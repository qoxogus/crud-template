package com.crud.template.helper;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class ObjectHelper {

    public static void throwExceptionIfEmpty(Object object) {
        if (ObjectHelper.isEmpty(object)) {
            throw new IllegalArgumentException("object is empty");
        }
    }

    /**
     * ObjectHelper.isEmpty(null)             = true <br>
     * ObjectHelper.isEmpty("")               = true <br>
     * ObjectHelper.isEmpty("ab")             = false <br>
     * ObjectHelper.isEmpty(new int[]{})      = true <br>
     * ObjectHelper.isEmpty(new int[]{1,2,3}) = false <br>
     * ObjectHelper.isEmpty(1234)             = false (WARNING) <br>
     *
     * *모든 케이스에 대응되진 않음
     *
     * @auhor 배태현
     */
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }

        if (object instanceof CharSequence) {
            return ((CharSequence) object).length() == 0;
        }

        if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        }

        if (object instanceof Collection<?>) {
            return ((Collection<?>) object).isEmpty();
        }

        if (object instanceof Map<?, ?>) {
            return ((Map<?, ?>) object).isEmpty();
        }

        if(object instanceof Optional) {
            return ((Optional<?>) object).isEmpty();
        }

        return false;
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }
}

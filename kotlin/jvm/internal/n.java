package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.TypeCastException;
@kotlin.h
/* loaded from: classes20.dex */
public final class n {
    private static final Object[] osT = new Object[0];

    public static final Object[] r(Collection<?> collection) {
        Object[] objArr;
        q.m(collection, "collection");
        int size = collection.size();
        if (size == 0) {
            return osT;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return osT;
        }
        Object[] objArr2 = new Object[size];
        int i = 0;
        Object[] objArr3 = objArr2;
        while (true) {
            int i2 = i + 1;
            objArr3[i] = it.next();
            if (i2 >= objArr3.length) {
                if (!it.hasNext()) {
                    return objArr3;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    if (i2 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    i3 = 2147483645;
                }
                objArr = Arrays.copyOf(objArr3, i3);
                q.l((Object) objArr, "Arrays.copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                Object[] copyOf = Arrays.copyOf(objArr3, i2);
                q.l((Object) copyOf, "Arrays.copyOf(result, size)");
                return copyOf;
            } else {
                objArr = objArr3;
            }
            objArr3 = objArr;
            i = i2;
        }
    }

    public static final Object[] a(Collection<?> collection, Object[] objArr) {
        Object[] objArr2;
        int i = 0;
        q.m(collection, "collection");
        if (objArr == null) {
            throw new NullPointerException();
        }
        int size = collection.size();
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            if (newInstance == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i2 = i + 1;
            objArr2[i] = it.next();
            if (i2 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    if (i2 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    i3 = 2147483645;
                }
                objArr2 = Arrays.copyOf(objArr2, i3);
                q.l((Object) objArr2, "Arrays.copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i2] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i2);
                q.l((Object) copyOf, "Arrays.copyOf(result, size)");
                return copyOf;
            }
            i = i2;
        }
    }
}

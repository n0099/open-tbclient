package d.g.c.c;

import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes6.dex */
public final class j0 {
    public static Object a(Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i2);
    }

    public static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    public static Object[] c(Object[] objArr, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            a(objArr[i3], i3);
        }
        return objArr;
    }

    public static Object[] d(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            objArr[i2] = it.next();
            i2++;
        }
        return objArr;
    }

    public static <T> T[] e(T[] tArr, int i2) {
        return (T[]) n0.b(tArr, i2);
    }

    public static Object[] f(Collection<?> collection) {
        Object[] objArr = new Object[collection.size()];
        d(collection, objArr);
        return objArr;
    }

    public static <T> T[] g(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) e(tArr, size);
        }
        d(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    public static <T> T[] h(Object[] objArr, int i2, int i3, T[] tArr) {
        d.g.c.a.n.v(i2, i2 + i3, objArr.length);
        if (tArr.length < i3) {
            tArr = (T[]) e(tArr, i3);
        } else if (tArr.length > i3) {
            tArr[i3] = null;
        }
        System.arraycopy(objArr, i2, tArr, 0, i3);
        return tArr;
    }
}

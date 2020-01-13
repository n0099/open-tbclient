package io.reactivex.internal.functions;

import io.reactivex.c.d;
/* loaded from: classes5.dex */
public final class a {
    static final d<Object, Object> nvA = new C0753a();

    public static <T> T h(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int ad(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static int bk(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(str + " > 0 required but it was " + i);
        }
        return i;
    }

    public static long x(long j, String str) {
        if (j <= 0) {
            throw new IllegalArgumentException(str + " > 0 required but it was " + j);
        }
        return j;
    }

    /* renamed from: io.reactivex.internal.functions.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C0753a implements d<Object, Object> {
        C0753a() {
        }

        @Override // io.reactivex.c.d
        public boolean k(Object obj, Object obj2) {
            return a.equals(obj, obj2);
        }
    }
}

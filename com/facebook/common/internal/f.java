package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public final class f {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int L(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aC(Object obj) {
        return new a(u(obj.getClass()));
    }

    private static String u(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private final String className;
        private C0443a jZg;
        private C0443a jZh;
        private boolean jZi;

        private a(String str) {
            this.jZg = new C0443a();
            this.jZh = this.jZg;
            this.jZi = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a t(String str, @Nullable Object obj) {
            return u(str, obj);
        }

        public a aE(String str, boolean z) {
            return u(str, String.valueOf(z));
        }

        public a bw(String str, int i) {
            return u(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.jZi;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0443a c0443a = this.jZg.jZj; c0443a != null; c0443a = c0443a.jZj) {
                if (!z || c0443a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0443a.name != null) {
                        append.append(c0443a.name).append('=');
                    }
                    append.append(c0443a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0443a cEC() {
            C0443a c0443a = new C0443a();
            this.jZh.jZj = c0443a;
            this.jZh = c0443a;
            return c0443a;
        }

        private a u(String str, @Nullable Object obj) {
            C0443a cEC = cEC();
            cEC.value = obj;
            cEC.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0443a {
            C0443a jZj;
            String name;
            Object value;

            private C0443a() {
            }
        }
    }
}

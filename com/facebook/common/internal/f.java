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
        private C0449a kam;
        private C0449a kan;
        private boolean kao;

        private a(String str) {
            this.kam = new C0449a();
            this.kan = this.kam;
            this.kao = false;
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
            boolean z = this.kao;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0449a c0449a = this.kam.kap; c0449a != null; c0449a = c0449a.kap) {
                if (!z || c0449a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0449a.name != null) {
                        append.append(c0449a.name).append('=');
                    }
                    append.append(c0449a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0449a cEX() {
            C0449a c0449a = new C0449a();
            this.kan.kap = c0449a;
            this.kan = c0449a;
            return c0449a;
        }

        private a u(String str, @Nullable Object obj) {
            C0449a cEX = cEX();
            cEX.value = obj;
            cEX.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0449a {
            C0449a kap;
            String name;
            Object value;

            private C0449a() {
            }
        }
    }
}

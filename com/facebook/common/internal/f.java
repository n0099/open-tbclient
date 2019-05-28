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

    public static int hashCode(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aC(Object obj) {
        return new a(s(obj.getClass()));
    }

    private static String s(Class<?> cls) {
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
        private C0444a jRZ;
        private C0444a jSa;
        private boolean jSb;

        private a(String str) {
            this.jRZ = new C0444a();
            this.jSa = this.jRZ;
            this.jSb = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a t(String str, @Nullable Object obj) {
            return u(str, obj);
        }

        public a aA(String str, boolean z) {
            return u(str, String.valueOf(z));
        }

        public a bv(String str, int i) {
            return u(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.jSb;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0444a c0444a = this.jRZ.jSc; c0444a != null; c0444a = c0444a.jSc) {
                if (!z || c0444a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0444a.name != null) {
                        append.append(c0444a.name).append('=');
                    }
                    append.append(c0444a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0444a cBC() {
            C0444a c0444a = new C0444a();
            this.jSa.jSc = c0444a;
            this.jSa = c0444a;
            return c0444a;
        }

        private a u(String str, @Nullable Object obj) {
            C0444a cBC = cBC();
            cBC.value = obj;
            cBC.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0444a {
            C0444a jSc;
            String name;
            Object value;

            private C0444a() {
            }
        }
    }
}

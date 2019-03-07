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

    public static a aD(Object obj) {
        return new a(t(obj.getClass()));
    }

    private static String t(Class<?> cls) {
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
        private C0329a jzC;
        private C0329a jzD;
        private boolean jzE;

        private a(String str) {
            this.jzC = new C0329a();
            this.jzD = this.jzC;
            this.jzE = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a q(String str, @Nullable Object obj) {
            return r(str, obj);
        }

        public a ax(String str, boolean z) {
            return r(str, String.valueOf(z));
        }

        public a bz(String str, int i) {
            return r(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.jzE;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0329a c0329a = this.jzC.jzF; c0329a != null; c0329a = c0329a.jzF) {
                if (!z || c0329a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0329a.name != null) {
                        append.append(c0329a.name).append('=');
                    }
                    append.append(c0329a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0329a ctx() {
            C0329a c0329a = new C0329a();
            this.jzD.jzF = c0329a;
            this.jzD = c0329a;
            return c0329a;
        }

        private a r(String str, @Nullable Object obj) {
            C0329a ctx = ctx();
            ctx.value = obj;
            ctx.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0329a {
            C0329a jzF;
            String name;
            Object value;

            private C0329a() {
            }
        }
    }
}

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
        private C0460a kcJ;
        private C0460a kcK;
        private boolean kcL;

        private a(String str) {
            this.kcJ = new C0460a();
            this.kcK = this.kcJ;
            this.kcL = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a t(String str, @Nullable Object obj) {
            return u(str, obj);
        }

        public a aE(String str, boolean z) {
            return u(str, String.valueOf(z));
        }

        public a by(String str, int i) {
            return u(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.kcL;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0460a c0460a = this.kcJ.kcM; c0460a != null; c0460a = c0460a.kcM) {
                if (!z || c0460a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0460a.name != null) {
                        append.append(c0460a.name).append('=');
                    }
                    append.append(c0460a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0460a cFL() {
            C0460a c0460a = new C0460a();
            this.kcK.kcM = c0460a;
            this.kcK = c0460a;
            return c0460a;
        }

        private a u(String str, @Nullable Object obj) {
            C0460a cFL = cFL();
            cFL.value = obj;
            cFL.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0460a {
            C0460a kcM;
            String name;
            Object value;

            private C0460a() {
            }
        }
    }
}

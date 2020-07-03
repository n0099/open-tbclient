package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public final class f {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int N(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aO(Object obj) {
        return new a(z(obj.getClass()));
    }

    private static String z(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }

    /* loaded from: classes13.dex */
    public static final class a {
        private final String className;
        private C0793a mIC;
        private C0793a mIE;
        private boolean mIF;

        private a(String str) {
            this.mIC = new C0793a();
            this.mIE = this.mIC;
            this.mIF = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a F(String str, @Nullable Object obj) {
            return G(str, obj);
        }

        public a aZ(String str, boolean z) {
            return G(str, String.valueOf(z));
        }

        public a bM(String str, int i) {
            return G(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.mIF;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0793a c0793a = this.mIC.mIG; c0793a != null; c0793a = c0793a.mIG) {
                if (!z || c0793a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0793a.name != null) {
                        append.append(c0793a.name).append('=');
                    }
                    append.append(c0793a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0793a dzf() {
            C0793a c0793a = new C0793a();
            this.mIE.mIG = c0793a;
            this.mIE = c0793a;
            return c0793a;
        }

        private a G(String str, @Nullable Object obj) {
            C0793a dzf = dzf();
            dzf.value = obj;
            dzf.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C0793a {
            C0793a mIG;
            @Nullable
            String name;
            @Nullable
            Object value;

            private C0793a() {
            }
        }
    }
}

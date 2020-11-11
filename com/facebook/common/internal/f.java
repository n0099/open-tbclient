package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public final class f {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int M(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aZ(Object obj) {
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

    /* loaded from: classes6.dex */
    public static final class a {
        private final String className;
        private C0967a oLc;
        private C0967a oLd;
        private boolean oLe;

        private a(String str) {
            this.oLc = new C0967a();
            this.oLd = this.oLc;
            this.oLe = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a F(String str, @Nullable Object obj) {
            return G(str, obj);
        }

        public a bn(String str, boolean z) {
            return G(str, String.valueOf(z));
        }

        public a bW(String str, int i) {
            return G(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.oLe;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0967a c0967a = this.oLc.oLf; c0967a != null; c0967a = c0967a.oLf) {
                if (!z || c0967a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0967a.name != null) {
                        append.append(c0967a.name).append('=');
                    }
                    append.append(c0967a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0967a ekb() {
            C0967a c0967a = new C0967a();
            this.oLd.oLf = c0967a;
            this.oLd = c0967a;
            return c0967a;
        }

        private a G(String str, @Nullable Object obj) {
            C0967a ekb = ekb();
            ekb.value = obj;
            ekb.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0967a {
            @Nullable
            String name;
            C0967a oLf;
            @Nullable
            Object value;

            private C0967a() {
            }
        }
    }
}

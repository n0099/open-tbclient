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

    public static int Q(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a bb(Object obj) {
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

    /* loaded from: classes6.dex */
    public static final class a {
        private final String className;
        private C1043a pzm;
        private C1043a pzn;
        private boolean pzo;

        private a(String str) {
            this.pzm = new C1043a();
            this.pzn = this.pzm;
            this.pzo = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a H(String str, @Nullable Object obj) {
            return I(str, obj);
        }

        public a bo(String str, boolean z) {
            return I(str, String.valueOf(z));
        }

        public a cl(String str, int i) {
            return I(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.pzo;
            String str = "";
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            for (C1043a c1043a = this.pzm.pzp; c1043a != null; c1043a = c1043a.pzp) {
                if (!z || c1043a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c1043a.name != null) {
                        append.append(c1043a.name).append('=');
                    }
                    append.append(c1043a.value);
                }
            }
            return append.append('}').toString();
        }

        private C1043a esF() {
            C1043a c1043a = new C1043a();
            this.pzn.pzp = c1043a;
            this.pzn = c1043a;
            return c1043a;
        }

        private a I(String str, @Nullable Object obj) {
            C1043a esF = esF();
            esF.value = obj;
            esF.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1043a {
            @Nullable
            String name;
            C1043a pzp;
            @Nullable
            Object value;

            private C1043a() {
            }
        }
    }
}

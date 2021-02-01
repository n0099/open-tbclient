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
        private C1041a pyM;
        private C1041a pyN;
        private boolean pyO;

        private a(String str) {
            this.pyM = new C1041a();
            this.pyN = this.pyM;
            this.pyO = false;
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
            boolean z = this.pyO;
            String str = "";
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            for (C1041a c1041a = this.pyM.pyP; c1041a != null; c1041a = c1041a.pyP) {
                if (!z || c1041a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c1041a.name != null) {
                        append.append(c1041a.name).append('=');
                    }
                    append.append(c1041a.value);
                }
            }
            return append.append('}').toString();
        }

        private C1041a esx() {
            C1041a c1041a = new C1041a();
            this.pyN.pyP = c1041a;
            this.pyN = c1041a;
            return c1041a;
        }

        private a I(String str, @Nullable Object obj) {
            C1041a esx = esx();
            esx.value = obj;
            esx.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1041a {
            @Nullable
            String name;
            C1041a pyP;
            @Nullable
            Object value;

            private C1041a() {
            }
        }
    }
}

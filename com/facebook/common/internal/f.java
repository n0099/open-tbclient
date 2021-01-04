package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static final class a {
        private final String className;
        private C1016a psV;
        private C1016a psW;
        private boolean psX;

        private a(String str) {
            this.psV = new C1016a();
            this.psW = this.psV;
            this.psX = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a I(String str, @Nullable Object obj) {
            return J(str, obj);
        }

        public a bo(String str, boolean z) {
            return J(str, String.valueOf(z));
        }

        public a cj(String str, int i) {
            return J(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.psX;
            String str = "";
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            for (C1016a c1016a = this.psV.psY; c1016a != null; c1016a = c1016a.psY) {
                if (!z || c1016a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c1016a.name != null) {
                        append.append(c1016a.name).append('=');
                    }
                    append.append(c1016a.value);
                }
            }
            return append.append('}').toString();
        }

        private C1016a etS() {
            C1016a c1016a = new C1016a();
            this.psW.psY = c1016a;
            this.psW = c1016a;
            return c1016a;
        }

        private a J(String str, @Nullable Object obj) {
            C1016a etS = etS();
            etS.value = obj;
            etS.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C1016a {
            @Nullable
            String name;
            C1016a psY;
            @Nullable
            Object value;

            private C1016a() {
            }
        }
    }
}

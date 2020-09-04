package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public final class f {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int M(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aQ(Object obj) {
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

    /* loaded from: classes9.dex */
    public static final class a {
        private final String className;
        private C0861a nkX;
        private C0861a nkY;
        private boolean nkZ;

        private a(String str) {
            this.nkX = new C0861a();
            this.nkY = this.nkX;
            this.nkZ = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a E(String str, @Nullable Object obj) {
            return F(str, obj);
        }

        public a ba(String str, boolean z) {
            return F(str, String.valueOf(z));
        }

        public a bP(String str, int i) {
            return F(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.nkZ;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0861a c0861a = this.nkX.nla; c0861a != null; c0861a = c0861a.nla) {
                if (!z || c0861a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0861a.name != null) {
                        append.append(c0861a.name).append('=');
                    }
                    append.append(c0861a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0861a dOF() {
            C0861a c0861a = new C0861a();
            this.nkY.nla = c0861a;
            this.nkY = c0861a;
            return c0861a;
        }

        private a F(String str, @Nullable Object obj) {
            C0861a dOF = dOF();
            dOF.value = obj;
            dOF.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C0861a {
            @Nullable
            String name;
            C0861a nla;
            @Nullable
            Object value;

            private C0861a() {
            }
        }
    }
}

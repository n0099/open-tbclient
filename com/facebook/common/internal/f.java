package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes17.dex */
public final class f {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int M(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aS(Object obj) {
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

    /* loaded from: classes17.dex */
    public static final class a {
        private final String className;
        private C0858a nuX;
        private C0858a nuY;
        private boolean nuZ;

        private a(String str) {
            this.nuX = new C0858a();
            this.nuY = this.nuX;
            this.nuZ = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a E(String str, @Nullable Object obj) {
            return F(str, obj);
        }

        public a bb(String str, boolean z) {
            return F(str, String.valueOf(z));
        }

        public a bP(String str, int i) {
            return F(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.nuZ;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0858a c0858a = this.nuX.nva; c0858a != null; c0858a = c0858a.nva) {
                if (!z || c0858a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0858a.name != null) {
                        append.append(c0858a.name).append('=');
                    }
                    append.append(c0858a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0858a dSD() {
            C0858a c0858a = new C0858a();
            this.nuY.nva = c0858a;
            this.nuY = c0858a;
            return c0858a;
        }

        private a F(String str, @Nullable Object obj) {
            C0858a dSD = dSD();
            dSD.value = obj;
            dSD.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public static final class C0858a {
            @Nullable
            String name;
            C0858a nva;
            @Nullable
            Object value;

            private C0858a() {
            }
        }
    }
}

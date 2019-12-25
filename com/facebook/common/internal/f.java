package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public final class f {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int J(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aQ(Object obj) {
        return new a(B(obj.getClass()));
    }

    private static String B(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }

    /* loaded from: classes11.dex */
    public static final class a {
        private final String className;
        private C0640a lEa;
        private C0640a lEb;
        private boolean lEc;

        private a(String str) {
            this.lEa = new C0640a();
            this.lEb = this.lEa;
            this.lEc = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a x(String str, @Nullable Object obj) {
            return y(str, obj);
        }

        public a aK(String str, boolean z) {
            return y(str, String.valueOf(z));
        }

        public a bH(String str, int i) {
            return y(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.lEc;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0640a c0640a = this.lEa.lEd; c0640a != null; c0640a = c0640a.lEd) {
                if (!z || c0640a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0640a.name != null) {
                        append.append(c0640a.name).append('=');
                    }
                    append.append(c0640a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0640a dio() {
            C0640a c0640a = new C0640a();
            this.lEb.lEd = c0640a;
            this.lEb = c0640a;
            return c0640a;
        }

        private a y(String str, @Nullable Object obj) {
            C0640a dio = dio();
            dio.value = obj;
            dio.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static final class C0640a {
            C0640a lEd;
            @Nullable
            String name;
            @Nullable
            Object value;

            private C0640a() {
            }
        }
    }
}

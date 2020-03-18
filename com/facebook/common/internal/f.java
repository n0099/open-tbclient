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

    public static int K(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aS(Object obj) {
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

    /* loaded from: classes13.dex */
    public static final class a {
        private final String className;
        private C0654a lKd;
        private C0654a lKe;
        private boolean lKf;

        private a(String str) {
            this.lKd = new C0654a();
            this.lKe = this.lKd;
            this.lKf = false;
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
            boolean z = this.lKf;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0654a c0654a = this.lKd.lKg; c0654a != null; c0654a = c0654a.lKg) {
                if (!z || c0654a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0654a.name != null) {
                        append.append(c0654a.name).append('=');
                    }
                    append.append(c0654a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0654a dle() {
            C0654a c0654a = new C0654a();
            this.lKe.lKg = c0654a;
            this.lKe = c0654a;
            return c0654a;
        }

        private a y(String str, @Nullable Object obj) {
            C0654a dle = dle();
            dle.value = obj;
            dle.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C0654a {
            C0654a lKg;
            @Nullable
            String name;
            @Nullable
            Object value;

            private C0654a() {
            }
        }
    }
}

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

    public static a aN(Object obj) {
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
        private C0773a mlt;
        private C0773a mlu;
        private boolean mlv;

        private a(String str) {
            this.mlt = new C0773a();
            this.mlu = this.mlt;
            this.mlv = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a F(String str, @Nullable Object obj) {
            return G(str, obj);
        }

        public a aX(String str, boolean z) {
            return G(str, String.valueOf(z));
        }

        public a bN(String str, int i) {
            return G(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.mlv;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0773a c0773a = this.mlt.mlw; c0773a != null; c0773a = c0773a.mlw) {
                if (!z || c0773a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0773a.name != null) {
                        append.append(c0773a.name).append('=');
                    }
                    append.append(c0773a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0773a duo() {
            C0773a c0773a = new C0773a();
            this.mlu.mlw = c0773a;
            this.mlu = c0773a;
            return c0773a;
        }

        private a G(String str, @Nullable Object obj) {
            C0773a duo = duo();
            duo.value = obj;
            duo.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C0773a {
            C0773a mlw;
            @Nullable
            String name;
            @Nullable
            Object value;

            private C0773a() {
            }
        }
    }
}

package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
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

    /* loaded from: classes14.dex */
    public static final class a {
        private final String className;
        private C1037a poB;
        private C1037a poC;
        private boolean poD;

        private a(String str) {
            this.poB = new C1037a();
            this.poC = this.poB;
            this.poD = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a I(String str, @Nullable Object obj) {
            return J(str, obj);
        }

        public a bo(String str, boolean z) {
            return J(str, String.valueOf(z));
        }

        public a ck(String str, int i) {
            return J(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.poD;
            String str = "";
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            for (C1037a c1037a = this.poB.poE; c1037a != null; c1037a = c1037a.poE) {
                if (!z || c1037a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c1037a.name != null) {
                        append.append(c1037a.name).append('=');
                    }
                    append.append(c1037a.value);
                }
            }
            return append.append('}').toString();
        }

        private C1037a eqe() {
            C1037a c1037a = new C1037a();
            this.poC.poE = c1037a;
            this.poC = c1037a;
            return c1037a;
        }

        private a J(String str, @Nullable Object obj) {
            C1037a eqe = eqe();
            eqe.value = obj;
            eqe.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C1037a {
            @Nullable
            String name;
            C1037a poE;
            @Nullable
            Object value;

            private C1037a() {
            }
        }
    }
}

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

    public static int M(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aJ(Object obj) {
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
        private C0718a lRB;
        private C0718a lRC;
        private boolean lRD;

        private a(String str) {
            this.lRB = new C0718a();
            this.lRC = this.lRB;
            this.lRD = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a C(String str, @Nullable Object obj) {
            return D(str, obj);
        }

        public a aK(String str, boolean z) {
            return D(str, String.valueOf(z));
        }

        public a bM(String str, int i) {
            return D(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.lRD;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0718a c0718a = this.lRB.lRE; c0718a != null; c0718a = c0718a.lRE) {
                if (!z || c0718a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0718a.name != null) {
                        append.append(c0718a.name).append('=');
                    }
                    append.append(c0718a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0718a dmV() {
            C0718a c0718a = new C0718a();
            this.lRC.lRE = c0718a;
            this.lRC = c0718a;
            return c0718a;
        }

        private a D(String str, @Nullable Object obj) {
            C0718a dmV = dmV();
            dmV.value = obj;
            dmV.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C0718a {
            C0718a lRE;
            @Nullable
            String name;
            @Nullable
            Object value;

            private C0718a() {
            }
        }
    }
}

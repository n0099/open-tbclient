package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public final class f {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int P(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a bd(Object obj) {
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

    /* loaded from: classes4.dex */
    public static final class a {
        private final String className;
        private C1058a pBr;
        private C1058a pBs;
        private boolean pBt;

        private a(String str) {
            this.pBr = new C1058a();
            this.pBs = this.pBr;
            this.pBt = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a G(String str, @Nullable Object obj) {
            return H(str, obj);
        }

        public a bo(String str, boolean z) {
            return H(str, String.valueOf(z));
        }

        public a cl(String str, int i) {
            return H(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.pBt;
            String str = "";
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            for (C1058a c1058a = this.pBr.pBu; c1058a != null; c1058a = c1058a.pBu) {
                if (!z || c1058a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c1058a.name != null) {
                        append.append(c1058a.name).append('=');
                    }
                    append.append(c1058a.value);
                }
            }
            return append.append('}').toString();
        }

        private C1058a esO() {
            C1058a c1058a = new C1058a();
            this.pBs.pBu = c1058a;
            this.pBs = c1058a;
            return c1058a;
        }

        private a H(String str, @Nullable Object obj) {
            C1058a esO = esO();
            esO.value = obj;
            esO.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1058a {
            @Nullable
            String name;
            C1058a pBu;
            @Nullable
            Object value;

            private C1058a() {
            }
        }
    }
}

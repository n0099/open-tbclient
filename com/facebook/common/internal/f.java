package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes19.dex */
public final class f {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int M(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a ba(Object obj) {
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

    /* loaded from: classes19.dex */
    public static final class a {
        private final String className;
        private C0987a pbQ;
        private C0987a pbR;
        private boolean pbS;

        private a(String str) {
            this.pbQ = new C0987a();
            this.pbR = this.pbQ;
            this.pbS = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a E(String str, @Nullable Object obj) {
            return F(str, obj);
        }

        public a bo(String str, boolean z) {
            return F(str, String.valueOf(z));
        }

        public a ca(String str, int i) {
            return F(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.pbS;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0987a c0987a = this.pbQ.pbT; c0987a != null; c0987a = c0987a.pbT) {
                if (!z || c0987a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0987a.name != null) {
                        append.append(c0987a.name).append('=');
                    }
                    append.append(c0987a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0987a epP() {
            C0987a c0987a = new C0987a();
            this.pbR.pbT = c0987a;
            this.pbR = c0987a;
            return c0987a;
        }

        private a F(String str, @Nullable Object obj) {
            C0987a epP = epP();
            epP.value = obj;
            epP.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public static final class C0987a {
            @Nullable
            String name;
            C0987a pbT;
            @Nullable
            Object value;

            private C0987a() {
            }
        }
    }
}

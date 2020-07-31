package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public final class f {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int N(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aO(Object obj) {
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

    /* loaded from: classes12.dex */
    public static final class a {
        private final String className;
        private C0803a mQI;
        private C0803a mQJ;
        private boolean mQK;

        private a(String str) {
            this.mQI = new C0803a();
            this.mQJ = this.mQI;
            this.mQK = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a F(String str, @Nullable Object obj) {
            return G(str, obj);
        }

        public a aW(String str, boolean z) {
            return G(str, String.valueOf(z));
        }

        public a bK(String str, int i) {
            return G(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.mQK;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0803a c0803a = this.mQI.mQL; c0803a != null; c0803a = c0803a.mQL) {
                if (!z || c0803a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0803a.name != null) {
                        append.append(c0803a.name).append('=');
                    }
                    append.append(c0803a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0803a dCv() {
            C0803a c0803a = new C0803a();
            this.mQJ.mQL = c0803a;
            this.mQJ = c0803a;
            return c0803a;
        }

        private a G(String str, @Nullable Object obj) {
            C0803a dCv = dCv();
            dCv.value = obj;
            dCv.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C0803a {
            C0803a mQL;
            @Nullable
            String name;
            @Nullable
            Object value;

            private C0803a() {
            }
        }
    }
}

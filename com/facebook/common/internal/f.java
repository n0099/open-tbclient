package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public final class f {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aE(Object obj) {
        return new a(t(obj.getClass()));
    }

    private static String t(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private final String className;
        private C0425a jzN;
        private C0425a jzO;
        private boolean jzP;

        private a(String str) {
            this.jzN = new C0425a();
            this.jzO = this.jzN;
            this.jzP = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a q(String str, @Nullable Object obj) {
            return r(str, obj);
        }

        public a ay(String str, boolean z) {
            return r(str, String.valueOf(z));
        }

        public a bz(String str, int i) {
            return r(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.jzP;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0425a c0425a = this.jzN.jzQ; c0425a != null; c0425a = c0425a.jzQ) {
                if (!z || c0425a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0425a.name != null) {
                        append.append(c0425a.name).append('=');
                    }
                    append.append(c0425a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0425a ctK() {
            C0425a c0425a = new C0425a();
            this.jzO.jzQ = c0425a;
            this.jzO = c0425a;
            return c0425a;
        }

        private a r(String str, @Nullable Object obj) {
            C0425a ctK = ctK();
            ctK.value = obj;
            ctK.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0425a {
            C0425a jzQ;
            String name;
            Object value;

            private C0425a() {
            }
        }
    }
}

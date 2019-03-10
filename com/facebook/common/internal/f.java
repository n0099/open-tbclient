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
        private C0332a jzV;
        private C0332a jzW;
        private boolean jzX;

        private a(String str) {
            this.jzV = new C0332a();
            this.jzW = this.jzV;
            this.jzX = false;
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
            boolean z = this.jzX;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0332a c0332a = this.jzV.jzY; c0332a != null; c0332a = c0332a.jzY) {
                if (!z || c0332a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0332a.name != null) {
                        append.append(c0332a.name).append('=');
                    }
                    append.append(c0332a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0332a ctH() {
            C0332a c0332a = new C0332a();
            this.jzW.jzY = c0332a;
            this.jzW = c0332a;
            return c0332a;
        }

        private a r(String str, @Nullable Object obj) {
            C0332a ctH = ctH();
            ctH.value = obj;
            ctH.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0332a {
            C0332a jzY;
            String name;
            Object value;

            private C0332a() {
            }
        }
    }
}

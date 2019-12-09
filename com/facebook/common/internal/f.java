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

    public static int I(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a ax(Object obj) {
        return new a(r(obj.getClass()));
    }

    private static String r(Class<?> cls) {
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
        private C0550a kab;
        private C0550a kac;
        private boolean kad;

        private a(String str) {
            this.kab = new C0550a();
            this.kac = this.kab;
            this.kad = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a q(String str, @Nullable Object obj) {
            return r(str, obj);
        }

        public a az(String str, boolean z) {
            return r(str, String.valueOf(z));
        }

        public a bt(String str, int i) {
            return r(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.kad;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0550a c0550a = this.kab.kae; c0550a != null; c0550a = c0550a.kae) {
                if (!z || c0550a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0550a.name != null) {
                        append.append(c0550a.name).append('=');
                    }
                    append.append(c0550a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0550a cCH() {
            C0550a c0550a = new C0550a();
            this.kac.kae = c0550a;
            this.kac = c0550a;
            return c0550a;
        }

        private a r(String str, @Nullable Object obj) {
            C0550a cCH = cCH();
            cCH.value = obj;
            cCH.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0550a {
            C0550a kae;
            String name;
            Object value;

            private C0550a() {
            }
        }
    }
}

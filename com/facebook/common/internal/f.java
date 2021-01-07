package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static final class a {
        private final String className;
        private C1054a ptc;
        private C1054a ptd;
        private boolean pte;

        private a(String str) {
            this.ptc = new C1054a();
            this.ptd = this.ptc;
            this.pte = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a I(String str, @Nullable Object obj) {
            return J(str, obj);
        }

        public a bo(String str, boolean z) {
            return J(str, String.valueOf(z));
        }

        public a cj(String str, int i) {
            return J(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.pte;
            String str = "";
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            for (C1054a c1054a = this.ptc.ptf; c1054a != null; c1054a = c1054a.ptf) {
                if (!z || c1054a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c1054a.name != null) {
                        append.append(c1054a.name).append('=');
                    }
                    append.append(c1054a.value);
                }
            }
            return append.append('}').toString();
        }

        private C1054a etY() {
            C1054a c1054a = new C1054a();
            this.ptd.ptf = c1054a;
            this.ptd = c1054a;
            return c1054a;
        }

        private a J(String str, @Nullable Object obj) {
            C1054a etY = etY();
            etY.value = obj;
            etY.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C1054a {
            @Nullable
            String name;
            C1054a ptf;
            @Nullable
            Object value;

            private C1054a() {
            }
        }
    }
}

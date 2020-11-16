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

    /* loaded from: classes12.dex */
    public static final class a {
        private final String className;
        private C0970a oMG;
        private C0970a oMH;
        private boolean oMI;

        private a(String str) {
            this.oMG = new C0970a();
            this.oMH = this.oMG;
            this.oMI = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a F(String str, @Nullable Object obj) {
            return G(str, obj);
        }

        public a bn(String str, boolean z) {
            return G(str, String.valueOf(z));
        }

        public a bV(String str, int i) {
            return G(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.oMI;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0970a c0970a = this.oMG.oMJ; c0970a != null; c0970a = c0970a.oMJ) {
                if (!z || c0970a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0970a.name != null) {
                        append.append(c0970a.name).append('=');
                    }
                    append.append(c0970a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0970a ejZ() {
            C0970a c0970a = new C0970a();
            this.oMH.oMJ = c0970a;
            this.oMH = c0970a;
            return c0970a;
        }

        private a G(String str, @Nullable Object obj) {
            C0970a ejZ = ejZ();
            ejZ.value = obj;
            ejZ.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C0970a {
            @Nullable
            String name;
            C0970a oMJ;
            @Nullable
            Object value;

            private C0970a() {
            }
        }
    }
}

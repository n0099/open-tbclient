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

    public static a aI(Object obj) {
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
        private C0697a lRx;
        private C0697a lRy;
        private boolean lRz;

        private a(String str) {
            this.lRx = new C0697a();
            this.lRy = this.lRx;
            this.lRz = false;
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
            boolean z = this.lRz;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0697a c0697a = this.lRx.lRA; c0697a != null; c0697a = c0697a.lRA) {
                if (!z || c0697a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0697a.name != null) {
                        append.append(c0697a.name).append('=');
                    }
                    append.append(c0697a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0697a dmX() {
            C0697a c0697a = new C0697a();
            this.lRy.lRA = c0697a;
            this.lRy = c0697a;
            return c0697a;
        }

        private a D(String str, @Nullable Object obj) {
            C0697a dmX = dmX();
            dmX.value = obj;
            dmX.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C0697a {
            C0697a lRA;
            @Nullable
            String name;
            @Nullable
            Object value;

            private C0697a() {
            }
        }
    }
}

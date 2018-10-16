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

    public static a ao(Object obj) {
        return new a(q(obj.getClass()));
    }

    private static String q(Class<?> cls) {
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
        private C0312a hWK;
        private C0312a hWL;
        private boolean hWM;

        private a(String str) {
            this.hWK = new C0312a();
            this.hWL = this.hWK;
            this.hWM = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a n(String str, @Nullable Object obj) {
            return o(str, obj);
        }

        public a ag(String str, boolean z) {
            return o(str, String.valueOf(z));
        }

        public a be(String str, int i) {
            return o(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.hWM;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0312a c0312a = this.hWK.hWN; c0312a != null; c0312a = c0312a.hWN) {
                if (!z || c0312a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0312a.name != null) {
                        append.append(c0312a.name).append('=');
                    }
                    append.append(c0312a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0312a bRA() {
            C0312a c0312a = new C0312a();
            this.hWL.hWN = c0312a;
            this.hWL = c0312a;
            return c0312a;
        }

        private a o(String str, @Nullable Object obj) {
            C0312a bRA = bRA();
            bRA.value = obj;
            bRA.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0312a {
            C0312a hWN;
            String name;
            Object value;

            private C0312a() {
            }
        }
    }
}

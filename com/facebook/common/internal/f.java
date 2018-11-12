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

    public static a an(Object obj) {
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
        private C0340a hYv;
        private C0340a hYw;
        private boolean hYx;

        private a(String str) {
            this.hYv = new C0340a();
            this.hYw = this.hYv;
            this.hYx = false;
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
            boolean z = this.hYx;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0340a c0340a = this.hYv.hYy; c0340a != null; c0340a = c0340a.hYy) {
                if (!z || c0340a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0340a.name != null) {
                        append.append(c0340a.name).append('=');
                    }
                    append.append(c0340a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0340a bQV() {
            C0340a c0340a = new C0340a();
            this.hYw.hYy = c0340a;
            this.hYw = c0340a;
            return c0340a;
        }

        private a o(String str, @Nullable Object obj) {
            C0340a bQV = bQV();
            bQV.value = obj;
            bQV.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0340a {
            C0340a hYy;
            String name;
            Object value;

            private C0340a() {
            }
        }
    }
}

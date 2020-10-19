package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public final class f {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int M(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aV(Object obj) {
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

    /* loaded from: classes6.dex */
    public static final class a {
        private final String className;
        private C0876a nKq;
        private C0876a nKr;
        private boolean nKs;

        private a(String str) {
            this.nKq = new C0876a();
            this.nKr = this.nKq;
            this.nKs = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a F(String str, @Nullable Object obj) {
            return G(str, obj);
        }

        public a bf(String str, boolean z) {
            return G(str, String.valueOf(z));
        }

        public a bQ(String str, int i) {
            return G(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.nKs;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0876a c0876a = this.nKq.nKt; c0876a != null; c0876a = c0876a.nKt) {
                if (!z || c0876a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0876a.name != null) {
                        append.append(c0876a.name).append('=');
                    }
                    append.append(c0876a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0876a dWo() {
            C0876a c0876a = new C0876a();
            this.nKr.nKt = c0876a;
            this.nKr = c0876a;
            return c0876a;
        }

        private a G(String str, @Nullable Object obj) {
            C0876a dWo = dWo();
            dWo.value = obj;
            dWo.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0876a {
            C0876a nKt;
            @Nullable
            String name;
            @Nullable
            Object value;

            private C0876a() {
            }
        }
    }
}

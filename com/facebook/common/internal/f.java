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

    public static int N(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aN(Object obj) {
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
        private C0774a mmD;
        private C0774a mmE;
        private boolean mmF;

        private a(String str) {
            this.mmD = new C0774a();
            this.mmE = this.mmD;
            this.mmF = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a F(String str, @Nullable Object obj) {
            return G(str, obj);
        }

        public a aX(String str, boolean z) {
            return G(str, String.valueOf(z));
        }

        public a bN(String str, int i) {
            return G(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.mmF;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0774a c0774a = this.mmD.mmG; c0774a != null; c0774a = c0774a.mmG) {
                if (!z || c0774a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0774a.name != null) {
                        append.append(c0774a.name).append('=');
                    }
                    append.append(c0774a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0774a duC() {
            C0774a c0774a = new C0774a();
            this.mmE.mmG = c0774a;
            this.mmE = c0774a;
            return c0774a;
        }

        private a G(String str, @Nullable Object obj) {
            C0774a duC = duC();
            duC.value = obj;
            duC.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C0774a {
            C0774a mmG;
            @Nullable
            String name;
            @Nullable
            Object value;

            private C0774a() {
            }
        }
    }
}

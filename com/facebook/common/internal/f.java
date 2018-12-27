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
        private C0354a iiS;
        private C0354a iiT;
        private boolean iiU;

        private a(String str) {
            this.iiS = new C0354a();
            this.iiT = this.iiS;
            this.iiU = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a n(String str, @Nullable Object obj) {
            return o(str, obj);
        }

        public a ai(String str, boolean z) {
            return o(str, String.valueOf(z));
        }

        public a bg(String str, int i) {
            return o(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.iiU;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0354a c0354a = this.iiS.iiV; c0354a != null; c0354a = c0354a.iiV) {
                if (!z || c0354a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0354a.name != null) {
                        append.append(c0354a.name).append('=');
                    }
                    append.append(c0354a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0354a bTR() {
            C0354a c0354a = new C0354a();
            this.iiT.iiV = c0354a;
            this.iiT = c0354a;
            return c0354a;
        }

        private a o(String str, @Nullable Object obj) {
            C0354a bTR = bTR();
            bTR.value = obj;
            bTR.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0354a {
            C0354a iiV;
            String name;
            Object value;

            private C0354a() {
            }
        }
    }
}

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
        private C0353a ijZ;
        private C0353a ika;
        private boolean ikb;

        private a(String str) {
            this.ijZ = new C0353a();
            this.ika = this.ijZ;
            this.ikb = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a n(String str, @Nullable Object obj) {
            return o(str, obj);
        }

        public a ah(String str, boolean z) {
            return o(str, String.valueOf(z));
        }

        public a bg(String str, int i) {
            return o(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.ikb;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0353a c0353a = this.ijZ.ikc; c0353a != null; c0353a = c0353a.ikc) {
                if (!z || c0353a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0353a.name != null) {
                        append.append(c0353a.name).append('=');
                    }
                    append.append(c0353a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0353a bUz() {
            C0353a c0353a = new C0353a();
            this.ika.ikc = c0353a;
            this.ika = c0353a;
            return c0353a;
        }

        private a o(String str, @Nullable Object obj) {
            C0353a bUz = bUz();
            bUz.value = obj;
            bUz.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0353a {
            C0353a ikc;
            String name;
            Object value;

            private C0353a() {
            }
        }
    }
}

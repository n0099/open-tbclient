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

    public static a aZ(Object obj) {
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
        private C0948a oBJ;
        private C0948a oBK;
        private boolean oBL;

        private a(String str) {
            this.oBJ = new C0948a();
            this.oBK = this.oBJ;
            this.oBL = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a F(String str, @Nullable Object obj) {
            return G(str, obj);
        }

        public a bl(String str, boolean z) {
            return G(str, String.valueOf(z));
        }

        public a bU(String str, int i) {
            return G(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.oBL;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0948a c0948a = this.oBJ.oBM; c0948a != null; c0948a = c0948a.oBM) {
                if (!z || c0948a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0948a.name != null) {
                        append.append(c0948a.name).append('=');
                    }
                    append.append(c0948a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0948a egm() {
            C0948a c0948a = new C0948a();
            this.oBK.oBM = c0948a;
            this.oBK = c0948a;
            return c0948a;
        }

        private a G(String str, @Nullable Object obj) {
            C0948a egm = egm();
            egm.value = obj;
            egm.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0948a {
            @Nullable
            String name;
            C0948a oBM;
            @Nullable
            Object value;

            private C0948a() {
            }
        }
    }
}

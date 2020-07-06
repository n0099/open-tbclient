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

    public static a aO(Object obj) {
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
        private C0794a mIG;
        private C0794a mIH;
        private boolean mII;

        private a(String str) {
            this.mIG = new C0794a();
            this.mIH = this.mIG;
            this.mII = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a F(String str, @Nullable Object obj) {
            return G(str, obj);
        }

        public a aZ(String str, boolean z) {
            return G(str, String.valueOf(z));
        }

        public a bM(String str, int i) {
            return G(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.mII;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0794a c0794a = this.mIG.mIJ; c0794a != null; c0794a = c0794a.mIJ) {
                if (!z || c0794a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0794a.name != null) {
                        append.append(c0794a.name).append('=');
                    }
                    append.append(c0794a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0794a dzj() {
            C0794a c0794a = new C0794a();
            this.mIH.mIJ = c0794a;
            this.mIH = c0794a;
            return c0794a;
        }

        private a G(String str, @Nullable Object obj) {
            C0794a dzj = dzj();
            dzj.value = obj;
            dzj.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C0794a {
            C0794a mIJ;
            @Nullable
            String name;
            @Nullable
            Object value;

            private C0794a() {
            }
        }
    }
}

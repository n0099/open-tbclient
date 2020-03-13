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

    public static int J(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aS(Object obj) {
        return new a(B(obj.getClass()));
    }

    private static String B(Class<?> cls) {
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
        private C0653a lIx;
        private C0653a lIy;
        private boolean lIz;

        private a(String str) {
            this.lIx = new C0653a();
            this.lIy = this.lIx;
            this.lIz = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a x(String str, @Nullable Object obj) {
            return y(str, obj);
        }

        public a aK(String str, boolean z) {
            return y(str, String.valueOf(z));
        }

        public a bH(String str, int i) {
            return y(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.lIz;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0653a c0653a = this.lIx.lIA; c0653a != null; c0653a = c0653a.lIA) {
                if (!z || c0653a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0653a.name != null) {
                        append.append(c0653a.name).append('=');
                    }
                    append.append(c0653a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0653a dkH() {
            C0653a c0653a = new C0653a();
            this.lIy.lIA = c0653a;
            this.lIy = c0653a;
            return c0653a;
        }

        private a y(String str, @Nullable Object obj) {
            C0653a dkH = dkH();
            dkH.value = obj;
            dkH.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C0653a {
            C0653a lIA;
            @Nullable
            String name;
            @Nullable
            Object value;

            private C0653a() {
            }
        }
    }
}

package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public final class f {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int J(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a aQ(Object obj) {
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

    /* loaded from: classes12.dex */
    public static final class a {
        private final String className;
        private boolean lHA;
        private C0645a lHy;
        private C0645a lHz;

        private a(String str) {
            this.lHy = new C0645a();
            this.lHz = this.lHy;
            this.lHA = false;
            this.className = (String) g.checkNotNull(str);
        }

        public a x(String str, @Nullable Object obj) {
            return y(str, obj);
        }

        public a aK(String str, boolean z) {
            return y(str, String.valueOf(z));
        }

        public a bI(String str, int i) {
            return y(str, String.valueOf(i));
        }

        public String toString() {
            boolean z = this.lHA;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C0645a c0645a = this.lHy.lHB; c0645a != null; c0645a = c0645a.lHB) {
                if (!z || c0645a.value != null) {
                    append.append(str);
                    str = ", ";
                    if (c0645a.name != null) {
                        append.append(c0645a.name).append('=');
                    }
                    append.append(c0645a.value);
                }
            }
            return append.append('}').toString();
        }

        private C0645a djp() {
            C0645a c0645a = new C0645a();
            this.lHz.lHB = c0645a;
            this.lHz = c0645a;
            return c0645a;
        }

        private a y(String str, @Nullable Object obj) {
            C0645a djp = djp();
            djp.value = obj;
            djp.name = (String) g.checkNotNull(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C0645a {
            C0645a lHB;
            @Nullable
            String name;
            @Nullable
            Object value;

            private C0645a() {
            }
        }
    }
}

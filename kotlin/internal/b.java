package kotlin.internal;

import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
import kotlin.text.l;
/* loaded from: classes4.dex */
public final class b {
    public static final a mYT;

    static {
        a aVar;
        Object newInstance;
        Object newInstance2;
        int dEO = dEO();
        if (dEO >= 65544) {
            try {
                newInstance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
            } catch (ClassNotFoundException e) {
                try {
                    Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    if (newInstance3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) newInstance3;
                } catch (ClassNotFoundException e2) {
                }
            }
            if (newInstance == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            aVar = (a) newInstance;
            mYT = aVar;
        }
        if (dEO >= 65543) {
            try {
                newInstance2 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
            } catch (ClassNotFoundException e3) {
                try {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    if (newInstance4 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) newInstance4;
                } catch (ClassNotFoundException e4) {
                }
            }
            if (newInstance2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            aVar = (a) newInstance2;
            mYT = aVar;
        }
        aVar = new a();
        mYT = aVar;
    }

    private static final int dEO() {
        int i;
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int a = l.a((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (a < 0) {
            try {
                i = Integer.parseInt(property) * 65536;
            } catch (NumberFormatException e) {
                i = 65542;
            }
            return i;
        }
        int a2 = l.a((CharSequence) property, '.', a + 1, false, 4, (Object) null);
        if (a2 < 0) {
            a2 = property.length();
        }
        if (property == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = property.substring(0, a);
        p.i(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int i2 = a + 1;
        if (property == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring2 = property.substring(i2, a2);
        p.i(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
        } catch (NumberFormatException e2) {
            return 65542;
        }
    }
}

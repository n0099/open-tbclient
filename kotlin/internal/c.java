package kotlin.internal;

import kotlin.TypeCastException;
import kotlin.e;
import kotlin.jvm.internal.p;
import kotlin.text.l;
@e
/* loaded from: classes17.dex */
public final class c {
    public static final b pKt;

    static {
        b bVar;
        Object newInstance;
        Object newInstance2;
        int eDX = eDX();
        if (eDX >= 65544) {
            try {
                newInstance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
            } catch (ClassNotFoundException e) {
                try {
                    Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    if (newInstance3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    bVar = (b) newInstance3;
                } catch (ClassNotFoundException e2) {
                }
            }
            if (newInstance == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            bVar = (b) newInstance;
            pKt = bVar;
        }
        if (eDX >= 65543) {
            try {
                newInstance2 = Class.forName("kotlin.internal.a.a").newInstance();
            } catch (ClassNotFoundException e3) {
                try {
                    Object newInstance4 = Class.forName("kotlin.internal.a").newInstance();
                    if (newInstance4 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    bVar = (b) newInstance4;
                } catch (ClassNotFoundException e4) {
                }
            }
            if (newInstance2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            bVar = (b) newInstance2;
            pKt = bVar;
        }
        bVar = new b();
        pKt = bVar;
    }

    private static final int eDX() {
        int i;
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int a2 = l.a((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (a2 < 0) {
            try {
                i = Integer.parseInt(property) * 65536;
            } catch (NumberFormatException e) {
                i = 65542;
            }
            return i;
        }
        int a3 = l.a((CharSequence) property, '.', a2 + 1, false, 4, (Object) null);
        if (a3 < 0) {
            a3 = property.length();
        }
        if (property == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = property.substring(0, a2);
        p.n(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int i2 = a2 + 1;
        if (property == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring2 = property.substring(i2, a3);
        p.n(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
        } catch (NumberFormatException e2) {
            return 65542;
        }
    }
}

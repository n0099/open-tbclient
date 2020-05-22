package kotlin.internal;

import kotlin.TypeCastException;
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.text.l;
@h
/* loaded from: classes7.dex */
public final class b {
    public static final a nsG;

    static {
        a aVar;
        Object newInstance;
        Object newInstance2;
        int dLJ = dLJ();
        if (dLJ >= 65544) {
            try {
                newInstance = Class.forName("kotlin.internal.b.a").newInstance();
                q.l(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                } catch (ClassCastException e) {
                    ClassLoader classLoader = newInstance.getClass().getClassLoader();
                    Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + a.class.getClassLoader()).initCause(e);
                    q.l((Object) initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause;
                }
            } catch (ClassNotFoundException e2) {
                try {
                    Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    q.l(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        if (newInstance3 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (a) newInstance3;
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader2 = newInstance3.getClass().getClassLoader();
                        Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader2 + ", base type classloader: " + a.class.getClassLoader()).initCause(e3);
                        q.l((Object) initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause2;
                    }
                } catch (ClassNotFoundException e4) {
                }
            }
            if (newInstance == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            aVar = (a) newInstance;
            nsG = aVar;
        }
        if (dLJ >= 65543) {
            try {
                newInstance2 = Class.forName("kotlin.internal.a.a").newInstance();
                q.l(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
            } catch (ClassNotFoundException e5) {
                try {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    q.l(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        if (newInstance4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (a) newInstance4;
                    } catch (ClassCastException e6) {
                        ClassLoader classLoader3 = newInstance4.getClass().getClassLoader();
                        Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + a.class.getClassLoader()).initCause(e6);
                        q.l((Object) initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause3;
                    }
                } catch (ClassNotFoundException e7) {
                }
            }
            try {
                if (newInstance2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                aVar = (a) newInstance2;
                nsG = aVar;
            } catch (ClassCastException e8) {
                ClassLoader classLoader4 = newInstance2.getClass().getClassLoader();
                Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader4 + ", base type classloader: " + a.class.getClassLoader()).initCause(e8);
                q.l((Object) initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause4;
            }
        }
        aVar = new a();
        nsG = aVar;
    }

    private static final int dLJ() {
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
        q.l((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int i2 = a + 1;
        if (property == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring2 = property.substring(i2, a2);
        q.l((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
        } catch (NumberFormatException e2) {
            return 65542;
        }
    }
}

package kotlin.internal;

import kotlin.TypeCastException;
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.text.l;
@h
/* loaded from: classes10.dex */
public final class c {
    public static final b pSu;

    static {
        b bVar;
        Object newInstance;
        Object newInstance2;
        int eBM = eBM();
        if (eBM >= 65544) {
            try {
                newInstance = Class.forName("kotlin.internal.b.a").newInstance();
                q.m(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                } catch (ClassCastException e) {
                    ClassLoader classLoader = newInstance.getClass().getClassLoader();
                    Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + b.class.getClassLoader()).initCause(e);
                    q.m(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause;
                }
            } catch (ClassNotFoundException e2) {
                try {
                    Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    q.m(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        if (newInstance3 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        bVar = (b) newInstance3;
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader2 = newInstance3.getClass().getClassLoader();
                        Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader2 + ", base type classloader: " + b.class.getClassLoader()).initCause(e3);
                        q.m(initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause2;
                    }
                } catch (ClassNotFoundException e4) {
                }
            }
            if (newInstance == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            bVar = (b) newInstance;
            pSu = bVar;
        }
        if (eBM >= 65543) {
            try {
                newInstance2 = Class.forName("kotlin.internal.a.a").newInstance();
                q.m(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
            } catch (ClassNotFoundException e5) {
                try {
                    Object newInstance4 = Class.forName("kotlin.internal.a").newInstance();
                    q.m(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        if (newInstance4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        bVar = (b) newInstance4;
                    } catch (ClassCastException e6) {
                        ClassLoader classLoader3 = newInstance4.getClass().getClassLoader();
                        Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + b.class.getClassLoader()).initCause(e6);
                        q.m(initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause3;
                    }
                } catch (ClassNotFoundException e7) {
                }
            }
            try {
                if (newInstance2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                bVar = (b) newInstance2;
                pSu = bVar;
            } catch (ClassCastException e8) {
                ClassLoader classLoader4 = newInstance2.getClass().getClassLoader();
                Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader4 + ", base type classloader: " + b.class.getClassLoader()).initCause(e8);
                q.m(initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause4;
            }
        }
        bVar = new b();
        pSu = bVar;
    }

    private static final int eBM() {
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
        q.m(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int i2 = a2 + 1;
        if (property == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring2 = property.substring(i2, a3);
        q.m(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
        } catch (NumberFormatException e2) {
            return 65542;
        }
    }
}

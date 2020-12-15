package kotlin.jvm.internal;
/* loaded from: classes17.dex */
public class s {
    private static final t pKF;
    private static final kotlin.reflect.c[] pKG;

    static {
        t tVar;
        try {
            tVar = (t) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException e) {
            tVar = null;
        } catch (ClassNotFoundException e2) {
            tVar = null;
        } catch (IllegalAccessException e3) {
            tVar = null;
        } catch (InstantiationException e4) {
            tVar = null;
        }
        if (tVar == null) {
            tVar = new t();
        }
        pKF = tVar;
        pKG = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.d j(Class cls, String str) {
        return pKF.j(cls, str);
    }

    public static kotlin.reflect.c M(Class cls) {
        return pKF.M(cls);
    }

    public static String a(Lambda lambda) {
        return pKF.a(lambda);
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        return pKF.a(functionReference);
    }

    public static kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return pKF.a(propertyReference0);
    }

    public static kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return pKF.a(mutablePropertyReference0);
    }

    public static kotlin.reflect.l a(PropertyReference1 propertyReference1) {
        return pKF.a(propertyReference1);
    }

    public static kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return pKF.a(mutablePropertyReference1);
    }

    public static kotlin.reflect.m a(PropertyReference2 propertyReference2) {
        return pKF.a(propertyReference2);
    }

    public static kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return pKF.a(mutablePropertyReference2);
    }
}

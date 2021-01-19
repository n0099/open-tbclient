package kotlin.jvm.internal;
/* loaded from: classes5.dex */
public class s {
    private static final t qjp;
    private static final kotlin.reflect.c[] qjq;

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
        qjp = tVar;
        qjq = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.d k(Class cls, String str) {
        return qjp.k(cls, str);
    }

    public static kotlin.reflect.c G(Class cls) {
        return qjp.G(cls);
    }

    public static String a(Lambda lambda) {
        return qjp.a(lambda);
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        return qjp.a(functionReference);
    }

    public static kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return qjp.a(propertyReference0);
    }

    public static kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return qjp.a(mutablePropertyReference0);
    }

    public static kotlin.reflect.l a(PropertyReference1 propertyReference1) {
        return qjp.a(propertyReference1);
    }

    public static kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return qjp.a(mutablePropertyReference1);
    }

    public static kotlin.reflect.m a(PropertyReference2 propertyReference2) {
        return qjp.a(propertyReference2);
    }

    public static kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return qjp.a(mutablePropertyReference2);
    }
}

package kotlin.jvm.internal;
/* loaded from: classes5.dex */
public class t {
    private static final u nBI;
    private static final kotlin.reflect.c[] nBJ;

    static {
        u uVar;
        try {
            uVar = (u) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException e) {
            uVar = null;
        } catch (ClassNotFoundException e2) {
            uVar = null;
        } catch (IllegalAccessException e3) {
            uVar = null;
        } catch (InstantiationException e4) {
            uVar = null;
        }
        if (uVar == null) {
            uVar = new u();
        }
        nBI = uVar;
        nBJ = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.d j(Class cls, String str) {
        return nBI.j(cls, str);
    }

    public static kotlin.reflect.c N(Class cls) {
        return nBI.N(cls);
    }

    public static String a(Lambda lambda) {
        return nBI.a(lambda);
    }

    public static String a(p pVar) {
        return nBI.a(pVar);
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        return nBI.a(functionReference);
    }

    public static kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return nBI.a(propertyReference0);
    }

    public static kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return nBI.a(mutablePropertyReference0);
    }

    public static kotlin.reflect.l a(PropertyReference1 propertyReference1) {
        return nBI.a(propertyReference1);
    }

    public static kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return nBI.a(mutablePropertyReference1);
    }

    public static kotlin.reflect.m a(PropertyReference2 propertyReference2) {
        return nBI.a(propertyReference2);
    }

    public static kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return nBI.a(mutablePropertyReference2);
    }
}

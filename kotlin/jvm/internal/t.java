package kotlin.jvm.internal;
/* loaded from: classes7.dex */
public class t {
    private static final u nCr;
    private static final kotlin.reflect.c[] nCs;

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
        nCr = uVar;
        nCs = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.d j(Class cls, String str) {
        return nCr.j(cls, str);
    }

    public static kotlin.reflect.c M(Class cls) {
        return nCr.M(cls);
    }

    public static String a(Lambda lambda) {
        return nCr.a(lambda);
    }

    public static String a(p pVar) {
        return nCr.a(pVar);
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        return nCr.a(functionReference);
    }

    public static kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return nCr.a(propertyReference0);
    }

    public static kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return nCr.a(mutablePropertyReference0);
    }

    public static kotlin.reflect.l a(PropertyReference1 propertyReference1) {
        return nCr.a(propertyReference1);
    }

    public static kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return nCr.a(mutablePropertyReference1);
    }

    public static kotlin.reflect.m a(PropertyReference2 propertyReference2) {
        return nCr.a(propertyReference2);
    }

    public static kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return nCr.a(mutablePropertyReference2);
    }
}

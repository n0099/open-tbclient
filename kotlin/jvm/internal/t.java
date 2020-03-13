package kotlin.jvm.internal;
/* loaded from: classes7.dex */
public class t {
    private static final u nCC;
    private static final kotlin.reflect.c[] nCD;

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
        nCC = uVar;
        nCD = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.d j(Class cls, String str) {
        return nCC.j(cls, str);
    }

    public static kotlin.reflect.c M(Class cls) {
        return nCC.M(cls);
    }

    public static String a(Lambda lambda) {
        return nCC.a(lambda);
    }

    public static String a(p pVar) {
        return nCC.a(pVar);
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        return nCC.a(functionReference);
    }

    public static kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return nCC.a(propertyReference0);
    }

    public static kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return nCC.a(mutablePropertyReference0);
    }

    public static kotlin.reflect.l a(PropertyReference1 propertyReference1) {
        return nCC.a(propertyReference1);
    }

    public static kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return nCC.a(mutablePropertyReference1);
    }

    public static kotlin.reflect.m a(PropertyReference2 propertyReference2) {
        return nCC.a(propertyReference2);
    }

    public static kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return nCC.a(mutablePropertyReference2);
    }
}

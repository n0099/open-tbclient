package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public class s {
    private static final t jSH;
    private static final kotlin.reflect.c[] jSI;

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
        jSH = tVar;
        jSI = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.d h(Class cls, String str) {
        return jSH.h(cls, str);
    }

    public static kotlin.reflect.c G(Class cls) {
        return jSH.G(cls);
    }

    public static String a(Lambda lambda) {
        return jSH.a(lambda);
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        return jSH.a(functionReference);
    }

    public static kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return jSH.a(propertyReference0);
    }

    public static kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return jSH.a(mutablePropertyReference0);
    }

    public static kotlin.reflect.l a(PropertyReference1 propertyReference1) {
        return jSH.a(propertyReference1);
    }

    public static kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return jSH.a(mutablePropertyReference1);
    }

    public static kotlin.reflect.m a(PropertyReference2 propertyReference2) {
        return jSH.a(propertyReference2);
    }

    public static kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return jSH.a(mutablePropertyReference2);
    }
}

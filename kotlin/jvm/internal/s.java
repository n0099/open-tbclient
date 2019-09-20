package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public class s {
    private static final t kvu;
    private static final kotlin.reflect.c[] kvv;

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
        kvu = tVar;
        kvv = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.d h(Class cls, String str) {
        return kvu.h(cls, str);
    }

    public static kotlin.reflect.c F(Class cls) {
        return kvu.F(cls);
    }

    public static String a(Lambda lambda) {
        return kvu.a(lambda);
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        return kvu.a(functionReference);
    }

    public static kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return kvu.a(propertyReference0);
    }

    public static kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return kvu.a(mutablePropertyReference0);
    }

    public static kotlin.reflect.l a(PropertyReference1 propertyReference1) {
        return kvu.a(propertyReference1);
    }

    public static kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return kvu.a(mutablePropertyReference1);
    }

    public static kotlin.reflect.m a(PropertyReference2 propertyReference2) {
        return kvu.a(propertyReference2);
    }

    public static kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return kvu.a(mutablePropertyReference2);
    }
}

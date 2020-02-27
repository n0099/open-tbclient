package kotlin.jvm.internal;
/* loaded from: classes7.dex */
public class t {
    private static final u nCp;
    private static final kotlin.reflect.c[] nCq;

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
        nCp = uVar;
        nCq = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.d j(Class cls, String str) {
        return nCp.j(cls, str);
    }

    public static kotlin.reflect.c M(Class cls) {
        return nCp.M(cls);
    }

    public static String a(Lambda lambda) {
        return nCp.a(lambda);
    }

    public static String a(p pVar) {
        return nCp.a(pVar);
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        return nCp.a(functionReference);
    }

    public static kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return nCp.a(propertyReference0);
    }

    public static kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return nCp.a(mutablePropertyReference0);
    }

    public static kotlin.reflect.l a(PropertyReference1 propertyReference1) {
        return nCp.a(propertyReference1);
    }

    public static kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return nCp.a(mutablePropertyReference1);
    }

    public static kotlin.reflect.m a(PropertyReference2 propertyReference2) {
        return nCp.a(propertyReference2);
    }

    public static kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return nCp.a(mutablePropertyReference2);
    }
}

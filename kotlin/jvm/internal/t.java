package kotlin.jvm.internal;
/* loaded from: classes7.dex */
public class t {
    private static final u nsT;
    private static final kotlin.reflect.c[] nsU;

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
        nsT = uVar;
        nsU = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.d j(Class cls, String str) {
        return nsT.j(cls, str);
    }

    public static kotlin.reflect.c M(Class cls) {
        return nsT.M(cls);
    }

    public static String a(Lambda lambda) {
        return nsT.a(lambda);
    }

    public static String a(p pVar) {
        return nsT.a(pVar);
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        return nsT.a(functionReference);
    }

    public static kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return nsT.a(propertyReference0);
    }

    public static kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return nsT.a(mutablePropertyReference0);
    }

    public static kotlin.reflect.l a(PropertyReference1 propertyReference1) {
        return nsT.a(propertyReference1);
    }

    public static kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return nsT.a(mutablePropertyReference1);
    }

    public static kotlin.reflect.m a(PropertyReference2 propertyReference2) {
        return nsT.a(propertyReference2);
    }

    public static kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return nsT.a(mutablePropertyReference2);
    }
}

package kotlin.jvm.internal;
/* loaded from: classes5.dex */
public class t {
    private static final u oCB;
    private static final kotlin.reflect.c[] oCC;

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
        oCB = uVar;
        oCC = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.d j(Class cls, String str) {
        return oCB.j(cls, str);
    }

    public static kotlin.reflect.c M(Class cls) {
        return oCB.M(cls);
    }

    public static String a(Lambda lambda) {
        return oCB.a(lambda);
    }

    public static String a(p pVar) {
        return oCB.a(pVar);
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        return oCB.a(functionReference);
    }

    public static kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return oCB.a(propertyReference0);
    }

    public static kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return oCB.a(mutablePropertyReference0);
    }

    public static kotlin.reflect.l a(PropertyReference1 propertyReference1) {
        return oCB.a(propertyReference1);
    }

    public static kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return oCB.a(mutablePropertyReference1);
    }

    public static kotlin.reflect.m a(PropertyReference2 propertyReference2) {
        return oCB.a(propertyReference2);
    }

    public static kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return oCB.a(mutablePropertyReference2);
    }
}

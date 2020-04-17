package kotlin.jvm.internal;
/* loaded from: classes7.dex */
public class t {
    private static final u mXO;
    private static final kotlin.reflect.c[] mXP;

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
        mXO = uVar;
        mXP = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.d j(Class cls, String str) {
        return mXO.j(cls, str);
    }

    public static kotlin.reflect.c M(Class cls) {
        return mXO.M(cls);
    }

    public static String a(Lambda lambda) {
        return mXO.a(lambda);
    }

    public static String a(p pVar) {
        return mXO.a(pVar);
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        return mXO.a(functionReference);
    }

    public static kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return mXO.a(propertyReference0);
    }

    public static kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return mXO.a(mutablePropertyReference0);
    }

    public static kotlin.reflect.l a(PropertyReference1 propertyReference1) {
        return mXO.a(propertyReference1);
    }

    public static kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return mXO.a(mutablePropertyReference1);
    }

    public static kotlin.reflect.m a(PropertyReference2 propertyReference2) {
        return mXO.a(propertyReference2);
    }

    public static kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return mXO.a(mutablePropertyReference2);
    }
}

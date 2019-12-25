package kotlin.jvm.internal;
/* loaded from: classes4.dex */
public class t {
    public kotlin.reflect.d j(Class cls, String str) {
        return new r(cls, str);
    }

    public kotlin.reflect.c M(Class cls) {
        return new m(cls);
    }

    public String a(Lambda lambda) {
        String obj = lambda.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring("kotlin.jvm.functions.".length()) : obj;
    }

    public kotlin.reflect.e a(FunctionReference functionReference) {
        return functionReference;
    }

    public kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public kotlin.reflect.l a(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public kotlin.reflect.m a(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    public kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }
}

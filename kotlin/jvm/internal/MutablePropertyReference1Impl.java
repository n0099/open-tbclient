package kotlin.jvm.internal;
/* loaded from: classes5.dex */
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    private final String name;
    private final kotlin.reflect.d owner;
    private final String signature;

    public MutablePropertyReference1Impl(kotlin.reflect.d dVar, String str, String str2) {
        this.owner = dVar;
        this.name = str;
        this.signature = str2;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.d getOwner() {
        return this.owner;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getName() {
        return this.name;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return this.signature;
    }

    @Override // kotlin.reflect.l
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    public void set(Object obj, Object obj2) {
        getSetter().call(obj, obj2);
    }
}

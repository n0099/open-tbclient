package kotlin.jvm.internal;
/* loaded from: classes9.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    private final String name;
    private final kotlin.reflect.d owner;
    private final String signature;

    public PropertyReference0Impl(kotlin.reflect.d dVar, String str, String str2) {
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

    @Override // kotlin.reflect.k
    public Object get() {
        return getGetter().call(new Object[0]);
    }
}

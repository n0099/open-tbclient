package kotlin.jvm.internal;
/* loaded from: classes17.dex */
public class FunctionReferenceImpl extends FunctionReference {
    private final String name;
    private final kotlin.reflect.d owner;
    private final String signature;

    public FunctionReferenceImpl(int i, kotlin.reflect.d dVar, String str, String str2) {
        super(i);
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
}

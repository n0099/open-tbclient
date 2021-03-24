package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;
/* loaded from: classes7.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public final String name;
    public final KDeclarationContainer owner;
    public final String signature;

    public PropertyReference1Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        this.owner = kDeclarationContainer;
        this.name = str;
        this.signature = str2;
    }

    @Override // kotlin.reflect.KProperty1
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return this.name;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return this.owner;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return this.signature;
    }
}

package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes9.dex */
public final /* synthetic */ class DeserializedClassDescriptor$memberScopeHolder$1 extends FunctionReference implements Function1<KotlinTypeRefiner, DeserializedClassDescriptor.DeserializedClassMemberScope> {
    public DeserializedClassDescriptor$memberScopeHolder$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(1, deserializedClassDescriptor);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DeserializedClassDescriptor.DeserializedClassMemberScope.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final DeserializedClassDescriptor.DeserializedClassMemberScope invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        return new DeserializedClassDescriptor.DeserializedClassMemberScope(kotlinTypeRefiner);
    }
}

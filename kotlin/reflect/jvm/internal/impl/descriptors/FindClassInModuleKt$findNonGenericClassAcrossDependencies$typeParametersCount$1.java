package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
/* loaded from: classes9.dex */
public final /* synthetic */ class FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1 extends FunctionReference implements Function1<ClassId, ClassId> {
    public static final FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1 INSTANCE = new FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1();

    public FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "getOuterClassId";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ClassId.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final ClassId invoke(ClassId classId) {
        return classId.getOuterClassId();
    }
}

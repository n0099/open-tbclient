package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
/* loaded from: classes9.dex */
public final /* synthetic */ class ReflectJavaClass$methods$2 extends FunctionReference implements Function1<Method, ReflectJavaMethod> {
    public static final ReflectJavaClass$methods$2 INSTANCE = new ReflectJavaClass$methods$2();

    public ReflectJavaClass$methods$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ReflectJavaMethod.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Method;)V";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final ReflectJavaMethod invoke(Method method) {
        return new ReflectJavaMethod(method);
    }
}

package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
/* loaded from: classes2.dex */
public final /* synthetic */ class BuiltInsLoaderImpl$createPackageFragmentProvider$1 extends FunctionReference implements Function1<String, InputStream> {
    public BuiltInsLoaderImpl$createPackageFragmentProvider$1(BuiltInsResourceLoader builtInsResourceLoader) {
        super(1, builtInsResourceLoader);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "loadResource";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BuiltInsResourceLoader.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final InputStream invoke(String str) {
        return ((BuiltInsResourceLoader) this.receiver).loadResource(str);
    }
}

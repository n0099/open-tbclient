package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
/* loaded from: classes2.dex */
public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {
    public final LazyJavaResolverContext c;
    public final DeclarationDescriptor containingDeclaration;
    public final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> resolve;
    public final Map<JavaTypeParameter, Integer> typeParameters;
    public final int typeParametersIndexOffset;

    public LazyJavaTypeParameterResolver(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        this.c = lazyJavaResolverContext;
        this.containingDeclaration = declarationDescriptor;
        this.typeParametersIndexOffset = i;
        this.typeParameters = CollectionsKt.mapToIndex(javaTypeParameterListOwner.getTypeParameters());
        this.resolve = this.c.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<JavaTypeParameter, LazyJavaTypeParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver$resolve$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final LazyJavaTypeParameterDescriptor invoke(JavaTypeParameter javaTypeParameter) {
                Map map;
                LazyJavaResolverContext lazyJavaResolverContext2;
                int i2;
                DeclarationDescriptor declarationDescriptor2;
                map = LazyJavaTypeParameterResolver.this.typeParameters;
                Integer num = (Integer) map.get(javaTypeParameter);
                if (num != null) {
                    int intValue = num.intValue();
                    lazyJavaResolverContext2 = LazyJavaTypeParameterResolver.this.c;
                    LazyJavaResolverContext child = ContextKt.child(lazyJavaResolverContext2, LazyJavaTypeParameterResolver.this);
                    i2 = LazyJavaTypeParameterResolver.this.typeParametersIndexOffset;
                    int i3 = i2 + intValue;
                    declarationDescriptor2 = LazyJavaTypeParameterResolver.this.containingDeclaration;
                    return new LazyJavaTypeParameterDescriptor(child, javaTypeParameter, i3, declarationDescriptor2);
                }
                return null;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
    public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter) {
        LazyJavaTypeParameterDescriptor invoke = this.resolve.invoke(javaTypeParameter);
        if (invoke == null) {
            return this.c.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter);
        }
        return invoke;
    }
}

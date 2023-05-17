package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class KTypeImpl$arguments$2 extends Lambda implements Function0<List<? extends KTypeProjection>> {
    public final /* synthetic */ KTypeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTypeImpl$arguments$2(KTypeImpl kTypeImpl) {
        super(0);
        this.this$0 = kTypeImpl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.KTypeProjection>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends KTypeProjection> invoke() {
        KTypeProjection invariant;
        List<TypeProjection> arguments = this.this$0.getType().getArguments();
        if (arguments.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        final Lazy lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<List<? extends Type>>() { // from class: kotlin.reflect.jvm.internal.KTypeImpl$arguments$2$parameterizedTypeArguments$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.List<java.lang.reflect.Type>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Type> invoke() {
                return ReflectClassUtilKt.getParameterizedTypeArguments(KTypeImpl$arguments$2.this.this$0.getJavaType$kotlin_reflection());
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10));
        final int i = 0;
        for (Object obj : arguments) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            if (typeProjection.isStarProjection()) {
                invariant = KTypeProjection.Companion.getSTAR();
            } else {
                KotlinType type = typeProjection.getType();
                Intrinsics.checkExpressionValueIsNotNull(type, "typeProjection.type");
                KTypeImpl kTypeImpl = new KTypeImpl(type, new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final Type invoke() {
                        Class<?> cls;
                        Type javaType$kotlin_reflection = this.this$0.getJavaType$kotlin_reflection();
                        if (javaType$kotlin_reflection instanceof Class) {
                            Class cls2 = (Class) javaType$kotlin_reflection;
                            if (cls2.isArray()) {
                                cls = cls2.getComponentType();
                            } else {
                                cls = Object.class;
                            }
                            Intrinsics.checkExpressionValueIsNotNull(cls, "if (javaType.isArray) ja…Type else Any::class.java");
                            return cls;
                        } else if (javaType$kotlin_reflection instanceof GenericArrayType) {
                            if (i == 0) {
                                Type genericComponentType = ((GenericArrayType) javaType$kotlin_reflection).getGenericComponentType();
                                Intrinsics.checkExpressionValueIsNotNull(genericComponentType, "javaType.genericComponentType");
                                return genericComponentType;
                            }
                            throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + this.this$0);
                        } else if (javaType$kotlin_reflection instanceof ParameterizedType) {
                            Type type2 = (Type) ((List) lazy.getValue()).get(i);
                            if (type2 instanceof WildcardType) {
                                WildcardType wildcardType = (WildcardType) type2;
                                Type[] lowerBounds = wildcardType.getLowerBounds();
                                Intrinsics.checkExpressionValueIsNotNull(lowerBounds, "argument.lowerBounds");
                                Type type3 = (Type) ArraysKt___ArraysKt.firstOrNull(lowerBounds);
                                if (type3 != null) {
                                    type2 = type3;
                                } else {
                                    Type[] upperBounds = wildcardType.getUpperBounds();
                                    Intrinsics.checkExpressionValueIsNotNull(upperBounds, "argument.upperBounds");
                                    type2 = (Type) ArraysKt___ArraysKt.first(upperBounds);
                                }
                            }
                            Intrinsics.checkExpressionValueIsNotNull(type2, "if (argument !is Wildcar…ument.upperBounds.first()");
                            return type2;
                        } else {
                            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + this.this$0);
                        }
                    }
                });
                int i3 = KTypeImpl.WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            invariant = KTypeProjection.Companion.covariant(kTypeImpl);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        invariant = KTypeProjection.Companion.contravariant(kTypeImpl);
                    }
                } else {
                    invariant = KTypeProjection.Companion.invariant(kTypeImpl);
                }
            }
            arrayList.add(invariant);
            i = i2;
        }
        return arrayList;
    }
}

package kotlin.reflect.full;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001b\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/KType;", "other", "", "isSubtypeOf", "(Lkotlin/reflect/KType;Lkotlin/reflect/KType;)Z", "isSupertypeOf", "nullable", "withNullability", "(Lkotlin/reflect/KType;Z)Lkotlin/reflect/KType;", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "KTypes")
/* loaded from: classes10.dex */
public final class KTypes {
    @SinceKotlin(version = "1.1")
    public static final boolean isSubtypeOf(KType kType, KType kType2) {
        return TypeUtilsKt.isSubtypeOf(((KTypeImpl) kType).getType(), ((KTypeImpl) kType2).getType());
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSupertypeOf(KType kType, KType kType2) {
        return isSubtypeOf(kType2, kType);
    }

    @SinceKotlin(version = "1.1")
    public static final KType withNullability(final KType kType, boolean z) {
        if (kType.isMarkedNullable()) {
            if (!z) {
                KotlinType makeNotNullable = TypeUtils.makeNotNullable(((KTypeImpl) kType).getType());
                Intrinsics.checkExpressionValueIsNotNull(makeNotNullable, "TypeUtils.makeNotNullabl…(this as KTypeImpl).type)");
                return new KTypeImpl(makeNotNullable, new Function0<Type>() { // from class: kotlin.reflect.full.KTypes$withNullability$1
                    {
                        super(0);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final Type invoke() {
                        return ((KTypeImpl) KType.this).getJavaType$kotlin_reflection();
                    }
                });
            }
            return kType;
        }
        KotlinType type = ((KTypeImpl) kType).getType();
        if (FlexibleTypesKt.isFlexible(type)) {
            KotlinType makeNullableAsSpecified = TypeUtils.makeNullableAsSpecified(type, z);
            Intrinsics.checkExpressionValueIsNotNull(makeNullableAsSpecified, "TypeUtils.makeNullableAs…ied(kotlinType, nullable)");
            return new KTypeImpl(makeNullableAsSpecified, new Function0<Type>() { // from class: kotlin.reflect.full.KTypes$withNullability$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final Type invoke() {
                    return ((KTypeImpl) KType.this).getJavaType$kotlin_reflection();
                }
            });
        } else if (z) {
            KotlinType makeNullable = TypeUtils.makeNullable(type);
            Intrinsics.checkExpressionValueIsNotNull(makeNullable, "TypeUtils.makeNullable(kotlinType)");
            return new KTypeImpl(makeNullable, new Function0<Type>() { // from class: kotlin.reflect.full.KTypes$withNullability$3
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final Type invoke() {
                    return ((KTypeImpl) KType.this).getJavaType$kotlin_reflection();
                }
            });
        } else {
            return kType;
        }
    }
}

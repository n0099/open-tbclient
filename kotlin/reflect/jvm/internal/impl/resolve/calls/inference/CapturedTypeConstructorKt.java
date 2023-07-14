package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;
/* loaded from: classes2.dex */
public final class CapturedTypeConstructorKt {
    public static final TypeProjection createCapturedIfNeeded(final TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor != null && typeProjection.getProjectionKind() != Variance.INVARIANT) {
            if (typeParameterDescriptor.getVariance() == typeProjection.getProjectionKind()) {
                if (typeProjection.isStarProjection()) {
                    StorageManager storageManager = LockBasedStorageManager.NO_LOCKS;
                    Intrinsics.checkExpressionValueIsNotNull(storageManager, "LockBasedStorageManager.NO_LOCKS");
                    return new TypeProjectionImpl(new LazyWrappedType(storageManager, new Function0<KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$createCapturedIfNeeded$1
                        {
                            super(0);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function0
                        public final KotlinType invoke() {
                            KotlinType type = TypeProjection.this.getType();
                            Intrinsics.checkExpressionValueIsNotNull(type, "this@createCapturedIfNeeded.type");
                            return type;
                        }
                    }));
                }
                return new TypeProjectionImpl(typeProjection.getType());
            }
            return new TypeProjectionImpl(createCapturedType(typeProjection));
        }
        return typeProjection;
    }

    public static final TypeSubstitution wrapWithCapturingSubstitution(final TypeSubstitution typeSubstitution, final boolean z) {
        if (typeSubstitution instanceof IndexedParametersSubstitution) {
            IndexedParametersSubstitution indexedParametersSubstitution = (IndexedParametersSubstitution) typeSubstitution;
            TypeParameterDescriptor[] parameters = indexedParametersSubstitution.getParameters();
            List<Pair> zip = ArraysKt___ArraysKt.zip(indexedParametersSubstitution.getArguments(), indexedParametersSubstitution.getParameters());
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(zip, 10));
            for (Pair pair : zip) {
                arrayList.add(createCapturedIfNeeded((TypeProjection) pair.getFirst(), (TypeParameterDescriptor) pair.getSecond()));
            }
            Object[] array = arrayList.toArray(new TypeProjection[0]);
            if (array != null) {
                return new IndexedParametersSubstitution(parameters, (TypeProjection[]) array, z);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return new DelegatedTypeSubstitution(typeSubstitution) { // from class: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2
            @Override // kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public boolean approximateContravariantCapturedTypes() {
                return z;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            /* renamed from: get */
            public TypeProjection mo2106get(KotlinType kotlinType) {
                TypeProjection createCapturedIfNeeded;
                TypeProjection mo2106get = super.mo2106get(kotlinType);
                TypeParameterDescriptor typeParameterDescriptor = null;
                if (mo2106get == null) {
                    return null;
                }
                ClassifierDescriptor mo2101getDeclarationDescriptor = kotlinType.getConstructor().mo2101getDeclarationDescriptor();
                if (mo2101getDeclarationDescriptor instanceof TypeParameterDescriptor) {
                    typeParameterDescriptor = mo2101getDeclarationDescriptor;
                }
                createCapturedIfNeeded = CapturedTypeConstructorKt.createCapturedIfNeeded(mo2106get, typeParameterDescriptor);
                return createCapturedIfNeeded;
            }
        };
    }

    public static final KotlinType createCapturedType(TypeProjection typeProjection) {
        return new CapturedType(typeProjection, null, false, null, 14, null);
    }

    public static final boolean isCaptured(KotlinType kotlinType) {
        return kotlinType.getConstructor() instanceof CapturedTypeConstructor;
    }

    public static /* synthetic */ TypeSubstitution wrapWithCapturingSubstitution$default(TypeSubstitution typeSubstitution, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return wrapWithCapturingSubstitution(typeSubstitution, z);
    }
}

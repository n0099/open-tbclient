package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001e\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00008@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0002\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/KClassifier;", "Lkotlin/reflect/KClass;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "jvmErasure", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "KTypesJvm")
/* loaded from: classes10.dex */
public final class KTypesJvm {
    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void jvmErasure$annotations(KType kType) {
    }

    public static final KClass<?> getJvmErasure(KClassifier kClassifier) {
        Object obj;
        KClass<?> jvmErasure;
        boolean z;
        if (kClassifier instanceof KClass) {
            return (KClass) kClassifier;
        }
        if (kClassifier instanceof KTypeParameter) {
            List<KType> upperBounds = ((KTypeParameter) kClassifier).getUpperBounds();
            Iterator<T> it = upperBounds.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                KType kType = (KType) next;
                if (kType != null) {
                    Object mo2102getDeclarationDescriptor = ((KTypeImpl) kType).getType().getConstructor().mo2102getDeclarationDescriptor();
                    if (mo2102getDeclarationDescriptor instanceof ClassDescriptor) {
                        obj = mo2102getDeclarationDescriptor;
                    }
                    ClassDescriptor classDescriptor = (ClassDescriptor) obj;
                    if (classDescriptor != null && classDescriptor.getKind() != ClassKind.INTERFACE && classDescriptor.getKind() != ClassKind.ANNOTATION_CLASS) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        obj = next;
                        break;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                }
            }
            KType kType2 = (KType) obj;
            if (kType2 == null) {
                kType2 = (KType) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) upperBounds);
            }
            if (kType2 == null || (jvmErasure = getJvmErasure(kType2)) == null) {
                return Reflection.getOrCreateKotlinClass(Object.class);
            }
            return jvmErasure;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kClassifier);
    }

    public static final KClass<?> getJvmErasure(KType kType) {
        KClass<?> jvmErasure;
        KClassifier classifier = kType.getClassifier();
        if (classifier != null && (jvmErasure = getJvmErasure(classifier)) != null) {
            return jvmErasure;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kType);
    }
}

package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* loaded from: classes9.dex */
public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: findAnnotation */
    AnnotationDescriptor mo2018findAnnotation(FqName fqName);

    boolean hasAnnotation(FqName fqName);

    boolean isEmpty();

    /* loaded from: classes9.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final Annotations EMPTY = new Annotations() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion$EMPTY$1
            /* JADX DEBUG: Possible override for method kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.findAnnotation(Lkotlin/reflect/jvm/internal/impl/name/FqName;)Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor; */
            public Void findAnnotation(FqName fqName) {
                return null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            public boolean isEmpty() {
                return true;
            }

            public String toString() {
                return "EMPTY";
            }

            @Override // java.lang.Iterable
            public Iterator<AnnotationDescriptor> iterator() {
                return CollectionsKt__CollectionsKt.emptyList().iterator();
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            /* renamed from: findAnnotation  reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AnnotationDescriptor mo2018findAnnotation(FqName fqName) {
                return (AnnotationDescriptor) findAnnotation(fqName);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            public boolean hasAnnotation(FqName fqName) {
                return Annotations.DefaultImpls.hasAnnotation(this, fqName);
            }
        };

        public final Annotations getEMPTY() {
            return EMPTY;
        }

        public final Annotations create(List<? extends AnnotationDescriptor> list) {
            if (list.isEmpty()) {
                return EMPTY;
            }
            return new AnnotationsImpl(list);
        }
    }

    /* loaded from: classes9.dex */
    public static final class DefaultImpls {
        public static AnnotationDescriptor findAnnotation(Annotations annotations, FqName fqName) {
            AnnotationDescriptor annotationDescriptor;
            Iterator<AnnotationDescriptor> it = annotations.iterator();
            while (true) {
                if (it.hasNext()) {
                    annotationDescriptor = it.next();
                    if (Intrinsics.areEqual(annotationDescriptor.getFqName(), fqName)) {
                        break;
                    }
                } else {
                    annotationDescriptor = null;
                    break;
                }
            }
            return annotationDescriptor;
        }

        public static boolean hasAnnotation(Annotations annotations, FqName fqName) {
            if (annotations.mo2018findAnnotation(fqName) != null) {
                return true;
            }
            return false;
        }
    }
}

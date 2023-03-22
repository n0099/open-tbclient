package kotlin.reflect.jvm.internal.impl.descriptors.annotations;
/* loaded from: classes9.dex */
public final class AnnotationsKt {
    public static final Annotations composeAnnotations(Annotations annotations, Annotations annotations2) {
        if (annotations.isEmpty()) {
            return annotations2;
        }
        if (!annotations2.isEmpty()) {
            return new CompositeAnnotations(annotations, annotations2);
        }
        return annotations;
    }
}

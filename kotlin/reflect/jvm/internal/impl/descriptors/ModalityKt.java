package kotlin.reflect.jvm.internal.impl.descriptors;
/* loaded from: classes9.dex */
public final class ModalityKt {
    public static final boolean isFinalClass(ClassDescriptor classDescriptor) {
        if (classDescriptor.getModality() == Modality.FINAL && classDescriptor.getKind() != ClassKind.ENUM_CLASS) {
            return true;
        }
        return false;
    }
}

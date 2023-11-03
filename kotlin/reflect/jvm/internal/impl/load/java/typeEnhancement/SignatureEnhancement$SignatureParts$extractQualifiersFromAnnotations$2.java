package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
public final class SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2<T> extends Lambda implements Function2<T, T, T> {
    public static final SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2 INSTANCE = new SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2();

    public SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final <T> T invoke(T t, T t2) {
        if (t != null && t2 != null && !Intrinsics.areEqual(t, t2)) {
            return null;
        }
        if (t == null) {
            return t2;
        }
        return t;
    }
}

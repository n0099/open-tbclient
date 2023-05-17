package kotlin.reflect.jvm.internal.impl.types.model;
/* loaded from: classes10.dex */
public enum TypeVariance {
    IN("in"),
    OUT("out"),
    INV("");
    
    public final String presentation;

    @Override // java.lang.Enum
    public String toString() {
        return this.presentation;
    }

    TypeVariance(String str) {
        this.presentation = str;
    }
}

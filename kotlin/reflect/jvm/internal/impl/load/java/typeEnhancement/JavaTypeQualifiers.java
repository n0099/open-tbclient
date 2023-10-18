package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes10.dex */
public final class JavaTypeQualifiers {
    public static final Companion Companion = new Companion(null);
    public static final JavaTypeQualifiers NONE = new JavaTypeQualifiers(null, null, false, false, 8, null);
    public final boolean isNotNullTypeParameter;
    public final boolean isNullabilityQualifierForWarning;
    public final MutabilityQualifier mutability;
    public final NullabilityQualifier nullability;

    /* loaded from: classes10.dex */
    public static final class Companion {
        public Companion() {
        }

        public final JavaTypeQualifiers getNONE() {
            return JavaTypeQualifiers.NONE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final MutabilityQualifier getMutability() {
        return this.mutability;
    }

    public final NullabilityQualifier getNullability() {
        return this.nullability;
    }

    public final boolean isNotNullTypeParameter() {
        return this.isNotNullTypeParameter;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.isNullabilityQualifierForWarning;
    }

    public JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        this.nullability = nullabilityQualifier;
        this.mutability = mutabilityQualifier;
        this.isNotNullTypeParameter = z;
        this.isNullabilityQualifierForWarning = z2;
    }

    public /* synthetic */ JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, mutabilityQualifier, z, (i & 8) != 0 ? false : z2);
    }
}

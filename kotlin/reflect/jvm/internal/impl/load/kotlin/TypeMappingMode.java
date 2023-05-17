package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.Variance;
/* loaded from: classes10.dex */
public final class TypeMappingMode {
    public final TypeMappingMode genericArgumentMode;
    public final TypeMappingMode genericContravariantArgumentMode;
    public final TypeMappingMode genericInvariantArgumentMode;
    public final boolean isForAnnotationParameter;
    public final boolean kotlinCollectionsToJavaCollections;
    public final boolean needInlineClassWrapping;
    public final boolean needPrimitiveBoxing;
    public final boolean skipDeclarationSiteWildcards;
    public final boolean skipDeclarationSiteWildcardsIfPossible;
    public static final Companion Companion = new Companion(null);
    @JvmField
    public static final TypeMappingMode GENERIC_ARGUMENT = new TypeMappingMode(false, false, false, false, false, null, false, null, null, 511, null);
    @JvmField
    public static final TypeMappingMode RETURN_TYPE_BOXED = new TypeMappingMode(false, true, false, false, false, null, false, null, null, 509, null);
    @JvmField
    public static final TypeMappingMode DEFAULT = new TypeMappingMode(false, false, false, false, false, GENERIC_ARGUMENT, false, null, null, 476, null);
    @JvmField
    public static final TypeMappingMode CLASS_DECLARATION = new TypeMappingMode(false, true, false, false, false, GENERIC_ARGUMENT, false, null, null, 476, null);
    @JvmField
    public static final TypeMappingMode SUPER_TYPE = new TypeMappingMode(false, false, false, true, false, GENERIC_ARGUMENT, false, null, null, 471, null);
    @JvmField
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(false, false, false, true, false, GENERIC_ARGUMENT, false, null, null, 407, null);
    @JvmField
    public static final TypeMappingMode VALUE_FOR_ANNOTATION = new TypeMappingMode(false, false, true, false, false, new TypeMappingMode(false, false, true, false, false, GENERIC_ARGUMENT, false, null, null, 475, null), false, null, null, 472, null);

    /* loaded from: classes10.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            $EnumSwitchMapping$0[Variance.INVARIANT.ordinal()] = 2;
        }
    }

    /* loaded from: classes10.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TypeMappingMode(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, TypeMappingMode typeMappingMode, boolean z6, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3) {
        this.needPrimitiveBoxing = z;
        this.needInlineClassWrapping = z2;
        this.isForAnnotationParameter = z3;
        this.skipDeclarationSiteWildcards = z4;
        this.skipDeclarationSiteWildcardsIfPossible = z5;
        this.genericArgumentMode = typeMappingMode;
        this.kotlinCollectionsToJavaCollections = z6;
        this.genericContravariantArgumentMode = typeMappingMode2;
        this.genericInvariantArgumentMode = typeMappingMode3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TypeMappingMode(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, TypeMappingMode typeMappingMode, boolean z6, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r6, r5, r7, r2, r8, r0);
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        TypeMappingMode typeMappingMode4;
        TypeMappingMode typeMappingMode5;
        TypeMappingMode typeMappingMode6;
        if ((i & 1) != 0) {
            z7 = true;
        } else {
            z7 = z;
        }
        if ((i & 2) != 0) {
            z8 = true;
        } else {
            z8 = z2;
        }
        if ((i & 4) != 0) {
            z9 = false;
        } else {
            z9 = z3;
        }
        if ((i & 8) != 0) {
            z10 = false;
        } else {
            z10 = z4;
        }
        boolean z11 = (i & 16) == 0 ? z5 : false;
        if ((i & 32) != 0) {
            typeMappingMode4 = null;
        } else {
            typeMappingMode4 = typeMappingMode;
        }
        boolean z12 = (i & 64) == 0 ? z6 : true;
        if ((i & 128) != 0) {
            typeMappingMode5 = typeMappingMode4;
        } else {
            typeMappingMode5 = typeMappingMode2;
        }
        if ((i & 256) != 0) {
            typeMappingMode6 = typeMappingMode4;
        } else {
            typeMappingMode6 = typeMappingMode3;
        }
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.kotlinCollectionsToJavaCollections;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.needInlineClassWrapping;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.needPrimitiveBoxing, true, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode);
    }

    public final TypeMappingMode toGenericArgumentMode(Variance variance) {
        int i = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i != 1) {
            if (i != 2) {
                TypeMappingMode typeMappingMode = this.genericArgumentMode;
                if (typeMappingMode != null) {
                    return typeMappingMode;
                }
            } else {
                TypeMappingMode typeMappingMode2 = this.genericInvariantArgumentMode;
                if (typeMappingMode2 != null) {
                    return typeMappingMode2;
                }
            }
        } else {
            TypeMappingMode typeMappingMode3 = this.genericContravariantArgumentMode;
            if (typeMappingMode3 != null) {
                return typeMappingMode3;
            }
        }
        return this;
    }
}

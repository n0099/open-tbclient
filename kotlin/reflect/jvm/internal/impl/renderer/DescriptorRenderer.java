package kotlin.reflect.jvm.internal.impl.renderer;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
/* loaded from: classes2.dex */
public abstract class DescriptorRenderer {
    @JvmField
    public static final DescriptorRenderer COMPACT;
    @JvmField
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES;
    @JvmField
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS;
    @JvmField
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES;
    public static final Companion Companion;
    @JvmField
    public static final DescriptorRenderer DEBUG_TEXT;
    @JvmField
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES;
    @JvmField
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS;
    @JvmField
    public static final DescriptorRenderer HTML;
    @JvmField
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES;
    @JvmField
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES;

    public abstract String render(DeclarationDescriptor declarationDescriptor);

    public abstract String renderAnnotation(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget);

    public abstract String renderFlexibleType(String str, String str2, KotlinBuiltIns kotlinBuiltIns);

    public abstract String renderFqName(FqNameUnsafe fqNameUnsafe);

    public abstract String renderName(Name name, boolean z);

    public abstract String renderType(KotlinType kotlinType);

    public abstract String renderTypeProjection(TypeProjection typeProjection);

    /* loaded from: classes2.dex */
    public static final class Companion {

        /* loaded from: classes2.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ClassKind.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[ClassKind.CLASS.ordinal()] = 1;
                $EnumSwitchMapping$0[ClassKind.INTERFACE.ordinal()] = 2;
                $EnumSwitchMapping$0[ClassKind.ENUM_CLASS.ordinal()] = 3;
                $EnumSwitchMapping$0[ClassKind.OBJECT.ordinal()] = 4;
                $EnumSwitchMapping$0[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                $EnumSwitchMapping$0[ClassKind.ENUM_ENTRY.ordinal()] = 6;
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> function1) {
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
            function1.invoke(descriptorRendererOptionsImpl);
            descriptorRendererOptionsImpl.lock();
            return new DescriptorRendererImpl(descriptorRendererOptionsImpl);
        }

        public final String getClassifierKindPrefix(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
            if (classifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor) {
                return "typealias";
            }
            if (classifierDescriptorWithTypeParameters instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptorWithTypeParameters;
                if (classDescriptor.isCompanionObject()) {
                    return "companion object";
                }
                switch (WhenMappings.$EnumSwitchMapping$0[classDescriptor.getKind().ordinal()]) {
                    case 1:
                        return "class";
                    case 2:
                        return "interface";
                    case 3:
                        return "enum class";
                    case 4:
                        return "object";
                    case 5:
                        return "annotation class";
                    case 6:
                        return "enum entry";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            throw new AssertionError("Unexpected classifier: " + classifierDescriptorWithTypeParameters);
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        COMPACT_WITH_MODIFIERS = companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$COMPACT_WITH_MODIFIERS$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                descriptorRendererOptions.setWithDefinedIn(false);
            }
        });
        COMPACT = Companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$COMPACT$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                descriptorRendererOptions.setWithDefinedIn(false);
                descriptorRendererOptions.setModifiers(SetsKt__SetsKt.emptySet());
            }
        });
        COMPACT_WITHOUT_SUPERTYPES = Companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                descriptorRendererOptions.setWithDefinedIn(false);
                descriptorRendererOptions.setModifiers(SetsKt__SetsKt.emptySet());
                descriptorRendererOptions.setWithoutSuperTypes(true);
            }
        });
        COMPACT_WITH_SHORT_TYPES = Companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                descriptorRendererOptions.setModifiers(SetsKt__SetsKt.emptySet());
                descriptorRendererOptions.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
                descriptorRendererOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
            }
        });
        ONLY_NAMES_WITH_SHORT_TYPES = Companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                descriptorRendererOptions.setWithDefinedIn(false);
                descriptorRendererOptions.setModifiers(SetsKt__SetsKt.emptySet());
                descriptorRendererOptions.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
                descriptorRendererOptions.setWithoutTypeParameters(true);
                descriptorRendererOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.NONE);
                descriptorRendererOptions.setReceiverAfterName(true);
                descriptorRendererOptions.setRenderCompanionObjectName(true);
                descriptorRendererOptions.setWithoutSuperTypes(true);
                descriptorRendererOptions.setStartFromName(true);
            }
        });
        FQ_NAMES_IN_TYPES = Companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                descriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
            }
        });
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = Companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                descriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL);
            }
        });
        SHORT_NAMES_IN_TYPES = Companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                descriptorRendererOptions.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
                descriptorRendererOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
            }
        });
        DEBUG_TEXT = Companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$DEBUG_TEXT$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                descriptorRendererOptions.setDebugMode(true);
                descriptorRendererOptions.setClassifierNamePolicy(ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
                descriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL);
            }
        });
        HTML = Companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$HTML$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                descriptorRendererOptions.setTextFormat(RenderingFormat.HTML);
                descriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL);
            }
        });
    }

    /* loaded from: classes2.dex */
    public interface ValueParametersHandler {
        void appendAfterValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb);

        void appendAfterValueParameters(int i, StringBuilder sb);

        void appendBeforeValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb);

        void appendBeforeValueParameters(int i, StringBuilder sb);

        /* loaded from: classes2.dex */
        public static final class DEFAULT implements ValueParametersHandler {
            public static final DEFAULT INSTANCE = new DEFAULT();

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb) {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb) {
                if (i != i2 - 1) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int i, StringBuilder sb) {
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int i, StringBuilder sb) {
                sb.append("(");
            }
        }
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer descriptorRenderer, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                annotationUseSiteTarget = null;
            }
            return descriptorRenderer.renderAnnotation(annotationDescriptor, annotationUseSiteTarget);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> function1) {
        DescriptorRendererOptionsImpl copy = ((DescriptorRendererImpl) this).getOptions().copy();
        function1.invoke(copy);
        copy.lock();
        return new DescriptorRendererImpl(copy);
    }
}

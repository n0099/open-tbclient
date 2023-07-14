package kotlin.reflect.jvm.internal.impl.renderer;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCode;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnresolvedType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.apache.commons.codec.language.bm.ResourceConstants;
/* loaded from: classes2.dex */
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    public final Lazy functionTypeAnnotationsRenderer$delegate;
    public final Lazy functionTypeParameterTypesRenderer$delegate;
    public final DescriptorRendererOptionsImpl options;

    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        static {
            int[] iArr = new int[RenderingFormat.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[RenderingFormat.PLAIN.ordinal()] = 1;
            $EnumSwitchMapping$0[RenderingFormat.HTML.ordinal()] = 2;
            int[] iArr2 = new int[RenderingFormat.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[RenderingFormat.PLAIN.ordinal()] = 1;
            $EnumSwitchMapping$1[RenderingFormat.HTML.ordinal()] = 2;
            int[] iArr3 = new int[RenderingFormat.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[RenderingFormat.PLAIN.ordinal()] = 1;
            $EnumSwitchMapping$2[RenderingFormat.HTML.ordinal()] = 2;
            int[] iArr4 = new int[RenderingFormat.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[RenderingFormat.PLAIN.ordinal()] = 1;
            $EnumSwitchMapping$3[RenderingFormat.HTML.ordinal()] = 2;
            int[] iArr5 = new int[ParameterNameRenderingPolicy.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            $EnumSwitchMapping$4[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            $EnumSwitchMapping$4[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
        }
    }

    private final DescriptorRendererImpl getFunctionTypeAnnotationsRenderer() {
        return (DescriptorRendererImpl) this.functionTypeAnnotationsRenderer$delegate.getValue();
    }

    private final DescriptorRenderer getFunctionTypeParameterTypesRenderer() {
        return (DescriptorRenderer) this.functionTypeParameterTypesRenderer$delegate.getValue();
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.options.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.options.getAlwaysRenderModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.options.getAnnotationArgumentsRenderingPolicy();
    }

    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return this.options.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.options.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.options.getClassWithPrimaryConstructor();
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.options.getClassifierNamePolicy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getDebugMode() {
        return this.options.getDebugMode();
    }

    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return this.options.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.options.getEachAnnotationOnNewLine();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getEnhancedTypes() {
        return this.options.getEnhancedTypes();
    }

    public Set<FqName> getExcludedAnnotationClasses() {
        return this.options.getExcludedAnnotationClasses();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.options.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.options.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.options.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.options.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.options.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.options.getInformativeErrorType();
    }

    public Set<DescriptorRendererModifier> getModifiers() {
        return this.options.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.options.getNormalizedVisibilities();
    }

    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return this.options.getOverrideRenderingPolicy();
    }

    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return this.options.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.options.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.options.getPresentableUnresolvedTypes();
    }

    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return this.options.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.options.getReceiverAfterName();
    }

    public boolean getRenderCompanionObjectName() {
        return this.options.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.options.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.options.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.options.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.options.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.options.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.options.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.options.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.options.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.options.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.options.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.options.getStartFromName();
    }

    public RenderingFormat getTextFormat() {
        return this.options.getTextFormat();
    }

    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.options.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.options.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.options.getUnitReturnType();
    }

    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return this.options.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.options.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.options.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.options.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.options.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.options.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.options.getWithoutTypeParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        this.options.setAnnotationArgumentsRenderingPolicy(annotationArgumentsRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        this.options.setClassifierNamePolicy(classifierNamePolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean z) {
        this.options.setDebugMode(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(Set<FqName> set) {
        this.options.setExcludedTypeAnnotationClasses(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(Set<? extends DescriptorRendererModifier> set) {
        this.options.setModifiers(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        this.options.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean z) {
        this.options.setReceiverAfterName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean z) {
        this.options.setRenderCompanionObjectName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean z) {
        this.options.setStartFromName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(RenderingFormat renderingFormat) {
        this.options.setTextFormat(renderingFormat);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean z) {
        this.options.setVerbose(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean z) {
        this.options.setWithDefinedIn(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean z) {
        this.options.setWithoutSuperTypes(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean z) {
        this.options.setWithoutTypeParameters(z);
    }

    /* loaded from: classes2.dex */
    public final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {

        /* loaded from: classes2.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PropertyAccessorRenderingPolicy.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                $EnumSwitchMapping$0[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                $EnumSwitchMapping$0[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public RenderDeclarationDescriptorVisitor() {
        }

        private final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb, String str) {
            int i = WhenMappings.$EnumSwitchMapping$0[DescriptorRendererImpl.this.getPropertyAccessorRenderingPolicy().ordinal()];
            if (i == 1) {
                DescriptorRendererImpl.this.renderAccessorModifiers(propertyAccessorDescriptor, sb);
                sb.append(str + " for ");
                DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
                PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
                Intrinsics.checkExpressionValueIsNotNull(correspondingProperty, "descriptor.correspondingProperty");
                descriptorRendererImpl.renderProperty(correspondingProperty, sb);
            } else if (i == 2) {
                visitFunctionDescriptor2((FunctionDescriptor) propertyAccessorDescriptor, sb);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitClassDescriptor(ClassDescriptor classDescriptor, StringBuilder sb) {
            visitClassDescriptor2(classDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
            visitConstructorDescriptor2(constructorDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitFunctionDescriptor(FunctionDescriptor functionDescriptor, StringBuilder sb) {
            visitFunctionDescriptor2(functionDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitModuleDeclaration(ModuleDescriptor moduleDescriptor, StringBuilder sb) {
            visitModuleDeclaration2(moduleDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
            visitPackageFragmentDescriptor2(packageFragmentDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
            visitPackageViewDescriptor2(packageViewDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
            visitPropertyDescriptor2(propertyDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, StringBuilder sb) {
            visitPropertyGetterDescriptor2(propertyGetterDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, StringBuilder sb) {
            visitPropertySetterDescriptor2(propertySetterDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, StringBuilder sb) {
            visitReceiverParameterDescriptor2(receiverParameterDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
            visitTypeAliasDescriptor2(typeAliasDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb) {
            visitTypeParameterDescriptor2(typeParameterDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, StringBuilder sb) {
            visitValueParameterDescriptor2(valueParameterDescriptor, sb);
            return Unit.INSTANCE;
        }

        /* renamed from: visitClassDescriptor  reason: avoid collision after fix types in other method */
        public void visitClassDescriptor2(ClassDescriptor classDescriptor, StringBuilder sb) {
            DescriptorRendererImpl.this.renderClass(classDescriptor, sb);
        }

        /* renamed from: visitConstructorDescriptor  reason: avoid collision after fix types in other method */
        public void visitConstructorDescriptor2(ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
            DescriptorRendererImpl.this.renderConstructor(constructorDescriptor, sb);
        }

        /* renamed from: visitFunctionDescriptor  reason: avoid collision after fix types in other method */
        public void visitFunctionDescriptor2(FunctionDescriptor functionDescriptor, StringBuilder sb) {
            DescriptorRendererImpl.this.renderFunction(functionDescriptor, sb);
        }

        /* renamed from: visitModuleDeclaration  reason: avoid collision after fix types in other method */
        public void visitModuleDeclaration2(ModuleDescriptor moduleDescriptor, StringBuilder sb) {
            DescriptorRendererImpl.this.renderName(moduleDescriptor, sb, true);
        }

        /* renamed from: visitPackageFragmentDescriptor  reason: avoid collision after fix types in other method */
        public void visitPackageFragmentDescriptor2(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
            DescriptorRendererImpl.this.renderPackageFragment(packageFragmentDescriptor, sb);
        }

        /* renamed from: visitPackageViewDescriptor  reason: avoid collision after fix types in other method */
        public void visitPackageViewDescriptor2(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
            DescriptorRendererImpl.this.renderPackageView(packageViewDescriptor, sb);
        }

        /* renamed from: visitPropertyDescriptor  reason: avoid collision after fix types in other method */
        public void visitPropertyDescriptor2(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
            DescriptorRendererImpl.this.renderProperty(propertyDescriptor, sb);
        }

        /* renamed from: visitPropertyGetterDescriptor  reason: avoid collision after fix types in other method */
        public void visitPropertyGetterDescriptor2(PropertyGetterDescriptor propertyGetterDescriptor, StringBuilder sb) {
            visitPropertyAccessorDescriptor(propertyGetterDescriptor, sb, "getter");
        }

        /* renamed from: visitPropertySetterDescriptor  reason: avoid collision after fix types in other method */
        public void visitPropertySetterDescriptor2(PropertySetterDescriptor propertySetterDescriptor, StringBuilder sb) {
            visitPropertyAccessorDescriptor(propertySetterDescriptor, sb, "setter");
        }

        /* renamed from: visitReceiverParameterDescriptor  reason: avoid collision after fix types in other method */
        public void visitReceiverParameterDescriptor2(ReceiverParameterDescriptor receiverParameterDescriptor, StringBuilder sb) {
            sb.append(receiverParameterDescriptor.getName());
        }

        /* renamed from: visitTypeAliasDescriptor  reason: avoid collision after fix types in other method */
        public void visitTypeAliasDescriptor2(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
            DescriptorRendererImpl.this.renderTypeAlias(typeAliasDescriptor, sb);
        }

        /* renamed from: visitTypeParameterDescriptor  reason: avoid collision after fix types in other method */
        public void visitTypeParameterDescriptor2(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb) {
            DescriptorRendererImpl.this.renderTypeParameter(typeParameterDescriptor, sb, true);
        }

        /* renamed from: visitValueParameterDescriptor  reason: avoid collision after fix types in other method */
        public void visitValueParameterDescriptor2(ValueParameterDescriptor valueParameterDescriptor, StringBuilder sb) {
            DescriptorRendererImpl.this.renderValueParameter(valueParameterDescriptor, true, sb, true);
        }
    }

    public DescriptorRendererImpl(DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        this.options = descriptorRendererOptionsImpl;
        boolean isLocked = descriptorRendererOptionsImpl.isLocked();
        if (_Assertions.ENABLED && !isLocked) {
            throw new AssertionError("Assertion failed");
        }
        this.functionTypeAnnotationsRenderer$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DescriptorRendererImpl>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$functionTypeAnnotationsRenderer$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final DescriptorRendererImpl invoke() {
                DescriptorRenderer withOptions = DescriptorRendererImpl.this.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$functionTypeAnnotationsRenderer$2.1
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                        invoke2(descriptorRendererOptions);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                        descriptorRendererOptions.setExcludedTypeAnnotationClasses(SetsKt___SetsKt.plus((Set) descriptorRendererOptions.getExcludedTypeAnnotationClasses(), (Iterable) CollectionsKt__CollectionsJVMKt.listOf(KotlinBuiltIns.FQ_NAMES.extensionFunctionType)));
                        descriptorRendererOptions.setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy.ALWAYS_PARENTHESIZED);
                    }
                });
                if (withOptions != null) {
                    return (DescriptorRendererImpl) withOptions;
                }
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
            }
        });
        this.functionTypeParameterTypesRenderer$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DescriptorRenderer>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$functionTypeParameterTypesRenderer$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final DescriptorRenderer invoke() {
                return DescriptorRendererImpl.this.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$functionTypeParameterTypesRenderer$2.1
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                        invoke2(descriptorRendererOptions);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                        descriptorRendererOptions.setExcludedTypeAnnotationClasses(SetsKt___SetsKt.plus((Set) descriptorRendererOptions.getExcludedTypeAnnotationClasses(), (Iterable) CollectionsKt__CollectionsJVMKt.listOf(KotlinBuiltIns.FQ_NAMES.parameterName)));
                    }
                });
            }
        });
    }

    private final String escape(String str) {
        return getTextFormat().escape(str);
    }

    private final boolean hasModifiersOrAnnotations(KotlinType kotlinType) {
        if (!FunctionTypesKt.isSuspendFunctionType(kotlinType) && kotlinType.getAnnotations().isEmpty()) {
            return false;
        }
        return true;
    }

    private final boolean overridesSomething(CallableMemberDescriptor callableMemberDescriptor) {
        return !callableMemberDescriptor.getOverriddenDescriptors().isEmpty();
    }

    private final String renderError(String str) {
        int i = WhenMappings.$EnumSwitchMapping$1[getTextFormat().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "<font color=red><b>" + str + "</b></font>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    private final String renderFqName(List<Name> list) {
        return escape(RenderingUtilsKt.renderFqName(list));
    }

    private final void renderSpaceIfNeeded(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(WebvttCueParser.CHAR_SPACE);
        }
    }

    private final boolean shouldRenderParameterNames(boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$4[getParameterNameRenderingPolicy().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            } else if (z) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String render(DeclarationDescriptor declarationDescriptor) {
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.accept(new RenderDeclarationDescriptorVisitor(), sb);
        if (getWithDefinedIn()) {
            appendDefinedIn(sb, declarationDescriptor);
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public String renderClassifierName(ClassifierDescriptor classifierDescriptor) {
        if (ErrorUtils.isError(classifierDescriptor)) {
            return classifierDescriptor.getTypeConstructor().toString();
        }
        return getClassifierNamePolicy().renderClassifier(classifierDescriptor, this);
    }

    public String renderMessage(String str) {
        int i = WhenMappings.$EnumSwitchMapping$3[getTextFormat().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "<i>" + str + "</i>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderType(KotlinType kotlinType) {
        StringBuilder sb = new StringBuilder();
        renderNormalizedType(sb, getTypeNormalizer().invoke(kotlinType));
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public String renderTypeArguments(List<? extends TypeProjection> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lt());
        appendTypeProjections(sb, list);
        sb.append(gt());
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderTypeProjection(TypeProjection typeProjection) {
        StringBuilder sb = new StringBuilder();
        appendTypeProjections(sb, CollectionsKt__CollectionsJVMKt.listOf(typeProjection));
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private final void renderModality(Modality modality, StringBuilder sb, Modality modality2) {
        if (!getRenderDefaultModality() && modality == modality2) {
            return;
        }
        boolean contains = getModifiers().contains(DescriptorRendererModifier.MODALITY);
        String name = modality.name();
        if (name != null) {
            String lowerCase = name.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
            renderModifier(sb, contains, lowerCase);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final void renderModifier(StringBuilder sb, boolean z, String str) {
        if (z) {
            sb.append(renderKeyword(str));
            sb.append(" ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderName(DeclarationDescriptor declarationDescriptor, StringBuilder sb, boolean z) {
        Name name = declarationDescriptor.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "descriptor.name");
        sb.append(renderName(name, z));
    }

    private final void renderPackageHeader(FqName fqName, String str, StringBuilder sb) {
        boolean z;
        sb.append(renderKeyword(str));
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics.checkExpressionValueIsNotNull(unsafe, "fqName.toUnsafe()");
        String renderFqName = renderFqName(unsafe);
        if (renderFqName.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            sb.append(" ");
            sb.append(renderFqName);
        }
    }

    private final void renderTypeConstructorAndArguments(StringBuilder sb, KotlinType kotlinType, TypeConstructor typeConstructor) {
        PossiblyInnerType buildPossiblyInnerType = TypeParameterUtilsKt.buildPossiblyInnerType(kotlinType);
        if (buildPossiblyInnerType == null) {
            sb.append(renderTypeConstructor(typeConstructor));
            sb.append(renderTypeArguments(kotlinType.getArguments()));
            return;
        }
        renderPossiblyInnerType(sb, buildPossiblyInnerType);
    }

    private final void renderTypeParameters(List<? extends TypeParameterDescriptor> list, StringBuilder sb, boolean z) {
        if (!getWithoutTypeParameters() && (!list.isEmpty())) {
            sb.append(lt());
            renderTypeParameterList(sb, list);
            sb.append(gt());
            if (z) {
                sb.append(" ");
            }
        }
    }

    private final void renderValVarPrefix(VariableDescriptor variableDescriptor, StringBuilder sb, boolean z) {
        String str;
        if (z || !(variableDescriptor instanceof ValueParameterDescriptor)) {
            if (variableDescriptor.isVar()) {
                str = "var";
            } else {
                str = "val";
            }
            sb.append(renderKeyword(str));
            sb.append(" ");
        }
    }

    private final void appendTypeProjections(StringBuilder sb, List<? extends TypeProjection> list) {
        CollectionsKt___CollectionsKt.joinTo$default(list, sb, StringUtil.ARRAY_ELEMENT_SEPARATOR, null, null, 0, null, new Function1<TypeProjection, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$appendTypeProjections$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(TypeProjection typeProjection) {
                if (typeProjection.isStarProjection()) {
                    return "*";
                }
                DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
                KotlinType type = typeProjection.getType();
                Intrinsics.checkExpressionValueIsNotNull(type, "it.type");
                String renderType = descriptorRendererImpl.renderType(type);
                if (typeProjection.getProjectionKind() == Variance.INVARIANT) {
                    return renderType;
                }
                return typeProjection.getProjectionKind() + WebvttCueParser.CHAR_SPACE + renderType;
            }
        }, 60, null);
    }

    private final void renderAbbreviatedTypeExpansion(StringBuilder sb, AbbreviatedType abbreviatedType) {
        if (getTextFormat() == RenderingFormat.HTML) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        renderNormalizedTypeAsIs(sb, abbreviatedType.getExpandedType());
        sb.append(" */");
        if (getTextFormat() == RenderingFormat.HTML) {
            sb.append("</i></font>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderAccessorModifiers(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb) {
        renderMemberModifiers(propertyAccessorDescriptor, sb);
    }

    private final void renderClassKindPrefix(ClassDescriptor classDescriptor, StringBuilder sb) {
        sb.append(renderKeyword(DescriptorRenderer.Companion.getClassifierKindPrefix(classDescriptor)));
    }

    private final void renderInitializer(VariableDescriptor variableDescriptor, StringBuilder sb) {
        ConstantValue<?> constant;
        if (getIncludePropertyConstant() && (constant = variableDescriptor.mo2097getCompileTimeInitializer()) != null) {
            sb.append(" = ");
            Intrinsics.checkExpressionValueIsNotNull(constant, "constant");
            sb.append(escape(renderConstant(constant)));
        }
    }

    private final void renderNormalizedType(StringBuilder sb, KotlinType kotlinType) {
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof AbbreviatedType)) {
            unwrap = null;
        }
        AbbreviatedType abbreviatedType = (AbbreviatedType) unwrap;
        if (abbreviatedType != null) {
            if (getRenderTypeExpansions()) {
                renderNormalizedTypeAsIs(sb, abbreviatedType.getExpandedType());
                return;
            }
            renderNormalizedTypeAsIs(sb, abbreviatedType.getAbbreviation());
            if (getRenderUnabbreviatedType()) {
                renderAbbreviatedTypeExpansion(sb, abbreviatedType);
                return;
            }
            return;
        }
        renderNormalizedTypeAsIs(sb, kotlinType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderPackageFragment(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
        renderPackageHeader(packageFragmentDescriptor.getFqName(), "package-fragment", sb);
        if (getDebugMode()) {
            sb.append(" in ");
            renderName(packageFragmentDescriptor.getContainingDeclaration(), sb, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderPackageView(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
        renderPackageHeader(packageViewDescriptor.getFqName(), "package", sb);
        if (getDebugMode()) {
            sb.append(" in context of ");
            renderName(packageViewDescriptor.getModule(), sb, false);
        }
    }

    private final void renderReceiverAfterName(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter;
        if (getReceiverAfterName() && (extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter()) != null) {
            sb.append(" on ");
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "receiver.type");
            sb.append(renderType(type));
        }
    }

    private final void renderSuspendModifier(FunctionDescriptor functionDescriptor, StringBuilder sb) {
        renderModifier(sb, functionDescriptor.isSuspend(), DownloadStatisticConstants.UBC_TYPE_SUSPEND);
    }

    private final void renderTypeParameterList(StringBuilder sb, List<? extends TypeParameterDescriptor> list) {
        Iterator<? extends TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            renderTypeParameter(it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderName(Name name, boolean z) {
        String escape = escape(RenderingUtilsKt.render(name));
        if (getBoldOnlyForNamesInHtml() && getTextFormat() == RenderingFormat.HTML && z) {
            return "<b>" + escape + "</b>";
        }
        return escape;
    }

    private final void appendDefinedIn(StringBuilder sb, DeclarationDescriptor declarationDescriptor) {
        String renderFqName;
        if (!(declarationDescriptor instanceof PackageFragmentDescriptor) && !(declarationDescriptor instanceof PackageViewDescriptor)) {
            if (declarationDescriptor instanceof ModuleDescriptor) {
                sb.append(" is a module");
                return;
            }
            DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
            if (containingDeclaration != null && !(containingDeclaration instanceof ModuleDescriptor)) {
                sb.append(" ");
                sb.append(renderMessage("defined in"));
                sb.append(" ");
                FqNameUnsafe fqName = DescriptorUtils.getFqName(containingDeclaration);
                Intrinsics.checkExpressionValueIsNotNull(fqName, "DescriptorUtils.getFqName(containingDeclaration)");
                if (fqName.isRoot()) {
                    renderFqName = "root package";
                } else {
                    renderFqName = renderFqName(fqName);
                }
                sb.append(renderFqName);
                if (getWithSourceFileForTopLevel() && (containingDeclaration instanceof PackageFragmentDescriptor) && (declarationDescriptor instanceof DeclarationDescriptorWithSource)) {
                    SourceElement source = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource();
                    Intrinsics.checkExpressionValueIsNotNull(source, "descriptor.source");
                    SourceFile containingFile = source.getContainingFile();
                    Intrinsics.checkExpressionValueIsNotNull(containingFile, "descriptor.source.containingFile");
                    String name = containingFile.getName();
                    if (name != null) {
                        sb.append(" ");
                        sb.append(renderMessage("in file"));
                        sb.append(" ");
                        sb.append(name);
                    }
                }
            }
        }
    }

    private final void renderDefaultType(StringBuilder sb, KotlinType kotlinType) {
        renderAnnotations$default(this, sb, kotlinType, null, 2, null);
        if (KotlinTypeKt.isError(kotlinType)) {
            if ((kotlinType instanceof UnresolvedType) && getPresentableUnresolvedTypes()) {
                sb.append(((UnresolvedType) kotlinType).getPresentableName());
            } else if ((kotlinType instanceof ErrorType) && !getInformativeErrorType()) {
                sb.append(((ErrorType) kotlinType).getPresentableName());
            } else {
                sb.append(kotlinType.getConstructor().toString());
            }
            sb.append(renderTypeArguments(kotlinType.getArguments()));
        } else {
            renderTypeConstructorAndArguments$default(this, sb, kotlinType, null, 2, null);
        }
        if (kotlinType.isMarkedNullable()) {
            sb.append("?");
        }
        if (SpecialTypesKt.isDefinitelyNotNullType(kotlinType)) {
            sb.append("!!");
        }
    }

    private final void renderPropertyAnnotations(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (!getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            return;
        }
        renderAnnotations$default(this, sb, propertyDescriptor, null, 2, null);
        FieldDescriptor it = propertyDescriptor.getBackingField();
        if (it != null) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            renderAnnotations(sb, it, AnnotationUseSiteTarget.FIELD);
        }
        FieldDescriptor it2 = propertyDescriptor.getDelegateField();
        if (it2 != null) {
            Intrinsics.checkExpressionValueIsNotNull(it2, "it");
            renderAnnotations(sb, it2, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
        }
        if (getPropertyAccessorRenderingPolicy() == PropertyAccessorRenderingPolicy.NONE) {
            PropertyGetterDescriptor it3 = propertyDescriptor.getGetter();
            if (it3 != null) {
                Intrinsics.checkExpressionValueIsNotNull(it3, "it");
                renderAnnotations(sb, it3, AnnotationUseSiteTarget.PROPERTY_GETTER);
            }
            PropertySetterDescriptor setter = propertyDescriptor.getSetter();
            if (setter != null) {
                Intrinsics.checkExpressionValueIsNotNull(setter, "it");
                renderAnnotations(sb, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                Intrinsics.checkExpressionValueIsNotNull(setter, "setter");
                List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                Intrinsics.checkExpressionValueIsNotNull(valueParameters, "setter.valueParameters");
                ValueParameterDescriptor it4 = (ValueParameterDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) valueParameters);
                Intrinsics.checkExpressionValueIsNotNull(it4, "it");
                renderAnnotations(sb, it4, AnnotationUseSiteTarget.SETTER_PARAMETER);
            }
        }
    }

    private final void renderSimpleType(StringBuilder sb, SimpleType simpleType) {
        if (!Intrinsics.areEqual(simpleType, TypeUtils.CANT_INFER_FUNCTION_PARAM_TYPE) && !TypeUtils.isDontCarePlaceholder(simpleType)) {
            if (ErrorUtils.isUninferredParameter(simpleType)) {
                if (getUninferredTypeParameterAsName()) {
                    TypeConstructor constructor = simpleType.getConstructor();
                    if (constructor != null) {
                        TypeParameterDescriptor typeParameterDescriptor = ((ErrorUtils.UninferredParameterTypeConstructor) constructor).getTypeParameterDescriptor();
                        Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, "(type.constructor as Uni…).typeParameterDescriptor");
                        String name = typeParameterDescriptor.getName().toString();
                        Intrinsics.checkExpressionValueIsNotNull(name, "(type.constructor as Uni…escriptor.name.toString()");
                        sb.append(renderError(name));
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.ErrorUtils.UninferredParameterTypeConstructor");
                }
                sb.append("???");
                return;
            } else if (KotlinTypeKt.isError(simpleType)) {
                renderDefaultType(sb, simpleType);
                return;
            } else if (shouldRenderAsPrettyFunctionType(simpleType)) {
                renderFunctionType(sb, simpleType);
                return;
            } else {
                renderDefaultType(sb, simpleType);
                return;
            }
        }
        sb.append("???");
    }

    private final void renderWhereSuffix(List<? extends TypeParameterDescriptor> list, StringBuilder sb) {
        if (getWithoutTypeParameters()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
            Intrinsics.checkExpressionValueIsNotNull(upperBounds, "typeParameter.upperBounds");
            for (KotlinType it : CollectionsKt___CollectionsKt.drop(upperBounds, 1)) {
                StringBuilder sb2 = new StringBuilder();
                Name name = typeParameterDescriptor.getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "typeParameter.name");
                sb2.append(renderName(name, false));
                sb2.append(ZeusCrashHandler.NAME_SEPERATOR);
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                sb2.append(renderType(it));
                arrayList.add(sb2.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            sb.append(" ");
            sb.append(renderKeyword("where"));
            sb.append(" ");
            CollectionsKt___CollectionsKt.joinTo$default(arrayList, sb, StringUtil.ARRAY_ELEMENT_SEPARATOR, null, null, 0, null, null, 124, null);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderAnnotation(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget) {
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (annotationUseSiteTarget != null) {
            sb.append(annotationUseSiteTarget.getRenderName() + ":");
        }
        KotlinType type = annotationDescriptor.getType();
        sb.append(renderType(type));
        if (getIncludeAnnotationArguments()) {
            List<String> renderAndSortAnnotationArguments = renderAndSortAnnotationArguments(annotationDescriptor);
            if (getIncludeEmptyAnnotationArguments() || (!renderAndSortAnnotationArguments.isEmpty())) {
                CollectionsKt___CollectionsKt.joinTo$default(renderAndSortAnnotationArguments, sb, StringUtil.ARRAY_ELEMENT_SEPARATOR, "(", SmallTailInfo.EMOTION_SUFFIX, 0, null, null, 112, null);
            }
        }
        if (getVerbose() && (KotlinTypeKt.isError(type) || (type.getConstructor().mo2101getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor))) {
            sb.append(" /* annotation class not found */");
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private final String arrow() {
        int i = WhenMappings.$EnumSwitchMapping$2[getTextFormat().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "&rarr;";
            }
            throw new NoWhenBranchMatchedException();
        }
        return escape("->");
    }

    private final String gt() {
        return escape(">");
    }

    private final String lt() {
        return escape("<");
    }

    public final DescriptorRendererOptionsImpl getOptions() {
        return this.options;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0032, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r7 + org.apache.commons.codec.net.RFC1522Codec.SEP, r8) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean differsOnlyInNullability(String str, String str2) {
        if (!Intrinsics.areEqual(str, StringsKt__StringsJVMKt.replace$default(str2, "?", "", false, 4, (Object) null))) {
            if (StringsKt__StringsJVMKt.endsWith$default(str2, "?", false, 2, null)) {
            }
            if (!Intrinsics.areEqual('(' + str + ")?", str2)) {
                return false;
            }
        }
        return true;
    }

    private final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder sb) {
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(declaredTypeParameters, "classifier.declaredTypeParameters");
        TypeConstructor typeConstructor = classifierDescriptorWithTypeParameters.getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "classifier.typeConstructor");
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        Intrinsics.checkExpressionValueIsNotNull(parameters, "classifier.typeConstructor.parameters");
        if (getVerbose() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            renderTypeParameterList(sb, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append(ResourceConstants.EXT_CMT_END);
        }
    }

    private final void renderCompanionObjectName(DeclarationDescriptor declarationDescriptor, StringBuilder sb) {
        if (getRenderCompanionObjectName()) {
            if (getStartFromName()) {
                sb.append("companion object");
            }
            renderSpaceIfNeeded(sb);
            DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
            if (containingDeclaration != null) {
                sb.append("of ");
                Name name = containingDeclaration.getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "containingDeclaration.name");
                sb.append(renderName(name, false));
            }
        }
        if (getVerbose() || (!Intrinsics.areEqual(declarationDescriptor.getName(), SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT))) {
            if (!getStartFromName()) {
                renderSpaceIfNeeded(sb);
            }
            Name name2 = declarationDescriptor.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "descriptor.name");
            sb.append(renderName(name2, true));
        }
    }

    private final void renderSuperTypes(ClassDescriptor classDescriptor, StringBuilder sb) {
        if (getWithoutSuperTypes() || KotlinBuiltIns.isNothing(classDescriptor.getDefaultType())) {
            return;
        }
        TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "klass.typeConstructor");
        Collection<KotlinType> mo2102getSupertypes = typeConstructor.mo2102getSupertypes();
        Intrinsics.checkExpressionValueIsNotNull(mo2102getSupertypes, "klass.typeConstructor.supertypes");
        if (!mo2102getSupertypes.isEmpty()) {
            if (mo2102getSupertypes.size() != 1 || !KotlinBuiltIns.isAnyOrNullableAny(mo2102getSupertypes.iterator().next())) {
                renderSpaceIfNeeded(sb);
                sb.append(": ");
                CollectionsKt___CollectionsKt.joinTo$default(mo2102getSupertypes, sb, StringUtil.ARRAY_ELEMENT_SEPARATOR, null, null, 0, null, new Function1<KotlinType, String>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderSuperTypes$1
                    {
                        super(1);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(KotlinType it) {
                        DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
                        Intrinsics.checkExpressionValueIsNotNull(it, "it");
                        return descriptorRendererImpl.renderType(it);
                    }
                }, 60, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderTypeAlias(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
        renderAnnotations$default(this, sb, typeAliasDescriptor, null, 2, null);
        Visibility visibility = typeAliasDescriptor.getVisibility();
        Intrinsics.checkExpressionValueIsNotNull(visibility, "typeAlias.visibility");
        renderVisibility(visibility, sb);
        renderMemberModifiers(typeAliasDescriptor, sb);
        sb.append(renderKeyword("typealias"));
        sb.append(" ");
        renderName(typeAliasDescriptor, sb, true);
        List<TypeParameterDescriptor> declaredTypeParameters = typeAliasDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(declaredTypeParameters, "typeAlias.declaredTypeParameters");
        renderTypeParameters(declaredTypeParameters, sb, false);
        renderCapturedTypeParametersIfRequired(typeAliasDescriptor, sb);
        sb.append(" = ");
        sb.append(renderType(typeAliasDescriptor.getUnderlyingType()));
    }

    private final Modality implicitModalityWithoutExtensions(MemberDescriptor memberDescriptor) {
        if (memberDescriptor instanceof ClassDescriptor) {
            if (((ClassDescriptor) memberDescriptor).getKind() == ClassKind.INTERFACE) {
                return Modality.ABSTRACT;
            }
            return Modality.FINAL;
        }
        DeclarationDescriptor containingDeclaration = memberDescriptor.getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            containingDeclaration = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        if (classDescriptor != null) {
            if (!(memberDescriptor instanceof CallableMemberDescriptor)) {
                return Modality.FINAL;
            }
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) memberDescriptor;
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics.checkExpressionValueIsNotNull(overriddenDescriptors, "this.overriddenDescriptors");
            if ((!overriddenDescriptors.isEmpty()) && classDescriptor.getModality() != Modality.FINAL) {
                return Modality.OPEN;
            }
            if (classDescriptor.getKind() == ClassKind.INTERFACE && (!Intrinsics.areEqual(callableMemberDescriptor.getVisibility(), Visibilities.PRIVATE))) {
                Modality modality = callableMemberDescriptor.getModality();
                Modality modality2 = Modality.ABSTRACT;
                if (modality != modality2) {
                    return Modality.OPEN;
                }
                return modality2;
            }
            return Modality.FINAL;
        }
        return Modality.FINAL;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void renderAdditionalModifiers(FunctionDescriptor functionDescriptor, StringBuilder sb) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (functionDescriptor.isOperator()) {
            Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
            Intrinsics.checkExpressionValueIsNotNull(overriddenDescriptors, "functionDescriptor.overriddenDescriptors");
            if (!(overriddenDescriptors instanceof Collection) || !overriddenDescriptors.isEmpty()) {
                for (FunctionDescriptor it : overriddenDescriptors) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    if (it.isOperator()) {
                        z3 = false;
                        break;
                    }
                }
            }
            z3 = true;
            if (z3 || getAlwaysRenderModifiers()) {
                z = true;
                if (functionDescriptor.isInfix()) {
                    Collection<? extends FunctionDescriptor> overriddenDescriptors2 = functionDescriptor.getOverriddenDescriptors();
                    Intrinsics.checkExpressionValueIsNotNull(overriddenDescriptors2, "functionDescriptor.overriddenDescriptors");
                    if (!(overriddenDescriptors2 instanceof Collection) || !overriddenDescriptors2.isEmpty()) {
                        for (FunctionDescriptor it2 : overriddenDescriptors2) {
                            Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                            if (it2.isInfix()) {
                                z2 = false;
                                break;
                            }
                        }
                    }
                    z2 = true;
                    if (z2 || getAlwaysRenderModifiers()) {
                        z4 = true;
                    }
                }
                renderModifier(sb, functionDescriptor.isTailrec(), "tailrec");
                renderSuspendModifier(functionDescriptor, sb);
                renderModifier(sb, functionDescriptor.isInline(), "inline");
                renderModifier(sb, z4, "infix");
                renderModifier(sb, z, "operator");
            }
        }
        z = false;
        if (functionDescriptor.isInfix()) {
        }
        renderModifier(sb, functionDescriptor.isTailrec(), "tailrec");
        renderSuspendModifier(functionDescriptor, sb);
        renderModifier(sb, functionDescriptor.isInline(), "inline");
        renderModifier(sb, z4, "infix");
        renderModifier(sb, z, "operator");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderFunction(FunctionDescriptor functionDescriptor, StringBuilder sb) {
        String renderType;
        if (!getStartFromName()) {
            if (!getStartFromDeclarationKeyword()) {
                renderAnnotations$default(this, sb, functionDescriptor, null, 2, null);
                Visibility visibility = functionDescriptor.getVisibility();
                Intrinsics.checkExpressionValueIsNotNull(visibility, "function.visibility");
                renderVisibility(visibility, sb);
                renderModalityForCallable(functionDescriptor, sb);
                if (getIncludeAdditionalModifiers()) {
                    renderMemberModifiers(functionDescriptor, sb);
                }
                renderOverride(functionDescriptor, sb);
                if (getIncludeAdditionalModifiers()) {
                    renderAdditionalModifiers(functionDescriptor, sb);
                } else {
                    renderSuspendModifier(functionDescriptor, sb);
                }
                renderMemberKind(functionDescriptor, sb);
                if (getVerbose()) {
                    if (functionDescriptor.isHiddenToOvercomeSignatureClash()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (functionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(renderKeyword("fun"));
            sb.append(" ");
            List<TypeParameterDescriptor> typeParameters = functionDescriptor.getTypeParameters();
            Intrinsics.checkExpressionValueIsNotNull(typeParameters, "function.typeParameters");
            renderTypeParameters(typeParameters, sb, true);
            renderReceiver(functionDescriptor, sb);
        }
        renderName(functionDescriptor, sb, true);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(valueParameters, "function.valueParameters");
        renderValueParameters(valueParameters, functionDescriptor.hasSynthesizedParameterNames(), sb);
        renderReceiverAfterName(functionDescriptor, sb);
        KotlinType returnType = functionDescriptor.getReturnType();
        if (!getWithoutReturnType() && (getUnitReturnType() || returnType == null || !KotlinBuiltIns.isUnit(returnType))) {
            sb.append(": ");
            if (returnType == null) {
                renderType = "[NULL]";
            } else {
                renderType = renderType(returnType);
            }
            sb.append(renderType);
        }
        List<TypeParameterDescriptor> typeParameters2 = functionDescriptor.getTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(typeParameters2, "function.typeParameters");
        renderWhereSuffix(typeParameters2, sb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderProperty(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        boolean z;
        if (!getStartFromName()) {
            if (!getStartFromDeclarationKeyword()) {
                renderPropertyAnnotations(propertyDescriptor, sb);
                Visibility visibility = propertyDescriptor.getVisibility();
                Intrinsics.checkExpressionValueIsNotNull(visibility, "property.visibility");
                renderVisibility(visibility, sb);
                boolean z2 = false;
                if (getModifiers().contains(DescriptorRendererModifier.CONST) && propertyDescriptor.isConst()) {
                    z = true;
                } else {
                    z = false;
                }
                renderModifier(sb, z, "const");
                renderMemberModifiers(propertyDescriptor, sb);
                renderModalityForCallable(propertyDescriptor, sb);
                renderOverride(propertyDescriptor, sb);
                if (getModifiers().contains(DescriptorRendererModifier.LATEINIT) && propertyDescriptor.isLateInit()) {
                    z2 = true;
                }
                renderModifier(sb, z2, "lateinit");
                renderMemberKind(propertyDescriptor, sb);
            }
            renderValVarPrefix$default(this, propertyDescriptor, sb, false, 4, null);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            Intrinsics.checkExpressionValueIsNotNull(typeParameters, "property.typeParameters");
            renderTypeParameters(typeParameters, sb, true);
            renderReceiver(propertyDescriptor, sb);
        }
        renderName(propertyDescriptor, sb, true);
        sb.append(": ");
        KotlinType type = propertyDescriptor.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "property.type");
        sb.append(renderType(type));
        renderReceiverAfterName(propertyDescriptor, sb);
        renderInitializer(propertyDescriptor, sb);
        List<TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(typeParameters2, "property.typeParameters");
        renderWhereSuffix(typeParameters2, sb);
    }

    private final List<String> renderAndSortAnnotationArguments(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor classDescriptor;
        String str;
        ClassConstructorDescriptor mo2095getUnsubstitutedPrimaryConstructor;
        List<ValueParameterDescriptor> valueParameters;
        Map<Name, ConstantValue<?>> allValueArguments = annotationDescriptor.getAllValueArguments();
        List list = null;
        if (getRenderDefaultAnnotationArguments()) {
            classDescriptor = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        } else {
            classDescriptor = null;
        }
        if (classDescriptor != null && (mo2095getUnsubstitutedPrimaryConstructor = classDescriptor.mo2095getUnsubstitutedPrimaryConstructor()) != null && (valueParameters = mo2095getUnsubstitutedPrimaryConstructor.getValueParameters()) != null) {
            ArrayList<ValueParameterDescriptor> arrayList = new ArrayList();
            for (Object obj : valueParameters) {
                if (((ValueParameterDescriptor) obj).declaresDefaultValue()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (ValueParameterDescriptor it : arrayList) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                arrayList2.add(it.getName());
            }
            list = arrayList2;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (!allValueArguments.containsKey((Name) obj2)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((Name) it2.next()).asString() + " = ...");
        }
        Set<Map.Entry<Name, ConstantValue<?>>> entrySet = allValueArguments.entrySet();
        ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10));
        Iterator<T> it3 = entrySet.iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            Name name = (Name) entry.getKey();
            ConstantValue<?> constantValue = (ConstantValue) entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(name.asString());
            sb.append(" = ");
            if (!list.contains(name)) {
                str = renderConstant(constantValue);
            } else {
                str = "...";
            }
            sb.append(str);
            arrayList5.add(sb.toString());
        }
        return CollectionsKt___CollectionsKt.sorted(CollectionsKt___CollectionsKt.plus((Collection) arrayList4, (Iterable) arrayList5));
    }

    private final void renderAnnotations(StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget) {
        Set<FqName> excludedAnnotationClasses;
        if (!getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            return;
        }
        if (annotated instanceof KotlinType) {
            excludedAnnotationClasses = getExcludedTypeAnnotationClasses();
        } else {
            excludedAnnotationClasses = getExcludedAnnotationClasses();
        }
        Function1<AnnotationDescriptor, Boolean> annotationFilter = getAnnotationFilter();
        for (AnnotationDescriptor annotationDescriptor : annotated.getAnnotations()) {
            if (!CollectionsKt___CollectionsKt.contains(excludedAnnotationClasses, annotationDescriptor.getFqName()) && (annotationFilter == null || annotationFilter.invoke(annotationDescriptor).booleanValue())) {
                sb.append(renderAnnotation(annotationDescriptor, annotationUseSiteTarget));
                if (getEachAnnotationOnNewLine()) {
                    StringsKt__StringBuilderJVMKt.appendln(sb);
                } else {
                    sb.append(" ");
                }
            }
        }
    }

    public static /* synthetic */ void renderAnnotations$default(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget, int i, Object obj) {
        if ((i & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        descriptorRendererImpl.renderAnnotations(sb, annotated, annotationUseSiteTarget);
    }

    public static /* synthetic */ void renderTypeConstructorAndArguments$default(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, KotlinType kotlinType, TypeConstructor typeConstructor, int i, Object obj) {
        if ((i & 2) != 0) {
            typeConstructor = kotlinType.getConstructor();
        }
        descriptorRendererImpl.renderTypeConstructorAndArguments(sb, kotlinType, typeConstructor);
    }

    public static /* synthetic */ void renderValVarPrefix$default(DescriptorRendererImpl descriptorRendererImpl, VariableDescriptor variableDescriptor, StringBuilder sb, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        descriptorRendererImpl.renderValVarPrefix(variableDescriptor, sb, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderClass(ClassDescriptor classDescriptor, StringBuilder sb) {
        boolean z;
        ClassConstructorDescriptor mo2095getUnsubstitutedPrimaryConstructor;
        boolean z2;
        boolean z3;
        boolean z4;
        if (classDescriptor.getKind() == ClassKind.ENUM_ENTRY) {
            z = true;
        } else {
            z = false;
        }
        if (!getStartFromName()) {
            renderAnnotations$default(this, sb, classDescriptor, null, 2, null);
            if (!z) {
                Visibility visibility = classDescriptor.getVisibility();
                Intrinsics.checkExpressionValueIsNotNull(visibility, "klass.visibility");
                renderVisibility(visibility, sb);
            }
            if (classDescriptor.getKind() != ClassKind.INTERFACE || classDescriptor.getModality() != Modality.ABSTRACT) {
                ClassKind kind = classDescriptor.getKind();
                Intrinsics.checkExpressionValueIsNotNull(kind, "klass.kind");
                if (!kind.isSingleton() || classDescriptor.getModality() != Modality.FINAL) {
                    Modality modality = classDescriptor.getModality();
                    Intrinsics.checkExpressionValueIsNotNull(modality, "klass.modality");
                    renderModality(modality, sb, implicitModalityWithoutExtensions(classDescriptor));
                }
            }
            renderMemberModifiers(classDescriptor, sb);
            if (getModifiers().contains(DescriptorRendererModifier.INNER) && classDescriptor.isInner()) {
                z2 = true;
            } else {
                z2 = false;
            }
            renderModifier(sb, z2, DeepLinkCode.OpenAppSource.OPEN_SOURCE_INNER);
            if (getModifiers().contains(DescriptorRendererModifier.DATA) && classDescriptor.isData()) {
                z3 = true;
            } else {
                z3 = false;
            }
            renderModifier(sb, z3, "data");
            if (getModifiers().contains(DescriptorRendererModifier.INLINE) && classDescriptor.isInline()) {
                z4 = true;
            } else {
                z4 = false;
            }
            renderModifier(sb, z4, "inline");
            renderClassKindPrefix(classDescriptor, sb);
        }
        if (!DescriptorUtils.isCompanionObject(classDescriptor)) {
            if (!getStartFromName()) {
                renderSpaceIfNeeded(sb);
            }
            renderName(classDescriptor, sb, true);
        } else {
            renderCompanionObjectName(classDescriptor, sb);
        }
        if (z) {
            return;
        }
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(declaredTypeParameters, "klass.declaredTypeParameters");
        renderTypeParameters(declaredTypeParameters, sb, false);
        renderCapturedTypeParametersIfRequired(classDescriptor, sb);
        ClassKind kind2 = classDescriptor.getKind();
        Intrinsics.checkExpressionValueIsNotNull(kind2, "klass.kind");
        if (!kind2.isSingleton() && getClassWithPrimaryConstructor() && (mo2095getUnsubstitutedPrimaryConstructor = classDescriptor.mo2095getUnsubstitutedPrimaryConstructor()) != null) {
            sb.append(" ");
            renderAnnotations$default(this, sb, mo2095getUnsubstitutedPrimaryConstructor, null, 2, null);
            Visibility visibility2 = mo2095getUnsubstitutedPrimaryConstructor.getVisibility();
            Intrinsics.checkExpressionValueIsNotNull(visibility2, "primaryConstructor.visibility");
            renderVisibility(visibility2, sb);
            sb.append(renderKeyword("constructor"));
            List<ValueParameterDescriptor> valueParameters = mo2095getUnsubstitutedPrimaryConstructor.getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(valueParameters, "primaryConstructor.valueParameters");
            renderValueParameters(valueParameters, mo2095getUnsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb);
        }
        renderSuperTypes(classDescriptor, sb);
        renderWhereSuffix(declaredTypeParameters, sb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String renderConstant(ConstantValue<?> constantValue) {
        if (constantValue instanceof ArrayValue) {
            return CollectionsKt___CollectionsKt.joinToString$default(((ArrayValue) constantValue).getValue(), StringUtil.ARRAY_ELEMENT_SEPARATOR, "{", "}", 0, null, new Function1<ConstantValue<?>, String>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstant$1
                {
                    super(1);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(ConstantValue<?> constantValue2) {
                    String renderConstant;
                    renderConstant = DescriptorRendererImpl.this.renderConstant(constantValue2);
                    return renderConstant;
                }
            }, 24, null);
        }
        if (constantValue instanceof AnnotationValue) {
            return StringsKt__StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, ((AnnotationValue) constantValue).getValue(), null, 2, null), (CharSequence) "@");
        }
        if (constantValue instanceof KClassValue) {
            KClassValue.Value value = ((KClassValue) constantValue).getValue();
            if (value instanceof KClassValue.Value.LocalClass) {
                return ((KClassValue.Value.LocalClass) value).getType() + "::class";
            } else if (value instanceof KClassValue.Value.NormalClass) {
                KClassValue.Value.NormalClass normalClass = (KClassValue.Value.NormalClass) value;
                String asString = normalClass.getClassId().asSingleFqName().asString();
                Intrinsics.checkExpressionValueIsNotNull(asString, "classValue.classId.asSingleFqName().asString()");
                for (int i = 0; i < normalClass.getArrayDimensions(); i++) {
                    asString = "kotlin.Array<" + asString + '>';
                }
                return asString + "::class";
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return constantValue.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0029, code lost:
        if (r0.getModality() != kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void renderConstructor(ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
        boolean z;
        boolean z2;
        ClassConstructorDescriptor mo2095getUnsubstitutedPrimaryConstructor;
        ArrayList arrayList;
        boolean z3;
        renderAnnotations$default(this, sb, constructorDescriptor, null, 2, null);
        if (!this.options.getRenderDefaultVisibility()) {
            ClassDescriptor constructedClass = constructorDescriptor.getConstructedClass();
            Intrinsics.checkExpressionValueIsNotNull(constructedClass, "constructor.constructedClass");
        }
        Visibility visibility = constructorDescriptor.getVisibility();
        Intrinsics.checkExpressionValueIsNotNull(visibility, "constructor.visibility");
        if (renderVisibility(visibility, sb)) {
            z = true;
            renderMemberKind(constructorDescriptor, sb);
            if (getRenderConstructorKeyword() && constructorDescriptor.isPrimary() && !z) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                sb.append(renderKeyword("constructor"));
            }
            ClassifierDescriptorWithTypeParameters containingDeclaration = constructorDescriptor.getContainingDeclaration();
            Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "constructor.containingDeclaration");
            if (getSecondaryConstructorsAsPrimary()) {
                if (z2) {
                    sb.append(" ");
                }
                renderName(containingDeclaration, sb, true);
                List<TypeParameterDescriptor> typeParameters = constructorDescriptor.getTypeParameters();
                Intrinsics.checkExpressionValueIsNotNull(typeParameters, "constructor.typeParameters");
                renderTypeParameters(typeParameters, sb, false);
            }
            List<ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(valueParameters, "constructor.valueParameters");
            renderValueParameters(valueParameters, constructorDescriptor.hasSynthesizedParameterNames(), sb);
            if (getRenderConstructorDelegation() && !constructorDescriptor.isPrimary() && (containingDeclaration instanceof ClassDescriptor) && (mo2095getUnsubstitutedPrimaryConstructor = ((ClassDescriptor) containingDeclaration).mo2095getUnsubstitutedPrimaryConstructor()) != null) {
                List<ValueParameterDescriptor> valueParameters2 = mo2095getUnsubstitutedPrimaryConstructor.getValueParameters();
                Intrinsics.checkExpressionValueIsNotNull(valueParameters2, "primaryConstructor.valueParameters");
                arrayList = new ArrayList();
                for (Object obj : valueParameters2) {
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) obj;
                    if (!valueParameterDescriptor.declaresDefaultValue() && valueParameterDescriptor.getVarargElementType() == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                    sb.append(renderKeyword("this"));
                    sb.append(CollectionsKt___CollectionsKt.joinToString$default(arrayList, StringUtil.ARRAY_ELEMENT_SEPARATOR, "(", SmallTailInfo.EMOTION_SUFFIX, 0, null, new Function1<ValueParameterDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstructor$1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function1
                        public final String invoke(ValueParameterDescriptor valueParameterDescriptor2) {
                            return "";
                        }
                    }, 24, null));
                }
            }
            if (!getSecondaryConstructorsAsPrimary()) {
                List<TypeParameterDescriptor> typeParameters2 = constructorDescriptor.getTypeParameters();
                Intrinsics.checkExpressionValueIsNotNull(typeParameters2, "constructor.typeParameters");
                renderWhereSuffix(typeParameters2, sb);
                return;
            }
            return;
        }
        z = false;
        renderMemberKind(constructorDescriptor, sb);
        if (getRenderConstructorKeyword()) {
        }
        z2 = true;
        if (z2) {
        }
        ClassifierDescriptorWithTypeParameters containingDeclaration2 = constructorDescriptor.getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(containingDeclaration2, "constructor.containingDeclaration");
        if (getSecondaryConstructorsAsPrimary()) {
        }
        List<ValueParameterDescriptor> valueParameters3 = constructorDescriptor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(valueParameters3, "constructor.valueParameters");
        renderValueParameters(valueParameters3, constructorDescriptor.hasSynthesizedParameterNames(), sb);
        if (getRenderConstructorDelegation()) {
            List<ValueParameterDescriptor> valueParameters22 = mo2095getUnsubstitutedPrimaryConstructor.getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(valueParameters22, "primaryConstructor.valueParameters");
            arrayList = new ArrayList();
            while (r0.hasNext()) {
            }
            if (!arrayList.isEmpty()) {
            }
        }
        if (!getSecondaryConstructorsAsPrimary()) {
        }
    }

    private final void renderFunctionType(StringBuilder sb, KotlinType kotlinType) {
        boolean z;
        boolean z2;
        Name name;
        boolean z3;
        int length = sb.length();
        renderAnnotations$default(getFunctionTypeAnnotationsRenderer(), sb, kotlinType, null, 2, null);
        boolean z4 = true;
        if (sb.length() != length) {
            z = true;
        } else {
            z = false;
        }
        boolean isSuspendFunctionType = FunctionTypesKt.isSuspendFunctionType(kotlinType);
        boolean isMarkedNullable = kotlinType.isMarkedNullable();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        if (!isMarkedNullable && (!z || receiverTypeFromFunctionType == null)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            if (isSuspendFunctionType) {
                sb.insert(length, '(');
            } else {
                if (z) {
                    if (StringsKt___StringsKt.last(sb) == ' ') {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (_Assertions.ENABLED && !z3) {
                        throw new AssertionError("Assertion failed");
                    }
                    if (sb.charAt(StringsKt__StringsKt.getLastIndex(sb) - 1) != ')') {
                        sb.insert(StringsKt__StringsKt.getLastIndex(sb), "()");
                    }
                }
                sb.append("(");
            }
        }
        renderModifier(sb, isSuspendFunctionType, DownloadStatisticConstants.UBC_TYPE_SUSPEND);
        if (receiverTypeFromFunctionType != null) {
            if ((!shouldRenderAsPrettyFunctionType(receiverTypeFromFunctionType) || receiverTypeFromFunctionType.isMarkedNullable()) && !hasModifiersOrAnnotations(receiverTypeFromFunctionType)) {
                z4 = false;
            }
            if (z4) {
                sb.append("(");
            }
            renderNormalizedType(sb, receiverTypeFromFunctionType);
            if (z4) {
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            sb.append(".");
        }
        sb.append("(");
        int i = 0;
        for (TypeProjection typeProjection : FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType)) {
            if (i > 0) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (getParameterNamesInFunctionalTypes()) {
                KotlinType type = typeProjection.getType();
                Intrinsics.checkExpressionValueIsNotNull(type, "typeProjection.type");
                name = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type);
            } else {
                name = null;
            }
            if (name != null) {
                sb.append(renderName(name, false));
                sb.append(": ");
            }
            sb.append(getFunctionTypeParameterTypesRenderer().renderTypeProjection(typeProjection));
            i++;
        }
        sb.append(") ");
        sb.append(arrow());
        sb.append(" ");
        renderNormalizedType(sb, FunctionTypesKt.getReturnTypeFromFunctionType(kotlinType));
        if (z2) {
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
        }
        if (isMarkedNullable) {
            sb.append("?");
        }
    }

    private final String renderKeyword(String str) {
        int i = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (!getBoldOnlyForNamesInHtml()) {
                    return "<b>" + str + "</b>";
                }
                return str;
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    private final boolean shouldRenderAsPrettyFunctionType(KotlinType kotlinType) {
        boolean z;
        if (!FunctionTypesKt.isBuiltinFunctionalType(kotlinType)) {
            return false;
        }
        List<TypeProjection> arguments = kotlinType.getArguments();
        if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
            for (TypeProjection typeProjection : arguments) {
                if (typeProjection.isStarProjection()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (!z) {
            return false;
        }
        return true;
    }

    public String renderTypeConstructor(TypeConstructor typeConstructor) {
        ClassifierDescriptor mo2101getDeclarationDescriptor = typeConstructor.mo2101getDeclarationDescriptor();
        if ((mo2101getDeclarationDescriptor instanceof TypeParameterDescriptor) || (mo2101getDeclarationDescriptor instanceof ClassDescriptor) || (mo2101getDeclarationDescriptor instanceof TypeAliasDescriptor)) {
            return renderClassifierName(mo2101getDeclarationDescriptor);
        }
        if (mo2101getDeclarationDescriptor == null) {
            return typeConstructor.toString();
        }
        throw new IllegalStateException(("Unexpected classifier: " + mo2101getDeclarationDescriptor.getClass()).toString());
    }

    private final void renderMemberKind(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) && getVerbose() && callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.DECLARATION) {
            sb.append(ResourceConstants.EXT_CMT_START);
            String name = callableMemberDescriptor.getKind().name();
            if (name != null) {
                String lowerCase = name.toLowerCase();
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
                sb.append(lowerCase);
                sb.append("*/ ");
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    private final void renderMemberModifiers(MemberDescriptor memberDescriptor, StringBuilder sb) {
        boolean z;
        renderModifier(sb, memberDescriptor.isExternal(), LaunchStatsUtils.EXTERNAL_LAUNCH);
        boolean z2 = true;
        if (getModifiers().contains(DescriptorRendererModifier.EXPECT) && memberDescriptor.isExpect()) {
            z = true;
        } else {
            z = false;
        }
        renderModifier(sb, z, "expect");
        renderModifier(sb, (getModifiers().contains(DescriptorRendererModifier.ACTUAL) && memberDescriptor.isActual()) ? false : false, "actual");
    }

    private final void renderModalityForCallable(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (!DescriptorUtils.isTopLevelDeclaration(callableMemberDescriptor) || callableMemberDescriptor.getModality() != Modality.FINAL) {
            if (getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OVERRIDE && callableMemberDescriptor.getModality() == Modality.OPEN && overridesSomething(callableMemberDescriptor)) {
                return;
            }
            Modality modality = callableMemberDescriptor.getModality();
            Intrinsics.checkExpressionValueIsNotNull(modality, "callable.modality");
            renderModality(modality, sb, implicitModalityWithoutExtensions(callableMemberDescriptor));
        }
    }

    private final void renderNormalizedTypeAsIs(StringBuilder sb, KotlinType kotlinType) {
        if ((kotlinType instanceof WrappedType) && getDebugMode() && !((WrappedType) kotlinType).isComputed()) {
            sb.append("<Not computed yet>");
            return;
        }
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            sb.append(((FlexibleType) unwrap).render(this, this));
        } else if (unwrap instanceof SimpleType) {
            renderSimpleType(sb, (SimpleType) unwrap);
        }
    }

    private final void renderOverride(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) && overridesSomething(callableMemberDescriptor) && getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OPEN) {
            renderModifier(sb, true, "override");
            if (getVerbose()) {
                sb.append(ResourceConstants.EXT_CMT_START);
                sb.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                sb.append("*/ ");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r3 != null) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void renderPossiblyInnerType(StringBuilder sb, PossiblyInnerType possiblyInnerType) {
        PossiblyInnerType outerType = possiblyInnerType.getOuterType();
        if (outerType != null) {
            renderPossiblyInnerType(sb, outerType);
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            Name name = possiblyInnerType.getClassifierDescriptor().getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(renderName(name, false));
        }
        TypeConstructor typeConstructor = possiblyInnerType.getClassifierDescriptor().getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "possiblyInnerType.classi…escriptor.typeConstructor");
        sb.append(renderTypeConstructor(typeConstructor));
        sb.append(renderTypeArguments(possiblyInnerType.getArguments()));
    }

    private final void renderReceiver(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            renderAnnotations(sb, extensionReceiverParameter, AnnotationUseSiteTarget.RECEIVER);
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "receiver.type");
            String renderType = renderType(type);
            if (shouldRenderAsPrettyFunctionType(type) && !TypeUtils.isNullableType(type)) {
                renderType = '(' + renderType + ')';
            }
            sb.append(renderType);
            sb.append(".");
        }
    }

    private final boolean renderVisibility(Visibility visibility, StringBuilder sb) {
        if (!getModifiers().contains(DescriptorRendererModifier.VISIBILITY)) {
            return false;
        }
        if (getNormalizedVisibilities()) {
            visibility = visibility.normalize();
        }
        if (!getRenderDefaultVisibility() && Intrinsics.areEqual(visibility, Visibilities.DEFAULT_VISIBILITY)) {
            return false;
        }
        sb.append(renderKeyword(visibility.getInternalDisplayName()));
        sb.append(" ");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderTypeParameter(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb, boolean z) {
        boolean z2;
        if (z) {
            sb.append(lt());
        }
        if (getVerbose()) {
            sb.append(ResourceConstants.EXT_CMT_START);
            sb.append(typeParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        renderModifier(sb, typeParameterDescriptor.isReified(), "reified");
        String label = typeParameterDescriptor.getVariance().getLabel();
        boolean z3 = true;
        if (label.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        renderModifier(sb, z2, label);
        renderAnnotations$default(this, sb, typeParameterDescriptor, null, 2, null);
        renderName(typeParameterDescriptor, sb, z);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z) || size == 1) {
            KotlinType upperBound = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (!KotlinBuiltIns.isDefaultBound(upperBound)) {
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                Intrinsics.checkExpressionValueIsNotNull(upperBound, "upperBound");
                sb.append(renderType(upperBound));
            }
        } else if (z) {
            for (KotlinType upperBound2 : typeParameterDescriptor.getUpperBounds()) {
                if (!KotlinBuiltIns.isDefaultBound(upperBound2)) {
                    if (z3) {
                        sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                    } else {
                        sb.append(" & ");
                    }
                    Intrinsics.checkExpressionValueIsNotNull(upperBound2, "upperBound");
                    sb.append(renderType(upperBound2));
                    z3 = false;
                }
            }
        }
        if (z) {
            sb.append(gt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void renderValueParameter(ValueParameterDescriptor valueParameterDescriptor, boolean z, StringBuilder sb, boolean z2) {
        boolean z3;
        boolean declaresOrInheritsDefaultValue;
        if (z2) {
            sb.append(renderKeyword("value-parameter"));
            sb.append(" ");
        }
        if (getVerbose()) {
            sb.append(ResourceConstants.EXT_CMT_START);
            sb.append(valueParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        renderAnnotations$default(this, sb, valueParameterDescriptor, null, 2, null);
        renderModifier(sb, valueParameterDescriptor.isCrossinline(), "crossinline");
        renderModifier(sb, valueParameterDescriptor.isNoinline(), "noinline");
        boolean z4 = false;
        if (getRenderPrimaryConstructorParametersAsProperties()) {
            CallableDescriptor containingDeclaration = valueParameterDescriptor.getContainingDeclaration();
            if (!(containingDeclaration instanceof ClassConstructorDescriptor)) {
                containingDeclaration = null;
            }
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) containingDeclaration;
            if (classConstructorDescriptor != null && classConstructorDescriptor.isPrimary()) {
                z3 = true;
                if (z3) {
                    renderModifier(sb, getActualPropertiesInPrimaryConstructor(), "actual");
                }
                renderVariable(valueParameterDescriptor, z, sb, z2, z3);
                if (getDefaultParameterValueRenderer() != null) {
                    if (getDebugMode()) {
                        declaresOrInheritsDefaultValue = valueParameterDescriptor.declaresDefaultValue();
                    } else {
                        declaresOrInheritsDefaultValue = DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor);
                    }
                    if (declaresOrInheritsDefaultValue) {
                        z4 = true;
                    }
                }
                if (!z4) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" = ");
                    Function1<ValueParameterDescriptor, String> defaultParameterValueRenderer = getDefaultParameterValueRenderer();
                    if (defaultParameterValueRenderer == null) {
                        Intrinsics.throwNpe();
                    }
                    sb2.append(defaultParameterValueRenderer.invoke(valueParameterDescriptor));
                    sb.append(sb2.toString());
                    return;
                }
                return;
            }
        }
        z3 = false;
        if (z3) {
        }
        renderVariable(valueParameterDescriptor, z, sb, z2, z3);
        if (getDefaultParameterValueRenderer() != null) {
        }
        if (!z4) {
        }
    }

    private final void renderValueParameters(Collection<? extends ValueParameterDescriptor> collection, boolean z, StringBuilder sb) {
        boolean shouldRenderParameterNames = shouldRenderParameterNames(z);
        int size = collection.size();
        getValueParametersHandler().appendBeforeValueParameters(size, sb);
        int i = 0;
        for (ValueParameterDescriptor valueParameterDescriptor : collection) {
            getValueParametersHandler().appendBeforeValueParameter(valueParameterDescriptor, i, size, sb);
            renderValueParameter(valueParameterDescriptor, shouldRenderParameterNames, sb, false);
            getValueParametersHandler().appendAfterValueParameter(valueParameterDescriptor, i, size, sb);
            i++;
        }
        getValueParametersHandler().appendAfterValueParameters(size, sb);
    }

    private final void renderVariable(VariableDescriptor variableDescriptor, boolean z, StringBuilder sb, boolean z2, boolean z3) {
        VariableDescriptor variableDescriptor2;
        KotlinType kotlinType;
        boolean z4;
        KotlinType type = variableDescriptor.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "variable.type");
        KotlinType kotlinType2 = null;
        if (!(variableDescriptor instanceof ValueParameterDescriptor)) {
            variableDescriptor2 = null;
        } else {
            variableDescriptor2 = variableDescriptor;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) variableDescriptor2;
        if (valueParameterDescriptor != null) {
            kotlinType2 = valueParameterDescriptor.getVarargElementType();
        }
        if (kotlinType2 != null) {
            kotlinType = kotlinType2;
        } else {
            kotlinType = type;
        }
        if (kotlinType2 != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        renderModifier(sb, z4, "vararg");
        if (z3 || (z2 && !getStartFromName())) {
            renderValVarPrefix(variableDescriptor, sb, z3);
        }
        if (z) {
            renderName(variableDescriptor, sb, z2);
            sb.append(": ");
        }
        sb.append(renderType(kotlinType));
        renderInitializer(variableDescriptor, sb);
        if (getVerbose() && kotlinType2 != null) {
            sb.append(" /*");
            sb.append(renderType(type));
            sb.append(ResourceConstants.EXT_CMT_END);
        }
    }

    private final String replacePrefixes(String str, String str2, String str3, String str4, String str5) {
        if (StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, null) && StringsKt__StringsJVMKt.startsWith$default(str3, str4, false, 2, null)) {
            int length = str2.length();
            if (str != null) {
                String substring = str.substring(length);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                int length2 = str4.length();
                if (str3 != null) {
                    String substring2 = str3.substring(length2);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                    String str6 = str5 + substring;
                    if (Intrinsics.areEqual(substring, substring2)) {
                        return str6;
                    }
                    if (differsOnlyInNullability(substring, substring2)) {
                        return str6 + '!';
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderFlexibleType(String str, String str2, KotlinBuiltIns kotlinBuiltIns) {
        if (differsOnlyInNullability(str, str2)) {
            if (StringsKt__StringsJVMKt.startsWith$default(str2, "(", false, 2, null)) {
                return '(' + str + ")!";
            }
            return str + '!';
        }
        ClassifierNamePolicy classifierNamePolicy = getClassifierNamePolicy();
        ClassDescriptor collection = kotlinBuiltIns.getCollection();
        Intrinsics.checkExpressionValueIsNotNull(collection, "builtIns.collection");
        String substringBefore$default = StringsKt__StringsKt.substringBefore$default(classifierNamePolicy.renderClassifier(collection, this), "Collection", (String) null, 2, (Object) null);
        String replacePrefixes = replacePrefixes(str, substringBefore$default + "Mutable", str2, substringBefore$default, substringBefore$default + "(Mutable)");
        if (replacePrefixes != null) {
            return replacePrefixes;
        }
        String replacePrefixes2 = replacePrefixes(str, substringBefore$default + "MutableMap.MutableEntry", str2, substringBefore$default + "Map.Entry", substringBefore$default + "(Mutable)Map.(Mutable)Entry");
        if (replacePrefixes2 != null) {
            return replacePrefixes2;
        }
        ClassifierNamePolicy classifierNamePolicy2 = getClassifierNamePolicy();
        ClassDescriptor array = kotlinBuiltIns.getArray();
        Intrinsics.checkExpressionValueIsNotNull(array, "builtIns.array");
        String substringBefore$default2 = StringsKt__StringsKt.substringBefore$default(classifierNamePolicy2.renderClassifier(array, this), "Array", (String) null, 2, (Object) null);
        String replacePrefixes3 = replacePrefixes(str, substringBefore$default2 + escape("Array<"), str2, substringBefore$default2 + escape("Array<out "), substringBefore$default2 + escape("Array<(out) "));
        if (replacePrefixes3 != null) {
            return replacePrefixes3;
        }
        return '(' + str + IStringUtil.TOP_PATH + str2 + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderFqName(FqNameUnsafe fqNameUnsafe) {
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkExpressionValueIsNotNull(pathSegments, "fqName.pathSegments()");
        return renderFqName(pathSegments);
    }
}

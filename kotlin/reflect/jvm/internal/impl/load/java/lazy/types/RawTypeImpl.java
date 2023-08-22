package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes2.dex */
public final class RawTypeImpl extends FlexibleType implements RawType {
    public RawTypeImpl(SimpleType simpleType, SimpleType simpleType2) {
        this(simpleType, simpleType2, false);
    }

    public RawTypeImpl(SimpleType simpleType, SimpleType simpleType2, boolean z) {
        super(simpleType, simpleType2);
        if (!z) {
            boolean isSubtypeOf = KotlinTypeChecker.DEFAULT.isSubtypeOf(simpleType, simpleType2);
            if (_Assertions.ENABLED && !isSubtypeOf) {
                throw new AssertionError("Lower bound " + simpleType + " of a flexible type must be a subtype of the upper bound " + simpleType2);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public SimpleType getDelegate() {
        return getLowerBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        ClassifierDescriptor mo2104getDeclarationDescriptor = getConstructor().mo2104getDeclarationDescriptor();
        if (!(mo2104getDeclarationDescriptor instanceof ClassDescriptor)) {
            mo2104getDeclarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) mo2104getDeclarationDescriptor;
        if (classDescriptor != null) {
            MemberScope memberScope = classDescriptor.getMemberScope(RawSubstitution.INSTANCE);
            Intrinsics.checkExpressionValueIsNotNull(memberScope, "classDescriptor.getMemberScope(RawSubstitution)");
            return memberScope;
        }
        throw new IllegalStateException(("Incorrect classifier: " + getConstructor().mo2104getDeclarationDescriptor()).toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public RawTypeImpl makeNullableAsSpecified(boolean z) {
        return new RawTypeImpl(getLowerBound().makeNullableAsSpecified(z), getUpperBound().makeNullableAsSpecified(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public FlexibleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        KotlinType refineType = kotlinTypeRefiner.refineType(getLowerBound());
        if (refineType != null) {
            SimpleType simpleType = (SimpleType) refineType;
            KotlinType refineType2 = kotlinTypeRefiner.refineType(getUpperBound());
            if (refineType2 != null) {
                return new RawTypeImpl(simpleType, (SimpleType) refineType2, true);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public RawTypeImpl replaceAnnotations(Annotations annotations) {
        return new RawTypeImpl(getLowerBound().replaceAnnotations(annotations), getUpperBound().replaceAnnotations(annotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(final DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        RawTypeImpl$render$1 rawTypeImpl$render$1 = RawTypeImpl$render$1.INSTANCE;
        Function1<KotlinType, List<? extends String>> function1 = new Function1<KotlinType, List<? extends String>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl$render$2
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final List<String> invoke(KotlinType kotlinType) {
                List<TypeProjection> arguments = kotlinType.getArguments();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10));
                for (TypeProjection typeProjection : arguments) {
                    arrayList.add(DescriptorRenderer.this.renderTypeProjection(typeProjection));
                }
                return arrayList;
            }
        };
        RawTypeImpl$render$3 rawTypeImpl$render$3 = RawTypeImpl$render$3.INSTANCE;
        String renderType = descriptorRenderer.renderType(getLowerBound());
        String renderType2 = descriptorRenderer.renderType(getUpperBound());
        if (descriptorRendererOptions.getDebugMode()) {
            return "raw (" + renderType + IStringUtil.TOP_PATH + renderType2 + ')';
        } else if (getUpperBound().getArguments().isEmpty()) {
            return descriptorRenderer.renderFlexibleType(renderType, renderType2, TypeUtilsKt.getBuiltIns(this));
        } else {
            List<String> invoke = function1.invoke((KotlinType) getLowerBound());
            List<String> invoke2 = function1.invoke((KotlinType) getUpperBound());
            String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(invoke, StringUtil.ARRAY_ELEMENT_SEPARATOR, null, null, 0, null, new Function1<String, String>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl$render$newArgs$1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(String str) {
                    return "(raw) " + str;
                }
            }, 30, null);
            List zip = CollectionsKt___CollectionsKt.zip(invoke, invoke2);
            boolean z = true;
            if (!(zip instanceof Collection) || !zip.isEmpty()) {
                Iterator it = zip.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    if (!RawTypeImpl$render$1.INSTANCE.invoke2((String) pair.getFirst(), (String) pair.getSecond())) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                renderType2 = rawTypeImpl$render$3.invoke(renderType2, joinToString$default);
            }
            String invoke3 = rawTypeImpl$render$3.invoke(renderType, joinToString$default);
            if (Intrinsics.areEqual(invoke3, renderType2)) {
                return invoke3;
            }
            return descriptorRenderer.renderFlexibleType(invoke3, renderType2, TypeUtilsKt.getBuiltIns(this));
        }
    }
}

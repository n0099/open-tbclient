package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
/* loaded from: classes9.dex */
public final class PredefinedEnhancementInfoKt {
    public static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    public static final JavaTypeQualifiers NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    public static final JavaTypeQualifiers NOT_PLATFORM = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, false, false, 8, null);
    public static final JavaTypeQualifiers NOT_NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, true, false, 8, null);

    static {
        final SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        final String javaLang = signatureBuildingComponents.javaLang("Object");
        final String javaFunction = signatureBuildingComponents.javaFunction("Predicate");
        final String javaFunction2 = signatureBuildingComponents.javaFunction("Function");
        final String javaFunction3 = signatureBuildingComponents.javaFunction("Consumer");
        final String javaFunction4 = signatureBuildingComponents.javaFunction("BiFunction");
        final String javaFunction5 = signatureBuildingComponents.javaFunction("BiConsumer");
        final String javaFunction6 = signatureBuildingComponents.javaFunction("UnaryOperator");
        final String javaUtil = signatureBuildingComponents.javaUtil("stream/Stream");
        final String javaUtil2 = signatureBuildingComponents.javaUtil("Optional");
        SignatureEnhancementBuilder signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureBuildingComponents.javaUtil("Iterator")).function("forEachRemaining", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                String str = javaFunction3;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureBuildingComponents.javaLang("Iterable")).function("spliterator", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                String javaUtil3 = SignatureBuildingComponents.this.javaUtil("Spliterator");
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(javaUtil3, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureBuildingComponents.javaUtil("Collection"));
        classEnhancementBuilder.function("removeIf", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                String str = javaFunction;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers2);
                functionEnhancementBuilder.returns(JvmPrimitiveType.BOOLEAN);
            }
        });
        classEnhancementBuilder.function("stream", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                String str = javaUtil;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(str, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        classEnhancementBuilder.function("parallelStream", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                String str = javaUtil;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(str, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureBuildingComponents.javaUtil("List")).function("replaceAll", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                String str = javaFunction6;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder2 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureBuildingComponents.javaUtil("Map"));
        classEnhancementBuilder2.function("forEach", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                String str = javaFunction5;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers3);
            }
        });
        classEnhancementBuilder2.function("putIfAbsent", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
                String str3 = javaLang;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.returns(str3, javaTypeQualifiers3);
            }
        });
        classEnhancementBuilder2.function(StickerDataChangeType.REPLACE, new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
                String str3 = javaLang;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.returns(str3, javaTypeQualifiers3);
            }
        });
        classEnhancementBuilder2.function(StickerDataChangeType.REPLACE, new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
                String str3 = javaLang;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str3, javaTypeQualifiers3);
                functionEnhancementBuilder.returns(JvmPrimitiveType.BOOLEAN);
            }
        });
        classEnhancementBuilder2.function("replaceAll", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                JavaTypeQualifiers javaTypeQualifiers4;
                String str = javaFunction4;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers4 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers3, javaTypeQualifiers4);
            }
        });
        classEnhancementBuilder2.function("compute", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                JavaTypeQualifiers javaTypeQualifiers4;
                JavaTypeQualifiers javaTypeQualifiers5;
                JavaTypeQualifiers javaTypeQualifiers6;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaFunction4;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers4 = PredefinedEnhancementInfoKt.NULLABLE;
                javaTypeQualifiers5 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2, javaTypeQualifiers3, javaTypeQualifiers4, javaTypeQualifiers5);
                String str3 = javaLang;
                javaTypeQualifiers6 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.returns(str3, javaTypeQualifiers6);
            }
        });
        classEnhancementBuilder2.function("computeIfAbsent", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                JavaTypeQualifiers javaTypeQualifiers4;
                JavaTypeQualifiers javaTypeQualifiers5;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaFunction2;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers4 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2, javaTypeQualifiers3, javaTypeQualifiers4);
                String str3 = javaLang;
                javaTypeQualifiers5 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(str3, javaTypeQualifiers5);
            }
        });
        classEnhancementBuilder2.function("computeIfPresent", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                JavaTypeQualifiers javaTypeQualifiers4;
                JavaTypeQualifiers javaTypeQualifiers5;
                JavaTypeQualifiers javaTypeQualifiers6;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaFunction4;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers4 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                javaTypeQualifiers5 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2, javaTypeQualifiers3, javaTypeQualifiers4, javaTypeQualifiers5);
                String str3 = javaLang;
                javaTypeQualifiers6 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.returns(str3, javaTypeQualifiers6);
            }
        });
        classEnhancementBuilder2.function("merge", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                JavaTypeQualifiers javaTypeQualifiers4;
                JavaTypeQualifiers javaTypeQualifiers5;
                JavaTypeQualifiers javaTypeQualifiers6;
                JavaTypeQualifiers javaTypeQualifiers7;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
                String str3 = javaFunction4;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers4 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                javaTypeQualifiers5 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                javaTypeQualifiers6 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.parameter(str3, javaTypeQualifiers3, javaTypeQualifiers4, javaTypeQualifiers5, javaTypeQualifiers6);
                String str4 = javaLang;
                javaTypeQualifiers7 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.returns(str4, javaTypeQualifiers7);
            }
        });
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(javaUtil2);
        classEnhancementBuilder3.function(SchemeCollecter.CLASSIFY_EMPTY, new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                String str = javaUtil2;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.returns(str, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        classEnhancementBuilder3.function(MapBundleKey.MapObjKey.OBJ_OFFSET, new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaUtil2;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.returns(str2, javaTypeQualifiers2, javaTypeQualifiers3);
            }
        });
        classEnhancementBuilder3.function("ofNullable", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaUtil2;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.returns(str2, javaTypeQualifiers2, javaTypeQualifiers3);
            }
        });
        classEnhancementBuilder3.function("get", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$19
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.returns(str, javaTypeQualifiers);
            }
        });
        classEnhancementBuilder3.function("ifPresent", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$20
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                String str = javaFunction3;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureBuildingComponents.javaLang("ref/Reference")).function("get", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$21
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.returns(str, javaTypeQualifiers);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(javaFunction).function(DebugActiveUploadResult.SOURCE, new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$22
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                functionEnhancementBuilder.returns(JvmPrimitiveType.BOOLEAN);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureBuildingComponents.javaFunction("BiPredicate")).function(DebugActiveUploadResult.SOURCE, new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$23
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
                functionEnhancementBuilder.returns(JvmPrimitiveType.BOOLEAN);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(javaFunction3).function(BOSTokenRequest.ACCEPT, new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$24
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(javaFunction5).function(BOSTokenRequest.ACCEPT, new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$25
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(javaFunction2).function("apply", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$26
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(str2, javaTypeQualifiers2);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(javaFunction4).function("apply", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$27
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
                String str3 = javaLang;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(str3, javaTypeQualifiers3);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureBuildingComponents.javaFunction("Supplier")).function("get", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$28
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(str, javaTypeQualifiers);
            }
        });
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = signatureEnhancementBuilder.build();
    }

    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }
}

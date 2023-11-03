package kotlin.reflect.jvm.internal;

import androidx.core.app.NotificationCompat;
import com.baidu.webkit.sdk.WebChromeClient;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0007¢\u0006\u0004\bI\u0010JJ'\u0010\u0006\u001a\u00028\u00002\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00028\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u00028\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ3\u0010\u0011\u001a\u00028\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\f\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R0\u0010\u001c\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001a \u001b*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u00190\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR0\u0010\u001f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\t \u001b*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001e0\u001e0\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR$\u0010!\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010 0 0\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001dR0\u0010#\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\" \u001b*\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00190\u00190\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010*\u001a\u0006\u0012\u0002\b\u00030'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001c\u00100\u001a\b\u0012\u0002\b\u0003\u0018\u00010'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010)R\u0016\u00104\u001a\u0002018&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00106\u001a\u0002058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u00108\u001a\u0002058D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b8\u00107R\u0016\u00109\u001a\u0002058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u00107R\u0016\u0010:\u001a\u0002058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00107R\u0016\u0010;\u001a\u0002058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u00107R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\t0\u00198V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010%R\u0016\u0010A\u001a\u00020>8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020B0\u00198V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010%R\u0018\u0010H\u001a\u0004\u0018\u00010E8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "", "", WebChromeClient.KEY_ARG_ARRAY, NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Object;", "", "Lkotlin/reflect/KParameter;", "callAnnotationConstructor", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "Lkotlin/coroutines/Continuation;", "continuationArgument", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callDefaultMethod", "Ljava/lang/reflect/Type;", "type", "defaultPrimitiveValue", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;", "extractContinuationArgument", "()Ljava/lang/reflect/Type;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "Ljava/util/ArrayList;", "_parameters", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "_typeParameters", "getAnnotations", "()Ljava/util/List;", "annotations", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "getDefaultCaller", "defaultCaller", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "descriptor", "", "isAbstract", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "getParameters", PushConstants.PARAMS, "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "returnType", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "visibility", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public abstract class KCallableImpl<R> implements KCallable<R> {
    public final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    public final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;
    public final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
    public final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;

    public abstract Caller<?> getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller<?> getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    public abstract boolean isBound();

    public KCallableImpl() {
        ReflectProperties.LazySoftVal<List<Annotation>> lazySoft = ReflectProperties.lazySoft(new Function0<List<? extends Annotation>>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_annotations$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.List<java.lang.annotation.Annotation>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Annotation> invoke() {
                return UtilKt.computeAnnotations(KCallableImpl.this.getDescriptor());
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(lazySoft, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this._annotations = lazySoft;
        ReflectProperties.LazySoftVal<ArrayList<KParameter>> lazySoft2 = ReflectProperties.lazySoft(new Function0<ArrayList<KParameter>>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<KParameter> invoke() {
                int i;
                final CallableMemberDescriptor descriptor = KCallableImpl.this.getDescriptor();
                ArrayList<KParameter> arrayList = new ArrayList<>();
                final int i2 = 0;
                if (!KCallableImpl.this.isBound()) {
                    final ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(descriptor);
                    if (instanceReceiverParameter != null) {
                        arrayList.add(new KParameterImpl(KCallableImpl.this, 0, KParameter.Kind.INSTANCE, new Function0<ReceiverParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.1
                            {
                                super(0);
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // kotlin.jvm.functions.Function0
                            public final ReceiverParameterDescriptor invoke() {
                                return ReceiverParameterDescriptor.this;
                            }
                        }));
                        i = 1;
                    } else {
                        i = 0;
                    }
                    final ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
                    if (extensionReceiverParameter != null) {
                        arrayList.add(new KParameterImpl(KCallableImpl.this, i, KParameter.Kind.EXTENSION_RECEIVER, new Function0<ReceiverParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.2
                            {
                                super(0);
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // kotlin.jvm.functions.Function0
                            public final ReceiverParameterDescriptor invoke() {
                                return ReceiverParameterDescriptor.this;
                            }
                        }));
                        i++;
                    }
                } else {
                    i = 0;
                }
                List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
                Intrinsics.checkExpressionValueIsNotNull(valueParameters, "descriptor.valueParameters");
                int size = valueParameters.size();
                while (i2 < size) {
                    arrayList.add(new KParameterImpl(KCallableImpl.this, i, KParameter.Kind.VALUE, new Function0<ValueParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function0
                        public final ValueParameterDescriptor invoke() {
                            ValueParameterDescriptor valueParameterDescriptor = CallableMemberDescriptor.this.getValueParameters().get(i2);
                            Intrinsics.checkExpressionValueIsNotNull(valueParameterDescriptor, "descriptor.valueParameters[i]");
                            return valueParameterDescriptor;
                        }
                    }));
                    i2++;
                    i++;
                }
                if (KCallableImpl.this.isAnnotationConstructor() && (descriptor instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new Comparator<T>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$$special$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt__ComparisonsKt.compareValues(((KParameter) t).getName(), ((KParameter) t2).getName());
                        }
                    });
                }
                arrayList.trimToSize();
                return arrayList;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(lazySoft2, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this._parameters = lazySoft2;
        ReflectProperties.LazySoftVal<KTypeImpl> lazySoft3 = ReflectProperties.lazySoft(new Function0<KTypeImpl>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final KTypeImpl invoke() {
                KotlinType returnType = KCallableImpl.this.getDescriptor().getReturnType();
                if (returnType == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(returnType, "descriptor.returnType!!");
                return new KTypeImpl(returnType, new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1.1
                    {
                        super(0);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final Type invoke() {
                        Type extractContinuationArgument;
                        extractContinuationArgument = KCallableImpl.this.extractContinuationArgument();
                        if (extractContinuationArgument == null) {
                            return KCallableImpl.this.getCaller().getReturnType();
                        }
                        return extractContinuationArgument;
                    }
                });
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(lazySoft3, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this._returnType = lazySoft3;
        ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> lazySoft4 = ReflectProperties.lazySoft(new Function0<List<? extends KTypeParameterImpl>>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_typeParameters$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KTypeParameterImpl>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KTypeParameterImpl> invoke() {
                List<TypeParameterDescriptor> typeParameters = KCallableImpl.this.getDescriptor().getTypeParameters();
                Intrinsics.checkExpressionValueIsNotNull(typeParameters, "descriptor.typeParameters");
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(typeParameters, 10));
                for (TypeParameterDescriptor typeParameterDescriptor : typeParameters) {
                    arrayList.add(new KTypeParameterImpl(typeParameterDescriptor));
                }
                return arrayList;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(lazySoft4, "ReflectProperties.lazySo…KTypeParameterImpl)\n    }");
        this._typeParameters = lazySoft4;
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... objArr) {
        try {
            return (R) getCaller().call(objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<KParameter, ? extends Object> map) {
        if (isAnnotationConstructor()) {
            return callAnnotationConstructor(map);
        }
        return callDefaultMethod$kotlin_reflection(map, null);
    }

    private final R callAnnotationConstructor(Map<KParameter, ? extends Object> map) {
        Object obj;
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters, 10));
        for (KParameter kParameter : parameters) {
            if (map.containsKey(kParameter)) {
                obj = map.get(kParameter);
                if (obj == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.isOptional()) {
                obj = null;
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
            }
            arrayList.add(obj);
        }
        Caller<?> defaultCaller = getDefaultCaller();
        if (defaultCaller != null) {
            try {
                Object[] array = arrayList.toArray(new Object[0]);
                if (array != null) {
                    return (R) defaultCaller.call(array);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            } catch (IllegalAccessException e) {
                throw new IllegalCallableAccessException(e);
            }
        }
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
    }

    private final Object defaultPrimitiveValue(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            if (Intrinsics.areEqual(type, Boolean.TYPE)) {
                return Boolean.FALSE;
            }
            if (Intrinsics.areEqual(type, Character.TYPE)) {
                return Character.valueOf((char) 0);
            }
            if (Intrinsics.areEqual(type, Byte.TYPE)) {
                return Byte.valueOf((byte) 0);
            }
            if (Intrinsics.areEqual(type, Short.TYPE)) {
                return Short.valueOf((short) 0);
            }
            if (Intrinsics.areEqual(type, Integer.TYPE)) {
                return 0;
            }
            if (Intrinsics.areEqual(type, Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (Intrinsics.areEqual(type, Long.TYPE)) {
                return 0L;
            }
            if (Intrinsics.areEqual(type, Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            if (Intrinsics.areEqual(type, Void.TYPE)) {
                throw new IllegalStateException("Parameter with void type is illegal");
            }
            throw new UnsupportedOperationException("Unknown primitive: " + type);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Type extractContinuationArgument() {
        Type type;
        Type[] lowerBounds;
        CallableMemberDescriptor descriptor = getDescriptor();
        if (!(descriptor instanceof FunctionDescriptor)) {
            descriptor = null;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) descriptor;
        if (functionDescriptor == null || !functionDescriptor.isSuspend()) {
            return null;
        }
        Object lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) getCaller().getParameterTypes());
        if (!(lastOrNull instanceof ParameterizedType)) {
            lastOrNull = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) lastOrNull;
        if (parameterizedType != null) {
            type = parameterizedType.getRawType();
        } else {
            type = null;
        }
        if (!Intrinsics.areEqual(type, Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkExpressionValueIsNotNull(actualTypeArguments, "continuationType.actualTypeArguments");
        Object single = ArraysKt___ArraysKt.single(actualTypeArguments);
        if (!(single instanceof WildcardType)) {
            single = null;
        }
        WildcardType wildcardType = (WildcardType) single;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) ArraysKt___ArraysKt.first(lowerBounds);
    }

    public final R callDefaultMethod$kotlin_reflection(Map<KParameter, ? extends Object> map, Continuation<?> continuation) {
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        int i = 0;
        boolean z = false;
        int i2 = 0;
        for (KParameter kParameter : parameters) {
            if (i != 0 && i % 32 == 0) {
                arrayList2.add(Integer.valueOf(i2));
                i2 = 0;
            }
            if (map.containsKey(kParameter)) {
                arrayList.add(map.get(kParameter));
            } else if (kParameter.isOptional()) {
                arrayList.add(defaultPrimitiveValue(ReflectJvmMapping.getJavaType(kParameter.getType())));
                i2 = (1 << (i % 32)) | i2;
                z = true;
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
            }
            if (kParameter.getKind() == KParameter.Kind.VALUE) {
                i++;
            }
        }
        if (continuation != null) {
            arrayList.add(continuation);
        }
        if (!z) {
            Object[] array = arrayList.toArray(new Object[0]);
            if (array != null) {
                return call(Arrays.copyOf(array, array.length));
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        arrayList2.add(Integer.valueOf(i2));
        Caller<?> defaultCaller = getDefaultCaller();
        if (defaultCaller != null) {
            arrayList.addAll(arrayList2);
            arrayList.add(null);
            try {
                Object[] array2 = arrayList.toArray(new Object[0]);
                if (array2 != null) {
                    return (R) defaultCaller.call(array2);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            } catch (IllegalAccessException e) {
                throw new IllegalCallableAccessException(e);
            }
        }
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        List<Annotation> invoke = this._annotations.invoke();
        Intrinsics.checkExpressionValueIsNotNull(invoke, "_annotations()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        ArrayList<KParameter> invoke = this._parameters.invoke();
        Intrinsics.checkExpressionValueIsNotNull(invoke, "_parameters()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        KTypeImpl invoke = this._returnType.invoke();
        Intrinsics.checkExpressionValueIsNotNull(invoke, "_returnType()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> invoke = this._typeParameters.invoke();
        Intrinsics.checkExpressionValueIsNotNull(invoke, "_typeParameters()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        Visibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkExpressionValueIsNotNull(visibility, "descriptor.visibility");
        return UtilKt.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        if (getDescriptor().getModality() == Modality.ABSTRACT) {
            return true;
        }
        return false;
    }

    public final boolean isAnnotationConstructor() {
        if (Intrinsics.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation()) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        if (getDescriptor().getModality() == Modality.FINAL) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        if (getDescriptor().getModality() == Modality.OPEN) {
            return true;
        }
        return false;
    }
}

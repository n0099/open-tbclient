package kotlin.reflect.jvm.internal.calls;

import androidx.core.app.NotificationCompat;
import com.baidu.webkit.sdk.WebChromeClient;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0002 \u0001*\u0004\u0018\u00010\u00012\u00020\u0003:\u0001 B%\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00028\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00158V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "Ljava/lang/reflect/Member;", "M", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", WebChromeClient.KEY_ARG_ARRAY, "", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "isDefault", "Z", "getMember", "()Ljava/lang/reflect/Member;", "member", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "parameterTypes", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "descriptor", "<init>", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    public final Caller<M> caller;
    public final BoxUnboxData data;
    public final boolean isDefault;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u0000B)\u0012\u0006\u0010\n\u001a\u00020\u0001\u0012\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0086\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0086\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0003R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\tR!\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0015"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "Lkotlin/ranges/IntRange;", "component1", "()Lkotlin/ranges/IntRange;", "", "Ljava/lang/reflect/Method;", "component2", "()[Ljava/lang/reflect/Method;", "component3", "()Ljava/lang/reflect/Method;", "argumentRange", "Lkotlin/ranges/IntRange;", "getArgumentRange", "box", "Ljava/lang/reflect/Method;", "getBox", "unbox", "[Ljava/lang/reflect/Method;", "getUnbox", "<init>", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class BoxUnboxData {
        public final IntRange argumentRange;
        public final Method box;
        public final Method[] unbox;

        public BoxUnboxData(IntRange intRange, Method[] methodArr, Method method) {
            this.argumentRange = intRange;
            this.unbox = methodArr;
            this.box = method;
        }

        public final IntRange component1() {
            return this.argumentRange;
        }

        public final Method[] component2() {
            return this.unbox;
        }

        public final Method component3() {
            return this.box;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.reflect.jvm.internal.calls.Caller<? extends M extends java.lang.reflect.Member> */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
        if ((r0 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InlineClassAwareCaller(CallableMemberDescriptor callableMemberDescriptor, Caller<? extends M> caller, boolean z) {
        Method method;
        int i;
        KotlinType kotlinType;
        BoxUnboxData boxUnboxData;
        Method method2;
        Class<?> inlineClass;
        this.caller = caller;
        this.isDefault = z;
        KotlinType returnType = callableMemberDescriptor.getReturnType();
        if (returnType == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(returnType, "descriptor.returnType!!");
        Class<?> inlineClass2 = InlineClassAwareCallerKt.toInlineClass(returnType);
        if (inlineClass2 != null) {
            method = InlineClassAwareCallerKt.getBoxMethod(inlineClass2, callableMemberDescriptor);
        } else {
            method = null;
        }
        if (InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(callableMemberDescriptor)) {
            boxUnboxData = new BoxUnboxData(IntRange.Companion.getEMPTY(), new Method[0], method);
        } else {
            Caller<M> caller2 = this.caller;
            int i2 = -1;
            if (!(caller2 instanceof CallerImpl.Method.BoundStatic)) {
                if (!(callableMemberDescriptor instanceof ConstructorDescriptor)) {
                    if (callableMemberDescriptor.getDispatchReceiverParameter() != null && !(this.caller instanceof BoundCaller)) {
                        DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
                        Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "descriptor.containingDeclaration");
                        if (!InlineClassesUtilsKt.isInlineClass(containingDeclaration)) {
                            i2 = 1;
                        }
                    }
                    i2 = 0;
                }
            }
            if (this.isDefault) {
                i = 2;
            } else {
                i = 0;
            }
            ArrayList arrayList = new ArrayList();
            ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
            if (extensionReceiverParameter != null) {
                kotlinType = extensionReceiverParameter.getType();
            } else {
                kotlinType = null;
            }
            if (kotlinType != null) {
                arrayList.add(kotlinType);
            } else if (callableMemberDescriptor instanceof ConstructorDescriptor) {
                ClassDescriptor constructedClass = ((ConstructorDescriptor) callableMemberDescriptor).getConstructedClass();
                Intrinsics.checkExpressionValueIsNotNull(constructedClass, "descriptor.constructedClass");
                if (constructedClass.isInner()) {
                    DeclarationDescriptor containingDeclaration2 = constructedClass.getContainingDeclaration();
                    if (containingDeclaration2 != null) {
                        arrayList.add(((ClassDescriptor) containingDeclaration2).getDefaultType());
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    }
                }
            } else {
                DeclarationDescriptor containingDeclaration3 = callableMemberDescriptor.getContainingDeclaration();
                Intrinsics.checkExpressionValueIsNotNull(containingDeclaration3, "descriptor.containingDeclaration");
                if (containingDeclaration3 instanceof ClassDescriptor) {
                    ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration3;
                    if (classDescriptor.isInline()) {
                        arrayList.add(classDescriptor.getDefaultType());
                    }
                }
            }
            List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(valueParameters, "descriptor.valueParameters");
            for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
                arrayList.add(valueParameterDescriptor.getType());
            }
            int size = arrayList.size() + i2 + i;
            if (CallerKt.getArity(this) == size) {
                IntRange until = RangesKt___RangesKt.until(Math.max(i2, 0), arrayList.size() + i2);
                Method[] methodArr = new Method[size];
                for (int i3 = 0; i3 < size; i3++) {
                    if (until.contains(i3) && (inlineClass = InlineClassAwareCallerKt.toInlineClass((KotlinType) arrayList.get(i3 - i2))) != null) {
                        method2 = InlineClassAwareCallerKt.getUnboxMethod(inlineClass, callableMemberDescriptor);
                    } else {
                        method2 = null;
                    }
                    methodArr[i3] = method2;
                }
                boxUnboxData = new BoxUnboxData(until, methodArr, method);
            } else {
                throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + CallerKt.getArity(this) + " != " + size + "\nCalling: " + callableMemberDescriptor + "\nParameter types: " + getParameterTypes() + ")\nDefault: " + this.isDefault);
            }
        }
        this.data = boxUnboxData;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] objArr) {
        Object invoke;
        BoxUnboxData boxUnboxData = this.data;
        IntRange component1 = boxUnboxData.component1();
        Method[] component2 = boxUnboxData.component2();
        Method component3 = boxUnboxData.component3();
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        if (copyOf != null) {
            int first = component1.getFirst();
            int last = component1.getLast();
            if (first <= last) {
                while (true) {
                    Method method = component2[first];
                    Object obj = objArr[first];
                    if (method != null && obj != null) {
                        obj = method.invoke(obj, new Object[0]);
                    }
                    copyOf[first] = obj;
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
            Object call = this.caller.call(copyOf);
            if (component3 != null && (invoke = component3.invoke(null, call)) != null) {
                return invoke;
            }
            return call;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* renamed from: getMember */
    public M mo2102getMember() {
        return this.caller.mo2102getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.caller.getReturnType();
    }
}

package kotlin.reflect.jvm.internal.calls;

import androidx.core.app.NotificationCompat;
import androidx.transition.Transition;
import com.baidu.webkit.sdk.WebChromeClient;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u001f\b\u0002\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b8F@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0001\u0002\u001c\u001d¨\u0006\u001e"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", Transition.MATCH_INSTANCE_STR, "", WebChromeClient.KEY_ARG_ARRAY, "callMethod", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/reflect/Method;", "getMember", "()Ljava/lang/reflect/Method;", "member", "", "Ljava/lang/reflect/Type;", "parameterTypes", "Ljava/util/List;", "getParameterTypes", "()Ljava/util/List;", "returnType", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "unboxMethod", "Ljava/lang/reflect/Method;", "<init>", "(Ljava/lang/reflect/Method;Ljava/util/List;)V", "Bound", "Unbound", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public abstract class InternalUnderlyingValOfInlineClass implements Caller<Method> {
    public final List<Type> parameterTypes;
    public final Type returnType;
    public final Method unboxMethod;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* renamed from: getMember  reason: avoid collision after fix types in other method */
    public final Method mo2097getMember() {
        return null;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "", WebChromeClient.KEY_ARG_ARRAY, "", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Object;", "boundReceiver", "Ljava/lang/Object;", "Ljava/lang/reflect/Method;", "unboxMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Bound extends InternalUnderlyingValOfInlineClass implements BoundCaller {
        public final Object boundReceiver;

        public Bound(Method method, Object obj) {
            super(method, CollectionsKt__CollectionsKt.emptyList(), null);
            this.boundReceiver = obj;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] objArr) {
            checkArguments(objArr);
            return callMethod(this.boundReceiver, objArr);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "", WebChromeClient.KEY_ARG_ARRAY, "", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/reflect/Method;", "unboxMethod", "<init>", "(Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Unbound extends InternalUnderlyingValOfInlineClass {
        public Unbound(Method method) {
            super(method, CollectionsKt__CollectionsJVMKt.listOf(method.getDeclaringClass()), null);
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] objArr) {
            Object[] copyOfRange;
            checkArguments(objArr);
            Object obj = objArr[0];
            CallerImpl.Companion companion = CallerImpl.Companion;
            if (objArr.length <= 1) {
                copyOfRange = new Object[0];
            } else {
                copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(objArr, 1, objArr.length);
                if (copyOfRange == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            return callMethod(obj, copyOfRange);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends java.lang.reflect.Type> */
    /* JADX WARN: Multi-variable type inference failed */
    public InternalUnderlyingValOfInlineClass(Method method, List<? extends Type> list) {
        this.unboxMethod = method;
        this.parameterTypes = list;
        Class<?> returnType = method.getReturnType();
        Intrinsics.checkExpressionValueIsNotNull(returnType, "unboxMethod.returnType");
        this.returnType = returnType;
    }

    public final Object callMethod(Object obj, Object[] objArr) {
        return this.unboxMethod.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public /* synthetic */ InternalUnderlyingValOfInlineClass(Method method, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(method, list);
    }

    public void checkArguments(Object[] objArr) {
        Caller.DefaultImpls.checkArguments(this, objArr);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Type getReturnType() {
        return this.returnType;
    }
}

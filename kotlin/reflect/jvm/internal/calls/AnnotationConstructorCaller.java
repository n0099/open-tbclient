package kotlin.reflect.jvm.internal.calls;

import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.webkit.sdk.WebChromeClient;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0002$%BA\u0012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\r\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\n\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0004\b\"\u0010#J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\fR\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\n8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00198V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", WebChromeClient.KEY_ARG_ARRAY, "", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "defaultValues", "Ljava/util/List;", "Ljava/lang/Class;", "erasedParameterTypes", "jClass", "Ljava/lang/Class;", "", "getMember", "()Ljava/lang/Void;", "member", "Ljava/lang/reflect/Method;", "methods", "", "parameterNames", "Ljava/lang/reflect/Type;", "parameterTypes", "getParameterTypes", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "origin", "<init>", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "CallMode", "Origin", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class AnnotationConstructorCaller implements Caller {
    public final CallMode callMode;
    public final List<Object> defaultValues;
    public final List<Class<?>> erasedParameterTypes;
    public final Class<?> jClass;
    public final List<Method> methods;
    public final List<String> parameterNames;
    public final List<Type> parameterTypes;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public enum CallMode {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", Constant.TYPE_JAVA, "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public enum Origin {
        JAVA,
        KOTLIN
    }

    /* JADX DEBUG: Possible override for method kotlin.reflect.jvm.internal.calls.Caller.getMember()Ljava/lang/reflect/Member; */
    public Void getMember() {
        return null;
    }

    public AnnotationConstructorCaller(Class<?> cls, List<String> list, CallMode callMode, Origin origin, List<Method> list2) {
        this.jClass = cls;
        this.parameterNames = list;
        this.callMode = callMode;
        this.methods = list2;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        for (Method method : list2) {
            arrayList.add(method.getGenericReturnType());
        }
        this.parameterTypes = arrayList;
        List<Method> list3 = this.methods;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
        for (Method method2 : list3) {
            Class<?> it = method2.getReturnType();
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(it);
            if (wrapperByPrimitive != null) {
                it = wrapperByPrimitive;
            }
            arrayList2.add(it);
        }
        this.erasedParameterTypes = arrayList2;
        List<Method> list4 = this.methods;
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
        for (Method method3 : list4) {
            arrayList3.add(method3.getDefaultValue());
        }
        this.defaultValues = arrayList3;
        if (this.callMode == CallMode.POSITIONAL_CALL && origin == Origin.JAVA && (!CollectionsKt___CollectionsKt.minus(this.parameterNames, "value").isEmpty())) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AnnotationConstructorCaller(Class cls, List list, CallMode callMode, Origin origin, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, list, callMode, origin, list2);
        if ((i & 16) != 0) {
            list2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                list2.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] objArr) {
        Object transformKotlinToJvm;
        checkArguments(objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            int i3 = i2 + 1;
            if (obj != null || this.callMode != CallMode.CALL_BY_NAME) {
                transformKotlinToJvm = AnnotationConstructorCallerKt.transformKotlinToJvm(obj, this.erasedParameterTypes.get(i2));
            } else {
                transformKotlinToJvm = this.defaultValues.get(i2);
            }
            if (transformKotlinToJvm == null) {
                AnnotationConstructorCallerKt.throwIllegalArgumentType(i2, this.parameterNames.get(i2), this.erasedParameterTypes.get(i2));
                throw null;
            }
            arrayList.add(transformKotlinToJvm);
            i++;
            i2 = i3;
        }
        return AnnotationConstructorCallerKt.createAnnotationInstance(this.jClass, MapsKt__MapsKt.toMap(CollectionsKt___CollectionsKt.zip(this.parameterNames, arrayList)), this.methods);
    }

    public void checkArguments(Object[] objArr) {
        Caller.DefaultImpls.checkArguments(this, objArr);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* renamed from: getMember  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Member mo2097getMember() {
        return (Member) getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.jClass;
    }
}

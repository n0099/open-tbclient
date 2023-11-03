package kotlin.reflect.full;

import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\u001a;\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007H\u0087@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\r\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e\"&\u0010\u0013\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\u00018F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\"&\u0010\u0016\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\u00018F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010\"*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0017*\u0006\u0012\u0002\b\u00030\u00018F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"R", "Lkotlin/reflect/KCallable;", "", "", WebChromeClient.KEY_ARG_ARRAY, "callSuspend", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlin/reflect/KParameter;", "callSuspendBy", "(Lkotlin/reflect/KCallable;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "name", "findParameterByName", "(Lkotlin/reflect/KCallable;Ljava/lang/String;)Lkotlin/reflect/KParameter;", "getExtensionReceiverParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "extensionReceiverParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "extensionReceiverParameter", "getInstanceParameter", "instanceParameter$annotations", "instanceParameter", "", "getValueParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "valueParameters$annotations", "valueParameters", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "KCallables")
/* loaded from: classes2.dex */
public final class KCallables {
    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void extensionReceiverParameter$annotations(KCallable kCallable) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void instanceParameter$annotations(KCallable kCallable) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void valueParameters$annotations(KCallable kCallable) {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    @SinceKotlin(version = "1.3")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object callSuspend(KCallable<? extends R> kCallable, Object[] objArr, Continuation<? super R> continuation) {
        KCallables$callSuspend$1 kCallables$callSuspend$1;
        Object obj;
        int i;
        if (continuation instanceof KCallables$callSuspend$1) {
            kCallables$callSuspend$1 = (KCallables$callSuspend$1) continuation;
            int i2 = kCallables$callSuspend$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                kCallables$callSuspend$1.label = i2 - Integer.MIN_VALUE;
                obj = kCallables$callSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kCallables$callSuspend$1.label;
                if (i == 0) {
                    if (i == 1) {
                        Object[] objArr2 = (Object[]) kCallables$callSuspend$1.L$1;
                        kCallable = (KCallable) kCallables$callSuspend$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (!kCallable.isSuspend()) {
                        return kCallable.call(Arrays.copyOf(objArr, objArr.length));
                    }
                    if (kCallable instanceof KFunction) {
                        kCallables$callSuspend$1.L$0 = kCallable;
                        kCallables$callSuspend$1.L$1 = objArr;
                        kCallables$callSuspend$1.label = 1;
                        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                        spreadBuilder.addSpread(objArr);
                        spreadBuilder.add(kCallables$callSuspend$1);
                        obj = kCallable.call(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
                        if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(kCallables$callSuspend$1);
                        }
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot callSuspend on a property " + kCallable + ": suspend properties are not supported yet");
                    }
                }
                if (!Intrinsics.areEqual(kCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) && !kCallable.getReturnType().isMarkedNullable()) {
                    return Unit.INSTANCE;
                }
                return obj;
            }
        }
        kCallables$callSuspend$1 = new KCallables$callSuspend$1(continuation);
        obj = kCallables$callSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kCallables$callSuspend$1.label;
        if (i == 0) {
        }
        if (!Intrinsics.areEqual(kCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class))) {
        }
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    @SinceKotlin(version = "1.3")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object callSuspendBy(KCallable<? extends R> kCallable, Map<KParameter, ? extends Object> map, Continuation<? super R> continuation) {
        KCallables$callSuspendBy$1 kCallables$callSuspendBy$1;
        Object obj;
        int i;
        if (continuation instanceof KCallables$callSuspendBy$1) {
            kCallables$callSuspendBy$1 = (KCallables$callSuspendBy$1) continuation;
            int i2 = kCallables$callSuspendBy$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                kCallables$callSuspendBy$1.label = i2 - Integer.MIN_VALUE;
                obj = kCallables$callSuspendBy$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kCallables$callSuspendBy$1.label;
                if (i == 0) {
                    if (i == 1) {
                        KCallableImpl kCallableImpl = (KCallableImpl) kCallables$callSuspendBy$1.L$2;
                        Map map2 = (Map) kCallables$callSuspendBy$1.L$1;
                        kCallable = (KCallable) kCallables$callSuspendBy$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (!kCallable.isSuspend()) {
                        return kCallable.callBy(map);
                    }
                    if (kCallable instanceof KFunction) {
                        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kCallable);
                        if (asKCallableImpl != null) {
                            kCallables$callSuspendBy$1.L$0 = kCallable;
                            kCallables$callSuspendBy$1.L$1 = map;
                            kCallables$callSuspendBy$1.L$2 = asKCallableImpl;
                            kCallables$callSuspendBy$1.label = 1;
                            obj = asKCallableImpl.callDefaultMethod$kotlin_reflection(map, kCallables$callSuspendBy$1);
                            if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(kCallables$callSuspendBy$1);
                            }
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            throw new KotlinReflectionInternalError("This callable does not support a default call: " + kCallable);
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot callSuspendBy on a property " + kCallable + ": suspend properties are not supported yet");
                    }
                }
                if (!Intrinsics.areEqual(kCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) && !kCallable.getReturnType().isMarkedNullable()) {
                    return Unit.INSTANCE;
                }
                return obj;
            }
        }
        kCallables$callSuspendBy$1 = new KCallables$callSuspendBy$1(continuation);
        obj = kCallables$callSuspendBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kCallables$callSuspendBy$1.label;
        if (i == 0) {
        }
        if (!Intrinsics.areEqual(kCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class))) {
        }
        return obj;
    }

    @SinceKotlin(version = "1.1")
    public static final KParameter findParameterByName(KCallable<?> kCallable, String str) {
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        boolean z = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (Intrinsics.areEqual(((KParameter) next).getName(), str)) {
                    if (z) {
                        break;
                    }
                    z = true;
                    obj2 = next;
                }
            } else if (z) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    public static final KParameter getExtensionReceiverParameter(KCallable<?> kCallable) {
        boolean z;
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        Object obj2 = null;
        boolean z2 = false;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (z2) {
                        break;
                    }
                    obj2 = next;
                    z2 = true;
                }
            } else if (z2) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    public static final KParameter getInstanceParameter(KCallable<?> kCallable) {
        boolean z;
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        Object obj2 = null;
        boolean z2 = false;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).getKind() == KParameter.Kind.INSTANCE) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (z2) {
                        break;
                    }
                    obj2 = next;
                    z2 = true;
                }
            } else if (z2) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    public static final List<KParameter> getValueParameters(KCallable<?> kCallable) {
        boolean z;
        List<KParameter> parameters = kCallable.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((KParameter) obj).getKind() == KParameter.Kind.VALUE) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}

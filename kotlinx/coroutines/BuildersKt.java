package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, d2 = {}, k = 4, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class BuildersKt {
    public static final Deferred async(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2) {
        return BuildersKt__Builders_commonKt.async(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final Job launch(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2) {
        return BuildersKt__Builders_commonKt.launch(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tun2tornadolite.booster.Engine.prepare(java.util.List):boolean, com.baidu.tun2tornadolite.booster.Engine.start(int, java.lang.String, java.lang.String, java.lang.String):void, kotlinx.coroutines.channels.ChannelsKt__ChannelsKt.sendBlocking(kotlinx.coroutines.channels.SendChannel, java.lang.Object):void] */
    public static /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) throws InterruptedException {
        return BuildersKt__BuildersKt.runBlocking$default(coroutineContext, function2, i, obj);
    }

    public static final Object invoke(CoroutineDispatcher coroutineDispatcher, Function2 function2, Continuation continuation) {
        return BuildersKt__Builders_commonKt.invoke(coroutineDispatcher, function2, continuation);
    }

    public static final Object withContext(CoroutineContext coroutineContext, Function2 function2, Continuation continuation) {
        return BuildersKt__Builders_commonKt.withContext(coroutineContext, function2, continuation);
    }

    public static final Object runBlocking(CoroutineContext coroutineContext, Function2 function2) throws InterruptedException {
        return BuildersKt__BuildersKt.runBlocking(coroutineContext, function2);
    }
}

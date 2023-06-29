package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.SavedStateHandle;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "K", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {387, 388, 390}, m = "invokeSuspend", n = {"$this$produce", SavedStateHandle.KEYS, "$this$produce", SavedStateHandle.KEYS, "e", "$this$produce", SavedStateHandle.KEYS, "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
/* loaded from: classes2.dex */
public final class ChannelsKt__DeprecatedKt$distinctBy$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function2<E, Continuation<? super K>, Object> $selector;
    public final /* synthetic */ ReceiveChannel<E> $this_distinctBy;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super K>, ? extends java.lang.Object> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$distinctBy$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$distinctBy$1> continuation) {
        super(2, continuation);
        this.$this_distinctBy = receiveChannel;
        this.$selector = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, continuation);
        channelsKt__DeprecatedKt$distinctBy$1.L$0 = obj;
        return channelsKt__DeprecatedKt$distinctBy$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Type inference failed for r8v1. Raw type applied. Possible types: kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super K>, java.lang.Object>, kotlin.jvm.functions.Function2 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d8  */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00c5 -> B:29:0x00cb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d2 -> B:13:0x0071). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        ChannelsKt__DeprecatedKt$distinctBy$1<E> channelsKt__DeprecatedKt$distinctBy$1;
        HashSet hashSet;
        ChannelIterator<E> channelIterator;
        ProducerScope producerScope2;
        HashSet hashSet2;
        E e;
        ChannelIterator<E> channelIterator2;
        Object obj2;
        ChannelsKt__DeprecatedKt$distinctBy$1<E> channelsKt__DeprecatedKt$distinctBy$12;
        ProducerScope producerScope3;
        HashSet hashSet3;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        Object obj3 = this.L$3;
                        channelIterator2 = (ChannelIterator) this.L$2;
                        HashSet hashSet4 = (HashSet) this.L$1;
                        ProducerScope producerScope4 = (ProducerScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        channelsKt__DeprecatedKt$distinctBy$1 = this;
                        hashSet4.add(obj3);
                        channelIterator = channelIterator2;
                        hashSet = hashSet4;
                        producerScope = producerScope4;
                        channelsKt__DeprecatedKt$distinctBy$1.L$0 = producerScope;
                        channelsKt__DeprecatedKt$distinctBy$1.L$1 = hashSet;
                        channelsKt__DeprecatedKt$distinctBy$1.L$2 = channelIterator;
                        channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
                        channelsKt__DeprecatedKt$distinctBy$1.label = 1;
                        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj4 = coroutine_suspended;
                        channelsKt__DeprecatedKt$distinctBy$12 = channelsKt__DeprecatedKt$distinctBy$1;
                        obj = hasNext;
                        producerScope3 = producerScope;
                        hashSet3 = hashSet;
                        channelIterator2 = channelIterator;
                        obj2 = obj4;
                        if (!((Boolean) obj).booleanValue()) {
                            E next = channelIterator2.next();
                            Function2 function2 = channelsKt__DeprecatedKt$distinctBy$12.$selector;
                            channelsKt__DeprecatedKt$distinctBy$12.L$0 = producerScope3;
                            channelsKt__DeprecatedKt$distinctBy$12.L$1 = hashSet3;
                            channelsKt__DeprecatedKt$distinctBy$12.L$2 = channelIterator2;
                            channelsKt__DeprecatedKt$distinctBy$12.L$3 = next;
                            channelsKt__DeprecatedKt$distinctBy$12.label = 2;
                            Object invoke = function2.invoke(next, channelsKt__DeprecatedKt$distinctBy$12);
                            if (invoke == obj2) {
                                return obj2;
                            }
                            HashSet hashSet5 = hashSet3;
                            e = next;
                            obj = invoke;
                            producerScope2 = producerScope3;
                            hashSet2 = hashSet5;
                            if (hashSet2.contains(obj)) {
                                channelsKt__DeprecatedKt$distinctBy$12.L$0 = producerScope2;
                                channelsKt__DeprecatedKt$distinctBy$12.L$1 = hashSet2;
                                channelsKt__DeprecatedKt$distinctBy$12.L$2 = channelIterator2;
                                channelsKt__DeprecatedKt$distinctBy$12.L$3 = obj;
                                channelsKt__DeprecatedKt$distinctBy$12.label = 3;
                                if (producerScope2.send(e, channelsKt__DeprecatedKt$distinctBy$12) == obj2) {
                                    return obj2;
                                }
                                hashSet4 = hashSet2;
                                producerScope4 = producerScope2;
                                Object obj5 = obj2;
                                obj3 = obj;
                                channelsKt__DeprecatedKt$distinctBy$1 = channelsKt__DeprecatedKt$distinctBy$12;
                                coroutine_suspended = obj5;
                                hashSet4.add(obj3);
                                channelIterator = channelIterator2;
                                hashSet = hashSet4;
                                producerScope = producerScope4;
                                channelsKt__DeprecatedKt$distinctBy$1.L$0 = producerScope;
                                channelsKt__DeprecatedKt$distinctBy$1.L$1 = hashSet;
                                channelsKt__DeprecatedKt$distinctBy$1.L$2 = channelIterator;
                                channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
                                channelsKt__DeprecatedKt$distinctBy$1.label = 1;
                                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
                                if (hasNext != coroutine_suspended) {
                                }
                            } else {
                                channelsKt__DeprecatedKt$distinctBy$1 = channelsKt__DeprecatedKt$distinctBy$12;
                                coroutine_suspended = obj2;
                                channelIterator = channelIterator2;
                                hashSet = hashSet2;
                                producerScope = producerScope2;
                                channelsKt__DeprecatedKt$distinctBy$1.L$0 = producerScope;
                                channelsKt__DeprecatedKt$distinctBy$1.L$1 = hashSet;
                                channelsKt__DeprecatedKt$distinctBy$1.L$2 = channelIterator;
                                channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
                                channelsKt__DeprecatedKt$distinctBy$1.label = 1;
                                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
                                if (hasNext != coroutine_suspended) {
                                }
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ?? r1 = this.L$3;
                    channelIterator2 = (ChannelIterator) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    producerScope2 = (ProducerScope) this.L$0;
                    hashSet2 = (HashSet) this.L$1;
                    e = r1;
                    obj2 = coroutine_suspended;
                    channelsKt__DeprecatedKt$distinctBy$12 = this;
                    if (hashSet2.contains(obj)) {
                    }
                }
            } else {
                ResultKt.throwOnFailure(obj);
                producerScope3 = (ProducerScope) this.L$0;
                hashSet3 = (HashSet) this.L$1;
                channelIterator2 = (ChannelIterator) this.L$2;
                obj2 = coroutine_suspended;
                channelsKt__DeprecatedKt$distinctBy$12 = this;
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            HashSet hashSet6 = new HashSet();
            ChannelIterator<E> it = this.$this_distinctBy.iterator();
            producerScope = (ProducerScope) this.L$0;
            channelsKt__DeprecatedKt$distinctBy$1 = this;
            hashSet = hashSet6;
            channelIterator = it;
            channelsKt__DeprecatedKt$distinctBy$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$distinctBy$1.L$1 = hashSet;
            channelsKt__DeprecatedKt$distinctBy$1.L$2 = channelIterator;
            channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
            channelsKt__DeprecatedKt$distinctBy$1.label = 1;
            hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
            if (hasNext != coroutine_suspended) {
            }
        }
    }
}

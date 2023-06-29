package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {164, 169, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
/* loaded from: classes2.dex */
public final class ChannelsKt__DeprecatedKt$drop$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ int $n;
    public final /* synthetic */ ReceiveChannel<E> $this_drop;
    public int I$0;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends E> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$drop$1(int i, ReceiveChannel<? extends E> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$drop$1> continuation) {
        super(2, continuation);
        this.$n = i;
        this.$this_drop = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$1 = new ChannelsKt__DeprecatedKt$drop$1(this.$n, this.$this_drop, continuation);
        channelsKt__DeprecatedKt$drop$1.L$0 = obj;
        return channelsKt__DeprecatedKt$drop$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$drop$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cf  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007c -> B:24:0x0083). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00cd -> B:33:0x00a4). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        boolean z;
        Object obj2;
        ChannelsKt__DeprecatedKt$drop$1<E> channelsKt__DeprecatedKt$drop$1;
        ProducerScope producerScope2;
        ChannelsKt__DeprecatedKt$drop$1<E> channelsKt__DeprecatedKt$drop$12;
        ChannelIterator<E> it;
        int i;
        ChannelIterator<E> it2;
        Object hasNext;
        ProducerScope producerScope3;
        Object hasNext2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        ResultKt.throwOnFailure(obj);
                        producerScope = (ProducerScope) this.L$0;
                        it2 = (ChannelIterator) this.L$1;
                        obj2 = coroutine_suspended;
                        channelsKt__DeprecatedKt$drop$1 = this;
                        channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
                        channelsKt__DeprecatedKt$drop$1.L$1 = it2;
                        channelsKt__DeprecatedKt$drop$1.label = 2;
                        hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$drop$1);
                        if (hasNext2 != obj2) {
                            return obj2;
                        }
                        producerScope3 = producerScope;
                        obj = hasNext2;
                        if (!((Boolean) obj).booleanValue()) {
                            E next = it2.next();
                            channelsKt__DeprecatedKt$drop$1.L$0 = producerScope3;
                            channelsKt__DeprecatedKt$drop$1.L$1 = it2;
                            channelsKt__DeprecatedKt$drop$1.label = 3;
                            if (producerScope3.send(next, channelsKt__DeprecatedKt$drop$1) == obj2) {
                                return obj2;
                            }
                            producerScope = producerScope3;
                            channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
                            channelsKt__DeprecatedKt$drop$1.L$1 = it2;
                            channelsKt__DeprecatedKt$drop$1.label = 2;
                            hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$drop$1);
                            if (hasNext2 != obj2) {
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    producerScope3 = (ProducerScope) this.L$0;
                    it2 = (ChannelIterator) this.L$1;
                    obj2 = coroutine_suspended;
                    channelsKt__DeprecatedKt$drop$1 = this;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                }
            } else {
                int i3 = this.I$0;
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope4 = (ProducerScope) this.L$0;
                ChannelIterator<E> channelIterator = (ChannelIterator) this.L$1;
                int i4 = i3;
                obj2 = coroutine_suspended;
                channelsKt__DeprecatedKt$drop$1 = this;
                if (((Boolean) obj).booleanValue()) {
                    channelIterator.next();
                    int i5 = i4 - 1;
                    if (i5 != 0) {
                        it = channelIterator;
                        producerScope2 = producerScope4;
                        Object obj3 = obj2;
                        i = i5;
                        channelsKt__DeprecatedKt$drop$12 = channelsKt__DeprecatedKt$drop$1;
                        coroutine_suspended = obj3;
                        channelsKt__DeprecatedKt$drop$12.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$drop$12.L$1 = it;
                        channelsKt__DeprecatedKt$drop$12.I$0 = i;
                        channelsKt__DeprecatedKt$drop$12.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$drop$12);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj4 = coroutine_suspended;
                        channelsKt__DeprecatedKt$drop$1 = channelsKt__DeprecatedKt$drop$12;
                        obj = hasNext;
                        producerScope4 = producerScope2;
                        channelIterator = it;
                        i4 = i;
                        obj2 = obj4;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    }
                }
                producerScope = producerScope4;
                it2 = channelsKt__DeprecatedKt$drop$1.$this_drop.iterator();
                channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$drop$1.L$1 = it2;
                channelsKt__DeprecatedKt$drop$1.label = 2;
                hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$drop$1);
                if (hasNext2 != obj2) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            if (this.$n >= 0) {
                z = true;
            } else {
                z = false;
            }
            int i6 = this.$n;
            if (z) {
                if (i6 > 0) {
                    producerScope2 = producerScope;
                    channelsKt__DeprecatedKt$drop$12 = this;
                    it = this.$this_drop.iterator();
                    i = i6;
                    channelsKt__DeprecatedKt$drop$12.L$0 = producerScope2;
                    channelsKt__DeprecatedKt$drop$12.L$1 = it;
                    channelsKt__DeprecatedKt$drop$12.I$0 = i;
                    channelsKt__DeprecatedKt$drop$12.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$drop$12);
                    if (hasNext != coroutine_suspended) {
                    }
                } else {
                    obj2 = coroutine_suspended;
                    channelsKt__DeprecatedKt$drop$1 = this;
                    it2 = channelsKt__DeprecatedKt$drop$1.$this_drop.iterator();
                    channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
                    channelsKt__DeprecatedKt$drop$1.L$1 = it2;
                    channelsKt__DeprecatedKt$drop$1.label = 2;
                    hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$drop$1);
                    if (hasNext2 != obj2) {
                    }
                }
            } else {
                throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
            }
        }
    }
}

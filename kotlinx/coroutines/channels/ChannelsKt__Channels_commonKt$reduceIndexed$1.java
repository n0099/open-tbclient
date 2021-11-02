package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00042<\u0010\u0005\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\rH\u0087H"}, d2 = {"reduceIndexed", "", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ReceiveChannel;", AppDownloadNetworkStateReceiver.KEY_OPERATION, "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "index", "acc", "continuation", "Lkotlin/coroutines/Continuation;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {2062, 2065}, m = "reduceIndexed", n = {"$this$reduceIndexed", AppDownloadNetworkStateReceiver.KEY_OPERATION, "$this$consume$iv", "cause$iv", "$this$consume", "iterator", "$this$reduceIndexed", AppDownloadNetworkStateReceiver.KEY_OPERATION, "$this$consume$iv", "cause$iv", "$this$consume", "iterator", "index", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$6"})
/* loaded from: classes3.dex */
public final class ChannelsKt__Channels_commonKt$reduceIndexed$1 extends ContinuationImpl {
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$reduceIndexed$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt.reduceIndexed(null, null, this);
    }
}

package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a%\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/SendChannel;", "element", "", "sendBlocking", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes3.dex */
public final /* synthetic */ class ChannelsKt__ChannelsKt {
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: E */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> void sendBlocking(SendChannel<? super E> sendChannel, E e2) {
        if (sendChannel.offer(e2)) {
            return;
        }
        BuildersKt.runBlocking$default(null, new ChannelsKt__ChannelsKt$sendBlocking$1(sendChannel, e2, null), 1, null);
    }
}

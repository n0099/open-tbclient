package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
@ObsoleteCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\u00020\u0004R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ActorScope;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlin/Any;", "Lkotlinx/coroutines/channels/Channel;", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "channel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public interface ActorScope<E> extends CoroutineScope, ReceiveChannel<E> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class DefaultImpls {
    }

    Channel<E> getChannel();
}

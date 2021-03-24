package kotlin.coroutines.experimental;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function2;
@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\t*\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lkotlin/coroutines/experimental/EmptyCoroutineContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "R", "initial", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", AppDownloadNetworkStateReceiver.KEY_OPERATION, "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext$Element;", "", "hashCode", "()I", "minusKey", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext;", "context", "plus", "(Lkotlin/coroutines/experimental/CoroutineContext;)Lkotlin/coroutines/experimental/CoroutineContext;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class EmptyCoroutineContext implements CoroutineContext {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();

    @Override // kotlin.coroutines.experimental.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return r;
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return this;
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return coroutineContext;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}

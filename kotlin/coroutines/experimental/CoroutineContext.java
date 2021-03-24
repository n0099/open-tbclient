package kotlin.coroutines.experimental;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001:\u0002\u0013\u0014J7\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\t*\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH¦\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lkotlin/coroutines/experimental/CoroutineContext;", "Lkotlin/Any;", "R", "initial", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", AppDownloadNetworkStateReceiver.KEY_OPERATION, "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext$Element;", "minusKey", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext;", "context", "plus", "(Lkotlin/coroutines/experimental/CoroutineContext;)Lkotlin/coroutines/experimental/CoroutineContext;", "Element", "Key", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public interface CoroutineContext {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class DefaultImpls {
        public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            return coroutineContext2 == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, CoroutineContext$plus$1.INSTANCE);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u00012\u00020\u0002J7\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\t*\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/coroutines/experimental/CoroutineContext$Element;", "Lkotlin/coroutines/experimental/CoroutineContext;", "Lkotlin/Any;", "R", "initial", "Lkotlin/Function2;", AppDownloadNetworkStateReceiver.KEY_OPERATION, "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext$Element;", "minusKey", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext;", "getKey", "()Lkotlin/coroutines/experimental/CoroutineContext$Key;", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public interface Element extends CoroutineContext {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes7.dex */
        public static final class DefaultImpls {
            public static <R> R fold(Element element, R r, Function2<? super R, ? super Element, ? extends R> function2) {
                return function2.invoke(r, element);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.experimental.CoroutineContext$Element */
            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E get(Element element, Key<E> key) {
                if (element.getKey() == key) {
                    if (element != 0) {
                        return element;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type E");
                }
                return null;
            }

            public static CoroutineContext minusKey(Element element, Key<?> key) {
                return element.getKey() == key ? EmptyCoroutineContext.INSTANCE : element;
            }

            public static CoroutineContext plus(Element element, CoroutineContext coroutineContext) {
                return DefaultImpls.plus(element, coroutineContext);
            }
        }

        @Override // kotlin.coroutines.experimental.CoroutineContext
        <R> R fold(R r, Function2<? super R, ? super Element, ? extends R> function2);

        @Override // kotlin.coroutines.experimental.CoroutineContext
        <E extends Element> E get(Key<E> key);

        Key<?> getKey();

        @Override // kotlin.coroutines.experimental.CoroutineContext
        CoroutineContext minusKey(Key<?> key);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/experimental/CoroutineContext$Key;", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", ExifInterface.LONGITUDE_EAST, "Lkotlin/Any;", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public interface Key<E extends Element> {
    }

    <R> R fold(R r, Function2<? super R, ? super Element, ? extends R> function2);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext coroutineContext);
}

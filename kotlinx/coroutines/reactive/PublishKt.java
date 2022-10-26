package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u001aY\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012/\b\u0001\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aw\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u00032-\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a]\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0000*\u00020\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00012/\b\u0001\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0013\"\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"(\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\"\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lorg/reactivestreams/Publisher;", "publish", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lorg/reactivestreams/Publisher;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "exceptionOnCancelHandler", "publishInternal", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lorg/reactivestreams/Publisher;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lorg/reactivestreams/Publisher;", "", "CLOSED", "J", "DEFAULT_HANDLER", "Lkotlin/Function2;", "SIGNALLED", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class PublishKt {
    public static final long CLOSED = -1;
    public static final Function2 DEFAULT_HANDLER = PublishKt$DEFAULT_HANDLER$1.INSTANCE;
    public static final long SIGNALLED = -2;

    public static final Publisher publish(CoroutineContext coroutineContext, Function2 function2) {
        boolean z;
        if (coroutineContext.get(Job.Key) == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return publishInternal(GlobalScope.INSTANCE, coroutineContext, DEFAULT_HANDLER, function2);
        }
        throw new IllegalArgumentException(("Publisher context cannot contain job in it.Its lifecycle should be managed via subscription. Had " + coroutineContext).toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "CoroutineScope.publish is deprecated in favour of top-level publish", replaceWith = @ReplaceWith(expression = "publish(context, block)", imports = {}))
    public static final Publisher publish(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2) {
        return publishInternal(coroutineScope, coroutineContext, DEFAULT_HANDLER, function2);
    }

    public static /* synthetic */ Publisher publish$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return publish(coroutineContext, function2);
    }

    public static final Publisher publishInternal(final CoroutineScope coroutineScope, final CoroutineContext coroutineContext, final Function2 function2, final Function2 function22) {
        return new Publisher() { // from class: kotlinx.coroutines.reactive.PublishKt$publishInternal$1
            @Override // org.reactivestreams.Publisher
            public final void subscribe(Subscriber subscriber) {
                if (subscriber != null) {
                    PublisherCoroutine publisherCoroutine = new PublisherCoroutine(CoroutineContextKt.newCoroutineContext(CoroutineScope.this, coroutineContext), subscriber, function2);
                    subscriber.onSubscribe(publisherCoroutine);
                    publisherCoroutine.start(CoroutineStart.DEFAULT, publisherCoroutine, function22);
                    return;
                }
                throw new NullPointerException("Subscriber cannot be null");
            }
        };
    }

    public static /* synthetic */ Publisher publish$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return publish(coroutineScope, coroutineContext, function2);
    }
}

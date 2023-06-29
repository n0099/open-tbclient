package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.SendChannel;
/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0006\b\u0001\u0010\u0002 \u0000H\u008a@"}, d2 = {"<anonymous>", "R", ExifInterface.GPS_DIRECTION_TRUE}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherCoroutine$registerSelectClause2$clause$1", f = "Publish.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class PublisherCoroutine$registerSelectClause2$clause$1<R> extends SuspendLambda implements Function1<Continuation<? super R>, Object> {
    public final /* synthetic */ Function2<SendChannel<? super T>, Continuation<? super R>, Object> $block;
    public final /* synthetic */ T $element;
    public int label;
    public final /* synthetic */ PublisherCoroutine<T> this$0;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.reactive.PublisherCoroutine<? super T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.channels.SendChannel<? super T>, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PublisherCoroutine$registerSelectClause2$clause$1(PublisherCoroutine<? super T> publisherCoroutine, T t, Function2<? super SendChannel<? super T>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super PublisherCoroutine$registerSelectClause2$clause$1> continuation) {
        super(1, continuation);
        this.this$0 = publisherCoroutine;
        this.$element = t;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PublisherCoroutine$registerSelectClause2$clause$1(this.this$0, this.$element, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((Continuation) ((Continuation) obj));
    }

    public final Object invoke(Continuation<? super R> continuation) {
        return ((PublisherCoroutine$registerSelectClause2$clause$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable doLockedNext;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            doLockedNext = this.this$0.doLockedNext(this.$element);
            if (doLockedNext == null) {
                Function2<SendChannel<? super T>, Continuation<? super R>, Object> function2 = this.$block;
                Continuation continuation = this.this$0;
                this.label = 1;
                obj = function2.invoke(continuation, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw doLockedNext;
            }
        }
        return obj;
    }
}

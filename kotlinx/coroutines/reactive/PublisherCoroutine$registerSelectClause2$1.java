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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0000*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherCoroutine$registerSelectClause2$1", f = "Publish.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class PublisherCoroutine$registerSelectClause2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function1<Continuation<? super R>, Object> $clause;
    public final /* synthetic */ SelectInstance<R> $select;
    public int label;
    public final /* synthetic */ PublisherCoroutine<T> this$0;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.reactive.PublisherCoroutine<? super T> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.selects.SelectInstance<? super R> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PublisherCoroutine$registerSelectClause2$1(PublisherCoroutine<? super T> publisherCoroutine, SelectInstance<? super R> selectInstance, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super PublisherCoroutine$registerSelectClause2$1> continuation) {
        super(2, continuation);
        this.this$0 = publisherCoroutine;
        this.$select = selectInstance;
        this.$clause = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PublisherCoroutine$registerSelectClause2$1(this.this$0, this.$select, this.$clause, continuation);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PublisherCoroutine$registerSelectClause2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        Mutex mutex2;
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
            mutex = this.this$0.mutex;
            this.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (this.$select.trySelect()) {
            CancellableKt.startCoroutineCancellable(this.$clause, this.$select.getCompletion());
            return Unit.INSTANCE;
        }
        mutex2 = this.this$0.mutex;
        Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
        return Unit.INSTANCE;
    }
}

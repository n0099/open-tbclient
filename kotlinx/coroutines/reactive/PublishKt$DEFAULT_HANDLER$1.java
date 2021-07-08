package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "t", "", "ctx", "Lkotlin/coroutines/CoroutineContext;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class PublishKt$DEFAULT_HANDLER$1 extends Lambda implements Function2<Throwable, CoroutineContext, Unit> {
    public static final PublishKt$DEFAULT_HANDLER$1 INSTANCE = new PublishKt$DEFAULT_HANDLER$1();

    public PublishKt$DEFAULT_HANDLER$1() {
        super(2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th, CoroutineContext coroutineContext) {
        invoke2(th, coroutineContext);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th, CoroutineContext coroutineContext) {
        if (th instanceof CancellationException) {
            return;
        }
        CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, th);
    }
}

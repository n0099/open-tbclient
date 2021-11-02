package kotlin.coroutines.cancellation;

import java.util.concurrent.CancellationException;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0087\b¢\u0006\u0004\b\u0006\u0010\b*\u001e\b\u0007\u0010\u0006\"\u00020\u00042\u00020\u0004B\u0002\b\tB\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¨\u0006\r"}, d2 = {"", "message", "", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "CancellationException", "(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/util/concurrent/CancellationException;", "(Ljava/lang/Throwable;)Ljava/util/concurrent/CancellationException;", "Lkotlin/ExperimentalStdlibApi;", "Lkotlin/SinceKotlin;", "version", "1.4", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class CancellationExceptionKt {
    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final CancellationException CancellationException(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static /* synthetic */ void CancellationException$annotations() {
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final CancellationException CancellationException(Throwable th) {
        CancellationException cancellationException = new CancellationException(th != null ? th.toString() : null);
        cancellationException.initCause(th);
        return cancellationException;
    }
}

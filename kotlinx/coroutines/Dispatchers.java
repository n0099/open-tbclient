package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0007R\"\u0010\u0002\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\b\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0003\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001c\u0010\u000f\u001a\u00020\u000b8F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0003\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Default$annotations", "()V", "IO", "getIO", "IO$annotations", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "Main$annotations", "Main", "Unconfined", "getUnconfined", "Unconfined$annotations", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class Dispatchers {
    public static final Dispatchers INSTANCE = new Dispatchers();
    public static final CoroutineDispatcher Default = CoroutineContextKt.createDefaultDispatcher();
    public static final CoroutineDispatcher Unconfined = Unconfined.INSTANCE;
    public static final CoroutineDispatcher IO = DefaultScheduler.INSTANCE.getIO();

    @JvmStatic
    public static /* synthetic */ void Default$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void IO$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void Main$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void Unconfined$annotations() {
    }

    public static final CoroutineDispatcher getDefault() {
        return Default;
    }

    public static final CoroutineDispatcher getIO() {
        return IO;
    }

    public static final MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }

    public static final CoroutineDispatcher getUnconfined() {
        return Unconfined;
    }
}

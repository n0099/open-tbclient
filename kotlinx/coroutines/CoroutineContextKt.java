package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a6\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0080\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\r\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000e\"\u0016\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011\"\u001c\u0010\u0014\u001a\u00020\u00138\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000f*\u00020\u00048@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "createDefaultDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/CoroutineContext;", "context", "", "countOrElement", "Lkotlin/Function0;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "withCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "newCoroutineContext", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "", "COROUTINES_SCHEDULER_PROPERTY_NAME", "Ljava/lang/String;", "DEBUG_THREAD_NAME_SEPARATOR", "", "useCoroutinesScheduler", "Z", "getUseCoroutinesScheduler", "()Z", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "coroutineName", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class CoroutineContextKt {
    public static final String COROUTINES_SCHEDULER_PROPERTY_NAME = "kotlinx.coroutines.scheduler";
    public static final String DEBUG_THREAD_NAME_SEPARATOR = " @";
    public static final boolean useCoroutinesScheduler;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r0.equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
        if (r0.equals("") != false) goto L21;
     */
    static {
        boolean z;
        String systemProp = SystemPropsKt.systemProp(COROUTINES_SCHEDULER_PROPERTY_NAME);
        if (systemProp != null) {
            int hashCode = systemProp.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode == 109935 && systemProp.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                        z = false;
                    }
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.scheduler' has unrecognized value '" + systemProp + '\'').toString());
            }
            useCoroutinesScheduler = z;
        }
        z = true;
        useCoroutinesScheduler = z;
    }

    public static final CoroutineDispatcher createDefaultDispatcher() {
        if (useCoroutinesScheduler) {
            return DefaultScheduler.INSTANCE;
        }
        return CommonPool.INSTANCE;
    }

    public static final boolean getUseCoroutinesScheduler() {
        return useCoroutinesScheduler;
    }

    public static final String getCoroutineName(CoroutineContext coroutineContext) {
        CoroutineId coroutineId;
        if (!DebugKt.getDEBUG() || (coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.Key)) == null) {
            return null;
        }
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.Key);
        String str = (coroutineName == null || (str = coroutineName.getName()) == null) ? "coroutine" : "coroutine";
        return str + '#' + coroutineId.getId();
    }

    public static final CoroutineContext newCoroutineContext(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContext2;
        CoroutineContext plus = coroutineScope.getCoroutineContext().plus(coroutineContext);
        if (DebugKt.getDEBUG()) {
            coroutineContext2 = plus.plus(new CoroutineId(DebugKt.getCOROUTINE_ID().incrementAndGet()));
        } else {
            coroutineContext2 = plus;
        }
        if (plus != Dispatchers.getDefault() && plus.get(ContinuationInterceptor.Key) == null) {
            return coroutineContext2.plus(Dispatchers.getDefault());
        }
        return coroutineContext2;
    }

    public static final Object withCoroutineContext(CoroutineContext coroutineContext, Object obj, Function0 function0) {
        Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, obj);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }
}

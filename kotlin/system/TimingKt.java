package kotlin.system;

import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.BreakpointSQLiteHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u001e\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"Lkotlin/Function0;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "", "measureNanoTime", "(Lkotlin/Function0;)J", "measureTimeMillis", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "TimingKt")
/* loaded from: classes7.dex */
public final class TimingKt {
    public static final long measureNanoTime(Function0<Unit> function0) {
        long nanoTime = System.nanoTime();
        function0.invoke();
        return System.nanoTime() - nanoTime;
    }

    public static final long measureTimeMillis(Function0<Unit> function0) {
        long currentTimeMillis = System.currentTimeMillis();
        function0.invoke();
        return System.currentTimeMillis() - currentTimeMillis;
    }
}

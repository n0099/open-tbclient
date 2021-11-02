package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.tbadk.TbConfig;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a:\u0010\n\u001a\u00028\u0001\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u0000\"\u0004\b\u0001\u0010\u0007*\u00028\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0087\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ljava/lang/AutoCloseable;", "", "cause", "", "closeFinally", "(Ljava/lang/AutoCloseable;Ljava/lang/Throwable;)V", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/Function1;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, TbConfig.ST_TYPE_USE, "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib-jre7"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "AutoCloseableKt")
/* loaded from: classes3.dex */
public final class AutoCloseableKt {
    @SinceKotlin(version = "1.1")
    @PublishedApi
    public static final void closeFinally(AutoCloseable autoCloseable, Throwable th) {
        if (autoCloseable == null) {
            return;
        }
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T extends AutoCloseable, R> R use(T t, Function1<? super T, ? extends R> function1) {
        try {
            R invoke = function1.invoke(t);
            InlineMarker.finallyStart(1);
            closeFinally(t, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }
}

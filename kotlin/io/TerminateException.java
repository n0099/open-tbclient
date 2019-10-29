package kotlin.io;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.File;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
final class TerminateException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TerminateException(File file) {
        super(file, null, null, 6, null);
        p.i(file, BdStatsConstant.OpSubType.FILE);
    }
}

package d.b.c.g.h;

import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.pyramid.annotation.Service;
@Service
/* loaded from: classes.dex */
public class c implements IStatisticManager {
    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordDownloadResult(int i, String str, int i2, String str2) {
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordException(int i, String str, String str2) {
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordInstallResult(int i, String str, int i2, String str2) {
        b.c(str, i, i2);
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordInvokeResult(int i, String str, int i2, String str2) {
        if (i == 14) {
            b.a(str, i2);
        }
        b.d(str, i, i2);
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordPeriod(long j, long j2) {
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordResult(long j, int i, String str) {
    }
}

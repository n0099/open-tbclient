package d.a.c.g.h;

import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.pyramid.annotation.Service;
@Service
/* loaded from: classes.dex */
public class c implements IStatisticManager {
    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordDownloadResult(int i2, String str, int i3, String str2) {
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordException(int i2, String str, String str2) {
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordInstallResult(int i2, String str, int i3, String str2) {
        b.c(str, i2, i3);
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordInvokeResult(int i2, String str, int i3, String str2) {
        if (i2 == 14) {
            b.a(str, i3);
        }
        b.d(str, i2, i3);
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordPeriod(long j, long j2) {
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordResult(long j, int i2, String str) {
    }
}

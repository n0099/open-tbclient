package d.o.a.e.b.m;

import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.o.a.e.b.g.r;
/* loaded from: classes7.dex */
public class j implements r {
    @Override // d.o.a.e.b.g.r
    public long a(int i, int i2) {
        if (i == 1) {
            return 3000L;
        }
        if (i == 2) {
            return 15000L;
        }
        return i == 3 ? StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD : i > 3 ? 300000L : 0L;
    }
}

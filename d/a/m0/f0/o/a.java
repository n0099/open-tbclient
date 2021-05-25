package d.a.m0.f0.o;

import android.text.TextUtils;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
import d.a.m0.f0.b;
import d.a.n0.z.m;
/* loaded from: classes3.dex */
public class a implements b<HistoryEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.f0.b
    /* renamed from: a */
    public boolean onEvent(HistoryEvent historyEvent) {
        if (historyEvent == null || TextUtils.isEmpty(historyEvent.tid)) {
            return false;
        }
        m.a(historyEvent.tid);
        return true;
    }
}

package d.a.n0.f0.p;

import android.text.TextUtils;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
import d.a.n0.f0.b;
import d.a.o0.z.m;
/* loaded from: classes3.dex */
public class a implements b<HistoryEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.f0.b
    /* renamed from: a */
    public boolean onEvent(HistoryEvent historyEvent) {
        if (historyEvent == null || TextUtils.isEmpty(historyEvent.tid)) {
            return false;
        }
        m.a(historyEvent.tid);
        return true;
    }
}

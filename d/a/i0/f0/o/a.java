package d.a.i0.f0.o;

import android.text.TextUtils;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
import d.a.i0.f0.b;
import d.a.j0.x.m;
/* loaded from: classes3.dex */
public class a implements b<HistoryEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.f0.b
    /* renamed from: a */
    public boolean onEvent(HistoryEvent historyEvent) {
        if (historyEvent == null || TextUtils.isEmpty(historyEvent.tid)) {
            return false;
        }
        m.a(historyEvent.tid);
        return true;
    }
}

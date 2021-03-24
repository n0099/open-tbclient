package d.b.i0.p1.l;

import com.baidu.searchbox.live.interfaces.service.ext.ExtLiveLogService;
import java.util.Map;
/* loaded from: classes3.dex */
public class b implements ExtLiveLogService {
    @Override // com.baidu.searchbox.live.interfaces.service.ext.ExtLiveLogService
    public void onLivePluginEvent(String str, Map<String, ?> map) {
        d.b.i0.l1.l.a.b(map);
    }
}

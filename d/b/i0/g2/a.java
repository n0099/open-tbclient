package d.b.i0.g2;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<SmartApp> f54940a;

    public List<SmartApp> a() {
        return this.f54940a;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f54940a = new ArrayList(dataRes.swan_list);
    }
}

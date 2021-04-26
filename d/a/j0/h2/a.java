package d.a.j0.h2;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<SmartApp> f54810a;

    public List<SmartApp> a() {
        return this.f54810a;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f54810a = new ArrayList(dataRes.swan_list);
    }
}

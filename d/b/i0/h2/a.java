package d.b.i0.h2;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<SmartApp> f56477a;

    public List<SmartApp> a() {
        return this.f56477a;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f56477a = new ArrayList(dataRes.swan_list);
    }
}

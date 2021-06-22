package d.a.o0.i2;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<SmartApp> f59519a;

    public List<SmartApp> a() {
        return this.f59519a;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f59519a = new ArrayList(dataRes.swan_list);
    }
}

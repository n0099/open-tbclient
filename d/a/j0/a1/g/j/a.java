package d.a.j0.a1.g.j;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import tbclient.App;
/* loaded from: classes4.dex */
public class a extends d.a.j0.x.e0.d {
    public void l(App app) {
        if (app == null) {
            return;
        }
        if (this.f62460e == null) {
            this.f62460e = new AdvertAppInfo();
        }
        this.f62460e.H4(app);
        this.position = this.f62460e.position;
    }
}

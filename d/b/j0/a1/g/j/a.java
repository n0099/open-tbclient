package d.b.j0.a1.g.j;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import tbclient.App;
/* loaded from: classes4.dex */
public class a extends d.b.j0.x.e0.d {
    public void j(App app) {
        if (app == null) {
            return;
        }
        if (this.f64197e == null) {
            this.f64197e = new AdvertAppInfo();
        }
        this.f64197e.H4(app);
        this.position = this.f64197e.position;
    }
}

package d.b.i0.z0.g.j;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import tbclient.App;
/* loaded from: classes4.dex */
public class a extends d.b.i0.x.e0.d {
    public void j(App app) {
        if (app == null) {
            return;
        }
        if (this.f62200e == null) {
            this.f62200e = new AdvertAppInfo();
        }
        this.f62200e.F4(app);
        this.position = this.f62200e.position;
    }
}

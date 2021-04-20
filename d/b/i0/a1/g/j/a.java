package d.b.i0.a1.g.j;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import tbclient.App;
/* loaded from: classes4.dex */
public class a extends d.b.i0.x.e0.d {
    public void j(App app) {
        if (app == null) {
            return;
        }
        if (this.f63776e == null) {
            this.f63776e = new AdvertAppInfo();
        }
        this.f63776e.H4(app);
        this.position = this.f63776e.position;
    }
}

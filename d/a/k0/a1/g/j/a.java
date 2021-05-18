package d.a.k0.a1.g.j;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import tbclient.App;
/* loaded from: classes4.dex */
public class a extends d.a.k0.x.e0.d {
    public void l(App app) {
        if (app == null) {
            return;
        }
        if (this.f63184e == null) {
            this.f63184e = new AdvertAppInfo();
        }
        this.f63184e.I4(app);
        this.position = this.f63184e.position;
    }
}

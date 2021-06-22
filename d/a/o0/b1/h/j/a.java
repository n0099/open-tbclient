package d.a.o0.b1.h.j;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import tbclient.App;
/* loaded from: classes4.dex */
public class a extends d.a.o0.z.e0.d {
    public void g(App app) {
        if (app == null) {
            return;
        }
        if (this.f67307e == null) {
            this.f67307e = new AdvertAppInfo();
        }
        this.f67307e.K4(app);
        this.position = this.f67307e.position;
    }
}

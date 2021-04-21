package d.b.i0.t;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f52221a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f52222b;

    public String a() {
        return this.f52222b;
    }

    public String b() {
        return this.f52221a;
    }

    public void c(Lbs lbs) {
        if (lbs == null) {
            return;
        }
        try {
            this.f52221a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f52222b = lbs.distance;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}

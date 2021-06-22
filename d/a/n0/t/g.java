package d.a.n0.t;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f54565a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f54566b;

    public String a() {
        return this.f54566b;
    }

    public String b() {
        return this.f54565a;
    }

    public void c(Lbs lbs) {
        if (lbs == null) {
            return;
        }
        try {
            this.f54565a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f54566b = lbs.distance;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}

package d.a.j0.t;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f50708a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f50709b;

    public String a() {
        return this.f50709b;
    }

    public String b() {
        return this.f50708a;
    }

    public void c(Lbs lbs) {
        if (lbs == null) {
            return;
        }
        try {
            this.f50708a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f50709b = lbs.distance;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}

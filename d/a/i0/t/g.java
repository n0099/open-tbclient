package d.a.i0.t;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f49889a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f49890b;

    public String a() {
        return this.f49890b;
    }

    public String b() {
        return this.f49889a;
    }

    public void c(Lbs lbs) {
        if (lbs == null) {
            return;
        }
        try {
            this.f49889a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f49890b = lbs.distance;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}

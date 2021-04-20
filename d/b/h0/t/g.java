package d.b.h0.t;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f51885a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f51886b;

    public String a() {
        return this.f51886b;
    }

    public String b() {
        return this.f51885a;
    }

    public void c(Lbs lbs) {
        if (lbs == null) {
            return;
        }
        try {
            this.f51885a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f51886b = lbs.distance;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}

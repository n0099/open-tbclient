package d.a.m0.t;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f54458a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f54459b;

    public String a() {
        return this.f54459b;
    }

    public String b() {
        return this.f54458a;
    }

    public void c(Lbs lbs) {
        if (lbs == null) {
            return;
        }
        try {
            this.f54458a = lbs.name;
            String str = lbs.lat;
            String str2 = lbs.lng;
            this.f54459b = lbs.distance;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}

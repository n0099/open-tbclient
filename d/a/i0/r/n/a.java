package d.a.i0.r.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StringHelper;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f49010a;

    /* renamed from: b  reason: collision with root package name */
    public String f49011b;

    /* renamed from: c  reason: collision with root package name */
    public int f49012c;

    /* renamed from: d  reason: collision with root package name */
    public long f49013d;

    /* renamed from: e  reason: collision with root package name */
    public int f49014e;

    /* renamed from: f  reason: collision with root package name */
    public long f49015f;

    /* renamed from: g  reason: collision with root package name */
    public long f49016g;

    public boolean a() {
        if (StringUtils.isNULL(this.f49010a) || this.f49013d <= 0) {
            return false;
        }
        int i2 = this.f49014e;
        if (i2 == 1 || i2 == 3) {
            long j = this.f49015f;
            if (j > 0) {
                long j2 = this.f49016g;
                return j2 > 0 && j2 > j;
            }
            return false;
        }
        return false;
    }

    public void b(BigdayInfo bigdayInfo) {
        if (bigdayInfo == null || StringUtils.isNULL(bigdayInfo.img_url) || bigdayInfo.id.longValue() <= 0) {
            return;
        }
        if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
            this.f49010a = bigdayInfo.img_url;
            this.f49011b = bigdayInfo.jump_url;
            this.f49012c = bigdayInfo.img_colour.intValue();
            this.f49013d = bigdayInfo.id.longValue();
            this.f49014e = bigdayInfo.position.intValue();
            this.f49015f = bigdayInfo.start_time.longValue();
            this.f49016g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.a() && a() && this.f49013d == aVar.f49013d && StringHelper.equals(this.f49010a, aVar.f49010a) && ((this.f49011b == null && aVar.f49011b == null) || StringHelper.equals(this.f49011b, aVar.f49011b)) && this.f49012c == aVar.f49012c && this.f49014e == aVar.f49014e && this.f49015f == aVar.f49015f && this.f49016g == aVar.f49016g;
        }
        return false;
    }
}

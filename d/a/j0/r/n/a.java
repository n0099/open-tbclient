package d.a.j0.r.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StringHelper;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f49840a;

    /* renamed from: b  reason: collision with root package name */
    public String f49841b;

    /* renamed from: c  reason: collision with root package name */
    public int f49842c;

    /* renamed from: d  reason: collision with root package name */
    public long f49843d;

    /* renamed from: e  reason: collision with root package name */
    public int f49844e;

    /* renamed from: f  reason: collision with root package name */
    public long f49845f;

    /* renamed from: g  reason: collision with root package name */
    public long f49846g;

    public boolean a() {
        if (StringUtils.isNULL(this.f49840a) || this.f49843d <= 0) {
            return false;
        }
        int i2 = this.f49844e;
        if (i2 == 1 || i2 == 3) {
            long j = this.f49845f;
            if (j > 0) {
                long j2 = this.f49846g;
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
            this.f49840a = bigdayInfo.img_url;
            this.f49841b = bigdayInfo.jump_url;
            this.f49842c = bigdayInfo.img_colour.intValue();
            this.f49843d = bigdayInfo.id.longValue();
            this.f49844e = bigdayInfo.position.intValue();
            this.f49845f = bigdayInfo.start_time.longValue();
            this.f49846g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.a() && a() && this.f49843d == aVar.f49843d && StringHelper.equals(this.f49840a, aVar.f49840a) && ((this.f49841b == null && aVar.f49841b == null) || StringHelper.equals(this.f49841b, aVar.f49841b)) && this.f49842c == aVar.f49842c && this.f49844e == aVar.f49844e && this.f49845f == aVar.f49845f && this.f49846g == aVar.f49846g;
        }
        return false;
    }
}

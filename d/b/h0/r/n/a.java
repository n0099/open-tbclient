package d.b.h0.r.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StringHelper;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f50648a;

    /* renamed from: b  reason: collision with root package name */
    public String f50649b;

    /* renamed from: c  reason: collision with root package name */
    public int f50650c;

    /* renamed from: d  reason: collision with root package name */
    public long f50651d;

    /* renamed from: e  reason: collision with root package name */
    public int f50652e;

    /* renamed from: f  reason: collision with root package name */
    public long f50653f;

    /* renamed from: g  reason: collision with root package name */
    public long f50654g;

    public boolean a() {
        if (StringUtils.isNULL(this.f50648a) || this.f50651d <= 0) {
            return false;
        }
        int i = this.f50652e;
        if (i == 1 || i == 3) {
            long j = this.f50653f;
            if (j > 0) {
                long j2 = this.f50654g;
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
            this.f50648a = bigdayInfo.img_url;
            this.f50649b = bigdayInfo.jump_url;
            this.f50650c = bigdayInfo.img_colour.intValue();
            this.f50651d = bigdayInfo.id.longValue();
            this.f50652e = bigdayInfo.position.intValue();
            this.f50653f = bigdayInfo.start_time.longValue();
            this.f50654g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.a() && a() && this.f50651d == aVar.f50651d && StringHelper.equals(this.f50648a, aVar.f50648a) && ((this.f50649b == null && aVar.f50649b == null) || StringHelper.equals(this.f50649b, aVar.f50649b)) && this.f50650c == aVar.f50650c && this.f50652e == aVar.f50652e && this.f50653f == aVar.f50653f && this.f50654g == aVar.f50654g;
        }
        return false;
    }
}

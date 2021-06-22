package d.a.n0.r.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StringHelper;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f53667a;

    /* renamed from: b  reason: collision with root package name */
    public String f53668b;

    /* renamed from: c  reason: collision with root package name */
    public int f53669c;

    /* renamed from: d  reason: collision with root package name */
    public long f53670d;

    /* renamed from: e  reason: collision with root package name */
    public int f53671e;

    /* renamed from: f  reason: collision with root package name */
    public long f53672f;

    /* renamed from: g  reason: collision with root package name */
    public long f53673g;

    public boolean a() {
        if (StringUtils.isNULL(this.f53667a) || this.f53670d <= 0) {
            return false;
        }
        int i2 = this.f53671e;
        if (i2 == 1 || i2 == 3) {
            long j = this.f53672f;
            if (j > 0) {
                long j2 = this.f53673g;
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
            this.f53667a = bigdayInfo.img_url;
            this.f53668b = bigdayInfo.jump_url;
            this.f53669c = bigdayInfo.img_colour.intValue();
            this.f53670d = bigdayInfo.id.longValue();
            this.f53671e = bigdayInfo.position.intValue();
            this.f53672f = bigdayInfo.start_time.longValue();
            this.f53673g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.a() && a() && this.f53670d == aVar.f53670d && StringHelper.equals(this.f53667a, aVar.f53667a) && ((this.f53668b == null && aVar.f53668b == null) || StringHelper.equals(this.f53668b, aVar.f53668b)) && this.f53669c == aVar.f53669c && this.f53671e == aVar.f53671e && this.f53672f == aVar.f53672f && this.f53673g == aVar.f53673g;
        }
        return false;
    }
}

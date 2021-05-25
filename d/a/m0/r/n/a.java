package d.a.m0.r.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StringHelper;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f49884a;

    /* renamed from: b  reason: collision with root package name */
    public String f49885b;

    /* renamed from: c  reason: collision with root package name */
    public int f49886c;

    /* renamed from: d  reason: collision with root package name */
    public long f49887d;

    /* renamed from: e  reason: collision with root package name */
    public int f49888e;

    /* renamed from: f  reason: collision with root package name */
    public long f49889f;

    /* renamed from: g  reason: collision with root package name */
    public long f49890g;

    public boolean a() {
        if (StringUtils.isNULL(this.f49884a) || this.f49887d <= 0) {
            return false;
        }
        int i2 = this.f49888e;
        if (i2 == 1 || i2 == 3) {
            long j = this.f49889f;
            if (j > 0) {
                long j2 = this.f49890g;
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
            this.f49884a = bigdayInfo.img_url;
            this.f49885b = bigdayInfo.jump_url;
            this.f49886c = bigdayInfo.img_colour.intValue();
            this.f49887d = bigdayInfo.id.longValue();
            this.f49888e = bigdayInfo.position.intValue();
            this.f49889f = bigdayInfo.start_time.longValue();
            this.f49890g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.a() && a() && this.f49887d == aVar.f49887d && StringHelper.equals(this.f49884a, aVar.f49884a) && ((this.f49885b == null && aVar.f49885b == null) || StringHelper.equals(this.f49885b, aVar.f49885b)) && this.f49886c == aVar.f49886c && this.f49888e == aVar.f49888e && this.f49889f == aVar.f49889f && this.f49890g == aVar.f49890g;
        }
        return false;
    }
}

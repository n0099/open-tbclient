package d.b.i0.r.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StringHelper;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f51392a;

    /* renamed from: b  reason: collision with root package name */
    public String f51393b;

    /* renamed from: c  reason: collision with root package name */
    public int f51394c;

    /* renamed from: d  reason: collision with root package name */
    public long f51395d;

    /* renamed from: e  reason: collision with root package name */
    public int f51396e;

    /* renamed from: f  reason: collision with root package name */
    public long f51397f;

    /* renamed from: g  reason: collision with root package name */
    public long f51398g;

    public boolean a() {
        if (StringUtils.isNULL(this.f51392a) || this.f51395d <= 0) {
            return false;
        }
        int i = this.f51396e;
        if (i == 1 || i == 3) {
            long j = this.f51397f;
            if (j > 0) {
                long j2 = this.f51398g;
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
            this.f51392a = bigdayInfo.img_url;
            this.f51393b = bigdayInfo.jump_url;
            this.f51394c = bigdayInfo.img_colour.intValue();
            this.f51395d = bigdayInfo.id.longValue();
            this.f51396e = bigdayInfo.position.intValue();
            this.f51397f = bigdayInfo.start_time.longValue();
            this.f51398g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.a() && a() && this.f51395d == aVar.f51395d && StringHelper.equals(this.f51392a, aVar.f51392a) && ((this.f51393b == null && aVar.f51393b == null) || StringHelper.equals(this.f51393b, aVar.f51393b)) && this.f51394c == aVar.f51394c && this.f51396e == aVar.f51396e && this.f51397f == aVar.f51397f && this.f51398g == aVar.f51398g;
        }
        return false;
    }
}

package d.b.h0.r.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StringHelper;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f51056a;

    /* renamed from: b  reason: collision with root package name */
    public String f51057b;

    /* renamed from: c  reason: collision with root package name */
    public int f51058c;

    /* renamed from: d  reason: collision with root package name */
    public long f51059d;

    /* renamed from: e  reason: collision with root package name */
    public int f51060e;

    /* renamed from: f  reason: collision with root package name */
    public long f51061f;

    /* renamed from: g  reason: collision with root package name */
    public long f51062g;

    public boolean a() {
        if (StringUtils.isNULL(this.f51056a) || this.f51059d <= 0) {
            return false;
        }
        int i = this.f51060e;
        if (i == 1 || i == 3) {
            long j = this.f51061f;
            if (j > 0) {
                long j2 = this.f51062g;
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
            this.f51056a = bigdayInfo.img_url;
            this.f51057b = bigdayInfo.jump_url;
            this.f51058c = bigdayInfo.img_colour.intValue();
            this.f51059d = bigdayInfo.id.longValue();
            this.f51060e = bigdayInfo.position.intValue();
            this.f51061f = bigdayInfo.start_time.longValue();
            this.f51062g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.a() && a() && this.f51059d == aVar.f51059d && StringHelper.equals(this.f51056a, aVar.f51056a) && ((this.f51057b == null && aVar.f51057b == null) || StringHelper.equals(this.f51057b, aVar.f51057b)) && this.f51058c == aVar.f51058c && this.f51060e == aVar.f51060e && this.f51061f == aVar.f51061f && this.f51062g == aVar.f51062g;
        }
        return false;
    }
}

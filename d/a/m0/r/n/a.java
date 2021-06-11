package d.a.m0.r.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StringHelper;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f53560a;

    /* renamed from: b  reason: collision with root package name */
    public String f53561b;

    /* renamed from: c  reason: collision with root package name */
    public int f53562c;

    /* renamed from: d  reason: collision with root package name */
    public long f53563d;

    /* renamed from: e  reason: collision with root package name */
    public int f53564e;

    /* renamed from: f  reason: collision with root package name */
    public long f53565f;

    /* renamed from: g  reason: collision with root package name */
    public long f53566g;

    public boolean a() {
        if (StringUtils.isNULL(this.f53560a) || this.f53563d <= 0) {
            return false;
        }
        int i2 = this.f53564e;
        if (i2 == 1 || i2 == 3) {
            long j = this.f53565f;
            if (j > 0) {
                long j2 = this.f53566g;
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
            this.f53560a = bigdayInfo.img_url;
            this.f53561b = bigdayInfo.jump_url;
            this.f53562c = bigdayInfo.img_colour.intValue();
            this.f53563d = bigdayInfo.id.longValue();
            this.f53564e = bigdayInfo.position.intValue();
            this.f53565f = bigdayInfo.start_time.longValue();
            this.f53566g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.a() && a() && this.f53563d == aVar.f53563d && StringHelper.equals(this.f53560a, aVar.f53560a) && ((this.f53561b == null && aVar.f53561b == null) || StringHelper.equals(this.f53561b, aVar.f53561b)) && this.f53562c == aVar.f53562c && this.f53564e == aVar.f53564e && this.f53565f == aVar.f53565f && this.f53566g == aVar.f53566g;
        }
        return false;
    }
}

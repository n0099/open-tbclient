package d.b.h0.r.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StringHelper;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f50649a;

    /* renamed from: b  reason: collision with root package name */
    public String f50650b;

    /* renamed from: c  reason: collision with root package name */
    public int f50651c;

    /* renamed from: d  reason: collision with root package name */
    public long f50652d;

    /* renamed from: e  reason: collision with root package name */
    public int f50653e;

    /* renamed from: f  reason: collision with root package name */
    public long f50654f;

    /* renamed from: g  reason: collision with root package name */
    public long f50655g;

    public boolean a() {
        if (StringUtils.isNULL(this.f50649a) || this.f50652d <= 0) {
            return false;
        }
        int i = this.f50653e;
        if (i == 1 || i == 3) {
            long j = this.f50654f;
            if (j > 0) {
                long j2 = this.f50655g;
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
            this.f50649a = bigdayInfo.img_url;
            this.f50650b = bigdayInfo.jump_url;
            this.f50651c = bigdayInfo.img_colour.intValue();
            this.f50652d = bigdayInfo.id.longValue();
            this.f50653e = bigdayInfo.position.intValue();
            this.f50654f = bigdayInfo.start_time.longValue();
            this.f50655g = bigdayInfo.end_time.longValue();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.a() && a() && this.f50652d == aVar.f50652d && StringHelper.equals(this.f50649a, aVar.f50649a) && ((this.f50650b == null && aVar.f50650b == null) || StringHelper.equals(this.f50650b, aVar.f50650b)) && this.f50651c == aVar.f50651c && this.f50653e == aVar.f50653e && this.f50654f == aVar.f50654f && this.f50655g == aVar.f50655g;
        }
        return false;
    }
}

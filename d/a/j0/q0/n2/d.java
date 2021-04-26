package d.a.j0.q0.n2;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TimeHelper;
import java.util.Date;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f58258a;

    /* renamed from: b  reason: collision with root package name */
    public String f58259b;

    public d(String str, String str2) {
        this.f58258a = str;
        this.f58259b = str2;
    }

    public final boolean a(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }

    public final String b() {
        return this.f58258a + "_" + this.f58259b;
    }

    public boolean c() {
        if (a(this.f58258a, this.f58259b)) {
            String b2 = b();
            Date date = new Date(d.a.i0.r.d0.b.j().l(b2, 0L));
            long currentTimeMillis = System.currentTimeMillis();
            if (TimeHelper.getDayDifference(new Date(currentTimeMillis), date) >= 2) {
                d.a.i0.r.d0.b.j().w(b2, currentTimeMillis);
                return true;
            }
            return false;
        }
        return false;
    }
}

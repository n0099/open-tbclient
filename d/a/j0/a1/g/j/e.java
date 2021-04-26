package d.a.j0.a1.g.j;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f50940a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f50941b;

    /* renamed from: c  reason: collision with root package name */
    public long f50942c;

    /* renamed from: d  reason: collision with root package name */
    public String f50943d;

    /* renamed from: e  reason: collision with root package name */
    public int f50944e;

    public boolean a() {
        return this.f50940a > 0;
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.f50940a = dataRes.user_count.intValue();
            this.f50941b = dataRes.portrait_list;
            this.f50942c = dataRes.hide_unix.longValue() * 1000;
            this.f50943d = dataRes.show_tip;
            this.f50944e = dataRes.thread_count.intValue();
        }
    }
}

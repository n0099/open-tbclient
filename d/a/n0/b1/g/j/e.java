package d.a.n0.b1.g.j;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f51806a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f51807b;

    /* renamed from: c  reason: collision with root package name */
    public long f51808c;

    /* renamed from: d  reason: collision with root package name */
    public String f51809d;

    /* renamed from: e  reason: collision with root package name */
    public int f51810e;

    public boolean a() {
        return this.f51806a > 0;
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.f51806a = dataRes.user_count.intValue();
            this.f51807b = dataRes.portrait_list;
            this.f51808c = dataRes.hide_unix.longValue() * 1000;
            this.f51809d = dataRes.show_tip;
            this.f51810e = dataRes.thread_count.intValue();
        }
    }
}

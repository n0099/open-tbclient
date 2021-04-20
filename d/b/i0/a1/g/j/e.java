package d.b.i0.a1.g.j;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f52803a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f52804b;

    /* renamed from: c  reason: collision with root package name */
    public long f52805c;

    /* renamed from: d  reason: collision with root package name */
    public String f52806d;

    /* renamed from: e  reason: collision with root package name */
    public int f52807e;

    public boolean a() {
        return this.f52803a > 0;
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.f52803a = dataRes.user_count.intValue();
            this.f52804b = dataRes.portrait_list;
            this.f52805c = dataRes.hide_unix.longValue() * 1000;
            this.f52806d = dataRes.show_tip;
            this.f52807e = dataRes.thread_count.intValue();
        }
    }
}

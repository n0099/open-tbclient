package d.a.k0.a1.g.j;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f51639a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f51640b;

    /* renamed from: c  reason: collision with root package name */
    public long f51641c;

    /* renamed from: d  reason: collision with root package name */
    public String f51642d;

    /* renamed from: e  reason: collision with root package name */
    public int f51643e;

    public boolean a() {
        return this.f51639a > 0;
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.f51639a = dataRes.user_count.intValue();
            this.f51640b = dataRes.portrait_list;
            this.f51641c = dataRes.hide_unix.longValue() * 1000;
            this.f51642d = dataRes.show_tip;
            this.f51643e = dataRes.thread_count.intValue();
        }
    }
}

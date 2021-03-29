package d.b.i0.z0.g.j;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f63184a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f63185b;

    /* renamed from: c  reason: collision with root package name */
    public long f63186c;

    /* renamed from: d  reason: collision with root package name */
    public String f63187d;

    /* renamed from: e  reason: collision with root package name */
    public int f63188e;

    public boolean a() {
        return this.f63184a > 0;
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.f63184a = dataRes.user_count.intValue();
            this.f63185b = dataRes.portrait_list;
            this.f63186c = dataRes.hide_unix.longValue() * 1000;
            this.f63187d = dataRes.show_tip;
            this.f63188e = dataRes.thread_count.intValue();
        }
    }
}

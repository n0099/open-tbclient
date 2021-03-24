package d.b.i0.z0.g.j;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f63183a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f63184b;

    /* renamed from: c  reason: collision with root package name */
    public long f63185c;

    /* renamed from: d  reason: collision with root package name */
    public String f63186d;

    /* renamed from: e  reason: collision with root package name */
    public int f63187e;

    public boolean a() {
        return this.f63183a > 0;
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.f63183a = dataRes.user_count.intValue();
            this.f63184b = dataRes.portrait_list;
            this.f63185c = dataRes.hide_unix.longValue() * 1000;
            this.f63186d = dataRes.show_tip;
            this.f63187e = dataRes.thread_count.intValue();
        }
    }
}

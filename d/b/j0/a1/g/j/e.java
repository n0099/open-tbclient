package d.b.j0.a1.g.j;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f53224a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f53225b;

    /* renamed from: c  reason: collision with root package name */
    public long f53226c;

    /* renamed from: d  reason: collision with root package name */
    public String f53227d;

    /* renamed from: e  reason: collision with root package name */
    public int f53228e;

    public boolean a() {
        return this.f53224a > 0;
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.f53224a = dataRes.user_count.intValue();
            this.f53225b = dataRes.portrait_list;
            this.f53226c = dataRes.hide_unix.longValue() * 1000;
            this.f53227d = dataRes.show_tip;
            this.f53228e = dataRes.thread_count.intValue();
        }
    }
}

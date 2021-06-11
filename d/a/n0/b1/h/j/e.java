package d.a.n0.b1.h.j;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f55489a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f55490b;

    /* renamed from: c  reason: collision with root package name */
    public long f55491c;

    /* renamed from: d  reason: collision with root package name */
    public String f55492d;

    /* renamed from: e  reason: collision with root package name */
    public int f55493e;

    public boolean a() {
        return this.f55489a > 0;
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.f55489a = dataRes.user_count.intValue();
            this.f55490b = dataRes.portrait_list;
            this.f55491c = dataRes.hide_unix.longValue() * 1000;
            this.f55492d = dataRes.show_tip;
            this.f55493e = dataRes.thread_count.intValue();
        }
    }
}

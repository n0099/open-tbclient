package d.a.o0.b1.h.j;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f55614a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f55615b;

    /* renamed from: c  reason: collision with root package name */
    public long f55616c;

    /* renamed from: d  reason: collision with root package name */
    public String f55617d;

    /* renamed from: e  reason: collision with root package name */
    public int f55618e;

    public boolean a() {
        return this.f55614a > 0;
    }

    public void b(DataRes dataRes) {
        if (dataRes != null) {
            this.f55614a = dataRes.user_count.intValue();
            this.f55615b = dataRes.portrait_list;
            this.f55616c = dataRes.hide_unix.longValue() * 1000;
            this.f55617d = dataRes.show_tip;
            this.f55618e = dataRes.thread_count.intValue();
        }
    }
}

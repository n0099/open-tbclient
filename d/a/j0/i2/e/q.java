package d.a.j0.i2.e;

import d.a.i0.r.q.s1;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public int f55549a;

    /* renamed from: b  reason: collision with root package name */
    public List<User> f55550b;

    public s1 a() {
        s1 s1Var = new s1();
        s1Var.f49261h = false;
        s1Var.A(this.f55550b);
        return s1Var;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f55550b = dataRes.recom_user_list;
        dataRes.has_more.intValue();
        this.f55549a = dataRes.current_page.intValue();
    }
}

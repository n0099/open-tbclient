package d.a.n0.j2.e;

import d.a.m0.r.q.s1;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes5.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public int f56440a;

    /* renamed from: b  reason: collision with root package name */
    public List<User> f56441b;

    public s1 a() {
        s1 s1Var = new s1();
        s1Var.f50124h = false;
        s1Var.A(this.f56441b);
        return s1Var;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f56441b = dataRes.recom_user_list;
        dataRes.has_more.intValue();
        this.f56440a = dataRes.current_page.intValue();
    }
}

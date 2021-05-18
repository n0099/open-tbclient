package d.a.k0.i2.e;

import d.a.j0.r.q.s1;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes5.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public int f56256a;

    /* renamed from: b  reason: collision with root package name */
    public List<User> f56257b;

    public s1 a() {
        s1 s1Var = new s1();
        s1Var.f50080h = false;
        s1Var.A(this.f56257b);
        return s1Var;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f56257b = dataRes.recom_user_list;
        dataRes.has_more.intValue();
        this.f56256a = dataRes.current_page.intValue();
    }
}

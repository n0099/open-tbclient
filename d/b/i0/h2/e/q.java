package d.b.i0.h2.e;

import d.b.h0.r.q.s1;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes5.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public int f55315a;

    /* renamed from: b  reason: collision with root package name */
    public List<User> f55316b;

    public s1 a() {
        s1 s1Var = new s1();
        s1Var.f50885h = false;
        s1Var.A(this.f55316b);
        return s1Var;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f55316b = dataRes.recom_user_list;
        dataRes.has_more.intValue();
        this.f55315a = dataRes.current_page.intValue();
    }
}

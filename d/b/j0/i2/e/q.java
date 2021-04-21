package d.b.j0.i2.e;

import d.b.i0.r.q.s1;
import java.util.List;
import tbclient.GetRecommendGodList.DataRes;
import tbclient.User;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public int f57594a;

    /* renamed from: b  reason: collision with root package name */
    public List<User> f57595b;

    public s1 a() {
        s1 s1Var = new s1();
        s1Var.f51628h = false;
        s1Var.A(this.f57595b);
        return s1Var;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f57595b = dataRes.recom_user_list;
        dataRes.has_more.intValue();
        this.f57594a = dataRes.current_page.intValue();
    }
}

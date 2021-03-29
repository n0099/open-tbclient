package d.b.i0.n0.b;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import java.util.List;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class b implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f57014f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f57015e;

    public int a() {
        return this.f57015e;
    }

    public void e(int i) {
        this.f57015e = i;
    }

    public void f(MemberGodInfo memberGodInfo) {
        List<User> list;
        if (memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0) {
            return;
        }
        e(memberGodInfo.forum_god_num.intValue());
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f57014f;
    }
}

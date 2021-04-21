package d.b.j0.o0.b;

import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import java.util.List;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class b implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f59134f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f59135e;

    public int a() {
        return this.f59135e;
    }

    public void e(int i) {
        this.f59135e = i;
    }

    public void f(MemberGodInfo memberGodInfo) {
        List<User> list;
        if (memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0) {
            return;
        }
        e(memberGodInfo.forum_god_num.intValue());
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f59134f;
    }
}

package d.a.j0.o0.b;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import java.util.List;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class b implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f57159f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f57160e;

    public int c() {
        return this.f57160e;
    }

    public void e(int i2) {
        this.f57160e = i2;
    }

    public void f(MemberGodInfo memberGodInfo) {
        List<User> list;
        if (memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0) {
            return;
        }
        e(memberGodInfo.forum_god_num.intValue());
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f57159f;
    }
}

package d.a.n0.p0.b;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import java.util.List;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class b implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f61666f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f61667e;

    public int b() {
        return this.f61667e;
    }

    public void c(int i2) {
        this.f61667e = i2;
    }

    public void e(MemberGodInfo memberGodInfo) {
        List<User> list;
        if (memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0) {
            return;
        }
        c(memberGodInfo.forum_god_num.intValue());
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f61666f;
    }
}

package d.a.j0.q0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class a implements n {
    public static BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f58525e;

    /* renamed from: f  reason: collision with root package name */
    public String f58526f;

    /* renamed from: g  reason: collision with root package name */
    public String f58527g;

    /* renamed from: h  reason: collision with root package name */
    public String f58528h;

    /* renamed from: i  reason: collision with root package name */
    public String f58529i;

    public String c() {
        return this.f58526f;
    }

    public String e() {
        return this.f58528h;
    }

    public String f() {
        return this.f58529i;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String h() {
        return this.f58525e;
    }

    public String i() {
        return this.f58527g;
    }

    public void k(DataRes dataRes) {
        this.f58527g = dataRes.publish_time;
        BawuRoleInfoPub bawuRoleInfoPub = dataRes.bazhu;
        if (bawuRoleInfoPub != null) {
            this.f58525e = bawuRoleInfoPub.portrait;
            this.f58529i = bawuRoleInfoPub.name_show;
        }
        ForumInfo forumInfo = dataRes.forum;
        if (forumInfo != null) {
            this.f58526f = forumInfo.avatar;
            this.f58528h = forumInfo.forum_name;
        }
    }

    public void l(String str) {
        this.f58526f = str;
    }

    public void m(String str) {
        this.f58528h = str;
    }

    public void o(String str) {
        this.f58529i = str;
    }

    public void p(String str) {
        this.f58525e = str;
    }
}

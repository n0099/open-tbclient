package d.a.k0.q0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class a implements n {
    public static BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f59267e;

    /* renamed from: f  reason: collision with root package name */
    public String f59268f;

    /* renamed from: g  reason: collision with root package name */
    public String f59269g;

    /* renamed from: h  reason: collision with root package name */
    public String f59270h;

    /* renamed from: i  reason: collision with root package name */
    public String f59271i;

    public String c() {
        return this.f59268f;
    }

    public String e() {
        return this.f59270h;
    }

    public String f() {
        return this.f59271i;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String h() {
        return this.f59267e;
    }

    public String i() {
        return this.f59269g;
    }

    public void k(DataRes dataRes) {
        this.f59269g = dataRes.publish_time;
        BawuRoleInfoPub bawuRoleInfoPub = dataRes.bazhu;
        if (bawuRoleInfoPub != null) {
            this.f59267e = bawuRoleInfoPub.portrait;
            this.f59271i = bawuRoleInfoPub.name_show;
        }
        ForumInfo forumInfo = dataRes.forum;
        if (forumInfo != null) {
            this.f59268f = forumInfo.avatar;
            this.f59270h = forumInfo.forum_name;
        }
    }

    public void l(String str) {
        this.f59268f = str;
    }

    public void m(String str) {
        this.f59270h = str;
    }

    public void o(String str) {
        this.f59271i = str;
    }

    public void p(String str) {
        this.f59267e = str;
    }
}

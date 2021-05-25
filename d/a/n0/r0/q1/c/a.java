package d.a.n0.r0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class a implements n {
    public static BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f59408e;

    /* renamed from: f  reason: collision with root package name */
    public String f59409f;

    /* renamed from: g  reason: collision with root package name */
    public String f59410g;

    /* renamed from: h  reason: collision with root package name */
    public String f59411h;

    /* renamed from: i  reason: collision with root package name */
    public String f59412i;

    public String c() {
        return this.f59409f;
    }

    public String e() {
        return this.f59411h;
    }

    public String f() {
        return this.f59412i;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String h() {
        return this.f59408e;
    }

    public String i() {
        return this.f59410g;
    }

    public void k(DataRes dataRes) {
        this.f59410g = dataRes.publish_time;
        BawuRoleInfoPub bawuRoleInfoPub = dataRes.bazhu;
        if (bawuRoleInfoPub != null) {
            this.f59408e = bawuRoleInfoPub.portrait;
            this.f59412i = bawuRoleInfoPub.name_show;
        }
        ForumInfo forumInfo = dataRes.forum;
        if (forumInfo != null) {
            this.f59409f = forumInfo.avatar;
            this.f59411h = forumInfo.forum_name;
        }
    }

    public void l(String str) {
        this.f59409f = str;
    }

    public void m(String str) {
        this.f59411h = str;
    }

    public void o(String str) {
        this.f59412i = str;
    }

    public void p(String str) {
        this.f59408e = str;
    }
}

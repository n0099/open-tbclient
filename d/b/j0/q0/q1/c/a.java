package d.b.j0.q0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class a implements n {
    public static BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60432e;

    /* renamed from: f  reason: collision with root package name */
    public String f60433f;

    /* renamed from: g  reason: collision with root package name */
    public String f60434g;

    /* renamed from: h  reason: collision with root package name */
    public String f60435h;
    public String i;

    public String a() {
        return this.f60433f;
    }

    public String e() {
        return this.f60435h;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.f60432e;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String j() {
        return this.f60434g;
    }

    public void k(DataRes dataRes) {
        this.f60434g = dataRes.publish_time;
        BawuRoleInfoPub bawuRoleInfoPub = dataRes.bazhu;
        if (bawuRoleInfoPub != null) {
            this.f60432e = bawuRoleInfoPub.portrait;
            this.i = bawuRoleInfoPub.name_show;
        }
        ForumInfo forumInfo = dataRes.forum;
        if (forumInfo != null) {
            this.f60433f = forumInfo.avatar;
            this.f60435h = forumInfo.forum_name;
        }
    }

    public void l(String str) {
        this.f60433f = str;
    }

    public void n(String str) {
        this.f60435h = str;
    }

    public void o(String str) {
        this.i = str;
    }

    public void p(String str) {
        this.f60432e = str;
    }
}

package d.b.i0.q0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class a implements n {
    public static BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60011e;

    /* renamed from: f  reason: collision with root package name */
    public String f60012f;

    /* renamed from: g  reason: collision with root package name */
    public String f60013g;

    /* renamed from: h  reason: collision with root package name */
    public String f60014h;
    public String i;

    public String a() {
        return this.f60012f;
    }

    public String e() {
        return this.f60014h;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.f60011e;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String j() {
        return this.f60013g;
    }

    public void k(DataRes dataRes) {
        this.f60013g = dataRes.publish_time;
        BawuRoleInfoPub bawuRoleInfoPub = dataRes.bazhu;
        if (bawuRoleInfoPub != null) {
            this.f60011e = bawuRoleInfoPub.portrait;
            this.i = bawuRoleInfoPub.name_show;
        }
        ForumInfo forumInfo = dataRes.forum;
        if (forumInfo != null) {
            this.f60012f = forumInfo.avatar;
            this.f60014h = forumInfo.forum_name;
        }
    }

    public void l(String str) {
        this.f60012f = str;
    }

    public void n(String str) {
        this.f60014h = str;
    }

    public void o(String str) {
        this.i = str;
    }

    public void p(String str) {
        this.f60011e = str;
    }
}

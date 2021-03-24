package d.b.i0.p0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class a implements n {
    public static BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f58348e;

    /* renamed from: f  reason: collision with root package name */
    public String f58349f;

    /* renamed from: g  reason: collision with root package name */
    public String f58350g;

    /* renamed from: h  reason: collision with root package name */
    public String f58351h;
    public String i;

    public String a() {
        return this.f58349f;
    }

    public String e() {
        return this.f58351h;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.f58348e;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String j() {
        return this.f58350g;
    }

    public void k(DataRes dataRes) {
        this.f58350g = dataRes.publish_time;
        BawuRoleInfoPub bawuRoleInfoPub = dataRes.bazhu;
        if (bawuRoleInfoPub != null) {
            this.f58348e = bawuRoleInfoPub.portrait;
            this.i = bawuRoleInfoPub.name_show;
        }
        ForumInfo forumInfo = dataRes.forum;
        if (forumInfo != null) {
            this.f58349f = forumInfo.avatar;
            this.f58351h = forumInfo.forum_name;
        }
    }

    public void l(String str) {
        this.f58349f = str;
    }

    public void n(String str) {
        this.f58351h = str;
    }

    public void o(String str) {
        this.i = str;
    }

    public void p(String str) {
        this.f58348e = str;
    }
}

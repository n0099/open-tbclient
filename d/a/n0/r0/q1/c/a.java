package d.a.n0.r0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class a implements n {
    public static BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f63099e;

    /* renamed from: f  reason: collision with root package name */
    public String f63100f;

    /* renamed from: g  reason: collision with root package name */
    public String f63101g;

    /* renamed from: h  reason: collision with root package name */
    public String f63102h;

    /* renamed from: i  reason: collision with root package name */
    public String f63103i;

    public String b() {
        return this.f63100f;
    }

    public String c() {
        return this.f63102h;
    }

    public String e() {
        return this.f63103i;
    }

    public String g() {
        return this.f63099e;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String h() {
        return this.f63101g;
    }

    public void i(DataRes dataRes) {
        this.f63101g = dataRes.publish_time;
        BawuRoleInfoPub bawuRoleInfoPub = dataRes.bazhu;
        if (bawuRoleInfoPub != null) {
            this.f63099e = bawuRoleInfoPub.portrait;
            this.f63103i = bawuRoleInfoPub.name_show;
        }
        ForumInfo forumInfo = dataRes.forum;
        if (forumInfo != null) {
            this.f63100f = forumInfo.avatar;
            this.f63102h = forumInfo.forum_name;
        }
    }

    public void k(String str) {
        this.f63100f = str;
    }

    public void l(String str) {
        this.f63102h = str;
    }

    public void n(String str) {
        this.f63103i = str;
    }

    public void o(String str) {
        this.f63099e = str;
    }
}

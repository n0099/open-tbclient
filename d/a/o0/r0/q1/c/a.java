package d.a.o0.r0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class a implements n {
    public static BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f63224e;

    /* renamed from: f  reason: collision with root package name */
    public String f63225f;

    /* renamed from: g  reason: collision with root package name */
    public String f63226g;

    /* renamed from: h  reason: collision with root package name */
    public String f63227h;

    /* renamed from: i  reason: collision with root package name */
    public String f63228i;

    public String b() {
        return this.f63225f;
    }

    public String c() {
        return this.f63227h;
    }

    public String e() {
        return this.f63228i;
    }

    public String g() {
        return this.f63224e;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String h() {
        return this.f63226g;
    }

    public void i(DataRes dataRes) {
        this.f63226g = dataRes.publish_time;
        BawuRoleInfoPub bawuRoleInfoPub = dataRes.bazhu;
        if (bawuRoleInfoPub != null) {
            this.f63224e = bawuRoleInfoPub.portrait;
            this.f63228i = bawuRoleInfoPub.name_show;
        }
        ForumInfo forumInfo = dataRes.forum;
        if (forumInfo != null) {
            this.f63225f = forumInfo.avatar;
            this.f63227h = forumInfo.forum_name;
        }
    }

    public void k(String str) {
        this.f63225f = str;
    }

    public void l(String str) {
        this.f63227h = str;
    }

    public void n(String str) {
        this.f63228i = str;
    }

    public void o(String str) {
        this.f63224e = str;
    }
}

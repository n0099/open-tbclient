package d.a.n0.r0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRule;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class b implements n {
    public static BdUniqueId q = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public ForumInfo f59413e;

    /* renamed from: f  reason: collision with root package name */
    public String f59414f;

    /* renamed from: g  reason: collision with root package name */
    public String f59415g;

    /* renamed from: h  reason: collision with root package name */
    public List<ForumRule> f59416h;

    /* renamed from: i  reason: collision with root package name */
    public int f59417i;
    public String j;
    public boolean k;
    public String l;
    public BawuRoleInfoPub m;
    public String n;
    public d o;
    public a p;

    public String c() {
        return this.j;
    }

    public int e() {
        return this.f59417i;
    }

    public BawuRoleInfoPub f() {
        return this.m;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return q;
    }

    public String h() {
        return this.n;
    }

    public ForumInfo i() {
        return this.f59413e;
    }

    public boolean k() {
        return this.k;
    }

    public String l() {
        return this.f59415g;
    }

    public String m() {
        return this.l;
    }

    public List<ForumRule> o() {
        return this.f59416h;
    }

    public String p() {
        return this.f59414f;
    }

    public a q() {
        return this.p;
    }

    public void r(DataRes dataRes) {
        if (dataRes != null) {
            this.f59413e = dataRes.forum;
            this.f59414f = dataRes.title;
            this.f59415g = dataRes.preface;
            this.f59416h = dataRes.rules;
            this.f59417i = dataRes.audit_status.intValue();
            this.j = dataRes.audit_opinion;
            this.k = dataRes.is_manager.intValue() == 1;
            Long l = dataRes.forum_rule_id;
            this.l = dataRes.publish_time;
            this.m = dataRes.bazhu;
            this.n = dataRes.cur_time;
            d dVar = new d();
            this.o = dVar;
            dVar.c(dataRes);
            a aVar = new a();
            this.p = aVar;
            aVar.k(dataRes);
        }
    }

    public void s(BawuRoleInfoPub bawuRoleInfoPub) {
        this.m = bawuRoleInfoPub;
    }

    public void t(ForumInfo forumInfo) {
        this.f59413e = forumInfo;
    }

    public void u(boolean z) {
        this.k = z;
    }

    public void v(String str) {
        this.f59415g = str;
    }
}

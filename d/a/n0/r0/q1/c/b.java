package d.a.n0.r0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRule;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class b implements n {
    public static BdUniqueId q = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public ForumInfo f63104e;

    /* renamed from: f  reason: collision with root package name */
    public String f63105f;

    /* renamed from: g  reason: collision with root package name */
    public String f63106g;

    /* renamed from: h  reason: collision with root package name */
    public List<ForumRule> f63107h;

    /* renamed from: i  reason: collision with root package name */
    public int f63108i;
    public String j;
    public boolean k;
    public String l;
    public BawuRoleInfoPub m;
    public String n;
    public d o;
    public a p;

    public String b() {
        return this.j;
    }

    public int c() {
        return this.f63108i;
    }

    public BawuRoleInfoPub e() {
        return this.m;
    }

    public String g() {
        return this.n;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return q;
    }

    public ForumInfo h() {
        return this.f63104e;
    }

    public boolean i() {
        return this.k;
    }

    public String k() {
        return this.f63106g;
    }

    public String l() {
        return this.l;
    }

    public List<ForumRule> n() {
        return this.f63107h;
    }

    public String o() {
        return this.f63105f;
    }

    public a p() {
        return this.p;
    }

    public void q(DataRes dataRes) {
        if (dataRes != null) {
            this.f63104e = dataRes.forum;
            this.f63105f = dataRes.title;
            this.f63106g = dataRes.preface;
            this.f63107h = dataRes.rules;
            this.f63108i = dataRes.audit_status.intValue();
            this.j = dataRes.audit_opinion;
            this.k = dataRes.is_manager.intValue() == 1;
            Long l = dataRes.forum_rule_id;
            this.l = dataRes.publish_time;
            this.m = dataRes.bazhu;
            this.n = dataRes.cur_time;
            d dVar = new d();
            this.o = dVar;
            dVar.b(dataRes);
            a aVar = new a();
            this.p = aVar;
            aVar.i(dataRes);
        }
    }

    public void s(BawuRoleInfoPub bawuRoleInfoPub) {
        this.m = bawuRoleInfoPub;
    }

    public void t(ForumInfo forumInfo) {
        this.f63104e = forumInfo;
    }

    public void u(boolean z) {
        this.k = z;
    }

    public void v(String str) {
        this.f63106g = str;
    }
}

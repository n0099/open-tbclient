package d.b.i0.p0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRule;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class b implements n {
    public static BdUniqueId q = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public ForumInfo f58352e;

    /* renamed from: f  reason: collision with root package name */
    public String f58353f;

    /* renamed from: g  reason: collision with root package name */
    public String f58354g;

    /* renamed from: h  reason: collision with root package name */
    public List<ForumRule> f58355h;
    public int i;
    public String j;
    public boolean k;
    public String l;
    public BawuRoleInfoPub m;
    public String n;
    public d o;
    public a p;

    public String a() {
        return this.j;
    }

    public int e() {
        return this.i;
    }

    public BawuRoleInfoPub f() {
        return this.m;
    }

    public String g() {
        return this.n;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return q;
    }

    public ForumInfo j() {
        return this.f58352e;
    }

    public boolean k() {
        return this.k;
    }

    public String l() {
        return this.f58354g;
    }

    public String n() {
        return this.l;
    }

    public List<ForumRule> o() {
        return this.f58355h;
    }

    public String p() {
        return this.f58353f;
    }

    public a q() {
        return this.p;
    }

    public void r(DataRes dataRes) {
        if (dataRes != null) {
            this.f58352e = dataRes.forum;
            this.f58353f = dataRes.title;
            this.f58354g = dataRes.preface;
            this.f58355h = dataRes.rules;
            this.i = dataRes.audit_status.intValue();
            this.j = dataRes.audit_opinion;
            this.k = dataRes.is_manager.intValue() == 1;
            Long l = dataRes.forum_rule_id;
            this.l = dataRes.publish_time;
            this.m = dataRes.bazhu;
            this.n = dataRes.cur_time;
            d dVar = new d();
            this.o = dVar;
            dVar.a(dataRes);
            a aVar = new a();
            this.p = aVar;
            aVar.k(dataRes);
        }
    }

    public void s(BawuRoleInfoPub bawuRoleInfoPub) {
        this.m = bawuRoleInfoPub;
    }

    public void t(ForumInfo forumInfo) {
        this.f58352e = forumInfo;
    }

    public void u(boolean z) {
        this.k = z;
    }

    public void v(String str) {
        this.f58354g = str;
    }
}

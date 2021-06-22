package d.a.o0.j0.d;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import d.a.n0.r.q.o1;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public boolean f59659g;

    /* renamed from: i  reason: collision with root package name */
    public HotSearchInfoData f59661i;
    public int j;

    /* renamed from: h  reason: collision with root package name */
    public int f59660h = 0;

    /* renamed from: a  reason: collision with root package name */
    public g f59653a = new g();

    /* renamed from: b  reason: collision with root package name */
    public o1 f59654b = new o1();

    /* renamed from: c  reason: collision with root package name */
    public ForumCreateInfoData f59655c = new ForumCreateInfoData();

    /* renamed from: d  reason: collision with root package name */
    public PrivateForumPopInfoData f59656d = new PrivateForumPopInfoData();

    /* renamed from: e  reason: collision with root package name */
    public j f59657e = new j();

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.j0.f.a.a f59658f = new d.a.o0.j0.f.a.a();

    public d() {
        this.f59659g = true;
        this.f59659g = false;
    }

    public boolean a() {
        return System.currentTimeMillis() / d.a.n0.t.e.f54559a.longValue() == (((long) this.f59660h) * 1000) / d.a.n0.t.e.f54559a.longValue();
    }

    public ForumCreateInfoData b() {
        return this.f59655c;
    }

    public d.a.o0.j0.f.a.a c() {
        return this.f59658f;
    }

    public HotSearchInfoData d() {
        return this.f59661i;
    }

    public g e() {
        return this.f59653a;
    }

    public PrivateForumPopInfoData f() {
        return this.f59656d;
    }

    public o1 g() {
        return this.f59654b;
    }

    public int h() {
        return this.j;
    }

    public boolean i() {
        return this.f59659g;
    }

    public void j(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        try {
            if (dataRes.forum_popup_info != null) {
                this.f59658f.f(dataRes.forum_popup_info);
            }
            s(dataRes.time.intValue());
            this.j = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
            if (dataRes.like_forum != null) {
                this.f59653a.c(dataRes.like_forum);
            }
            if (dataRes.recommend_forum_info != null) {
                this.f59654b.C(dataRes.recommend_forum_info);
            }
            if (dataRes.forum_create_info != null) {
                this.f59655c.A(dataRes.forum_create_info);
            }
            if (dataRes.private_forum_popinfo != null) {
                this.f59656d.A(dataRes.private_forum_popinfo);
            }
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.f59661i = hotSearchInfoData;
                hotSearchInfoData.x(dataRes.hot_search);
            }
            if (dataRes.nav_tab_info != null) {
                this.f59657e.a(dataRes.nav_tab_info);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void k(ForumCreateInfoData forumCreateInfoData) {
        this.f59655c = forumCreateInfoData;
    }

    public void l(HotSearchInfoData hotSearchInfoData) {
        this.f59661i = hotSearchInfoData;
    }

    public void m(boolean z) {
        this.f59659g = z;
    }

    public void n(g gVar) {
        this.f59653a = gVar;
    }

    public void o(PrivateForumPopInfoData privateForumPopInfoData) {
        this.f59656d = privateForumPopInfoData;
    }

    public void p(o1 o1Var) {
        this.f59654b = o1Var;
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(j jVar) {
        this.f59657e = jVar;
    }

    public void s(int i2) {
        this.f59660h = i2;
    }

    public void t(d.a.o0.j0.f.a.a aVar) {
        this.f59658f = aVar;
    }
}

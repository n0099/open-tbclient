package d.b.i0.i0.d;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import d.b.h0.r.q.o1;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public boolean f56610g;
    public HotSearchInfoData i;
    public int j;

    /* renamed from: h  reason: collision with root package name */
    public int f56611h = 0;

    /* renamed from: a  reason: collision with root package name */
    public g f56604a = new g();

    /* renamed from: b  reason: collision with root package name */
    public o1 f56605b = new o1();

    /* renamed from: c  reason: collision with root package name */
    public ForumCreateInfoData f56606c = new ForumCreateInfoData();

    /* renamed from: d  reason: collision with root package name */
    public PrivateForumPopInfoData f56607d = new PrivateForumPopInfoData();

    /* renamed from: e  reason: collision with root package name */
    public j f56608e = new j();

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.i0.f.a.a f56609f = new d.b.i0.i0.f.a.a();

    public d() {
        this.f56610g = true;
        this.f56610g = false;
    }

    public boolean a() {
        return System.currentTimeMillis() / d.b.h0.t.e.f51879a.longValue() == (((long) this.f56611h) * 1000) / d.b.h0.t.e.f51879a.longValue();
    }

    public ForumCreateInfoData b() {
        return this.f56606c;
    }

    public d.b.i0.i0.f.a.a c() {
        return this.f56609f;
    }

    public HotSearchInfoData d() {
        return this.i;
    }

    public g e() {
        return this.f56604a;
    }

    public PrivateForumPopInfoData f() {
        return this.f56607d;
    }

    public o1 g() {
        return this.f56605b;
    }

    public int h() {
        return this.j;
    }

    public boolean i() {
        return this.f56610g;
    }

    public void j(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        try {
            if (dataRes.forum_popup_info != null) {
                this.f56609f.f(dataRes.forum_popup_info);
            }
            s(dataRes.time.intValue());
            this.j = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
            if (dataRes.like_forum != null) {
                this.f56604a.c(dataRes.like_forum);
            }
            if (dataRes.recommend_forum_info != null) {
                this.f56605b.C(dataRes.recommend_forum_info);
            }
            if (dataRes.forum_create_info != null) {
                this.f56606c.w(dataRes.forum_create_info);
            }
            if (dataRes.private_forum_popinfo != null) {
                this.f56607d.w(dataRes.private_forum_popinfo);
            }
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.i = hotSearchInfoData;
                hotSearchInfoData.t(dataRes.hot_search);
            }
            if (dataRes.nav_tab_info != null) {
                this.f56608e.a(dataRes.nav_tab_info);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void k(ForumCreateInfoData forumCreateInfoData) {
        this.f56606c = forumCreateInfoData;
    }

    public void l(HotSearchInfoData hotSearchInfoData) {
        this.i = hotSearchInfoData;
    }

    public void m(boolean z) {
        this.f56610g = z;
    }

    public void n(g gVar) {
        this.f56604a = gVar;
    }

    public void o(PrivateForumPopInfoData privateForumPopInfoData) {
        this.f56607d = privateForumPopInfoData;
    }

    public void p(o1 o1Var) {
        this.f56605b = o1Var;
    }

    public void q(int i) {
        this.j = i;
    }

    public void r(j jVar) {
        this.f56608e = jVar;
    }

    public void s(int i) {
        this.f56611h = i;
    }

    public void t(d.b.i0.i0.f.a.a aVar) {
        this.f56609f = aVar;
    }
}

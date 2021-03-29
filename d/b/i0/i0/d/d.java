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
    public boolean f55487g;
    public HotSearchInfoData i;
    public int j;

    /* renamed from: h  reason: collision with root package name */
    public int f55488h = 0;

    /* renamed from: a  reason: collision with root package name */
    public g f55481a = new g();

    /* renamed from: b  reason: collision with root package name */
    public o1 f55482b = new o1();

    /* renamed from: c  reason: collision with root package name */
    public ForumCreateInfoData f55483c = new ForumCreateInfoData();

    /* renamed from: d  reason: collision with root package name */
    public PrivateForumPopInfoData f55484d = new PrivateForumPopInfoData();

    /* renamed from: e  reason: collision with root package name */
    public j f55485e = new j();

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.i0.f.a.a f55486f = new d.b.i0.i0.f.a.a();

    public d() {
        this.f55487g = true;
        this.f55487g = false;
    }

    public boolean a() {
        return System.currentTimeMillis() / d.b.h0.t.d.f51458a.longValue() == (((long) this.f55488h) * 1000) / d.b.h0.t.d.f51458a.longValue();
    }

    public ForumCreateInfoData b() {
        return this.f55483c;
    }

    public d.b.i0.i0.f.a.a c() {
        return this.f55486f;
    }

    public HotSearchInfoData d() {
        return this.i;
    }

    public g e() {
        return this.f55481a;
    }

    public PrivateForumPopInfoData f() {
        return this.f55484d;
    }

    public o1 g() {
        return this.f55482b;
    }

    public int h() {
        return this.j;
    }

    public boolean i() {
        return this.f55487g;
    }

    public void j(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        try {
            if (dataRes.forum_popup_info != null) {
                this.f55486f.f(dataRes.forum_popup_info);
            }
            s(dataRes.time.intValue());
            this.j = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
            if (dataRes.like_forum != null) {
                this.f55481a.c(dataRes.like_forum);
            }
            if (dataRes.recommend_forum_info != null) {
                this.f55482b.C(dataRes.recommend_forum_info);
            }
            if (dataRes.forum_create_info != null) {
                this.f55483c.w(dataRes.forum_create_info);
            }
            if (dataRes.private_forum_popinfo != null) {
                this.f55484d.w(dataRes.private_forum_popinfo);
            }
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.i = hotSearchInfoData;
                hotSearchInfoData.t(dataRes.hot_search);
            }
            if (dataRes.nav_tab_info != null) {
                this.f55485e.a(dataRes.nav_tab_info);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void k(ForumCreateInfoData forumCreateInfoData) {
        this.f55483c = forumCreateInfoData;
    }

    public void l(HotSearchInfoData hotSearchInfoData) {
        this.i = hotSearchInfoData;
    }

    public void m(boolean z) {
        this.f55487g = z;
    }

    public void n(g gVar) {
        this.f55481a = gVar;
    }

    public void o(PrivateForumPopInfoData privateForumPopInfoData) {
        this.f55484d = privateForumPopInfoData;
    }

    public void p(o1 o1Var) {
        this.f55482b = o1Var;
    }

    public void q(int i) {
        this.j = i;
    }

    public void r(j jVar) {
        this.f55485e = jVar;
    }

    public void s(int i) {
        this.f55488h = i;
    }

    public void t(d.b.i0.i0.f.a.a aVar) {
        this.f55486f = aVar;
    }
}

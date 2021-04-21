package d.b.j0.i0.d;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import d.b.i0.r.q.o1;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public boolean f57031g;
    public HotSearchInfoData i;
    public int j;

    /* renamed from: h  reason: collision with root package name */
    public int f57032h = 0;

    /* renamed from: a  reason: collision with root package name */
    public g f57025a = new g();

    /* renamed from: b  reason: collision with root package name */
    public o1 f57026b = new o1();

    /* renamed from: c  reason: collision with root package name */
    public ForumCreateInfoData f57027c = new ForumCreateInfoData();

    /* renamed from: d  reason: collision with root package name */
    public PrivateForumPopInfoData f57028d = new PrivateForumPopInfoData();

    /* renamed from: e  reason: collision with root package name */
    public j f57029e = new j();

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.i0.f.a.a f57030f = new d.b.j0.i0.f.a.a();

    public d() {
        this.f57031g = true;
        this.f57031g = false;
    }

    public boolean a() {
        return System.currentTimeMillis() / d.b.i0.t.e.f52215a.longValue() == (((long) this.f57032h) * 1000) / d.b.i0.t.e.f52215a.longValue();
    }

    public ForumCreateInfoData b() {
        return this.f57027c;
    }

    public d.b.j0.i0.f.a.a c() {
        return this.f57030f;
    }

    public HotSearchInfoData d() {
        return this.i;
    }

    public g e() {
        return this.f57025a;
    }

    public PrivateForumPopInfoData f() {
        return this.f57028d;
    }

    public o1 g() {
        return this.f57026b;
    }

    public int h() {
        return this.j;
    }

    public boolean i() {
        return this.f57031g;
    }

    public void j(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        try {
            if (dataRes.forum_popup_info != null) {
                this.f57030f.f(dataRes.forum_popup_info);
            }
            s(dataRes.time.intValue());
            this.j = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
            if (dataRes.like_forum != null) {
                this.f57025a.c(dataRes.like_forum);
            }
            if (dataRes.recommend_forum_info != null) {
                this.f57026b.C(dataRes.recommend_forum_info);
            }
            if (dataRes.forum_create_info != null) {
                this.f57027c.w(dataRes.forum_create_info);
            }
            if (dataRes.private_forum_popinfo != null) {
                this.f57028d.w(dataRes.private_forum_popinfo);
            }
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.i = hotSearchInfoData;
                hotSearchInfoData.t(dataRes.hot_search);
            }
            if (dataRes.nav_tab_info != null) {
                this.f57029e.a(dataRes.nav_tab_info);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void k(ForumCreateInfoData forumCreateInfoData) {
        this.f57027c = forumCreateInfoData;
    }

    public void l(HotSearchInfoData hotSearchInfoData) {
        this.i = hotSearchInfoData;
    }

    public void m(boolean z) {
        this.f57031g = z;
    }

    public void n(g gVar) {
        this.f57025a = gVar;
    }

    public void o(PrivateForumPopInfoData privateForumPopInfoData) {
        this.f57028d = privateForumPopInfoData;
    }

    public void p(o1 o1Var) {
        this.f57026b = o1Var;
    }

    public void q(int i) {
        this.j = i;
    }

    public void r(j jVar) {
        this.f57029e = jVar;
    }

    public void s(int i) {
        this.f57032h = i;
    }

    public void t(d.b.j0.i0.f.a.a aVar) {
        this.f57030f = aVar;
    }
}

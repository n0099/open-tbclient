package d.a.k0.i0.d;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import d.a.j0.r.q.o1;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public boolean f55661g;

    /* renamed from: i  reason: collision with root package name */
    public HotSearchInfoData f55663i;
    public int j;

    /* renamed from: h  reason: collision with root package name */
    public int f55662h = 0;

    /* renamed from: a  reason: collision with root package name */
    public g f55655a = new g();

    /* renamed from: b  reason: collision with root package name */
    public o1 f55656b = new o1();

    /* renamed from: c  reason: collision with root package name */
    public ForumCreateInfoData f55657c = new ForumCreateInfoData();

    /* renamed from: d  reason: collision with root package name */
    public PrivateForumPopInfoData f55658d = new PrivateForumPopInfoData();

    /* renamed from: e  reason: collision with root package name */
    public j f55659e = new j();

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.i0.f.a.a f55660f = new d.a.k0.i0.f.a.a();

    public d() {
        this.f55661g = true;
        this.f55661g = false;
    }

    public boolean a() {
        return System.currentTimeMillis() / d.a.j0.t.e.f50702a.longValue() == (((long) this.f55662h) * 1000) / d.a.j0.t.e.f50702a.longValue();
    }

    public ForumCreateInfoData b() {
        return this.f55657c;
    }

    public d.a.k0.i0.f.a.a c() {
        return this.f55660f;
    }

    public HotSearchInfoData d() {
        return this.f55663i;
    }

    public g e() {
        return this.f55655a;
    }

    public PrivateForumPopInfoData f() {
        return this.f55658d;
    }

    public o1 g() {
        return this.f55656b;
    }

    public int h() {
        return this.j;
    }

    public boolean i() {
        return this.f55661g;
    }

    public void j(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        try {
            if (dataRes.forum_popup_info != null) {
                this.f55660f.f(dataRes.forum_popup_info);
            }
            s(dataRes.time.intValue());
            this.j = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
            if (dataRes.like_forum != null) {
                this.f55655a.c(dataRes.like_forum);
            }
            if (dataRes.recommend_forum_info != null) {
                this.f55656b.C(dataRes.recommend_forum_info);
            }
            if (dataRes.forum_create_info != null) {
                this.f55657c.w(dataRes.forum_create_info);
            }
            if (dataRes.private_forum_popinfo != null) {
                this.f55658d.w(dataRes.private_forum_popinfo);
            }
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.f55663i = hotSearchInfoData;
                hotSearchInfoData.t(dataRes.hot_search);
            }
            if (dataRes.nav_tab_info != null) {
                this.f55659e.a(dataRes.nav_tab_info);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void k(ForumCreateInfoData forumCreateInfoData) {
        this.f55657c = forumCreateInfoData;
    }

    public void l(HotSearchInfoData hotSearchInfoData) {
        this.f55663i = hotSearchInfoData;
    }

    public void m(boolean z) {
        this.f55661g = z;
    }

    public void n(g gVar) {
        this.f55655a = gVar;
    }

    public void o(PrivateForumPopInfoData privateForumPopInfoData) {
        this.f55658d = privateForumPopInfoData;
    }

    public void p(o1 o1Var) {
        this.f55656b = o1Var;
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(j jVar) {
        this.f55659e = jVar;
    }

    public void s(int i2) {
        this.f55662h = i2;
    }

    public void t(d.a.k0.i0.f.a.a aVar) {
        this.f55660f = aVar;
    }
}

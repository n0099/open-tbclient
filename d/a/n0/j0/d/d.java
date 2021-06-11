package d.a.n0.j0.d;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import d.a.m0.r.q.o1;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public boolean f59534g;

    /* renamed from: i  reason: collision with root package name */
    public HotSearchInfoData f59536i;
    public int j;

    /* renamed from: h  reason: collision with root package name */
    public int f59535h = 0;

    /* renamed from: a  reason: collision with root package name */
    public g f59528a = new g();

    /* renamed from: b  reason: collision with root package name */
    public o1 f59529b = new o1();

    /* renamed from: c  reason: collision with root package name */
    public ForumCreateInfoData f59530c = new ForumCreateInfoData();

    /* renamed from: d  reason: collision with root package name */
    public PrivateForumPopInfoData f59531d = new PrivateForumPopInfoData();

    /* renamed from: e  reason: collision with root package name */
    public j f59532e = new j();

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.j0.f.a.a f59533f = new d.a.n0.j0.f.a.a();

    public d() {
        this.f59534g = true;
        this.f59534g = false;
    }

    public boolean a() {
        return System.currentTimeMillis() / d.a.m0.t.e.f54452a.longValue() == (((long) this.f59535h) * 1000) / d.a.m0.t.e.f54452a.longValue();
    }

    public ForumCreateInfoData b() {
        return this.f59530c;
    }

    public d.a.n0.j0.f.a.a c() {
        return this.f59533f;
    }

    public HotSearchInfoData d() {
        return this.f59536i;
    }

    public g e() {
        return this.f59528a;
    }

    public PrivateForumPopInfoData f() {
        return this.f59531d;
    }

    public o1 g() {
        return this.f59529b;
    }

    public int h() {
        return this.j;
    }

    public boolean i() {
        return this.f59534g;
    }

    public void j(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        try {
            if (dataRes.forum_popup_info != null) {
                this.f59533f.f(dataRes.forum_popup_info);
            }
            s(dataRes.time.intValue());
            this.j = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
            if (dataRes.like_forum != null) {
                this.f59528a.c(dataRes.like_forum);
            }
            if (dataRes.recommend_forum_info != null) {
                this.f59529b.C(dataRes.recommend_forum_info);
            }
            if (dataRes.forum_create_info != null) {
                this.f59530c.A(dataRes.forum_create_info);
            }
            if (dataRes.private_forum_popinfo != null) {
                this.f59531d.A(dataRes.private_forum_popinfo);
            }
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.f59536i = hotSearchInfoData;
                hotSearchInfoData.x(dataRes.hot_search);
            }
            if (dataRes.nav_tab_info != null) {
                this.f59532e.a(dataRes.nav_tab_info);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void k(ForumCreateInfoData forumCreateInfoData) {
        this.f59530c = forumCreateInfoData;
    }

    public void l(HotSearchInfoData hotSearchInfoData) {
        this.f59536i = hotSearchInfoData;
    }

    public void m(boolean z) {
        this.f59534g = z;
    }

    public void n(g gVar) {
        this.f59528a = gVar;
    }

    public void o(PrivateForumPopInfoData privateForumPopInfoData) {
        this.f59531d = privateForumPopInfoData;
    }

    public void p(o1 o1Var) {
        this.f59529b = o1Var;
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(j jVar) {
        this.f59532e = jVar;
    }

    public void s(int i2) {
        this.f59535h = i2;
    }

    public void t(d.a.n0.j0.f.a.a aVar) {
        this.f59533f = aVar;
    }
}

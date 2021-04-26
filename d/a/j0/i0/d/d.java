package d.a.j0.i0.d;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import d.a.i0.r.q.o1;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public boolean f54954g;

    /* renamed from: i  reason: collision with root package name */
    public HotSearchInfoData f54956i;
    public int j;

    /* renamed from: h  reason: collision with root package name */
    public int f54955h = 0;

    /* renamed from: a  reason: collision with root package name */
    public g f54948a = new g();

    /* renamed from: b  reason: collision with root package name */
    public o1 f54949b = new o1();

    /* renamed from: c  reason: collision with root package name */
    public ForumCreateInfoData f54950c = new ForumCreateInfoData();

    /* renamed from: d  reason: collision with root package name */
    public PrivateForumPopInfoData f54951d = new PrivateForumPopInfoData();

    /* renamed from: e  reason: collision with root package name */
    public j f54952e = new j();

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.i0.f.a.a f54953f = new d.a.j0.i0.f.a.a();

    public d() {
        this.f54954g = true;
        this.f54954g = false;
    }

    public boolean a() {
        return System.currentTimeMillis() / d.a.i0.t.e.f49883a.longValue() == (((long) this.f54955h) * 1000) / d.a.i0.t.e.f49883a.longValue();
    }

    public ForumCreateInfoData b() {
        return this.f54950c;
    }

    public d.a.j0.i0.f.a.a c() {
        return this.f54953f;
    }

    public HotSearchInfoData d() {
        return this.f54956i;
    }

    public g e() {
        return this.f54948a;
    }

    public PrivateForumPopInfoData f() {
        return this.f54951d;
    }

    public o1 g() {
        return this.f54949b;
    }

    public int h() {
        return this.j;
    }

    public boolean i() {
        return this.f54954g;
    }

    public void j(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        try {
            if (dataRes.forum_popup_info != null) {
                this.f54953f.f(dataRes.forum_popup_info);
            }
            s(dataRes.time.intValue());
            this.j = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
            if (dataRes.like_forum != null) {
                this.f54948a.c(dataRes.like_forum);
            }
            if (dataRes.recommend_forum_info != null) {
                this.f54949b.C(dataRes.recommend_forum_info);
            }
            if (dataRes.forum_create_info != null) {
                this.f54950c.w(dataRes.forum_create_info);
            }
            if (dataRes.private_forum_popinfo != null) {
                this.f54951d.w(dataRes.private_forum_popinfo);
            }
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.f54956i = hotSearchInfoData;
                hotSearchInfoData.t(dataRes.hot_search);
            }
            if (dataRes.nav_tab_info != null) {
                this.f54952e.a(dataRes.nav_tab_info);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void k(ForumCreateInfoData forumCreateInfoData) {
        this.f54950c = forumCreateInfoData;
    }

    public void l(HotSearchInfoData hotSearchInfoData) {
        this.f54956i = hotSearchInfoData;
    }

    public void m(boolean z) {
        this.f54954g = z;
    }

    public void n(g gVar) {
        this.f54948a = gVar;
    }

    public void o(PrivateForumPopInfoData privateForumPopInfoData) {
        this.f54951d = privateForumPopInfoData;
    }

    public void p(o1 o1Var) {
        this.f54949b = o1Var;
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(j jVar) {
        this.f54952e = jVar;
    }

    public void s(int i2) {
        this.f54955h = i2;
    }

    public void t(d.a.j0.i0.f.a.a aVar) {
        this.f54953f = aVar;
    }
}

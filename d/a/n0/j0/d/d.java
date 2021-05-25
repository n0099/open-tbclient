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
    public boolean f55845g;

    /* renamed from: i  reason: collision with root package name */
    public HotSearchInfoData f55847i;
    public int j;

    /* renamed from: h  reason: collision with root package name */
    public int f55846h = 0;

    /* renamed from: a  reason: collision with root package name */
    public g f55839a = new g();

    /* renamed from: b  reason: collision with root package name */
    public o1 f55840b = new o1();

    /* renamed from: c  reason: collision with root package name */
    public ForumCreateInfoData f55841c = new ForumCreateInfoData();

    /* renamed from: d  reason: collision with root package name */
    public PrivateForumPopInfoData f55842d = new PrivateForumPopInfoData();

    /* renamed from: e  reason: collision with root package name */
    public j f55843e = new j();

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.j0.f.a.a f55844f = new d.a.n0.j0.f.a.a();

    public d() {
        this.f55845g = true;
        this.f55845g = false;
    }

    public boolean a() {
        return System.currentTimeMillis() / d.a.m0.t.e.f50775a.longValue() == (((long) this.f55846h) * 1000) / d.a.m0.t.e.f50775a.longValue();
    }

    public ForumCreateInfoData b() {
        return this.f55841c;
    }

    public d.a.n0.j0.f.a.a c() {
        return this.f55844f;
    }

    public HotSearchInfoData d() {
        return this.f55847i;
    }

    public g e() {
        return this.f55839a;
    }

    public PrivateForumPopInfoData f() {
        return this.f55842d;
    }

    public o1 g() {
        return this.f55840b;
    }

    public int h() {
        return this.j;
    }

    public boolean i() {
        return this.f55845g;
    }

    public void j(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        try {
            if (dataRes.forum_popup_info != null) {
                this.f55844f.f(dataRes.forum_popup_info);
            }
            s(dataRes.time.intValue());
            this.j = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
            if (dataRes.like_forum != null) {
                this.f55839a.c(dataRes.like_forum);
            }
            if (dataRes.recommend_forum_info != null) {
                this.f55840b.C(dataRes.recommend_forum_info);
            }
            if (dataRes.forum_create_info != null) {
                this.f55841c.w(dataRes.forum_create_info);
            }
            if (dataRes.private_forum_popinfo != null) {
                this.f55842d.w(dataRes.private_forum_popinfo);
            }
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.f55847i = hotSearchInfoData;
                hotSearchInfoData.t(dataRes.hot_search);
            }
            if (dataRes.nav_tab_info != null) {
                this.f55843e.a(dataRes.nav_tab_info);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void k(ForumCreateInfoData forumCreateInfoData) {
        this.f55841c = forumCreateInfoData;
    }

    public void l(HotSearchInfoData hotSearchInfoData) {
        this.f55847i = hotSearchInfoData;
    }

    public void m(boolean z) {
        this.f55845g = z;
    }

    public void n(g gVar) {
        this.f55839a = gVar;
    }

    public void o(PrivateForumPopInfoData privateForumPopInfoData) {
        this.f55842d = privateForumPopInfoData;
    }

    public void p(o1 o1Var) {
        this.f55840b = o1Var;
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(j jVar) {
        this.f55843e = jVar;
    }

    public void s(int i2) {
        this.f55846h = i2;
    }

    public void t(d.a.n0.j0.f.a.a aVar) {
        this.f55844f = aVar;
    }
}

package d.b.i0.z0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f62815a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f62816b;

    /* renamed from: c  reason: collision with root package name */
    public RecPersonalizePageModel f62817c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernNetModel f62818d;

    /* renamed from: e  reason: collision with root package name */
    public d f62819e;

    /* renamed from: f  reason: collision with root package name */
    public RecPersonalizePageModel.b f62820f = new a();

    /* renamed from: g  reason: collision with root package name */
    public ConcernNetModel.d f62821g = new b();

    /* renamed from: h  reason: collision with root package name */
    public ConcernNetModel.c f62822h = new C1687c();

    /* loaded from: classes3.dex */
    public class a implements RecPersonalizePageModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(int i, String str) {
            if (c.this.f62819e != null) {
                c.this.f62819e.c("", str, i, false, 1);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.f62819e != null) {
                c.this.f62819e.b(dataRes, z, z2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ConcernNetModel.d {
        public b() {
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void a(int i, String str) {
            if (c.this.f62819e != null) {
                c.this.f62819e.c("", str, i, false, 0);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.f62819e != null) {
                c.this.f62819e.d(dataRes, z);
            }
        }
    }

    /* renamed from: d.b.i0.z0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1687c implements ConcernNetModel.c {
        public C1687c() {
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.c
        public void a(boolean z) {
            if (c.this.f62819e != null) {
                c.this.f62819e.a(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(boolean z);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(String str, String str2, int i, boolean z, int i2);

        void d(tbclient.Userlike.DataRes dataRes, boolean z);

        void e(boolean z, d.b.i0.z0.h.a.a aVar, boolean z2, String str, String str2, boolean z3);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.f62815a = tbPageContext;
        this.f62816b = bdUniqueId;
        RecPersonalizePageModel recPersonalizePageModel = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.f62817c = recPersonalizePageModel;
        recPersonalizePageModel.C(this.f62820f);
        ConcernNetModel concernNetModel = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.f62818d = concernNetModel;
        concernNetModel.A(this.f62821g);
        this.f62818d.z(this.f62822h);
    }

    public void b(boolean z) {
        ConcernNetModel concernNetModel = this.f62818d;
        if (concernNetModel != null) {
            concernNetModel.v(z);
        }
    }

    public TbPageContext<BaseFragmentActivity> c() {
        return this.f62815a;
    }

    public d.b.i0.i1.s.a d() {
        return null;
    }

    public d e() {
        return this.f62819e;
    }

    public BdUniqueId f() {
        return this.f62816b;
    }

    public void g(String str, d.b.h0.z0.c cVar) {
        ConcernNetModel concernNetModel = this.f62818d;
        if (concernNetModel != null) {
            concernNetModel.w(str, cVar);
        }
    }

    public void h(int i, int i2, d.b.h0.z0.c cVar, int i3, int i4) {
        RecPersonalizePageModel recPersonalizePageModel = this.f62817c;
        if (recPersonalizePageModel != null) {
            recPersonalizePageModel.v(i, i2, cVar, i3, i4);
        }
    }

    public void i(d.b.i0.i1.s.a aVar) {
    }

    public void j(d dVar) {
        this.f62819e = dVar;
    }
}

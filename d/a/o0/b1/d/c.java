package d.a.o0.b1.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f55222a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f55223b;

    /* renamed from: c  reason: collision with root package name */
    public RecPersonalizePageModel f55224c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernNetModel f55225d;

    /* renamed from: e  reason: collision with root package name */
    public d f55226e;

    /* renamed from: f  reason: collision with root package name */
    public RecPersonalizePageModel.b f55227f = new a();

    /* renamed from: g  reason: collision with root package name */
    public ConcernNetModel.d f55228g = new b();

    /* renamed from: h  reason: collision with root package name */
    public ConcernNetModel.c f55229h = new C1250c();

    /* loaded from: classes4.dex */
    public class a implements RecPersonalizePageModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(int i2, String str) {
            if (c.this.f55226e != null) {
                c.this.f55226e.c("", str, i2, false, 1);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.f55226e != null) {
                c.this.f55226e.b(dataRes, z, z2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ConcernNetModel.d {
        public b() {
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void a(int i2, String str) {
            if (c.this.f55226e != null) {
                c.this.f55226e.c("", str, i2, false, 0);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.f55226e != null) {
                c.this.f55226e.d(dataRes, z);
            }
        }
    }

    /* renamed from: d.a.o0.b1.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1250c implements ConcernNetModel.c {
        public C1250c() {
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.c
        public void a(boolean z) {
            if (c.this.f55226e != null) {
                c.this.f55226e.a(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(String str, String str2, int i2, boolean z, int i3);

        void d(tbclient.Userlike.DataRes dataRes, boolean z);

        void e(boolean z, d.a.o0.b1.i.a.a aVar, boolean z2, String str, String str2, boolean z3);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.f55222a = tbPageContext;
        this.f55223b = bdUniqueId;
        RecPersonalizePageModel recPersonalizePageModel = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.f55224c = recPersonalizePageModel;
        recPersonalizePageModel.G(this.f55227f);
        ConcernNetModel concernNetModel = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.f55225d = concernNetModel;
        concernNetModel.E(this.f55228g);
        this.f55225d.D(this.f55229h);
    }

    public void b(boolean z) {
        ConcernNetModel concernNetModel = this.f55225d;
        if (concernNetModel != null) {
            concernNetModel.z(z);
        }
    }

    public TbPageContext<BaseFragmentActivity> c() {
        return this.f55222a;
    }

    public d.a.o0.k1.s.a d() {
        return null;
    }

    public d e() {
        return this.f55226e;
    }

    public BdUniqueId f() {
        return this.f55223b;
    }

    public void g(String str, d.a.n0.z0.c cVar) {
        ConcernNetModel concernNetModel = this.f55225d;
        if (concernNetModel != null) {
            concernNetModel.A(str, cVar);
        }
    }

    public void h(int i2, int i3, d.a.n0.z0.c cVar, int i4, int i5) {
        RecPersonalizePageModel recPersonalizePageModel = this.f55224c;
        if (recPersonalizePageModel != null) {
            recPersonalizePageModel.z(i2, i3, cVar, i4, i5);
        }
    }

    public void i(d.a.o0.k1.s.a aVar) {
    }

    public void j(d dVar) {
        this.f55226e = dVar;
    }
}

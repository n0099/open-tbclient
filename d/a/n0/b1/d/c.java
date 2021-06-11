package d.a.n0.b1.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f55097a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f55098b;

    /* renamed from: c  reason: collision with root package name */
    public RecPersonalizePageModel f55099c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernNetModel f55100d;

    /* renamed from: e  reason: collision with root package name */
    public d f55101e;

    /* renamed from: f  reason: collision with root package name */
    public RecPersonalizePageModel.b f55102f = new a();

    /* renamed from: g  reason: collision with root package name */
    public ConcernNetModel.d f55103g = new b();

    /* renamed from: h  reason: collision with root package name */
    public ConcernNetModel.c f55104h = new C1246c();

    /* loaded from: classes4.dex */
    public class a implements RecPersonalizePageModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(int i2, String str) {
            if (c.this.f55101e != null) {
                c.this.f55101e.c("", str, i2, false, 1);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.f55101e != null) {
                c.this.f55101e.b(dataRes, z, z2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ConcernNetModel.d {
        public b() {
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void a(int i2, String str) {
            if (c.this.f55101e != null) {
                c.this.f55101e.c("", str, i2, false, 0);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.f55101e != null) {
                c.this.f55101e.d(dataRes, z);
            }
        }
    }

    /* renamed from: d.a.n0.b1.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1246c implements ConcernNetModel.c {
        public C1246c() {
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.c
        public void a(boolean z) {
            if (c.this.f55101e != null) {
                c.this.f55101e.a(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(String str, String str2, int i2, boolean z, int i3);

        void d(tbclient.Userlike.DataRes dataRes, boolean z);

        void e(boolean z, d.a.n0.b1.i.a.a aVar, boolean z2, String str, String str2, boolean z3);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.f55097a = tbPageContext;
        this.f55098b = bdUniqueId;
        RecPersonalizePageModel recPersonalizePageModel = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.f55099c = recPersonalizePageModel;
        recPersonalizePageModel.G(this.f55102f);
        ConcernNetModel concernNetModel = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.f55100d = concernNetModel;
        concernNetModel.E(this.f55103g);
        this.f55100d.D(this.f55104h);
    }

    public void b(boolean z) {
        ConcernNetModel concernNetModel = this.f55100d;
        if (concernNetModel != null) {
            concernNetModel.z(z);
        }
    }

    public TbPageContext<BaseFragmentActivity> c() {
        return this.f55097a;
    }

    public d.a.n0.k1.s.a d() {
        return null;
    }

    public d e() {
        return this.f55101e;
    }

    public BdUniqueId f() {
        return this.f55098b;
    }

    public void g(String str, d.a.m0.z0.c cVar) {
        ConcernNetModel concernNetModel = this.f55100d;
        if (concernNetModel != null) {
            concernNetModel.A(str, cVar);
        }
    }

    public void h(int i2, int i3, d.a.m0.z0.c cVar, int i4, int i5) {
        RecPersonalizePageModel recPersonalizePageModel = this.f55099c;
        if (recPersonalizePageModel != null) {
            recPersonalizePageModel.z(i2, i3, cVar, i4, i5);
        }
    }

    public void i(d.a.n0.k1.s.a aVar) {
    }

    public void j(d dVar) {
        this.f55101e = dVar;
    }
}

package d.a.n0.b1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f51414a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f51415b;

    /* renamed from: c  reason: collision with root package name */
    public RecPersonalizePageModel f51416c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernNetModel f51417d;

    /* renamed from: e  reason: collision with root package name */
    public d f51418e;

    /* renamed from: f  reason: collision with root package name */
    public RecPersonalizePageModel.b f51419f = new a();

    /* renamed from: g  reason: collision with root package name */
    public ConcernNetModel.d f51420g = new b();

    /* renamed from: h  reason: collision with root package name */
    public ConcernNetModel.c f51421h = new C1190c();

    /* loaded from: classes4.dex */
    public class a implements RecPersonalizePageModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(int i2, String str) {
            if (c.this.f51418e != null) {
                c.this.f51418e.c("", str, i2, false, 1);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.f51418e != null) {
                c.this.f51418e.b(dataRes, z, z2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ConcernNetModel.d {
        public b() {
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void a(int i2, String str) {
            if (c.this.f51418e != null) {
                c.this.f51418e.c("", str, i2, false, 0);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.f51418e != null) {
                c.this.f51418e.d(dataRes, z);
            }
        }
    }

    /* renamed from: d.a.n0.b1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1190c implements ConcernNetModel.c {
        public C1190c() {
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.c
        public void a(boolean z) {
            if (c.this.f51418e != null) {
                c.this.f51418e.a(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(String str, String str2, int i2, boolean z, int i3);

        void d(tbclient.Userlike.DataRes dataRes, boolean z);

        void e(boolean z, d.a.n0.b1.h.a.a aVar, boolean z2, String str, String str2, boolean z3);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.f51414a = tbPageContext;
        this.f51415b = bdUniqueId;
        RecPersonalizePageModel recPersonalizePageModel = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.f51416c = recPersonalizePageModel;
        recPersonalizePageModel.C(this.f51419f);
        ConcernNetModel concernNetModel = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.f51417d = concernNetModel;
        concernNetModel.A(this.f51420g);
        this.f51417d.z(this.f51421h);
    }

    public void b(boolean z) {
        ConcernNetModel concernNetModel = this.f51417d;
        if (concernNetModel != null) {
            concernNetModel.v(z);
        }
    }

    public TbPageContext<BaseFragmentActivity> c() {
        return this.f51414a;
    }

    public d.a.n0.k1.s.a d() {
        return null;
    }

    public d e() {
        return this.f51418e;
    }

    public BdUniqueId f() {
        return this.f51415b;
    }

    public void g(String str, d.a.m0.z0.c cVar) {
        ConcernNetModel concernNetModel = this.f51417d;
        if (concernNetModel != null) {
            concernNetModel.w(str, cVar);
        }
    }

    public void h(int i2, int i3, d.a.m0.z0.c cVar, int i4, int i5) {
        RecPersonalizePageModel recPersonalizePageModel = this.f51416c;
        if (recPersonalizePageModel != null) {
            recPersonalizePageModel.v(i2, i3, cVar, i4, i5);
        }
    }

    public void i(d.a.n0.k1.s.a aVar) {
    }

    public void j(d dVar) {
        this.f51418e = dVar;
    }
}

package d.b.i0.z0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f62814a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f62815b;

    /* renamed from: c  reason: collision with root package name */
    public RecPersonalizePageModel f62816c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernNetModel f62817d;

    /* renamed from: e  reason: collision with root package name */
    public d f62818e;

    /* renamed from: f  reason: collision with root package name */
    public RecPersonalizePageModel.b f62819f = new a();

    /* renamed from: g  reason: collision with root package name */
    public ConcernNetModel.d f62820g = new b();

    /* renamed from: h  reason: collision with root package name */
    public ConcernNetModel.c f62821h = new C1686c();

    /* loaded from: classes4.dex */
    public class a implements RecPersonalizePageModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(int i, String str) {
            if (c.this.f62818e != null) {
                c.this.f62818e.c("", str, i, false, 1);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.f62818e != null) {
                c.this.f62818e.b(dataRes, z, z2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ConcernNetModel.d {
        public b() {
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void a(int i, String str) {
            if (c.this.f62818e != null) {
                c.this.f62818e.c("", str, i, false, 0);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.f62818e != null) {
                c.this.f62818e.d(dataRes, z);
            }
        }
    }

    /* renamed from: d.b.i0.z0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1686c implements ConcernNetModel.c {
        public C1686c() {
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.c
        public void a(boolean z) {
            if (c.this.f62818e != null) {
                c.this.f62818e.a(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(String str, String str2, int i, boolean z, int i2);

        void d(tbclient.Userlike.DataRes dataRes, boolean z);

        void e(boolean z, d.b.i0.z0.h.a.a aVar, boolean z2, String str, String str2, boolean z3);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.f62814a = tbPageContext;
        this.f62815b = bdUniqueId;
        RecPersonalizePageModel recPersonalizePageModel = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.f62816c = recPersonalizePageModel;
        recPersonalizePageModel.C(this.f62819f);
        ConcernNetModel concernNetModel = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.f62817d = concernNetModel;
        concernNetModel.A(this.f62820g);
        this.f62817d.z(this.f62821h);
    }

    public void b(boolean z) {
        ConcernNetModel concernNetModel = this.f62817d;
        if (concernNetModel != null) {
            concernNetModel.v(z);
        }
    }

    public TbPageContext<BaseFragmentActivity> c() {
        return this.f62814a;
    }

    public d.b.i0.i1.s.a d() {
        return null;
    }

    public d e() {
        return this.f62818e;
    }

    public BdUniqueId f() {
        return this.f62815b;
    }

    public void g(String str, d.b.h0.z0.c cVar) {
        ConcernNetModel concernNetModel = this.f62817d;
        if (concernNetModel != null) {
            concernNetModel.w(str, cVar);
        }
    }

    public void h(int i, int i2, d.b.h0.z0.c cVar, int i3, int i4) {
        RecPersonalizePageModel recPersonalizePageModel = this.f62816c;
        if (recPersonalizePageModel != null) {
            recPersonalizePageModel.v(i, i2, cVar, i3, i4);
        }
    }

    public void i(d.b.i0.i1.s.a aVar) {
    }

    public void j(d dVar) {
        this.f62818e = dVar;
    }
}

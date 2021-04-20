package d.b.i0.a1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f52434a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f52435b;

    /* renamed from: c  reason: collision with root package name */
    public RecPersonalizePageModel f52436c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernNetModel f52437d;

    /* renamed from: e  reason: collision with root package name */
    public d f52438e;

    /* renamed from: f  reason: collision with root package name */
    public RecPersonalizePageModel.b f52439f = new a();

    /* renamed from: g  reason: collision with root package name */
    public ConcernNetModel.d f52440g = new b();

    /* renamed from: h  reason: collision with root package name */
    public ConcernNetModel.c f52441h = new C1139c();

    /* loaded from: classes4.dex */
    public class a implements RecPersonalizePageModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(int i, String str) {
            if (c.this.f52438e != null) {
                c.this.f52438e.c("", str, i, false, 1);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.f52438e != null) {
                c.this.f52438e.b(dataRes, z, z2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ConcernNetModel.d {
        public b() {
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void a(int i, String str) {
            if (c.this.f52438e != null) {
                c.this.f52438e.c("", str, i, false, 0);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.f52438e != null) {
                c.this.f52438e.d(dataRes, z);
            }
        }
    }

    /* renamed from: d.b.i0.a1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1139c implements ConcernNetModel.c {
        public C1139c() {
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.c
        public void a(boolean z) {
            if (c.this.f52438e != null) {
                c.this.f52438e.a(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(String str, String str2, int i, boolean z, int i2);

        void d(tbclient.Userlike.DataRes dataRes, boolean z);

        void e(boolean z, d.b.i0.a1.h.a.a aVar, boolean z2, String str, String str2, boolean z3);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.f52434a = tbPageContext;
        this.f52435b = bdUniqueId;
        RecPersonalizePageModel recPersonalizePageModel = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.f52436c = recPersonalizePageModel;
        recPersonalizePageModel.C(this.f52439f);
        ConcernNetModel concernNetModel = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.f52437d = concernNetModel;
        concernNetModel.A(this.f52440g);
        this.f52437d.z(this.f52441h);
    }

    public void b(boolean z) {
        ConcernNetModel concernNetModel = this.f52437d;
        if (concernNetModel != null) {
            concernNetModel.v(z);
        }
    }

    public TbPageContext<BaseFragmentActivity> c() {
        return this.f52434a;
    }

    public d.b.i0.j1.s.a d() {
        return null;
    }

    public d e() {
        return this.f52438e;
    }

    public BdUniqueId f() {
        return this.f52435b;
    }

    public void g(String str, d.b.h0.z0.c cVar) {
        ConcernNetModel concernNetModel = this.f52437d;
        if (concernNetModel != null) {
            concernNetModel.w(str, cVar);
        }
    }

    public void h(int i, int i2, d.b.h0.z0.c cVar, int i3, int i4) {
        RecPersonalizePageModel recPersonalizePageModel = this.f52436c;
        if (recPersonalizePageModel != null) {
            recPersonalizePageModel.v(i, i2, cVar, i3, i4);
        }
    }

    public void i(d.b.i0.j1.s.a aVar) {
    }

    public void j(d dVar) {
        this.f52438e = dVar;
    }
}

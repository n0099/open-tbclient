package d.a.n0.h2.d;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import d.a.m0.t.n;
import d.a.n0.h2.e.f;
import d.a.n0.h2.g.c;
import d.a.n0.u2.b;
/* loaded from: classes5.dex */
public class b implements c.InterfaceC1364c {

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f55520a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.h2.g.c f55521b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f55522c = new a();

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f55523d = new C1363b(2001435);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f55524e = new c(this, 2005016);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f55525f = new d(2016485);

    /* loaded from: classes5.dex */
    public class a implements PersonCenterModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.f55521b.d();
            b.this.f55521b.j(fVar);
            if (fVar != null && fVar.p() != null) {
                d.a.m0.r.l.f.b(fVar.p().getPersonPrivate());
            }
            d.a.n0.h2.a.d().i(System.currentTimeMillis() - currentTimeMillis);
            long e2 = d.a.n0.h2.a.d().e();
            if (e2 > 0) {
                d.a.n0.h2.a.d().k(System.currentTimeMillis() - e2);
                d.a.n0.h2.a.d().j(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void onFail(int i2, String str) {
            if (i2 != -1 || b.this.f55520a.mIsDataLoaded) {
                b.this.f55521b.l(i2, str);
            } else {
                b.this.f55521b.n();
            }
        }
    }

    /* renamed from: d.a.n0.h2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1363b extends CustomMessageListener {
        public C1363b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.n0.u2.b bVar;
            SparseArray<b.a> sparseArray;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.n0.u2.b) || (sparseArray = (bVar = (d.a.n0.u2.b) customResponsedMessage.getData()).f61360a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f61360a.get(2);
            b.a aVar2 = bVar.f61360a.get(3);
            b.a aVar3 = bVar.f61360a.get(9);
            b.a aVar4 = bVar.f61360a.get(10);
            if (b.this.f55520a.w() != null) {
                if (aVar2 != null) {
                    b.this.f55520a.w().f(aVar2.f61361a);
                }
                if (aVar != null) {
                    b.this.f55520a.w().d(aVar.f61361a);
                }
                if (aVar3 != null) {
                    b.this.f55520a.w().c(aVar3.f61361a);
                }
                if (aVar4 != null) {
                    b.this.f55520a.w().e(aVar4.f61361a);
                }
            }
            b.a aVar5 = bVar.f61360a.get(5);
            if (aVar5 != null) {
                b.this.f55521b.o(5, aVar5.f61361a);
            }
            b.a aVar6 = bVar.f61360a.get(6);
            if (aVar6 != null) {
                b.this.f55521b.o(6, aVar6.f61361a);
            }
            b.this.f55521b.g();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(b bVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            d.a.n0.u2.a.v().I(false);
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof n) || (nVar = (n) customResponsedMessage.getData()) == null) {
                return;
            }
            if (b.this.f55520a.w() != null) {
                b.this.f55520a.w().u(nVar);
                b.this.f55521b.g();
                return;
            }
            b.this.j();
        }
    }

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        d.a.n0.h2.g.c cVar = new d.a.n0.h2.g.c(view, tbPageContext, bdUniqueId);
        this.f55521b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f55520a = personCenterModel;
        personCenterModel.B(this.f55522c);
        d.a.n0.u2.a.v();
        this.f55523d.setTag(bdUniqueId);
        this.f55524e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55523d);
        MessageManager.getInstance().registerListener(this.f55524e);
        this.f55525f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55525f);
    }

    @Override // d.a.n0.h2.g.c.InterfaceC1364c
    public void a(View view) {
        this.f55520a.LoadData();
    }

    public void d() {
        this.f55521b.c();
    }

    public void e() {
        this.f55521b.e();
    }

    public void f(int i2) {
        this.f55521b.h(i2);
    }

    public void g() {
        this.f55521b.i();
    }

    public void h(String str) {
        f w = this.f55520a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setPortrait(str);
        this.f55521b.g();
    }

    public void i(String str) {
        f w = this.f55520a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setName_show(str);
        this.f55521b.g();
    }

    public void j() {
        d.a.n0.h2.a.d().j(System.currentTimeMillis());
        this.f55520a.LoadData();
    }

    public void k(boolean z) {
        this.f55520a.C(z);
    }

    public void l() {
        this.f55521b.m();
    }
}

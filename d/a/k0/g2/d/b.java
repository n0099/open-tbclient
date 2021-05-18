package d.a.k0.g2.d;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import d.a.j0.t.n;
import d.a.k0.g2.e.f;
import d.a.k0.g2.g.c;
import d.a.k0.t2.b;
/* loaded from: classes5.dex */
public class b implements c.InterfaceC1342c {

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f55246a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.g2.g.c f55247b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f55248c = new a();

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f55249d = new C1341b(2001435);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f55250e = new c(this, 2005016);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f55251f = new d(2016485);

    /* loaded from: classes5.dex */
    public class a implements PersonCenterModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.f55247b.d();
            b.this.f55247b.j(fVar);
            if (fVar != null && fVar.p() != null) {
                d.a.j0.r.l.f.b(fVar.p().getPersonPrivate());
            }
            d.a.k0.g2.a.d().i(System.currentTimeMillis() - currentTimeMillis);
            long e2 = d.a.k0.g2.a.d().e();
            if (e2 > 0) {
                d.a.k0.g2.a.d().k(System.currentTimeMillis() - e2);
                d.a.k0.g2.a.d().j(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void onFail(int i2, String str) {
            if (i2 != -1 || b.this.f55246a.mIsDataLoaded) {
                b.this.f55247b.l(i2, str);
            } else {
                b.this.f55247b.n();
            }
        }
    }

    /* renamed from: d.a.k0.g2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1341b extends CustomMessageListener {
        public C1341b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.k0.t2.b bVar;
            SparseArray<b.a> sparseArray;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.k0.t2.b) || (sparseArray = (bVar = (d.a.k0.t2.b) customResponsedMessage.getData()).f61953a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f61953a.get(2);
            b.a aVar2 = bVar.f61953a.get(3);
            b.a aVar3 = bVar.f61953a.get(9);
            b.a aVar4 = bVar.f61953a.get(10);
            if (b.this.f55246a.w() != null) {
                if (aVar2 != null) {
                    b.this.f55246a.w().f(aVar2.f61954a);
                }
                if (aVar != null) {
                    b.this.f55246a.w().d(aVar.f61954a);
                }
                if (aVar3 != null) {
                    b.this.f55246a.w().c(aVar3.f61954a);
                }
                if (aVar4 != null) {
                    b.this.f55246a.w().e(aVar4.f61954a);
                }
            }
            b.a aVar5 = bVar.f61953a.get(5);
            if (aVar5 != null) {
                b.this.f55247b.o(5, aVar5.f61954a);
            }
            b.a aVar6 = bVar.f61953a.get(6);
            if (aVar6 != null) {
                b.this.f55247b.o(6, aVar6.f61954a);
            }
            b.this.f55247b.g();
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
            d.a.k0.t2.a.v().I(false);
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
            if (b.this.f55246a.w() != null) {
                b.this.f55246a.w().u(nVar);
                b.this.f55247b.g();
                return;
            }
            b.this.j();
        }
    }

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        d.a.k0.g2.g.c cVar = new d.a.k0.g2.g.c(view, tbPageContext, bdUniqueId);
        this.f55247b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f55246a = personCenterModel;
        personCenterModel.B(this.f55248c);
        d.a.k0.t2.a.v();
        this.f55249d.setTag(bdUniqueId);
        this.f55250e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55249d);
        MessageManager.getInstance().registerListener(this.f55250e);
        this.f55251f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55251f);
    }

    @Override // d.a.k0.g2.g.c.InterfaceC1342c
    public void a(View view) {
        this.f55246a.LoadData();
    }

    public void d() {
        this.f55247b.c();
    }

    public void e() {
        this.f55247b.e();
    }

    public void f(int i2) {
        this.f55247b.h(i2);
    }

    public void g() {
        this.f55247b.i();
    }

    public void h(String str) {
        f w = this.f55246a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setPortrait(str);
        this.f55247b.g();
    }

    public void i(String str) {
        f w = this.f55246a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setName_show(str);
        this.f55247b.g();
    }

    public void j() {
        d.a.k0.g2.a.d().j(System.currentTimeMillis());
        this.f55246a.LoadData();
    }

    public void k(boolean z) {
        this.f55246a.C(z);
    }

    public void l() {
        this.f55247b.m();
    }
}

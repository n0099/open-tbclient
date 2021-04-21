package d.b.j0.g2.d;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import d.b.i0.t.n;
import d.b.j0.g2.e.f;
import d.b.j0.g2.g.c;
import d.b.j0.t2.b;
/* loaded from: classes3.dex */
public class b implements c.InterfaceC1331c {

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f56640a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.g2.g.c f56641b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f56642c = new a();

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f56643d = new C1330b(2001435);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f56644e = new c(this, 2005016);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f56645f = new d(2016485);

    /* loaded from: classes3.dex */
    public class a implements PersonCenterModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.f56641b.d();
            b.this.f56641b.j(fVar);
            if (fVar != null && fVar.p() != null) {
                d.b.i0.r.l.f.b(fVar.p().getPersonPrivate());
            }
            d.b.j0.g2.a.d().i(System.currentTimeMillis() - currentTimeMillis);
            long e2 = d.b.j0.g2.a.d().e();
            if (e2 > 0) {
                d.b.j0.g2.a.d().k(System.currentTimeMillis() - e2);
                d.b.j0.g2.a.d().j(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void onFail(int i, String str) {
            if (i != -1 || b.this.f56640a.mIsDataLoaded) {
                b.this.f56641b.l(i, str);
            } else {
                b.this.f56641b.n();
            }
        }
    }

    /* renamed from: d.b.j0.g2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1330b extends CustomMessageListener {
        public C1330b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.j0.t2.b bVar;
            SparseArray<b.a> sparseArray;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.j0.t2.b) || (sparseArray = (bVar = (d.b.j0.t2.b) customResponsedMessage.getData()).f63022a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f63022a.get(2);
            b.a aVar2 = bVar.f63022a.get(3);
            b.a aVar3 = bVar.f63022a.get(9);
            b.a aVar4 = bVar.f63022a.get(10);
            if (b.this.f56640a.w() != null) {
                if (aVar2 != null) {
                    b.this.f56640a.w().f(aVar2.f63023a);
                }
                if (aVar != null) {
                    b.this.f56640a.w().d(aVar.f63023a);
                }
                if (aVar3 != null) {
                    b.this.f56640a.w().c(aVar3.f63023a);
                }
                if (aVar4 != null) {
                    b.this.f56640a.w().e(aVar4.f63023a);
                }
            }
            b.a aVar5 = bVar.f63022a.get(5);
            if (aVar5 != null) {
                b.this.f56641b.o(5, aVar5.f63023a);
            }
            b.a aVar6 = bVar.f63022a.get(6);
            if (aVar6 != null) {
                b.this.f56641b.o(6, aVar6.f63023a);
            }
            b.this.f56641b.g();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(b bVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            d.b.j0.t2.a.v().I(false);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof n) || (nVar = (n) customResponsedMessage.getData()) == null) {
                return;
            }
            if (b.this.f56640a.w() != null) {
                b.this.f56640a.w().u(nVar);
                b.this.f56641b.g();
                return;
            }
            b.this.j();
        }
    }

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        d.b.j0.g2.g.c cVar = new d.b.j0.g2.g.c(view, tbPageContext, bdUniqueId);
        this.f56641b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f56640a = personCenterModel;
        personCenterModel.B(this.f56642c);
        d.b.j0.t2.a.v();
        this.f56643d.setTag(bdUniqueId);
        this.f56644e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f56643d);
        MessageManager.getInstance().registerListener(this.f56644e);
        this.f56645f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f56645f);
    }

    @Override // d.b.j0.g2.g.c.InterfaceC1331c
    public void a(View view) {
        this.f56640a.LoadData();
    }

    public void d() {
        this.f56641b.c();
    }

    public void e() {
        this.f56641b.e();
    }

    public void f(int i) {
        this.f56641b.h(i);
    }

    public void g() {
        this.f56641b.i();
    }

    public void h(String str) {
        f w = this.f56640a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setPortrait(str);
        this.f56641b.g();
    }

    public void i(String str) {
        f w = this.f56640a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setName_show(str);
        this.f56641b.g();
    }

    public void j() {
        d.b.j0.g2.a.d().j(System.currentTimeMillis());
        this.f56640a.LoadData();
    }

    public void k(boolean z) {
        this.f56640a.C(z);
    }

    public void l() {
        this.f56641b.m();
    }
}

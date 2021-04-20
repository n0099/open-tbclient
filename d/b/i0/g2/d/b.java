package d.b.i0.g2.d;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import d.b.h0.t.n;
import d.b.i0.g2.e.f;
import d.b.i0.g2.g.c;
import d.b.i0.t2.b;
/* loaded from: classes3.dex */
public class b implements c.InterfaceC1308c {

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f56219a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.g2.g.c f56220b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f56221c = new a();

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f56222d = new C1307b(2001435);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f56223e = new c(this, 2005016);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f56224f = new d(2016485);

    /* loaded from: classes3.dex */
    public class a implements PersonCenterModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.f56220b.d();
            b.this.f56220b.j(fVar);
            if (fVar != null && fVar.p() != null) {
                d.b.h0.r.l.f.b(fVar.p().getPersonPrivate());
            }
            d.b.i0.g2.a.d().i(System.currentTimeMillis() - currentTimeMillis);
            long e2 = d.b.i0.g2.a.d().e();
            if (e2 > 0) {
                d.b.i0.g2.a.d().k(System.currentTimeMillis() - e2);
                d.b.i0.g2.a.d().j(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void onFail(int i, String str) {
            if (i != -1 || b.this.f56219a.mIsDataLoaded) {
                b.this.f56220b.l(i, str);
            } else {
                b.this.f56220b.n();
            }
        }
    }

    /* renamed from: d.b.i0.g2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1307b extends CustomMessageListener {
        public C1307b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.i0.t2.b bVar;
            SparseArray<b.a> sparseArray;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.t2.b) || (sparseArray = (bVar = (d.b.i0.t2.b) customResponsedMessage.getData()).f62601a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f62601a.get(2);
            b.a aVar2 = bVar.f62601a.get(3);
            b.a aVar3 = bVar.f62601a.get(9);
            b.a aVar4 = bVar.f62601a.get(10);
            if (b.this.f56219a.w() != null) {
                if (aVar2 != null) {
                    b.this.f56219a.w().f(aVar2.f62602a);
                }
                if (aVar != null) {
                    b.this.f56219a.w().d(aVar.f62602a);
                }
                if (aVar3 != null) {
                    b.this.f56219a.w().c(aVar3.f62602a);
                }
                if (aVar4 != null) {
                    b.this.f56219a.w().e(aVar4.f62602a);
                }
            }
            b.a aVar5 = bVar.f62601a.get(5);
            if (aVar5 != null) {
                b.this.f56220b.o(5, aVar5.f62602a);
            }
            b.a aVar6 = bVar.f62601a.get(6);
            if (aVar6 != null) {
                b.this.f56220b.o(6, aVar6.f62602a);
            }
            b.this.f56220b.g();
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
            d.b.i0.t2.a.v().I(false);
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
            if (b.this.f56219a.w() != null) {
                b.this.f56219a.w().u(nVar);
                b.this.f56220b.g();
                return;
            }
            b.this.j();
        }
    }

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        d.b.i0.g2.g.c cVar = new d.b.i0.g2.g.c(view, tbPageContext, bdUniqueId);
        this.f56220b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f56219a = personCenterModel;
        personCenterModel.B(this.f56221c);
        d.b.i0.t2.a.v();
        this.f56222d.setTag(bdUniqueId);
        this.f56223e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f56222d);
        MessageManager.getInstance().registerListener(this.f56223e);
        this.f56224f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f56224f);
    }

    @Override // d.b.i0.g2.g.c.InterfaceC1308c
    public void a(View view) {
        this.f56219a.LoadData();
    }

    public void d() {
        this.f56220b.c();
    }

    public void e() {
        this.f56220b.e();
    }

    public void f(int i) {
        this.f56220b.h(i);
    }

    public void g() {
        this.f56220b.i();
    }

    public void h(String str) {
        f w = this.f56219a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setPortrait(str);
        this.f56220b.g();
    }

    public void i(String str) {
        f w = this.f56219a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setName_show(str);
        this.f56220b.g();
    }

    public void j() {
        d.b.i0.g2.a.d().j(System.currentTimeMillis());
        this.f56219a.LoadData();
    }

    public void k(boolean z) {
        this.f56219a.C(z);
    }

    public void l() {
        this.f56220b.m();
    }
}

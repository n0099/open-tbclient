package d.a.j0.g2.d;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import d.a.i0.t.n;
import d.a.j0.g2.e.f;
import d.a.j0.g2.g.c;
import d.a.j0.t2.b;
/* loaded from: classes4.dex */
public class b implements c.InterfaceC1270c {

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f54539a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.g2.g.c f54540b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f54541c = new a();

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f54542d = new C1269b(2001435);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f54543e = new c(this, 2005016);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f54544f = new d(2016485);

    /* loaded from: classes4.dex */
    public class a implements PersonCenterModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.f54540b.d();
            b.this.f54540b.j(fVar);
            if (fVar != null && fVar.p() != null) {
                d.a.i0.r.l.f.b(fVar.p().getPersonPrivate());
            }
            d.a.j0.g2.a.d().i(System.currentTimeMillis() - currentTimeMillis);
            long e2 = d.a.j0.g2.a.d().e();
            if (e2 > 0) {
                d.a.j0.g2.a.d().k(System.currentTimeMillis() - e2);
                d.a.j0.g2.a.d().j(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void onFail(int i2, String str) {
            if (i2 != -1 || b.this.f54539a.mIsDataLoaded) {
                b.this.f54540b.l(i2, str);
            } else {
                b.this.f54540b.n();
            }
        }
    }

    /* renamed from: d.a.j0.g2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1269b extends CustomMessageListener {
        public C1269b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.j0.t2.b bVar;
            SparseArray<b.a> sparseArray;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.j0.t2.b) || (sparseArray = (bVar = (d.a.j0.t2.b) customResponsedMessage.getData()).f61229a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f61229a.get(2);
            b.a aVar2 = bVar.f61229a.get(3);
            b.a aVar3 = bVar.f61229a.get(9);
            b.a aVar4 = bVar.f61229a.get(10);
            if (b.this.f54539a.w() != null) {
                if (aVar2 != null) {
                    b.this.f54539a.w().f(aVar2.f61230a);
                }
                if (aVar != null) {
                    b.this.f54539a.w().d(aVar.f61230a);
                }
                if (aVar3 != null) {
                    b.this.f54539a.w().c(aVar3.f61230a);
                }
                if (aVar4 != null) {
                    b.this.f54539a.w().e(aVar4.f61230a);
                }
            }
            b.a aVar5 = bVar.f61229a.get(5);
            if (aVar5 != null) {
                b.this.f54540b.o(5, aVar5.f61230a);
            }
            b.a aVar6 = bVar.f61229a.get(6);
            if (aVar6 != null) {
                b.this.f54540b.o(6, aVar6.f61230a);
            }
            b.this.f54540b.g();
        }
    }

    /* loaded from: classes4.dex */
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
            d.a.j0.t2.a.v().I(false);
        }
    }

    /* loaded from: classes4.dex */
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
            if (b.this.f54539a.w() != null) {
                b.this.f54539a.w().u(nVar);
                b.this.f54540b.g();
                return;
            }
            b.this.j();
        }
    }

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        d.a.j0.g2.g.c cVar = new d.a.j0.g2.g.c(view, tbPageContext, bdUniqueId);
        this.f54540b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f54539a = personCenterModel;
        personCenterModel.B(this.f54541c);
        d.a.j0.t2.a.v();
        this.f54542d.setTag(bdUniqueId);
        this.f54543e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f54542d);
        MessageManager.getInstance().registerListener(this.f54543e);
        this.f54544f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f54544f);
    }

    @Override // d.a.j0.g2.g.c.InterfaceC1270c
    public void a(View view) {
        this.f54539a.LoadData();
    }

    public void d() {
        this.f54540b.c();
    }

    public void e() {
        this.f54540b.e();
    }

    public void f(int i2) {
        this.f54540b.h(i2);
    }

    public void g() {
        this.f54540b.i();
    }

    public void h(String str) {
        f w = this.f54539a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setPortrait(str);
        this.f54540b.g();
    }

    public void i(String str) {
        f w = this.f54539a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setName_show(str);
        this.f54540b.g();
    }

    public void j() {
        d.a.j0.g2.a.d().j(System.currentTimeMillis());
        this.f54539a.LoadData();
    }

    public void k(boolean z) {
        this.f54539a.C(z);
    }

    public void l() {
        this.f54540b.m();
    }
}

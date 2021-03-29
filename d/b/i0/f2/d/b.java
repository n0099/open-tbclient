package d.b.i0.f2.d;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import d.b.h0.t.m;
import d.b.i0.f2.e.f;
import d.b.i0.f2.g.c;
import d.b.i0.s2.b;
/* loaded from: classes5.dex */
public class b implements c.InterfaceC1251c {

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f54749a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.f2.g.c f54750b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f54751c = new a();

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f54752d = new C1250b(2001435);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f54753e = new c(this, 2005016);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f54754f = new d(2016485);

    /* loaded from: classes5.dex */
    public class a implements PersonCenterModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.f54750b.d();
            b.this.f54750b.j(fVar);
            if (fVar != null && fVar.p() != null) {
                d.b.h0.r.l.f.b(fVar.p().getPersonPrivate());
            }
            d.b.i0.f2.a.d().i(System.currentTimeMillis() - currentTimeMillis);
            long e2 = d.b.i0.f2.a.d().e();
            if (e2 > 0) {
                d.b.i0.f2.a.d().k(System.currentTimeMillis() - e2);
                d.b.i0.f2.a.d().j(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void onFail(int i, String str) {
            if (i != -1 || b.this.f54749a.mIsDataLoaded) {
                b.this.f54750b.l(i, str);
            } else {
                b.this.f54750b.n();
            }
        }
    }

    /* renamed from: d.b.i0.f2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1250b extends CustomMessageListener {
        public C1250b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.i0.s2.b bVar;
            SparseArray<b.a> sparseArray;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.s2.b) || (sparseArray = (bVar = (d.b.i0.s2.b) customResponsedMessage.getData()).f60187a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f60187a.get(2);
            b.a aVar2 = bVar.f60187a.get(3);
            b.a aVar3 = bVar.f60187a.get(9);
            b.a aVar4 = bVar.f60187a.get(10);
            if (b.this.f54749a.w() != null) {
                if (aVar2 != null) {
                    b.this.f54749a.w().f(aVar2.f60188a);
                }
                if (aVar != null) {
                    b.this.f54749a.w().d(aVar.f60188a);
                }
                if (aVar3 != null) {
                    b.this.f54749a.w().c(aVar3.f60188a);
                }
                if (aVar4 != null) {
                    b.this.f54749a.w().e(aVar4.f60188a);
                }
            }
            b.a aVar5 = bVar.f60187a.get(5);
            if (aVar5 != null) {
                b.this.f54750b.o(5, aVar5.f60188a);
            }
            b.a aVar6 = bVar.f60187a.get(6);
            if (aVar6 != null) {
                b.this.f54750b.o(6, aVar6.f60188a);
            }
            b.this.f54750b.g();
        }
    }

    /* loaded from: classes5.dex */
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
            d.b.i0.s2.a.v().I(false);
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof m) || (mVar = (m) customResponsedMessage.getData()) == null) {
                return;
            }
            if (b.this.f54749a.w() != null) {
                b.this.f54749a.w().u(mVar);
                b.this.f54750b.g();
                return;
            }
            b.this.j();
        }
    }

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        d.b.i0.f2.g.c cVar = new d.b.i0.f2.g.c(view, tbPageContext, bdUniqueId);
        this.f54750b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f54749a = personCenterModel;
        personCenterModel.B(this.f54751c);
        d.b.i0.s2.a.v();
        this.f54752d.setTag(bdUniqueId);
        this.f54753e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f54752d);
        MessageManager.getInstance().registerListener(this.f54753e);
        this.f54754f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f54754f);
    }

    @Override // d.b.i0.f2.g.c.InterfaceC1251c
    public void a(View view) {
        this.f54749a.LoadData();
    }

    public void d() {
        this.f54750b.c();
    }

    public void e() {
        this.f54750b.e();
    }

    public void f(int i) {
        this.f54750b.h(i);
    }

    public void g() {
        this.f54750b.i();
    }

    public void h(String str) {
        f w = this.f54749a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setPortrait(str);
        this.f54750b.g();
    }

    public void i(String str) {
        f w = this.f54749a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setName_show(str);
        this.f54750b.g();
    }

    public void j() {
        d.b.i0.f2.a.d().j(System.currentTimeMillis());
        this.f54749a.LoadData();
    }

    public void k(boolean z) {
        this.f54749a.C(z);
    }

    public void l() {
        this.f54750b.m();
    }
}

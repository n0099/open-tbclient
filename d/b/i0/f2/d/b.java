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
public class b implements c.InterfaceC1250c {

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f54748a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.f2.g.c f54749b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f54750c = new a();

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f54751d = new C1249b(2001435);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f54752e = new c(this, 2005016);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f54753f = new d(2016485);

    /* loaded from: classes5.dex */
    public class a implements PersonCenterModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.f54749b.d();
            b.this.f54749b.j(fVar);
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
            if (i != -1 || b.this.f54748a.mIsDataLoaded) {
                b.this.f54749b.l(i, str);
            } else {
                b.this.f54749b.n();
            }
        }
    }

    /* renamed from: d.b.i0.f2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1249b extends CustomMessageListener {
        public C1249b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.i0.s2.b bVar;
            SparseArray<b.a> sparseArray;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.s2.b) || (sparseArray = (bVar = (d.b.i0.s2.b) customResponsedMessage.getData()).f60186a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f60186a.get(2);
            b.a aVar2 = bVar.f60186a.get(3);
            b.a aVar3 = bVar.f60186a.get(9);
            b.a aVar4 = bVar.f60186a.get(10);
            if (b.this.f54748a.w() != null) {
                if (aVar2 != null) {
                    b.this.f54748a.w().f(aVar2.f60187a);
                }
                if (aVar != null) {
                    b.this.f54748a.w().d(aVar.f60187a);
                }
                if (aVar3 != null) {
                    b.this.f54748a.w().c(aVar3.f60187a);
                }
                if (aVar4 != null) {
                    b.this.f54748a.w().e(aVar4.f60187a);
                }
            }
            b.a aVar5 = bVar.f60186a.get(5);
            if (aVar5 != null) {
                b.this.f54749b.o(5, aVar5.f60187a);
            }
            b.a aVar6 = bVar.f60186a.get(6);
            if (aVar6 != null) {
                b.this.f54749b.o(6, aVar6.f60187a);
            }
            b.this.f54749b.g();
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
            if (b.this.f54748a.w() != null) {
                b.this.f54748a.w().u(mVar);
                b.this.f54749b.g();
                return;
            }
            b.this.j();
        }
    }

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        d.b.i0.f2.g.c cVar = new d.b.i0.f2.g.c(view, tbPageContext, bdUniqueId);
        this.f54749b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f54748a = personCenterModel;
        personCenterModel.B(this.f54750c);
        d.b.i0.s2.a.v();
        this.f54751d.setTag(bdUniqueId);
        this.f54752e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f54751d);
        MessageManager.getInstance().registerListener(this.f54752e);
        this.f54753f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f54753f);
    }

    @Override // d.b.i0.f2.g.c.InterfaceC1250c
    public void a(View view) {
        this.f54748a.LoadData();
    }

    public void d() {
        this.f54749b.c();
    }

    public void e() {
        this.f54749b.e();
    }

    public void f(int i) {
        this.f54749b.h(i);
    }

    public void g() {
        this.f54749b.i();
    }

    public void h(String str) {
        f w = this.f54748a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setPortrait(str);
        this.f54749b.g();
    }

    public void i(String str) {
        f w = this.f54748a.w();
        if (w == null || w.p() == null) {
            return;
        }
        w.p().setName_show(str);
        this.f54749b.g();
    }

    public void j() {
        d.b.i0.f2.a.d().j(System.currentTimeMillis());
        this.f54748a.LoadData();
    }

    public void k(boolean z) {
        this.f54748a.C(z);
    }

    public void l() {
        this.f54749b.m();
    }
}

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
public class b implements c.InterfaceC1420c {

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f59209a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.h2.g.c f59210b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f59211c = new a();

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f59212d = new C1419b(2001435);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f59213e = new c(this, 2005016);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f59214f = new d(2016485);

    /* loaded from: classes5.dex */
    public class a implements PersonCenterModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.f59210b.d();
            b.this.f59210b.j(fVar);
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
            if (i2 != -1 || b.this.f59209a.mIsDataLoaded) {
                b.this.f59210b.l(i2, str);
            } else {
                b.this.f59210b.n();
            }
        }
    }

    /* renamed from: d.a.n0.h2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1419b extends CustomMessageListener {
        public C1419b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.n0.u2.b bVar;
            SparseArray<b.a> sparseArray;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.n0.u2.b) || (sparseArray = (bVar = (d.a.n0.u2.b) customResponsedMessage.getData()).f65073a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f65073a.get(2);
            b.a aVar2 = bVar.f65073a.get(3);
            b.a aVar3 = bVar.f65073a.get(9);
            b.a aVar4 = bVar.f65073a.get(10);
            if (b.this.f59209a.A() != null) {
                if (aVar2 != null) {
                    b.this.f59209a.A().f(aVar2.f65074a);
                }
                if (aVar != null) {
                    b.this.f59209a.A().d(aVar.f65074a);
                }
                if (aVar3 != null) {
                    b.this.f59209a.A().c(aVar3.f65074a);
                }
                if (aVar4 != null) {
                    b.this.f59209a.A().e(aVar4.f65074a);
                }
            }
            b.a aVar5 = bVar.f65073a.get(5);
            if (aVar5 != null) {
                b.this.f59210b.o(5, aVar5.f65074a);
            }
            b.a aVar6 = bVar.f65073a.get(6);
            if (aVar6 != null) {
                b.this.f59210b.o(6, aVar6.f65074a);
            }
            b.this.f59210b.g();
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
            if (b.this.f59209a.A() != null) {
                b.this.f59209a.A().u(nVar);
                b.this.f59210b.g();
                return;
            }
            b.this.j();
        }
    }

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        d.a.n0.h2.g.c cVar = new d.a.n0.h2.g.c(view, tbPageContext, bdUniqueId);
        this.f59210b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f59209a = personCenterModel;
        personCenterModel.F(this.f59211c);
        d.a.n0.u2.a.v();
        this.f59212d.setTag(bdUniqueId);
        this.f59213e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f59212d);
        MessageManager.getInstance().registerListener(this.f59213e);
        this.f59214f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f59214f);
    }

    @Override // d.a.n0.h2.g.c.InterfaceC1420c
    public void a(View view) {
        this.f59209a.LoadData();
    }

    public void d() {
        this.f59210b.c();
    }

    public void e() {
        this.f59210b.e();
    }

    public void f(int i2) {
        this.f59210b.h(i2);
    }

    public void g() {
        this.f59210b.i();
    }

    public void h(String str) {
        f A = this.f59209a.A();
        if (A == null || A.p() == null) {
            return;
        }
        A.p().setPortrait(str);
        this.f59210b.g();
    }

    public void i(String str) {
        f A = this.f59209a.A();
        if (A == null || A.p() == null) {
            return;
        }
        A.p().setName_show(str);
        this.f59210b.g();
    }

    public void j() {
        d.a.n0.h2.a.d().j(System.currentTimeMillis());
        this.f59209a.LoadData();
    }

    public void k(boolean z) {
        this.f59209a.G(z);
    }

    public void l() {
        this.f59210b.m();
    }
}

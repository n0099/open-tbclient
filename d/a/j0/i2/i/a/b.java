package d.a.j0.i2.i.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.j0.x.q;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55593a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f55594b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.i2.i.b.a f55595c;

    /* renamed from: d  reason: collision with root package name */
    public int f55596d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f55597e = new C1310b(2921428);

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f55598f = new c(2016557);

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f55599g = new d(2921436);

    /* loaded from: classes4.dex */
    public class a implements q.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a2 f55600a;

        public a(a2 a2Var) {
            this.f55600a = a2Var;
        }

        @Override // d.a.j0.x.q.i
        public void a(boolean z) {
            if (z) {
                l.L(b.this.f55593a.getPageActivity(), R.string.thread_has_hide);
            }
            b.this.h(z, this.f55600a);
        }
    }

    /* renamed from: d.a.j0.i2.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1310b extends CustomMessageListener {
        public C1310b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a2) || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != b.this.f55594b || b.this.f55595c == null || !b.this.f55595c.i0()) {
                return;
            }
            b.this.k((a2) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            b.this.j((String) customResponsedMessage.getData());
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            b.this.i((String) customResponsedMessage.getData());
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, d.a.j0.i2.i.b.a aVar, int i2) {
        this.f55593a = tbPageContext;
        this.f55594b = bdUniqueId;
        this.f55595c = aVar;
        this.f55596d = i2;
        this.f55597e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55597e);
        this.f55598f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55598f);
        this.f55599g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55599g);
    }

    public final void h(boolean z, a2 a2Var) {
        d.a.j0.i2.i.b.a aVar;
        a2 e2;
        if (a2Var == null || (aVar = this.f55595c) == null || ListUtils.isEmpty(aVar.J()) || this.f55595c.E() == null || this.f55595c.E().e() == null) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f55595c.J().size()) {
                break;
            }
            n nVar = this.f55595c.J().get(i2);
            if (nVar != null && (e2 = d.a.j0.i2.i.c.a.e(nVar)) != null && !StringUtils.isNull(e2.A) && e2.A.equals(a2Var.A)) {
                e2.b2 = z;
                d.a.j0.x.e0.b d2 = d.a.j0.i2.i.c.a.d(e2);
                if (d2 != null) {
                    this.f55595c.J().set(i2, d2);
                    z2 = true;
                    break;
                }
            }
            i2++;
        }
        if (z2) {
            this.f55595c.E().n(this.f55595c.J());
        }
    }

    public final void i(String str) {
        d.a.j0.i2.i.b.a aVar;
        a2 e2;
        if (StringUtils.isNull(str) || (aVar = this.f55595c) == null || ListUtils.isEmpty(aVar.J()) || this.f55595c.E() == null || this.f55595c.E().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f55595c.J().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = d.a.j0.i2.i.c.a.e(next)) != null && e2.V() != null && !StringUtils.isNull(e2.V().oriUgcNid) && e2.V().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f55595c.E().n(this.f55595c.J());
        }
    }

    public final void j(String str) {
        d.a.j0.i2.i.b.a aVar;
        a2 e2;
        if (StringUtils.isNull(str) || (aVar = this.f55595c) == null || ListUtils.isEmpty(aVar.J()) || this.f55595c.E() == null || this.f55595c.E().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f55595c.J().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = d.a.j0.i2.i.c.a.e(next)) != null && !StringUtils.isNull(e2.A) && e2.A.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f55595c.E().n(this.f55595c.J());
        }
    }

    public final void k(a2 a2Var) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.r = a2Var;
        cardPersonDynamicThreadData.f15057e = String.valueOf(a2Var.c0());
        cardPersonDynamicThreadData.f15058f = a2Var.A;
        cardPersonDynamicThreadData.f15059g = a2Var.c2;
        cardPersonDynamicThreadData.q = a2Var.b2;
        if (a2Var != null && a2Var.V() != null) {
            cardPersonDynamicThreadData.I = a2Var.V().oriUgcNid;
        }
        q qVar = new q(this.f55593a);
        qVar.t(this.f55596d == 1);
        qVar.o();
        qVar.s(new a(a2Var));
        qVar.n(cardPersonDynamicThreadData, false);
        qVar.u();
    }
}

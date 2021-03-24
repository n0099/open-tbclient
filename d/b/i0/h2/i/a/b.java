package d.b.i0.h2.i.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.i0.x.q;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55355a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f55356b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.h2.i.b.a f55357c;

    /* renamed from: d  reason: collision with root package name */
    public int f55358d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f55359e = new C1272b(2921428);

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f55360f = new c(2016557);

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f55361g = new d(2921436);

    /* loaded from: classes5.dex */
    public class a implements q.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a2 f55362a;

        public a(a2 a2Var) {
            this.f55362a = a2Var;
        }

        @Override // d.b.i0.x.q.i
        public void a(boolean z) {
            if (z) {
                l.K(b.this.f55355a.getPageActivity(), R.string.thread_has_hide);
            }
            b.this.h(z, this.f55362a);
        }
    }

    /* renamed from: d.b.i0.h2.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1272b extends CustomMessageListener {
        public C1272b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a2) || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != b.this.f55356b || b.this.f55357c == null || !b.this.f55357c.X()) {
                return;
            }
            b.this.k((a2) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
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

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
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

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, d.b.i0.h2.i.b.a aVar, int i) {
        this.f55355a = tbPageContext;
        this.f55356b = bdUniqueId;
        this.f55357c = aVar;
        this.f55358d = i;
        this.f55359e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55359e);
        this.f55360f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55360f);
        this.f55361g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55361g);
    }

    public final void h(boolean z, a2 a2Var) {
        d.b.i0.h2.i.b.a aVar;
        a2 e2;
        if (a2Var == null || (aVar = this.f55357c) == null || ListUtils.isEmpty(aVar.i0()) || this.f55357c.C() == null || this.f55357c.C().e() == null) {
            return;
        }
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= this.f55357c.i0().size()) {
                break;
            }
            n nVar = this.f55357c.i0().get(i);
            if (nVar != null && (e2 = d.b.i0.h2.i.c.a.e(nVar)) != null && !StringUtils.isNull(e2.A) && e2.A.equals(a2Var.A)) {
                e2.b2 = z;
                d.b.i0.x.e0.b d2 = d.b.i0.h2.i.c.a.d(e2);
                if (d2 != null) {
                    this.f55357c.i0().set(i, d2);
                    z2 = true;
                    break;
                }
            }
            i++;
        }
        if (z2) {
            this.f55357c.C().n(this.f55357c.i0());
        }
    }

    public final void i(String str) {
        d.b.i0.h2.i.b.a aVar;
        a2 e2;
        if (StringUtils.isNull(str) || (aVar = this.f55357c) == null || ListUtils.isEmpty(aVar.i0()) || this.f55357c.C() == null || this.f55357c.C().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f55357c.i0().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = d.b.i0.h2.i.c.a.e(next)) != null && e2.V() != null && !StringUtils.isNull(e2.V().oriUgcNid) && e2.V().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f55357c.C().n(this.f55357c.i0());
        }
    }

    public final void j(String str) {
        d.b.i0.h2.i.b.a aVar;
        a2 e2;
        if (StringUtils.isNull(str) || (aVar = this.f55357c) == null || ListUtils.isEmpty(aVar.i0()) || this.f55357c.C() == null || this.f55357c.C().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f55357c.i0().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = d.b.i0.h2.i.c.a.e(next)) != null && !StringUtils.isNull(e2.A) && e2.A.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f55357c.C().n(this.f55357c.i0());
        }
    }

    public final void k(a2 a2Var) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.r = a2Var;
        cardPersonDynamicThreadData.f15274e = String.valueOf(a2Var.c0());
        cardPersonDynamicThreadData.f15275f = a2Var.A;
        cardPersonDynamicThreadData.f15276g = a2Var.c2;
        cardPersonDynamicThreadData.q = a2Var.b2;
        if (a2Var != null && a2Var.V() != null) {
            cardPersonDynamicThreadData.I = a2Var.V().oriUgcNid;
        }
        q qVar = new q(this.f55355a);
        qVar.t(this.f55358d == 1);
        qVar.o();
        qVar.s(new a(a2Var));
        qVar.n(cardPersonDynamicThreadData, false);
        qVar.u();
    }
}

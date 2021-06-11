package d.a.n0.j2.i.a;

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
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.z.q;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60173a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f60174b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.j2.i.b.a f60175c;

    /* renamed from: d  reason: collision with root package name */
    public int f60176d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f60177e = new C1456b(2921428);

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f60178f = new c(2016557);

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f60179g = new d(2921436);

    /* loaded from: classes5.dex */
    public class a implements q.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a2 f60180a;

        public a(a2 a2Var) {
            this.f60180a = a2Var;
        }

        @Override // d.a.n0.z.q.i
        public void a(boolean z) {
            if (z) {
                l.L(b.this.f60173a.getPageActivity(), R.string.thread_has_hide);
            }
            b.this.h(z, this.f60180a);
        }
    }

    /* renamed from: d.a.n0.j2.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1456b extends CustomMessageListener {
        public C1456b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a2) || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != b.this.f60174b || b.this.f60175c == null || !b.this.f60175c.l0()) {
                return;
            }
            b.this.k((a2) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, d.a.n0.j2.i.b.a aVar, int i2) {
        this.f60173a = tbPageContext;
        this.f60174b = bdUniqueId;
        this.f60175c = aVar;
        this.f60176d = i2;
        this.f60177e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f60177e);
        this.f60178f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f60178f);
        this.f60179g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f60179g);
    }

    public final void h(boolean z, a2 a2Var) {
        d.a.n0.j2.i.b.a aVar;
        a2 e2;
        if (a2Var == null || (aVar = this.f60175c) == null || ListUtils.isEmpty(aVar.K()) || this.f60175c.E() == null || this.f60175c.E().e() == null) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f60175c.K().size()) {
                break;
            }
            n nVar = this.f60175c.K().get(i2);
            if (nVar != null && (e2 = d.a.n0.j2.i.c.a.e(nVar)) != null && !StringUtils.isNull(e2.A) && e2.A.equals(a2Var.A)) {
                e2.e2 = z;
                d.a.n0.z.e0.b d2 = d.a.n0.j2.i.c.a.d(e2);
                if (d2 != null) {
                    this.f60175c.K().set(i2, d2);
                    z2 = true;
                    break;
                }
            }
            i2++;
        }
        if (z2) {
            this.f60175c.E().n(this.f60175c.K());
        }
    }

    public final void i(String str) {
        d.a.n0.j2.i.b.a aVar;
        a2 e2;
        if (StringUtils.isNull(str) || (aVar = this.f60175c) == null || ListUtils.isEmpty(aVar.K()) || this.f60175c.E() == null || this.f60175c.E().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f60175c.K().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = d.a.n0.j2.i.c.a.e(next)) != null && e2.V() != null && !StringUtils.isNull(e2.V().oriUgcNid) && e2.V().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f60175c.E().n(this.f60175c.K());
        }
    }

    public final void j(String str) {
        d.a.n0.j2.i.b.a aVar;
        a2 e2;
        if (StringUtils.isNull(str) || (aVar = this.f60175c) == null || ListUtils.isEmpty(aVar.K()) || this.f60175c.E() == null || this.f60175c.E().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f60175c.K().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = d.a.n0.j2.i.c.a.e(next)) != null && !StringUtils.isNull(e2.A) && e2.A.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f60175c.E().n(this.f60175c.K());
        }
    }

    public final void k(a2 a2Var) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
        cardPersonDynamicThreadData.r = a2Var;
        cardPersonDynamicThreadData.f14332e = String.valueOf(a2Var.c0());
        cardPersonDynamicThreadData.f14333f = a2Var.A;
        cardPersonDynamicThreadData.f14334g = a2Var.f2;
        cardPersonDynamicThreadData.q = a2Var.e2;
        if (a2Var != null && a2Var.V() != null) {
            cardPersonDynamicThreadData.I = a2Var.V().oriUgcNid;
        }
        q qVar = new q(this.f60173a);
        qVar.t(this.f60176d == 1);
        qVar.o();
        qVar.s(new a(a2Var));
        qVar.n(cardPersonDynamicThreadData, false);
        qVar.u();
    }
}

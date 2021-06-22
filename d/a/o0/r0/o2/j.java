package d.a.o0.r0.o2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import d.a.o0.r0.a0;
import d.a.o0.r0.r;
import d.a.o0.r0.s0;
import d.a.o0.r0.u;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class j extends d.a.o0.r0.e2.j {

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.r0.h2.a f63100h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f63101i;
    public HashMap<Integer, a0> j;
    public boolean k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public s0 q;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                j.this.k = false;
                return;
            }
            j.this.k = true;
            j.this.f62354b.B2().J();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || j.this.f62353a == null) {
                return;
            }
            j.this.f62353a.K1();
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a0)) {
                return;
            }
            j.this.f62353a.M1();
            a0 a0Var = (a0) customResponsedMessage.getData();
            s0 s0Var = a0Var.f62180b;
            if (s0Var != null) {
                j.this.e0(a0Var.f62179a, s0Var);
            } else {
                int i2 = a0Var.f62179a;
                if (i2 != 1) {
                    j.this.e0(i2, null);
                } else {
                    j jVar = j.this;
                    jVar.e0(i2, jVar.q);
                }
            }
            j.this.h0(a0Var.f62179a);
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a0)) {
                return;
            }
            a0 a0Var = (a0) customResponsedMessage.getData();
            j.this.f0(a0Var.f62179a, a0Var.f62181c);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof u)) {
                return;
            }
            u uVar = (u) customResponsedMessage.getData();
            j.this.g0(uVar.f63477a, uVar.f63478b);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements s0 {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f62353a.e0() == null || j.this.f62358f == null || j.this.f62353a.e0().getVisibility() == 0) {
                    return;
                }
                j.this.f62358f.o();
            }
        }

        public f() {
        }

        @Override // d.a.o0.r0.s0
        public void l() {
            if (j.this.f62354b == null || !j.this.f62354b.isAdded()) {
                return;
            }
            if (j.this.f63101i && j.this.f62354b.B2() != null) {
                if (!j.this.k && !j.this.c0()) {
                    j.this.f62354b.B2().c0();
                }
                j.this.f63101i = false;
            }
            if (j.this.f63100h != null && j.this.f62354b.B0() != null && j.this.f62354b.B0().W() != null && !j.this.f62354b.B0().W().o() && j.this.f62354b.B2() != null && !j.this.f62354b.B2().T()) {
                j.this.f63100h.b();
            }
            if (j.this.f62353a == null || j.this.f62358f == null || j.this.f62356d == null || j.this.f63100h == null) {
                return;
            }
            j.this.f62353a.g0().n(0, 0, true, true);
            j.this.f62354b.d3();
            j.this.f62354b.p3(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (j.this.f62354b.B0() != null) {
                j.this.f62354b.B0().k1(1, false);
            }
            j.this.f62356d.t0();
            if (!TbadkCoreApplication.isLogin() || j.this.f62354b.x2().getVisibility() != 0 || ListUtils.isEmpty(j.this.f62354b.j0().getThreadList())) {
            }
        }

        @Override // d.a.o0.r0.s0
        public void n() {
            j.this.f63101i = true;
            if (j.this.f62353a == null || j.this.f62358f == null || j.this.f62356d == null || j.this.f62354b == null || !j.this.f62354b.isAdded()) {
                return;
            }
            if (j.this.f62353a != null && j.this.f62353a.g0() != null) {
                j.this.f62353a.g0().w();
            }
            j.this.f62354b.p3(false);
            d.a.c.e.m.e.a().postDelayed(new a(), 110L);
            j.this.f62353a.k1(1, true);
            if (d.a.c.e.p.j.z()) {
                j.this.f62354b.refresh();
                j.this.f62354b.p3(true);
            } else {
                j.this.f62354b.F3();
            }
            TiebaStatic.log(new StatisticItem("c11749").param("fid", j.this.f62354b.G()).param("obj_locate", "1"));
        }
    }

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.f63101i = false;
        this.k = false;
        this.l = new a(2921468);
        this.m = new b(2003003);
        this.n = new c(2921448);
        this.o = new d(9205410);
        this.p = new e(2921449);
        this.q = new f();
        this.f63100h = frsFragment.v2();
        this.j = new HashMap<>();
        this.f62353a.Z0(1);
        frsFragment.registerListener(this.m);
        frsFragment.registerListener(this.n);
        frsFragment.registerListener(this.o);
        frsFragment.registerListener(this.p);
        frsFragment.registerListener(this.l);
    }

    public void b0() {
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final boolean c0() {
        if (this.f62354b.j0() == null || this.f62354b.j0().getUserData() == null || this.f62354b.j0().forumRule == null || this.f62354b.j0().getForum() == null || !this.f62354b.j0().getForum().getIsShowRule()) {
            return false;
        }
        return this.f62354b.j0().getUserData().getIs_manager() == 1 ? this.f62354b.j0().forumRule.has_forum_rule.intValue() != 1 && this.f62354b.j0().forumRule.audit_status.intValue() == 0 && d.a.n0.r.d0.b.j().k("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f62354b.j0().forumRule.has_forum_rule.intValue() == 1 && d.a.n0.r.d0.b.j().k("key_forum_rule_first_show_frs", 0) <= 0;
    }

    public void d0() {
        if (this.f62353a == null) {
            return;
        }
        n nVar = this.f62355c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).y() != null && (((FrsTabViewController) this.f62355c).y().f15905b instanceof s0)) {
            FrsTabViewController.o y = ((FrsTabViewController) this.f62355c).y();
            e0(y.f15904a, (s0) y.f15905b);
            h0(y.f15904a);
            return;
        }
        this.f62353a.g1(this.q);
    }

    public final void e0(int i2, s0 s0Var) {
        a0 a0Var = this.j.get(Integer.valueOf(i2));
        if (a0Var == null) {
            a0 a0Var2 = new a0();
            a0Var2.f62179a = i2;
            a0Var2.f62180b = s0Var;
            this.j.put(Integer.valueOf(i2), a0Var2);
        } else {
            a0Var.f62180b = s0Var;
        }
        r rVar = this.f62353a;
        if (rVar != null) {
            rVar.g1(s0Var);
        }
    }

    public final void f0(int i2, boolean z) {
        a0 a0Var = this.j.get(Integer.valueOf(i2));
        if (a0Var == null) {
            a0 a0Var2 = new a0();
            a0Var2.f62179a = i2;
            a0Var2.f62181c = z;
            this.j.put(Integer.valueOf(i2), a0Var2);
        } else {
            a0Var.f62181c = z;
        }
        r rVar = this.f62353a;
        if (rVar != null) {
            rVar.u1(z);
        }
    }

    public final void g0(int i2, boolean z) {
        r rVar = this.f62353a;
        if (rVar != null) {
            rVar.k1(i2, z);
        }
    }

    public final void h0(int i2) {
        a0 a0Var;
        if (this.f62353a == null || (a0Var = this.j.get(Integer.valueOf(i2))) == null) {
            return;
        }
        this.f62353a.Z0(i2);
        this.f62353a.g1(a0Var.f62180b);
        this.f62353a.u1(a0Var.f62181c);
        if (a0Var.f62180b == null) {
            this.f62353a.u1(false);
        }
    }
}

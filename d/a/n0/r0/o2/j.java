package d.a.n0.r0.o2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import d.a.n0.r0.a0;
import d.a.n0.r0.r;
import d.a.n0.r0.s0;
import d.a.n0.r0.u;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class j extends d.a.n0.r0.e2.j {

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.r0.h2.a f62975h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62976i;
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
            j.this.f62229b.B2().J();
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
            if (customResponsedMessage == null || j.this.f62228a == null) {
                return;
            }
            j.this.f62228a.K1();
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
            j.this.f62228a.M1();
            a0 a0Var = (a0) customResponsedMessage.getData();
            s0 s0Var = a0Var.f62055b;
            if (s0Var != null) {
                j.this.e0(a0Var.f62054a, s0Var);
            } else {
                int i2 = a0Var.f62054a;
                if (i2 != 1) {
                    j.this.e0(i2, null);
                } else {
                    j jVar = j.this;
                    jVar.e0(i2, jVar.q);
                }
            }
            j.this.h0(a0Var.f62054a);
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
            j.this.f0(a0Var.f62054a, a0Var.f62056c);
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
            j.this.g0(uVar.f63352a, uVar.f63353b);
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
                if (j.this.f62228a.e0() == null || j.this.f62233f == null || j.this.f62228a.e0().getVisibility() == 0) {
                    return;
                }
                j.this.f62233f.o();
            }
        }

        public f() {
        }

        @Override // d.a.n0.r0.s0
        public void l() {
            if (j.this.f62229b == null || !j.this.f62229b.isAdded()) {
                return;
            }
            if (j.this.f62976i && j.this.f62229b.B2() != null) {
                if (!j.this.k && !j.this.c0()) {
                    j.this.f62229b.B2().c0();
                }
                j.this.f62976i = false;
            }
            if (j.this.f62975h != null && j.this.f62229b.B0() != null && j.this.f62229b.B0().W() != null && !j.this.f62229b.B0().W().o() && j.this.f62229b.B2() != null && !j.this.f62229b.B2().T()) {
                j.this.f62975h.b();
            }
            if (j.this.f62228a == null || j.this.f62233f == null || j.this.f62231d == null || j.this.f62975h == null) {
                return;
            }
            j.this.f62228a.g0().n(0, 0, true, true);
            j.this.f62229b.d3();
            j.this.f62229b.p3(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (j.this.f62229b.B0() != null) {
                j.this.f62229b.B0().k1(1, false);
            }
            j.this.f62231d.t0();
            if (!TbadkCoreApplication.isLogin() || j.this.f62229b.x2().getVisibility() != 0 || ListUtils.isEmpty(j.this.f62229b.j0().getThreadList())) {
            }
        }

        @Override // d.a.n0.r0.s0
        public void n() {
            j.this.f62976i = true;
            if (j.this.f62228a == null || j.this.f62233f == null || j.this.f62231d == null || j.this.f62229b == null || !j.this.f62229b.isAdded()) {
                return;
            }
            if (j.this.f62228a != null && j.this.f62228a.g0() != null) {
                j.this.f62228a.g0().w();
            }
            j.this.f62229b.p3(false);
            d.a.c.e.m.e.a().postDelayed(new a(), 110L);
            j.this.f62228a.k1(1, true);
            if (d.a.c.e.p.j.z()) {
                j.this.f62229b.refresh();
                j.this.f62229b.p3(true);
            } else {
                j.this.f62229b.F3();
            }
            TiebaStatic.log(new StatisticItem("c11749").param("fid", j.this.f62229b.G()).param("obj_locate", "1"));
        }
    }

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.f62976i = false;
        this.k = false;
        this.l = new a(2921468);
        this.m = new b(2003003);
        this.n = new c(2921448);
        this.o = new d(9205410);
        this.p = new e(2921449);
        this.q = new f();
        this.f62975h = frsFragment.v2();
        this.j = new HashMap<>();
        this.f62228a.Z0(1);
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
        if (this.f62229b.j0() == null || this.f62229b.j0().getUserData() == null || this.f62229b.j0().forumRule == null || this.f62229b.j0().getForum() == null || !this.f62229b.j0().getForum().getIsShowRule()) {
            return false;
        }
        return this.f62229b.j0().getUserData().getIs_manager() == 1 ? this.f62229b.j0().forumRule.has_forum_rule.intValue() != 1 && this.f62229b.j0().forumRule.audit_status.intValue() == 0 && d.a.m0.r.d0.b.j().k("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f62229b.j0().forumRule.has_forum_rule.intValue() == 1 && d.a.m0.r.d0.b.j().k("key_forum_rule_first_show_frs", 0) <= 0;
    }

    public void d0() {
        if (this.f62228a == null) {
            return;
        }
        n nVar = this.f62230c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).y() != null && (((FrsTabViewController) this.f62230c).y().f15823b instanceof s0)) {
            FrsTabViewController.o y = ((FrsTabViewController) this.f62230c).y();
            e0(y.f15822a, (s0) y.f15823b);
            h0(y.f15822a);
            return;
        }
        this.f62228a.g1(this.q);
    }

    public final void e0(int i2, s0 s0Var) {
        a0 a0Var = this.j.get(Integer.valueOf(i2));
        if (a0Var == null) {
            a0 a0Var2 = new a0();
            a0Var2.f62054a = i2;
            a0Var2.f62055b = s0Var;
            this.j.put(Integer.valueOf(i2), a0Var2);
        } else {
            a0Var.f62055b = s0Var;
        }
        r rVar = this.f62228a;
        if (rVar != null) {
            rVar.g1(s0Var);
        }
    }

    public final void f0(int i2, boolean z) {
        a0 a0Var = this.j.get(Integer.valueOf(i2));
        if (a0Var == null) {
            a0 a0Var2 = new a0();
            a0Var2.f62054a = i2;
            a0Var2.f62056c = z;
            this.j.put(Integer.valueOf(i2), a0Var2);
        } else {
            a0Var.f62056c = z;
        }
        r rVar = this.f62228a;
        if (rVar != null) {
            rVar.u1(z);
        }
    }

    public final void g0(int i2, boolean z) {
        r rVar = this.f62228a;
        if (rVar != null) {
            rVar.k1(i2, z);
        }
    }

    public final void h0(int i2) {
        a0 a0Var;
        if (this.f62228a == null || (a0Var = this.j.get(Integer.valueOf(i2))) == null) {
            return;
        }
        this.f62228a.Z0(i2);
        this.f62228a.g1(a0Var.f62055b);
        this.f62228a.u1(a0Var.f62056c);
        if (a0Var.f62055b == null) {
            this.f62228a.u1(false);
        }
    }
}

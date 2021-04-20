package d.b.i0.q0.o2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import d.b.i0.q0.a0;
import d.b.i0.q0.r;
import d.b.i0.q0.s0;
import d.b.i0.q0.u;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class j extends d.b.i0.q0.e2.j {

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.q0.h2.a f59890h;
    public boolean i;
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
        public a(int i) {
            super(i);
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
            j.this.f59177b.z2().J();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || j.this.f59176a == null) {
                return;
            }
            j.this.f59176a.K1();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a0)) {
                return;
            }
            j.this.f59176a.M1();
            a0 a0Var = (a0) customResponsedMessage.getData();
            s0 s0Var = a0Var.f59021b;
            if (s0Var != null) {
                j.this.e0(a0Var.f59020a, s0Var);
            } else {
                int i = a0Var.f59020a;
                if (i != 1) {
                    j.this.e0(i, null);
                } else {
                    j jVar = j.this;
                    jVar.e0(i, jVar.q);
                }
            }
            j.this.h0(a0Var.f59020a);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a0)) {
                return;
            }
            a0 a0Var = (a0) customResponsedMessage.getData();
            j.this.f0(a0Var.f59020a, a0Var.f59022c);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof u)) {
                return;
            }
            u uVar = (u) customResponsedMessage.getData();
            j.this.g0(uVar.f60250a, uVar.f60251b);
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
                if (j.this.f59176a.e0() == null || j.this.f59181f == null || j.this.f59176a.e0().getVisibility() == 0) {
                    return;
                }
                j.this.f59181f.o();
            }
        }

        public f() {
        }

        @Override // d.b.i0.q0.s0
        public void m() {
            j.this.i = true;
            if (j.this.f59176a == null || j.this.f59181f == null || j.this.f59179d == null || j.this.f59177b == null || !j.this.f59177b.isAdded()) {
                return;
            }
            if (j.this.f59176a != null && j.this.f59176a.g0() != null) {
                j.this.f59176a.g0().w();
            }
            j.this.f59177b.n3(false);
            d.b.c.e.m.e.a().postDelayed(new a(), 110L);
            j.this.f59176a.k1(1, true);
            if (d.b.c.e.p.j.z()) {
                j.this.f59177b.refresh();
                j.this.f59177b.n3(true);
            } else {
                j.this.f59177b.D3();
            }
            TiebaStatic.log(new StatisticItem("c11749").param("fid", j.this.f59177b.V()).param("obj_locate", "1"));
        }

        @Override // d.b.i0.q0.s0
        public void o() {
            if (j.this.f59177b == null || !j.this.f59177b.isAdded()) {
                return;
            }
            if (j.this.i && j.this.f59177b.z2() != null) {
                if (!j.this.k && !j.this.c0()) {
                    j.this.f59177b.z2().c0();
                }
                j.this.i = false;
            }
            if (j.this.f59890h != null && j.this.f59177b.x0() != null && j.this.f59177b.x0().W() != null && !j.this.f59177b.x0().W().o() && j.this.f59177b.z2() != null && !j.this.f59177b.z2().T()) {
                j.this.f59890h.b();
            }
            if (j.this.f59176a == null || j.this.f59181f == null || j.this.f59179d == null || j.this.f59890h == null) {
                return;
            }
            j.this.f59176a.g0().n(0, 0, true, true);
            j.this.f59177b.b3();
            j.this.f59177b.n3(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (j.this.f59177b.x0() != null) {
                j.this.f59177b.x0().k1(1, false);
            }
            j.this.f59179d.v0();
            if (!TbadkCoreApplication.isLogin() || j.this.f59177b.v2().getVisibility() != 0 || ListUtils.isEmpty(j.this.f59177b.S().getThreadList())) {
            }
        }
    }

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.i = false;
        this.k = false;
        this.l = new a(2921468);
        this.m = new b(2003003);
        this.n = new c(2921448);
        this.o = new d(9205410);
        this.p = new e(2921449);
        this.q = new f();
        this.f59890h = frsFragment.t2();
        this.j = new HashMap<>();
        this.f59176a.Z0(1);
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
        if (this.f59177b.S() == null || this.f59177b.S().getUserData() == null || this.f59177b.S().forumRule == null || this.f59177b.S().getForum() == null || !this.f59177b.S().getForum().getIsShowRule()) {
            return false;
        }
        return this.f59177b.S().getUserData().getIs_manager() == 1 ? this.f59177b.S().forumRule.has_forum_rule.intValue() != 1 && this.f59177b.S().forumRule.audit_status.intValue() == 0 && d.b.h0.r.d0.b.j().k("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f59177b.S().forumRule.has_forum_rule.intValue() == 1 && d.b.h0.r.d0.b.j().k("key_forum_rule_first_show_frs", 0) <= 0;
    }

    public void d0() {
        if (this.f59176a == null) {
            return;
        }
        n nVar = this.f59178c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).y() != null && (((FrsTabViewController) this.f59178c).y().f16315b instanceof s0)) {
            FrsTabViewController.o y = ((FrsTabViewController) this.f59178c).y();
            e0(y.f16314a, (s0) y.f16315b);
            h0(y.f16314a);
            return;
        }
        this.f59176a.g1(this.q);
    }

    public final void e0(int i, s0 s0Var) {
        a0 a0Var = this.j.get(Integer.valueOf(i));
        if (a0Var == null) {
            a0 a0Var2 = new a0();
            a0Var2.f59020a = i;
            a0Var2.f59021b = s0Var;
            this.j.put(Integer.valueOf(i), a0Var2);
        } else {
            a0Var.f59021b = s0Var;
        }
        r rVar = this.f59176a;
        if (rVar != null) {
            rVar.g1(s0Var);
        }
    }

    public final void f0(int i, boolean z) {
        a0 a0Var = this.j.get(Integer.valueOf(i));
        if (a0Var == null) {
            a0 a0Var2 = new a0();
            a0Var2.f59020a = i;
            a0Var2.f59022c = z;
            this.j.put(Integer.valueOf(i), a0Var2);
        } else {
            a0Var.f59022c = z;
        }
        r rVar = this.f59176a;
        if (rVar != null) {
            rVar.u1(z);
        }
    }

    public final void g0(int i, boolean z) {
        r rVar = this.f59176a;
        if (rVar != null) {
            rVar.k1(i, z);
        }
    }

    public final void h0(int i) {
        a0 a0Var;
        if (this.f59176a == null || (a0Var = this.j.get(Integer.valueOf(i))) == null) {
            return;
        }
        this.f59176a.Z0(i);
        this.f59176a.g1(a0Var.f59021b);
        this.f59176a.u1(a0Var.f59022c);
        if (a0Var.f59021b == null) {
            this.f59176a.u1(false);
        }
    }
}

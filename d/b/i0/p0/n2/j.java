package d.b.i0.p0.n2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import d.b.i0.p0.a0;
import d.b.i0.p0.r;
import d.b.i0.p0.s0;
import d.b.i0.p0.u;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class j extends d.b.i0.p0.e2.j {

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.p0.h2.a f58194h;
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
            j.this.f57478b.z2().J();
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
            if (customResponsedMessage == null || j.this.f57477a == null) {
                return;
            }
            j.this.f57477a.K1();
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
            j.this.f57477a.M1();
            a0 a0Var = (a0) customResponsedMessage.getData();
            s0 s0Var = a0Var.f57322b;
            if (s0Var != null) {
                j.this.e0(a0Var.f57321a, s0Var);
            } else {
                int i = a0Var.f57321a;
                if (i != 1) {
                    j.this.e0(i, null);
                } else {
                    j jVar = j.this;
                    jVar.e0(i, jVar.q);
                }
            }
            j.this.h0(a0Var.f57321a);
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
            j.this.f0(a0Var.f57321a, a0Var.f57323c);
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
            j.this.g0(uVar.f58582a, uVar.f58583b);
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
                if (j.this.f57477a.e0() == null || j.this.f57482f == null || j.this.f57477a.e0().getVisibility() == 0) {
                    return;
                }
                j.this.f57482f.o();
            }
        }

        public f() {
        }

        @Override // d.b.i0.p0.s0
        public void m() {
            j.this.i = true;
            if (j.this.f57477a == null || j.this.f57482f == null || j.this.f57480d == null || j.this.f57478b == null || !j.this.f57478b.isAdded()) {
                return;
            }
            if (j.this.f57477a != null && j.this.f57477a.g0() != null) {
                j.this.f57477a.g0().w();
            }
            j.this.f57478b.n3(false);
            d.b.b.e.m.e.a().postDelayed(new a(), 110L);
            j.this.f57477a.k1(1, true);
            if (d.b.b.e.p.j.z()) {
                j.this.f57478b.refresh();
                j.this.f57478b.n3(true);
            } else {
                j.this.f57478b.D3();
            }
            TiebaStatic.log(new StatisticItem("c11749").param("fid", j.this.f57478b.V()).param("obj_locate", "1"));
        }

        @Override // d.b.i0.p0.s0
        public void o() {
            if (j.this.f57478b == null || !j.this.f57478b.isAdded()) {
                return;
            }
            if (j.this.i && j.this.f57478b.z2() != null) {
                if (!j.this.k && !j.this.c0()) {
                    j.this.f57478b.z2().c0();
                }
                j.this.i = false;
            }
            if (j.this.f58194h != null && j.this.f57478b.x0() != null && j.this.f57478b.x0().W() != null && !j.this.f57478b.x0().W().o() && j.this.f57478b.z2() != null && !j.this.f57478b.z2().T()) {
                j.this.f58194h.b();
            }
            if (j.this.f57477a == null || j.this.f57482f == null || j.this.f57480d == null || j.this.f58194h == null) {
                return;
            }
            j.this.f57477a.g0().n(0, 0, true, true);
            j.this.f57478b.b3();
            j.this.f57478b.n3(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (j.this.f57478b.x0() != null) {
                j.this.f57478b.x0().k1(1, false);
            }
            j.this.f57480d.v0();
            if (!TbadkCoreApplication.isLogin() || j.this.f57478b.v2().getVisibility() != 0 || ListUtils.isEmpty(j.this.f57478b.S().getThreadList())) {
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
        this.f58194h = frsFragment.t2();
        this.j = new HashMap<>();
        this.f57477a.Z0(1);
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
        if (this.f57478b.S() == null || this.f57478b.S().getUserData() == null || this.f57478b.S().forumRule == null || this.f57478b.S().getForum() == null || !this.f57478b.S().getForum().getIsShowRule()) {
            return false;
        }
        return this.f57478b.S().getUserData().getIs_manager() == 1 ? this.f57478b.S().forumRule.has_forum_rule.intValue() != 1 && this.f57478b.S().forumRule.audit_status.intValue() == 0 && d.b.h0.r.d0.b.i().j("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f57478b.S().forumRule.has_forum_rule.intValue() == 1 && d.b.h0.r.d0.b.i().j("key_forum_rule_first_show_frs", 0) <= 0;
    }

    public void d0() {
        if (this.f57477a == null) {
            return;
        }
        n nVar = this.f57479c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).y() != null && (((FrsTabViewController) this.f57479c).y().f16654b instanceof s0)) {
            FrsTabViewController.o y = ((FrsTabViewController) this.f57479c).y();
            e0(y.f16653a, (s0) y.f16654b);
            h0(y.f16653a);
            return;
        }
        this.f57477a.g1(this.q);
    }

    public final void e0(int i, s0 s0Var) {
        a0 a0Var = this.j.get(Integer.valueOf(i));
        if (a0Var == null) {
            a0 a0Var2 = new a0();
            a0Var2.f57321a = i;
            a0Var2.f57322b = s0Var;
            this.j.put(Integer.valueOf(i), a0Var2);
        } else {
            a0Var.f57322b = s0Var;
        }
        r rVar = this.f57477a;
        if (rVar != null) {
            rVar.g1(s0Var);
        }
    }

    public final void f0(int i, boolean z) {
        a0 a0Var = this.j.get(Integer.valueOf(i));
        if (a0Var == null) {
            a0 a0Var2 = new a0();
            a0Var2.f57321a = i;
            a0Var2.f57323c = z;
            this.j.put(Integer.valueOf(i), a0Var2);
        } else {
            a0Var.f57323c = z;
        }
        r rVar = this.f57477a;
        if (rVar != null) {
            rVar.u1(z);
        }
    }

    public final void g0(int i, boolean z) {
        r rVar = this.f57477a;
        if (rVar != null) {
            rVar.k1(i, z);
        }
    }

    public final void h0(int i) {
        a0 a0Var;
        if (this.f57477a == null || (a0Var = this.j.get(Integer.valueOf(i))) == null) {
            return;
        }
        this.f57477a.Z0(i);
        this.f57477a.g1(a0Var.f57322b);
        this.f57477a.u1(a0Var.f57323c);
        if (a0Var.f57322b == null) {
            this.f57477a.u1(false);
        }
    }
}

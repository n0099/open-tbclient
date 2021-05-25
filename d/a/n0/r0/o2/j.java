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
    public d.a.n0.r0.h2.a f59284h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59285i;
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
            j.this.f58538b.y2().J();
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
            if (customResponsedMessage == null || j.this.f58537a == null) {
                return;
            }
            j.this.f58537a.K1();
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
            j.this.f58537a.M1();
            a0 a0Var = (a0) customResponsedMessage.getData();
            s0 s0Var = a0Var.f58364b;
            if (s0Var != null) {
                j.this.e0(a0Var.f58363a, s0Var);
            } else {
                int i2 = a0Var.f58363a;
                if (i2 != 1) {
                    j.this.e0(i2, null);
                } else {
                    j jVar = j.this;
                    jVar.e0(i2, jVar.q);
                }
            }
            j.this.h0(a0Var.f58363a);
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
            j.this.f0(a0Var.f58363a, a0Var.f58365c);
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
            j.this.g0(uVar.f59661a, uVar.f59662b);
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
                if (j.this.f58537a.e0() == null || j.this.f58542f == null || j.this.f58537a.e0().getVisibility() == 0) {
                    return;
                }
                j.this.f58542f.o();
            }
        }

        public f() {
        }

        @Override // d.a.n0.r0.s0
        public void k() {
            if (j.this.f58538b == null || !j.this.f58538b.isAdded()) {
                return;
            }
            if (j.this.f59285i && j.this.f58538b.y2() != null) {
                if (!j.this.k && !j.this.c0()) {
                    j.this.f58538b.y2().c0();
                }
                j.this.f59285i = false;
            }
            if (j.this.f59284h != null && j.this.f58538b.y0() != null && j.this.f58538b.y0().W() != null && !j.this.f58538b.y0().W().o() && j.this.f58538b.y2() != null && !j.this.f58538b.y2().T()) {
                j.this.f59284h.b();
            }
            if (j.this.f58537a == null || j.this.f58542f == null || j.this.f58540d == null || j.this.f59284h == null) {
                return;
            }
            j.this.f58537a.g0().n(0, 0, true, true);
            j.this.f58538b.a3();
            j.this.f58538b.m3(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (j.this.f58538b.y0() != null) {
                j.this.f58538b.y0().k1(1, false);
            }
            j.this.f58540d.v0();
            if (!TbadkCoreApplication.isLogin() || j.this.f58538b.u2().getVisibility() != 0 || ListUtils.isEmpty(j.this.f58538b.g0().getThreadList())) {
            }
        }

        @Override // d.a.n0.r0.s0
        public void m() {
            j.this.f59285i = true;
            if (j.this.f58537a == null || j.this.f58542f == null || j.this.f58540d == null || j.this.f58538b == null || !j.this.f58538b.isAdded()) {
                return;
            }
            if (j.this.f58537a != null && j.this.f58537a.g0() != null) {
                j.this.f58537a.g0().w();
            }
            j.this.f58538b.m3(false);
            d.a.c.e.m.e.a().postDelayed(new a(), 110L);
            j.this.f58537a.k1(1, true);
            if (d.a.c.e.p.j.z()) {
                j.this.f58538b.refresh();
                j.this.f58538b.m3(true);
            } else {
                j.this.f58538b.C3();
            }
            TiebaStatic.log(new StatisticItem("c11749").param("fid", j.this.f58538b.F()).param("obj_locate", "1"));
        }
    }

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.f59285i = false;
        this.k = false;
        this.l = new a(2921468);
        this.m = new b(2003003);
        this.n = new c(2921448);
        this.o = new d(9205410);
        this.p = new e(2921449);
        this.q = new f();
        this.f59284h = frsFragment.s2();
        this.j = new HashMap<>();
        this.f58537a.Z0(1);
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
        if (this.f58538b.g0() == null || this.f58538b.g0().getUserData() == null || this.f58538b.g0().forumRule == null || this.f58538b.g0().getForum() == null || !this.f58538b.g0().getForum().getIsShowRule()) {
            return false;
        }
        return this.f58538b.g0().getUserData().getIs_manager() == 1 ? this.f58538b.g0().forumRule.has_forum_rule.intValue() != 1 && this.f58538b.g0().forumRule.audit_status.intValue() == 0 && d.a.m0.r.d0.b.j().k("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f58538b.g0().forumRule.has_forum_rule.intValue() == 1 && d.a.m0.r.d0.b.j().k("key_forum_rule_first_show_frs", 0) <= 0;
    }

    public void d0() {
        if (this.f58537a == null) {
            return;
        }
        n nVar = this.f58539c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).y() != null && (((FrsTabViewController) this.f58539c).y().f15761b instanceof s0)) {
            FrsTabViewController.o y = ((FrsTabViewController) this.f58539c).y();
            e0(y.f15760a, (s0) y.f15761b);
            h0(y.f15760a);
            return;
        }
        this.f58537a.g1(this.q);
    }

    public final void e0(int i2, s0 s0Var) {
        a0 a0Var = this.j.get(Integer.valueOf(i2));
        if (a0Var == null) {
            a0 a0Var2 = new a0();
            a0Var2.f58363a = i2;
            a0Var2.f58364b = s0Var;
            this.j.put(Integer.valueOf(i2), a0Var2);
        } else {
            a0Var.f58364b = s0Var;
        }
        r rVar = this.f58537a;
        if (rVar != null) {
            rVar.g1(s0Var);
        }
    }

    public final void f0(int i2, boolean z) {
        a0 a0Var = this.j.get(Integer.valueOf(i2));
        if (a0Var == null) {
            a0 a0Var2 = new a0();
            a0Var2.f58363a = i2;
            a0Var2.f58365c = z;
            this.j.put(Integer.valueOf(i2), a0Var2);
        } else {
            a0Var.f58365c = z;
        }
        r rVar = this.f58537a;
        if (rVar != null) {
            rVar.u1(z);
        }
    }

    public final void g0(int i2, boolean z) {
        r rVar = this.f58537a;
        if (rVar != null) {
            rVar.k1(i2, z);
        }
    }

    public final void h0(int i2) {
        a0 a0Var;
        if (this.f58537a == null || (a0Var = this.j.get(Integer.valueOf(i2))) == null) {
            return;
        }
        this.f58537a.Z0(i2);
        this.f58537a.g1(a0Var.f58364b);
        this.f58537a.u1(a0Var.f58365c);
        if (a0Var.f58364b == null) {
            this.f58537a.u1(false);
        }
    }
}

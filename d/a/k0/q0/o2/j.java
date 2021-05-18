package d.a.k0.q0.o2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import d.a.k0.q0.a0;
import d.a.k0.q0.r;
import d.a.k0.q0.s0;
import d.a.k0.q0.u;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class j extends d.a.k0.q0.e2.j {

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.q0.h2.a f59143h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59144i;
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
            j.this.f58397b.y2().J();
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
            if (customResponsedMessage == null || j.this.f58396a == null) {
                return;
            }
            j.this.f58396a.K1();
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
            j.this.f58396a.M1();
            a0 a0Var = (a0) customResponsedMessage.getData();
            s0 s0Var = a0Var.f58223b;
            if (s0Var != null) {
                j.this.e0(a0Var.f58222a, s0Var);
            } else {
                int i2 = a0Var.f58222a;
                if (i2 != 1) {
                    j.this.e0(i2, null);
                } else {
                    j jVar = j.this;
                    jVar.e0(i2, jVar.q);
                }
            }
            j.this.h0(a0Var.f58222a);
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
            j.this.f0(a0Var.f58222a, a0Var.f58224c);
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
            j.this.g0(uVar.f59520a, uVar.f59521b);
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
                if (j.this.f58396a.e0() == null || j.this.f58401f == null || j.this.f58396a.e0().getVisibility() == 0) {
                    return;
                }
                j.this.f58401f.o();
            }
        }

        public f() {
        }

        @Override // d.a.k0.q0.s0
        public void k() {
            if (j.this.f58397b == null || !j.this.f58397b.isAdded()) {
                return;
            }
            if (j.this.f59144i && j.this.f58397b.y2() != null) {
                if (!j.this.k && !j.this.c0()) {
                    j.this.f58397b.y2().c0();
                }
                j.this.f59144i = false;
            }
            if (j.this.f59143h != null && j.this.f58397b.y0() != null && j.this.f58397b.y0().W() != null && !j.this.f58397b.y0().W().o() && j.this.f58397b.y2() != null && !j.this.f58397b.y2().T()) {
                j.this.f59143h.b();
            }
            if (j.this.f58396a == null || j.this.f58401f == null || j.this.f58399d == null || j.this.f59143h == null) {
                return;
            }
            j.this.f58396a.g0().n(0, 0, true, true);
            j.this.f58397b.a3();
            j.this.f58397b.m3(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (j.this.f58397b.y0() != null) {
                j.this.f58397b.y0().k1(1, false);
            }
            j.this.f58399d.v0();
            if (!TbadkCoreApplication.isLogin() || j.this.f58397b.u2().getVisibility() != 0 || ListUtils.isEmpty(j.this.f58397b.g0().getThreadList())) {
            }
        }

        @Override // d.a.k0.q0.s0
        public void m() {
            j.this.f59144i = true;
            if (j.this.f58396a == null || j.this.f58401f == null || j.this.f58399d == null || j.this.f58397b == null || !j.this.f58397b.isAdded()) {
                return;
            }
            if (j.this.f58396a != null && j.this.f58396a.g0() != null) {
                j.this.f58396a.g0().w();
            }
            j.this.f58397b.m3(false);
            d.a.c.e.m.e.a().postDelayed(new a(), 110L);
            j.this.f58396a.k1(1, true);
            if (d.a.c.e.p.j.z()) {
                j.this.f58397b.refresh();
                j.this.f58397b.m3(true);
            } else {
                j.this.f58397b.C3();
            }
            TiebaStatic.log(new StatisticItem("c11749").param("fid", j.this.f58397b.F()).param("obj_locate", "1"));
        }
    }

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.f59144i = false;
        this.k = false;
        this.l = new a(2921468);
        this.m = new b(2003003);
        this.n = new c(2921448);
        this.o = new d(9205410);
        this.p = new e(2921449);
        this.q = new f();
        this.f59143h = frsFragment.s2();
        this.j = new HashMap<>();
        this.f58396a.Z0(1);
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
        if (this.f58397b.g0() == null || this.f58397b.g0().getUserData() == null || this.f58397b.g0().forumRule == null || this.f58397b.g0().getForum() == null || !this.f58397b.g0().getForum().getIsShowRule()) {
            return false;
        }
        return this.f58397b.g0().getUserData().getIs_manager() == 1 ? this.f58397b.g0().forumRule.has_forum_rule.intValue() != 1 && this.f58397b.g0().forumRule.audit_status.intValue() == 0 && d.a.j0.r.d0.b.j().k("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.f58397b.g0().forumRule.has_forum_rule.intValue() == 1 && d.a.j0.r.d0.b.j().k("key_forum_rule_first_show_frs", 0) <= 0;
    }

    public void d0() {
        if (this.f58396a == null) {
            return;
        }
        n nVar = this.f58398c;
        if ((nVar instanceof FrsTabViewController) && ((FrsTabViewController) nVar).y() != null && (((FrsTabViewController) this.f58398c).y().f15858b instanceof s0)) {
            FrsTabViewController.o y = ((FrsTabViewController) this.f58398c).y();
            e0(y.f15857a, (s0) y.f15858b);
            h0(y.f15857a);
            return;
        }
        this.f58396a.g1(this.q);
    }

    public final void e0(int i2, s0 s0Var) {
        a0 a0Var = this.j.get(Integer.valueOf(i2));
        if (a0Var == null) {
            a0 a0Var2 = new a0();
            a0Var2.f58222a = i2;
            a0Var2.f58223b = s0Var;
            this.j.put(Integer.valueOf(i2), a0Var2);
        } else {
            a0Var.f58223b = s0Var;
        }
        r rVar = this.f58396a;
        if (rVar != null) {
            rVar.g1(s0Var);
        }
    }

    public final void f0(int i2, boolean z) {
        a0 a0Var = this.j.get(Integer.valueOf(i2));
        if (a0Var == null) {
            a0 a0Var2 = new a0();
            a0Var2.f58222a = i2;
            a0Var2.f58224c = z;
            this.j.put(Integer.valueOf(i2), a0Var2);
        } else {
            a0Var.f58224c = z;
        }
        r rVar = this.f58396a;
        if (rVar != null) {
            rVar.u1(z);
        }
    }

    public final void g0(int i2, boolean z) {
        r rVar = this.f58396a;
        if (rVar != null) {
            rVar.k1(i2, z);
        }
    }

    public final void h0(int i2) {
        a0 a0Var;
        if (this.f58396a == null || (a0Var = this.j.get(Integer.valueOf(i2))) == null) {
            return;
        }
        this.f58396a.Z0(i2);
        this.f58396a.g1(a0Var.f58223b);
        this.f58396a.u1(a0Var.f58224c);
        if (a0Var.f58223b == null) {
            this.f58396a.u1(false);
        }
    }
}

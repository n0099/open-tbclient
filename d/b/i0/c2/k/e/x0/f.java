package d.b.i0.c2.k.e.x0;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f52924a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.c2.n.g f52925b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.c2.n.f f52926c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52927d = false;

    public f(PbFragment pbFragment) {
        this.f52924a = pbFragment;
    }

    public void a() {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            gVar.O();
        }
    }

    public void b() {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            gVar.f0();
        }
    }

    public View c() {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            return gVar.P();
        }
        return null;
    }

    public int d() {
        View c2 = c();
        if (c2 != null) {
            return c2.getHeight();
        }
        return 0;
    }

    public int e() {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            return gVar.Q();
        }
        return 0;
    }

    public boolean f() {
        d.b.i0.c2.n.g gVar = this.f52925b;
        return gVar != null && gVar.X();
    }

    public boolean g() {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            return gVar.Z();
        }
        return false;
    }

    public void h(int i) {
        d.b.i0.c2.n.f fVar = this.f52926c;
        if (fVar != null) {
            fVar.c(i);
        }
    }

    public void i(int i) {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            gVar.c0(i);
        }
    }

    public void j(Configuration configuration) {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            gVar.d0(configuration);
        }
    }

    public boolean k(int i) {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            return gVar.e0(i);
        }
        return false;
    }

    public void l() {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            gVar.f0();
        }
    }

    public void m() {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            gVar.g0();
        }
    }

    public void n(AbsListView absListView, int i, int i2, int i3) {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            gVar.h0(absListView, i);
        }
    }

    public void o(AbsListView absListView, int i) {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            gVar.i0(absListView, i);
        }
    }

    public void p(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            d.b.i0.c2.n.g gVar = this.f52925b;
            if (gVar != null) {
                bdTypeListView.removeHeaderView(gVar.R());
            }
            d.b.i0.c2.n.f fVar = this.f52926c;
            if (fVar != null) {
                fVar.e(bdTypeListView);
            }
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView == null) {
            return;
        }
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar == null || gVar.P() == null) {
            d.b.i0.c2.n.g gVar2 = this.f52925b;
            if (gVar2 != null) {
                pbLandscapeListView.removeHeaderView(gVar2.R());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.x(textView, 0);
                return;
            }
            return;
        }
        if (textView != null) {
            pbLandscapeListView.removeHeaderView(textView);
            pbLandscapeListView.setTextViewAdded(false);
        }
        if (i != 1) {
            pbLandscapeListView.removeHeaderView(this.f52925b.R());
            pbLandscapeListView.x(this.f52925b.R(), 0);
        }
    }

    public void r(boolean z) {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            gVar.o0(z);
        }
    }

    public void s(boolean z) {
        this.f52927d = z;
    }

    public void t(View.OnClickListener onClickListener) {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            gVar.s0(onClickListener);
        }
    }

    public void u() {
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar != null) {
            gVar.t0();
        }
    }

    public void v(BdTypeListView bdTypeListView) {
        if (this.f52925b != null) {
            TiebaStatic.log(new StatisticItem("c11997").param("obj_type", 1));
            this.f52925b.t0();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public void w(d.b.i0.c2.h.e eVar, PostData postData, BdTypeListView bdTypeListView, e eVar2, FrameLayout frameLayout, d.b.i0.c2.k.e.c1.c cVar, String str, long j) {
        if (eVar == null || !eVar.e0()) {
            return;
        }
        d.b.i0.c2.n.g gVar = this.f52925b;
        if (gVar == null) {
            d.b.i0.c2.n.g gVar2 = new d.b.i0.c2.n.g(this.f52924a, cVar, eVar.L().u1(), j);
            this.f52925b = gVar2;
            gVar2.U(eVar.L().u1(), eVar.L(), eVar.m());
            this.f52925b.w0();
        } else if (this.f52927d) {
            gVar.U(eVar.L().u1(), eVar.L(), eVar.m());
            this.f52925b.w0();
        } else {
            gVar.x0(eVar.m());
        }
        d.b.i0.c2.m.a.d(this.f52924a.getUniqueId(), eVar, postData, 1, 1);
        if (eVar.H() != null && eVar.H().size() >= 1) {
            a2 a2Var = eVar.H().get(0);
            this.f52925b.q0(a2Var);
            this.f52925b.r0(a2Var.x1());
        }
        this.f52925b.k0(postData, eVar.L(), eVar.O());
        this.f52927d = false;
        bdTypeListView.removeHeaderView(this.f52925b.R());
        bdTypeListView.x(this.f52925b.R(), 0);
        if (this.f52925b.P() != null && this.f52925b.P().getParent() == null) {
            frameLayout.addView(this.f52925b.P());
        }
        if (this.f52926c == null) {
            this.f52926c = new d.b.i0.c2.n.f(this.f52924a.getBaseFragmentActivity());
        }
        this.f52926c.d(eVar, str);
        bdTypeListView.removeHeaderView(this.f52926c.b());
        bdTypeListView.x(this.f52926c.b(), 1);
        eVar2.s(bdTypeListView);
        eVar2.h(bdTypeListView, 2);
        if (this.f52925b != null) {
            cVar.y(false);
            this.f52925b.c0(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}

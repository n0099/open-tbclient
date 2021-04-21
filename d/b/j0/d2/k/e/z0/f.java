package d.b.j0.d2.k.e.z0;

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
import d.b.i0.r.q.a2;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f54841a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.d2.n.g f54842b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.d2.n.f f54843c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54844d = false;

    public f(PbFragment pbFragment) {
        this.f54841a = pbFragment;
    }

    public void a() {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            gVar.O();
        }
    }

    public void b() {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            gVar.f0();
        }
    }

    public View c() {
        d.b.j0.d2.n.g gVar = this.f54842b;
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
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            return gVar.Q();
        }
        return 0;
    }

    public boolean f() {
        d.b.j0.d2.n.g gVar = this.f54842b;
        return gVar != null && gVar.X();
    }

    public boolean g() {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            return gVar.Z();
        }
        return false;
    }

    public void h(int i) {
        d.b.j0.d2.n.f fVar = this.f54843c;
        if (fVar != null) {
            fVar.c(i);
        }
    }

    public void i(int i) {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            gVar.c0(i);
        }
    }

    public void j(Configuration configuration) {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            gVar.d0(configuration);
        }
    }

    public boolean k(int i) {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            return gVar.e0(i);
        }
        return false;
    }

    public void l() {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            gVar.f0();
        }
    }

    public void m() {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            gVar.g0();
        }
    }

    public void n(AbsListView absListView, int i, int i2, int i3) {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            gVar.h0(absListView, i);
        }
    }

    public void o(AbsListView absListView, int i) {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            gVar.i0(absListView, i);
        }
    }

    public void p(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            d.b.j0.d2.n.g gVar = this.f54842b;
            if (gVar != null) {
                bdTypeListView.removeHeaderView(gVar.R());
            }
            d.b.j0.d2.n.f fVar = this.f54843c;
            if (fVar != null) {
                fVar.e(bdTypeListView);
            }
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView == null) {
            return;
        }
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar == null || gVar.P() == null) {
            d.b.j0.d2.n.g gVar2 = this.f54842b;
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
            pbLandscapeListView.removeHeaderView(this.f54842b.R());
            pbLandscapeListView.x(this.f54842b.R(), 0);
        }
    }

    public void r(boolean z) {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            gVar.o0(z);
        }
    }

    public void s(boolean z) {
        this.f54844d = z;
    }

    public void t(View.OnClickListener onClickListener) {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            gVar.s0(onClickListener);
        }
    }

    public void u() {
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar != null) {
            gVar.t0();
        }
    }

    public void v(BdTypeListView bdTypeListView) {
        if (this.f54842b != null) {
            TiebaStatic.log(new StatisticItem("c11997").param("obj_type", 1));
            this.f54842b.t0();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public void w(d.b.j0.d2.h.e eVar, PostData postData, BdTypeListView bdTypeListView, e eVar2, FrameLayout frameLayout, d.b.j0.d2.k.e.e1.c cVar, String str, long j) {
        if (eVar == null || !eVar.f0()) {
            return;
        }
        d.b.j0.d2.n.g gVar = this.f54842b;
        if (gVar == null) {
            d.b.j0.d2.n.g gVar2 = new d.b.j0.d2.n.g(this.f54841a, cVar, eVar.L().u1(), j);
            this.f54842b = gVar2;
            gVar2.U(eVar.L().u1(), eVar.L(), eVar.m());
            this.f54842b.w0();
        } else if (this.f54844d) {
            gVar.U(eVar.L().u1(), eVar.L(), eVar.m());
            this.f54842b.w0();
        } else {
            gVar.x0(eVar.m());
        }
        d.b.j0.d2.m.a.d(this.f54841a.getUniqueId(), eVar, postData, 1, 1);
        if (eVar.H() != null && eVar.H().size() >= 1) {
            a2 a2Var = eVar.H().get(0);
            this.f54842b.q0(a2Var);
            this.f54842b.r0(a2Var.x1());
        }
        this.f54842b.k0(postData, eVar.L(), eVar.P());
        this.f54844d = false;
        bdTypeListView.removeHeaderView(this.f54842b.R());
        bdTypeListView.x(this.f54842b.R(), 0);
        if (this.f54842b.P() != null && this.f54842b.P().getParent() == null) {
            frameLayout.addView(this.f54842b.P());
        }
        if (this.f54843c == null) {
            this.f54843c = new d.b.j0.d2.n.f(this.f54841a.getBaseFragmentActivity());
        }
        this.f54843c.d(eVar, str);
        bdTypeListView.removeHeaderView(this.f54843c.b());
        bdTypeListView.x(this.f54843c.b(), 1);
        eVar2.s(bdTypeListView);
        eVar2.h(bdTypeListView, 2);
        if (this.f54842b != null) {
            cVar.y(false);
            this.f54842b.c0(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}

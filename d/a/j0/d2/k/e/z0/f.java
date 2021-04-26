package d.a.j0.d2.k.e.z0;

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
import d.a.i0.r.q.a2;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f52658a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.d2.n.g f52659b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.d2.n.f f52660c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52661d = false;

    public f(PbFragment pbFragment) {
        this.f52658a = pbFragment;
    }

    public void a() {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            gVar.O();
        }
    }

    public void b() {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            gVar.f0();
        }
    }

    public View c() {
        d.a.j0.d2.n.g gVar = this.f52659b;
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
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            return gVar.Q();
        }
        return 0;
    }

    public boolean f() {
        d.a.j0.d2.n.g gVar = this.f52659b;
        return gVar != null && gVar.X();
    }

    public boolean g() {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            return gVar.Z();
        }
        return false;
    }

    public void h(int i2) {
        d.a.j0.d2.n.f fVar = this.f52660c;
        if (fVar != null) {
            fVar.c(i2);
        }
    }

    public void i(int i2) {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            gVar.c0(i2);
        }
    }

    public void j(Configuration configuration) {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            gVar.d0(configuration);
        }
    }

    public boolean k(int i2) {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            return gVar.e0(i2);
        }
        return false;
    }

    public void l() {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            gVar.f0();
        }
    }

    public void m() {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            gVar.g0();
        }
    }

    public void n(AbsListView absListView, int i2, int i3, int i4) {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            gVar.h0(absListView, i2);
        }
    }

    public void o(AbsListView absListView, int i2) {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            gVar.i0(absListView, i2);
        }
    }

    public void p(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            d.a.j0.d2.n.g gVar = this.f52659b;
            if (gVar != null) {
                bdTypeListView.removeHeaderView(gVar.R());
            }
            d.a.j0.d2.n.f fVar = this.f52660c;
            if (fVar != null) {
                fVar.e(bdTypeListView);
            }
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i2) {
        if (pbLandscapeListView == null) {
            return;
        }
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar == null || gVar.P() == null) {
            d.a.j0.d2.n.g gVar2 = this.f52659b;
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
        if (i2 != 1) {
            pbLandscapeListView.removeHeaderView(this.f52659b.R());
            pbLandscapeListView.x(this.f52659b.R(), 0);
        }
    }

    public void r(boolean z) {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            gVar.o0(z);
        }
    }

    public void s(boolean z) {
        this.f52661d = z;
    }

    public void t(View.OnClickListener onClickListener) {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            gVar.s0(onClickListener);
        }
    }

    public void u() {
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar != null) {
            gVar.t0();
        }
    }

    public void v(BdTypeListView bdTypeListView) {
        if (this.f52659b != null) {
            TiebaStatic.log(new StatisticItem("c11997").param("obj_type", 1));
            this.f52659b.t0();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public void w(d.a.j0.d2.h.e eVar, PostData postData, BdTypeListView bdTypeListView, e eVar2, FrameLayout frameLayout, d.a.j0.d2.k.e.e1.c cVar, String str, long j) {
        if (eVar == null || !eVar.f0()) {
            return;
        }
        d.a.j0.d2.n.g gVar = this.f52659b;
        if (gVar == null) {
            d.a.j0.d2.n.g gVar2 = new d.a.j0.d2.n.g(this.f52658a, cVar, eVar.L().u1(), j);
            this.f52659b = gVar2;
            gVar2.U(eVar.L().u1(), eVar.L(), eVar.m());
            this.f52659b.w0();
        } else if (this.f52661d) {
            gVar.U(eVar.L().u1(), eVar.L(), eVar.m());
            this.f52659b.w0();
        } else {
            gVar.x0(eVar.m());
        }
        d.a.j0.d2.m.a.d(this.f52658a.getUniqueId(), eVar, postData, 1, 1);
        if (eVar.H() != null && eVar.H().size() >= 1) {
            a2 a2Var = eVar.H().get(0);
            this.f52659b.q0(a2Var);
            this.f52659b.r0(a2Var.x1());
        }
        this.f52659b.k0(postData, eVar.L(), eVar.P());
        this.f52661d = false;
        bdTypeListView.removeHeaderView(this.f52659b.R());
        bdTypeListView.x(this.f52659b.R(), 0);
        if (this.f52659b.P() != null && this.f52659b.P().getParent() == null) {
            frameLayout.addView(this.f52659b.P());
        }
        if (this.f52660c == null) {
            this.f52660c = new d.a.j0.d2.n.f(this.f52658a.getBaseFragmentActivity());
        }
        this.f52660c.d(eVar, str);
        bdTypeListView.removeHeaderView(this.f52660c.b());
        bdTypeListView.x(this.f52660c.b(), 1);
        eVar2.s(bdTypeListView);
        eVar2.h(bdTypeListView, 2);
        if (this.f52659b != null) {
            cVar.y(false);
            this.f52659b.c0(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}

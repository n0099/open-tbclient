package d.a.o0.e2.k.e.a1;

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
import d.a.n0.r.q.a2;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f56936a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.e2.n.g f56937b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.e2.n.f f56938c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56939d = false;

    public f(PbFragment pbFragment) {
        this.f56936a = pbFragment;
    }

    public void a() {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            gVar.O();
        }
    }

    public void b() {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            gVar.f0();
        }
    }

    public View c() {
        d.a.o0.e2.n.g gVar = this.f56937b;
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
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            return gVar.Q();
        }
        return 0;
    }

    public boolean f() {
        d.a.o0.e2.n.g gVar = this.f56937b;
        return gVar != null && gVar.X();
    }

    public boolean g() {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            return gVar.Z();
        }
        return false;
    }

    public void h(int i2) {
        d.a.o0.e2.n.f fVar = this.f56938c;
        if (fVar != null) {
            fVar.c(i2);
        }
    }

    public void i(int i2) {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            gVar.c0(i2);
        }
    }

    public void j(Configuration configuration) {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            gVar.d0(configuration);
        }
    }

    public boolean k(int i2) {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            return gVar.e0(i2);
        }
        return false;
    }

    public void l() {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            gVar.f0();
        }
    }

    public void m() {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            gVar.g0();
        }
    }

    public void n(AbsListView absListView, int i2, int i3, int i4) {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            gVar.h0(absListView, i2);
        }
    }

    public void o(AbsListView absListView, int i2) {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            gVar.i0(absListView, i2);
        }
    }

    public void p(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            d.a.o0.e2.n.g gVar = this.f56937b;
            if (gVar != null) {
                bdTypeListView.removeHeaderView(gVar.R());
            }
            d.a.o0.e2.n.f fVar = this.f56938c;
            if (fVar != null) {
                fVar.e(bdTypeListView);
            }
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i2) {
        if (pbLandscapeListView == null) {
            return;
        }
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar == null || gVar.P() == null) {
            d.a.o0.e2.n.g gVar2 = this.f56937b;
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
            pbLandscapeListView.removeHeaderView(this.f56937b.R());
            pbLandscapeListView.x(this.f56937b.R(), 0);
        }
    }

    public void r(boolean z) {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            gVar.o0(z);
        }
    }

    public void s(boolean z) {
        this.f56939d = z;
    }

    public void t(View.OnClickListener onClickListener) {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            gVar.s0(onClickListener);
        }
    }

    public void u() {
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar != null) {
            gVar.t0();
        }
    }

    public void v(BdTypeListView bdTypeListView) {
        if (this.f56937b != null) {
            TiebaStatic.log(new StatisticItem("c11997").param("obj_type", 1));
            this.f56937b.t0();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public void w(d.a.o0.e2.h.e eVar, PostData postData, BdTypeListView bdTypeListView, e eVar2, FrameLayout frameLayout, d.a.o0.e2.k.e.f1.c cVar, String str, long j) {
        if (eVar == null || !eVar.f0()) {
            return;
        }
        d.a.o0.e2.n.g gVar = this.f56937b;
        if (gVar == null) {
            d.a.o0.e2.n.g gVar2 = new d.a.o0.e2.n.g(this.f56936a, cVar, eVar.L().x1(), j);
            this.f56937b = gVar2;
            gVar2.U(eVar.L().x1(), eVar.L(), eVar.m());
            this.f56937b.w0();
        } else if (this.f56939d) {
            gVar.U(eVar.L().x1(), eVar.L(), eVar.m());
            this.f56937b.w0();
        } else {
            gVar.x0(eVar.m());
        }
        d.a.o0.e2.m.a.d(this.f56936a.getUniqueId(), eVar, postData, 1, 1);
        if (eVar.H() != null && eVar.H().size() >= 1) {
            a2 a2Var = eVar.H().get(0);
            this.f56937b.q0(a2Var);
            this.f56937b.r0(a2Var.A1());
        }
        this.f56937b.k0(postData, eVar.L(), eVar.P());
        this.f56939d = false;
        bdTypeListView.removeHeaderView(this.f56937b.R());
        bdTypeListView.x(this.f56937b.R(), 0);
        if (this.f56937b.P() != null && this.f56937b.P().getParent() == null) {
            frameLayout.addView(this.f56937b.P());
        }
        if (this.f56938c == null) {
            this.f56938c = new d.a.o0.e2.n.f(this.f56936a.getBaseFragmentActivity());
        }
        this.f56938c.d(eVar, str);
        bdTypeListView.removeHeaderView(this.f56938c.b());
        bdTypeListView.x(this.f56938c.b(), 1);
        eVar2.s(bdTypeListView);
        eVar2.h(bdTypeListView, 2);
        if (this.f56937b != null) {
            cVar.y(false);
            this.f56937b.c0(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}

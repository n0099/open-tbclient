package d.b.i0.u3.n;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.EditorInfoContainer;
import d.b.b.e.p.l;
import d.b.h0.w.m;
import d.b.h0.w.n;
import d.b.i0.b0.e;
/* loaded from: classes5.dex */
public class b extends m {
    public Context q;

    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.m = false;
        this.q = context;
        this.l = 3;
        this.k = new EditorInfoContainer(context, str);
        this.n = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void g() {
        n nVar = this.k;
        if (nVar instanceof EditorInfoContainer) {
            ((EditorInfoContainer) nVar).hide();
        }
    }

    public void h() {
        n nVar = this.k;
        if (nVar instanceof EditorInfoContainer) {
            ((EditorInfoContainer) nVar).l();
        }
    }

    public void i() {
        n nVar = this.k;
        if (nVar instanceof EditorInfoContainer) {
            ((EditorInfoContainer) nVar).m();
        }
    }

    public void j(String str, int i) {
        n nVar = this.k;
        if (nVar instanceof EditorInfoContainer) {
            ((EditorInfoContainer) nVar).q(str, i);
        }
    }

    public void k(int i) {
        n nVar = this.k;
        if (nVar instanceof EditorInfoContainer) {
            ((EditorInfoContainer) nVar).r(i);
        }
    }

    public void l(boolean z) {
        n nVar = this.k;
        if (nVar instanceof EditorInfoContainer) {
            ((EditorInfoContainer) nVar).s(z);
        }
    }

    public void m(String str) {
        n nVar = this.k;
        if (nVar instanceof EditorInfoContainer) {
            ((EditorInfoContainer) nVar).setFrom(str);
        }
    }

    public void n(boolean z) {
        n nVar = this.k;
        if (nVar instanceof EditorInfoContainer) {
            ((EditorInfoContainer) nVar).v(z);
        }
    }

    public void o() {
        BaseActivity baseActivity = (BaseActivity) this.q;
        e eVar = new e(baseActivity.getPageContext(), (View) this.k);
        eVar.c0(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.N(16);
        eVar.T(true);
        eVar.K(2);
        eVar.d0(true);
        eVar.f0(l.g(baseActivity, R.dimen.ds32));
        eVar.a0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.Z(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.M((int) 3000);
        eVar.U(false);
        if (eVar.j0(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.k).u(3000L);
        }
    }
}

package d.a.o0.w3.m;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.EditorInfoContainer;
import d.a.c.e.p.l;
import d.a.n0.w.m;
import d.a.n0.w.n;
import d.a.o0.d0.e;
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

    public void j(String str, int i2) {
        n nVar = this.k;
        if (nVar instanceof EditorInfoContainer) {
            ((EditorInfoContainer) nVar).q(str, i2);
        }
    }

    public void k(int i2) {
        n nVar = this.k;
        if (nVar instanceof EditorInfoContainer) {
            ((EditorInfoContainer) nVar).r(i2);
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
        eVar.g0(R.drawable.bg_tip_blue_left_less_than_right_down);
        eVar.O(16);
        eVar.U(true);
        eVar.L(2);
        eVar.h0(true);
        eVar.j0(l.g(baseActivity, R.dimen.ds32));
        eVar.d0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.a0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.N((int) 3000);
        eVar.V(false);
        if (eVar.n0(baseActivity.getString(R.string.write_location_topic_hint_title), "write_hint_tip_key", true)) {
            ((EditorInfoContainer) this.k).u(3000L);
        }
    }
}

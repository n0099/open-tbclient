package d.a.k0.d2.k.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.j0.r.q.a2;
/* loaded from: classes5.dex */
public class h extends t0 {

    /* renamed from: c  reason: collision with root package name */
    public TextView f53089c;

    public h(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.f53089c = null;
    }

    @Override // d.a.k0.d2.k.e.t0
    public void c(g gVar) {
        TextView textView = (TextView) this.f53252b.findViewById(R.id.icon_push);
        this.f53089c = textView;
        textView.setVisibility(8);
    }

    public TextView e() {
        return this.f53089c;
    }

    public void f(a2 a2Var) {
        if (a2Var == null || a2Var.S0() == null) {
            return;
        }
        int status = a2Var.S0().getStatus();
        if (status == 1) {
            g(true);
        } else if (status == 2) {
            g(false);
        }
    }

    public void g(boolean z) {
        TextView textView = this.f53089c;
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setText(R.string.push);
            SkinManager.setViewTextColor(this.f53089c, R.drawable.push_text_selector);
            SkinManager.setBackgroundResource(this.f53089c, R.drawable.push_bg_selector);
            this.f53089c.setClickable(true);
        } else {
            textView.setText(R.string.already_push);
            SkinManager.setBackgroundResource(this.f53089c, R.drawable.label_bg_gray80);
            SkinManager.setViewTextColor(this.f53089c, R.color.CAM_X0109);
            this.f53089c.setClickable(false);
        }
        this.f53089c.setVisibility(0);
    }
}

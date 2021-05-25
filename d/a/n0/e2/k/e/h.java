package d.a.n0.e2.k.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.m0.r.q.a2;
/* loaded from: classes5.dex */
public class h extends u0 {

    /* renamed from: c  reason: collision with root package name */
    public TextView f53345c;

    public h(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.f53345c = null;
    }

    @Override // d.a.n0.e2.k.e.u0
    public void c(g gVar) {
        TextView textView = (TextView) this.f53517b.findViewById(R.id.icon_push);
        this.f53345c = textView;
        textView.setVisibility(8);
    }

    public TextView e() {
        return this.f53345c;
    }

    public void f(a2 a2Var) {
        if (a2Var == null || a2Var.T0() == null) {
            return;
        }
        int status = a2Var.T0().getStatus();
        if (status == 1) {
            g(true);
        } else if (status == 2) {
            g(false);
        }
    }

    public void g(boolean z) {
        TextView textView = this.f53345c;
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setText(R.string.push);
            SkinManager.setViewTextColor(this.f53345c, R.drawable.push_text_selector);
            SkinManager.setBackgroundResource(this.f53345c, R.drawable.push_bg_selector);
            this.f53345c.setClickable(true);
        } else {
            textView.setText(R.string.already_push);
            SkinManager.setBackgroundResource(this.f53345c, R.drawable.label_bg_gray80);
            SkinManager.setViewTextColor(this.f53345c, R.color.CAM_X0109);
            this.f53345c.setClickable(false);
        }
        this.f53345c.setVisibility(0);
    }
}

package d.b.i0.d2.k.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
/* loaded from: classes3.dex */
public class h extends t0 {

    /* renamed from: c  reason: collision with root package name */
    public TextView f54162c;

    public h(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.f54162c = null;
    }

    @Override // d.b.i0.d2.k.e.t0
    public void c(g gVar) {
        TextView textView = (TextView) this.f54316b.findViewById(R.id.icon_push);
        this.f54162c = textView;
        textView.setVisibility(8);
    }

    public TextView e() {
        return this.f54162c;
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
        TextView textView = this.f54162c;
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setText(R.string.push);
            SkinManager.setViewTextColor(this.f54162c, R.drawable.push_text_selector);
            SkinManager.setBackgroundResource(this.f54162c, R.drawable.push_bg_selector);
            this.f54162c.setClickable(true);
        } else {
            textView.setText(R.string.already_push);
            SkinManager.setBackgroundResource(this.f54162c, R.drawable.label_bg_gray80);
            SkinManager.setViewTextColor(this.f54162c, R.color.CAM_X0109);
            this.f54162c.setClickable(false);
        }
        this.f54162c.setVisibility(0);
    }
}

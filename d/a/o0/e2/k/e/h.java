package d.a.o0.e2.k.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.n0.r.q.a2;
/* loaded from: classes5.dex */
public class h extends u0 {

    /* renamed from: c  reason: collision with root package name */
    public TextView f57159c;

    public h(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.f57159c = null;
    }

    @Override // d.a.o0.e2.k.e.u0
    public void c(g gVar) {
        TextView textView = (TextView) this.f57331b.findViewById(R.id.icon_push);
        this.f57159c = textView;
        textView.setVisibility(8);
    }

    public TextView e() {
        return this.f57159c;
    }

    public void f(a2 a2Var) {
        if (a2Var == null || a2Var.U0() == null) {
            return;
        }
        int status = a2Var.U0().getStatus();
        if (status == 1) {
            g(true);
        } else if (status == 2) {
            g(false);
        }
    }

    public void g(boolean z) {
        TextView textView = this.f57159c;
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setText(R.string.push);
            SkinManager.setViewTextColor(this.f57159c, R.drawable.push_text_selector);
            SkinManager.setBackgroundResource(this.f57159c, R.drawable.push_bg_selector);
            this.f57159c.setClickable(true);
        } else {
            textView.setText(R.string.already_push);
            SkinManager.setBackgroundResource(this.f57159c, R.drawable.label_bg_gray80);
            SkinManager.setViewTextColor(this.f57159c, R.color.CAM_X0109);
            this.f57159c.setClickable(false);
        }
        this.f57159c.setVisibility(0);
    }
}

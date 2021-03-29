package d.b.i0.c2.k.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class f extends r0 {

    /* renamed from: c  reason: collision with root package name */
    public TextView f52677c;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.f52677c = null;
    }

    @Override // d.b.i0.c2.k.e.r0
    public void c(e eVar) {
        TextView textView = (TextView) this.f52821b.findViewById(R.id.icon_push);
        this.f52677c = textView;
        textView.setVisibility(8);
    }

    public TextView e() {
        return this.f52677c;
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
        TextView textView = this.f52677c;
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setText(R.string.push);
            SkinManager.setViewTextColor(this.f52677c, R.drawable.push_text_selector);
            SkinManager.setBackgroundResource(this.f52677c, R.drawable.push_bg_selector);
            this.f52677c.setClickable(true);
        } else {
            textView.setText(R.string.already_push);
            SkinManager.setBackgroundResource(this.f52677c, R.drawable.label_bg_gray80);
            SkinManager.setViewTextColor(this.f52677c, R.color.CAM_X0109);
            this.f52677c.setClickable(false);
        }
        this.f52677c.setVisibility(0);
    }
}

package d.b.h0.r.s;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.CircleView1080;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends AlertDialog {

    /* renamed from: e  reason: collision with root package name */
    public String f50980e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f50981f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50982g;

    /* renamed from: h  reason: collision with root package name */
    public CircleView1080 f50983h;
    public int i;

    public c(Context context) {
        super(context);
    }

    public void a(String str) {
        this.f50980e = str;
        TextView textView = this.f50982g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void b(int i) {
        if (i == this.i) {
            return;
        }
        this.i = i;
        TextView textView = this.f50981f;
        if (textView != null) {
            textView.setText(i + "%");
        }
        CircleView1080 circleView1080 = this.f50983h;
        if (circleView1080 != null) {
            circleView1080.setProgress(i);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(R.layout.progress_dialog_1080);
            View findViewById = findViewById(R.id.frame_progress_dialog);
            if (findViewById.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.topMargin = d.b.b.e.p.l.g(getContext(), R.dimen.tbds50);
                findViewById.setLayoutParams(layoutParams);
            }
            TextView textView = (TextView) window.findViewById(R.id.text_progress_dialog_message);
            this.f50982g = textView;
            if (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f50982g.getLayoutParams();
                layoutParams2.topMargin = d.b.b.e.p.l.g(getContext(), R.dimen.tbds35);
                this.f50982g.setLayoutParams(layoutParams2);
            }
            if (!StringUtils.isNull(this.f50980e)) {
                this.f50982g.setText(this.f50980e);
            }
            this.f50981f = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
            this.f50983h = (CircleView1080) window.findViewById(R.id.circle_progress_dialog);
        }
    }
}

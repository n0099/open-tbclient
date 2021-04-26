package d.a.i0.r.s;

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
    public String f49362e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f49363f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49364g;

    /* renamed from: h  reason: collision with root package name */
    public CircleView1080 f49365h;

    /* renamed from: i  reason: collision with root package name */
    public int f49366i;

    public c(Context context) {
        super(context);
    }

    public void a(String str) {
        this.f49362e = str;
        TextView textView = this.f49364g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void b(int i2) {
        if (i2 == this.f49366i) {
            return;
        }
        this.f49366i = i2;
        TextView textView = this.f49363f;
        if (textView != null) {
            textView.setText(i2 + "%");
        }
        CircleView1080 circleView1080 = this.f49365h;
        if (circleView1080 != null) {
            circleView1080.setProgress(i2);
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
                layoutParams.topMargin = d.a.c.e.p.l.g(getContext(), R.dimen.tbds50);
                findViewById.setLayoutParams(layoutParams);
            }
            TextView textView = (TextView) window.findViewById(R.id.text_progress_dialog_message);
            this.f49364g = textView;
            if (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f49364g.getLayoutParams();
                layoutParams2.topMargin = d.a.c.e.p.l.g(getContext(), R.dimen.tbds35);
                this.f49364g.setLayoutParams(layoutParams2);
            }
            if (!StringUtils.isNull(this.f49362e)) {
                this.f49364g.setText(this.f49362e);
            }
            this.f49363f = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
            this.f49365h = (CircleView1080) window.findViewById(R.id.circle_progress_dialog);
        }
    }
}

package d.a.j0.r.s;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.CircleView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d extends AlertDialog {

    /* renamed from: e  reason: collision with root package name */
    public String f50186e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f50187f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50188g;

    /* renamed from: h  reason: collision with root package name */
    public CircleView f50189h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f50190i;

    public d(Context context) {
        super(context);
    }

    public void a(String str) {
        this.f50186e = str;
        TextView textView = this.f50188g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void b(int i2) {
        TextView textView = this.f50187f;
        if (textView != null) {
            textView.setText(i2 + "%");
        }
        CircleView circleView = this.f50189h;
        if (circleView != null) {
            circleView.setProgress(i2);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(R.layout.post_video_progress_dialog);
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.frame_progress_dialog);
            this.f50190i = frameLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.f50190i.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(this.f50186e)) {
                TextView textView = (TextView) window.findViewById(R.id.text_progress_dialog_message);
                this.f50188g = textView;
                textView.setText(this.f50186e);
            }
            this.f50187f = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
            this.f50189h = (CircleView) window.findViewById(R.id.circle_progress_dialog);
        }
    }
}

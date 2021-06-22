package d.a.n0.r.s;

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
    public String f54013e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54014f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54015g;

    /* renamed from: h  reason: collision with root package name */
    public CircleView f54016h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f54017i;

    public d(Context context) {
        super(context);
    }

    public void a(String str) {
        this.f54013e = str;
        TextView textView = this.f54015g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void b(int i2) {
        TextView textView = this.f54014f;
        if (textView != null) {
            textView.setText(i2 + "%");
        }
        CircleView circleView = this.f54016h;
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
            this.f54017i = frameLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.f54017i.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(this.f54013e)) {
                TextView textView = (TextView) window.findViewById(R.id.text_progress_dialog_message);
                this.f54015g = textView;
                textView.setText(this.f54013e);
            }
            this.f54014f = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
            this.f54016h = (CircleView) window.findViewById(R.id.circle_progress_dialog);
        }
    }
}

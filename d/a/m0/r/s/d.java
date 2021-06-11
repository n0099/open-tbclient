package d.a.m0.r.s;

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
    public String f53906e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53907f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53908g;

    /* renamed from: h  reason: collision with root package name */
    public CircleView f53909h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f53910i;

    public d(Context context) {
        super(context);
    }

    public void a(String str) {
        this.f53906e = str;
        TextView textView = this.f53908g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void b(int i2) {
        TextView textView = this.f53907f;
        if (textView != null) {
            textView.setText(i2 + "%");
        }
        CircleView circleView = this.f53909h;
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
            this.f53910i = frameLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.f53910i.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(this.f53906e)) {
                TextView textView = (TextView) window.findViewById(R.id.text_progress_dialog_message);
                this.f53908g = textView;
                textView.setText(this.f53906e);
            }
            this.f53907f = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
            this.f53909h = (CircleView) window.findViewById(R.id.circle_progress_dialog);
        }
    }
}

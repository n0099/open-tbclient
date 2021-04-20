package d.b.h0.r.s;

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
    public String f51391e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f51392f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51393g;

    /* renamed from: h  reason: collision with root package name */
    public CircleView f51394h;
    public FrameLayout i;

    public d(Context context) {
        super(context);
    }

    public void a(String str) {
        this.f51391e = str;
        TextView textView = this.f51393g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void b(int i) {
        TextView textView = this.f51392f;
        if (textView != null) {
            textView.setText(i + "%");
        }
        CircleView circleView = this.f51394h;
        if (circleView != null) {
            circleView.setProgress(i);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(R.layout.post_video_progress_dialog);
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.frame_progress_dialog);
            this.i = frameLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.i.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(this.f51391e)) {
                TextView textView = (TextView) window.findViewById(R.id.text_progress_dialog_message);
                this.f51393g = textView;
                textView.setText(this.f51391e);
            }
            this.f51392f = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
            this.f51394h = (CircleView) window.findViewById(R.id.circle_progress_dialog);
        }
    }
}

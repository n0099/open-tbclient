package d.b.i0.r.s;

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
    public String f51727e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f51728f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51729g;

    /* renamed from: h  reason: collision with root package name */
    public CircleView f51730h;
    public FrameLayout i;

    public d(Context context) {
        super(context);
    }

    public void a(String str) {
        this.f51727e = str;
        TextView textView = this.f51729g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void b(int i) {
        TextView textView = this.f51728f;
        if (textView != null) {
            textView.setText(i + "%");
        }
        CircleView circleView = this.f51730h;
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
            if (!StringUtils.isNull(this.f51727e)) {
                TextView textView = (TextView) window.findViewById(R.id.text_progress_dialog_message);
                this.f51729g = textView;
                textView.setText(this.f51727e);
            }
            this.f51728f = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
            this.f51730h = (CircleView) window.findViewById(R.id.circle_progress_dialog);
        }
    }
}

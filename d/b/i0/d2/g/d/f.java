package d.b.i0.d2.g.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public View f53795a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f53796b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53797c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53798d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f53799e;

    public f(View view) {
        this.f53795a = view;
        this.f53796b = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.f53797c = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.f53798d = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.f53799e = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void a() {
        SkinManager.setBackgroundResource(this.f53795a, R.drawable.bg_rec_lick);
        SkinManager.setBackgroundResource(this.f53796b, R.drawable.bg_rec_comment);
        SkinManager.setViewTextColor(this.f53797c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(this.f53798d, R.color.CAM_X0110, 1);
        SkinManager.setImageResource(this.f53799e, R.drawable.recommend_pb_share_selector);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f53796b.setOnClickListener(onClickListener);
    }

    public void c(String str) {
        this.f53798d.setText(str);
    }

    public void d(View.OnClickListener onClickListener) {
        this.f53799e.setOnClickListener(onClickListener);
    }

    public void e(boolean z) {
        this.f53795a.setVisibility(z ? 0 : 8);
    }
}

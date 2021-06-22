package d.a.o0.e2.g.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public View f56713a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f56714b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56715c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56716d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f56717e;

    public f(View view) {
        this.f56713a = view;
        this.f56714b = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.f56715c = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.f56716d = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.f56717e = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void a() {
        SkinManager.setBackgroundResource(this.f56713a, R.drawable.bg_rec_lick);
        SkinManager.setBackgroundResource(this.f56714b, R.drawable.bg_rec_comment);
        SkinManager.setViewTextColor(this.f56715c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(this.f56716d, R.color.CAM_X0110, 1);
        SkinManager.setImageResource(this.f56717e, R.drawable.recommend_pb_share_selector);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f56714b.setOnClickListener(onClickListener);
    }

    public void c(String str) {
        this.f56716d.setText(str);
    }

    public void d(View.OnClickListener onClickListener) {
        this.f56717e.setOnClickListener(onClickListener);
    }

    public void e(boolean z) {
        this.f56713a.setVisibility(z ? 0 : 8);
    }
}

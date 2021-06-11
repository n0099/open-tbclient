package d.a.n0.e2.g.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public View f56588a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f56589b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56590c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56591d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f56592e;

    public f(View view) {
        this.f56588a = view;
        this.f56589b = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.f56590c = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.f56591d = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.f56592e = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void a() {
        SkinManager.setBackgroundResource(this.f56588a, R.drawable.bg_rec_lick);
        SkinManager.setBackgroundResource(this.f56589b, R.drawable.bg_rec_comment);
        SkinManager.setViewTextColor(this.f56590c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(this.f56591d, R.color.CAM_X0110, 1);
        SkinManager.setImageResource(this.f56592e, R.drawable.recommend_pb_share_selector);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f56589b.setOnClickListener(onClickListener);
    }

    public void c(String str) {
        this.f56591d.setText(str);
    }

    public void d(View.OnClickListener onClickListener) {
        this.f56592e.setOnClickListener(onClickListener);
    }

    public void e(boolean z) {
        this.f56588a.setVisibility(z ? 0 : 8);
    }
}

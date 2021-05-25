package d.a.n0.e2.g.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public View f52899a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f52900b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52901c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52902d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f52903e;

    public f(View view) {
        this.f52899a = view;
        this.f52900b = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.f52901c = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.f52902d = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.f52903e = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void a() {
        SkinManager.setBackgroundResource(this.f52899a, R.drawable.bg_rec_lick);
        SkinManager.setBackgroundResource(this.f52900b, R.drawable.bg_rec_comment);
        SkinManager.setViewTextColor(this.f52901c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(this.f52902d, R.color.CAM_X0110, 1);
        SkinManager.setImageResource(this.f52903e, R.drawable.recommend_pb_share_selector);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f52900b.setOnClickListener(onClickListener);
    }

    public void c(String str) {
        this.f52902d.setText(str);
    }

    public void d(View.OnClickListener onClickListener) {
        this.f52903e.setOnClickListener(onClickListener);
    }

    public void e(boolean z) {
        this.f52899a.setVisibility(z ? 0 : 8);
    }
}

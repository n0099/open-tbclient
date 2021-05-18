package d.a.k0.d2.g.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public View f52694a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f52695b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52696c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52697d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f52698e;

    public f(View view) {
        this.f52694a = view;
        this.f52695b = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.f52696c = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.f52697d = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.f52698e = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void a() {
        SkinManager.setBackgroundResource(this.f52694a, R.drawable.bg_rec_lick);
        SkinManager.setBackgroundResource(this.f52695b, R.drawable.bg_rec_comment);
        SkinManager.setViewTextColor(this.f52696c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(this.f52697d, R.color.CAM_X0110, 1);
        SkinManager.setImageResource(this.f52698e, R.drawable.recommend_pb_share_selector);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f52695b.setOnClickListener(onClickListener);
    }

    public void c(String str) {
        this.f52697d.setText(str);
    }

    public void d(View.OnClickListener onClickListener) {
        this.f52698e.setOnClickListener(onClickListener);
    }

    public void e(boolean z) {
        this.f52694a.setVisibility(z ? 0 : 8);
    }
}

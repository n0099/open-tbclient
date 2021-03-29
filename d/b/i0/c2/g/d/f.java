package d.b.i0.c2.g.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public View f52400a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f52401b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52402c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52403d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f52404e;

    public f(View view) {
        this.f52400a = view;
        this.f52401b = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.f52402c = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.f52403d = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.f52404e = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void a() {
        SkinManager.setBackgroundResource(this.f52400a, R.drawable.bg_rec_lick);
        SkinManager.setBackgroundResource(this.f52401b, R.drawable.bg_rec_comment);
        SkinManager.setViewTextColor(this.f52402c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(this.f52403d, R.color.CAM_X0110, 1);
        SkinManager.setImageResource(this.f52404e, R.drawable.recommend_pb_share_selector);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f52401b.setOnClickListener(onClickListener);
    }

    public void c(String str) {
        this.f52403d.setText(str);
    }

    public void d(View.OnClickListener onClickListener) {
        this.f52404e.setOnClickListener(onClickListener);
    }

    public void e(boolean z) {
        this.f52400a.setVisibility(z ? 0 : 8);
    }
}

package d.b.j0.d2.g.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public View f54216a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f54217b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54218c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54219d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f54220e;

    public f(View view) {
        this.f54216a = view;
        this.f54217b = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.f54218c = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.f54219d = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.f54220e = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void a() {
        SkinManager.setBackgroundResource(this.f54216a, R.drawable.bg_rec_lick);
        SkinManager.setBackgroundResource(this.f54217b, R.drawable.bg_rec_comment);
        SkinManager.setViewTextColor(this.f54218c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(this.f54219d, R.color.CAM_X0110, 1);
        SkinManager.setImageResource(this.f54220e, R.drawable.recommend_pb_share_selector);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f54217b.setOnClickListener(onClickListener);
    }

    public void c(String str) {
        this.f54219d.setText(str);
    }

    public void d(View.OnClickListener onClickListener) {
        this.f54220e.setOnClickListener(onClickListener);
    }

    public void e(boolean z) {
        this.f54216a.setVisibility(z ? 0 : 8);
    }
}

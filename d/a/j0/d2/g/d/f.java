package d.a.j0.d2.g.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public View f51995a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f51996b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f51997c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f51998d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f51999e;

    public f(View view) {
        this.f51995a = view;
        this.f51996b = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.f51997c = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.f51998d = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.f51999e = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void a() {
        SkinManager.setBackgroundResource(this.f51995a, R.drawable.bg_rec_lick);
        SkinManager.setBackgroundResource(this.f51996b, R.drawable.bg_rec_comment);
        SkinManager.setViewTextColor(this.f51997c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(this.f51998d, R.color.CAM_X0110, 1);
        SkinManager.setImageResource(this.f51999e, R.drawable.recommend_pb_share_selector);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f51996b.setOnClickListener(onClickListener);
    }

    public void c(String str) {
        this.f51998d.setText(str);
    }

    public void d(View.OnClickListener onClickListener) {
        this.f51999e.setOnClickListener(onClickListener);
    }

    public void e(boolean z) {
        this.f51995a.setVisibility(z ? 0 : 8);
    }
}

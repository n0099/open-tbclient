package d.a.n0.z1.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.q.h;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f67487a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f67488b;

    /* renamed from: c  reason: collision with root package name */
    public View f67489c;

    /* renamed from: d  reason: collision with root package name */
    public View f67490d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f67491e;

    public c(TbPageContext tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.f67490d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.emotion_manage_header_content);
        this.f67491e = linearLayout;
        linearLayout.setVisibility(8);
        this.f67487a = this.f67490d.findViewById(R.id.emotion_manage_item_header);
        this.f67488b = (TextView) this.f67490d.findViewById(R.id.emotion_manage_total_title);
        View findViewById = this.f67490d.findViewById(R.id.emotion_manage_edit_lable);
        this.f67489c = findViewById;
        findViewById.setVisibility(8);
    }

    public View a() {
        return this.f67490d;
    }

    public void b(int i2) {
        View view = this.f67487a;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i2);
        }
        LinearLayout linearLayout = this.f67491e;
        if (linearLayout != null) {
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0204, i2);
        }
        TextView textView = this.f67488b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i2);
            SkinManager.setBackgroundColor(this.f67488b, R.color.CAM_X0204, i2);
        }
        View view2 = this.f67489c;
        if (view2 != null) {
            SkinManager.setViewTextColor(view2, R.color.CAM_X0107, i2);
            SkinManager.setBackgroundColor(this.f67489c, R.color.CAM_X0204, i2);
        }
    }

    public void c() {
        if (d.a.n0.z1.h.a.b().a()) {
            this.f67489c.setVisibility(0);
        } else {
            this.f67489c.setVisibility(8);
        }
    }

    public void d(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.f67491e.setVisibility(8);
        } else {
            this.f67488b.setText(String.format(h.a(R.string.emotion_manage_local_number), num));
            this.f67491e.setVisibility(0);
        }
        if (d.a.n0.z1.h.a.b().a()) {
            this.f67489c.setVisibility(0);
        } else {
            this.f67489c.setVisibility(8);
        }
    }
}

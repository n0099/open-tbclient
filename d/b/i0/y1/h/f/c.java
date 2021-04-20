package d.b.i0.y1.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.q.h;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f64179a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f64180b;

    /* renamed from: c  reason: collision with root package name */
    public View f64181c;

    /* renamed from: d  reason: collision with root package name */
    public View f64182d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f64183e;

    public c(TbPageContext tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.f64182d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.emotion_manage_header_content);
        this.f64183e = linearLayout;
        linearLayout.setVisibility(8);
        this.f64179a = this.f64182d.findViewById(R.id.emotion_manage_item_header);
        this.f64180b = (TextView) this.f64182d.findViewById(R.id.emotion_manage_total_title);
        View findViewById = this.f64182d.findViewById(R.id.emotion_manage_edit_lable);
        this.f64181c = findViewById;
        findViewById.setVisibility(8);
    }

    public View a() {
        return this.f64182d;
    }

    public void b(int i) {
        View view = this.f64179a;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i);
        }
        LinearLayout linearLayout = this.f64183e;
        if (linearLayout != null) {
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0204, i);
        }
        TextView textView = this.f64180b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i);
            SkinManager.setBackgroundColor(this.f64180b, R.color.CAM_X0204, i);
        }
        View view2 = this.f64181c;
        if (view2 != null) {
            SkinManager.setViewTextColor(view2, R.color.CAM_X0107, i);
            SkinManager.setBackgroundColor(this.f64181c, R.color.CAM_X0204, i);
        }
    }

    public void c() {
        if (d.b.i0.y1.h.a.b().a()) {
            this.f64181c.setVisibility(0);
        } else {
            this.f64181c.setVisibility(8);
        }
    }

    public void d(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.f64183e.setVisibility(8);
        } else {
            this.f64180b.setText(String.format(h.a(R.string.emotion_manage_local_number), num));
            this.f64183e.setVisibility(0);
        }
        if (d.b.i0.y1.h.a.b().a()) {
            this.f64181c.setVisibility(0);
        } else {
            this.f64181c.setVisibility(8);
        }
    }
}

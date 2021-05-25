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
    public View f63769a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63770b;

    /* renamed from: c  reason: collision with root package name */
    public View f63771c;

    /* renamed from: d  reason: collision with root package name */
    public View f63772d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f63773e;

    public c(TbPageContext tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.f63772d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.emotion_manage_header_content);
        this.f63773e = linearLayout;
        linearLayout.setVisibility(8);
        this.f63769a = this.f63772d.findViewById(R.id.emotion_manage_item_header);
        this.f63770b = (TextView) this.f63772d.findViewById(R.id.emotion_manage_total_title);
        View findViewById = this.f63772d.findViewById(R.id.emotion_manage_edit_lable);
        this.f63771c = findViewById;
        findViewById.setVisibility(8);
    }

    public View a() {
        return this.f63772d;
    }

    public void b(int i2) {
        View view = this.f63769a;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i2);
        }
        LinearLayout linearLayout = this.f63773e;
        if (linearLayout != null) {
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0204, i2);
        }
        TextView textView = this.f63770b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i2);
            SkinManager.setBackgroundColor(this.f63770b, R.color.CAM_X0204, i2);
        }
        View view2 = this.f63771c;
        if (view2 != null) {
            SkinManager.setViewTextColor(view2, R.color.CAM_X0107, i2);
            SkinManager.setBackgroundColor(this.f63771c, R.color.CAM_X0204, i2);
        }
    }

    public void c() {
        if (d.a.n0.z1.h.a.b().a()) {
            this.f63771c.setVisibility(0);
        } else {
            this.f63771c.setVisibility(8);
        }
    }

    public void d(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.f63773e.setVisibility(8);
        } else {
            this.f63770b.setText(String.format(h.a(R.string.emotion_manage_local_number), num));
            this.f63773e.setVisibility(0);
        }
        if (d.a.n0.z1.h.a.b().a()) {
            this.f63771c.setVisibility(0);
        } else {
            this.f63771c.setVisibility(8);
        }
    }
}

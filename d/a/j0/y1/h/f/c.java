package d.a.j0.y1.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.q.h;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f62881a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62882b;

    /* renamed from: c  reason: collision with root package name */
    public View f62883c;

    /* renamed from: d  reason: collision with root package name */
    public View f62884d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f62885e;

    public c(TbPageContext tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.f62884d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.emotion_manage_header_content);
        this.f62885e = linearLayout;
        linearLayout.setVisibility(8);
        this.f62881a = this.f62884d.findViewById(R.id.emotion_manage_item_header);
        this.f62882b = (TextView) this.f62884d.findViewById(R.id.emotion_manage_total_title);
        View findViewById = this.f62884d.findViewById(R.id.emotion_manage_edit_lable);
        this.f62883c = findViewById;
        findViewById.setVisibility(8);
    }

    public View a() {
        return this.f62884d;
    }

    public void b(int i2) {
        View view = this.f62881a;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i2);
        }
        LinearLayout linearLayout = this.f62885e;
        if (linearLayout != null) {
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0204, i2);
        }
        TextView textView = this.f62882b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i2);
            SkinManager.setBackgroundColor(this.f62882b, R.color.CAM_X0204, i2);
        }
        View view2 = this.f62883c;
        if (view2 != null) {
            SkinManager.setViewTextColor(view2, R.color.CAM_X0107, i2);
            SkinManager.setBackgroundColor(this.f62883c, R.color.CAM_X0204, i2);
        }
    }

    public void c() {
        if (d.a.j0.y1.h.a.b().a()) {
            this.f62883c.setVisibility(0);
        } else {
            this.f62883c.setVisibility(8);
        }
    }

    public void d(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.f62885e.setVisibility(8);
        } else {
            this.f62882b.setText(String.format(h.a(R.string.emotion_manage_local_number), num));
            this.f62885e.setVisibility(0);
        }
        if (d.a.j0.y1.h.a.b().a()) {
            this.f62883c.setVisibility(0);
        } else {
            this.f62883c.setVisibility(8);
        }
    }
}

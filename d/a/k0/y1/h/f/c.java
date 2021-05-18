package d.a.k0.y1.h.f;

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
    public View f63605a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63606b;

    /* renamed from: c  reason: collision with root package name */
    public View f63607c;

    /* renamed from: d  reason: collision with root package name */
    public View f63608d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f63609e;

    public c(TbPageContext tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.f63608d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.emotion_manage_header_content);
        this.f63609e = linearLayout;
        linearLayout.setVisibility(8);
        this.f63605a = this.f63608d.findViewById(R.id.emotion_manage_item_header);
        this.f63606b = (TextView) this.f63608d.findViewById(R.id.emotion_manage_total_title);
        View findViewById = this.f63608d.findViewById(R.id.emotion_manage_edit_lable);
        this.f63607c = findViewById;
        findViewById.setVisibility(8);
    }

    public View a() {
        return this.f63608d;
    }

    public void b(int i2) {
        View view = this.f63605a;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i2);
        }
        LinearLayout linearLayout = this.f63609e;
        if (linearLayout != null) {
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0204, i2);
        }
        TextView textView = this.f63606b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i2);
            SkinManager.setBackgroundColor(this.f63606b, R.color.CAM_X0204, i2);
        }
        View view2 = this.f63607c;
        if (view2 != null) {
            SkinManager.setViewTextColor(view2, R.color.CAM_X0107, i2);
            SkinManager.setBackgroundColor(this.f63607c, R.color.CAM_X0204, i2);
        }
    }

    public void c() {
        if (d.a.k0.y1.h.a.b().a()) {
            this.f63607c.setVisibility(0);
        } else {
            this.f63607c.setVisibility(8);
        }
    }

    public void d(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.f63609e.setVisibility(8);
        } else {
            this.f63606b.setText(String.format(h.a(R.string.emotion_manage_local_number), num));
            this.f63609e.setVisibility(0);
        }
        if (d.a.k0.y1.h.a.b().a()) {
            this.f63607c.setVisibility(0);
        } else {
            this.f63607c.setVisibility(8);
        }
    }
}

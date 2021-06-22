package d.a.o0.z1.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.q.h;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f67612a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f67613b;

    /* renamed from: c  reason: collision with root package name */
    public View f67614c;

    /* renamed from: d  reason: collision with root package name */
    public View f67615d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f67616e;

    public c(TbPageContext tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.f67615d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.emotion_manage_header_content);
        this.f67616e = linearLayout;
        linearLayout.setVisibility(8);
        this.f67612a = this.f67615d.findViewById(R.id.emotion_manage_item_header);
        this.f67613b = (TextView) this.f67615d.findViewById(R.id.emotion_manage_total_title);
        View findViewById = this.f67615d.findViewById(R.id.emotion_manage_edit_lable);
        this.f67614c = findViewById;
        findViewById.setVisibility(8);
    }

    public View a() {
        return this.f67615d;
    }

    public void b(int i2) {
        View view = this.f67612a;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i2);
        }
        LinearLayout linearLayout = this.f67616e;
        if (linearLayout != null) {
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0204, i2);
        }
        TextView textView = this.f67613b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i2);
            SkinManager.setBackgroundColor(this.f67613b, R.color.CAM_X0204, i2);
        }
        View view2 = this.f67614c;
        if (view2 != null) {
            SkinManager.setViewTextColor(view2, R.color.CAM_X0107, i2);
            SkinManager.setBackgroundColor(this.f67614c, R.color.CAM_X0204, i2);
        }
    }

    public void c() {
        if (d.a.o0.z1.h.a.b().a()) {
            this.f67614c.setVisibility(0);
        } else {
            this.f67614c.setVisibility(8);
        }
    }

    public void d(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.f67616e.setVisibility(8);
        } else {
            this.f67613b.setText(String.format(h.a(R.string.emotion_manage_local_number), num));
            this.f67616e.setVisibility(0);
        }
        if (d.a.o0.z1.h.a.b().a()) {
            this.f67614c.setVisibility(0);
        } else {
            this.f67614c.setVisibility(8);
        }
    }
}

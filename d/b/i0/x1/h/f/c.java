package d.b.i0.x1.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.q.h;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f62493a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62494b;

    /* renamed from: c  reason: collision with root package name */
    public View f62495c;

    /* renamed from: d  reason: collision with root package name */
    public View f62496d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f62497e;

    public c(TbPageContext tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.f62496d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.emotion_manage_header_content);
        this.f62497e = linearLayout;
        linearLayout.setVisibility(8);
        this.f62493a = this.f62496d.findViewById(R.id.emotion_manage_item_header);
        this.f62494b = (TextView) this.f62496d.findViewById(R.id.emotion_manage_total_title);
        View findViewById = this.f62496d.findViewById(R.id.emotion_manage_edit_lable);
        this.f62495c = findViewById;
        findViewById.setVisibility(8);
    }

    public View a() {
        return this.f62496d;
    }

    public void b(int i) {
        View view = this.f62493a;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i);
        }
        LinearLayout linearLayout = this.f62497e;
        if (linearLayout != null) {
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0204, i);
        }
        TextView textView = this.f62494b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i);
            SkinManager.setBackgroundColor(this.f62494b, R.color.CAM_X0204, i);
        }
        View view2 = this.f62495c;
        if (view2 != null) {
            SkinManager.setViewTextColor(view2, R.color.CAM_X0107, i);
            SkinManager.setBackgroundColor(this.f62495c, R.color.CAM_X0204, i);
        }
    }

    public void c() {
        if (d.b.i0.x1.h.a.b().a()) {
            this.f62495c.setVisibility(0);
        } else {
            this.f62495c.setVisibility(8);
        }
    }

    public void d(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.f62497e.setVisibility(8);
        } else {
            this.f62494b.setText(String.format(h.a(R.string.emotion_manage_local_number), num));
            this.f62497e.setVisibility(0);
        }
        if (d.b.i0.x1.h.a.b().a()) {
            this.f62495c.setVisibility(0);
        } else {
            this.f62495c.setVisibility(8);
        }
    }
}

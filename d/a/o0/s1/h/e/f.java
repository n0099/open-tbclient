package d.a.o0.s1.h.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public View f64535a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f64536b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f64537c;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_member_guide_item, (ViewGroup) null);
        this.f64535a = inflate;
        inflate.setTag(this);
        this.f64536b = (TextView) this.f64535a.findViewById(R.id.tail_tool_member_guide_button);
        this.f64537c = (TextView) this.f64535a.findViewById(R.id.tail_tool_member_guide_text);
        return this.f64535a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f64536b, R.drawable.member_privilege_button_new_selector);
        SkinManager.setViewTextColor(this.f64536b, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f64537c, R.color.CAM_X0108, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f64536b.setOnClickListener(onClickListener);
    }
}

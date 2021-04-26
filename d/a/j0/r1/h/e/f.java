package d.a.j0.r1.h.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public View f59851a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59852b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59853c;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_member_guide_item, (ViewGroup) null);
        this.f59851a = inflate;
        inflate.setTag(this);
        this.f59852b = (TextView) this.f59851a.findViewById(R.id.tail_tool_member_guide_button);
        this.f59853c = (TextView) this.f59851a.findViewById(R.id.tail_tool_member_guide_text);
        return this.f59851a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f59852b, R.drawable.member_privilege_button_new_selector);
        SkinManager.setViewTextColor(this.f59852b, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f59853c, R.color.CAM_X0108, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f59852b.setOnClickListener(onClickListener);
    }
}

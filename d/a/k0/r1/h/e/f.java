package d.a.k0.r1.h.e;

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
    public View f60596a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60597b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60598c;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_member_guide_item, (ViewGroup) null);
        this.f60596a = inflate;
        inflate.setTag(this);
        this.f60597b = (TextView) this.f60596a.findViewById(R.id.tail_tool_member_guide_button);
        this.f60598c = (TextView) this.f60596a.findViewById(R.id.tail_tool_member_guide_text);
        return this.f60596a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f60597b, R.drawable.member_privilege_button_new_selector);
        SkinManager.setViewTextColor(this.f60597b, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f60598c, R.color.CAM_X0108, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f60597b.setOnClickListener(onClickListener);
    }
}

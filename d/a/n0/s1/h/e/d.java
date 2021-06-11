package d.a.n0.s1.h.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public View f64402a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f64403b;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_edit_item, (ViewGroup) null);
        this.f64402a = inflate;
        this.f64403b = (TextView) inflate.findViewById(R.id.tail_tool_edit_item_btn);
        this.f64402a.setTag(this);
        return this.f64402a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f64403b, R.drawable.tail_tool_add_button_bg);
        SkinManager.setViewTextColor(this.f64403b, R.color.CAM_X0302, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f64402a.setOnClickListener(onClickListener);
    }
}

package d.b.i0.q1.h.e;

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
    public View f59571a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59572b;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_edit_item, (ViewGroup) null);
        this.f59571a = inflate;
        this.f59572b = (TextView) inflate.findViewById(R.id.tail_tool_edit_item_btn);
        this.f59571a.setTag(this);
        return this.f59571a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f59572b, R.drawable.tail_tool_add_button_bg);
        SkinManager.setViewTextColor(this.f59572b, R.color.CAM_X0302, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f59571a.setOnClickListener(onClickListener);
    }
}

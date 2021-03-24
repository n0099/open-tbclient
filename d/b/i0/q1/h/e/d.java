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
    public View f59570a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59571b;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_edit_item, (ViewGroup) null);
        this.f59570a = inflate;
        this.f59571b = (TextView) inflate.findViewById(R.id.tail_tool_edit_item_btn);
        this.f59570a.setTag(this);
        return this.f59570a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f59571b, R.drawable.tail_tool_add_button_bg);
        SkinManager.setViewTextColor(this.f59571b, R.color.CAM_X0302, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f59570a.setOnClickListener(onClickListener);
    }
}

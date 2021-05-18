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
public class d {

    /* renamed from: a  reason: collision with root package name */
    public View f60588a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60589b;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_edit_item, (ViewGroup) null);
        this.f60588a = inflate;
        this.f60589b = (TextView) inflate.findViewById(R.id.tail_tool_edit_item_btn);
        this.f60588a.setTag(this);
        return this.f60588a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f60589b, R.drawable.tail_tool_add_button_bg);
        SkinManager.setViewTextColor(this.f60589b, R.color.CAM_X0302, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f60588a.setOnClickListener(onClickListener);
    }
}

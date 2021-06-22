package d.a.o0.s1.h.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f64523a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f64524b;

    /* renamed from: c  reason: collision with root package name */
    public Context f64525c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f64526d;

    public View a(Context context) {
        this.f64525c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_add_item, (ViewGroup) null);
        this.f64523a = inflate;
        inflate.setTag(this);
        this.f64526d = (TextView) this.f64523a.findViewById(R.id.tail_management_new_text);
        this.f64524b = (ImageView) this.f64523a.findViewById(R.id.tail_management_new_button);
        return this.f64523a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f64524b, R.drawable.tail_tool_add_button_bg);
        SkinManager.setImageResource(this.f64524b, R.drawable.icon_tail_post_add);
        SkinManager.setViewTextColor(this.f64526d, R.color.CAM_X0109, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f64524b.setOnClickListener(onClickListener);
    }

    public void d(int i2) {
        this.f64526d.setText(String.format(this.f64525c.getString(R.string.tail_management_available), Integer.valueOf(i2)));
    }
}

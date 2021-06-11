package d.a.n0.s1.h.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f64398a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f64399b;

    /* renamed from: c  reason: collision with root package name */
    public Context f64400c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f64401d;

    public View a(Context context) {
        this.f64400c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_add_item, (ViewGroup) null);
        this.f64398a = inflate;
        inflate.setTag(this);
        this.f64401d = (TextView) this.f64398a.findViewById(R.id.tail_management_new_text);
        this.f64399b = (ImageView) this.f64398a.findViewById(R.id.tail_management_new_button);
        return this.f64398a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f64399b, R.drawable.tail_tool_add_button_bg);
        SkinManager.setImageResource(this.f64399b, R.drawable.icon_tail_post_add);
        SkinManager.setViewTextColor(this.f64401d, R.color.CAM_X0109, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f64399b.setOnClickListener(onClickListener);
    }

    public void d(int i2) {
        this.f64401d.setText(String.format(this.f64400c.getString(R.string.tail_management_available), Integer.valueOf(i2)));
    }
}

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
    public View f60707a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f60708b;

    /* renamed from: c  reason: collision with root package name */
    public Context f60709c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60710d;

    public View a(Context context) {
        this.f60709c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_add_item, (ViewGroup) null);
        this.f60707a = inflate;
        inflate.setTag(this);
        this.f60710d = (TextView) this.f60707a.findViewById(R.id.tail_management_new_text);
        this.f60708b = (ImageView) this.f60707a.findViewById(R.id.tail_management_new_button);
        return this.f60707a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f60708b, R.drawable.tail_tool_add_button_bg);
        SkinManager.setImageResource(this.f60708b, R.drawable.icon_tail_post_add);
        SkinManager.setViewTextColor(this.f60710d, R.color.CAM_X0109, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f60708b.setOnClickListener(onClickListener);
    }

    public void d(int i2) {
        this.f60710d.setText(String.format(this.f60709c.getString(R.string.tail_management_available), Integer.valueOf(i2)));
    }
}

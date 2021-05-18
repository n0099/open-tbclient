package d.a.k0.r1.h.e;

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
    public View f60584a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f60585b;

    /* renamed from: c  reason: collision with root package name */
    public Context f60586c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60587d;

    public View a(Context context) {
        this.f60586c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_add_item, (ViewGroup) null);
        this.f60584a = inflate;
        inflate.setTag(this);
        this.f60587d = (TextView) this.f60584a.findViewById(R.id.tail_management_new_text);
        this.f60585b = (ImageView) this.f60584a.findViewById(R.id.tail_management_new_button);
        return this.f60584a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f60585b, R.drawable.tail_tool_add_button_bg);
        SkinManager.setImageResource(this.f60585b, R.drawable.icon_tail_post_add);
        SkinManager.setViewTextColor(this.f60587d, R.color.CAM_X0109, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f60585b.setOnClickListener(onClickListener);
    }

    public void d(int i2) {
        this.f60587d.setText(String.format(this.f60586c.getString(R.string.tail_management_available), Integer.valueOf(i2)));
    }
}

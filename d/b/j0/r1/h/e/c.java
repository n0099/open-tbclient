package d.b.j0.r1.h.e;

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
    public View f61682a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f61683b;

    /* renamed from: c  reason: collision with root package name */
    public Context f61684c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61685d;

    public View a(Context context) {
        this.f61684c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_add_item, (ViewGroup) null);
        this.f61682a = inflate;
        inflate.setTag(this);
        this.f61685d = (TextView) this.f61682a.findViewById(R.id.tail_management_new_text);
        this.f61683b = (ImageView) this.f61682a.findViewById(R.id.tail_management_new_button);
        return this.f61682a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f61683b, R.drawable.tail_tool_add_button_bg);
        SkinManager.setImageResource(this.f61683b, R.drawable.icon_tail_post_add);
        SkinManager.setViewTextColor(this.f61685d, R.color.CAM_X0109, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f61683b.setOnClickListener(onClickListener);
    }

    public void d(int i) {
        this.f61685d.setText(String.format(this.f61684c.getString(R.string.tail_management_available), Integer.valueOf(i)));
    }
}

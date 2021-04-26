package d.a.j0.r1.h.e;

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
    public View f59839a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59840b;

    /* renamed from: c  reason: collision with root package name */
    public Context f59841c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59842d;

    public View a(Context context) {
        this.f59841c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_add_item, (ViewGroup) null);
        this.f59839a = inflate;
        inflate.setTag(this);
        this.f59842d = (TextView) this.f59839a.findViewById(R.id.tail_management_new_text);
        this.f59840b = (ImageView) this.f59839a.findViewById(R.id.tail_management_new_button);
        return this.f59839a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f59840b, R.drawable.tail_tool_add_button_bg);
        SkinManager.setImageResource(this.f59840b, R.drawable.icon_tail_post_add);
        SkinManager.setViewTextColor(this.f59842d, R.color.CAM_X0109, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f59840b.setOnClickListener(onClickListener);
    }

    public void d(int i2) {
        this.f59842d.setText(String.format(this.f59841c.getString(R.string.tail_management_available), Integer.valueOf(i2)));
    }
}

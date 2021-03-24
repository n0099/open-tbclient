package d.b.i0.q1.h.e;

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
    public View f59566a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59567b;

    /* renamed from: c  reason: collision with root package name */
    public Context f59568c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59569d;

    public View a(Context context) {
        this.f59568c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_add_item, (ViewGroup) null);
        this.f59566a = inflate;
        inflate.setTag(this);
        this.f59569d = (TextView) this.f59566a.findViewById(R.id.tail_management_new_text);
        this.f59567b = (ImageView) this.f59566a.findViewById(R.id.tail_management_new_button);
        return this.f59566a;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        SkinManager.setBackgroundResource(this.f59567b, R.drawable.tail_tool_add_button_bg);
        SkinManager.setImageResource(this.f59567b, R.drawable.icon_tail_post_add);
        SkinManager.setViewTextColor(this.f59569d, R.color.CAM_X0109, 1);
    }

    public void c(View.OnClickListener onClickListener) {
        this.f59567b.setOnClickListener(onClickListener);
    }

    public void d(int i) {
        this.f59569d.setText(String.format(this.f59568c.getString(R.string.tail_management_available), Integer.valueOf(i)));
    }
}

package d.a.n0.s1.h.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public View f64404a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64405b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f64406c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f64407d;

    /* renamed from: e  reason: collision with root package name */
    public TailData f64408e;

    /* renamed from: f  reason: collision with root package name */
    public View f64409f;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_item, (ViewGroup) null);
        this.f64404a = inflate;
        this.f64405b = context;
        inflate.setTag(this);
        this.f64406c = (TextView) this.f64404a.findViewById(R.id.tail_tool_item_text);
        this.f64407d = (ImageView) this.f64404a.findViewById(R.id.tail_tool_item_selected);
        View findViewById = this.f64404a.findViewById(R.id.tail_tool_item_scope);
        this.f64409f = findViewById;
        findViewById.setTag(this);
        return this.f64404a;
    }

    public TailData b() {
        return this.f64408e;
    }

    @SuppressLint({"ResourceAsColor"})
    public void c() {
        SkinManager.setBackgroundResource(this.f64409f, R.drawable.tail_item_bg);
        SkinManager.setViewTextColor(this.f64406c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundResource(this.f64407d, R.drawable.tail_tool_list_item_checkbox_bg);
        SkinManager.setImageResource(this.f64407d, R.drawable.tail_tool_list_item_checkbox_selector);
    }

    public void d(String str) {
        this.f64406c.setTextColor(d.a.n0.s1.h.f.c.a(str));
    }

    public void e(View.OnClickListener onClickListener) {
        this.f64409f.setOnClickListener(onClickListener);
    }

    public void f(TailData tailData) {
        this.f64408e = tailData;
    }

    public void g(String str) {
        this.f64406c.setText(TbFaceManager.e().l(this.f64405b, d.a.n0.s1.h.f.d.a(str), null));
    }

    public void h(TailData tailData) {
        if (tailData == null) {
            return;
        }
        g(tailData.getContent());
        d(tailData.getFontColor());
        this.f64407d.setSelected(tailData.isSelected());
    }
}

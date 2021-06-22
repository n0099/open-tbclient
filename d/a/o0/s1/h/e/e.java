package d.a.o0.s1.h.e;

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
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public View f64529a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64530b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f64531c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f64532d;

    /* renamed from: e  reason: collision with root package name */
    public TailData f64533e;

    /* renamed from: f  reason: collision with root package name */
    public View f64534f;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_item, (ViewGroup) null);
        this.f64529a = inflate;
        this.f64530b = context;
        inflate.setTag(this);
        this.f64531c = (TextView) this.f64529a.findViewById(R.id.tail_tool_item_text);
        this.f64532d = (ImageView) this.f64529a.findViewById(R.id.tail_tool_item_selected);
        View findViewById = this.f64529a.findViewById(R.id.tail_tool_item_scope);
        this.f64534f = findViewById;
        findViewById.setTag(this);
        return this.f64529a;
    }

    public TailData b() {
        return this.f64533e;
    }

    @SuppressLint({"ResourceAsColor"})
    public void c() {
        SkinManager.setBackgroundResource(this.f64534f, R.drawable.tail_item_bg);
        SkinManager.setViewTextColor(this.f64531c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundResource(this.f64532d, R.drawable.tail_tool_list_item_checkbox_bg);
        SkinManager.setImageResource(this.f64532d, R.drawable.tail_tool_list_item_checkbox_selector);
    }

    public void d(String str) {
        this.f64531c.setTextColor(d.a.o0.s1.h.f.c.a(str));
    }

    public void e(View.OnClickListener onClickListener) {
        this.f64534f.setOnClickListener(onClickListener);
    }

    public void f(TailData tailData) {
        this.f64533e = tailData;
    }

    public void g(String str) {
        this.f64531c.setText(TbFaceManager.e().l(this.f64530b, d.a.o0.s1.h.f.d.a(str), null));
    }

    public void h(TailData tailData) {
        if (tailData == null) {
            return;
        }
        g(tailData.getContent());
        d(tailData.getFontColor());
        this.f64532d.setSelected(tailData.isSelected());
    }
}

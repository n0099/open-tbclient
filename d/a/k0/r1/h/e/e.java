package d.a.k0.r1.h.e;

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
    public View f60590a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60591b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60592c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60593d;

    /* renamed from: e  reason: collision with root package name */
    public TailData f60594e;

    /* renamed from: f  reason: collision with root package name */
    public View f60595f;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_item, (ViewGroup) null);
        this.f60590a = inflate;
        this.f60591b = context;
        inflate.setTag(this);
        this.f60592c = (TextView) this.f60590a.findViewById(R.id.tail_tool_item_text);
        this.f60593d = (ImageView) this.f60590a.findViewById(R.id.tail_tool_item_selected);
        View findViewById = this.f60590a.findViewById(R.id.tail_tool_item_scope);
        this.f60595f = findViewById;
        findViewById.setTag(this);
        return this.f60590a;
    }

    public TailData b() {
        return this.f60594e;
    }

    @SuppressLint({"ResourceAsColor"})
    public void c() {
        SkinManager.setBackgroundResource(this.f60595f, R.drawable.tail_item_bg);
        SkinManager.setViewTextColor(this.f60592c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundResource(this.f60593d, R.drawable.tail_tool_list_item_checkbox_bg);
        SkinManager.setImageResource(this.f60593d, R.drawable.tail_tool_list_item_checkbox_selector);
    }

    public void d(String str) {
        this.f60592c.setTextColor(d.a.k0.r1.h.f.c.a(str));
    }

    public void e(View.OnClickListener onClickListener) {
        this.f60595f.setOnClickListener(onClickListener);
    }

    public void f(TailData tailData) {
        this.f60594e = tailData;
    }

    public void g(String str) {
        this.f60592c.setText(TbFaceManager.e().l(this.f60591b, d.a.k0.r1.h.f.d.a(str), null));
    }

    public void h(TailData tailData) {
        if (tailData == null) {
            return;
        }
        g(tailData.getContent());
        d(tailData.getFontColor());
        this.f60593d.setSelected(tailData.isSelected());
    }
}

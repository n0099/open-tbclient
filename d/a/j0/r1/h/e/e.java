package d.a.j0.r1.h.e;

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
    public View f59845a;

    /* renamed from: b  reason: collision with root package name */
    public Context f59846b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59847c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59848d;

    /* renamed from: e  reason: collision with root package name */
    public TailData f59849e;

    /* renamed from: f  reason: collision with root package name */
    public View f59850f;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_item, (ViewGroup) null);
        this.f59845a = inflate;
        this.f59846b = context;
        inflate.setTag(this);
        this.f59847c = (TextView) this.f59845a.findViewById(R.id.tail_tool_item_text);
        this.f59848d = (ImageView) this.f59845a.findViewById(R.id.tail_tool_item_selected);
        View findViewById = this.f59845a.findViewById(R.id.tail_tool_item_scope);
        this.f59850f = findViewById;
        findViewById.setTag(this);
        return this.f59845a;
    }

    public TailData b() {
        return this.f59849e;
    }

    @SuppressLint({"ResourceAsColor"})
    public void c() {
        SkinManager.setBackgroundResource(this.f59850f, R.drawable.tail_item_bg);
        SkinManager.setViewTextColor(this.f59847c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundResource(this.f59848d, R.drawable.tail_tool_list_item_checkbox_bg);
        SkinManager.setImageResource(this.f59848d, R.drawable.tail_tool_list_item_checkbox_selector);
    }

    public void d(String str) {
        this.f59847c.setTextColor(d.a.j0.r1.h.f.c.a(str));
    }

    public void e(View.OnClickListener onClickListener) {
        this.f59850f.setOnClickListener(onClickListener);
    }

    public void f(TailData tailData) {
        this.f59849e = tailData;
    }

    public void g(String str) {
        this.f59847c.setText(TbFaceManager.e().l(this.f59846b, d.a.j0.r1.h.f.d.a(str), null));
    }

    public void h(TailData tailData) {
        if (tailData == null) {
            return;
        }
        g(tailData.getContent());
        d(tailData.getFontColor());
        this.f59848d.setSelected(tailData.isSelected());
    }
}

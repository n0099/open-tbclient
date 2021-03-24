package d.b.i0.q1.h.e;

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
    public View f59572a;

    /* renamed from: b  reason: collision with root package name */
    public Context f59573b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59574c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59575d;

    /* renamed from: e  reason: collision with root package name */
    public TailData f59576e;

    /* renamed from: f  reason: collision with root package name */
    public View f59577f;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_item, (ViewGroup) null);
        this.f59572a = inflate;
        this.f59573b = context;
        inflate.setTag(this);
        this.f59574c = (TextView) this.f59572a.findViewById(R.id.tail_tool_item_text);
        this.f59575d = (ImageView) this.f59572a.findViewById(R.id.tail_tool_item_selected);
        View findViewById = this.f59572a.findViewById(R.id.tail_tool_item_scope);
        this.f59577f = findViewById;
        findViewById.setTag(this);
        return this.f59572a;
    }

    public TailData b() {
        return this.f59576e;
    }

    @SuppressLint({"ResourceAsColor"})
    public void c() {
        SkinManager.setBackgroundResource(this.f59577f, R.drawable.tail_item_bg);
        SkinManager.setViewTextColor(this.f59574c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundResource(this.f59575d, R.drawable.tail_tool_list_item_checkbox_bg);
        SkinManager.setImageResource(this.f59575d, R.drawable.tail_tool_list_item_checkbox_selector);
    }

    public void d(String str) {
        this.f59574c.setTextColor(d.b.i0.q1.h.f.c.a(str));
    }

    public void e(View.OnClickListener onClickListener) {
        this.f59577f.setOnClickListener(onClickListener);
    }

    public void f(TailData tailData) {
        this.f59576e = tailData;
    }

    public void g(String str) {
        this.f59574c.setText(TbFaceManager.e().l(this.f59573b, d.b.i0.q1.h.f.d.a(str), null));
    }

    public void h(TailData tailData) {
        if (tailData == null) {
            return;
        }
        g(tailData.getContent());
        d(tailData.getFontColor());
        this.f59575d.setSelected(tailData.isSelected());
    }
}

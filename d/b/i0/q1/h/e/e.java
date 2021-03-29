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
    public View f59573a;

    /* renamed from: b  reason: collision with root package name */
    public Context f59574b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59575c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59576d;

    /* renamed from: e  reason: collision with root package name */
    public TailData f59577e;

    /* renamed from: f  reason: collision with root package name */
    public View f59578f;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_item, (ViewGroup) null);
        this.f59573a = inflate;
        this.f59574b = context;
        inflate.setTag(this);
        this.f59575c = (TextView) this.f59573a.findViewById(R.id.tail_tool_item_text);
        this.f59576d = (ImageView) this.f59573a.findViewById(R.id.tail_tool_item_selected);
        View findViewById = this.f59573a.findViewById(R.id.tail_tool_item_scope);
        this.f59578f = findViewById;
        findViewById.setTag(this);
        return this.f59573a;
    }

    public TailData b() {
        return this.f59577e;
    }

    @SuppressLint({"ResourceAsColor"})
    public void c() {
        SkinManager.setBackgroundResource(this.f59578f, R.drawable.tail_item_bg);
        SkinManager.setViewTextColor(this.f59575c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundResource(this.f59576d, R.drawable.tail_tool_list_item_checkbox_bg);
        SkinManager.setImageResource(this.f59576d, R.drawable.tail_tool_list_item_checkbox_selector);
    }

    public void d(String str) {
        this.f59575c.setTextColor(d.b.i0.q1.h.f.c.a(str));
    }

    public void e(View.OnClickListener onClickListener) {
        this.f59578f.setOnClickListener(onClickListener);
    }

    public void f(TailData tailData) {
        this.f59577e = tailData;
    }

    public void g(String str) {
        this.f59575c.setText(TbFaceManager.e().l(this.f59574b, d.b.i0.q1.h.f.d.a(str), null));
    }

    public void h(TailData tailData) {
        if (tailData == null) {
            return;
        }
        g(tailData.getContent());
        d(tailData.getFontColor());
        this.f59576d.setSelected(tailData.isSelected());
    }
}

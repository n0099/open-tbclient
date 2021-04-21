package d.b.j0.r1.h.e;

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
    public View f61688a;

    /* renamed from: b  reason: collision with root package name */
    public Context f61689b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61690c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f61691d;

    /* renamed from: e  reason: collision with root package name */
    public TailData f61692e;

    /* renamed from: f  reason: collision with root package name */
    public View f61693f;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_item, (ViewGroup) null);
        this.f61688a = inflate;
        this.f61689b = context;
        inflate.setTag(this);
        this.f61690c = (TextView) this.f61688a.findViewById(R.id.tail_tool_item_text);
        this.f61691d = (ImageView) this.f61688a.findViewById(R.id.tail_tool_item_selected);
        View findViewById = this.f61688a.findViewById(R.id.tail_tool_item_scope);
        this.f61693f = findViewById;
        findViewById.setTag(this);
        return this.f61688a;
    }

    public TailData b() {
        return this.f61692e;
    }

    @SuppressLint({"ResourceAsColor"})
    public void c() {
        SkinManager.setBackgroundResource(this.f61693f, R.drawable.tail_item_bg);
        SkinManager.setViewTextColor(this.f61690c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundResource(this.f61691d, R.drawable.tail_tool_list_item_checkbox_bg);
        SkinManager.setImageResource(this.f61691d, R.drawable.tail_tool_list_item_checkbox_selector);
    }

    public void d(String str) {
        this.f61690c.setTextColor(d.b.j0.r1.h.f.c.a(str));
    }

    public void e(View.OnClickListener onClickListener) {
        this.f61693f.setOnClickListener(onClickListener);
    }

    public void f(TailData tailData) {
        this.f61692e = tailData;
    }

    public void g(String str) {
        this.f61690c.setText(TbFaceManager.e().l(this.f61689b, d.b.j0.r1.h.f.d.a(str), null));
    }

    public void h(TailData tailData) {
        if (tailData == null) {
            return;
        }
        g(tailData.getContent());
        d(tailData.getFontColor());
        this.f61691d.setSelected(tailData.isSelected());
    }
}

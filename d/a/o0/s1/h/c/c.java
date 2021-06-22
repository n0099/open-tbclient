package d.a.o0.s1.h.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f64487a;

    /* renamed from: b  reason: collision with root package name */
    public TailData f64488b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f64489c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f64490d;

    /* renamed from: e  reason: collision with root package name */
    public Context f64491e;

    /* renamed from: f  reason: collision with root package name */
    public String f64492f;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f64487a);
        d(this.f64492f);
    }

    public View b(Context context) {
        this.f64491e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
        this.f64487a = inflate;
        inflate.setTag(this);
        this.f64489c = (TextView) this.f64487a.findViewById(R.id.tail_management_item_text);
        TextView textView = (TextView) this.f64487a.findViewById(R.id.tail_management_item_delete);
        this.f64490d = textView;
        textView.setTag(this);
        return this.f64487a;
    }

    public TailData c() {
        return this.f64488b;
    }

    public final void d(String str) {
        this.f64492f = str;
        this.f64489c.setTextColor(d.a.o0.s1.h.f.c.a(str));
    }

    public final void e(String str) {
        this.f64489c.setText(TbFaceManager.e().l(this.f64491e, d.a.o0.s1.h.f.d.a(str), null));
    }

    public void f(View.OnClickListener onClickListener) {
        this.f64490d.setOnClickListener(onClickListener);
    }

    public void g(Boolean bool) {
        this.f64490d.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    public void h(View.OnClickListener onClickListener) {
        this.f64487a.setOnClickListener(onClickListener);
    }

    public void i(TailData tailData) {
        this.f64488b = tailData;
        e(tailData.getContent());
        d(tailData.getFontColor());
    }
}

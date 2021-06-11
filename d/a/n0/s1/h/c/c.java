package d.a.n0.s1.h.c;

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
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f64362a;

    /* renamed from: b  reason: collision with root package name */
    public TailData f64363b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f64364c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f64365d;

    /* renamed from: e  reason: collision with root package name */
    public Context f64366e;

    /* renamed from: f  reason: collision with root package name */
    public String f64367f;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f64362a);
        d(this.f64367f);
    }

    public View b(Context context) {
        this.f64366e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
        this.f64362a = inflate;
        inflate.setTag(this);
        this.f64364c = (TextView) this.f64362a.findViewById(R.id.tail_management_item_text);
        TextView textView = (TextView) this.f64362a.findViewById(R.id.tail_management_item_delete);
        this.f64365d = textView;
        textView.setTag(this);
        return this.f64362a;
    }

    public TailData c() {
        return this.f64363b;
    }

    public final void d(String str) {
        this.f64367f = str;
        this.f64364c.setTextColor(d.a.n0.s1.h.f.c.a(str));
    }

    public final void e(String str) {
        this.f64364c.setText(TbFaceManager.e().l(this.f64366e, d.a.n0.s1.h.f.d.a(str), null));
    }

    public void f(View.OnClickListener onClickListener) {
        this.f64365d.setOnClickListener(onClickListener);
    }

    public void g(Boolean bool) {
        this.f64365d.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    public void h(View.OnClickListener onClickListener) {
        this.f64362a.setOnClickListener(onClickListener);
    }

    public void i(TailData tailData) {
        this.f64363b = tailData;
        e(tailData.getContent());
        d(tailData.getFontColor());
    }
}

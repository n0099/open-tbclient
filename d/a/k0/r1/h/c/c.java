package d.a.k0.r1.h.c;

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
    public View f60548a;

    /* renamed from: b  reason: collision with root package name */
    public TailData f60549b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60550c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60551d;

    /* renamed from: e  reason: collision with root package name */
    public Context f60552e;

    /* renamed from: f  reason: collision with root package name */
    public String f60553f;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f60548a);
        d(this.f60553f);
    }

    public View b(Context context) {
        this.f60552e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
        this.f60548a = inflate;
        inflate.setTag(this);
        this.f60550c = (TextView) this.f60548a.findViewById(R.id.tail_management_item_text);
        TextView textView = (TextView) this.f60548a.findViewById(R.id.tail_management_item_delete);
        this.f60551d = textView;
        textView.setTag(this);
        return this.f60548a;
    }

    public TailData c() {
        return this.f60549b;
    }

    public final void d(String str) {
        this.f60553f = str;
        this.f60550c.setTextColor(d.a.k0.r1.h.f.c.a(str));
    }

    public final void e(String str) {
        this.f60550c.setText(TbFaceManager.e().l(this.f60552e, d.a.k0.r1.h.f.d.a(str), null));
    }

    public void f(View.OnClickListener onClickListener) {
        this.f60551d.setOnClickListener(onClickListener);
    }

    public void g(Boolean bool) {
        this.f60551d.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    public void h(View.OnClickListener onClickListener) {
        this.f60548a.setOnClickListener(onClickListener);
    }

    public void i(TailData tailData) {
        this.f60549b = tailData;
        e(tailData.getContent());
        d(tailData.getFontColor());
    }
}

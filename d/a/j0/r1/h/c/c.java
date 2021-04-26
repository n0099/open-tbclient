package d.a.j0.r1.h.c;

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
    public View f59803a;

    /* renamed from: b  reason: collision with root package name */
    public TailData f59804b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59805c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59806d;

    /* renamed from: e  reason: collision with root package name */
    public Context f59807e;

    /* renamed from: f  reason: collision with root package name */
    public String f59808f;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f59803a);
        d(this.f59808f);
    }

    public View b(Context context) {
        this.f59807e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
        this.f59803a = inflate;
        inflate.setTag(this);
        this.f59805c = (TextView) this.f59803a.findViewById(R.id.tail_management_item_text);
        TextView textView = (TextView) this.f59803a.findViewById(R.id.tail_management_item_delete);
        this.f59806d = textView;
        textView.setTag(this);
        return this.f59803a;
    }

    public TailData c() {
        return this.f59804b;
    }

    public final void d(String str) {
        this.f59808f = str;
        this.f59805c.setTextColor(d.a.j0.r1.h.f.c.a(str));
    }

    public final void e(String str) {
        this.f59805c.setText(TbFaceManager.e().l(this.f59807e, d.a.j0.r1.h.f.d.a(str), null));
    }

    public void f(View.OnClickListener onClickListener) {
        this.f59806d.setOnClickListener(onClickListener);
    }

    public void g(Boolean bool) {
        this.f59806d.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    public void h(View.OnClickListener onClickListener) {
        this.f59803a.setOnClickListener(onClickListener);
    }

    public void i(TailData tailData) {
        this.f59804b = tailData;
        e(tailData.getContent());
        d(tailData.getFontColor());
    }
}

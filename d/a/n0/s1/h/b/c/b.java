package d.a.n0.s1.h.b.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f64342a;

    /* renamed from: b  reason: collision with root package name */
    public String f64343b;

    /* renamed from: c  reason: collision with root package name */
    public View f64344c;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_edit_color_item, (ViewGroup) null);
        this.f64342a = inflate;
        this.f64344c = inflate.findViewById(R.id.tail_edit_color_item_selected);
        this.f64342a.setTag(this);
        return this.f64342a;
    }

    public String b() {
        return this.f64343b;
    }

    public void c(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f64342a);
        this.f64342a.setBackgroundColor(d.a.n0.s1.h.f.c.a(this.f64343b));
    }

    public void d(String str) {
        this.f64343b = str;
        this.f64342a.setBackgroundColor(d.a.n0.s1.h.f.c.a(str));
    }

    public void e(View.OnClickListener onClickListener) {
        this.f64342a.setOnClickListener(onClickListener);
    }

    public void f(boolean z) {
        this.f64344c.setVisibility(z ? 0 : 4);
    }
}

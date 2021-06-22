package d.a.o0.s1.h.b.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f64467a;

    /* renamed from: b  reason: collision with root package name */
    public String f64468b;

    /* renamed from: c  reason: collision with root package name */
    public View f64469c;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_edit_color_item, (ViewGroup) null);
        this.f64467a = inflate;
        this.f64469c = inflate.findViewById(R.id.tail_edit_color_item_selected);
        this.f64467a.setTag(this);
        return this.f64467a;
    }

    public String b() {
        return this.f64468b;
    }

    public void c(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f64467a);
        this.f64467a.setBackgroundColor(d.a.o0.s1.h.f.c.a(this.f64468b));
    }

    public void d(String str) {
        this.f64468b = str;
        this.f64467a.setBackgroundColor(d.a.o0.s1.h.f.c.a(str));
    }

    public void e(View.OnClickListener onClickListener) {
        this.f64467a.setOnClickListener(onClickListener);
    }

    public void f(boolean z) {
        this.f64469c.setVisibility(z ? 0 : 4);
    }
}

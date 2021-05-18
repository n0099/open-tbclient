package d.a.k0.r1.h.b.c;

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
    public View f60528a;

    /* renamed from: b  reason: collision with root package name */
    public String f60529b;

    /* renamed from: c  reason: collision with root package name */
    public View f60530c;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_edit_color_item, (ViewGroup) null);
        this.f60528a = inflate;
        this.f60530c = inflate.findViewById(R.id.tail_edit_color_item_selected);
        this.f60528a.setTag(this);
        return this.f60528a;
    }

    public String b() {
        return this.f60529b;
    }

    public void c(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f60528a);
        this.f60528a.setBackgroundColor(d.a.k0.r1.h.f.c.a(this.f60529b));
    }

    public void d(String str) {
        this.f60529b = str;
        this.f60528a.setBackgroundColor(d.a.k0.r1.h.f.c.a(str));
    }

    public void e(View.OnClickListener onClickListener) {
        this.f60528a.setOnClickListener(onClickListener);
    }

    public void f(boolean z) {
        this.f60530c.setVisibility(z ? 0 : 4);
    }
}

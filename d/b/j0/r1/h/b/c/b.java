package d.b.j0.r1.h.b.c;

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
    public View f61628a;

    /* renamed from: b  reason: collision with root package name */
    public String f61629b;

    /* renamed from: c  reason: collision with root package name */
    public View f61630c;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_edit_color_item, (ViewGroup) null);
        this.f61628a = inflate;
        this.f61630c = inflate.findViewById(R.id.tail_edit_color_item_selected);
        this.f61628a.setTag(this);
        return this.f61628a;
    }

    public String b() {
        return this.f61629b;
    }

    public void c(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f61628a);
        this.f61628a.setBackgroundColor(d.b.j0.r1.h.f.c.a(this.f61629b));
    }

    public void d(String str) {
        this.f61629b = str;
        this.f61628a.setBackgroundColor(d.b.j0.r1.h.f.c.a(str));
    }

    public void e(View.OnClickListener onClickListener) {
        this.f61628a.setOnClickListener(onClickListener);
    }

    public void f(boolean z) {
        this.f61630c.setVisibility(z ? 0 : 4);
    }
}

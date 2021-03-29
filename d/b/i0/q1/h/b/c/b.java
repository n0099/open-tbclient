package d.b.i0.q1.h.b.c;

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
    public View f59513a;

    /* renamed from: b  reason: collision with root package name */
    public String f59514b;

    /* renamed from: c  reason: collision with root package name */
    public View f59515c;

    public View a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_edit_color_item, (ViewGroup) null);
        this.f59513a = inflate;
        this.f59515c = inflate.findViewById(R.id.tail_edit_color_item_selected);
        this.f59513a.setTag(this);
        return this.f59513a;
    }

    public String b() {
        return this.f59514b;
    }

    public void c(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f59513a);
        this.f59513a.setBackgroundColor(d.b.i0.q1.h.f.c.a(this.f59514b));
    }

    public void d(String str) {
        this.f59514b = str;
        this.f59513a.setBackgroundColor(d.b.i0.q1.h.f.c.a(str));
    }

    public void e(View.OnClickListener onClickListener) {
        this.f59513a.setOnClickListener(onClickListener);
    }

    public void f(boolean z) {
        this.f59515c.setVisibility(z ? 0 : 4);
    }
}

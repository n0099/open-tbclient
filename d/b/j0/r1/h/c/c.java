package d.b.j0.r1.h.c;

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
    public View f61647a;

    /* renamed from: b  reason: collision with root package name */
    public TailData f61648b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61649c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61650d;

    /* renamed from: e  reason: collision with root package name */
    public Context f61651e;

    /* renamed from: f  reason: collision with root package name */
    public String f61652f;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f61647a);
        d(this.f61652f);
    }

    public View b(Context context) {
        this.f61651e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
        this.f61647a = inflate;
        inflate.setTag(this);
        this.f61649c = (TextView) this.f61647a.findViewById(R.id.tail_management_item_text);
        TextView textView = (TextView) this.f61647a.findViewById(R.id.tail_management_item_delete);
        this.f61650d = textView;
        textView.setTag(this);
        return this.f61647a;
    }

    public TailData c() {
        return this.f61648b;
    }

    public final void d(String str) {
        this.f61652f = str;
        this.f61649c.setTextColor(d.b.j0.r1.h.f.c.a(str));
    }

    public final void e(String str) {
        this.f61649c.setText(TbFaceManager.e().l(this.f61651e, d.b.j0.r1.h.f.d.a(str), null));
    }

    public void f(View.OnClickListener onClickListener) {
        this.f61650d.setOnClickListener(onClickListener);
    }

    public void g(Boolean bool) {
        this.f61650d.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    public void h(View.OnClickListener onClickListener) {
        this.f61647a.setOnClickListener(onClickListener);
    }

    public void i(TailData tailData) {
        this.f61648b = tailData;
        e(tailData.getContent());
        d(tailData.getFontColor());
    }
}

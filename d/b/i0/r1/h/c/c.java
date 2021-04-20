package d.b.i0.r1.h.c;

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
    public View f61226a;

    /* renamed from: b  reason: collision with root package name */
    public TailData f61227b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61228c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61229d;

    /* renamed from: e  reason: collision with root package name */
    public Context f61230e;

    /* renamed from: f  reason: collision with root package name */
    public String f61231f;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f61226a);
        d(this.f61231f);
    }

    public View b(Context context) {
        this.f61230e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
        this.f61226a = inflate;
        inflate.setTag(this);
        this.f61228c = (TextView) this.f61226a.findViewById(R.id.tail_management_item_text);
        TextView textView = (TextView) this.f61226a.findViewById(R.id.tail_management_item_delete);
        this.f61229d = textView;
        textView.setTag(this);
        return this.f61226a;
    }

    public TailData c() {
        return this.f61227b;
    }

    public final void d(String str) {
        this.f61231f = str;
        this.f61228c.setTextColor(d.b.i0.r1.h.f.c.a(str));
    }

    public final void e(String str) {
        this.f61228c.setText(TbFaceManager.e().l(this.f61230e, d.b.i0.r1.h.f.d.a(str), null));
    }

    public void f(View.OnClickListener onClickListener) {
        this.f61229d.setOnClickListener(onClickListener);
    }

    public void g(Boolean bool) {
        this.f61229d.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    public void h(View.OnClickListener onClickListener) {
        this.f61226a.setOnClickListener(onClickListener);
    }

    public void i(TailData tailData) {
        this.f61227b = tailData;
        e(tailData.getContent());
        d(tailData.getFontColor());
    }
}

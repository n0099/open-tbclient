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
    public View f60671a;

    /* renamed from: b  reason: collision with root package name */
    public TailData f60672b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60673c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60674d;

    /* renamed from: e  reason: collision with root package name */
    public Context f60675e;

    /* renamed from: f  reason: collision with root package name */
    public String f60676f;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f60671a);
        d(this.f60676f);
    }

    public View b(Context context) {
        this.f60675e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
        this.f60671a = inflate;
        inflate.setTag(this);
        this.f60673c = (TextView) this.f60671a.findViewById(R.id.tail_management_item_text);
        TextView textView = (TextView) this.f60671a.findViewById(R.id.tail_management_item_delete);
        this.f60674d = textView;
        textView.setTag(this);
        return this.f60671a;
    }

    public TailData c() {
        return this.f60672b;
    }

    public final void d(String str) {
        this.f60676f = str;
        this.f60673c.setTextColor(d.a.n0.s1.h.f.c.a(str));
    }

    public final void e(String str) {
        this.f60673c.setText(TbFaceManager.e().l(this.f60675e, d.a.n0.s1.h.f.d.a(str), null));
    }

    public void f(View.OnClickListener onClickListener) {
        this.f60674d.setOnClickListener(onClickListener);
    }

    public void g(Boolean bool) {
        this.f60674d.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    public void h(View.OnClickListener onClickListener) {
        this.f60671a.setOnClickListener(onClickListener);
    }

    public void i(TailData tailData) {
        this.f60672b = tailData;
        e(tailData.getContent());
        d(tailData.getFontColor());
    }
}

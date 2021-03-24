package d.b.i0.c2.k.e.a1;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i.a;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class d extends a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52579f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52580g;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public View a() {
        LinearLayout linearLayout = (LinearLayout) this.f52564a.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
        this.f52579f = linearLayout;
        this.f52580g = (TextView) linearLayout.findViewById(R.id.text);
        return this.f52579f;
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f52568e != i) {
            this.f52568e = i;
            SkinManager.setBackgroundColor(this.f52579f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f52580g, R.color.CAM_X0105);
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52580g.setText(new SpannableString(originalThreadInfo.f13216g));
        SkinManager.setViewTextColor(this.f52580g, R.color.CAM_X0105);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void d(a.InterfaceC1115a interfaceC1115a) {
        super.d(interfaceC1115a);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
    }
}

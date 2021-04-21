package d.b.j0.d2.k.e.c1;

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
import d.b.j0.x.b0;
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54486f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54487g;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public View a() {
        LinearLayout linearLayout = (LinearLayout) this.f54471a.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
        this.f54486f = linearLayout;
        this.f54487g = (TextView) linearLayout.findViewById(R.id.text);
        return this.f54486f;
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f54475e != i) {
            this.f54475e = i;
            SkinManager.setBackgroundColor(this.f54486f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f54487g, R.color.CAM_X0105);
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f54487g.setText(new SpannableString(originalThreadInfo.f12886g));
        SkinManager.setViewTextColor(this.f54487g, R.color.CAM_X0105);
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void d(a.InterfaceC1070a interfaceC1070a) {
        super.d(interfaceC1070a);
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
    }
}

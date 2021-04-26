package d.a.j0.d2.k.e.c1;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.j0.x.b0;
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52282f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52283g;

    public d(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public View a() {
        LinearLayout linearLayout = (LinearLayout) this.f52266a.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
        this.f52282f = linearLayout;
        this.f52283g = (TextView) linearLayout.findViewById(R.id.text);
        return this.f52282f;
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52270e != i2) {
            this.f52270e = i2;
            SkinManager.setBackgroundColor(this.f52282f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f52283g, R.color.CAM_X0105);
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52283g.setText(new SpannableString(originalThreadInfo.f12802g));
        SkinManager.setViewTextColor(this.f52283g, R.color.CAM_X0105);
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void d(a.InterfaceC1009a interfaceC1009a) {
        super.d(interfaceC1009a);
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
    }
}

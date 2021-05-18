package d.a.k0.d2.k.e.c1;

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
import d.a.k0.x.b0;
/* loaded from: classes5.dex */
public class d extends a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52981f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52982g;

    public d(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public View a() {
        LinearLayout linearLayout = (LinearLayout) this.f52965a.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
        this.f52981f = linearLayout;
        this.f52982g = (TextView) linearLayout.findViewById(R.id.text);
        return this.f52981f;
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52969e != i2) {
            this.f52969e = i2;
            SkinManager.setBackgroundColor(this.f52981f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f52982g, R.color.CAM_X0105);
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52982g.setText(new SpannableString(originalThreadInfo.f12138g));
        SkinManager.setViewTextColor(this.f52982g, R.color.CAM_X0105);
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void d(a.InterfaceC0547a interfaceC0547a) {
        super.d(interfaceC0547a);
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
    }
}

package d.a.o0.e2.k.e.d1;

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
import d.a.o0.z.b0;
/* loaded from: classes5.dex */
public class d extends a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f57055f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57056g;

    public d(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public View a() {
        LinearLayout linearLayout = (LinearLayout) this.f57039a.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
        this.f57055f = linearLayout;
        this.f57056g = (TextView) linearLayout.findViewById(R.id.text);
        return this.f57055f;
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f57043e != i2) {
            this.f57043e = i2;
            SkinManager.setBackgroundColor(this.f57055f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f57056g, R.color.CAM_X0105);
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f57056g.setText(new SpannableString(originalThreadInfo.f12183g));
        SkinManager.setViewTextColor(this.f57056g, R.color.CAM_X0105);
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void d(a.InterfaceC0600a interfaceC0600a) {
        super.d(interfaceC0600a);
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
    }
}

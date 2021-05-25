package d.a.n0.e2.k.e.d1;

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
import d.a.n0.z.b0;
/* loaded from: classes5.dex */
public class d extends a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f53241f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53242g;

    public d(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        LinearLayout linearLayout = (LinearLayout) this.f53225a.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
        this.f53241f = linearLayout;
        this.f53242g = (TextView) linearLayout.findViewById(R.id.text);
        return this.f53241f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f53229e != i2) {
            this.f53229e = i2;
            SkinManager.setBackgroundColor(this.f53241f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f53242g, R.color.CAM_X0105);
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f53242g.setText(new SpannableString(originalThreadInfo.f12039g));
        SkinManager.setViewTextColor(this.f53242g, R.color.CAM_X0105);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0542a interfaceC0542a) {
        super.d(interfaceC0542a);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
    }
}

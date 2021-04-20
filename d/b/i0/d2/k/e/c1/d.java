package d.b.i0.d2.k.e.c1;

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
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54065f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54066g;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public View a() {
        LinearLayout linearLayout = (LinearLayout) this.f54050a.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
        this.f54065f = linearLayout;
        this.f54066g = (TextView) linearLayout.findViewById(R.id.text);
        return this.f54065f;
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f54054e != i) {
            this.f54054e = i;
            SkinManager.setBackgroundColor(this.f54065f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f54066g, R.color.CAM_X0105);
        }
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f54066g.setText(new SpannableString(originalThreadInfo.f12878g));
        SkinManager.setViewTextColor(this.f54066g, R.color.CAM_X0105);
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void d(a.InterfaceC1129a interfaceC1129a) {
        super.d(interfaceC1129a);
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
    }
}

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
    public LinearLayout f56930f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56931g;

    public d(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        LinearLayout linearLayout = (LinearLayout) this.f56914a.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
        this.f56930f = linearLayout;
        this.f56931g = (TextView) linearLayout.findViewById(R.id.text);
        return this.f56930f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f56918e != i2) {
            this.f56918e = i2;
            SkinManager.setBackgroundColor(this.f56930f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f56931g, R.color.CAM_X0105);
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f56931g.setText(new SpannableString(originalThreadInfo.f12101g));
        SkinManager.setViewTextColor(this.f56931g, R.color.CAM_X0105);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0598a interfaceC0598a) {
        super.d(interfaceC0598a);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
    }
}

package d.b.i0.p0.q1.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import d.b.h0.r.u.c;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f58368a;

    /* renamed from: b  reason: collision with root package name */
    public View f58369b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f58370c;

    public b(Context context) {
        this.f58368a = context;
        b(context);
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        View view;
        if (bdTypeRecyclerView == null || (view = this.f58369b) == null) {
            return;
        }
        view.setVisibility(0);
        bdTypeRecyclerView.s(this.f58369b);
    }

    public final void b(Context context) {
        if (this.f58369b != null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.forum_rules_title_area, (ViewGroup) null);
        this.f58369b = inflate;
        this.f58370c = (EMTextView) inflate.findViewById(R.id.forum_rules_title);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(int i) {
        c a2 = c.a(this.f58370c);
        a2.s(R.string.F_X02);
        a2.n(R.color.CAM_X0105);
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        View view;
        if (bdTypeRecyclerView == null || (view = this.f58369b) == null) {
            return;
        }
        view.setVisibility(8);
        bdTypeRecyclerView.removeHeaderView(this.f58369b);
    }

    public void e(String str) {
        this.f58370c.setText(str);
    }
}

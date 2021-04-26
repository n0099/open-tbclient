package d.a.j0.q0.q1.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import d.a.i0.r.u.c;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f58546a;

    /* renamed from: b  reason: collision with root package name */
    public View f58547b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f58548c;

    public b(Context context) {
        this.f58546a = context;
        b(context);
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        View view;
        if (bdTypeRecyclerView == null || (view = this.f58547b) == null) {
            return;
        }
        view.setVisibility(0);
        bdTypeRecyclerView.s(this.f58547b);
    }

    public final void b(Context context) {
        if (this.f58547b != null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.forum_rules_title_area, (ViewGroup) null);
        this.f58547b = inflate;
        this.f58548c = (EMTextView) inflate.findViewById(R.id.forum_rules_title);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(int i2) {
        c d2 = c.d(this.f58548c);
        d2.v(R.string.F_X02);
        d2.q(R.color.CAM_X0105);
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        View view;
        if (bdTypeRecyclerView == null || (view = this.f58547b) == null) {
            return;
        }
        view.setVisibility(8);
        bdTypeRecyclerView.removeHeaderView(this.f58547b);
    }

    public void e(String str) {
        this.f58548c.setText(str);
    }
}

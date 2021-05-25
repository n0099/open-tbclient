package d.a.n0.r0.q1.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import d.a.m0.r.u.c;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f59429a;

    /* renamed from: b  reason: collision with root package name */
    public View f59430b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f59431c;

    public b(Context context) {
        this.f59429a = context;
        b(context);
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        View view;
        if (bdTypeRecyclerView == null || (view = this.f59430b) == null) {
            return;
        }
        view.setVisibility(0);
        bdTypeRecyclerView.s(this.f59430b);
    }

    public final void b(Context context) {
        if (this.f59430b != null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.forum_rules_title_area, (ViewGroup) null);
        this.f59430b = inflate;
        this.f59431c = (EMTextView) inflate.findViewById(R.id.forum_rules_title);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(int i2) {
        c d2 = c.d(this.f59431c);
        d2.x(R.string.F_X02);
        d2.s(R.color.CAM_X0105);
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        View view;
        if (bdTypeRecyclerView == null || (view = this.f59430b) == null) {
            return;
        }
        view.setVisibility(8);
        bdTypeRecyclerView.removeHeaderView(this.f59430b);
    }

    public void e(String str) {
        this.f59431c.setText(str);
    }
}

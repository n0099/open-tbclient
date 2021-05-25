package d.a.n0.g2.j;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.a.c.j.e.n;
import d.a.n0.h2.e.h;
import d.a.n0.z.b0;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55212a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f55213b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f55214c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.g2.j.a f55215d;

    /* renamed from: e  reason: collision with root package name */
    public b0<h> f55216e;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f55212a.getPageActivity().finish();
        }
    }

    public c(TbPageContext tbPageContext) {
        this.f55212a = tbPageContext;
    }

    public final void b() {
        this.f55213b.setCenterTextTitle(this.f55212a.getString(R.string.person_center_more));
        this.f55213b.showBottomLine();
        this.f55213b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f55213b.onChangeSkinType(this.f55212a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(View view) {
        this.f55213b = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        BdTypeListView bdTypeListView = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.f55214c = bdTypeListView;
        this.f55215d = new d.a.n0.g2.j.a(this.f55212a, bdTypeListView, this.f55216e);
        b();
    }

    public void d() {
        this.f55215d.a();
        SkinManager.setBackgroundColor(this.f55214c, R.color.CAM_X0201);
        this.f55213b.onChangeSkinType(this.f55212a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(List<n> list) {
        this.f55214c.setData(list);
    }

    public void f(b0<h> b0Var) {
        this.f55216e = b0Var;
    }
}

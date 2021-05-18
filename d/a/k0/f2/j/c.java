package d.a.k0.f2.j;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.a.c.j.e.n;
import d.a.k0.g2.e.h;
import d.a.k0.x.b0;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55024a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f55025b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f55026c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.f2.j.a f55027d;

    /* renamed from: e  reason: collision with root package name */
    public b0<h> f55028e;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f55024a.getPageActivity().finish();
        }
    }

    public c(TbPageContext tbPageContext) {
        this.f55024a = tbPageContext;
    }

    public final void b() {
        this.f55025b.setCenterTextTitle(this.f55024a.getString(R.string.person_center_more));
        this.f55025b.showBottomLine();
        this.f55025b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f55025b.onChangeSkinType(this.f55024a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(View view) {
        this.f55025b = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        BdTypeListView bdTypeListView = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.f55026c = bdTypeListView;
        this.f55027d = new d.a.k0.f2.j.a(this.f55024a, bdTypeListView, this.f55028e);
        b();
    }

    public void d() {
        this.f55027d.a();
        SkinManager.setBackgroundColor(this.f55026c, R.color.CAM_X0201);
        this.f55025b.onChangeSkinType(this.f55024a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(List<n> list) {
        this.f55026c.setData(list);
    }

    public void f(b0<h> b0Var) {
        this.f55028e = b0Var;
    }
}

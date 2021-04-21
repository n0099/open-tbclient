package d.b.j0.f2.j;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.b.c.j.e.n;
import d.b.j0.g2.e.h;
import d.b.j0.x.b0;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56429a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f56430b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f56431c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.f2.j.a f56432d;

    /* renamed from: e  reason: collision with root package name */
    public b0<h> f56433e;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f56429a.getPageActivity().finish();
        }
    }

    public c(TbPageContext tbPageContext) {
        this.f56429a = tbPageContext;
    }

    public final void b() {
        this.f56430b.setCenterTextTitle(this.f56429a.getString(R.string.person_center_more));
        this.f56430b.showBottomLine();
        this.f56430b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f56430b.onChangeSkinType(this.f56429a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(View view) {
        this.f56430b = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        BdTypeListView bdTypeListView = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.f56431c = bdTypeListView;
        this.f56432d = new d.b.j0.f2.j.a(this.f56429a, bdTypeListView, this.f56433e);
        b();
    }

    public void d() {
        this.f56432d.a();
        SkinManager.setBackgroundColor(this.f56431c, R.color.CAM_X0201);
        this.f56430b.onChangeSkinType(this.f56429a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(List<n> list) {
        this.f56431c.setData(list);
    }

    public void f(b0<h> b0Var) {
        this.f56433e = b0Var;
    }
}

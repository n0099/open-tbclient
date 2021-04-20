package d.b.i0.f2.j;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.b.c.j.e.n;
import d.b.i0.g2.e.h;
import d.b.i0.x.b0;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56008a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f56009b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f56010c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.f2.j.a f56011d;

    /* renamed from: e  reason: collision with root package name */
    public b0<h> f56012e;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f56008a.getPageActivity().finish();
        }
    }

    public c(TbPageContext tbPageContext) {
        this.f56008a = tbPageContext;
    }

    public final void b() {
        this.f56009b.setCenterTextTitle(this.f56008a.getString(R.string.person_center_more));
        this.f56009b.showBottomLine();
        this.f56009b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f56009b.onChangeSkinType(this.f56008a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(View view) {
        this.f56009b = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        BdTypeListView bdTypeListView = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.f56010c = bdTypeListView;
        this.f56011d = new d.b.i0.f2.j.a(this.f56008a, bdTypeListView, this.f56012e);
        b();
    }

    public void d() {
        this.f56011d.a();
        SkinManager.setBackgroundColor(this.f56010c, R.color.CAM_X0201);
        this.f56009b.onChangeSkinType(this.f56008a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(List<n> list) {
        this.f56010c.setData(list);
    }

    public void f(b0<h> b0Var) {
        this.f56012e = b0Var;
    }
}

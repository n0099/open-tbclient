package d.b.i0.e2.j;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.b.b.j.e.n;
import d.b.i0.f2.e.h;
import d.b.i0.x.b0;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54567a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f54568b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f54569c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.e2.j.a f54570d;

    /* renamed from: e  reason: collision with root package name */
    public b0<h> f54571e;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f54567a.getPageActivity().finish();
        }
    }

    public c(TbPageContext tbPageContext) {
        this.f54567a = tbPageContext;
    }

    public final void b() {
        this.f54568b.setCenterTextTitle(this.f54567a.getString(R.string.person_center_more));
        this.f54568b.showBottomLine();
        this.f54568b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f54568b.onChangeSkinType(this.f54567a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(View view) {
        this.f54568b = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        BdTypeListView bdTypeListView = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.f54569c = bdTypeListView;
        this.f54570d = new d.b.i0.e2.j.a(this.f54567a, bdTypeListView, this.f54571e);
        b();
    }

    public void d() {
        this.f54570d.a();
        SkinManager.setBackgroundColor(this.f54569c, R.color.CAM_X0201);
        this.f54568b.onChangeSkinType(this.f54567a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(List<n> list) {
        this.f54569c.setData(list);
    }

    public void f(b0<h> b0Var) {
        this.f54571e = b0Var;
    }
}

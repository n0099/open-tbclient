package d.a.o0.g2.j;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.a.c.k.e.n;
import d.a.o0.h2.e.h;
import d.a.o0.z.b0;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59026a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f59027b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f59028c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.g2.j.a f59029d;

    /* renamed from: e  reason: collision with root package name */
    public b0<h> f59030e;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f59026a.getPageActivity().finish();
        }
    }

    public c(TbPageContext tbPageContext) {
        this.f59026a = tbPageContext;
    }

    public final void b() {
        this.f59027b.setCenterTextTitle(this.f59026a.getString(R.string.person_center_more));
        this.f59027b.showBottomLine();
        this.f59027b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f59027b.onChangeSkinType(this.f59026a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(View view) {
        this.f59027b = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        BdTypeListView bdTypeListView = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.f59028c = bdTypeListView;
        this.f59029d = new d.a.o0.g2.j.a(this.f59026a, bdTypeListView, this.f59030e);
        b();
    }

    public void d() {
        this.f59029d.a();
        SkinManager.setBackgroundColor(this.f59028c, R.color.CAM_X0201);
        this.f59027b.onChangeSkinType(this.f59026a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(List<n> list) {
        this.f59028c.setData(list);
    }

    public void f(b0<h> b0Var) {
        this.f59030e = b0Var;
    }
}

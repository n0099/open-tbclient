package d.a.n0.g2.j;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.a.c.k.e.n;
import d.a.n0.h2.e.h;
import d.a.n0.z.b0;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58901a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f58902b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f58903c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.g2.j.a f58904d;

    /* renamed from: e  reason: collision with root package name */
    public b0<h> f58905e;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f58901a.getPageActivity().finish();
        }
    }

    public c(TbPageContext tbPageContext) {
        this.f58901a = tbPageContext;
    }

    public final void b() {
        this.f58902b.setCenterTextTitle(this.f58901a.getString(R.string.person_center_more));
        this.f58902b.showBottomLine();
        this.f58902b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f58902b.onChangeSkinType(this.f58901a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(View view) {
        this.f58902b = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        BdTypeListView bdTypeListView = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.f58903c = bdTypeListView;
        this.f58904d = new d.a.n0.g2.j.a(this.f58901a, bdTypeListView, this.f58905e);
        b();
    }

    public void d() {
        this.f58904d.a();
        SkinManager.setBackgroundColor(this.f58903c, R.color.CAM_X0201);
        this.f58902b.onChangeSkinType(this.f58901a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(List<n> list) {
        this.f58903c.setData(list);
    }

    public void f(b0<h> b0Var) {
        this.f58905e = b0Var;
    }
}

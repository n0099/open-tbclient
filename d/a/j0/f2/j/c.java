package d.a.j0.f2.j;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.a.c.j.e.n;
import d.a.j0.g2.e.h;
import d.a.j0.x.b0;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54317a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f54318b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f54319c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.f2.j.a f54320d;

    /* renamed from: e  reason: collision with root package name */
    public b0<h> f54321e;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f54317a.getPageActivity().finish();
        }
    }

    public c(TbPageContext tbPageContext) {
        this.f54317a = tbPageContext;
    }

    public final void b() {
        this.f54318b.setCenterTextTitle(this.f54317a.getString(R.string.person_center_more));
        this.f54318b.showBottomLine();
        this.f54318b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f54318b.onChangeSkinType(this.f54317a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(View view) {
        this.f54318b = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
        BdTypeListView bdTypeListView = (BdTypeListView) view.findViewById(R.id.person_more_listview);
        this.f54319c = bdTypeListView;
        this.f54320d = new d.a.j0.f2.j.a(this.f54317a, bdTypeListView, this.f54321e);
        b();
    }

    public void d() {
        this.f54320d.a();
        SkinManager.setBackgroundColor(this.f54319c, R.color.CAM_X0201);
        this.f54318b.onChangeSkinType(this.f54317a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(List<n> list) {
        this.f54319c.setData(list);
    }

    public void f(b0<h> b0Var) {
        this.f54321e = b0Var;
    }
}

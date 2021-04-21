package d.b.j0.l0;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FacePurchaseRecordsActivity;
import com.baidu.tieba.faceshop.FacePurchaseRecordsData;
import d.b.i0.r.f0.f;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FacePurchaseRecordsActivity> f58377a;

    /* renamed from: b  reason: collision with root package name */
    public final View f58378b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f58379c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f58380d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f58381e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.i0.r.f0.g f58382f;

    /* renamed from: g  reason: collision with root package name */
    public View f58383g;

    /* renamed from: h  reason: collision with root package name */
    public k f58384h;

    public l(TbPageContext<FacePurchaseRecordsActivity> tbPageContext) {
        this.f58377a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f58378b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f58379c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f58379c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58380d = (NoNetworkView) this.f58378b.findViewById(R.id.view_no_network);
        this.f58381e = (BdListView) this.f58378b.findViewById(R.id.purchase_record_list);
        d.b.i0.r.f0.g gVar = new d.b.i0.r.f0.g(tbPageContext);
        this.f58382f = gVar;
        this.f58381e.setPullRefresh(gVar);
        this.f58383g = BdListViewHelper.d(this.f58377a.getPageActivity(), this.f58381e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        this.f58380d.a(bVar);
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f58383g, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f58381e.A(0L);
    }

    public k d() {
        return this.f58384h;
    }

    public void e(int i) {
        d.b.i0.r.c layoutMode = this.f58377a.getLayoutMode();
        layoutMode.k(i == 1);
        layoutMode.j(this.f58378b);
        this.f58379c.onChangeSkinType(this.f58377a, i);
        this.f58380d.c(this.f58377a, i);
        this.f58382f.I(i);
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.f58384h == null) {
            k kVar = new k(this.f58377a.getOrignalPage());
            this.f58384h = kVar;
            this.f58381e.setAdapter((ListAdapter) kVar);
        }
        this.f58384h.e(facePurchaseRecordsData);
        c();
    }

    public void g(NoNetworkView.b bVar) {
        this.f58380d.d(bVar);
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        this.f58381e.setOnItemClickListener(onItemClickListener);
    }

    public void i(f.g gVar) {
        this.f58382f.b(gVar);
    }
}

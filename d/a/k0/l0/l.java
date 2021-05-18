package d.a.k0.l0;

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
import d.a.j0.r.f0.f;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FacePurchaseRecordsActivity> f57085a;

    /* renamed from: b  reason: collision with root package name */
    public final View f57086b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f57087c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f57088d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f57089e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.j0.r.f0.g f57090f;

    /* renamed from: g  reason: collision with root package name */
    public View f57091g;

    /* renamed from: h  reason: collision with root package name */
    public k f57092h;

    public l(TbPageContext<FacePurchaseRecordsActivity> tbPageContext) {
        this.f57085a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f57086b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f57087c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f57087c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57088d = (NoNetworkView) this.f57086b.findViewById(R.id.view_no_network);
        this.f57089e = (BdListView) this.f57086b.findViewById(R.id.purchase_record_list);
        d.a.j0.r.f0.g gVar = new d.a.j0.r.f0.g(tbPageContext);
        this.f57090f = gVar;
        this.f57089e.setPullRefresh(gVar);
        this.f57091g = BdListViewHelper.d(this.f57085a.getPageActivity(), this.f57089e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        this.f57088d.a(bVar);
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f57091g, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f57089e.A(0L);
    }

    public k d() {
        return this.f57092h;
    }

    public void e(int i2) {
        d.a.j0.r.c layoutMode = this.f57085a.getLayoutMode();
        layoutMode.k(i2 == 1);
        layoutMode.j(this.f57086b);
        this.f57087c.onChangeSkinType(this.f57085a, i2);
        this.f57088d.c(this.f57085a, i2);
        this.f57090f.I(i2);
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.f57092h == null) {
            k kVar = new k(this.f57085a.getOrignalPage());
            this.f57092h = kVar;
            this.f57089e.setAdapter((ListAdapter) kVar);
        }
        this.f57092h.e(facePurchaseRecordsData);
        c();
    }

    public void g(NoNetworkView.b bVar) {
        this.f57088d.d(bVar);
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        this.f57089e.setOnItemClickListener(onItemClickListener);
    }

    public void i(f.g gVar) {
        this.f57090f.a(gVar);
    }
}

package d.a.o0.m0;

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
import d.a.n0.r.f0.f;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FacePurchaseRecordsActivity> f61089a;

    /* renamed from: b  reason: collision with root package name */
    public final View f61090b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f61091c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f61092d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f61093e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.n0.r.f0.g f61094f;

    /* renamed from: g  reason: collision with root package name */
    public View f61095g;

    /* renamed from: h  reason: collision with root package name */
    public k f61096h;

    public l(TbPageContext<FacePurchaseRecordsActivity> tbPageContext) {
        this.f61089a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f61090b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f61091c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f61091c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61092d = (NoNetworkView) this.f61090b.findViewById(R.id.view_no_network);
        this.f61093e = (BdListView) this.f61090b.findViewById(R.id.purchase_record_list);
        d.a.n0.r.f0.g gVar = new d.a.n0.r.f0.g(tbPageContext);
        this.f61094f = gVar;
        this.f61093e.setPullRefresh(gVar);
        this.f61095g = BdListViewHelper.d(this.f61089a.getPageActivity(), this.f61093e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        this.f61092d.a(bVar);
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f61095g, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f61093e.A(0L);
    }

    public k d() {
        return this.f61096h;
    }

    public void e(int i2) {
        d.a.n0.r.c layoutMode = this.f61089a.getLayoutMode();
        layoutMode.k(i2 == 1);
        layoutMode.j(this.f61090b);
        this.f61091c.onChangeSkinType(this.f61089a, i2);
        this.f61092d.c(this.f61089a, i2);
        this.f61094f.I(i2);
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.f61096h == null) {
            k kVar = new k(this.f61089a.getOrignalPage());
            this.f61096h = kVar;
            this.f61093e.setAdapter((ListAdapter) kVar);
        }
        this.f61096h.e(facePurchaseRecordsData);
        c();
    }

    public void g(NoNetworkView.b bVar) {
        this.f61092d.d(bVar);
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        this.f61093e.setOnItemClickListener(onItemClickListener);
    }

    public void i(f.g gVar) {
        this.f61094f.a(gVar);
    }
}

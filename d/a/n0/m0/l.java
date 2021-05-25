package d.a.n0.m0;

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
import d.a.m0.r.f0.f;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FacePurchaseRecordsActivity> f57275a;

    /* renamed from: b  reason: collision with root package name */
    public final View f57276b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f57277c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f57278d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f57279e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.m0.r.f0.g f57280f;

    /* renamed from: g  reason: collision with root package name */
    public View f57281g;

    /* renamed from: h  reason: collision with root package name */
    public k f57282h;

    public l(TbPageContext<FacePurchaseRecordsActivity> tbPageContext) {
        this.f57275a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f57276b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f57277c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f57277c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57278d = (NoNetworkView) this.f57276b.findViewById(R.id.view_no_network);
        this.f57279e = (BdListView) this.f57276b.findViewById(R.id.purchase_record_list);
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(tbPageContext);
        this.f57280f = gVar;
        this.f57279e.setPullRefresh(gVar);
        this.f57281g = BdListViewHelper.d(this.f57275a.getPageActivity(), this.f57279e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        this.f57278d.a(bVar);
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f57281g, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f57279e.A(0L);
    }

    public k d() {
        return this.f57282h;
    }

    public void e(int i2) {
        d.a.m0.r.c layoutMode = this.f57275a.getLayoutMode();
        layoutMode.k(i2 == 1);
        layoutMode.j(this.f57276b);
        this.f57277c.onChangeSkinType(this.f57275a, i2);
        this.f57278d.c(this.f57275a, i2);
        this.f57280f.I(i2);
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.f57282h == null) {
            k kVar = new k(this.f57275a.getOrignalPage());
            this.f57282h = kVar;
            this.f57279e.setAdapter((ListAdapter) kVar);
        }
        this.f57282h.e(facePurchaseRecordsData);
        c();
    }

    public void g(NoNetworkView.b bVar) {
        this.f57278d.d(bVar);
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        this.f57279e.setOnItemClickListener(onItemClickListener);
    }

    public void i(f.g gVar) {
        this.f57280f.a(gVar);
    }
}

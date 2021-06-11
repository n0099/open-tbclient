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
    public final TbPageContext<FacePurchaseRecordsActivity> f60964a;

    /* renamed from: b  reason: collision with root package name */
    public final View f60965b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f60966c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f60967d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f60968e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.m0.r.f0.g f60969f;

    /* renamed from: g  reason: collision with root package name */
    public View f60970g;

    /* renamed from: h  reason: collision with root package name */
    public k f60971h;

    public l(TbPageContext<FacePurchaseRecordsActivity> tbPageContext) {
        this.f60964a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f60965b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f60966c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f60966c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60967d = (NoNetworkView) this.f60965b.findViewById(R.id.view_no_network);
        this.f60968e = (BdListView) this.f60965b.findViewById(R.id.purchase_record_list);
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(tbPageContext);
        this.f60969f = gVar;
        this.f60968e.setPullRefresh(gVar);
        this.f60970g = BdListViewHelper.d(this.f60964a.getPageActivity(), this.f60968e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        this.f60967d.a(bVar);
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f60970g, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f60968e.A(0L);
    }

    public k d() {
        return this.f60971h;
    }

    public void e(int i2) {
        d.a.m0.r.c layoutMode = this.f60964a.getLayoutMode();
        layoutMode.k(i2 == 1);
        layoutMode.j(this.f60965b);
        this.f60966c.onChangeSkinType(this.f60964a, i2);
        this.f60967d.c(this.f60964a, i2);
        this.f60969f.I(i2);
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.f60971h == null) {
            k kVar = new k(this.f60964a.getOrignalPage());
            this.f60971h = kVar;
            this.f60968e.setAdapter((ListAdapter) kVar);
        }
        this.f60971h.e(facePurchaseRecordsData);
        c();
    }

    public void g(NoNetworkView.b bVar) {
        this.f60967d.d(bVar);
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        this.f60968e.setOnItemClickListener(onItemClickListener);
    }

    public void i(f.g gVar) {
        this.f60969f.a(gVar);
    }
}

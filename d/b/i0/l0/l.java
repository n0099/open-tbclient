package d.b.i0.l0;

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
import d.b.h0.r.f0.f;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FacePurchaseRecordsActivity> f56549a;

    /* renamed from: b  reason: collision with root package name */
    public final View f56550b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f56551c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f56552d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f56553e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.h0.r.f0.g f56554f;

    /* renamed from: g  reason: collision with root package name */
    public View f56555g;

    /* renamed from: h  reason: collision with root package name */
    public k f56556h;

    public l(TbPageContext<FacePurchaseRecordsActivity> tbPageContext) {
        this.f56549a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f56550b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f56551c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f56551c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56552d = (NoNetworkView) this.f56550b.findViewById(R.id.view_no_network);
        this.f56553e = (BdListView) this.f56550b.findViewById(R.id.purchase_record_list);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(tbPageContext);
        this.f56554f = gVar;
        this.f56553e.setPullRefresh(gVar);
        this.f56555g = BdListViewHelper.d(this.f56549a.getPageActivity(), this.f56553e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        this.f56552d.a(bVar);
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f56555g, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f56553e.A(0L);
    }

    public k d() {
        return this.f56556h;
    }

    public void e(int i) {
        d.b.h0.r.c layoutMode = this.f56549a.getLayoutMode();
        layoutMode.k(i == 1);
        layoutMode.j(this.f56550b);
        this.f56551c.onChangeSkinType(this.f56549a, i);
        this.f56552d.c(this.f56549a, i);
        this.f56554f.I(i);
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.f56556h == null) {
            k kVar = new k(this.f56549a.getOrignalPage());
            this.f56556h = kVar;
            this.f56553e.setAdapter((ListAdapter) kVar);
        }
        this.f56556h.e(facePurchaseRecordsData);
        c();
    }

    public void g(NoNetworkView.b bVar) {
        this.f56552d.d(bVar);
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        this.f56553e.setOnItemClickListener(onItemClickListener);
    }

    public void i(f.g gVar) {
        this.f56554f.b(gVar);
    }
}

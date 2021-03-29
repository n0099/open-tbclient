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
    public final TbPageContext<FacePurchaseRecordsActivity> f56550a;

    /* renamed from: b  reason: collision with root package name */
    public final View f56551b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f56552c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f56553d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f56554e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.h0.r.f0.g f56555f;

    /* renamed from: g  reason: collision with root package name */
    public View f56556g;

    /* renamed from: h  reason: collision with root package name */
    public k f56557h;

    public l(TbPageContext<FacePurchaseRecordsActivity> tbPageContext) {
        this.f56550a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f56551b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f56552c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f56552c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56553d = (NoNetworkView) this.f56551b.findViewById(R.id.view_no_network);
        this.f56554e = (BdListView) this.f56551b.findViewById(R.id.purchase_record_list);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(tbPageContext);
        this.f56555f = gVar;
        this.f56554e.setPullRefresh(gVar);
        this.f56556g = BdListViewHelper.d(this.f56550a.getPageActivity(), this.f56554e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        this.f56553d.a(bVar);
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f56556g, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f56554e.A(0L);
    }

    public k d() {
        return this.f56557h;
    }

    public void e(int i) {
        d.b.h0.r.c layoutMode = this.f56550a.getLayoutMode();
        layoutMode.k(i == 1);
        layoutMode.j(this.f56551b);
        this.f56552c.onChangeSkinType(this.f56550a, i);
        this.f56553d.c(this.f56550a, i);
        this.f56555f.I(i);
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.f56557h == null) {
            k kVar = new k(this.f56550a.getOrignalPage());
            this.f56557h = kVar;
            this.f56554e.setAdapter((ListAdapter) kVar);
        }
        this.f56557h.e(facePurchaseRecordsData);
        c();
    }

    public void g(NoNetworkView.b bVar) {
        this.f56553d.d(bVar);
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        this.f56554e.setOnItemClickListener(onItemClickListener);
    }

    public void i(f.g gVar) {
        this.f56555f.b(gVar);
    }
}

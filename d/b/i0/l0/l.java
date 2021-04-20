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
    public final TbPageContext<FacePurchaseRecordsActivity> f57956a;

    /* renamed from: b  reason: collision with root package name */
    public final View f57957b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f57958c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f57959d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f57960e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.h0.r.f0.g f57961f;

    /* renamed from: g  reason: collision with root package name */
    public View f57962g;

    /* renamed from: h  reason: collision with root package name */
    public k f57963h;

    public l(TbPageContext<FacePurchaseRecordsActivity> tbPageContext) {
        this.f57956a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f57957b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f57958c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f57958c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57959d = (NoNetworkView) this.f57957b.findViewById(R.id.view_no_network);
        this.f57960e = (BdListView) this.f57957b.findViewById(R.id.purchase_record_list);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(tbPageContext);
        this.f57961f = gVar;
        this.f57960e.setPullRefresh(gVar);
        this.f57962g = BdListViewHelper.d(this.f57956a.getPageActivity(), this.f57960e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        this.f57959d.a(bVar);
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f57962g, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f57960e.A(0L);
    }

    public k d() {
        return this.f57963h;
    }

    public void e(int i) {
        d.b.h0.r.c layoutMode = this.f57956a.getLayoutMode();
        layoutMode.k(i == 1);
        layoutMode.j(this.f57957b);
        this.f57958c.onChangeSkinType(this.f57956a, i);
        this.f57959d.c(this.f57956a, i);
        this.f57961f.I(i);
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.f57963h == null) {
            k kVar = new k(this.f57956a.getOrignalPage());
            this.f57963h = kVar;
            this.f57960e.setAdapter((ListAdapter) kVar);
        }
        this.f57963h.e(facePurchaseRecordsData);
        c();
    }

    public void g(NoNetworkView.b bVar) {
        this.f57959d.d(bVar);
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        this.f57960e.setOnItemClickListener(onItemClickListener);
    }

    public void i(f.g gVar) {
        this.f57961f.b(gVar);
    }
}

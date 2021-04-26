package d.a.j0.l0;

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
import d.a.i0.r.f0.f;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FacePurchaseRecordsActivity> f56378a;

    /* renamed from: b  reason: collision with root package name */
    public final View f56379b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f56380c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f56381d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f56382e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.i0.r.f0.g f56383f;

    /* renamed from: g  reason: collision with root package name */
    public View f56384g;

    /* renamed from: h  reason: collision with root package name */
    public k f56385h;

    public l(TbPageContext<FacePurchaseRecordsActivity> tbPageContext) {
        this.f56378a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f56379b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f56380c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f56380c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56381d = (NoNetworkView) this.f56379b.findViewById(R.id.view_no_network);
        this.f56382e = (BdListView) this.f56379b.findViewById(R.id.purchase_record_list);
        d.a.i0.r.f0.g gVar = new d.a.i0.r.f0.g(tbPageContext);
        this.f56383f = gVar;
        this.f56382e.setPullRefresh(gVar);
        this.f56384g = BdListViewHelper.d(this.f56378a.getPageActivity(), this.f56382e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        this.f56381d.a(bVar);
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f56384g, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        this.f56382e.A(0L);
    }

    public k d() {
        return this.f56385h;
    }

    public void e(int i2) {
        d.a.i0.r.c layoutMode = this.f56378a.getLayoutMode();
        layoutMode.k(i2 == 1);
        layoutMode.j(this.f56379b);
        this.f56380c.onChangeSkinType(this.f56378a, i2);
        this.f56381d.c(this.f56378a, i2);
        this.f56383f.I(i2);
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.f56385h == null) {
            k kVar = new k(this.f56378a.getOrignalPage());
            this.f56385h = kVar;
            this.f56382e.setAdapter((ListAdapter) kVar);
        }
        this.f56385h.e(facePurchaseRecordsData);
        c();
    }

    public void g(NoNetworkView.b bVar) {
        this.f56381d.d(bVar);
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        this.f56382e.setOnItemClickListener(onItemClickListener);
    }

    public void i(f.g gVar) {
        this.f56383f.a(gVar);
    }
}

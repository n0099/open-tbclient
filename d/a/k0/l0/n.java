package d.a.k0.l0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FacePackageData;
import com.baidu.tieba.faceshop.FaceShopActivity;
import com.baidu.tieba.faceshop.FaceShopData;
import com.baidu.tieba.faceshop.QueryDownloadMessage;
import d.a.j0.r.f0.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FaceShopActivity> f57115a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f57116b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f57117c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f57118d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f57119e;

    /* renamed from: f  reason: collision with root package name */
    public final m f57120f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f57121g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.j0.r.f0.g f57122h;

    /* renamed from: i  reason: collision with root package name */
    public final a f57123i;
    public final h j;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.j.e.b {

        /* renamed from: f  reason: collision with root package name */
        public final TbPageContext<?> f57124f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f57125g = null;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f57126h = null;

        /* renamed from: i  reason: collision with root package name */
        public View f57127i = null;
        public View j;

        public a(n nVar, TbPageContext<?> tbPageContext) {
            this.f57124f = tbPageContext;
        }

        @Override // d.a.c.j.e.b
        public View a() {
            View inflate = LayoutInflater.from(this.f57124f.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.f57127i = inflate;
            inflate.setPadding(0, this.f57124f.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f57124f.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.f57125g = (TextView) this.f57127i.findViewById(R.id.pb_more_text);
            View findViewById = this.f57127i.findViewById(R.id.pb_more_view);
            this.j = findViewById;
            findViewById.setVisibility(8);
            this.f57126h = (ProgressBar) this.f57127i.findViewById(R.id.progress);
            h(TbadkApplication.getInst().getSkinType());
            this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.f57127i;
        }

        @Override // d.a.c.j.e.b
        public void c() {
        }

        public void d() {
            this.f57127i.setVisibility(0);
        }

        public void e() {
            this.f57127i.setVisibility(8);
        }

        public void f() {
            this.f57126h.setVisibility(8);
            this.f57125g.setText(R.string.load_more);
        }

        public void g() {
            this.f57126h.setVisibility(0);
            this.f57125g.setText(this.f57124f.getPageActivity().getText(R.string.loading));
            this.j.setVisibility(0);
        }

        public void h(int i2) {
            TbPageContext<?> tbPageContext = this.f57124f;
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i2 == 1);
                this.f57124f.getLayoutMode().j(this.j);
            }
        }
    }

    public n(TbPageContext<FaceShopActivity> tbPageContext) {
        this.f57115a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.f57116b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f57117c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.f57117c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f57117c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        this.f57118d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f57121g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.f57119e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.f57122h = new d.a.j0.r.f0.g(tbPageContext);
        this.f57120f = new m(tbPageContext.getOrignalPage());
        this.f57123i = new a(this, tbPageContext);
        this.f57119e.setAdapter((ListAdapter) this.f57120f);
        this.f57119e.setPullRefresh(this.f57122h);
        this.f57119e.setNextPage(this.f57123i);
        try {
            this.f57118d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.j = new h(tbPageContext, R.style.common_alert_dialog);
    }

    public void a(NoNetworkView.b bVar) {
        this.f57121g.a(bVar);
    }

    public void b() {
        this.f57123i.f();
        this.f57119e.A(0L);
    }

    public m c() {
        return this.f57120f;
    }

    public TextView d() {
        return this.f57118d;
    }

    public void e() {
        h hVar = this.j;
        if (hVar != null) {
            d.a.c.e.m.g.b(hVar, this.f57115a);
        }
    }

    public void f() {
        a aVar = this.f57123i;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void g(int i2) {
        d.a.j0.r.c layoutMode = this.f57115a.getLayoutMode();
        layoutMode.k(i2 == 1);
        layoutMode.j(this.f57116b);
        NavigationBar navigationBar = this.f57117c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57115a, i2);
        }
        d.a.j0.r.f0.g gVar = this.f57122h;
        if (gVar != null) {
            gVar.I(i2);
        }
        a aVar = this.f57123i;
        if (aVar != null) {
            aVar.h(i2);
        }
        NoNetworkView noNetworkView = this.f57121g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f57115a, i2);
        }
    }

    public void h() {
        NoNetworkView noNetworkView = this.f57121g;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && d.a.c.e.p.j.z()) {
            this.f57121g.e(false);
        }
    }

    public void i(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(arrayList));
    }

    public void j(FaceShopData faceShopData) {
        ArrayList<FacePackageData> arrayList;
        b();
        if (faceShopData == null || (arrayList = faceShopData.pack_list) == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<FacePackageData> it = faceShopData.pack_list.iterator();
        while (it.hasNext()) {
            arrayList2.add(String.valueOf(it.next().pid));
        }
        i(arrayList2);
    }

    public void k(NoNetworkView.b bVar) {
        this.f57121g.d(bVar);
    }

    public void l() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.c();
        }
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        this.f57119e.setOnItemClickListener(onItemClickListener);
    }

    public void n() {
        this.f57123i.g();
    }

    public void o(f.g gVar) {
        this.f57122h.a(gVar);
    }

    public void p(BdListView.p pVar) {
        this.f57119e.setOnSrollToBottomListener(pVar);
    }

    public void q() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.d();
            d.a.c.e.m.g.j(this.j, this.f57115a);
        }
    }

    public void r() {
        a aVar = this.f57123i;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void s() {
        this.f57119e.F();
    }
}

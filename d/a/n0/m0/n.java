package d.a.n0.m0;

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
import d.a.m0.r.f0.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FaceShopActivity> f57305a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f57306b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f57307c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f57308d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f57309e;

    /* renamed from: f  reason: collision with root package name */
    public final m f57310f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f57311g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.m0.r.f0.g f57312h;

    /* renamed from: i  reason: collision with root package name */
    public final a f57313i;
    public final h j;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.j.e.b {

        /* renamed from: f  reason: collision with root package name */
        public final TbPageContext<?> f57314f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f57315g = null;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f57316h = null;

        /* renamed from: i  reason: collision with root package name */
        public View f57317i = null;
        public View j;

        public a(n nVar, TbPageContext<?> tbPageContext) {
            this.f57314f = tbPageContext;
        }

        @Override // d.a.c.j.e.b
        public View a() {
            View inflate = LayoutInflater.from(this.f57314f.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.f57317i = inflate;
            inflate.setPadding(0, this.f57314f.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f57314f.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.f57315g = (TextView) this.f57317i.findViewById(R.id.pb_more_text);
            View findViewById = this.f57317i.findViewById(R.id.pb_more_view);
            this.j = findViewById;
            findViewById.setVisibility(8);
            this.f57316h = (ProgressBar) this.f57317i.findViewById(R.id.progress);
            h(TbadkApplication.getInst().getSkinType());
            this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.f57317i;
        }

        @Override // d.a.c.j.e.b
        public void c() {
        }

        public void d() {
            this.f57317i.setVisibility(0);
        }

        public void e() {
            this.f57317i.setVisibility(8);
        }

        public void f() {
            this.f57316h.setVisibility(8);
            this.f57315g.setText(R.string.load_more);
        }

        public void g() {
            this.f57316h.setVisibility(0);
            this.f57315g.setText(this.f57314f.getPageActivity().getText(R.string.loading));
            this.j.setVisibility(0);
        }

        public void h(int i2) {
            TbPageContext<?> tbPageContext = this.f57314f;
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i2 == 1);
                this.f57314f.getLayoutMode().j(this.j);
            }
        }
    }

    public n(TbPageContext<FaceShopActivity> tbPageContext) {
        this.f57305a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.f57306b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f57307c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.f57307c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f57307c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        this.f57308d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f57311g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.f57309e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.f57312h = new d.a.m0.r.f0.g(tbPageContext);
        this.f57310f = new m(tbPageContext.getOrignalPage());
        this.f57313i = new a(this, tbPageContext);
        this.f57309e.setAdapter((ListAdapter) this.f57310f);
        this.f57309e.setPullRefresh(this.f57312h);
        this.f57309e.setNextPage(this.f57313i);
        try {
            this.f57308d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.j = new h(tbPageContext, R.style.common_alert_dialog);
    }

    public void a(NoNetworkView.b bVar) {
        this.f57311g.a(bVar);
    }

    public void b() {
        this.f57313i.f();
        this.f57309e.A(0L);
    }

    public m c() {
        return this.f57310f;
    }

    public TextView d() {
        return this.f57308d;
    }

    public void e() {
        h hVar = this.j;
        if (hVar != null) {
            d.a.c.e.m.g.b(hVar, this.f57305a);
        }
    }

    public void f() {
        a aVar = this.f57313i;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void g(int i2) {
        d.a.m0.r.c layoutMode = this.f57305a.getLayoutMode();
        layoutMode.k(i2 == 1);
        layoutMode.j(this.f57306b);
        NavigationBar navigationBar = this.f57307c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57305a, i2);
        }
        d.a.m0.r.f0.g gVar = this.f57312h;
        if (gVar != null) {
            gVar.I(i2);
        }
        a aVar = this.f57313i;
        if (aVar != null) {
            aVar.h(i2);
        }
        NoNetworkView noNetworkView = this.f57311g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f57305a, i2);
        }
    }

    public void h() {
        NoNetworkView noNetworkView = this.f57311g;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && d.a.c.e.p.j.z()) {
            this.f57311g.e(false);
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
        this.f57311g.d(bVar);
    }

    public void l() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.c();
        }
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        this.f57309e.setOnItemClickListener(onItemClickListener);
    }

    public void n() {
        this.f57313i.g();
    }

    public void o(f.g gVar) {
        this.f57312h.a(gVar);
    }

    public void p(BdListView.p pVar) {
        this.f57309e.setOnSrollToBottomListener(pVar);
    }

    public void q() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.d();
            d.a.c.e.m.g.j(this.j, this.f57305a);
        }
    }

    public void r() {
        a aVar = this.f57313i;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void s() {
        this.f57309e.F();
    }
}

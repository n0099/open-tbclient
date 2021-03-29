package d.b.i0.l0;

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
import d.b.h0.r.f0.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FaceShopActivity> f56578a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f56579b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f56580c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f56581d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f56582e;

    /* renamed from: f  reason: collision with root package name */
    public final m f56583f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f56584g;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.h0.r.f0.g f56585h;
    public final a i;
    public final h j;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.j.e.b {

        /* renamed from: f  reason: collision with root package name */
        public final TbPageContext<?> f56586f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f56587g = null;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f56588h = null;
        public View i = null;
        public View j;

        public a(n nVar, TbPageContext<?> tbPageContext) {
            this.f56586f = tbPageContext;
        }

        @Override // d.b.b.j.e.b
        public View a() {
            View inflate = LayoutInflater.from(this.f56586f.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.i = inflate;
            inflate.setPadding(0, this.f56586f.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f56586f.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.f56587g = (TextView) this.i.findViewById(R.id.pb_more_text);
            View findViewById = this.i.findViewById(R.id.pb_more_view);
            this.j = findViewById;
            findViewById.setVisibility(8);
            this.f56588h = (ProgressBar) this.i.findViewById(R.id.progress);
            h(TbadkApplication.getInst().getSkinType());
            this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.i;
        }

        @Override // d.b.b.j.e.b
        public void c() {
        }

        public void d() {
            this.i.setVisibility(0);
        }

        public void e() {
            this.i.setVisibility(8);
        }

        public void f() {
            this.f56588h.setVisibility(8);
            this.f56587g.setText(R.string.load_more);
        }

        public void g() {
            this.f56588h.setVisibility(0);
            this.f56587g.setText(this.f56586f.getPageActivity().getText(R.string.loading));
            this.j.setVisibility(0);
        }

        public void h(int i) {
            TbPageContext<?> tbPageContext = this.f56586f;
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i == 1);
                this.f56586f.getLayoutMode().j(this.j);
            }
        }
    }

    public n(TbPageContext<FaceShopActivity> tbPageContext) {
        this.f56578a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.f56579b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f56580c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.f56580c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f56580c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        this.f56581d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f56584g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.f56582e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.f56585h = new d.b.h0.r.f0.g(tbPageContext);
        this.f56583f = new m(tbPageContext.getOrignalPage());
        this.i = new a(this, tbPageContext);
        this.f56582e.setAdapter((ListAdapter) this.f56583f);
        this.f56582e.setPullRefresh(this.f56585h);
        this.f56582e.setNextPage(this.i);
        try {
            this.f56581d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.j = new h(tbPageContext, R.style.common_alert_dialog);
    }

    public void a(NoNetworkView.b bVar) {
        this.f56584g.a(bVar);
    }

    public void b() {
        this.i.f();
        this.f56582e.A(0L);
    }

    public m c() {
        return this.f56583f;
    }

    public TextView d() {
        return this.f56581d;
    }

    public void e() {
        h hVar = this.j;
        if (hVar != null) {
            d.b.b.e.m.g.b(hVar, this.f56578a);
        }
    }

    public void f() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void g(int i) {
        d.b.h0.r.c layoutMode = this.f56578a.getLayoutMode();
        layoutMode.k(i == 1);
        layoutMode.j(this.f56579b);
        NavigationBar navigationBar = this.f56580c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56578a, i);
        }
        d.b.h0.r.f0.g gVar = this.f56585h;
        if (gVar != null) {
            gVar.I(i);
        }
        a aVar = this.i;
        if (aVar != null) {
            aVar.h(i);
        }
        NoNetworkView noNetworkView = this.f56584g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f56578a, i);
        }
    }

    public void h() {
        NoNetworkView noNetworkView = this.f56584g;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && d.b.b.e.p.j.z()) {
            this.f56584g.e(false);
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
        this.f56584g.d(bVar);
    }

    public void l() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.c();
        }
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        this.f56582e.setOnItemClickListener(onItemClickListener);
    }

    public void n() {
        this.i.g();
    }

    public void o(f.g gVar) {
        this.f56585h.b(gVar);
    }

    public void p(BdListView.p pVar) {
        this.f56582e.setOnSrollToBottomListener(pVar);
    }

    public void q() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.d();
            d.b.b.e.m.g.j(this.j, this.f56578a);
        }
    }

    public void r() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void s() {
        this.f56582e.F();
    }
}

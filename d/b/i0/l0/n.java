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
    public final TbPageContext<FaceShopActivity> f57984a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f57985b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f57986c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f57987d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f57988e;

    /* renamed from: f  reason: collision with root package name */
    public final m f57989f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f57990g;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.h0.r.f0.g f57991h;
    public final a i;
    public final h j;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.j.e.b {

        /* renamed from: f  reason: collision with root package name */
        public final TbPageContext<?> f57992f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f57993g = null;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f57994h = null;
        public View i = null;
        public View j;

        public a(n nVar, TbPageContext<?> tbPageContext) {
            this.f57992f = tbPageContext;
        }

        @Override // d.b.c.j.e.b
        public View a() {
            View inflate = LayoutInflater.from(this.f57992f.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.i = inflate;
            inflate.setPadding(0, this.f57992f.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f57992f.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.f57993g = (TextView) this.i.findViewById(R.id.pb_more_text);
            View findViewById = this.i.findViewById(R.id.pb_more_view);
            this.j = findViewById;
            findViewById.setVisibility(8);
            this.f57994h = (ProgressBar) this.i.findViewById(R.id.progress);
            h(TbadkApplication.getInst().getSkinType());
            this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.i;
        }

        @Override // d.b.c.j.e.b
        public void c() {
        }

        public void d() {
            this.i.setVisibility(0);
        }

        public void e() {
            this.i.setVisibility(8);
        }

        public void f() {
            this.f57994h.setVisibility(8);
            this.f57993g.setText(R.string.load_more);
        }

        public void g() {
            this.f57994h.setVisibility(0);
            this.f57993g.setText(this.f57992f.getPageActivity().getText(R.string.loading));
            this.j.setVisibility(0);
        }

        public void h(int i) {
            TbPageContext<?> tbPageContext = this.f57992f;
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i == 1);
                this.f57992f.getLayoutMode().j(this.j);
            }
        }
    }

    public n(TbPageContext<FaceShopActivity> tbPageContext) {
        this.f57984a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.f57985b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f57986c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.f57986c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f57986c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        this.f57987d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f57990g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.f57988e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.f57991h = new d.b.h0.r.f0.g(tbPageContext);
        this.f57989f = new m(tbPageContext.getOrignalPage());
        this.i = new a(this, tbPageContext);
        this.f57988e.setAdapter((ListAdapter) this.f57989f);
        this.f57988e.setPullRefresh(this.f57991h);
        this.f57988e.setNextPage(this.i);
        try {
            this.f57987d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.j = new h(tbPageContext, R.style.common_alert_dialog);
    }

    public void a(NoNetworkView.b bVar) {
        this.f57990g.a(bVar);
    }

    public void b() {
        this.i.f();
        this.f57988e.A(0L);
    }

    public m c() {
        return this.f57989f;
    }

    public TextView d() {
        return this.f57987d;
    }

    public void e() {
        h hVar = this.j;
        if (hVar != null) {
            d.b.c.e.m.g.b(hVar, this.f57984a);
        }
    }

    public void f() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void g(int i) {
        d.b.h0.r.c layoutMode = this.f57984a.getLayoutMode();
        layoutMode.k(i == 1);
        layoutMode.j(this.f57985b);
        NavigationBar navigationBar = this.f57986c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57984a, i);
        }
        d.b.h0.r.f0.g gVar = this.f57991h;
        if (gVar != null) {
            gVar.I(i);
        }
        a aVar = this.i;
        if (aVar != null) {
            aVar.h(i);
        }
        NoNetworkView noNetworkView = this.f57990g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f57984a, i);
        }
    }

    public void h() {
        NoNetworkView noNetworkView = this.f57990g;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && d.b.c.e.p.j.z()) {
            this.f57990g.e(false);
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
        this.f57990g.d(bVar);
    }

    public void l() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.c();
        }
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        this.f57988e.setOnItemClickListener(onItemClickListener);
    }

    public void n() {
        this.i.g();
    }

    public void o(f.g gVar) {
        this.f57991h.b(gVar);
    }

    public void p(BdListView.p pVar) {
        this.f57988e.setOnSrollToBottomListener(pVar);
    }

    public void q() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.d();
            d.b.c.e.m.g.j(this.j, this.f57984a);
        }
    }

    public void r() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void s() {
        this.f57988e.F();
    }
}

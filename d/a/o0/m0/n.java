package d.a.o0.m0;

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
import d.a.n0.r.f0.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FaceShopActivity> f61119a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f61120b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f61121c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f61122d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f61123e;

    /* renamed from: f  reason: collision with root package name */
    public final m f61124f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f61125g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.n0.r.f0.g f61126h;

    /* renamed from: i  reason: collision with root package name */
    public final a f61127i;
    public final h j;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.k.e.b {

        /* renamed from: f  reason: collision with root package name */
        public final TbPageContext<?> f61128f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61129g = null;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f61130h = null;

        /* renamed from: i  reason: collision with root package name */
        public View f61131i = null;
        public View j;

        public a(n nVar, TbPageContext<?> tbPageContext) {
            this.f61128f = tbPageContext;
        }

        @Override // d.a.c.k.e.b
        public View a() {
            View inflate = LayoutInflater.from(this.f61128f.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.f61131i = inflate;
            inflate.setPadding(0, this.f61128f.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f61128f.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.f61129g = (TextView) this.f61131i.findViewById(R.id.pb_more_text);
            View findViewById = this.f61131i.findViewById(R.id.pb_more_view);
            this.j = findViewById;
            findViewById.setVisibility(8);
            this.f61130h = (ProgressBar) this.f61131i.findViewById(R.id.progress);
            h(TbadkApplication.getInst().getSkinType());
            this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.f61131i;
        }

        @Override // d.a.c.k.e.b
        public void c() {
        }

        public void d() {
            this.f61131i.setVisibility(0);
        }

        public void e() {
            this.f61131i.setVisibility(8);
        }

        public void f() {
            this.f61130h.setVisibility(8);
            this.f61129g.setText(R.string.load_more);
        }

        public void g() {
            this.f61130h.setVisibility(0);
            this.f61129g.setText(this.f61128f.getPageActivity().getText(R.string.loading));
            this.j.setVisibility(0);
        }

        public void h(int i2) {
            TbPageContext<?> tbPageContext = this.f61128f;
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i2 == 1);
                this.f61128f.getLayoutMode().j(this.j);
            }
        }
    }

    public n(TbPageContext<FaceShopActivity> tbPageContext) {
        this.f61119a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.f61120b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f61121c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.f61121c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f61121c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        this.f61122d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f61125g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.f61123e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.f61126h = new d.a.n0.r.f0.g(tbPageContext);
        this.f61124f = new m(tbPageContext.getOrignalPage());
        this.f61127i = new a(this, tbPageContext);
        this.f61123e.setAdapter((ListAdapter) this.f61124f);
        this.f61123e.setPullRefresh(this.f61126h);
        this.f61123e.setNextPage(this.f61127i);
        try {
            this.f61122d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.j = new h(tbPageContext, R.style.common_alert_dialog);
    }

    public void a(NoNetworkView.b bVar) {
        this.f61125g.a(bVar);
    }

    public void b() {
        this.f61127i.f();
        this.f61123e.A(0L);
    }

    public m c() {
        return this.f61124f;
    }

    public TextView d() {
        return this.f61122d;
    }

    public void e() {
        h hVar = this.j;
        if (hVar != null) {
            d.a.c.e.m.g.b(hVar, this.f61119a);
        }
    }

    public void f() {
        a aVar = this.f61127i;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void g(int i2) {
        d.a.n0.r.c layoutMode = this.f61119a.getLayoutMode();
        layoutMode.k(i2 == 1);
        layoutMode.j(this.f61120b);
        NavigationBar navigationBar = this.f61121c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f61119a, i2);
        }
        d.a.n0.r.f0.g gVar = this.f61126h;
        if (gVar != null) {
            gVar.I(i2);
        }
        a aVar = this.f61127i;
        if (aVar != null) {
            aVar.h(i2);
        }
        NoNetworkView noNetworkView = this.f61125g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f61119a, i2);
        }
    }

    public void h() {
        NoNetworkView noNetworkView = this.f61125g;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && d.a.c.e.p.j.z()) {
            this.f61125g.e(false);
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
        this.f61125g.d(bVar);
    }

    public void l() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.c();
        }
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        this.f61123e.setOnItemClickListener(onItemClickListener);
    }

    public void n() {
        this.f61127i.g();
    }

    public void o(f.g gVar) {
        this.f61126h.a(gVar);
    }

    public void p(BdListView.p pVar) {
        this.f61123e.setOnSrollToBottomListener(pVar);
    }

    public void q() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.d();
            d.a.c.e.m.g.j(this.j, this.f61119a);
        }
    }

    public void r() {
        a aVar = this.f61127i;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void s() {
        this.f61123e.F();
    }
}

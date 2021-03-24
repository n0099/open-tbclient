package d.b.i0.t.j.c;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import d.b.h0.d0.g;
import d.b.h0.d0.h;
import d.b.i0.t.j.d.e;
import d.b.i0.t.j.d.f;
import d.b.i0.t.j.d.j;
import d.b.i0.t.j.d.k;
import d.b.i0.t.j.d.l;
import d.b.i0.t.j.d.m;
import d.b.i0.t.j.d.n;
import d.b.i0.t.j.d.o;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a implements d.b.i0.t.j.f.a, d.b.i0.t.j.e.a {

    /* renamed from: a  reason: collision with root package name */
    public AlaPersonCenterModel f60841a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.t.j.d.c f60842b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.t.j.b.d f60843c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f60844d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f60845e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f60846f;

    /* renamed from: g  reason: collision with root package name */
    public View f60847g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f60848h;
    public g i;
    public boolean j;
    public int l;
    public ImageView m;
    public TextView n;
    public boolean o;
    public String p;
    public h q;
    public boolean k = true;
    public boolean r = false;
    public boolean s = false;

    /* renamed from: d.b.i0.t.j.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1567a implements View.OnClickListener {
        public View$OnClickListenerC1567a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.l();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.f60841a != null) {
                a.this.f60841a.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, a.this.f60844d.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AbsListView.OnScrollListener {
        public d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            a.this.v();
            a.this.u();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        this.l = 0;
        this.o = false;
        new b(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH);
        this.f60844d = tbPageContext;
        this.o = z;
        this.l = (int) tbPageContext.getResources().getDimension(R.dimen.ds400);
        AlaPersonCenterModel alaPersonCenterModel = new AlaPersonCenterModel(tbPageContext);
        this.f60841a = alaPersonCenterModel;
        alaPersonCenterModel.u(this);
        n(tbPageContext.getPageActivity());
    }

    @Override // d.b.i0.t.j.e.a
    public void a(int i) {
        if (i == 1) {
            this.s = true;
        }
    }

    @Override // d.b.i0.t.j.f.a
    public void b(int i, String str, Object obj) {
        g gVar = this.i;
        if (gVar != null) {
            gVar.dettachView(this.f60847g);
        }
        this.f60846f.setVisibility(0);
        BdTypeListView bdTypeListView = this.f60846f;
        if (bdTypeListView == null || !ListUtils.isEmpty(bdTypeListView.getData())) {
            return;
        }
        w();
    }

    @Override // d.b.i0.t.j.f.a
    public void c(Object obj, int i) {
        if (obj == null) {
            return;
        }
        j();
        if ((obj instanceof d.b.i0.t.j.d.c) && i == 1) {
            d.b.i0.t.j.d.c cVar = (d.b.i0.t.j.d.c) obj;
            this.f60842b = cVar;
            cVar.e(this.j);
            this.i.dettachView(this.f60847g);
            this.f60846f.setVisibility(0);
            h();
        }
    }

    public void h() {
        ArrayList arrayList;
        if (this.f60842b == null) {
            return;
        }
        if (this.j) {
            arrayList = new ArrayList(10);
            f fVar = new f();
            fVar.j(this.f60842b);
            arrayList.add(fVar);
            m mVar = new m();
            mVar.j(this.f60842b);
            arrayList.add(mVar);
            j jVar = new j();
            jVar.j(this.f60842b);
            arrayList.add(jVar);
            k kVar = new k();
            kVar.j(this.f60842b);
            arrayList.add(kVar);
            if (this.f60842b.f60862h != null) {
                d.b.i0.t.j.d.d dVar = new d.b.i0.t.j.d.d();
                dVar.j(this.f60842b);
                arrayList.add(dVar);
            }
            d.b.i0.t.j.d.h hVar = new d.b.i0.t.j.d.h();
            hVar.j(this.f60842b);
            arrayList.add(hVar);
            l lVar = new l();
            lVar.j(this.f60842b);
            arrayList.add(lVar);
            d.b.i0.t.j.d.g gVar = new d.b.i0.t.j.d.g();
            gVar.j(this.f60842b);
            arrayList.add(gVar);
            e eVar = new e();
            eVar.j(this.f60842b);
            arrayList.add(eVar);
            o oVar = new o();
            oVar.j(this.f60842b);
            arrayList.add(oVar);
            n nVar = new n();
            nVar.j(this.f60842b);
            arrayList.add(nVar);
        } else {
            arrayList = new ArrayList(4);
            f fVar2 = new f();
            fVar2.j(this.f60842b);
            arrayList.add(fVar2);
        }
        this.f60843c.b(arrayList);
    }

    public View i() {
        return this.f60847g;
    }

    public final void j() {
        h hVar = this.q;
        if (hVar != null && hVar.b().getParent() != null) {
            ((ViewGroup) this.q.b().getParent()).removeView(this.q.b());
        }
        this.r = false;
    }

    public void k(String str, String str2, String str3, boolean z) {
        this.f60841a.setUid(str);
        this.j = z;
    }

    public void l() {
        this.f60841a.t();
    }

    public void m(int i) {
        this.f60845e.onChangeSkinType(this.f60844d, i);
        this.f60845e.getBackground().mutate().setAlpha(0);
        TextView textView = this.f60845e.mTextTitle;
        int i2 = R.color.CAM_X0101;
        SkinManager.setNavbarTitleColor(textView, i2, i2);
        SkinManager.setNavbarIconSrc(this.m, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.f60846f.setDivider(SkinManager.getDrawable(i, R.color.CAM_X0204));
        this.f60846f.setDividerHeight(this.f60844d.getResources().getDimensionPixelSize(R.dimen.ds2));
        SkinManager.setBackgroundColor(this.f60847g, R.color.CAM_X0201);
        if (this.f60846f.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f60846f.getAdapter2().notifyDataSetChanged();
            g gVar = this.i;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            this.f60848h.c(this.f60844d, i);
            if (i == 1) {
                this.f60845e.getBarBgView().setBackgroundColor(this.f60844d.getResources().getColor(R.color.CAM_X0207_1));
                this.f60845e.getTopCoverBgView().setBackgroundColor(this.f60844d.getResources().getColor(R.color.CAM_X0201_1));
            } else if (i == 0) {
                this.f60845e.getBarBgView().setBackgroundColor(this.f60844d.getResources().getColor(R.color.CAM_X0207));
                this.f60845e.getTopCoverBgView().setBackgroundColor(this.f60844d.getResources().getColor(R.color.CAM_X0201));
            }
        }
    }

    public final void n(Context context) {
        View inflate = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.f60847g = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.ala_person_center_navigation_bar);
        this.f60845e = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.o) {
            addSystemImageButton.setOnClickListener(new c());
        }
        this.m = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.f60845e.showBottomLine(false);
        if (!this.o) {
            this.n = this.f60845e.setCenterTextTitle(this.f60844d.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.f60844d.getResources().getString(R.string.forum));
            this.n = this.f60845e.setCenterTextTitle(sb.toString());
        }
        this.f60848h = (NoNetworkView) this.f60847g.findViewById(R.id.ala_person_center_no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f60847g.findViewById(R.id.ala_person_center_listview);
        this.f60846f = bdTypeListView;
        bdTypeListView.setItemsCanFocus(true);
        this.f60846f.setVisibility(8);
        d.b.i0.t.j.b.d dVar = new d.b.i0.t.j.b.d(this.f60844d, this.f60846f, this);
        this.f60843c = dVar;
        dVar.f(this.o);
        if (this.o) {
            this.f60847g.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        g gVar = new g(this.f60844d.getPageActivity());
        this.i = gVar;
        gVar.attachView(this.f60847g, false);
        this.f60846f.setOnScrollListener(new d());
    }

    public void o() {
        g gVar = this.i;
        if (gVar != null) {
            gVar.m();
            this.i.dettachView(this.f60847g);
        }
        AlaPersonCenterModel alaPersonCenterModel = this.f60841a;
        if (alaPersonCenterModel != null) {
            alaPersonCenterModel.destory();
        }
    }

    public void p() {
        if (this.s) {
            this.s = false;
            l();
        }
    }

    public void q(float f2, boolean z) {
        if (!z && !this.r) {
            ImageView imageView = this.m;
            int i = R.drawable.icon_return_bg_s;
            SkinManager.setNavbarIconSrc(imageView, i, i);
            SkinManager.setNavbarTitleColor(this.n, R.color.CAM_X0105, R.color.s_navbar_title_color);
        } else {
            ImageView imageView2 = this.m;
            int i2 = R.drawable.icon_return_bg_s;
            SkinManager.setNavbarIconSrc(imageView2, i2, i2);
            SkinManager.setNavbarTitleColor(this.n, R.color.CAM_X0105, R.color.s_navbar_title_color);
        }
        this.n.setAlpha(f2);
        this.m.setAlpha(f2);
    }

    public void r(String str) {
        d.b.i0.t.j.b.d dVar = this.f60843c;
        if (dVar != null) {
            dVar.c(str);
        }
    }

    public void s(String str) {
        this.p = str;
        d.b.i0.t.j.b.d dVar = this.f60843c;
        if (dVar != null) {
            dVar.d(str);
        }
        if (!this.o) {
            this.n = this.f60845e.setCenterTextTitle(this.f60844d.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.f60844d.getResources().getString(R.string.forum));
        this.n = this.f60845e.setCenterTextTitle(sb.toString());
    }

    public void t(String str) {
        d.b.i0.t.j.b.d dVar = this.f60843c;
        if (dVar != null) {
            dVar.e(str);
        }
    }

    public final void u() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        float alpha = this.f60845e.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.k) {
                this.k = true;
            }
        } else if (this.k) {
            this.k = false;
        }
        q(alpha, !this.k);
    }

    public final void v() {
        if (Build.VERSION.SDK_INT < 11 || this.f60846f.getChildAt(0) == null) {
            return;
        }
        int dimension = (int) this.f60844d.getResources().getDimension(R.dimen.ds98);
        int i = this.l - (-this.f60846f.getChildAt(0).getTop());
        if (i < dimension) {
            if (this.f60845e.getBarBgView().getAlpha() != 1.0f) {
                this.f60845e.getBarBgView().setAlpha(1.0f);
                this.f60845e.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= dimension && i <= dimension * 2) {
            float f2 = 1.0f - (((i - dimension) * 1.0f) / dimension);
            this.f60845e.getBarBgView().setAlpha(f2);
            this.f60845e.getTopCoverBgView().setAlpha(1.0f - f2);
        } else if (i > dimension * 2 && this.f60845e.getBarBgView().getAlpha() != 0.0f) {
            this.f60845e.getBarBgView().setAlpha(0.0f);
            this.f60845e.getTopCoverBgView().setAlpha(1.0f);
        }
        if (this.f60846f.getFirstVisiblePosition() <= 0 || this.f60845e.getBarBgView().getAlpha() == 1.0f) {
            return;
        }
        this.f60845e.getBarBgView().setAlpha(1.0f);
        this.f60845e.getTopCoverBgView().setAlpha(0.0f);
    }

    public final void w() {
        if (this.q == null) {
            h hVar = new h(this.f60844d.getPageActivity(), new View$OnClickListenerC1567a());
            this.q = hVar;
            hVar.m(null);
            this.q.g(null);
            this.q.j(this.f60844d.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.q.o();
            this.q.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.q.l(null);
        this.q.m(this.f60844d.getResources().getString(R.string.refresh_view_title_text));
        this.q.onChangeSkinType();
        if (!this.r) {
            ((ViewGroup) this.f60847g).addView(this.q.b(), 0);
        }
        this.r = true;
    }
}

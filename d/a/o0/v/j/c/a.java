package d.a.o0.v.j.c;

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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import d.a.n0.d0.g;
import d.a.n0.d0.h;
import d.a.o0.v.j.d.e;
import d.a.o0.v.j.d.f;
import d.a.o0.v.j.d.j;
import d.a.o0.v.j.d.k;
import d.a.o0.v.j.d.l;
import d.a.o0.v.j.d.m;
import d.a.o0.v.j.d.n;
import d.a.o0.v.j.d.o;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a implements d.a.o0.v.j.f.a, d.a.o0.v.j.e.a {

    /* renamed from: a  reason: collision with root package name */
    public AlaPersonCenterModel f65877a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.v.j.d.c f65878b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.v.j.b.d f65879c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f65880d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f65881e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f65882f;

    /* renamed from: g  reason: collision with root package name */
    public View f65883g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f65884h;

    /* renamed from: i  reason: collision with root package name */
    public g f65885i;
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

    /* renamed from: d.a.o0.v.j.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1730a implements View.OnClickListener {
        public View$OnClickListenerC1730a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.l();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.f65877a != null) {
                a.this.f65877a.x();
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
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, a.this.f65880d.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AbsListView.OnScrollListener {
        public d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            a.this.v();
            a.this.u();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        this.l = 0;
        this.o = false;
        new b(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH);
        this.f65880d = tbPageContext;
        this.o = z;
        this.l = (int) tbPageContext.getResources().getDimension(R.dimen.ds400);
        AlaPersonCenterModel alaPersonCenterModel = new AlaPersonCenterModel(tbPageContext);
        this.f65877a = alaPersonCenterModel;
        alaPersonCenterModel.y(this);
        n(tbPageContext.getPageActivity());
    }

    @Override // d.a.o0.v.j.e.a
    public void a(int i2) {
        if (i2 == 1) {
            this.s = true;
        }
    }

    @Override // d.a.o0.v.j.f.a
    public void b(int i2, String str, Object obj) {
        g gVar = this.f65885i;
        if (gVar != null) {
            gVar.dettachView(this.f65883g);
        }
        this.f65882f.setVisibility(0);
        BdTypeListView bdTypeListView = this.f65882f;
        if (bdTypeListView == null || !ListUtils.isEmpty(bdTypeListView.getData())) {
            return;
        }
        w();
    }

    @Override // d.a.o0.v.j.f.a
    public void c(Object obj, int i2) {
        if (obj == null) {
            return;
        }
        j();
        if ((obj instanceof d.a.o0.v.j.d.c) && i2 == 1) {
            d.a.o0.v.j.d.c cVar = (d.a.o0.v.j.d.c) obj;
            this.f65878b = cVar;
            cVar.e(this.j);
            this.f65885i.dettachView(this.f65883g);
            this.f65882f.setVisibility(0);
            h();
        }
    }

    public void h() {
        ArrayList arrayList;
        if (this.f65878b == null) {
            return;
        }
        if (this.j) {
            arrayList = new ArrayList(10);
            f fVar = new f();
            fVar.g(this.f65878b);
            arrayList.add(fVar);
            if (TbSingleton.getInstance().isShowStartLiveEntry()) {
                m mVar = new m();
                mVar.g(this.f65878b);
                arrayList.add(mVar);
            }
            j jVar = new j();
            jVar.g(this.f65878b);
            arrayList.add(jVar);
            k kVar = new k();
            kVar.g(this.f65878b);
            arrayList.add(kVar);
            if (this.f65878b.f65899h != null) {
                d.a.o0.v.j.d.d dVar = new d.a.o0.v.j.d.d();
                dVar.g(this.f65878b);
                arrayList.add(dVar);
            }
            d.a.o0.v.j.d.h hVar = new d.a.o0.v.j.d.h();
            hVar.g(this.f65878b);
            arrayList.add(hVar);
            l lVar = new l();
            lVar.g(this.f65878b);
            arrayList.add(lVar);
            d.a.o0.v.j.d.g gVar = new d.a.o0.v.j.d.g();
            gVar.g(this.f65878b);
            arrayList.add(gVar);
            e eVar = new e();
            eVar.g(this.f65878b);
            arrayList.add(eVar);
            o oVar = new o();
            oVar.g(this.f65878b);
            arrayList.add(oVar);
            n nVar = new n();
            nVar.g(this.f65878b);
            arrayList.add(nVar);
        } else {
            arrayList = new ArrayList(4);
            f fVar2 = new f();
            fVar2.g(this.f65878b);
            arrayList.add(fVar2);
        }
        this.f65879c.b(arrayList);
    }

    public View i() {
        return this.f65883g;
    }

    public final void j() {
        h hVar = this.q;
        if (hVar != null && hVar.b().getParent() != null) {
            ((ViewGroup) this.q.b().getParent()).removeView(this.q.b());
        }
        this.r = false;
    }

    public void k(String str, String str2, String str3, boolean z) {
        this.f65877a.setUid(str);
        this.j = z;
    }

    public void l() {
        this.f65877a.x();
    }

    public void m(int i2) {
        this.f65881e.onChangeSkinType(this.f65880d, i2);
        this.f65881e.getBackground().mutate().setAlpha(0);
        TextView textView = this.f65881e.mTextTitle;
        int i3 = R.color.CAM_X0101;
        SkinManager.setNavbarTitleColor(textView, i3, i3);
        SkinManager.setNavbarIconSrc(this.m, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.f65882f.setDivider(SkinManager.getDrawable(i2, R.color.CAM_X0204));
        this.f65882f.setDividerHeight(this.f65880d.getResources().getDimensionPixelSize(R.dimen.ds2));
        SkinManager.setBackgroundColor(this.f65883g, R.color.CAM_X0201);
        if (this.f65882f.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f65882f.getAdapter2().notifyDataSetChanged();
            g gVar = this.f65885i;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            this.f65884h.c(this.f65880d, i2);
            if (i2 == 1) {
                this.f65881e.getBarBgView().setBackgroundColor(this.f65880d.getResources().getColor(R.color.CAM_X0207_1));
                this.f65881e.getTopCoverBgView().setBackgroundColor(this.f65880d.getResources().getColor(R.color.CAM_X0201_1));
            } else if (i2 == 0) {
                this.f65881e.getBarBgView().setBackgroundColor(this.f65880d.getResources().getColor(R.color.CAM_X0207));
                this.f65881e.getTopCoverBgView().setBackgroundColor(this.f65880d.getResources().getColor(R.color.CAM_X0201));
            }
        }
    }

    public final void n(Context context) {
        View inflate = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.f65883g = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.ala_person_center_navigation_bar);
        this.f65881e = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.o) {
            addSystemImageButton.setOnClickListener(new c());
        }
        this.m = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.f65881e.showBottomLine(false);
        if (!this.o) {
            this.n = this.f65881e.setCenterTextTitle(this.f65880d.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.f65880d.getResources().getString(R.string.forum));
            this.n = this.f65881e.setCenterTextTitle(sb.toString());
        }
        this.f65884h = (NoNetworkView) this.f65883g.findViewById(R.id.ala_person_center_no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f65883g.findViewById(R.id.ala_person_center_listview);
        this.f65882f = bdTypeListView;
        bdTypeListView.setItemsCanFocus(true);
        this.f65882f.setVisibility(8);
        d.a.o0.v.j.b.d dVar = new d.a.o0.v.j.b.d(this.f65880d, this.f65882f, this);
        this.f65879c = dVar;
        dVar.f(this.o);
        if (this.o) {
            this.f65883g.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        g gVar = new g(this.f65880d.getPageActivity());
        this.f65885i = gVar;
        gVar.attachView(this.f65883g, false);
        this.f65882f.setOnScrollListener(new d());
    }

    public void o() {
        g gVar = this.f65885i;
        if (gVar != null) {
            gVar.m();
            this.f65885i.dettachView(this.f65883g);
        }
        AlaPersonCenterModel alaPersonCenterModel = this.f65877a;
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
            int i2 = R.drawable.icon_return_bg_s;
            SkinManager.setNavbarIconSrc(imageView, i2, i2);
            SkinManager.setNavbarTitleColor(this.n, R.color.CAM_X0105, R.color.s_navbar_title_color);
        } else {
            ImageView imageView2 = this.m;
            int i3 = R.drawable.icon_return_bg_s;
            SkinManager.setNavbarIconSrc(imageView2, i3, i3);
            SkinManager.setNavbarTitleColor(this.n, R.color.CAM_X0105, R.color.s_navbar_title_color);
        }
        this.n.setAlpha(f2);
        this.m.setAlpha(f2);
    }

    public void r(String str) {
        d.a.o0.v.j.b.d dVar = this.f65879c;
        if (dVar != null) {
            dVar.c(str);
        }
    }

    public void s(String str) {
        this.p = str;
        d.a.o0.v.j.b.d dVar = this.f65879c;
        if (dVar != null) {
            dVar.d(str);
        }
        if (!this.o) {
            this.n = this.f65881e.setCenterTextTitle(this.f65880d.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.f65880d.getResources().getString(R.string.forum));
        this.n = this.f65881e.setCenterTextTitle(sb.toString());
    }

    public void t(String str) {
        d.a.o0.v.j.b.d dVar = this.f65879c;
        if (dVar != null) {
            dVar.e(str);
        }
    }

    public final void u() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        float alpha = this.f65881e.getBarBgView().getAlpha();
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
        if (Build.VERSION.SDK_INT < 11 || this.f65882f.getChildAt(0) == null) {
            return;
        }
        int dimension = (int) this.f65880d.getResources().getDimension(R.dimen.ds98);
        int i2 = this.l - (-this.f65882f.getChildAt(0).getTop());
        if (i2 < dimension) {
            if (this.f65881e.getBarBgView().getAlpha() != 1.0f) {
                this.f65881e.getBarBgView().setAlpha(1.0f);
                this.f65881e.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i2 >= dimension && i2 <= dimension * 2) {
            float f2 = 1.0f - (((i2 - dimension) * 1.0f) / dimension);
            this.f65881e.getBarBgView().setAlpha(f2);
            this.f65881e.getTopCoverBgView().setAlpha(1.0f - f2);
        } else if (i2 > dimension * 2 && this.f65881e.getBarBgView().getAlpha() != 0.0f) {
            this.f65881e.getBarBgView().setAlpha(0.0f);
            this.f65881e.getTopCoverBgView().setAlpha(1.0f);
        }
        if (this.f65882f.getFirstVisiblePosition() <= 0 || this.f65881e.getBarBgView().getAlpha() == 1.0f) {
            return;
        }
        this.f65881e.getBarBgView().setAlpha(1.0f);
        this.f65881e.getTopCoverBgView().setAlpha(0.0f);
    }

    public final void w() {
        if (this.q == null) {
            h hVar = new h(this.f65880d.getPageActivity(), new View$OnClickListenerC1730a());
            this.q = hVar;
            hVar.m(null);
            this.q.g(null);
            this.q.j(this.f65880d.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.q.o();
            this.q.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.q.l(null);
        this.q.m(this.f65880d.getResources().getString(R.string.refresh_view_title_text));
        this.q.onChangeSkinType();
        if (!this.r) {
            ((ViewGroup) this.f65883g).addView(this.q.b(), 0);
        }
        this.r = true;
    }
}

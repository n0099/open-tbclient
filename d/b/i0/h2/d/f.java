package d.b.i0.h2.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class f extends d.b.i0.h2.d.e {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f55214f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f55215g;

    /* renamed from: h  reason: collision with root package name */
    public View f55216h;
    public d.b.h0.d0.h i;
    public e j;
    public PbListView k;
    public NoNetworkView l;
    public PluginErrorTipView m;
    public ImageView n;
    public d.b.h0.d0.g o;
    public int p;
    public LinearLayout q;
    public FrameLayout r;
    public NoNetworkView s;
    public RelativeLayout t;
    public d.b.i0.h2.j.k u;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(f.this.f55214f.getPageActivity(), "notlogin_10", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            ViewHelper.skipToLoginActivity(f.this.f55214f.getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.b.b.e.p.j.A()) {
                f.this.o();
                f.this.E(true);
                if (f.this.j != null) {
                    f.this.j.a(view);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(f.this.f55214f.getPageActivity(), null, d.b.i0.c2.c.a(), true)));
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public d.b.i0.h2.f.b f55220e = new d.b.i0.h2.f.b();

        /* renamed from: f  reason: collision with root package name */
        public UserData f55221f;

        /* renamed from: g  reason: collision with root package name */
        public d.b.i0.t3.f f55222g;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserData userData = this.f55221f;
            if (userData == null || !userData.isBaijiahaoUser()) {
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "3"));
                d.b.i0.h2.f.b bVar = this.f55220e;
                bVar.f56402a = 10;
                bVar.f56403b = new Bundle();
                this.f55220e.f56403b.putSerializable(UserData.TYPE_USER, this.f55221f);
                d.b.i0.t3.f fVar = this.f55222g;
                if (fVar != null) {
                    fVar.a(view, this.f55220e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        new d();
        this.p = 3;
        if (tbPageContext == null || view == null) {
            return;
        }
        this.f55214f = tbPageContext;
        this.f55216h = view;
        this.l = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.m = (PluginErrorTipView) this.f55216h.findViewById(R.id.person_center_plugin_error_tip_view);
        this.q = (LinearLayout) this.f55216h.findViewById(R.id.person_center_anti_container);
        d.b.i0.h2.j.k kVar = new d.b.i0.h2.j.k(this.f55214f, this.f55216h.findViewById(R.id.person_center_anti_navigation_bar), this.f55216h.findViewById(R.id.person_center_anti_status_bar_space), z);
        this.u = kVar;
        kVar.k(PersonStatus.GUEST_DEFAULT);
        this.r = (FrameLayout) this.f55216h.findViewById(R.id.person_center_anti_content);
        this.s = (NoNetworkView) this.f55216h.findViewById(R.id.person_center_anti_no_network_view);
        this.t = (RelativeLayout) this.f55216h.findViewById(R.id.person_center_noanti_rootview);
        PbListView pbListView = new PbListView(this.f55214f.getPageActivity());
        this.k = pbListView;
        pbListView.b();
        this.k.C(SkinManager.getColor(R.color.CAM_X0109));
        this.k.y(R.color.CAM_X0110);
        this.k.o(R.color.CAM_X0201);
        this.k.r(l.g(this.f55214f.getPageActivity(), R.dimen.ds140));
        this.k.p(l.g(this.f55214f.getPageActivity(), R.dimen.ds12));
        this.k.x();
        this.k.u(R.color.CAM_X0205);
        r(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(boolean z, List<n> list) {
    }

    public void B() {
        if (this.r == null) {
            return;
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.q.setVisibility(0);
        int dimensionPixelSize = this.f55214f.getResources().getDimensionPixelSize(R.dimen.ds220);
        int dimensionPixelSize2 = this.f55214f.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.f55214f.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.f55214f.getResources().getDimensionPixelSize(R.dimen.ds60);
        int dimensionPixelSize5 = this.f55214f.getResources().getDimensionPixelSize(R.dimen.ds20);
        NoDataView a2 = NoDataViewFactory.a(this.f55214f.getPageActivity(), this.r, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.e(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.c.b(new NoDataViewFactory.b(this.f55214f.getString(R.string.unlogin_person_button_text), new a()), dimensionPixelSize5));
        this.f55215g = a2;
        a2.setVisibility(0);
        this.f55215g.f(this.f55214f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void E(boolean z) {
        if (z) {
            z();
        }
    }

    public void k(d.b.i0.h2.e.a aVar) {
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
        d.b.h0.d0.g gVar = this.o;
        if (gVar != null) {
            gVar.dettachView(this.f55216h);
            this.o = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
    }

    public void o() {
        d.b.h0.d0.h hVar = this.i;
        if (hVar != null) {
            hVar.dettachView(this.r);
            this.i = null;
        }
    }

    public void p() {
    }

    public boolean q() {
        d.b.h0.d0.h hVar = this.i;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void r(int i) {
        if (this.p == i) {
            return;
        }
        NoDataView noDataView = this.f55215g;
        if (noDataView != null) {
            noDataView.f(this.f55214f, i);
        }
        NoNetworkView noNetworkView = this.s;
        if (noNetworkView != null) {
            noNetworkView.c(this.f55214f, i);
        }
        d.b.i0.h2.j.k kVar = this.u;
        if (kVar != null) {
            kVar.g(i);
        }
        SkinManager.setBackgroundResource(this.f55216h, R.color.CAM_X0201);
        d.b.h0.d0.h hVar = this.i;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.p = i;
    }

    public void s(int i) {
        this.t.setVisibility(i);
    }

    public void u(e eVar) {
        this.j = eVar;
    }

    public void v(boolean z) {
        this.t.setVisibility(8);
        int dimensionPixelSize = this.f55214f.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.f55215g == null) {
            this.f55215g = NoDataViewFactory.a(this.f55214f.getPageActivity(), this.f55216h, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.e.d(null, this.f55214f.getString(R.string.user_to_anti)), null);
        }
        SkinManager.setViewTextColor(this.f55215g.getSuTextView(), R.color.CAM_X0106);
        this.f55215g.f(this.f55214f, TbadkCoreApplication.getInst().getSkinType());
        this.f55215g.setVisibility(0);
    }

    public void w(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void x(boolean z, int i) {
        if (this.o == null) {
            if (i < 0) {
                this.o = new d.b.h0.d0.g(this.f55214f.getContext());
            } else {
                this.o = new d.b.h0.d0.g(this.f55214f.getContext(), i);
            }
            this.o.onChangeSkinType();
        }
        this.o.attachView(this.f55216h, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
    }

    public void y(String str, boolean z) {
        if (q()) {
            return;
        }
        this.q.setVisibility(0);
        if (this.i == null) {
            this.i = new d.b.h0.d0.h(this.f55214f.getPageActivity(), new b());
        }
        this.i.h(R.drawable.new_pic_emotion_08);
        this.i.attachView(this.r, z);
        this.i.o();
        this.i.onChangeSkinType();
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void z() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.n == null) {
                ImageView imageView = new ImageView(this.f55214f.getPageActivity());
                this.n = imageView;
                imageView.setImageResource(R.drawable.icon_nichengjun);
                this.n.setOnClickListener(new c());
            }
            if (this.n.getParent() != null) {
                ((ViewGroup) this.n.getParent()).removeView(this.n);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.g(this.f55214f.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.g(this.f55214f.getPageActivity(), R.dimen.ds26);
            View view = this.f55216h;
            if (view instanceof RelativeLayout) {
                ((RelativeLayout) view).addView(this.n, layoutParams);
                return;
            }
            return;
        }
        ImageView imageView2 = this.n;
        if (imageView2 == null || imageView2.getParent() == null) {
            return;
        }
        ViewParent parent = this.n.getParent();
        View view2 = this.f55216h;
        if (parent == view2) {
            ((RelativeLayout) view2).removeView(this.n);
        }
    }
}

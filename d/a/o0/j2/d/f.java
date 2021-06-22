package d.a.o0.j2.d;

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
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class f extends d.a.o0.j2.d.e {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f60140f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f60141g;

    /* renamed from: h  reason: collision with root package name */
    public View f60142h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.d0.h f60143i;
    public e j;
    public PbListView k;
    public NoNetworkView l;
    public PluginErrorTipView m;
    public ImageView n;
    public d.a.n0.d0.g o;
    public int p;
    public LinearLayout q;
    public FrameLayout r;
    public NoNetworkView s;
    public RelativeLayout t;
    public d.a.o0.j2.j.k u;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(f.this.f60140f.getPageActivity(), "notlogin_10", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            ViewHelper.skipToLoginActivity(f.this.f60140f.getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.j.A()) {
                f.this.o();
                f.this.B(true);
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(f.this.f60140f.getPageActivity(), null, d.a.o0.e2.c.a(), true)));
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public d.a.o0.j2.f.b f60147e = new d.a.o0.j2.f.b();

        /* renamed from: f  reason: collision with root package name */
        public UserData f60148f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.o0.v3.f f60149g;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserData userData = this.f60148f;
            if (userData == null || !userData.isBaijiahaoUser()) {
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "3"));
                d.a.o0.j2.f.b bVar = this.f60147e;
                bVar.f60400a = 10;
                bVar.f60401b = new Bundle();
                this.f60147e.f60401b.putSerializable(UserData.TYPE_USER, this.f60148f);
                d.a.o0.v3.f fVar = this.f60149g;
                if (fVar != null) {
                    fVar.a(view, this.f60147e);
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
        this.f60140f = tbPageContext;
        this.f60142h = view;
        this.l = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.m = (PluginErrorTipView) this.f60142h.findViewById(R.id.person_center_plugin_error_tip_view);
        this.q = (LinearLayout) this.f60142h.findViewById(R.id.person_center_anti_container);
        d.a.o0.j2.j.k kVar = new d.a.o0.j2.j.k(this.f60140f, this.f60142h.findViewById(R.id.person_center_anti_navigation_bar), this.f60142h.findViewById(R.id.person_center_anti_status_bar_space), z);
        this.u = kVar;
        kVar.k(PersonStatus.GUEST_DEFAULT);
        this.r = (FrameLayout) this.f60142h.findViewById(R.id.person_center_anti_content);
        this.s = (NoNetworkView) this.f60142h.findViewById(R.id.person_center_anti_no_network_view);
        this.t = (RelativeLayout) this.f60142h.findViewById(R.id.person_center_noanti_rootview);
        PbListView pbListView = new PbListView(this.f60140f.getPageActivity());
        this.k = pbListView;
        pbListView.b();
        this.k.C(SkinManager.getColor(R.color.CAM_X0109));
        this.k.y(R.color.CAM_X0110);
        this.k.o(R.color.CAM_X0201);
        this.k.r(l.g(this.f60140f.getPageActivity(), R.dimen.ds140));
        this.k.p(l.g(this.f60140f.getPageActivity(), R.dimen.ds12));
        this.k.x();
        this.k.u(R.color.CAM_X0205);
        r(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A() {
        if (this.r == null) {
            return;
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.q.setVisibility(0);
        int dimensionPixelSize = this.f60140f.getResources().getDimensionPixelSize(R.dimen.ds220);
        int dimensionPixelSize2 = this.f60140f.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.f60140f.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.f60140f.getResources().getDimensionPixelSize(R.dimen.ds60);
        int dimensionPixelSize5 = this.f60140f.getResources().getDimensionPixelSize(R.dimen.ds20);
        NoDataView a2 = NoDataViewFactory.a(this.f60140f.getPageActivity(), this.r, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.e(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.c.b(new NoDataViewFactory.b(this.f60140f.getString(R.string.unlogin_person_button_text), new a()), dimensionPixelSize5));
        this.f60141g = a2;
        a2.setVisibility(0);
        this.f60141g.f(this.f60140f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void B(boolean z) {
        if (z) {
            y();
        }
    }

    public void k(d.a.o0.j2.e.a aVar) {
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
        d.a.n0.d0.g gVar = this.o;
        if (gVar != null) {
            gVar.dettachView(this.f60142h);
            this.o = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
    }

    public void o() {
        d.a.n0.d0.h hVar = this.f60143i;
        if (hVar != null) {
            hVar.dettachView(this.r);
            this.f60143i = null;
        }
    }

    public void p() {
    }

    public boolean q() {
        d.a.n0.d0.h hVar = this.f60143i;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void r(int i2) {
        if (this.p == i2) {
            return;
        }
        NoDataView noDataView = this.f60141g;
        if (noDataView != null) {
            noDataView.f(this.f60140f, i2);
        }
        NoNetworkView noNetworkView = this.s;
        if (noNetworkView != null) {
            noNetworkView.c(this.f60140f, i2);
        }
        d.a.o0.j2.j.k kVar = this.u;
        if (kVar != null) {
            kVar.g(i2);
        }
        SkinManager.setBackgroundResource(this.f60142h, R.color.CAM_X0201);
        d.a.n0.d0.h hVar = this.f60143i;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.p = i2;
    }

    public void s(int i2) {
        this.t.setVisibility(i2);
    }

    public void t(e eVar) {
        this.j = eVar;
    }

    public void u(boolean z) {
        this.t.setVisibility(8);
        int dimensionPixelSize = this.f60140f.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.f60141g == null) {
            this.f60141g = NoDataViewFactory.a(this.f60140f.getPageActivity(), this.f60142h, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.e.d(null, this.f60140f.getString(R.string.user_to_anti)), null);
        }
        SkinManager.setViewTextColor(this.f60141g.getSuTextView(), R.color.CAM_X0106);
        this.f60141g.f(this.f60140f, TbadkCoreApplication.getInst().getSkinType());
        this.f60141g.setVisibility(0);
    }

    public void v(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void w(boolean z, int i2) {
        if (this.o == null) {
            if (i2 < 0) {
                this.o = new d.a.n0.d0.g(this.f60140f.getContext());
            } else {
                this.o = new d.a.n0.d0.g(this.f60140f.getContext(), i2);
            }
            this.o.onChangeSkinType();
        }
        this.o.attachView(this.f60142h, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
    }

    public void x(String str, boolean z) {
        if (q()) {
            return;
        }
        this.q.setVisibility(0);
        if (this.f60143i == null) {
            this.f60143i = new d.a.n0.d0.h(this.f60140f.getPageActivity(), new b());
        }
        this.f60143i.h(R.drawable.new_pic_emotion_08);
        this.f60143i.attachView(this.r, z);
        this.f60143i.o();
        this.f60143i.onChangeSkinType();
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void y() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.n == null) {
                ImageView imageView = new ImageView(this.f60140f.getPageActivity());
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
            layoutParams.topMargin = l.g(this.f60140f.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.g(this.f60140f.getPageActivity(), R.dimen.ds26);
            View view = this.f60142h;
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
        View view2 = this.f60142h;
        if (parent == view2) {
            ((RelativeLayout) view2).removeView(this.n);
        }
    }

    public void z(boolean z, List<n> list) {
    }
}

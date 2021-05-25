package d.a.n0.w2.c;

import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MoreActivity;
import com.baidu.tieba.setting.more.SettingTextImageView;
import com.baidu.tieba.setting.more.SettingTextNormalImageView;
import com.baidu.tieba.setting.more.SettingTextVersionView;
import com.baidu.tieba.setting.more.TbSettingTextNewDotView;
import d.a.m0.r.s.j;
import d.a.m0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e extends d.a.c.a.d<MoreActivity> {
    public View A;
    public RelativeLayout B;
    public BdSwitchView C;
    public RelativeLayout D;
    public BdSwitchView E;

    /* renamed from: a  reason: collision with root package name */
    public MoreActivity f62580a;

    /* renamed from: b  reason: collision with root package name */
    public d f62581b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62582c;

    /* renamed from: d  reason: collision with root package name */
    public j f62583d;

    /* renamed from: e  reason: collision with root package name */
    public l f62584e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextNormalImageView f62585f;

    /* renamed from: g  reason: collision with root package name */
    public SettingTextImageView f62586g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f62587h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f62588i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TbSettingTextTipView m;
    public TbSettingTextTipView n;
    public SettingTextVersionView o;
    public TbSettingTextTipView p;
    public TbSettingTextTipView q;
    public TbSettingTextNewDotView r;
    public TextView s;
    public RelativeLayout t;
    public View u;
    public View v;
    public View w;
    public View x;
    public View y;
    public View z;

    /* loaded from: classes5.dex */
    public class a implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.h f62589e;

        public a(d.a.m0.r.s.h hVar) {
            this.f62589e = hVar;
        }

        @Override // d.a.m0.r.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            if (i2 == this.f62589e.f()) {
                e.this.w();
                e.this.f62581b.a(12);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements l.c {
        public b() {
        }

        @Override // d.a.m0.r.s.l.c
        public void onClick() {
            e.this.w();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == e.this.v) {
                e.this.f62581b.a(0);
            } else if (view == e.this.f62586g) {
                e.this.f62581b.a(1);
            } else if (view == e.this.f62587h) {
                e.this.f62581b.a(15);
            } else if (view == e.this.f62588i) {
                e.this.f62581b.a(2);
            } else if (view == e.this.j) {
                e.this.f62581b.a(3);
            } else if (view == e.this.k) {
                e.this.f62581b.a(17);
            } else if (view == e.this.m) {
                e.this.f62581b.a(4);
            } else if (view == e.this.n) {
                e.this.f62581b.a(9);
            } else if (view == e.this.o) {
                e.this.f62581b.a(6);
            } else if (view == e.this.p) {
                e.this.f62581b.a(7);
            } else if (view == e.this.q) {
                e.this.f62581b.a(8);
            } else if (view == e.this.r) {
                e.this.f62581b.a(5);
            } else if (view == e.this.s) {
                e.this.f62581b.a(10);
            } else if (view == e.this.f62585f) {
                e.this.f62581b.a(13);
            } else if (view == e.this.l) {
                e.this.f62581b.a(16);
            }
        }
    }

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.f62580a = moreActivity;
        this.f62581b = dVar;
        moreActivity.setContentView(R.layout.more_activity);
        F();
        P();
    }

    public BdSwitchView A() {
        return this.E;
    }

    public final void B(View.OnClickListener onClickListener) {
        this.f62585f.setOnClickListener(onClickListener);
        this.v.setOnClickListener(onClickListener);
        this.f62586g.setOnClickListener(onClickListener);
        this.f62587h.setOnClickListener(onClickListener);
        this.f62588i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
        this.m.setOnClickListener(onClickListener);
        this.n.setOnClickListener(onClickListener);
        this.o.setOnClickListener(onClickListener);
        this.p.setOnClickListener(onClickListener);
        this.q.setOnClickListener(onClickListener);
        this.r.setOnClickListener(onClickListener);
        this.s.setOnClickListener(onClickListener);
        this.C.setOnSwitchStateChangeListener(this.f62580a);
        this.E.setOnSwitchStateChangeListener(this.f62580a);
    }

    public final void F() {
        View.OnClickListener z = z();
        this.t = (RelativeLayout) this.f62580a.findViewById(R.id.parent);
        this.u = this.f62580a.findViewById(R.id.scroll);
        this.f62580a.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        NavigationBar navigationBar = (NavigationBar) this.f62580a.findViewById(R.id.view_navigation_bar);
        this.f62582c = navigationBar;
        this.v = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62582c.setCenterTextTitle(this.f62580a.getPageContext().getString(R.string.setup));
        this.f62582c.showBottomLine();
        this.f62585f = (SettingTextNormalImageView) this.f62580a.findViewById(R.id.accountSafeSetting);
        this.f62586g = (SettingTextImageView) this.f62580a.findViewById(R.id.personInfo);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f62580a.findViewById(R.id.interest_label_setting);
        this.f62587h = tbSettingTextTipView;
        tbSettingTextTipView.setTopLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f62580a.findViewById(R.id.accountManager);
        this.f62588i = tbSettingTextTipView2;
        tbSettingTextTipView2.setTopLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f62580a.findViewById(R.id.browseSetting);
        this.j = tbSettingTextTipView3;
        tbSettingTextTipView3.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f62580a.findViewById(R.id.youngsterSetting);
        this.k = tbSettingTextTipView4;
        tbSettingTextTipView4.setBottomLineVisibility(true);
        if (d.a.m0.c1.b.e.d()) {
            this.k.setTip(this.f62580a.getString(R.string.youngster_settings_tip_open));
        } else {
            this.k.setTip(this.f62580a.getString(R.string.youngster_settings_tip_close));
        }
        TbSettingTextTipView tbSettingTextTipView5 = (TbSettingTextTipView) this.f62580a.findViewById(R.id.adSetting);
        this.l = tbSettingTextTipView5;
        tbSettingTextTipView5.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView6 = (TbSettingTextTipView) this.f62580a.findViewById(R.id.messageSetting);
        this.m = tbSettingTextTipView6;
        tbSettingTextTipView6.setBottomLineVisibility(true);
        this.j.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView7 = (TbSettingTextTipView) this.f62580a.findViewById(R.id.secretSetting);
        this.n = tbSettingTextTipView7;
        tbSettingTextTipView7.setBottomLineVisibility(true);
        this.o = (SettingTextVersionView) this.f62580a.findViewById(R.id.versionInfo);
        TbSettingTextTipView tbSettingTextTipView8 = (TbSettingTextTipView) this.f62580a.findViewById(R.id.feedBack);
        this.p = tbSettingTextTipView8;
        tbSettingTextTipView8.setTopLineVisibility(true);
        this.p.setBottomLineVisibility(true);
        this.q = (TbSettingTextTipView) this.f62580a.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.q.setVisibility(8);
            this.q.setBottomLineVisibility(false);
        } else {
            this.q.setVisibility(0);
            this.q.setBottomLineVisibility(true);
        }
        this.r = (TbSettingTextNewDotView) this.f62580a.findViewById(R.id.systemhelpsetting);
        this.s = (TextView) this.f62580a.findViewById(R.id.quit);
        this.B = (RelativeLayout) this.f62580a.findViewById(R.id.eyeshield_mode);
        this.C = (BdSwitchView) this.f62580a.findViewById(R.id.item_switch);
        d.a.c.e.p.l.c(this.f62580a.getPageContext().getPageActivity(), this.C, 10, 10, 10, 10);
        this.D = (RelativeLayout) this.f62580a.findViewById(R.id.follow_system_day_night_mode);
        this.E = (BdSwitchView) this.f62580a.findViewById(R.id.follow_system_item_switch);
        d.a.c.e.p.l.c(this.f62580a.getPageContext().getPageActivity(), this.E, 10, 10, 10, 10);
        this.w = this.f62580a.findViewById(R.id.divide_view2);
        this.x = this.f62580a.findViewById(R.id.divide_view1);
        this.y = this.f62580a.findViewById(R.id.divide_view3);
        this.z = this.f62580a.findViewById(R.id.divide_view4);
        this.A = this.f62580a.findViewById(R.id.divide_view5);
        J();
        O();
        this.f62586g.b();
        N(TbadkCoreApplication.getInst().getSkinType());
        this.x.setVisibility(0);
        this.y.setVisibility(0);
        this.z.setVisibility(0);
        this.A.setVisibility(0);
        B(z);
        if (!v()) {
            this.j.setTip(this.f62580a.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.w.setVisibility(8);
            this.B.setVisibility(8);
        } else {
            this.w.setVisibility(0);
            this.B.setVisibility(0);
        }
        this.D.setVisibility(x() ? 0 : 8);
        if (d.a.m0.r.d0.b.j().g("key_is_follow_system_mode", false)) {
            this.E.k();
        } else {
            this.E.h();
        }
    }

    public void G(String str, boolean z) {
        if (str != null && str.length() > 0) {
            this.f62586g.a();
            this.f62586g.setIcon(str, z);
            return;
        }
        SettingTextImageView settingTextImageView = this.f62586g;
        if (settingTextImageView != null) {
            settingTextImageView.b();
        }
    }

    public void H() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f62580a).areNotificationsEnabled();
        TbSettingTextTipView tbSettingTextTipView = this.m;
        if (tbSettingTextTipView != null) {
            tbSettingTextTipView.setTipViewColor(R.color.CAM_X0105);
            this.m.setTip(areNotificationsEnabled ? "" : this.f62580a.getString(R.string.may_lose_important_msg));
        }
    }

    public void I() {
        this.f62586g.e();
        this.f62587h.g();
        this.f62588i.g();
        this.j.g();
        this.k.g();
        this.m.g();
        this.n.g();
        this.o.g();
        this.p.g();
        this.q.g();
    }

    public void J() {
        SettingTextVersionView settingTextVersionView = this.o;
        if (settingTextVersionView != null) {
            settingTextVersionView.i();
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = this.r;
        if (tbSettingTextNewDotView != null) {
            tbSettingTextNewDotView.i();
        }
    }

    public void K(int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() == i2) {
            return;
        }
        if (i2 == 1) {
            onChangeSkinType(i2);
            TbadkCoreApplication.getInst().setSkinType(i2);
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", "1").param("obj_source", "0"));
        } else if (i2 == 0 || i2 == 4) {
            onChangeSkinType(i2);
            TbadkCoreApplication.getInst().setSkinType(i2);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", "0").param("obj_source", "0"));
        }
        BitmapHelper.clearCashBitmap();
    }

    public void L() {
        if (this.f62583d == null) {
            u();
        }
        this.f62583d.l();
    }

    public void N(int i2) {
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201);
        this.f62582c.onChangeSkinType(getPageContext(), i2);
        this.f62586g.f(i2);
        this.f62580a.getLayoutMode().k(i2 == 1);
        this.f62580a.getLayoutMode().j(this.t);
        this.f62582c.onChangeSkinType(getPageContext(), i2);
        J();
        this.C.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.E.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
        this.f62585f.setLocalIcon(SkinManager.getResourceId(R.drawable.icon_mine_list_baidu));
        l lVar = this.f62584e;
        if (lVar != null) {
            lVar.j();
        }
        this.f62585f.c(i2);
        this.f62586g.f(i2);
        this.f62587h.f(i2);
        this.f62588i.f(i2);
        this.j.f(i2);
        this.k.f(i2);
        this.l.f(i2);
        this.m.f(i2);
        this.n.f(i2);
        this.o.f(i2);
        this.p.f(i2);
        this.q.f(i2);
        this.r.f(i2);
    }

    public void O() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            this.f62586g.setVisibility(0);
        } else {
            this.f62586g.setVisibility(8);
        }
    }

    public void P() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.C.i();
        } else {
            this.C.f();
        }
    }

    public void onChangeSkinType(int i2) {
        N(i2);
        if (this.f62584e != null) {
            this.f62580a.getLayoutMode().k(i2 == 1);
            this.f62580a.getLayoutMode().j(this.f62584e.g());
        }
        if (i2 == 1) {
            this.C.k();
        } else {
            this.C.h();
        }
    }

    public final void u() {
        l lVar = new l(getPageContext().getPageActivity());
        this.f62584e = lVar;
        lVar.q(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        d.a.m0.r.s.h hVar = new d.a.m0.r.s.h(getPageContext().getString(R.string.quite_current_account), this.f62584e);
        hVar.o(R.color.CAM_X0301);
        arrayList.add(hVar);
        this.f62580a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f62580a.getLayoutMode().j(this.f62584e.g());
        a aVar = new a(hVar);
        b bVar = new b();
        this.f62584e.k(arrayList);
        this.f62584e.n(aVar);
        this.f62584e.m(bVar);
        j jVar = new j(this.mContext);
        this.f62583d = jVar;
        jVar.setCanceledOnTouchOutside(true);
        this.f62583d.h(this.f62584e);
    }

    public final boolean v() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    public void w() {
        j jVar = this.f62583d;
        if (jVar != null) {
            jVar.dismiss();
        }
    }

    public final boolean x() {
        if (v()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return d.a.m0.r.d0.b.j().g("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    public BdSwitchView y() {
        return this.C;
    }

    public final View.OnClickListener z() {
        return new c();
    }
}

package d.b.j0.v2.c;

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
import d.b.i0.r.s.j;
import d.b.i0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e extends d.b.c.a.d<MoreActivity> {
    public View A;
    public RelativeLayout B;
    public BdSwitchView C;
    public RelativeLayout D;
    public BdSwitchView E;

    /* renamed from: a  reason: collision with root package name */
    public MoreActivity f63509a;

    /* renamed from: b  reason: collision with root package name */
    public d f63510b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f63511c;

    /* renamed from: d  reason: collision with root package name */
    public j f63512d;

    /* renamed from: e  reason: collision with root package name */
    public l f63513e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextNormalImageView f63514f;

    /* renamed from: g  reason: collision with root package name */
    public SettingTextImageView f63515g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f63516h;
    public TbSettingTextTipView i;
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

    /* loaded from: classes4.dex */
    public class a implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.h f63517e;

        public a(d.b.i0.r.s.h hVar) {
            this.f63517e = hVar;
        }

        @Override // d.b.i0.r.s.l.e
        public void onItemClick(l lVar, int i, View view) {
            if (i == this.f63517e.f()) {
                e.this.y();
                e.this.f63510b.a(12);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements l.c {
        public b() {
        }

        @Override // d.b.i0.r.s.l.c
        public void onClick() {
            e.this.y();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == e.this.v) {
                e.this.f63510b.a(0);
            } else if (view == e.this.f63515g) {
                e.this.f63510b.a(1);
            } else if (view == e.this.f63516h) {
                e.this.f63510b.a(15);
            } else if (view == e.this.i) {
                e.this.f63510b.a(2);
            } else if (view == e.this.j) {
                e.this.f63510b.a(3);
            } else if (view == e.this.k) {
                e.this.f63510b.a(17);
            } else if (view == e.this.m) {
                e.this.f63510b.a(4);
            } else if (view == e.this.n) {
                e.this.f63510b.a(9);
            } else if (view == e.this.o) {
                e.this.f63510b.a(6);
            } else if (view == e.this.p) {
                e.this.f63510b.a(7);
            } else if (view == e.this.q) {
                e.this.f63510b.a(8);
            } else if (view == e.this.r) {
                e.this.f63510b.a(5);
            } else if (view == e.this.s) {
                e.this.f63510b.a(10);
            } else if (view == e.this.f63514f) {
                e.this.f63510b.a(13);
            } else if (view == e.this.l) {
                e.this.f63510b.a(16);
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
        this.f63509a = moreActivity;
        this.f63510b = dVar;
        moreActivity.setContentView(R.layout.more_activity);
        G();
        R();
    }

    public BdSwitchView A() {
        return this.C;
    }

    public final View.OnClickListener B() {
        return new c();
    }

    public BdSwitchView E() {
        return this.E;
    }

    public final void F(View.OnClickListener onClickListener) {
        this.f63514f.setOnClickListener(onClickListener);
        this.v.setOnClickListener(onClickListener);
        this.f63515g.setOnClickListener(onClickListener);
        this.f63516h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
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
        this.C.setOnSwitchStateChangeListener(this.f63509a);
        this.E.setOnSwitchStateChangeListener(this.f63509a);
    }

    public final void G() {
        View.OnClickListener B = B();
        this.t = (RelativeLayout) this.f63509a.findViewById(R.id.parent);
        this.u = this.f63509a.findViewById(R.id.scroll);
        this.f63509a.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        NavigationBar navigationBar = (NavigationBar) this.f63509a.findViewById(R.id.view_navigation_bar);
        this.f63511c = navigationBar;
        this.v = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63511c.setCenterTextTitle(this.f63509a.getPageContext().getString(R.string.setup));
        this.f63511c.showBottomLine();
        this.f63514f = (SettingTextNormalImageView) this.f63509a.findViewById(R.id.accountSafeSetting);
        this.f63515g = (SettingTextImageView) this.f63509a.findViewById(R.id.personInfo);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f63509a.findViewById(R.id.interest_label_setting);
        this.f63516h = tbSettingTextTipView;
        tbSettingTextTipView.setTopLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f63509a.findViewById(R.id.accountManager);
        this.i = tbSettingTextTipView2;
        tbSettingTextTipView2.setTopLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f63509a.findViewById(R.id.browseSetting);
        this.j = tbSettingTextTipView3;
        tbSettingTextTipView3.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f63509a.findViewById(R.id.youngsterSetting);
        this.k = tbSettingTextTipView4;
        tbSettingTextTipView4.setBottomLineVisibility(true);
        if (d.b.i0.c1.b.c.d()) {
            this.k.setTip(this.f63509a.getString(R.string.youngster_settings_tip_open));
        } else {
            this.k.setTip(this.f63509a.getString(R.string.youngster_settings_tip_close));
        }
        TbSettingTextTipView tbSettingTextTipView5 = (TbSettingTextTipView) this.f63509a.findViewById(R.id.adSetting);
        this.l = tbSettingTextTipView5;
        tbSettingTextTipView5.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView6 = (TbSettingTextTipView) this.f63509a.findViewById(R.id.messageSetting);
        this.m = tbSettingTextTipView6;
        tbSettingTextTipView6.setBottomLineVisibility(true);
        this.j.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView7 = (TbSettingTextTipView) this.f63509a.findViewById(R.id.secretSetting);
        this.n = tbSettingTextTipView7;
        tbSettingTextTipView7.setBottomLineVisibility(true);
        this.o = (SettingTextVersionView) this.f63509a.findViewById(R.id.versionInfo);
        TbSettingTextTipView tbSettingTextTipView8 = (TbSettingTextTipView) this.f63509a.findViewById(R.id.feedBack);
        this.p = tbSettingTextTipView8;
        tbSettingTextTipView8.setTopLineVisibility(true);
        this.p.setBottomLineVisibility(true);
        this.q = (TbSettingTextTipView) this.f63509a.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.q.setVisibility(8);
            this.q.setBottomLineVisibility(false);
        } else {
            this.q.setVisibility(0);
            this.q.setBottomLineVisibility(true);
        }
        this.r = (TbSettingTextNewDotView) this.f63509a.findViewById(R.id.systemhelpsetting);
        this.s = (TextView) this.f63509a.findViewById(R.id.quit);
        this.B = (RelativeLayout) this.f63509a.findViewById(R.id.eyeshield_mode);
        this.C = (BdSwitchView) this.f63509a.findViewById(R.id.item_switch);
        d.b.c.e.p.l.c(this.f63509a.getPageContext().getPageActivity(), this.C, 10, 10, 10, 10);
        this.D = (RelativeLayout) this.f63509a.findViewById(R.id.follow_system_day_night_mode);
        this.E = (BdSwitchView) this.f63509a.findViewById(R.id.follow_system_item_switch);
        d.b.c.e.p.l.c(this.f63509a.getPageContext().getPageActivity(), this.E, 10, 10, 10, 10);
        this.w = this.f63509a.findViewById(R.id.divide_view2);
        this.x = this.f63509a.findViewById(R.id.divide_view1);
        this.y = this.f63509a.findViewById(R.id.divide_view3);
        this.z = this.f63509a.findViewById(R.id.divide_view4);
        this.A = this.f63509a.findViewById(R.id.divide_view5);
        L();
        Q();
        this.f63515g.b();
        P(TbadkCoreApplication.getInst().getSkinType());
        this.x.setVisibility(0);
        this.y.setVisibility(0);
        this.z.setVisibility(0);
        this.A.setVisibility(0);
        F(B);
        if (!x()) {
            this.j.setTip(this.f63509a.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.w.setVisibility(8);
            this.B.setVisibility(8);
        } else {
            this.w.setVisibility(0);
            this.B.setVisibility(0);
        }
        this.D.setVisibility(z() ? 0 : 8);
        if (d.b.i0.r.d0.b.j().g("key_is_follow_system_mode", false)) {
            this.E.k();
        } else {
            this.E.h();
        }
    }

    public void I(String str, boolean z) {
        if (str != null && str.length() > 0) {
            this.f63515g.a();
            this.f63515g.setIcon(str, z);
            return;
        }
        SettingTextImageView settingTextImageView = this.f63515g;
        if (settingTextImageView != null) {
            settingTextImageView.b();
        }
    }

    public void J() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f63509a).areNotificationsEnabled();
        TbSettingTextTipView tbSettingTextTipView = this.m;
        if (tbSettingTextTipView != null) {
            tbSettingTextTipView.setTipViewColor(R.color.CAM_X0105);
            this.m.setTip(areNotificationsEnabled ? "" : this.f63509a.getString(R.string.may_lose_important_msg));
        }
    }

    public void K() {
        this.f63515g.e();
        this.f63516h.g();
        this.i.g();
        this.j.g();
        this.k.g();
        this.m.g();
        this.n.g();
        this.o.g();
        this.p.g();
        this.q.g();
    }

    public void L() {
        SettingTextVersionView settingTextVersionView = this.o;
        if (settingTextVersionView != null) {
            settingTextVersionView.i();
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = this.r;
        if (tbSettingTextNewDotView != null) {
            tbSettingTextNewDotView.i();
        }
    }

    public void M(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() == i) {
            return;
        }
        if (i == 1) {
            onChangeSkinType(i);
            TbadkCoreApplication.getInst().setSkinType(i);
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", "1").param("obj_source", "0"));
        } else if (i == 0 || i == 4) {
            onChangeSkinType(i);
            TbadkCoreApplication.getInst().setSkinType(i);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", "0").param("obj_source", "0"));
        }
        BitmapHelper.clearCashBitmap();
    }

    public void O() {
        if (this.f63512d == null) {
            w();
        }
        this.f63512d.l();
    }

    public void P(int i) {
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201);
        this.f63511c.onChangeSkinType(getPageContext(), i);
        this.f63515g.f(i);
        this.f63509a.getLayoutMode().k(i == 1);
        this.f63509a.getLayoutMode().j(this.t);
        this.f63511c.onChangeSkinType(getPageContext(), i);
        L();
        this.C.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.E.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
        this.f63514f.setLocalIcon(SkinManager.getResourceId(R.drawable.icon_mine_list_baidu));
        l lVar = this.f63513e;
        if (lVar != null) {
            lVar.j();
        }
        this.f63514f.c(i);
        this.f63515g.f(i);
        this.f63516h.f(i);
        this.i.f(i);
        this.j.f(i);
        this.k.f(i);
        this.l.f(i);
        this.m.f(i);
        this.n.f(i);
        this.o.f(i);
        this.p.f(i);
        this.q.f(i);
        this.r.f(i);
    }

    public void Q() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            this.f63515g.setVisibility(0);
        } else {
            this.f63515g.setVisibility(8);
        }
    }

    public void R() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.C.i();
        } else {
            this.C.f();
        }
    }

    public void onChangeSkinType(int i) {
        P(i);
        if (this.f63513e != null) {
            this.f63509a.getLayoutMode().k(i == 1);
            this.f63509a.getLayoutMode().j(this.f63513e.g());
        }
        if (i == 1) {
            this.C.k();
        } else {
            this.C.h();
        }
    }

    public final void w() {
        l lVar = new l(getPageContext().getPageActivity());
        this.f63513e = lVar;
        lVar.q(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        d.b.i0.r.s.h hVar = new d.b.i0.r.s.h(getPageContext().getString(R.string.quite_current_account), this.f63513e);
        hVar.o(R.color.CAM_X0301);
        arrayList.add(hVar);
        this.f63509a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f63509a.getLayoutMode().j(this.f63513e.g());
        a aVar = new a(hVar);
        b bVar = new b();
        this.f63513e.k(arrayList);
        this.f63513e.n(aVar);
        this.f63513e.m(bVar);
        j jVar = new j(this.mContext);
        this.f63512d = jVar;
        jVar.setCanceledOnTouchOutside(true);
        this.f63512d.h(this.f63513e);
    }

    public final boolean x() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    public void y() {
        j jVar = this.f63512d;
        if (jVar != null) {
            jVar.dismiss();
        }
    }

    public final boolean z() {
        if (x()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return d.b.i0.r.d0.b.j().g("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }
}

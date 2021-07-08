package d.a.p0.z2.c;

import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.s.j;
import d.a.o0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class e extends d.a.c.a.d<MoreActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public RelativeLayout B;
    public BdSwitchView C;
    public RelativeLayout D;
    public BdSwitchView E;

    /* renamed from: a  reason: collision with root package name */
    public MoreActivity f66619a;

    /* renamed from: b  reason: collision with root package name */
    public d f66620b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66621c;

    /* renamed from: d  reason: collision with root package name */
    public j f66622d;

    /* renamed from: e  reason: collision with root package name */
    public l f66623e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextNormalImageView f66624f;

    /* renamed from: g  reason: collision with root package name */
    public SettingTextImageView f66625g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f66626h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f66627i;
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

    /* loaded from: classes8.dex */
    public class a implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.h f66628e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f66629f;

        public a(e eVar, d.a.o0.r.s.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66629f = eVar;
            this.f66628e = hVar;
        }

        @Override // d.a.o0.r.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) && i2 == this.f66628e.f()) {
                this.f66629f.w();
                this.f66629f.f66620b.a(12);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f66630a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66630a = eVar;
        }

        @Override // d.a.o0.r.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66630a.w();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f66631e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66631e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f66631e.v) {
                    this.f66631e.f66620b.a(0);
                } else if (view == this.f66631e.f66625g) {
                    this.f66631e.f66620b.a(1);
                } else if (view == this.f66631e.f66626h) {
                    this.f66631e.f66620b.a(15);
                } else if (view == this.f66631e.f66627i) {
                    this.f66631e.f66620b.a(2);
                } else if (view == this.f66631e.j) {
                    this.f66631e.f66620b.a(3);
                } else if (view == this.f66631e.k) {
                    this.f66631e.f66620b.a(17);
                } else if (view == this.f66631e.m) {
                    this.f66631e.f66620b.a(4);
                } else if (view == this.f66631e.n) {
                    this.f66631e.f66620b.a(9);
                } else if (view == this.f66631e.o) {
                    this.f66631e.f66620b.a(6);
                } else if (view == this.f66631e.p) {
                    this.f66631e.f66620b.a(7);
                } else if (view == this.f66631e.q) {
                    this.f66631e.f66620b.a(8);
                } else if (view == this.f66631e.r) {
                    this.f66631e.f66620b.a(5);
                } else if (view == this.f66631e.s) {
                    this.f66631e.f66620b.a(10);
                } else if (view == this.f66631e.f66624f) {
                    this.f66631e.f66620b.a(13);
                } else if (view == this.f66631e.l) {
                    this.f66631e.f66620b.a(16);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {moreActivity, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.f66619a = moreActivity;
        this.f66620b = dVar;
        moreActivity.setContentView(R.layout.more_activity);
        F();
        P();
    }

    public BdSwitchView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.E : (BdSwitchView) invokeV.objValue;
    }

    public final void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f66624f.setOnClickListener(onClickListener);
            this.v.setOnClickListener(onClickListener);
            this.f66625g.setOnClickListener(onClickListener);
            this.f66626h.setOnClickListener(onClickListener);
            this.f66627i.setOnClickListener(onClickListener);
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
            this.C.setOnSwitchStateChangeListener(this.f66619a);
            this.E.setOnSwitchStateChangeListener(this.f66619a);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View.OnClickListener z = z();
            this.t = (RelativeLayout) this.f66619a.findViewById(R.id.parent);
            this.u = this.f66619a.findViewById(R.id.scroll);
            this.f66619a.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            NavigationBar navigationBar = (NavigationBar) this.f66619a.findViewById(R.id.view_navigation_bar);
            this.f66621c = navigationBar;
            this.v = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f66621c.setCenterTextTitle(this.f66619a.getPageContext().getString(R.string.setup));
            this.f66621c.showBottomLine();
            this.f66624f = (SettingTextNormalImageView) this.f66619a.findViewById(R.id.accountSafeSetting);
            this.f66625g = (SettingTextImageView) this.f66619a.findViewById(R.id.personInfo);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f66619a.findViewById(R.id.interest_label_setting);
            this.f66626h = tbSettingTextTipView;
            tbSettingTextTipView.setTopLineVisibility(true);
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f66619a.findViewById(R.id.accountManager);
            this.f66627i = tbSettingTextTipView2;
            tbSettingTextTipView2.setTopLineVisibility(true);
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f66619a.findViewById(R.id.browseSetting);
            this.j = tbSettingTextTipView3;
            tbSettingTextTipView3.setBottomLineVisibility(true);
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f66619a.findViewById(R.id.youngsterSetting);
            this.k = tbSettingTextTipView4;
            tbSettingTextTipView4.setBottomLineVisibility(true);
            if (d.a.o0.c1.b.e.d()) {
                this.k.setTip(this.f66619a.getString(R.string.youngster_settings_tip_open));
            } else {
                this.k.setTip(this.f66619a.getString(R.string.youngster_settings_tip_close));
            }
            TbSettingTextTipView tbSettingTextTipView5 = (TbSettingTextTipView) this.f66619a.findViewById(R.id.adSetting);
            this.l = tbSettingTextTipView5;
            tbSettingTextTipView5.setBottomLineVisibility(true);
            TbSettingTextTipView tbSettingTextTipView6 = (TbSettingTextTipView) this.f66619a.findViewById(R.id.messageSetting);
            this.m = tbSettingTextTipView6;
            tbSettingTextTipView6.setBottomLineVisibility(true);
            this.j.setBottomLineVisibility(true);
            TbSettingTextTipView tbSettingTextTipView7 = (TbSettingTextTipView) this.f66619a.findViewById(R.id.secretSetting);
            this.n = tbSettingTextTipView7;
            tbSettingTextTipView7.setBottomLineVisibility(true);
            this.o = (SettingTextVersionView) this.f66619a.findViewById(R.id.versionInfo);
            TbSettingTextTipView tbSettingTextTipView8 = (TbSettingTextTipView) this.f66619a.findViewById(R.id.feedBack);
            this.p = tbSettingTextTipView8;
            tbSettingTextTipView8.setTopLineVisibility(true);
            this.p.setBottomLineVisibility(true);
            this.q = (TbSettingTextTipView) this.f66619a.findViewById(R.id.recommend);
            if (!TbadkCoreApplication.getInst().getIsAppOn()) {
                this.q.setVisibility(8);
                this.q.setBottomLineVisibility(false);
            } else {
                this.q.setVisibility(0);
                this.q.setBottomLineVisibility(true);
            }
            this.r = (TbSettingTextNewDotView) this.f66619a.findViewById(R.id.systemhelpsetting);
            this.s = (TextView) this.f66619a.findViewById(R.id.quit);
            this.B = (RelativeLayout) this.f66619a.findViewById(R.id.eyeshield_mode);
            this.C = (BdSwitchView) this.f66619a.findViewById(R.id.item_switch);
            d.a.c.e.p.l.c(this.f66619a.getPageContext().getPageActivity(), this.C, 10, 10, 10, 10);
            this.D = (RelativeLayout) this.f66619a.findViewById(R.id.follow_system_day_night_mode);
            this.E = (BdSwitchView) this.f66619a.findViewById(R.id.follow_system_item_switch);
            d.a.c.e.p.l.c(this.f66619a.getPageContext().getPageActivity(), this.E, 10, 10, 10, 10);
            this.w = this.f66619a.findViewById(R.id.divide_view2);
            this.x = this.f66619a.findViewById(R.id.divide_view1);
            this.y = this.f66619a.findViewById(R.id.divide_view3);
            this.z = this.f66619a.findViewById(R.id.divide_view4);
            this.A = this.f66619a.findViewById(R.id.divide_view5);
            J();
            O();
            this.f66625g.b();
            N(TbadkCoreApplication.getInst().getSkinType());
            this.x.setVisibility(0);
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            B(z);
            if (!v()) {
                this.j.setTip(this.f66619a.getResources().getString(R.string.browsing_settings_tip_no_night));
                this.w.setVisibility(8);
                this.B.setVisibility(8);
            } else {
                this.w.setVisibility(0);
                this.B.setVisibility(0);
            }
            this.D.setVisibility(x() ? 0 : 8);
            if (d.a.o0.r.d0.b.j().g("key_is_follow_system_mode", false)) {
                this.E.k();
            } else {
                this.E.h();
            }
        }
    }

    public void G(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) {
            if (str != null && str.length() > 0) {
                this.f66625g.a();
                this.f66625g.setIcon(str, z);
                return;
            }
            SettingTextImageView settingTextImageView = this.f66625g;
            if (settingTextImageView != null) {
                settingTextImageView.b();
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f66619a).areNotificationsEnabled();
            TbSettingTextTipView tbSettingTextTipView = this.m;
            if (tbSettingTextTipView != null) {
                tbSettingTextTipView.setTipViewColor(R.color.CAM_X0105);
                this.m.setTip(areNotificationsEnabled ? "" : this.f66619a.getString(R.string.may_lose_important_msg));
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f66625g.e();
            this.f66626h.g();
            this.f66627i.g();
            this.j.g();
            this.k.g();
            this.m.g();
            this.n.g();
            this.o.g();
            this.p.g();
            this.q.g();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SettingTextVersionView settingTextVersionView = this.o;
            if (settingTextVersionView != null) {
                settingTextVersionView.i();
            }
            TbSettingTextNewDotView tbSettingTextNewDotView = this.r;
            if (tbSettingTextNewDotView != null) {
                tbSettingTextNewDotView.i();
            }
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || TbadkCoreApplication.getInst().getSkinType() == i2) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f66622d == null) {
                u();
            }
            this.f66622d.l();
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201);
            this.f66621c.onChangeSkinType(getPageContext(), i2);
            this.f66625g.f(i2);
            this.f66619a.getLayoutMode().k(i2 == 1);
            this.f66619a.getLayoutMode().j(this.t);
            this.f66621c.onChangeSkinType(getPageContext(), i2);
            J();
            this.C.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.E.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            this.f66624f.setLocalIcon(SkinManager.getResourceId(R.drawable.icon_mine_list_baidu));
            l lVar = this.f66623e;
            if (lVar != null) {
                lVar.j();
            }
            this.f66624f.c(i2);
            this.f66625g.f(i2);
            this.f66626h.f(i2);
            this.f66627i.f(i2);
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
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.f66625g.setVisibility(0);
            } else {
                this.f66625g.setVisibility(8);
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.C.i();
            } else {
                this.C.f();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            N(i2);
            if (this.f66623e != null) {
                this.f66619a.getLayoutMode().k(i2 == 1);
                this.f66619a.getLayoutMode().j(this.f66623e.g());
            }
            if (i2 == 1) {
                this.C.k();
            } else {
                this.C.h();
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            l lVar = new l(getPageContext().getPageActivity());
            this.f66623e = lVar;
            lVar.q(getPageContext().getString(R.string.quit_account_tip));
            ArrayList arrayList = new ArrayList();
            d.a.o0.r.s.h hVar = new d.a.o0.r.s.h(getPageContext().getString(R.string.quite_current_account), this.f66623e);
            hVar.o(R.color.CAM_X0301);
            arrayList.add(hVar);
            this.f66619a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f66619a.getLayoutMode().j(this.f66623e.g());
            a aVar = new a(this, hVar);
            b bVar = new b(this);
            this.f66623e.k(arrayList);
            this.f66623e.n(aVar);
            this.f66623e.m(bVar);
            j jVar = new j(this.mContext);
            this.f66622d = jVar;
            jVar.setCanceledOnTouchOutside(true);
            this.f66622d.h(this.f66623e);
        }
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? MessageManager.getInstance().runTask(2001281, Boolean.class) != null : invokeV.booleanValue;
    }

    public void w() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (jVar = this.f66622d) == null) {
            return;
        }
        jVar.dismiss();
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (v()) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return d.a.o0.r.d0.b.j().g("key_is_dark_mode_notify_shown", false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public BdSwitchView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.C : (BdSwitchView) invokeV.objValue;
    }

    public final View.OnClickListener z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? new c(this) : (View.OnClickListener) invokeV.objValue;
    }
}

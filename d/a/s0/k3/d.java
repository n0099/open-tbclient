package d.a.s0.k3;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.s.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public final ItemCardHelper.b C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public CustomMessageListener F;
    public Runnable G;
    public Runnable H;
    public Runnable I;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f62700a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f62701b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62702c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62703d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f62704e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f62705f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f62706g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f62707h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f62708i;
    public ImageView j;
    public TextView k;
    public boolean l;
    public int m;
    public boolean n;
    public PopupWindow o;
    public boolean p;
    public Handler q;
    public d.a.s0.e0.h r;
    public d.a.s0.v3.e s;
    public MaintabBottomIndicator t;
    public MaintabBottomIndicator u;
    public int v;
    public boolean w;
    public int x;
    public boolean y;
    public FragmentTabHost.a z;

    /* loaded from: classes9.dex */
    public class a implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62709a;

        /* renamed from: d.a.s0.k3.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1557a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f62710e;

            public RunnableC1557a(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f62710e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.f62710e);
                }
            }
        }

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62709a = dVar;
        }

        public final void a(int i2) {
            String m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f62709a.f62701b.f(i2).f12346a == 2) {
                    m = TbPageExtraHelper.l(this.f62709a.f62700a.getPageContext().getContext());
                } else {
                    m = TbPageExtraHelper.m();
                }
                d.a.c.e.m.e.a().postDelayed(new RunnableC1557a(this, new CustomResponsedMessage(2921520, m)), 100L);
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                int i3 = this.f62709a.f62701b.f(i2).f12346a;
                if (i3 == 8) {
                    TbPageExtraHelper.u("a011");
                } else if (i3 == 2) {
                    TbPageExtraHelper.u("a002");
                } else if (i3 == 3) {
                    TbPageExtraHelper.u("a079");
                } else if (i3 == 1) {
                    TbPageExtraHelper.u("a025");
                } else if (i3 == 21) {
                    TbPageExtraHelper.u("a075");
                } else if (i3 == 22) {
                    TbPageExtraHelper.u("a088");
                }
            }
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                FragmentTabHost.b f2 = this.f62709a.f62701b.f(i2);
                if (f2.f12346a == 2 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f62709a.f62700a.getPageContext(), null)) {
                    int i3 = f2.f12346a;
                    if (i3 != 9) {
                        if (i3 == 8 && !ViewHelper.checkUpIsLogin(this.f62709a.f62700a.getActivity())) {
                            if (this.f62709a.t != null) {
                                this.f62709a.t.n();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                            return false;
                        }
                        int i4 = f2.f12346a;
                        if (i4 != 15) {
                            if (i4 == 3 && !ViewHelper.checkUpIsLogin(this.f62709a.f62700a.getActivity())) {
                                return false;
                            }
                            if (f2.f12346a == 1) {
                                TiebaStatic.log(new StatisticItem("c13001"));
                            }
                        } else {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f62709a.f62700a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                                return false;
                            }
                        }
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new d.a.r0.t.k(0)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                FragmentTabHost.b f2 = this.f62709a.f62701b.f(i2);
                int i3 = f2.f12346a;
                if (i3 == 8) {
                    if (this.f62709a.t != null && this.f62709a.t.getAnimationView() != null && this.f62709a.t.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.f62709a.t != null) {
                        this.f62709a.t.n();
                    }
                    TiebaStatic.log("c13841");
                } else if (i3 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                }
                if (f2.f12346a == 2) {
                    if (this.f62709a.w) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.f62709a.w = true;
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if (this.f62709a.x != 2 || this.f62709a.v == i2 || homeBarShowType != 1 || this.f62709a.u == null) {
                        if (this.f62709a.x == 1 && this.f62709a.u != null) {
                            this.f62709a.u.x(this.f62709a.w);
                        }
                    } else {
                        this.f62709a.u.y();
                    }
                    this.f62709a.y = false;
                } else {
                    this.f62709a.y = true;
                    if (this.f62709a.w && this.f62709a.u != null) {
                        this.f62709a.u.x(this.f62709a.w);
                    }
                    this.f62709a.w = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                }
                if (this.f62709a.A() != null) {
                    this.f62709a.A().A = this.f62709a.w;
                }
                b(this.f62709a.v);
                a(this.f62709a.v);
                this.f62709a.v = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i2)));
                if (f2.f12346a != 22) {
                    if (this.f62709a.f62701b.getFragmentTabWidget() != null) {
                        this.f62709a.f62701b.getFragmentTabWidget().g(false, R.color.CAM_X0207);
                    }
                    this.f62709a.f62701b.n(false);
                } else {
                    TiebaStatic.log(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 1));
                    if (this.f62709a.f62701b.f(this.f62709a.f62701b.getCurrentTabIndex()).f12346a != 22) {
                        if (this.f62709a.f62701b.getFragmentTabWidget() != null) {
                            this.f62709a.f62701b.getFragmentTabWidget().g(true, R.color.CAM_X0215);
                        }
                        this.f62709a.f62701b.n(true);
                        if (!d.a.c.e.p.j.z()) {
                            d.a.c.e.p.l.J(this.f62709a.f62700a, this.f62709a.f62700a.getResources().getString(R.string.neterror));
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.TRUE));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.FALSE));
                    }
                }
                if (f2.f12346a == 1 && TbSingleton.getInstance().needRefreshForumSquare) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921589));
                    TbSingleton.getInstance().needRefreshForumSquare = false;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f62711e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f62712f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f62713g;

        public b(d dVar, d.a.r0.r.s.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62713g = dVar;
            this.f62711e = aVar;
            this.f62712f = i2;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f62711e.dismiss();
                int i2 = this.f62712f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f62713g.f62700a.getPageContext().getPageActivity(), "user_overdue_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f62713g.f62700a.getPageContext().getPageActivity(), "user_expire_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f62714e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f62715f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f62716g;

        public c(d dVar, d.a.r0.r.s.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62716g = dVar;
            this.f62714e = aVar;
            this.f62715f = i2;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f62714e.dismiss();
                int i2 = this.f62715f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f62716g.f62700a.getPageContext().getPageActivity(), "user_overdue_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4006001000";
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f62716g.f62700a.getPageContext().getPageActivity(), "user_expire_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4005001000";
                } else {
                    str = null;
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f62716g.f62700a.getPageContext().getPageActivity(), 2);
                if (!StringUtils.isNULL(str)) {
                    memberPayActivityConfig.setSceneId(str);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* renamed from: d.a.s0.k3.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1558d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62717e;

        public View$OnClickListenerC1558d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62717e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62717e.R(false);
                this.f62717e.f62706g.setVisibility(8);
                d.a.r0.r.d0.b.j().t("game_is_show_tip", false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, Boolean.FALSE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, this.f62717e.f62700a.getPageContext()));
                TiebaStatic.eventStat(this.f62717e.f62700a.getPageContext().getPageActivity(), "tb_gamecenter", PrefetchEvent.STATE_CLICK, 1, "ref_type", "601");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62718e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62718e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62718e.f62700a.sendMessage(new CustomMessage(2015003, new IntentConfig(this.f62718e.f62700a.getPageContext().getPageActivity())));
                int i2 = 3;
                if (this.f62718e.f62701b.getCurrentTabType() != 3) {
                    i2 = this.f62718e.f62701b.getCurrentTabType() == 2 ? 1 : 0;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", i2));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62719e;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62719e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                this.f62719e.f62700a.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(this.f62719e.f62700a.getPageContext().getPageActivity())));
                TiebaStatic.log("c10085");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62720e;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62720e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f62720e.f62700a.getPageContext().getPageActivity(), "notlogin_4", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                ViewHelper.skipToLoginActivity(this.f62720e.f62700a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62721e;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62721e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f62721e.f62700a.getPageContext().getPageActivity(), "notlogin_3", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                int i2 = this.f62721e.m;
                TiebaStatic.log(new StatisticItem("c10517").param("obj_source", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 8 ? "" : "profile" : "message" : "kantie" : "forum"));
                ViewHelper.skipToRegisterActivity(this.f62721e.f62700a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62722e;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62722e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62722e.f62701b == null || this.f62722e.o == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f62722e.f62701b.getFragmentTabWidget();
            d.a.c.e.p.l.k(this.f62722e.f62700a.getActivity());
            int g2 = d.a.c.e.p.l.g(this.f62722e.f62700a.getActivity(), R.dimen.ds178);
            View contentView = this.f62722e.o.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b g3 = this.f62722e.f62701b.g(3);
            if (g3 == null || (tbFragmentTabIndicator = g3.f12347b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = d.a.c.e.p.l.g(this.f62722e.f62700a.getActivity(), R.dimen.tbds570);
            }
            d.a.c.e.m.g.l(this.f62722e.o, fragmentTabWidget, measuredWidth2, -g2);
            d.a.r0.r.d0.b.j().t("show_maintab_last_message_tips", true);
            this.f62722e.p = true;
            this.f62722e.q.postDelayed(this.f62722e.I, 5000L);
        }
    }

    /* loaded from: classes9.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62723e;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62723e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62723e.z();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "1");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
                d.a.s0.b1.a.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62724a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62724a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.r0.e0.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f62724a.f62701b == null || !(customResponsedMessage.getData() instanceof d.a.r0.e0.c) || (cVar = (d.a.r0.e0.c) customResponsedMessage.getData()) == null || this.f62724a.f62701b.g(cVar.f55255e) == null || this.f62724a.f62701b.getCurrentTabType() == cVar.f55255e) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = this.f62724a.f62701b.g(cVar.f55255e).f12347b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(cVar.f55257g, cVar.f55253c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62725a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62725a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.h(this.f62725a.f62700a, this.f62725a.f62700a.getUniqueId(), (View) customResponsedMessage.getData(), this.f62725a.f62700a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements ItemCardHelper.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62726a;

        public o(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62726a = dVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.q(this.f62726a.f62700a, ItemCardHelper.OrderTipStatus.FAIL, this.f62726a.f62700a.getActivityRootView());
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.q(this.f62726a.f62700a, ItemCardHelper.OrderTipStatus.SUCCESS, this.f62726a.f62700a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62727a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62727a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.r0.e0.e.a c2;
            d.a.r0.e0.e.a c3;
            d.a.r0.e0.e.a c4;
            d.a.r0.e0.e.a c5;
            d.a.r0.e0.e.a c6;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f62727a.f62701b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FragmentTabHost.b g2 = this.f62727a.f62701b.g(2);
                if (g2 != null && (g2.f12347b instanceof MaintabBottomIndicator) && (c6 = d.a.r0.e0.e.c.d().c("homePage")) != null) {
                    ((MaintabBottomIndicator) g2.f12347b).setDynamicIconData(c6);
                }
                FragmentTabHost.b g3 = this.f62727a.f62701b.g(1);
                if (g3 != null && (g3.f12347b instanceof MaintabBottomIndicator) && (c5 = d.a.r0.e0.e.c.d().c("enterForum")) != null) {
                    ((MaintabBottomIndicator) g3.f12347b).setDynamicIconData(c5);
                }
                FragmentTabHost.b g4 = this.f62727a.f62701b.g(22);
                if (g4 != null && (g4.f12347b instanceof MaintabBottomIndicator) && (c4 = d.a.r0.e0.e.c.d().c("channel")) != null) {
                    ((MaintabBottomIndicator) g4.f12347b).setDynamicIconData(c4);
                }
                FragmentTabHost.b g5 = this.f62727a.f62701b.g(3);
                if (g5 != null && (g5.f12347b instanceof MaintabBottomIndicator) && (c3 = d.a.r0.e0.e.c.d().c("message")) != null) {
                    ((MaintabBottomIndicator) g5.f12347b).setDynamicIconData(c3);
                }
                FragmentTabHost.b g6 = this.f62727a.f62701b.g(8);
                if (g6 == null || !(g6.f12347b instanceof MaintabBottomIndicator) || (c2 = d.a.r0.e0.e.c.d().c("person")) == null) {
                    return;
                }
                ((MaintabBottomIndicator) g6.f12347b).setDynamicIconData(c2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62728a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62728a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f62728a.A() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int intValue = ((Integer) data).intValue();
                if (intValue == 4) {
                    this.f62728a.y = true;
                    this.f62728a.w = true;
                    if (this.f62728a.x != 2) {
                        if (this.f62728a.u == null || !this.f62728a.u.p()) {
                            return;
                        }
                        this.f62728a.u.x(this.f62728a.w);
                        return;
                    }
                    this.f62728a.A().w();
                    return;
                }
                if (intValue == 6) {
                    this.f62728a.y = false;
                    if (this.f62728a.x == 1) {
                        return;
                    }
                } else {
                    this.f62728a.x = intValue;
                }
                if (this.f62728a.x == 1) {
                    this.f62728a.A().x(this.f62728a.w);
                } else if (this.f62728a.x == 2) {
                    this.f62728a.A().y();
                } else if (intValue == 5) {
                    this.f62728a.x = 1;
                    this.f62728a.w = true;
                    if (!this.f62728a.y) {
                        this.f62728a.A().w();
                    }
                } else {
                    this.f62728a.A().v();
                }
                this.f62728a.A().z = true;
                this.f62728a.A().B = this.f62728a.x;
                this.f62728a.A().A = this.f62728a.w;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62729a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62729a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f62729a.w = true;
                if (this.f62729a.A() != null) {
                    this.f62729a.A().A = this.f62729a.w;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62730e;

        public s(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62730e = dVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.f62730e.f62701b.getCurrentTabType() != 2) {
                    if (this.f62730e.f62701b.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                this.f62730e.P();
                if (this.f62730e.f62701b.getCurrentTabType() != this.f62730e.f62701b.f(i2).f12346a) {
                    this.f62730e.f62701b.setCurrentTab(i2);
                }
                if (this.f62730e.f62701b.getCurrentTabType() != 1) {
                    this.f62730e.f62704e.setVisibility(8);
                    this.f62730e.f62707h.setVisibility(0);
                }
                if (this.f62730e.f62701b.getCurrentTabType() == 1 && !d.a.r0.r.d0.b.j().g("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d dVar = this.f62730e;
                dVar.m = dVar.f62701b.getCurrentTabType();
                this.f62730e.S();
                if (d.a.r0.r.d0.b.j().g("enter_forum_edit_mode", false)) {
                    if (this.f62730e.f62701b.getCurrentTabType() != 3) {
                        if (this.f62730e.f62701b.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (this.f62730e.f62701b.getCurrentTabType() == 3) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62731e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f62732f;

        public t(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62732f = dVar;
            this.f62731e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62732f.U(this.f62731e);
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = -1;
        this.p = false;
        this.q = new Handler();
        this.v = 0;
        this.w = true;
        this.x = 1;
        this.y = false;
        this.z = new a(this);
        this.A = new m(this, 2921492);
        this.B = new n(this, 2001440);
        this.C = new o(this);
        this.D = new p(this, 2921551);
        this.E = new q(this, 2921382);
        this.F = new r(this, 2921410);
        this.H = new i(this);
        this.I = new j(this);
        this.f62700a = mainTabActivity;
    }

    public MaintabBottomIndicator A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.u : (MaintabBottomIndicator) invokeV.objValue;
    }

    public MaintabBottomIndicator B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.t : (MaintabBottomIndicator) invokeV.objValue;
    }

    public FragmentTabHost C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f62701b : (FragmentTabHost) invokeV.objValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ImageView imageView = this.j;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView = this.k;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f62700a.findViewById(R.id.view_navigation_bar);
            this.f62702c = navigationBar;
            if (navigationBar != null) {
                this.f62703d = (TextView) navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimension = (int) this.f62700a.getResources().getDimension(R.dimen.ds16);
                layoutParams.setMargins(dimension, dimension, 0, dimension);
                this.f62703d.setLayoutParams(layoutParams);
                View addCustomView = this.f62702c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
                this.f62705f = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
                this.f62706g = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
                this.f62705f.setOnClickListener(new View$OnClickListenerC1558d(this));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(0, 0, d.a.c.e.p.l.g(this.f62700a.getPageContext().getPageActivity(), R.dimen.ds16), 0);
                ImageView imageView = (ImageView) this.f62702c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
                this.f62707h = imageView;
                imageView.setLayoutParams(layoutParams2);
                this.f62707h.setVisibility(8);
                this.f62707h.setOnClickListener(new e(this));
                ImageView imageView2 = (ImageView) this.f62702c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
                this.f62704e = imageView2;
                imageView2.setLayoutParams(layoutParams2);
                this.f62704e.setVisibility(8);
                this.f62704e.setOnClickListener(new f(this));
                this.f62702c.setLoginClickListener(new g(this));
                this.f62702c.setRegisterClickListener(new h(this));
            }
        }
    }

    public void F(ArrayList<d.a.r0.e0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.f62701b.q();
            Iterator<d.a.r0.e0.b> it = arrayList.iterator();
            while (it.hasNext()) {
                d.a.r0.e0.b next = it.next();
                if (next != null && next.isAvailable()) {
                    y(next, next.getFragmentTabStructure(), next.getTabIndicator(this.f62700a.getPageContext().getPageActivity()));
                }
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.f62701b.k(2);
            } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f62701b.k(1);
            } else {
                this.f62701b.k(0);
            }
            this.f62701b.setViewPagerScrollable(false);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.y = false;
            this.x = 1;
            if (A() != null) {
                A().B = this.x;
            }
        }
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ImageView imageView = this.f62705f;
            return imageView != null && imageView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f62701b.setShouldDrawTopLine(false);
            }
            this.f62701b.p(i2);
            FragmentTabHost fragmentTabHost = this.f62701b;
            FragmentTabHost.b f2 = fragmentTabHost.f(fragmentTabHost.getCurrentTabIndex());
            if (f2 != null && f2.f12346a == 22) {
                if (this.f62701b.getFragmentTabWidget() != null) {
                    this.f62701b.getFragmentTabWidget().g(true, R.color.CAM_X0215);
                }
                this.f62701b.n(true);
            } else {
                if (this.f62701b.getFragmentTabWidget() != null) {
                    this.f62701b.getFragmentTabWidget().g(false, R.color.CAM_X0207);
                }
                this.f62701b.n(false);
            }
            this.f62702c.onChangeSkinType(this.f62700a.getPageContext(), i2);
            SkinManager.setNavbarTitleColor(this.f62703d, R.color.CAM_X0105, R.color.s_navbar_title_color, i2);
            SkinManager.setImageResource(this.f62706g, R.drawable.icon_news_down_bar_one);
            SkinManager.setNavbarIconSrc(this.f62705f, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0106);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62707h, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62704e, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            T();
            if (C() != null) {
                C().q();
            }
            z();
            d.a.s0.e0.h hVar = this.r;
            if (hVar != null) {
                hVar.i();
            }
            d.a.s0.v3.e eVar = this.s;
            if (eVar != null) {
                eVar.e();
            }
        }
    }

    public void L(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (fragmentTabHost = this.f62701b) == null) {
            return;
        }
        if (z) {
            fragmentTabHost.h();
            D();
            return;
        }
        fragmentTabHost.r();
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ItemCardHelper.p(this.C);
            MessageManager.getInstance().registerListener(this.B);
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.f62700a.findViewById(R.id.tab_host);
            this.f62701b = fragmentTabHost;
            fragmentTabHost.setup(this.f62700a.getSupportFragmentManager());
            this.f62701b.setAbsoluteWeight(true);
            this.f62701b.setOnTabSelectionListener(this.z);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f62701b.setShouldDrawIndicatorLine(false);
                this.f62701b.setShouldDrawTopLine(true);
            }
            this.f62701b.setOnPageChangeListener(new s(this));
            this.l = d.a.r0.r.d0.b.j().g("has_show_message_tab_tips", false);
            E();
            this.j = (ImageView) this.f62700a.findViewById(R.id.home_page_new_write_icon);
            this.k = (TextView) this.f62700a.findViewById(R.id.view_bottom_text);
            this.f62708i = (TextView) this.f62700a.findViewById(R.id.activity_prize_my_tip);
            this.f62701b.setUIType(0);
            this.f62701b.setTabContainerShadowShow(false);
            this.f62701b.setBackGroundStyle(0);
            this.f62701b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            D();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.f62700a.getPageContext()));
            d0(z);
            if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.f62700a.registerListener(this.E);
            }
            this.f62700a.registerListener(this.F);
            this.f62700a.registerListener(this.A);
            this.f62700a.registerListener(this.D);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.B);
        }
    }

    public void P() {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (fragmentTabHost = this.f62701b) == null) {
            return;
        }
        if (fragmentTabHost.getCurrentTabType() == 8 || this.f62701b.getCurrentTabType() == 3 || this.f62701b.getCurrentTabType() == 2 || this.f62701b.getCurrentTabType() == 15 || this.f62701b.getCurrentTabType() == 1) {
            NavigationBar navigationBar = this.f62702c;
            if (navigationBar != null) {
                navigationBar.setVisibility(8);
            }
            this.f62707h.setVisibility(8);
        }
    }

    public void Q(int i2) {
        MaintabBottomIndicator maintabBottomIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            C().setCurrentTabByType(i2);
            if (i2 != 2) {
                this.y = true;
                if (this.w && (maintabBottomIndicator = this.u) != null) {
                    maintabBottomIndicator.x(false);
                }
                this.w = false;
                if (A() != null) {
                    A().A = this.w;
                }
            }
        }
    }

    public final void R(boolean z) {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (layoutParams = (FrameLayout.LayoutParams) this.f62705f.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            layoutParams.rightMargin = d.a.c.e.p.l.g(this.f62700a.getPageContext().getPageActivity(), R.dimen.ds32);
        } else {
            layoutParams.rightMargin = d.a.c.e.p.l.g(this.f62700a.getPageContext().getPageActivity(), R.dimen.ds20);
        }
        this.f62705f.setLayoutParams(layoutParams);
    }

    public void S() {
        FragmentTabHost fragmentTabHost;
        FragmentTabHost.b g2;
        d.a.r0.e0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (fragmentTabHost = this.f62701b) == null || (g2 = fragmentTabHost.g(fragmentTabHost.getCurrentTabType())) == null || (bVar = g2.f12349d) == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        String string = this.f62700a.getPageContext().getString(g2.f12349d.getFragmentTabStructure().f55252b);
        TextView textView = this.f62703d;
        if (textView != null) {
            textView.setText(string);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            d.a.r0.r.d0.b.j().t("has_show_message_tab_tips", this.l);
        }
    }

    public void U(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.f62708i.setVisibility(8);
                return;
            }
            FragmentTabHost.b g2 = this.f62701b.g(8);
            if (g2 != null) {
                if (this.p && ((popupWindow = this.o) == null || !popupWindow.isShowing())) {
                    V(str, g2);
                    return;
                }
                if (this.G == null) {
                    this.G = new t(this, str);
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.G);
                TbadkCoreApplication.getInst().handler.postDelayed(this.G, 5000L);
                return;
            }
            this.f62708i.setVisibility(8);
        }
    }

    public final void V(String str, FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, bVar) == null) {
            int[] iArr = new int[2];
            bVar.f12347b.getLocationInWindow(iArr);
            int width = iArr[0] + (bVar.f12347b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f62708i.getLayoutParams();
            layoutParams.rightMargin = (d.a.c.e.p.l.q(this.f62700a).widthPixels - width) - d.a.c.e.p.l.g(this.f62700a.getPageContext().getPageActivity(), R.dimen.ds26);
            this.f62708i.setLayoutParams(layoutParams);
            this.f62708i.setVisibility(0);
            this.f62708i.setText(str);
        }
    }

    public void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f62700a.getActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.close, new k(this));
            aVar.setNegativeButton(R.string.check, new l(this));
            aVar.create(this.f62700a.getPageContext()).show();
        }
    }

    public void X(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (imageView = this.f62705f) == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && H()) {
            if (z) {
                if (this.f62706g.getVisibility() != 0) {
                    this.f62706g.setVisibility(0);
                    R(true);
                    SkinManager.setImageResource(this.f62706g, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            R(false);
            this.f62706g.setVisibility(8);
        }
    }

    public void Z(PayMemberInfoData payMemberInfoData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048601, this, payMemberInfoData, i2) == null) || payMemberInfoData == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f62700a.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        if (!StringUtils.isNull(payMemberInfoData.x())) {
            textView.setText(payMemberInfoData.x());
        }
        if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
            tbImageView.M(payMemberInfoData.getUrl(), 21, false);
            tbImageView.setIsNight(z);
        } else {
            SkinManager.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
        }
        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f62700a.getPageContext().getPageActivity());
        aVar.setContentView(inflate);
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setNegativeButton(R.string.know, new b(this, aVar, i2));
        String string = this.f62700a.getPageContext().getString(R.string.member_continue_pay);
        if (i2 == 0) {
            string = this.f62700a.getPageContext().getString(R.string.open_member);
        }
        aVar.setPositiveButton(string, new c(this, aVar, i2));
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(this.f62700a.getPageContext()).show();
        d.a.r0.r.d0.b.j().t("show_member_deid_line", false);
    }

    public void a0(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.s == null) {
                MainTabActivity mainTabActivity = this.f62700a;
                this.s = new d.a.s0.v3.e(mainTabActivity, mainTabActivity.getActivityRootView());
            }
            this.s.g(postWriteCallBackData);
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            if (z) {
                this.f62704e.setVisibility(0);
                this.f62707h.setVisibility(8);
                return;
            }
            this.f62704e.setVisibility(8);
            this.f62707h.setVisibility(0);
        }
    }

    public void c0(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, postWriteCallBackData) == null) {
            if (this.r == null) {
                this.r = new d.a.s0.e0.h(this.f62700a.getPageContext(), (NavigationBarCoverTip) this.f62700a.findViewById(R.id.navigation_cover_tip));
            }
            this.r.m(postWriteCallBackData);
        }
    }

    public void d0(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || (navigationBar = this.f62702c) == null) {
            return;
        }
        navigationBar.switchNaviBarStatus(z);
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.n = z;
            if (z) {
                return;
            }
            d.a.r0.r.d0.b.j().t("enter_forum_edit_mode", false);
        }
    }

    public boolean x(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || d.a.c.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (d.a.r0.r.d0.b.j().g(d.a.r0.r.d0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f62700a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void y(d.a.r0.e0.b bVar, d.a.r0.e0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048608, this, bVar, cVar, tbFragmentTabIndicator) == null) && cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.f12348c = cVar.f55251a;
            bVar2.f12346a = cVar.f55255e;
            maintabBottomIndicator.setShowIconType(cVar.f55259i);
            int i2 = cVar.f55259i;
            if (i2 == d.a.r0.e0.c.j) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (i2 == d.a.r0.e0.c.m) {
                maintabBottomIndicator.setText(cVar.f55252b);
                maintabBottomIndicator.setAnimationResId(cVar.f55256f);
                this.t = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.f55252b);
                maintabBottomIndicator.setAnimationResId(cVar.f55256f);
            }
            if (!d.a.c.e.p.k.isEmpty(cVar.f55257g)) {
                maintabBottomIndicator.setImageIconUrl(cVar.f55257g, cVar.f55253c);
            }
            d.a.r0.e0.e.a aVar = cVar.f55258h;
            if (aVar != null) {
                maintabBottomIndicator.setDynamicIconData(aVar);
            }
            if (bVar2.f12346a == 2) {
                maintabBottomIndicator.D = true;
                this.u = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.f12347b = maintabBottomIndicator;
            bVar2.f12349d = bVar;
            this.f62701b.c(bVar2, -1, z);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.q.removeCallbacks(this.H);
            this.q.removeCallbacks(this.I);
            d.a.c.e.m.g.c(this.o);
        }
    }
}

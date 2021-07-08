package d.a.p0.k3;

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
import d.a.o0.r.s.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
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
    public MainTabActivity f59463a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f59464b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59465c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59466d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f59467e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59468f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59469g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f59470h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f59471i;
    public ImageView j;
    public TextView k;
    public boolean l;
    public int m;
    public boolean n;
    public PopupWindow o;
    public boolean p;
    public Handler q;
    public d.a.p0.e0.h r;
    public d.a.p0.v3.e s;
    public MaintabBottomIndicator t;
    public MaintabBottomIndicator u;
    public int v;
    public boolean w;
    public int x;
    public boolean y;
    public FragmentTabHost.a z;

    /* loaded from: classes8.dex */
    public class a implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f59472a;

        /* renamed from: d.a.p0.k3.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1513a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f59473e;

            public RunnableC1513a(a aVar, CustomResponsedMessage customResponsedMessage) {
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
                this.f59473e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.f59473e);
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
            this.f59472a = dVar;
        }

        public final void a(int i2) {
            String m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f59472a.f59464b.f(i2).f12363a == 2) {
                    m = TbPageExtraHelper.l(this.f59472a.f59463a.getPageContext().getContext());
                } else {
                    m = TbPageExtraHelper.m();
                }
                d.a.c.e.m.e.a().postDelayed(new RunnableC1513a(this, new CustomResponsedMessage(2921520, m)), 100L);
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                int i3 = this.f59472a.f59464b.f(i2).f12363a;
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
                FragmentTabHost.b f2 = this.f59472a.f59464b.f(i2);
                if (f2.f12363a == 2 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f59472a.f59463a.getPageContext(), null)) {
                    int i3 = f2.f12363a;
                    if (i3 != 9) {
                        if (i3 == 8 && !ViewHelper.checkUpIsLogin(this.f59472a.f59463a.getActivity())) {
                            if (this.f59472a.t != null) {
                                this.f59472a.t.n();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                            return false;
                        }
                        int i4 = f2.f12363a;
                        if (i4 != 15) {
                            if (i4 == 3 && !ViewHelper.checkUpIsLogin(this.f59472a.f59463a.getActivity())) {
                                return false;
                            }
                            if (f2.f12363a == 1) {
                                TiebaStatic.log(new StatisticItem("c13001"));
                            }
                        } else {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f59472a.f59463a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                                return false;
                            }
                        }
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new d.a.o0.t.k(0)));
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
                FragmentTabHost.b f2 = this.f59472a.f59464b.f(i2);
                int i3 = f2.f12363a;
                if (i3 == 8) {
                    if (this.f59472a.t != null && this.f59472a.t.getAnimationView() != null && this.f59472a.t.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.f59472a.t != null) {
                        this.f59472a.t.n();
                    }
                    TiebaStatic.log("c13841");
                } else if (i3 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                }
                if (f2.f12363a == 2) {
                    if (this.f59472a.w) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.f59472a.w = true;
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if (this.f59472a.x != 2 || this.f59472a.v == i2 || homeBarShowType != 1 || this.f59472a.u == null) {
                        if (this.f59472a.x == 1 && this.f59472a.u != null) {
                            this.f59472a.u.x(this.f59472a.w);
                        }
                    } else {
                        this.f59472a.u.y();
                    }
                    this.f59472a.y = false;
                } else {
                    this.f59472a.y = true;
                    if (this.f59472a.w && this.f59472a.u != null) {
                        this.f59472a.u.x(this.f59472a.w);
                    }
                    this.f59472a.w = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                }
                if (this.f59472a.A() != null) {
                    this.f59472a.A().A = this.f59472a.w;
                }
                b(this.f59472a.v);
                a(this.f59472a.v);
                this.f59472a.v = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i2)));
                if (f2.f12363a != 22) {
                    if (this.f59472a.f59464b.getFragmentTabWidget() != null) {
                        this.f59472a.f59464b.getFragmentTabWidget().g(false, R.color.CAM_X0207);
                    }
                    this.f59472a.f59464b.n(false);
                } else {
                    TiebaStatic.log(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 1));
                    if (this.f59472a.f59464b.f(this.f59472a.f59464b.getCurrentTabIndex()).f12363a != 22) {
                        if (this.f59472a.f59464b.getFragmentTabWidget() != null) {
                            this.f59472a.f59464b.getFragmentTabWidget().g(true, R.color.CAM_X0215);
                        }
                        this.f59472a.f59464b.n(true);
                        if (!d.a.c.e.p.j.z()) {
                            d.a.c.e.p.l.J(this.f59472a.f59463a, this.f59472a.f59463a.getResources().getString(R.string.neterror));
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.TRUE));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.FALSE));
                    }
                }
                if (f2.f12363a == 1 && TbSingleton.getInstance().needRefreshForumSquare) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921589));
                    TbSingleton.getInstance().needRefreshForumSquare = false;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f59474e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f59475f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f59476g;

        public b(d dVar, d.a.o0.r.s.a aVar, int i2) {
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
            this.f59476g = dVar;
            this.f59474e = aVar;
            this.f59475f = i2;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f59474e.dismiss();
                int i2 = this.f59475f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f59476g.f59463a.getPageContext().getPageActivity(), "user_overdue_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f59476g.f59463a.getPageContext().getPageActivity(), "user_expire_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f59477e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f59478f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f59479g;

        public c(d dVar, d.a.o0.r.s.a aVar, int i2) {
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
            this.f59479g = dVar;
            this.f59477e = aVar;
            this.f59478f = i2;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f59477e.dismiss();
                int i2 = this.f59478f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f59479g.f59463a.getPageContext().getPageActivity(), "user_overdue_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4006001000";
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f59479g.f59463a.getPageContext().getPageActivity(), "user_expire_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4005001000";
                } else {
                    str = null;
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f59479g.f59463a.getPageContext().getPageActivity(), 2);
                if (!StringUtils.isNULL(str)) {
                    memberPayActivityConfig.setSceneId(str);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* renamed from: d.a.p0.k3.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1514d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f59480e;

        public View$OnClickListenerC1514d(d dVar) {
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
            this.f59480e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59480e.R(false);
                this.f59480e.f59469g.setVisibility(8);
                d.a.o0.r.d0.b.j().t("game_is_show_tip", false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, Boolean.FALSE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, this.f59480e.f59463a.getPageContext()));
                TiebaStatic.eventStat(this.f59480e.f59463a.getPageContext().getPageActivity(), "tb_gamecenter", PrefetchEvent.STATE_CLICK, 1, "ref_type", "601");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f59481e;

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
            this.f59481e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59481e.f59463a.sendMessage(new CustomMessage(2015003, new IntentConfig(this.f59481e.f59463a.getPageContext().getPageActivity())));
                int i2 = 3;
                if (this.f59481e.f59464b.getCurrentTabType() != 3) {
                    i2 = this.f59481e.f59464b.getCurrentTabType() == 2 ? 1 : 0;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", i2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f59482e;

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
            this.f59482e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                this.f59482e.f59463a.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(this.f59482e.f59463a.getPageContext().getPageActivity())));
                TiebaStatic.log("c10085");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f59483e;

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
            this.f59483e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f59483e.f59463a.getPageContext().getPageActivity(), "notlogin_4", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                ViewHelper.skipToLoginActivity(this.f59483e.f59463a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f59484e;

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
            this.f59484e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f59484e.f59463a.getPageContext().getPageActivity(), "notlogin_3", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                int i2 = this.f59484e.m;
                TiebaStatic.log(new StatisticItem("c10517").param("obj_source", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 8 ? "" : "profile" : "message" : "kantie" : "forum"));
                ViewHelper.skipToRegisterActivity(this.f59484e.f59463a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f59485e;

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
            this.f59485e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59485e.f59464b == null || this.f59485e.o == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f59485e.f59464b.getFragmentTabWidget();
            d.a.c.e.p.l.k(this.f59485e.f59463a.getActivity());
            int g2 = d.a.c.e.p.l.g(this.f59485e.f59463a.getActivity(), R.dimen.ds178);
            View contentView = this.f59485e.o.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b g3 = this.f59485e.f59464b.g(3);
            if (g3 == null || (tbFragmentTabIndicator = g3.f12364b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = d.a.c.e.p.l.g(this.f59485e.f59463a.getActivity(), R.dimen.tbds570);
            }
            d.a.c.e.m.g.l(this.f59485e.o, fragmentTabWidget, measuredWidth2, -g2);
            d.a.o0.r.d0.b.j().t("show_maintab_last_message_tips", true);
            this.f59485e.p = true;
            this.f59485e.q.postDelayed(this.f59485e.I, 5000L);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f59486e;

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
            this.f59486e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59486e.z();
            }
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "1");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
                d.a.p0.b1.a.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f59487a;

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
            this.f59487a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.o0.e0.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f59487a.f59464b == null || !(customResponsedMessage.getData() instanceof d.a.o0.e0.c) || (cVar = (d.a.o0.e0.c) customResponsedMessage.getData()) == null || this.f59487a.f59464b.g(cVar.f51960e) == null || this.f59487a.f59464b.getCurrentTabType() == cVar.f51960e) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = this.f59487a.f59464b.g(cVar.f51960e).f12364b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(cVar.f51962g, cVar.f51958c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f59488a;

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
            this.f59488a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.h(this.f59488a.f59463a, this.f59488a.f59463a.getUniqueId(), (View) customResponsedMessage.getData(), this.f59488a.f59463a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements ItemCardHelper.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f59489a;

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
            this.f59489a = dVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.q(this.f59489a.f59463a, ItemCardHelper.OrderTipStatus.FAIL, this.f59489a.f59463a.getActivityRootView());
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.q(this.f59489a.f59463a, ItemCardHelper.OrderTipStatus.SUCCESS, this.f59489a.f59463a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f59490a;

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
            this.f59490a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.o0.e0.e.a c2;
            d.a.o0.e0.e.a c3;
            d.a.o0.e0.e.a c4;
            d.a.o0.e0.e.a c5;
            d.a.o0.e0.e.a c6;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f59490a.f59464b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FragmentTabHost.b g2 = this.f59490a.f59464b.g(2);
                if (g2 != null && (g2.f12364b instanceof MaintabBottomIndicator) && (c6 = d.a.o0.e0.e.c.d().c("homePage")) != null) {
                    ((MaintabBottomIndicator) g2.f12364b).setDynamicIconData(c6);
                }
                FragmentTabHost.b g3 = this.f59490a.f59464b.g(1);
                if (g3 != null && (g3.f12364b instanceof MaintabBottomIndicator) && (c5 = d.a.o0.e0.e.c.d().c("enterForum")) != null) {
                    ((MaintabBottomIndicator) g3.f12364b).setDynamicIconData(c5);
                }
                FragmentTabHost.b g4 = this.f59490a.f59464b.g(22);
                if (g4 != null && (g4.f12364b instanceof MaintabBottomIndicator) && (c4 = d.a.o0.e0.e.c.d().c("channel")) != null) {
                    ((MaintabBottomIndicator) g4.f12364b).setDynamicIconData(c4);
                }
                FragmentTabHost.b g5 = this.f59490a.f59464b.g(3);
                if (g5 != null && (g5.f12364b instanceof MaintabBottomIndicator) && (c3 = d.a.o0.e0.e.c.d().c("message")) != null) {
                    ((MaintabBottomIndicator) g5.f12364b).setDynamicIconData(c3);
                }
                FragmentTabHost.b g6 = this.f59490a.f59464b.g(8);
                if (g6 == null || !(g6.f12364b instanceof MaintabBottomIndicator) || (c2 = d.a.o0.e0.e.c.d().c("person")) == null) {
                    return;
                }
                ((MaintabBottomIndicator) g6.f12364b).setDynamicIconData(c2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f59491a;

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
            this.f59491a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f59491a.A() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int intValue = ((Integer) data).intValue();
                if (intValue == 4) {
                    this.f59491a.y = true;
                    this.f59491a.w = true;
                    if (this.f59491a.x != 2) {
                        if (this.f59491a.u == null || !this.f59491a.u.p()) {
                            return;
                        }
                        this.f59491a.u.x(this.f59491a.w);
                        return;
                    }
                    this.f59491a.A().w();
                    return;
                }
                if (intValue == 6) {
                    this.f59491a.y = false;
                    if (this.f59491a.x == 1) {
                        return;
                    }
                } else {
                    this.f59491a.x = intValue;
                }
                if (this.f59491a.x == 1) {
                    this.f59491a.A().x(this.f59491a.w);
                } else if (this.f59491a.x == 2) {
                    this.f59491a.A().y();
                } else if (intValue == 5) {
                    this.f59491a.x = 1;
                    this.f59491a.w = true;
                    if (!this.f59491a.y) {
                        this.f59491a.A().w();
                    }
                } else {
                    this.f59491a.A().v();
                }
                this.f59491a.A().z = true;
                this.f59491a.A().B = this.f59491a.x;
                this.f59491a.A().A = this.f59491a.w;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f59492a;

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
            this.f59492a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f59492a.w = true;
                if (this.f59492a.A() != null) {
                    this.f59492a.A().A = this.f59492a.w;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f59493e;

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
            this.f59493e = dVar;
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
                if (this.f59493e.f59464b.getCurrentTabType() != 2) {
                    if (this.f59493e.f59464b.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                this.f59493e.P();
                if (this.f59493e.f59464b.getCurrentTabType() != this.f59493e.f59464b.f(i2).f12363a) {
                    this.f59493e.f59464b.setCurrentTab(i2);
                }
                if (this.f59493e.f59464b.getCurrentTabType() != 1) {
                    this.f59493e.f59467e.setVisibility(8);
                    this.f59493e.f59470h.setVisibility(0);
                }
                if (this.f59493e.f59464b.getCurrentTabType() == 1 && !d.a.o0.r.d0.b.j().g("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d dVar = this.f59493e;
                dVar.m = dVar.f59464b.getCurrentTabType();
                this.f59493e.S();
                if (d.a.o0.r.d0.b.j().g("enter_forum_edit_mode", false)) {
                    if (this.f59493e.f59464b.getCurrentTabType() != 3) {
                        if (this.f59493e.f59464b.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (this.f59493e.f59464b.getCurrentTabType() == 3) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59494e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f59495f;

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
            this.f59495f = dVar;
            this.f59494e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59495f.U(this.f59494e);
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
        this.f59463a = mainTabActivity;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59464b : (FragmentTabHost) invokeV.objValue;
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
            NavigationBar navigationBar = (NavigationBar) this.f59463a.findViewById(R.id.view_navigation_bar);
            this.f59465c = navigationBar;
            if (navigationBar != null) {
                this.f59466d = (TextView) navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimension = (int) this.f59463a.getResources().getDimension(R.dimen.ds16);
                layoutParams.setMargins(dimension, dimension, 0, dimension);
                this.f59466d.setLayoutParams(layoutParams);
                View addCustomView = this.f59465c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
                this.f59468f = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
                this.f59469g = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
                this.f59468f.setOnClickListener(new View$OnClickListenerC1514d(this));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(0, 0, d.a.c.e.p.l.g(this.f59463a.getPageContext().getPageActivity(), R.dimen.ds16), 0);
                ImageView imageView = (ImageView) this.f59465c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
                this.f59470h = imageView;
                imageView.setLayoutParams(layoutParams2);
                this.f59470h.setVisibility(8);
                this.f59470h.setOnClickListener(new e(this));
                ImageView imageView2 = (ImageView) this.f59465c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
                this.f59467e = imageView2;
                imageView2.setLayoutParams(layoutParams2);
                this.f59467e.setVisibility(8);
                this.f59467e.setOnClickListener(new f(this));
                this.f59465c.setLoginClickListener(new g(this));
                this.f59465c.setRegisterClickListener(new h(this));
            }
        }
    }

    public void F(ArrayList<d.a.o0.e0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.f59464b.q();
            Iterator<d.a.o0.e0.b> it = arrayList.iterator();
            while (it.hasNext()) {
                d.a.o0.e0.b next = it.next();
                if (next != null && next.isAvailable()) {
                    y(next, next.getFragmentTabStructure(), next.getTabIndicator(this.f59463a.getPageContext().getPageActivity()));
                }
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.f59464b.k(2);
            } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f59464b.k(1);
            } else {
                this.f59464b.k(0);
            }
            this.f59464b.setViewPagerScrollable(false);
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
            ImageView imageView = this.f59468f;
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
                this.f59464b.setShouldDrawTopLine(false);
            }
            this.f59464b.p(i2);
            FragmentTabHost fragmentTabHost = this.f59464b;
            FragmentTabHost.b f2 = fragmentTabHost.f(fragmentTabHost.getCurrentTabIndex());
            if (f2 != null && f2.f12363a == 22) {
                if (this.f59464b.getFragmentTabWidget() != null) {
                    this.f59464b.getFragmentTabWidget().g(true, R.color.CAM_X0215);
                }
                this.f59464b.n(true);
            } else {
                if (this.f59464b.getFragmentTabWidget() != null) {
                    this.f59464b.getFragmentTabWidget().g(false, R.color.CAM_X0207);
                }
                this.f59464b.n(false);
            }
            this.f59465c.onChangeSkinType(this.f59463a.getPageContext(), i2);
            SkinManager.setNavbarTitleColor(this.f59466d, R.color.CAM_X0105, R.color.s_navbar_title_color, i2);
            SkinManager.setImageResource(this.f59469g, R.drawable.icon_news_down_bar_one);
            SkinManager.setNavbarIconSrc(this.f59468f, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0106);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59470h, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59467e, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
            d.a.p0.e0.h hVar = this.r;
            if (hVar != null) {
                hVar.h();
            }
            d.a.p0.v3.e eVar = this.s;
            if (eVar != null) {
                eVar.e();
            }
        }
    }

    public void L(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (fragmentTabHost = this.f59464b) == null) {
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
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.f59463a.findViewById(R.id.tab_host);
            this.f59464b = fragmentTabHost;
            fragmentTabHost.setup(this.f59463a.getSupportFragmentManager());
            this.f59464b.setAbsoluteWeight(true);
            this.f59464b.setOnTabSelectionListener(this.z);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f59464b.setShouldDrawIndicatorLine(false);
                this.f59464b.setShouldDrawTopLine(true);
            }
            this.f59464b.setOnPageChangeListener(new s(this));
            this.l = d.a.o0.r.d0.b.j().g("has_show_message_tab_tips", false);
            E();
            this.j = (ImageView) this.f59463a.findViewById(R.id.home_page_new_write_icon);
            this.k = (TextView) this.f59463a.findViewById(R.id.view_bottom_text);
            this.f59471i = (TextView) this.f59463a.findViewById(R.id.activity_prize_my_tip);
            this.f59464b.setUIType(0);
            this.f59464b.setTabContainerShadowShow(false);
            this.f59464b.setBackGroundStyle(0);
            this.f59464b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            D();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.f59463a.getPageContext()));
            d0(z);
            if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.f59463a.registerListener(this.E);
            }
            this.f59463a.registerListener(this.F);
            this.f59463a.registerListener(this.A);
            this.f59463a.registerListener(this.D);
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
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (fragmentTabHost = this.f59464b) == null) {
            return;
        }
        if (fragmentTabHost.getCurrentTabType() == 8 || this.f59464b.getCurrentTabType() == 3 || this.f59464b.getCurrentTabType() == 2 || this.f59464b.getCurrentTabType() == 15 || this.f59464b.getCurrentTabType() == 1) {
            NavigationBar navigationBar = this.f59465c;
            if (navigationBar != null) {
                navigationBar.setVisibility(8);
            }
            this.f59470h.setVisibility(8);
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
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (layoutParams = (FrameLayout.LayoutParams) this.f59468f.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            layoutParams.rightMargin = d.a.c.e.p.l.g(this.f59463a.getPageContext().getPageActivity(), R.dimen.ds32);
        } else {
            layoutParams.rightMargin = d.a.c.e.p.l.g(this.f59463a.getPageContext().getPageActivity(), R.dimen.ds20);
        }
        this.f59468f.setLayoutParams(layoutParams);
    }

    public void S() {
        FragmentTabHost fragmentTabHost;
        FragmentTabHost.b g2;
        d.a.o0.e0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (fragmentTabHost = this.f59464b) == null || (g2 = fragmentTabHost.g(fragmentTabHost.getCurrentTabType())) == null || (bVar = g2.f12366d) == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        String string = this.f59463a.getPageContext().getString(g2.f12366d.getFragmentTabStructure().f51957b);
        TextView textView = this.f59466d;
        if (textView != null) {
            textView.setText(string);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            d.a.o0.r.d0.b.j().t("has_show_message_tab_tips", this.l);
        }
    }

    public void U(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.f59471i.setVisibility(8);
                return;
            }
            FragmentTabHost.b g2 = this.f59464b.g(8);
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
            this.f59471i.setVisibility(8);
        }
    }

    public final void V(String str, FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, bVar) == null) {
            int[] iArr = new int[2];
            bVar.f12364b.getLocationInWindow(iArr);
            int width = iArr[0] + (bVar.f12364b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f59471i.getLayoutParams();
            layoutParams.rightMargin = (d.a.c.e.p.l.q(this.f59463a).widthPixels - width) - d.a.c.e.p.l.g(this.f59463a.getPageContext().getPageActivity(), R.dimen.ds26);
            this.f59471i.setLayoutParams(layoutParams);
            this.f59471i.setVisibility(0);
            this.f59471i.setText(str);
        }
    }

    public void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f59463a.getActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.close, new k(this));
            aVar.setNegativeButton(R.string.check, new l(this));
            aVar.create(this.f59463a.getPageContext()).show();
        }
    }

    public void X(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (imageView = this.f59468f) == null) {
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
                if (this.f59469g.getVisibility() != 0) {
                    this.f59469g.setVisibility(0);
                    R(true);
                    SkinManager.setImageResource(this.f59469g, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            R(false);
            this.f59469g.setVisibility(8);
        }
    }

    public void Z(PayMemberInfoData payMemberInfoData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048601, this, payMemberInfoData, i2) == null) || payMemberInfoData == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f59463a.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
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
        d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f59463a.getPageContext().getPageActivity());
        aVar.setContentView(inflate);
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setNegativeButton(R.string.know, new b(this, aVar, i2));
        String string = this.f59463a.getPageContext().getString(R.string.member_continue_pay);
        if (i2 == 0) {
            string = this.f59463a.getPageContext().getString(R.string.open_member);
        }
        aVar.setPositiveButton(string, new c(this, aVar, i2));
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(this.f59463a.getPageContext()).show();
        d.a.o0.r.d0.b.j().t("show_member_deid_line", false);
    }

    public void a0(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.s == null) {
                MainTabActivity mainTabActivity = this.f59463a;
                this.s = new d.a.p0.v3.e(mainTabActivity, mainTabActivity.getActivityRootView());
            }
            this.s.g(postWriteCallBackData);
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            if (z) {
                this.f59467e.setVisibility(0);
                this.f59470h.setVisibility(8);
                return;
            }
            this.f59467e.setVisibility(8);
            this.f59470h.setVisibility(0);
        }
    }

    public void c0(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, postWriteCallBackData) == null) {
            if (this.r == null) {
                this.r = new d.a.p0.e0.h(this.f59463a.getPageContext(), (NavigationBarCoverTip) this.f59463a.findViewById(R.id.navigation_cover_tip));
            }
            this.r.l(postWriteCallBackData);
        }
    }

    public void d0(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || (navigationBar = this.f59465c) == null) {
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
            d.a.o0.r.d0.b.j().t("enter_forum_edit_mode", false);
        }
    }

    public boolean x(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || d.a.c.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (d.a.o0.r.d0.b.j().g(d.a.o0.r.d0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f59463a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void y(d.a.o0.e0.b bVar, d.a.o0.e0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048608, this, bVar, cVar, tbFragmentTabIndicator) == null) && cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.f12365c = cVar.f51956a;
            bVar2.f12363a = cVar.f51960e;
            maintabBottomIndicator.setShowIconType(cVar.f51964i);
            int i2 = cVar.f51964i;
            if (i2 == d.a.o0.e0.c.j) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (i2 == d.a.o0.e0.c.m) {
                maintabBottomIndicator.setText(cVar.f51957b);
                maintabBottomIndicator.setAnimationResId(cVar.f51961f);
                this.t = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.f51957b);
                maintabBottomIndicator.setAnimationResId(cVar.f51961f);
            }
            if (!d.a.c.e.p.k.isEmpty(cVar.f51962g)) {
                maintabBottomIndicator.setImageIconUrl(cVar.f51962g, cVar.f51958c);
            }
            d.a.o0.e0.e.a aVar = cVar.f51963h;
            if (aVar != null) {
                maintabBottomIndicator.setDynamicIconData(aVar);
            }
            if (bVar2.f12363a == 2) {
                maintabBottomIndicator.D = true;
                this.u = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.f12364b = maintabBottomIndicator;
            bVar2.f12366d = bVar;
            this.f59464b.c(bVar2, -1, z);
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

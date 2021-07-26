package d.a.q0.k3;

import android.os.Handler;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.view.MessageRedDotView;
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
import d.a.p0.s.s.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentTabHost.a A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public final ItemCardHelper.b D;
    public CustomMessageListener E;
    public CustomMessageListener F;
    public CustomMessageListener G;
    public Runnable H;
    public Runnable I;
    public Runnable J;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f60077a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f60078b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60079c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60080d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f60081e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f60082f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f60083g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f60084h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f60085i;
    public ImageView j;
    public TextView k;
    public boolean l;
    public int m;
    public boolean n;
    public PopupWindow o;
    public boolean p;
    public Handler q;
    public d.a.q0.e0.h r;
    public d.a.q0.v3.e s;
    public MaintabBottomIndicator t;
    public MaintabBottomIndicator u;
    public int v;
    public boolean w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f60086a;

        /* renamed from: d.a.q0.k3.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1518a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f60087e;

            public RunnableC1518a(a aVar, CustomResponsedMessage customResponsedMessage) {
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
                this.f60087e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.f60087e);
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
            this.f60086a = dVar;
        }

        public final void a(int i2) {
            String m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f60086a.f60078b.f(i2).f12393a == 2) {
                    m = TbPageExtraHelper.l(this.f60086a.f60077a.getPageContext().getContext());
                } else {
                    m = TbPageExtraHelper.m();
                }
                d.a.d.e.m.e.a().postDelayed(new RunnableC1518a(this, new CustomResponsedMessage(2921520, m)), 100L);
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                int i3 = this.f60086a.f60078b.f(i2).f12393a;
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
                FragmentTabHost.b f2 = this.f60086a.f60078b.f(i2);
                if (f2.f12393a == 2 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f60086a.f60077a.getPageContext(), null)) {
                    int i3 = f2.f12393a;
                    if (i3 != 9) {
                        if (i3 == 8 && !ViewHelper.checkUpIsLogin(this.f60086a.f60077a.getActivity())) {
                            if (this.f60086a.t != null) {
                                this.f60086a.t.n();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                            return false;
                        }
                        int i4 = f2.f12393a;
                        if (i4 != 15) {
                            if (i4 == 3 && !ViewHelper.checkUpIsLogin(this.f60086a.f60077a.getActivity())) {
                                return false;
                            }
                            if (f2.f12393a == 1) {
                                TiebaStatic.log(new StatisticItem("c13001"));
                            }
                        } else {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f60086a.f60077a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                                return false;
                            }
                        }
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new d.a.p0.u.j(0)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x01ae, code lost:
            if (com.baidu.tbadk.core.util.UtilHelper.isNumber(r9) != false) goto L45;
         */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                FragmentTabHost.b f2 = this.f60086a.f60078b.f(i2);
                int i3 = f2.f12393a;
                int i4 = 3;
                if (i3 == 8) {
                    if (this.f60086a.t != null && this.f60086a.t.getAnimationView() != null && this.f60086a.t.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.f60086a.t != null) {
                        this.f60086a.t.n();
                    }
                    TiebaStatic.log("c13841");
                } else if (i3 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                }
                int i5 = 2;
                if (f2.f12393a == 2) {
                    if (this.f60086a.w) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.f60086a.w = true;
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if (this.f60086a.x != 2 || this.f60086a.v == i2 || homeBarShowType != 1 || this.f60086a.u == null) {
                        if (this.f60086a.x == 1 && this.f60086a.u != null) {
                            this.f60086a.u.x(this.f60086a.w);
                        }
                    } else {
                        this.f60086a.u.y();
                    }
                    this.f60086a.y = false;
                } else {
                    this.f60086a.y = true;
                    if (this.f60086a.w && this.f60086a.u != null) {
                        this.f60086a.u.x(this.f60086a.w);
                    }
                    this.f60086a.w = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                }
                if (this.f60086a.C() != null) {
                    this.f60086a.C().A = this.f60086a.w;
                }
                b(this.f60086a.v);
                a(this.f60086a.v);
                this.f60086a.v = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i2)));
                if (f2.f12393a != 22) {
                    if (this.f60086a.f60078b.getFragmentTabWidget() != null) {
                        this.f60086a.f60078b.getFragmentTabWidget().g(false, R.color.CAM_X0207);
                    }
                    this.f60086a.f60078b.n(false);
                } else {
                    TbFragmentTabIndicator tbFragmentTabIndicator = f2.f12394b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        if (maintabBottomIndicator.d("video_msg") != null && (maintabBottomIndicator.d("video_msg").f13164a instanceof MessageRedDotView)) {
                            String redNum = ((MessageRedDotView) maintabBottomIndicator.d("video_msg").f13164a).getRedNum();
                            if (!TextUtils.isEmpty(redNum)) {
                            }
                        }
                    }
                    i5 = 1;
                    if (this.f60086a.z) {
                        this.f60086a.z = false;
                    } else {
                        i4 = i5;
                    }
                    TiebaStatic.log(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", i4));
                    if (this.f60086a.f60078b.f(this.f60086a.f60078b.getCurrentTabIndex()).f12393a != 22) {
                        if (this.f60086a.f60078b.getFragmentTabWidget() != null) {
                            this.f60086a.f60078b.getFragmentTabWidget().g(true, R.color.CAM_X0215);
                        }
                        this.f60086a.f60078b.n(true);
                        if (!d.a.d.e.p.j.z()) {
                            d.a.d.e.p.l.J(this.f60086a.f60077a, this.f60086a.f60077a.getResources().getString(R.string.neterror));
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.TRUE));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.FALSE));
                    }
                }
                if (f2.f12393a == 1 && TbSingleton.getInstance().needRefreshForumSquare) {
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
        public final /* synthetic */ d.a.p0.s.s.a f60088e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f60089f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f60090g;

        public b(d dVar, d.a.p0.s.s.a aVar, int i2) {
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
            this.f60090g = dVar;
            this.f60088e = aVar;
            this.f60089f = i2;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f60088e.dismiss();
                int i2 = this.f60089f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f60090g.f60077a.getPageContext().getPageActivity(), "user_overdue_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f60090g.f60077a.getPageContext().getPageActivity(), "user_expire_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f60091e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f60092f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f60093g;

        public c(d dVar, d.a.p0.s.s.a aVar, int i2) {
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
            this.f60093g = dVar;
            this.f60091e = aVar;
            this.f60092f = i2;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f60091e.dismiss();
                int i2 = this.f60092f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f60093g.f60077a.getPageContext().getPageActivity(), "user_overdue_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4006001000";
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f60093g.f60077a.getPageContext().getPageActivity(), "user_expire_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4005001000";
                } else {
                    str = null;
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f60093g.f60077a.getPageContext().getPageActivity(), 2);
                if (!StringUtils.isNULL(str)) {
                    memberPayActivityConfig.setSceneId(str);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* renamed from: d.a.q0.k3.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1519d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f60094e;

        public View$OnClickListenerC1519d(d dVar) {
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
            this.f60094e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60094e.T(false);
                this.f60094e.f60083g.setVisibility(8);
                d.a.p0.s.d0.b.j().t("game_is_show_tip", false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, Boolean.FALSE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, this.f60094e.f60077a.getPageContext()));
                TiebaStatic.eventStat(this.f60094e.f60077a.getPageContext().getPageActivity(), "tb_gamecenter", PrefetchEvent.STATE_CLICK, 1, "ref_type", "601");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f60095e;

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
            this.f60095e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60095e.f60077a.sendMessage(new CustomMessage(2015003, new IntentConfig(this.f60095e.f60077a.getPageContext().getPageActivity())));
                int i2 = 3;
                if (this.f60095e.f60078b.getCurrentTabType() != 3) {
                    i2 = this.f60095e.f60078b.getCurrentTabType() == 2 ? 1 : 0;
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
        public final /* synthetic */ d f60096e;

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
            this.f60096e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                this.f60096e.f60077a.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(this.f60096e.f60077a.getPageContext().getPageActivity())));
                TiebaStatic.log("c10085");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f60097e;

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
            this.f60097e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f60097e.f60077a.getPageContext().getPageActivity(), "notlogin_4", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                ViewHelper.skipToLoginActivity(this.f60097e.f60077a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f60098e;

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
            this.f60098e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f60098e.f60077a.getPageContext().getPageActivity(), "notlogin_3", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                int i2 = this.f60098e.m;
                TiebaStatic.log(new StatisticItem("c10517").param("obj_source", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 8 ? "" : "profile" : "message" : "kantie" : "forum"));
                ViewHelper.skipToRegisterActivity(this.f60098e.f60077a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f60099e;

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
            this.f60099e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60099e.f60078b == null || this.f60099e.o == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f60099e.f60078b.getFragmentTabWidget();
            d.a.d.e.p.l.k(this.f60099e.f60077a.getActivity());
            int g2 = d.a.d.e.p.l.g(this.f60099e.f60077a.getActivity(), R.dimen.ds178);
            View contentView = this.f60099e.o.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b g3 = this.f60099e.f60078b.g(3);
            if (g3 == null || (tbFragmentTabIndicator = g3.f12394b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = d.a.d.e.p.l.g(this.f60099e.f60077a.getActivity(), R.dimen.tbds570);
            }
            d.a.d.e.m.g.l(this.f60099e.o, fragmentTabWidget, measuredWidth2, -g2);
            d.a.p0.s.d0.b.j().t("show_maintab_last_message_tips", true);
            this.f60099e.p = true;
            this.f60099e.q.postDelayed(this.f60099e.J, 5000L);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f60100e;

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
            this.f60100e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60100e.B();
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
                d.a.q0.b1.a.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f60101a;

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
            this.f60101a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.p0.g0.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f60101a.f60078b == null || !(customResponsedMessage.getData() instanceof d.a.p0.g0.c) || (cVar = (d.a.p0.g0.c) customResponsedMessage.getData()) == null || this.f60101a.f60078b.g(cVar.f52622e) == null || this.f60101a.f60078b.getCurrentTabType() == cVar.f52622e) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = this.f60101a.f60078b.g(cVar.f52622e).f12394b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(cVar.f52624g, cVar.f52620c);
                if (TextUtils.isEmpty(cVar.f52624g)) {
                    return;
                }
                this.f60101a.z = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f60102a;

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
            this.f60102a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.j(this.f60102a.f60077a, this.f60102a.f60077a.getUniqueId(), (View) customResponsedMessage.getData(), this.f60102a.f60077a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements ItemCardHelper.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f60103a;

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
            this.f60103a = dVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.u(this.f60103a.f60077a, ItemCardHelper.OrderTipStatus.FAIL, this.f60103a.f60077a.getActivityRootView());
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.u(this.f60103a.f60077a, ItemCardHelper.OrderTipStatus.SUCCESS, this.f60103a.f60077a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f60104a;

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
            this.f60104a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.p0.g0.e.a c2;
            d.a.p0.g0.e.a c3;
            d.a.p0.g0.e.a c4;
            d.a.p0.g0.e.a c5;
            d.a.p0.g0.e.a c6;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f60104a.f60078b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FragmentTabHost.b g2 = this.f60104a.f60078b.g(2);
                if (g2 != null && (g2.f12394b instanceof MaintabBottomIndicator) && (c6 = d.a.p0.g0.e.c.d().c("homePage")) != null) {
                    ((MaintabBottomIndicator) g2.f12394b).setDynamicIconData(c6);
                }
                FragmentTabHost.b g3 = this.f60104a.f60078b.g(1);
                if (g3 != null && (g3.f12394b instanceof MaintabBottomIndicator) && (c5 = d.a.p0.g0.e.c.d().c("enterForum")) != null) {
                    ((MaintabBottomIndicator) g3.f12394b).setDynamicIconData(c5);
                }
                FragmentTabHost.b g4 = this.f60104a.f60078b.g(22);
                if (g4 != null && (g4.f12394b instanceof MaintabBottomIndicator) && (c4 = d.a.p0.g0.e.c.d().c("channel")) != null) {
                    ((MaintabBottomIndicator) g4.f12394b).setDynamicIconData(c4);
                }
                FragmentTabHost.b g5 = this.f60104a.f60078b.g(3);
                if (g5 != null && (g5.f12394b instanceof MaintabBottomIndicator) && (c3 = d.a.p0.g0.e.c.d().c("message")) != null) {
                    ((MaintabBottomIndicator) g5.f12394b).setDynamicIconData(c3);
                }
                FragmentTabHost.b g6 = this.f60104a.f60078b.g(8);
                if (g6 == null || !(g6.f12394b instanceof MaintabBottomIndicator) || (c2 = d.a.p0.g0.e.c.d().c("person")) == null) {
                    return;
                }
                ((MaintabBottomIndicator) g6.f12394b).setDynamicIconData(c2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f60105a;

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
            this.f60105a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f60105a.C() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int intValue = ((Integer) data).intValue();
                if (intValue == 4) {
                    this.f60105a.y = true;
                    this.f60105a.w = true;
                    if (this.f60105a.x != 2) {
                        if (this.f60105a.u == null || !this.f60105a.u.p()) {
                            return;
                        }
                        this.f60105a.u.x(this.f60105a.w);
                        return;
                    }
                    this.f60105a.C().w();
                    return;
                }
                if (intValue == 6) {
                    this.f60105a.y = false;
                    if (this.f60105a.x == 1) {
                        return;
                    }
                } else {
                    this.f60105a.x = intValue;
                }
                if (this.f60105a.x == 1) {
                    this.f60105a.C().x(this.f60105a.w);
                } else if (this.f60105a.x == 2) {
                    this.f60105a.C().y();
                } else if (intValue == 5) {
                    this.f60105a.x = 1;
                    this.f60105a.w = true;
                    if (!this.f60105a.y) {
                        this.f60105a.C().w();
                    }
                } else {
                    this.f60105a.C().v();
                }
                this.f60105a.C().z = true;
                this.f60105a.C().B = this.f60105a.x;
                this.f60105a.C().A = this.f60105a.w;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f60106a;

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
            this.f60106a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f60106a.w = true;
                if (this.f60106a.C() != null) {
                    this.f60106a.C().A = this.f60106a.w;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f60107e;

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
            this.f60107e = dVar;
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
                if (this.f60107e.f60078b.getCurrentTabType() != 2) {
                    if (this.f60107e.f60078b.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                this.f60107e.R();
                if (this.f60107e.f60078b.getCurrentTabType() != this.f60107e.f60078b.f(i2).f12393a) {
                    this.f60107e.f60078b.setCurrentTab(i2);
                }
                if (this.f60107e.f60078b.getCurrentTabType() != 1) {
                    this.f60107e.f60081e.setVisibility(8);
                    this.f60107e.f60084h.setVisibility(0);
                }
                if (this.f60107e.f60078b.getCurrentTabType() == 1 && !d.a.p0.s.d0.b.j().g("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d dVar = this.f60107e;
                dVar.m = dVar.f60078b.getCurrentTabType();
                this.f60107e.U();
                if (d.a.p0.s.d0.b.j().g("enter_forum_edit_mode", false)) {
                    if (this.f60107e.f60078b.getCurrentTabType() != 3) {
                        if (this.f60107e.f60078b.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (this.f60107e.f60078b.getCurrentTabType() == 3) {
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
        public final /* synthetic */ String f60108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f60109f;

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
            this.f60109f = dVar;
            this.f60108e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60109f.W(this.f60108e);
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
        this.z = false;
        this.A = new a(this);
        this.B = new m(this, 2921492);
        this.C = new n(this, 2001440);
        this.D = new o(this);
        this.E = new p(this, 2921551);
        this.F = new q(this, 2921382);
        this.G = new r(this, 2921410);
        this.I = new i(this);
        this.J = new j(this);
        this.f60077a = mainTabActivity;
    }

    public final void A(d.a.p0.g0.b bVar, d.a.p0.g0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, bVar, cVar, tbFragmentTabIndicator) == null) && cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.f12395c = cVar.f52618a;
            bVar2.f12393a = cVar.f52622e;
            maintabBottomIndicator.setShowIconType(cVar.f52626i);
            int i2 = cVar.f52626i;
            if (i2 == d.a.p0.g0.c.j) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (i2 == d.a.p0.g0.c.m) {
                maintabBottomIndicator.setText(cVar.f52619b);
                maintabBottomIndicator.setAnimationResId(cVar.f52623f);
                this.t = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.f52619b);
                maintabBottomIndicator.setAnimationResId(cVar.f52623f);
            }
            if (!d.a.d.e.p.k.isEmpty(cVar.f52624g)) {
                maintabBottomIndicator.setImageIconUrl(cVar.f52624g, cVar.f52620c);
            }
            d.a.p0.g0.e.a aVar = cVar.f52625h;
            if (aVar != null) {
                maintabBottomIndicator.setDynamicIconData(aVar);
            }
            if (bVar2.f12393a == 2) {
                maintabBottomIndicator.D = true;
                this.u = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.f12394b = maintabBottomIndicator;
            bVar2.f12396d = bVar;
            this.f60078b.c(bVar2, -1, z);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q.removeCallbacks(this.I);
            this.q.removeCallbacks(this.J);
            d.a.d.e.m.g.c(this.o);
        }
    }

    public MaintabBottomIndicator C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.u : (MaintabBottomIndicator) invokeV.objValue;
    }

    public MaintabBottomIndicator D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (MaintabBottomIndicator) invokeV.objValue;
    }

    public FragmentTabHost E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f60078b : (FragmentTabHost) invokeV.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f60077a.findViewById(R.id.view_navigation_bar);
            this.f60079c = navigationBar;
            if (navigationBar != null) {
                this.f60080d = (TextView) navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimension = (int) this.f60077a.getResources().getDimension(R.dimen.ds16);
                layoutParams.setMargins(dimension, dimension, 0, dimension);
                this.f60080d.setLayoutParams(layoutParams);
                View addCustomView = this.f60079c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
                this.f60082f = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
                this.f60083g = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
                this.f60082f.setOnClickListener(new View$OnClickListenerC1519d(this));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(0, 0, d.a.d.e.p.l.g(this.f60077a.getPageContext().getPageActivity(), R.dimen.ds16), 0);
                ImageView imageView = (ImageView) this.f60079c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
                this.f60084h = imageView;
                imageView.setLayoutParams(layoutParams2);
                this.f60084h.setVisibility(8);
                this.f60084h.setOnClickListener(new e(this));
                ImageView imageView2 = (ImageView) this.f60079c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
                this.f60081e = imageView2;
                imageView2.setLayoutParams(layoutParams2);
                this.f60081e.setVisibility(8);
                this.f60081e.setOnClickListener(new f(this));
                this.f60079c.setLoginClickListener(new g(this));
                this.f60079c.setRegisterClickListener(new h(this));
            }
        }
    }

    public void H(ArrayList<d.a.p0.g0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) {
            this.f60078b.q();
            Iterator<d.a.p0.g0.b> it = arrayList.iterator();
            while (it.hasNext()) {
                d.a.p0.g0.b next = it.next();
                if (next != null && next.isAvailable()) {
                    A(next, next.getFragmentTabStructure(), next.getTabIndicator(this.f60077a.getPageContext().getPageActivity()));
                }
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.f60078b.k(2);
            } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f60078b.k(1);
            } else {
                this.f60078b.k(0);
            }
            this.f60078b.setViewPagerScrollable(false);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.y = false;
            this.x = 1;
            if (C() != null) {
                C().B = this.x;
            }
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ImageView imageView = this.f60082f;
            return imageView != null && imageView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f60078b.setShouldDrawTopLine(false);
            }
            this.f60078b.p(i2);
            FragmentTabHost fragmentTabHost = this.f60078b;
            FragmentTabHost.b f2 = fragmentTabHost.f(fragmentTabHost.getCurrentTabIndex());
            if (f2 != null && f2.f12393a == 22) {
                if (this.f60078b.getFragmentTabWidget() != null) {
                    this.f60078b.getFragmentTabWidget().g(true, R.color.CAM_X0215);
                }
                this.f60078b.n(true);
            } else {
                if (this.f60078b.getFragmentTabWidget() != null) {
                    this.f60078b.getFragmentTabWidget().g(false, R.color.CAM_X0207);
                }
                this.f60078b.n(false);
            }
            this.f60079c.onChangeSkinType(this.f60077a.getPageContext(), i2);
            SkinManager.setNavbarTitleColor(this.f60080d, R.color.CAM_X0105, R.color.s_navbar_title_color, i2);
            SkinManager.setImageResource(this.f60083g, R.drawable.icon_news_down_bar_one);
            SkinManager.setNavbarIconSrc(this.f60082f, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0106);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60084h, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60081e, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            V();
            if (E() != null) {
                E().q();
            }
            B();
            d.a.q0.e0.h hVar = this.r;
            if (hVar != null) {
                hVar.h();
            }
            d.a.q0.v3.e eVar = this.s;
            if (eVar != null) {
                eVar.e();
            }
        }
    }

    public void N(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (fragmentTabHost = this.f60078b) == null) {
            return;
        }
        if (z) {
            fragmentTabHost.h();
            F();
            return;
        }
        fragmentTabHost.r();
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ItemCardHelper.s(this.D);
            MessageManager.getInstance().registerListener(this.C);
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.f60077a.findViewById(R.id.tab_host);
            this.f60078b = fragmentTabHost;
            fragmentTabHost.setup(this.f60077a.getSupportFragmentManager());
            this.f60078b.setAbsoluteWeight(true);
            this.f60078b.setOnTabSelectionListener(this.A);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f60078b.setShouldDrawIndicatorLine(false);
                this.f60078b.setShouldDrawTopLine(true);
            }
            this.f60078b.setOnPageChangeListener(new s(this));
            this.l = d.a.p0.s.d0.b.j().g("has_show_message_tab_tips", false);
            G();
            this.j = (ImageView) this.f60077a.findViewById(R.id.home_page_new_write_icon);
            this.k = (TextView) this.f60077a.findViewById(R.id.view_bottom_text);
            this.f60085i = (TextView) this.f60077a.findViewById(R.id.activity_prize_my_tip);
            this.f60078b.setUIType(0);
            this.f60078b.setTabContainerShadowShow(false);
            this.f60078b.setBackGroundStyle(0);
            this.f60078b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            F();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.f60077a.getPageContext()));
            f0(z);
            if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.f60077a.registerListener(this.F);
            }
            this.f60077a.registerListener(this.G);
            this.f60077a.registerListener(this.B);
            this.f60077a.registerListener(this.E);
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.C);
        }
    }

    public void R() {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (fragmentTabHost = this.f60078b) == null) {
            return;
        }
        if (fragmentTabHost.getCurrentTabType() == 8 || this.f60078b.getCurrentTabType() == 3 || this.f60078b.getCurrentTabType() == 2 || this.f60078b.getCurrentTabType() == 15 || this.f60078b.getCurrentTabType() == 1) {
            NavigationBar navigationBar = this.f60079c;
            if (navigationBar != null) {
                navigationBar.setVisibility(8);
            }
            this.f60084h.setVisibility(8);
        }
    }

    public void S(int i2) {
        MaintabBottomIndicator maintabBottomIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            E().setCurrentTabByType(i2);
            if (i2 != 2) {
                this.y = true;
                if (this.w && (maintabBottomIndicator = this.u) != null) {
                    maintabBottomIndicator.x(false);
                }
                this.w = false;
                if (C() != null) {
                    C().A = this.w;
                }
            }
        }
    }

    public final void T(boolean z) {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (layoutParams = (FrameLayout.LayoutParams) this.f60082f.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            layoutParams.rightMargin = d.a.d.e.p.l.g(this.f60077a.getPageContext().getPageActivity(), R.dimen.ds32);
        } else {
            layoutParams.rightMargin = d.a.d.e.p.l.g(this.f60077a.getPageContext().getPageActivity(), R.dimen.ds20);
        }
        this.f60082f.setLayoutParams(layoutParams);
    }

    public void U() {
        FragmentTabHost fragmentTabHost;
        FragmentTabHost.b g2;
        d.a.p0.g0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (fragmentTabHost = this.f60078b) == null || (g2 = fragmentTabHost.g(fragmentTabHost.getCurrentTabType())) == null || (bVar = g2.f12396d) == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        String string = this.f60077a.getPageContext().getString(g2.f12396d.getFragmentTabStructure().f52619b);
        TextView textView = this.f60080d;
        if (textView != null) {
            textView.setText(string);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            d.a.p0.s.d0.b.j().t("has_show_message_tab_tips", this.l);
        }
    }

    public void W(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.f60085i.setVisibility(8);
                return;
            }
            FragmentTabHost.b g2 = this.f60078b.g(8);
            if (g2 != null) {
                if (this.p && ((popupWindow = this.o) == null || !popupWindow.isShowing())) {
                    X(str, g2);
                    return;
                }
                if (this.H == null) {
                    this.H = new t(this, str);
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.H);
                TbadkCoreApplication.getInst().handler.postDelayed(this.H, 5000L);
                return;
            }
            this.f60085i.setVisibility(8);
        }
    }

    public final void X(String str, FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, bVar) == null) {
            int[] iArr = new int[2];
            bVar.f12394b.getLocationInWindow(iArr);
            int width = iArr[0] + (bVar.f12394b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f60085i.getLayoutParams();
            layoutParams.rightMargin = (d.a.d.e.p.l.q(this.f60077a).widthPixels - width) - d.a.d.e.p.l.g(this.f60077a.getPageContext().getPageActivity(), R.dimen.ds26);
            this.f60085i.setLayoutParams(layoutParams);
            this.f60085i.setVisibility(0);
            this.f60085i.setText(str);
        }
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f60077a.getActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.close, new k(this));
            aVar.setNegativeButton(R.string.check, new l(this));
            aVar.create(this.f60077a.getPageContext()).show();
        }
    }

    public void Z(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (imageView = this.f60082f) == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048602, this, z) == null) && J()) {
            if (z) {
                if (this.f60083g.getVisibility() != 0) {
                    this.f60083g.setVisibility(0);
                    T(true);
                    SkinManager.setImageResource(this.f60083g, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            T(false);
            this.f60083g.setVisibility(8);
        }
    }

    public void b0(PayMemberInfoData payMemberInfoData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048603, this, payMemberInfoData, i2) == null) || payMemberInfoData == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f60077a.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
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
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f60077a.getPageContext().getPageActivity());
        aVar.setContentView(inflate);
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setNegativeButton(R.string.know, new b(this, aVar, i2));
        String string = this.f60077a.getPageContext().getString(R.string.member_continue_pay);
        if (i2 == 0) {
            string = this.f60077a.getPageContext().getString(R.string.open_member);
        }
        aVar.setPositiveButton(string, new c(this, aVar, i2));
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(this.f60077a.getPageContext()).show();
        d.a.p0.s.d0.b.j().t("show_member_deid_line", false);
    }

    public void c0(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.s == null) {
                MainTabActivity mainTabActivity = this.f60077a;
                this.s = new d.a.q0.v3.e(mainTabActivity, mainTabActivity.getActivityRootView());
            }
            this.s.g(postWriteCallBackData);
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            if (z) {
                this.f60081e.setVisibility(0);
                this.f60084h.setVisibility(8);
                return;
            }
            this.f60081e.setVisibility(8);
            this.f60084h.setVisibility(0);
        }
    }

    public void e0(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, postWriteCallBackData) == null) {
            if (this.r == null) {
                this.r = new d.a.q0.e0.h(this.f60077a.getPageContext(), (NavigationBarCoverTip) this.f60077a.findViewById(R.id.navigation_cover_tip));
            }
            this.r.l(postWriteCallBackData);
        }
    }

    public void f0(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || (navigationBar = this.f60079c) == null) {
            return;
        }
        navigationBar.switchNaviBarStatus(z);
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.n = z;
            if (z) {
                return;
            }
            d.a.p0.s.d0.b.j().t("enter_forum_edit_mode", false);
        }
    }

    public boolean z(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || d.a.d.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (d.a.p0.s.d0.b.j().g(d.a.p0.s.d0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f60077a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

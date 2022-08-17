package com.repackage;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
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
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SoLoadUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
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
import com.repackage.ur4;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes6.dex */
public class mn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final ItemCardHelper.c B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public Runnable F;
    public Runnable G;
    public Runnable H;
    public MainTabActivity a;
    public FragmentTabHost b;
    public TextView c;
    public boolean d;
    public boolean e;
    public TbImageView f;
    public TbImageView g;
    public PopupWindow h;
    public boolean i;
    public Handler j;
    public s16 k;
    public rs8 l;
    public MaintabBottomIndicator m;
    public MaintabBottomIndicator n;
    public int o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public tn8 t;
    public boolean u;
    public boolean v;
    public boolean w;
    public ez8 x;
    public FragmentTabHost.a y;
    public CustomMessageListener z;

    /* loaded from: classes6.dex */
    public class a implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn8 a;

        /* renamed from: com.repackage.mn8$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0526a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;

            public RunnableC0526a(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.a);
                }
            }
        }

        public a(mn8 mn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mn8Var;
        }

        public final void a(RedIcon redIcon) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, redIcon) == null) || redIcon == null) {
                return;
            }
            n65 n65Var = new n65();
            n65Var.g = redIcon.image;
            n65Var.e = 22;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, n65Var));
        }

        public final void b(int i) {
            String prePageKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (this.a.b.i(i).a == 2) {
                    prePageKey = TbPageExtraHelper.getCurrentVisiblePageKey(this.a.a.getPageContext().getContext());
                } else {
                    prePageKey = TbPageExtraHelper.getPrePageKey();
                }
                rg.a().postDelayed(new RunnableC0526a(this, new CustomResponsedMessage(2921520, prePageKey)), 100L);
            }
        }

        public final void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                int i2 = this.a.b.i(i).a;
                if (i2 == 8) {
                    TbPageExtraHelper.setPrePageKey("a011");
                } else if (i2 == 2) {
                    TbPageExtraHelper.setPrePageKey("a002");
                } else if (i2 == 3) {
                    TbPageExtraHelper.setPrePageKey("a079");
                } else if (i2 == 1) {
                    TbPageExtraHelper.setPrePageKey("a025");
                } else if (i2 == 21) {
                    TbPageExtraHelper.setPrePageKey("a075");
                } else if (i2 == 22) {
                    TbPageExtraHelper.setPrePageKey("a088");
                }
            }
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                FragmentTabHost.b i2 = this.a.b.i(i);
                if (i2.a == 2 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.a.getPageContext(), null)) {
                    int i3 = i2.a;
                    if (i3 == 9) {
                        if (UbsABTestHelper.isMainTabShowA()) {
                            this.a.a.O0().a().i().I();
                            if (DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a, LoginDialogData.HOME_PAGE_WRITE_PAGE))) {
                                this.a.x.m();
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new p15(0)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                        }
                        return false;
                    } else if (i3 == 8 && !TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.a.a.getActivity(), "maintab_person");
                        if (this.a.m != null) {
                            this.a.m.n();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                        return false;
                    } else {
                        int i4 = i2.a;
                        if (i4 == 15) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                                return false;
                            }
                        } else if (i4 == 3 && !TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(this.a.a.getActivity(), "maintab_msg");
                            return false;
                        } else if (i2.a == 1) {
                            TiebaStatic.log(new StatisticItem("c13001"));
                        }
                        return true;
                    }
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00f0, code lost:
            if (com.baidu.tbadk.core.util.UtilHelper.isNumber(r1) != false) goto L119;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0268, code lost:
            if (com.baidu.tbadk.core.util.UtilHelper.isNumber(r14) != false) goto L45;
         */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTabSelectionChanged(int i, boolean z) {
            String str;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                FragmentTabHost.b i3 = this.a.b.i(i);
                int i4 = i3.a;
                int i5 = 3;
                int i6 = 2;
                if (i4 == 8) {
                    TbSingleton.getInstance().setMyTabClicked(true);
                    if (this.a.m != null && this.a.m.getAnimationView() != null && this.a.m.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.a.m != null) {
                        this.a.m.n();
                    }
                    TiebaStatic.log("c13841");
                    SoLoadUtils.checkDownloadSo("libmml_framework.so", "com.baidu.tieba.soloader.libmmlframework", "mml_framework");
                    SoLoadUtils.checkDownloadSo("libc++_shared.so", "com.baidu.tieba.soloader.libcshared", SwanKV.LIB_CPP_SHARED);
                    SoLoadUtils.checkDownloadSo("libopencv_java3.so", "com.baidu.tieba.soloader.libopencv_java3", "opencv_java3");
                    SoLoadUtils.checkDownloadSo("libbd_pass_face_sdk.so", "com.baidu.tieba.soloader.libbdface", "bd_pass_face_sdk");
                } else if (i4 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                    TbFragmentTabIndicator tbFragmentTabIndicator = i3.b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        if (maintabBottomIndicator.d("msg") != null && (maintabBottomIndicator.d("msg").a instanceof MessageRedDotView)) {
                            str = ((MessageRedDotView) maintabBottomIndicator.d("msg").a).getRedNum();
                            if (!TextUtils.isEmpty(str)) {
                            }
                        }
                    }
                    str = "0";
                    if (z) {
                        try {
                            i2 = Integer.parseInt(str);
                        } catch (Exception e) {
                            e.printStackTrace();
                            i2 = 0;
                        }
                        boolean z2 = i2 > 0;
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", z2 ? 1 : 2).param("obj_param1", str));
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", str).param("obj_type", z2 ? 1 : 2).param("obj_source", 1));
                    }
                }
                if (i3.a == 2) {
                    if (this.a.p) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.a.p = true;
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if (this.a.q != 2 || this.a.o == i || homeBarShowType != 1 || this.a.n == null) {
                        if (this.a.q == 1 && this.a.n != null) {
                            this.a.n.x(this.a.p);
                        }
                    } else {
                        this.a.n.y();
                    }
                    this.a.r = false;
                } else {
                    this.a.r = true;
                    if (this.a.p && this.a.n != null) {
                        this.a.n.x(this.a.p);
                    }
                    this.a.p = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                }
                if (this.a.z() != null) {
                    this.a.z().w = this.a.p;
                }
                c(this.a.o);
                b(this.a.o);
                this.a.o = i;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
                if (i3.a == 22) {
                    TbFragmentTabIndicator tbFragmentTabIndicator2 = i3.b;
                    if (tbFragmentTabIndicator2 instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator2 = (MaintabBottomIndicator) tbFragmentTabIndicator2;
                        if (maintabBottomIndicator2.d("video_msg") != null && (maintabBottomIndicator2.d("video_msg").a instanceof MessageRedDotView)) {
                            String redNum = ((MessageRedDotView) maintabBottomIndicator2.d("video_msg").a).getRedNum();
                            if (!TextUtils.isEmpty(redNum)) {
                            }
                        }
                    }
                    i6 = 1;
                    if (this.a.s) {
                        this.a.s = false;
                    } else {
                        i5 = i6;
                    }
                    if (z && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                        long logWithBackTime = TiebaStatic.logWithBackTime(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", i5));
                        if (this.a.b.i(this.a.b.getCurrentTabIndex()) != null && this.a.b.i(this.a.b.getCurrentTabIndex()).a != 22) {
                            TbSingleton.getInstance().setCurrentClickTime(logWithBackTime);
                        }
                    }
                    g75.b().c();
                    g75.b().l(true);
                    if (this.a.b.i(this.a.b.getCurrentTabIndex()) == null || this.a.b.i(this.a.b.getCurrentTabIndex()).a != 22) {
                        if (this.a.b.getFragmentTabWidget() != null) {
                            this.a.b.getFragmentTabWidget().g(true, R.color.CAM_X0215);
                        }
                        this.a.b.q(true);
                        if (!oi.z()) {
                            qi.K(this.a.a, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c3d));
                        }
                        if (!TbSingleton.getInstance().isFromFeedVideoClick()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.TRUE));
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921577, ""));
                        }
                    } else if (!TbSingleton.getInstance().isFromFeedVideoClick()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.FALSE));
                    }
                } else {
                    if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                        this.a.b.t(false, null);
                        TbSingleton.getInstance().setFromFeedVideoClick(false);
                        RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                        TbSingleton.getInstance().setVideoChannelRecommendRedIcon(videoChannelRecommendRedIcon);
                        a(videoChannelRecommendRedIcon);
                    }
                    g75.b().o();
                    g75.b().l(false);
                    if (this.a.b.getFragmentTabWidget() != null) {
                        this.a.b.getFragmentTabWidget().g(false, R.color.CAM_X0207);
                    }
                    this.a.b.q(false);
                }
                if (i3.a == 1 && TbSingleton.getInstance().needRefreshForumSquare) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921589));
                    TbSingleton.getInstance().needRefreshForumSquare = false;
                }
                int i7 = i3.a;
                if (i7 == 22 || i7 == 23) {
                    this.a.t.f(true);
                } else {
                    this.a.t.f(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn8 a;

        public b(mn8 mn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mn8Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.a.b.getCurrentTabType() != 2) {
                    if (this.a.b.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                if (this.a.b.getCurrentTabType() != this.a.b.i(i).a) {
                    this.a.b.setCurrentTab(i);
                }
                if (this.a.b.getCurrentTabType() == 1 && !ru4.k().h("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                if (ru4.k().h("enter_forum_edit_mode", false)) {
                    if (this.a.b.getCurrentTabType() != 3) {
                        if (this.a.b.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (this.a.b.getCurrentTabType() == 3) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mn8 b;

        public c(mn8 mn8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mn8Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.P(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn8 a;

        public d(mn8 mn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mn8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null || this.a.h == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.a.b.getFragmentTabWidget();
            qi.k(this.a.a.getActivity());
            int f = qi.f(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f07025e);
            View contentView = this.a.h.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b j = this.a.b.j(3);
            if (j == null || (tbFragmentTabIndicator = j.b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = qi.f(this.a.a.getActivity(), R.dimen.tbds570);
            }
            tg.l(this.a.h, fragmentTabWidget, measuredWidth2, -f);
            ru4.k().u("show_maintab_last_message_tips", true);
            this.a.i = true;
            this.a.j.postDelayed(this.a.H, 5000L);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn8 a;

        public e(mn8 mn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mn8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(mn8 mn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "1");
                TiebaStatic.log(statisticItem);
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(mn8 mn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                ur4Var.dismiss();
                wt6.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(mn8 mn8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mn8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n65 n65Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.b == null || !(customResponsedMessage.getData() instanceof n65) || (n65Var = (n65) customResponsedMessage.getData()) == null || this.a.b.j(n65Var.e) == null || this.a.b.getCurrentTabType() == n65Var.e) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = this.a.b.j(n65Var.e).b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(n65Var.g, n65Var.c);
                if (TextUtils.isEmpty(n65Var.g)) {
                    return;
                }
                this.a.s = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(mn8 mn8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mn8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), this.a.a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn8 a;

        public j(mn8 mn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mn8Var;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.a.getActivityRootView(), j);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.a.getActivityRootView(), 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(mn8 mn8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mn8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            q65 c;
            q65 c2;
            q65 c3;
            q65 c4;
            q65 c5;
            q65 c6;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FragmentTabHost.b j = this.a.b.j(2);
                if (j != null && (j.b instanceof MaintabBottomIndicator) && (c6 = s65.d().c("homePage")) != null) {
                    ((MaintabBottomIndicator) j.b).setDynamicIconData(c6);
                }
                FragmentTabHost.b j2 = this.a.b.j(1);
                if (j2 != null && (j2.b instanceof MaintabBottomIndicator) && (c5 = s65.d().c("enterForum")) != null) {
                    ((MaintabBottomIndicator) j2.b).setDynamicIconData(c5);
                }
                FragmentTabHost.b j3 = this.a.b.j(22);
                if (j3 != null && (j3.b instanceof MaintabBottomIndicator) && (c4 = s65.d().c("channel")) != null) {
                    ((MaintabBottomIndicator) j3.b).setDynamicIconData(c4);
                }
                FragmentTabHost.b j4 = this.a.b.j(3);
                if (j4 != null && (j4.b instanceof MaintabBottomIndicator) && (c3 = s65.d().c("message")) != null) {
                    ((MaintabBottomIndicator) j4.b).setDynamicIconData(c3);
                }
                FragmentTabHost.b j5 = this.a.b.j(8);
                if (j5 != null && (j5.b instanceof MaintabBottomIndicator) && (c2 = s65.d().c("person")) != null) {
                    ((MaintabBottomIndicator) j5.b).setDynamicIconData(c2);
                }
                if (this.a.f == null || this.a.f.getVisibility() != 0 || (c = s65.d().c(AlbumActivityConfig.FROM_WRITE)) == null) {
                    return;
                }
                this.a.f.setVisibility(8);
                this.a.g.setVisibility(0);
                this.a.g.K(c.k(), c.j(), false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(mn8 mn8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mn8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.z() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int intValue = ((Integer) data).intValue();
                if (intValue == 4) {
                    this.a.r = true;
                    this.a.p = true;
                    if (this.a.q != 2) {
                        if (this.a.n == null || !this.a.n.p()) {
                            return;
                        }
                        this.a.n.x(this.a.p);
                        return;
                    }
                    this.a.z().w();
                    return;
                }
                if (intValue == 6) {
                    this.a.r = false;
                    if (this.a.q == 1) {
                        return;
                    }
                } else {
                    this.a.q = intValue;
                }
                if (this.a.q == 1) {
                    this.a.z().x(this.a.p);
                } else if (this.a.q == 2) {
                    this.a.z().y();
                } else if (intValue == 5) {
                    this.a.q = 1;
                    this.a.p = true;
                    if (!this.a.r) {
                        this.a.z().w();
                    }
                } else {
                    this.a.z().v();
                }
                this.a.z().v = true;
                this.a.z().x = this.a.q;
                this.a.z().w = this.a.p;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(mn8 mn8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mn8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.p = true;
                if (this.a.z() != null) {
                    this.a.z().w = this.a.p;
                }
                ru4.k().u("key_member_auto_ban_renewal_show", false);
                TbSingleton.getInstance().hasPerformInterestPanelShow = false;
                xl5.k().o();
                fu4.b().l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn8 a;

        public n(mn8 mn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mn8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setVisibility(4);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mn8 a;

        public o(mn8 mn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mn8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setVisibility(0);
            }
        }
    }

    public mn8(MainTabActivity mainTabActivity) {
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
        this.d = false;
        this.i = false;
        this.j = new Handler();
        this.o = 0;
        this.p = true;
        this.q = 1;
        this.r = false;
        this.s = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.y = new a(this);
        this.z = new h(this, 2921492);
        this.A = new i(this, 2001440);
        this.B = new j(this);
        this.C = new k(this, 2921551);
        this.D = new l(this, 2921382);
        this.E = new m(this, 2921410);
        this.G = new d(this);
        this.H = new e(this);
        this.a = mainTabActivity;
    }

    public MaintabBottomIndicator A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (MaintabBottomIndicator) invokeV.objValue;
    }

    public FragmentTabHost B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (FragmentTabHost) invokeV.objValue;
    }

    public void C(ArrayList<m65> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.u();
            Iterator<m65> it = arrayList.iterator();
            while (it.hasNext()) {
                m65 next = it.next();
                if (next != null && next.d()) {
                    x(next, next.b(), next.c(this.a.getPageContext().getPageActivity()));
                }
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.b.n(2);
            } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.b.n(1);
            } else {
                this.b.n(0);
            }
            this.b.setViewPagerScrollable(false);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r = false;
            this.q = 1;
            if (z() != null) {
                z().x = this.q;
            }
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public void F(int i2) {
        FragmentTabHost fragmentTabHost;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (fragmentTabHost = this.b) == null) {
            return;
        }
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            fragmentTabHost.setShouldDrawTopLine(true);
        }
        ez8 ez8Var = this.x;
        if (ez8Var != null) {
            ez8Var.i(i2);
        }
        this.b.s(i2);
        FragmentTabHost fragmentTabHost2 = this.b;
        FragmentTabHost.b i4 = fragmentTabHost2.i(fragmentTabHost2.getCurrentTabIndex());
        if (i4 != null && ((i3 = i4.a) == 22 || i3 == 23)) {
            if (this.b.getFragmentTabWidget() != null) {
                this.b.getFragmentTabWidget().g(true, R.color.CAM_X0215);
            }
            this.b.q(true);
            return;
        }
        if (this.b.getFragmentTabWidget() != null) {
            this.b.getFragmentTabWidget().g(false, R.color.CAM_X0207);
        }
        this.b.q(false);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            N();
            if (B() != null) {
                B().u();
            }
            y();
            s16 s16Var = this.k;
            if (s16Var != null) {
                s16Var.h();
            }
            rs8 rs8Var = this.l;
            if (rs8Var != null) {
                rs8Var.e();
            }
        }
    }

    public void H(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (fragmentTabHost = this.b) == null) {
            return;
        }
        if (z) {
            fragmentTabHost.k();
        } else {
            fragmentTabHost.v();
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (this.u != z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921645, Boolean.valueOf(z)));
                this.w = z;
                this.u = z;
            }
            H(this.v || this.w);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ItemCardHelper.v(this.B);
            MessageManager.getInstance().registerListener(this.A);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.a.findViewById(R.id.obfuscated_res_0x7f091fc1);
            this.b = fragmentTabHost;
            fragmentTabHost.setVisibility(8);
            hn8.b(new n(this), 1);
            hn8.b(new o(this), 6);
            this.b.setup(this.a.getSupportFragmentManager());
            this.b.setAbsoluteWeight(true);
            this.b.setOnTabSelectionListener(this.y);
            this.b.s(TbadkCoreApplication.getInst().getSkinType());
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.b.setShouldDrawIndicatorLine(false);
                this.b.setShouldDrawTopLine(true);
            }
            this.b.setOnPageChangeListener(new b(this));
            this.f = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d7f);
            this.g = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d7e);
            this.d = ru4.k().h("has_show_message_tab_tips", false);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090078);
            this.b.setUIType(0);
            this.b.setTabContainerShadowShow(false);
            this.b.setBackGroundStyle(0);
            this.b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            tn8 tn8Var = new tn8(this.a, this.b.getTabWrapper());
            this.t = tn8Var;
            tn8Var.f(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.a.getPageContext()));
            if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.a.registerListener(this.D);
            }
            this.a.registerListener(this.E);
            this.a.registerListener(this.z);
            this.a.registerListener(this.C);
            this.x = new ez8(this.a, "main_tab", 1, "8");
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.A);
        }
    }

    public void M(int i2) {
        MaintabBottomIndicator maintabBottomIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            B().setCurrentTabByType(i2);
            if (i2 != 2) {
                this.r = true;
                if (this.p && (maintabBottomIndicator = this.n) != null) {
                    maintabBottomIndicator.x(false);
                }
                this.p = false;
                if (z() != null) {
                    z().w = this.p;
                }
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ru4.k().u("has_show_message_tab_tips", this.d);
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (B() == null) {
                return true;
            }
            FragmentTabHost B = B();
            FragmentTabHost.b i2 = B.i(B.getCurrentTabIndex());
            return i2 == null || i2.a != 22;
        }
        return invokeV.booleanValue;
    }

    public void P(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.c.setVisibility(8);
                return;
            }
            FragmentTabHost.b j2 = this.b.j(8);
            if (j2 != null) {
                if (this.i && ((popupWindow = this.h) == null || !popupWindow.isShowing())) {
                    Q(str, j2);
                    return;
                }
                if (this.F == null) {
                    this.F = new c(this, str);
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.F);
                TbadkCoreApplication.getInst().handler.postDelayed(this.F, 5000L);
                return;
            }
            this.c.setVisibility(8);
        }
    }

    public final void Q(String str, FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, bVar) == null) {
            int[] iArr = new int[2];
            bVar.b.getLocationInWindow(iArr);
            int width = iArr[0] + (bVar.b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.rightMargin = (qi.r(this.a).widthPixels - width) - qi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701f0);
            this.c.setLayoutParams(layoutParams);
            this.c.setVisibility(0);
            this.c.setText(str);
        }
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            ur4 ur4Var = new ur4(this.a.getActivity());
            ur4Var.setMessage(str);
            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f03f3, new f(this));
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ac, new g(this));
            ur4Var.create(this.a.getPageContext()).show();
        }
    }

    public void S(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, postWriteCallBackData) == null) || postWriteCallBackData == null || this.a.getActivityRootView() == null || postWriteCallBackData.mFrom != 1) {
            return;
        }
        if (this.l == null) {
            MainTabActivity mainTabActivity = this.a;
            this.l = new rs8(mainTabActivity, mainTabActivity.getActivityRootView());
        }
        this.l.g(postWriteCallBackData);
    }

    public void T(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, postWriteCallBackData) == null) {
            if (this.k == null) {
                this.k = new s16(this.a.getPageContext(), (NavigationBarCoverTip) this.a.findViewById(R.id.obfuscated_res_0x7f091630));
            }
            this.k.l(postWriteCallBackData);
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.e = z;
            if (z) {
                return;
            }
            ru4.k().u("enter_forum_edit_mode", false);
        }
    }

    public boolean w(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || pi.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (ru4.k().h(ru4.o(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void x(m65 m65Var, n65 n65Var, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048598, this, m65Var, n65Var, tbFragmentTabIndicator) == null) && n65Var != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            bVar.c = n65Var.a;
            bVar.a = n65Var.e;
            maintabBottomIndicator.setShowIconType(n65Var.i);
            int i2 = n65Var.i;
            boolean z = false;
            if (i2 == n65.j) {
                maintabBottomIndicator.setWriteIconView();
                q65 q65Var = n65Var.h;
                if (q65Var != null && !TextUtils.isEmpty(q65Var.k())) {
                    this.f.setVisibility(8);
                    this.g.setVisibility(0);
                    this.g.K(n65Var.h.k(), n65Var.h.j(), false);
                } else {
                    this.f.setVisibility(0);
                    this.f.setImageResource(n65Var.d);
                }
                z = true;
            } else if (i2 == n65.m) {
                maintabBottomIndicator.setText(n65Var.b);
                maintabBottomIndicator.setAnimationResId(n65Var.f);
                this.m = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(n65Var.b);
                maintabBottomIndicator.setAnimationResId(n65Var.f);
            }
            if (!pi.isEmpty(n65Var.g)) {
                maintabBottomIndicator.setImageIconUrl(n65Var.g, n65Var.c);
            }
            q65 q65Var2 = n65Var.h;
            if (q65Var2 != null) {
                maintabBottomIndicator.setDynamicIconData(q65Var2);
            }
            if (bVar.a == 2) {
                maintabBottomIndicator.z = true;
                this.n = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar.b = maintabBottomIndicator;
            bVar.d = m65Var;
            this.b.e(bVar, -1, z);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.j.removeCallbacks(this.G);
            this.j.removeCallbacks(this.H);
            tg.c(this.h);
        }
    }

    public MaintabBottomIndicator z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.n : (MaintabBottomIndicator) invokeV.objValue;
    }
}

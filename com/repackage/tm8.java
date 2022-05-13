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
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nr4;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes7.dex */
public class tm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public Runnable C;
    public Runnable D;
    public Runnable E;
    public MainTabActivity a;
    public FragmentTabHost b;
    public TextView c;
    public boolean d;
    public boolean e;
    public PopupWindow f;
    public boolean g;
    public Handler h;
    public rz5 i;
    public ur8 j;
    public MaintabBottomIndicator k;
    public MaintabBottomIndicator l;
    public int m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public an8 r;
    public boolean s;
    public boolean t;
    public boolean u;
    public FragmentTabHost.a v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public final ItemCardHelper.c y;
    public CustomMessageListener z;

    /* loaded from: classes7.dex */
    public class a implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm8 a;

        /* renamed from: com.repackage.tm8$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0525a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;

            public RunnableC0525a(a aVar, CustomResponsedMessage customResponsedMessage) {
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

        public a(tm8 tm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tm8Var;
        }

        public final void a(RedIcon redIcon) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, redIcon) == null) || redIcon == null) {
                return;
            }
            e55 e55Var = new e55();
            e55Var.g = redIcon.image;
            e55Var.e = 22;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, e55Var));
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
                ng.a().postDelayed(new RunnableC0525a(this, new CustomResponsedMessage(2921520, prePageKey)), 100L);
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
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new h05(0)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                        return false;
                    } else if (i3 == 8 && !TbadkCoreApplication.isLogin()) {
                        if (UbsABTestHelper.isMinePageForVisitor() && TbSingleton.getInstance().isFlutterPluginLoadSuccess()) {
                            return true;
                        }
                        ViewHelper.skipToLoginActivity(this.a.a.getActivity(), "maintab_person");
                        if (this.a.k != null) {
                            this.a.k.n();
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

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00e9, code lost:
            if (com.baidu.tbadk.core.util.UtilHelper.isNumber(r1) != false) goto L122;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0270, code lost:
            if (com.baidu.tbadk.core.util.UtilHelper.isNumber(r14) != false) goto L48;
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
                    if (this.a.k != null && this.a.k.getAnimationView() != null && this.a.k.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.a.k != null) {
                        this.a.k.n();
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
                    if (this.a.n) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.a.n = true;
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if (this.a.o != 2 || this.a.m == i || homeBarShowType != 1 || this.a.l == null) {
                        if (this.a.o == 1 && this.a.l != null) {
                            this.a.l.x(this.a.n);
                        }
                    } else {
                        this.a.l.y();
                    }
                    this.a.p = false;
                } else {
                    this.a.p = true;
                    if (this.a.n && this.a.l != null) {
                        this.a.l.x(this.a.n);
                    }
                    this.a.n = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                }
                if (this.a.x() != null) {
                    this.a.x().w = this.a.n;
                }
                if (!this.a.n) {
                    er6.j().t();
                }
                c(this.a.m);
                b(this.a.m);
                this.a.m = i;
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
                    if (this.a.q) {
                        this.a.q = false;
                    } else {
                        i5 = i6;
                    }
                    if (z && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                        long logWithBackTime = TiebaStatic.logWithBackTime(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", i5));
                        if (this.a.b.i(this.a.b.getCurrentTabIndex()) != null && this.a.b.i(this.a.b.getCurrentTabIndex()).a != 22) {
                            TbSingleton.getInstance().setCurrentClickTime(logWithBackTime);
                        }
                    }
                    w55.b().c();
                    w55.b().l(true);
                    if (this.a.b.i(this.a.b.getCurrentTabIndex()) == null || this.a.b.i(this.a.b.getCurrentTabIndex()).a != 22) {
                        if (this.a.b.getFragmentTabWidget() != null) {
                            this.a.b.getFragmentTabWidget().g(true, R.color.CAM_X0215);
                        }
                        this.a.b.q(true);
                        if (!ki.z()) {
                            mi.K(this.a.a, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d));
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
                    w55.b().o();
                    w55.b().l(false);
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
                    this.a.r.f(true);
                } else {
                    this.a.r.f(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm8 a;

        public b(tm8 tm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tm8Var;
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
                if (this.a.b.getCurrentTabType() == 1 && !iu4.k().h("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                if (iu4.k().h("enter_forum_edit_mode", false)) {
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

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tm8 b;

        public c(tm8 tm8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tm8Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.N(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm8 a;

        public d(tm8 tm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tm8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null || this.a.f == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.a.b.getFragmentTabWidget();
            mi.k(this.a.a.getActivity());
            int f = mi.f(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f070262);
            View contentView = this.a.f.getContentView();
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
                measuredWidth2 = mi.f(this.a.a.getActivity(), R.dimen.tbds570);
            }
            pg.l(this.a.f, fragmentTabWidget, measuredWidth2, -f);
            iu4.k().u("show_maintab_last_message_tips", true);
            this.a.g = true;
            this.a.h.postDelayed(this.a.E, 5000L);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm8 a;

        public e(tm8 tm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tm8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(tm8 tm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "1");
                TiebaStatic.log(statisticItem);
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(tm8 tm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                nr4Var.dismiss();
                js6.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(tm8 tm8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var, Integer.valueOf(i)};
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
            this.a = tm8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e55 e55Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.b == null || !(customResponsedMessage.getData() instanceof e55) || (e55Var = (e55) customResponsedMessage.getData()) == null || this.a.b.j(e55Var.e) == null || this.a.b.getCurrentTabType() == e55Var.e) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = this.a.b.j(e55Var.e).b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(e55Var.g, e55Var.c);
                if (TextUtils.isEmpty(e55Var.g)) {
                    return;
                }
                this.a.q = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(tm8 tm8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var, Integer.valueOf(i)};
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
            this.a = tm8Var;
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

    /* loaded from: classes7.dex */
    public class j implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm8 a;

        public j(tm8 tm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tm8Var;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.a.getActivityRootView(), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.a.getActivityRootView(), j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(tm8 tm8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var, Integer.valueOf(i)};
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
            this.a = tm8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h55 c;
            h55 c2;
            h55 c3;
            h55 c4;
            h55 c5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FragmentTabHost.b j = this.a.b.j(2);
                if (j != null && (j.b instanceof MaintabBottomIndicator) && (c5 = j55.d().c("homePage")) != null) {
                    ((MaintabBottomIndicator) j.b).setDynamicIconData(c5);
                }
                FragmentTabHost.b j2 = this.a.b.j(1);
                if (j2 != null && (j2.b instanceof MaintabBottomIndicator) && (c4 = j55.d().c("enterForum")) != null) {
                    ((MaintabBottomIndicator) j2.b).setDynamicIconData(c4);
                }
                FragmentTabHost.b j3 = this.a.b.j(22);
                if (j3 != null && (j3.b instanceof MaintabBottomIndicator) && (c3 = j55.d().c("channel")) != null) {
                    ((MaintabBottomIndicator) j3.b).setDynamicIconData(c3);
                }
                FragmentTabHost.b j4 = this.a.b.j(3);
                if (j4 != null && (j4.b instanceof MaintabBottomIndicator) && (c2 = j55.d().c("message")) != null) {
                    ((MaintabBottomIndicator) j4.b).setDynamicIconData(c2);
                }
                FragmentTabHost.b j5 = this.a.b.j(8);
                if (j5 == null || !(j5.b instanceof MaintabBottomIndicator) || (c = j55.d().c("person")) == null) {
                    return;
                }
                ((MaintabBottomIndicator) j5.b).setDynamicIconData(c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(tm8 tm8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var, Integer.valueOf(i)};
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
            this.a = tm8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.x() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int intValue = ((Integer) data).intValue();
                if (intValue == 4) {
                    this.a.p = true;
                    this.a.n = true;
                    if (this.a.o != 2) {
                        if (this.a.l == null || !this.a.l.p()) {
                            return;
                        }
                        this.a.l.x(this.a.n);
                        return;
                    }
                    this.a.x().w();
                    return;
                }
                if (intValue == 6) {
                    this.a.p = false;
                    if (this.a.o == 1) {
                        return;
                    }
                } else {
                    this.a.o = intValue;
                }
                if (this.a.o == 1) {
                    this.a.x().x(this.a.n);
                } else if (this.a.o == 2) {
                    this.a.x().y();
                } else if (intValue == 5) {
                    this.a.o = 1;
                    this.a.n = true;
                    if (!this.a.p) {
                        this.a.x().w();
                    }
                } else {
                    this.a.x().v();
                }
                this.a.x().v = true;
                this.a.x().x = this.a.o;
                this.a.x().w = this.a.n;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(tm8 tm8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var, Integer.valueOf(i)};
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
            this.a = tm8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.n = true;
                if (this.a.x() != null) {
                    this.a.x().w = this.a.n;
                }
                if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(TbSingleton.getInstance().accountWhenColdStart) && !TbSingleton.getInstance().accountWhenColdStart.equals(TbadkCoreApplication.getCurrentAccount())) {
                    lh8.r().D(true);
                }
                iu4.k().u("key_member_auto_ban_renewal_show", false);
                TbSingleton.getInstance().hasPerformInterestPanelShow = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm8 a;

        public n(tm8 tm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tm8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setVisibility(4);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm8 a;

        public o(tm8 tm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tm8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setVisibility(0);
            }
        }
    }

    public tm8(MainTabActivity mainTabActivity) {
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
        this.g = false;
        this.h = new Handler();
        this.m = 0;
        this.n = true;
        this.o = 1;
        this.p = false;
        this.q = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = new a(this);
        this.w = new h(this, 2921492);
        this.x = new i(this, 2001440);
        this.y = new j(this);
        this.z = new k(this, 2921551);
        this.A = new l(this, 2921382);
        this.B = new m(this, 2921410);
        this.D = new d(this);
        this.E = new e(this);
        this.a = mainTabActivity;
    }

    public void A(ArrayList<d55> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            this.b.u();
            Iterator<d55> it = arrayList.iterator();
            while (it.hasNext()) {
                d55 next = it.next();
                if (next != null && next.d()) {
                    v(next, next.b(), next.c(this.a.getPageContext().getPageActivity()));
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

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.p = false;
            this.o = 1;
            if (x() != null) {
                x().x = this.o;
            }
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public void D(int i2) {
        FragmentTabHost fragmentTabHost;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (fragmentTabHost = this.b) == null) {
            return;
        }
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            fragmentTabHost.setShouldDrawTopLine(true);
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

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            L();
            if (z() != null) {
                z().u();
            }
            w();
            rz5 rz5Var = this.i;
            if (rz5Var != null) {
                rz5Var.h();
            }
            ur8 ur8Var = this.j;
            if (ur8Var != null) {
                ur8Var.e();
            }
        }
    }

    public void F(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (fragmentTabHost = this.b) == null) {
            return;
        }
        if (z) {
            fragmentTabHost.k();
        } else {
            fragmentTabHost.v();
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (this.s != z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921645, Boolean.valueOf(z)));
                this.u = z;
                this.s = z;
            }
            F(this.t || this.u);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ItemCardHelper.v(this.y);
            MessageManager.getInstance().registerListener(this.x);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.a.findViewById(R.id.obfuscated_res_0x7f091e88);
            this.b = fragmentTabHost;
            fragmentTabHost.setVisibility(8);
            om8.b(new n(this), 1);
            om8.b(new o(this), 6);
            this.b.setup(this.a.getSupportFragmentManager());
            this.b.setAbsoluteWeight(true);
            this.b.setOnTabSelectionListener(this.v);
            this.b.s(TbadkCoreApplication.getInst().getSkinType());
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.b.setShouldDrawIndicatorLine(false);
                this.b.setShouldDrawTopLine(true);
            }
            this.b.setOnPageChangeListener(new b(this));
            this.d = iu4.k().h("has_show_message_tab_tips", false);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090074);
            this.b.setUIType(0);
            this.b.setTabContainerShadowShow(false);
            this.b.setBackGroundStyle(0);
            this.b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            an8 an8Var = new an8(this.a, this.b.getTabWrapper());
            this.r = an8Var;
            an8Var.f(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.a.getPageContext()));
            if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.a.registerListener(this.A);
            }
            this.a.registerListener(this.B);
            this.a.registerListener(this.w);
            this.a.registerListener(this.z);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.x);
        }
    }

    public void K(int i2) {
        MaintabBottomIndicator maintabBottomIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            z().setCurrentTabByType(i2);
            if (i2 != 2) {
                this.p = true;
                if (this.n && (maintabBottomIndicator = this.l) != null) {
                    maintabBottomIndicator.x(false);
                }
                this.n = false;
                if (x() != null) {
                    x().w = this.n;
                }
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            iu4.k().u("has_show_message_tab_tips", this.d);
        }
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (z() == null) {
                return true;
            }
            FragmentTabHost z = z();
            FragmentTabHost.b i2 = z.i(z.getCurrentTabIndex());
            return i2 == null || i2.a != 22;
        }
        return invokeV.booleanValue;
    }

    public void N(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.c.setVisibility(8);
                return;
            }
            FragmentTabHost.b j2 = this.b.j(8);
            if (j2 != null) {
                if (this.g && ((popupWindow = this.f) == null || !popupWindow.isShowing())) {
                    O(str, j2);
                    return;
                }
                if (this.C == null) {
                    this.C = new c(this, str);
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.C);
                TbadkCoreApplication.getInst().handler.postDelayed(this.C, 5000L);
                return;
            }
            this.c.setVisibility(8);
        }
    }

    public final void O(String str, FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, bVar) == null) {
            int[] iArr = new int[2];
            bVar.b.getLocationInWindow(iArr);
            int width = iArr[0] + (bVar.b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.rightMargin = (mi.q(this.a).widthPixels - width) - mi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701f0);
            this.c.setLayoutParams(layoutParams);
            this.c.setVisibility(0);
            this.c.setText(str);
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            nr4 nr4Var = new nr4(this.a.getActivity());
            nr4Var.setMessage(str);
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f03ed, new f(this));
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ac, new g(this));
            nr4Var.create(this.a.getPageContext()).show();
        }
    }

    public void Q(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) || postWriteCallBackData == null || this.a.getActivityRootView() == null || postWriteCallBackData.mFrom != 1) {
            return;
        }
        if (this.j == null) {
            MainTabActivity mainTabActivity = this.a;
            this.j = new ur8(mainTabActivity, mainTabActivity.getActivityRootView());
        }
        this.j.g(postWriteCallBackData);
    }

    public void R(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, postWriteCallBackData) == null) {
            if (this.i == null) {
                this.i = new rz5(this.a.getPageContext(), (NavigationBarCoverTip) this.a.findViewById(R.id.obfuscated_res_0x7f09153f));
            }
            this.i.l(postWriteCallBackData);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.e = z;
            if (z) {
                return;
            }
            iu4.k().u("enter_forum_edit_mode", false);
        }
    }

    public boolean u(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || li.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (iu4.k().h(iu4.o(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void v(d55 d55Var, e55 e55Var, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048596, this, d55Var, e55Var, tbFragmentTabIndicator) == null) && e55Var != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            boolean z = false;
            bVar.c = e55Var.a;
            bVar.a = e55Var.e;
            maintabBottomIndicator.setShowIconType(e55Var.i);
            int i2 = e55Var.i;
            if (i2 == e55.j) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (i2 == e55.m) {
                maintabBottomIndicator.setText(e55Var.b);
                maintabBottomIndicator.setAnimationResId(e55Var.f);
                this.k = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(e55Var.b);
                maintabBottomIndicator.setAnimationResId(e55Var.f);
            }
            if (!li.isEmpty(e55Var.g)) {
                maintabBottomIndicator.setImageIconUrl(e55Var.g, e55Var.c);
            }
            h55 h55Var = e55Var.h;
            if (h55Var != null) {
                maintabBottomIndicator.setDynamicIconData(h55Var);
            }
            if (bVar.a == 2) {
                maintabBottomIndicator.z = true;
                this.l = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar.b = maintabBottomIndicator;
            bVar.d = d55Var;
            this.b.e(bVar, -1, z);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.h.removeCallbacks(this.D);
            this.h.removeCallbacks(this.E);
            pg.c(this.f);
        }
    }

    public MaintabBottomIndicator x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.l : (MaintabBottomIndicator) invokeV.objValue;
    }

    public MaintabBottomIndicator y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.k : (MaintabBottomIndicator) invokeV.objValue;
    }

    public FragmentTabHost z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.b : (FragmentTabHost) invokeV.objValue;
    }
}

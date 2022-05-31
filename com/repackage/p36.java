package com.repackage;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StatusbarColorUtils;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftViewPager;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.EnterForumTabFragment;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.forumSquare.ForumSquareFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b45;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class p36 extends z8 implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFragment a;
    public LinearLayout b;
    public ForumHeaderView c;
    public NewPagerSlidingTabBaseStrip d;
    public PullLeftViewPager e;
    public EnterForumTabPagerAdapter f;
    public List<EnterForumTabPagerAdapter.a> g;
    public View h;
    public AlphaAnimation i;
    public AlphaAnimation j;
    public b36 k;
    public b36 l;
    public ImageView m;
    public View n;
    public View o;
    public NavigationBar p;
    public View q;
    public NoNetworkView r;
    public g56 s;
    public int t;
    public int u;
    public boolean v;
    public wa w;
    public CustomMessageListener x;
    public ViewPager.OnPageChangeListener y;

    /* loaded from: classes6.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p36 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p36 p36Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p36Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p36Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().y();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().y();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = this.a.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0574);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p36 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(p36 p36Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p36Var, Integer.valueOf(i)};
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
            this.a = p36Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.a.X();
                } else {
                    this.a.s();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p36 a;

        public c(p36 p36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p36Var;
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
                this.a.N(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Fragment fragment;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.M(i);
                if (this.a.g == null || this.a.g.size() <= i) {
                    return;
                }
                if (this.a.s != null) {
                    this.a.s.U();
                }
                EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) this.a.g.get(i);
                if (aVar == null || (fragment = aVar.a) == null) {
                    return;
                }
                if (fragment instanceof EnterForumFragment) {
                    z = ((EnterForumFragment) fragment).K0();
                } else if (fragment instanceof EnterForumTabFeedFragment) {
                    gw5.b().e(false);
                    boolean H0 = ((EnterForumTabFeedFragment) aVar.a).H0();
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, ((EnterForumTabFeedFragment) aVar.a).G0()));
                    z = H0;
                } else {
                    z = true;
                }
                if (!z) {
                    this.a.X();
                } else {
                    this.a.s();
                }
                if (i == 0) {
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
                }
                if (i == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements b45.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p36 a;

        public d(p36 p36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p36Var;
        }

        @Override // com.repackage.b45.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new NoNetworkView(this.a.mContext.getPageActivity()) : invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements b45.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p36 a;

        public e(p36 p36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p36Var;
        }

        @Override // com.repackage.b45.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (LinearLayout) LayoutInflater.from(this.a.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0272, (ViewGroup) null) : invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements b45.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p36 a;

        public f(p36 p36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p36Var;
        }

        @Override // com.repackage.b45.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new NavigationBar(this.a.mContext.getPageActivity()) : invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p36 a;

        public g(p36 p36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p36Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (FileHelper.CheckFile("scan_flag") && PermissionUtil.checkCamera(this.a.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(this.a.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                } else {
                    this.a.a.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(this.a.getPageContext().getPageActivity())));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p36 a;

        public h(p36 p36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p36Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.q.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p36(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = false;
        this.w = new a(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
        this.x = new b(this, 2001630);
        this.y = new c(this);
        this.a = enterForumTabFragment;
        enterForumTabFragment.registerListener(this.w);
        this.a.registerListener(this.x);
        this.t = li.f(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.u = UtilHelper.getStatusBarHeight() + li.f(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public static String F(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    public final void A(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) b45.e().d(1022, new f(this));
            this.p = navigationBar;
            ((RelativeLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0914f3)).addView(navigationBar);
            this.p.setNavHeight(this.t);
            this.p.hideBottomLine();
            this.q = this.h.findViewById(R.id.obfuscated_res_0x7f0907e5);
            Y(0);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0914eb);
            this.m = imageView;
            imageView.setOnClickListener(new g(this));
            if (this.d != null) {
                this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.b, (View.OnClickListener) null);
                ViewGroup viewGroup = (ViewGroup) this.b.getParent();
                if (viewGroup instanceof LinearLayout) {
                    ((LinearLayout) viewGroup).setGravity(3);
                } else if (viewGroup instanceof RelativeLayout) {
                    ((RelativeLayout) viewGroup).setGravity(3);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.gravity = 3;
                    viewGroup.setLayoutParams(layoutParams);
                }
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.d;
                newPagerSlidingTabBaseStrip.setPadding(newPagerSlidingTabBaseStrip.getPaddingLeft(), this.d.getPaddingTop(), this.d.getPaddingRight(), this.d.getPaddingBottom());
            }
        }
    }

    public final void B(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            LinearLayout linearLayout = (LinearLayout) b45.e().d(1023, new e(this));
            this.b = linearLayout;
            ForumHeaderView forumHeaderView = (ForumHeaderView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0919f9);
            this.c = forumHeaderView;
            forumHeaderView.setFrom(0);
            this.c.b();
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.b.findViewById(R.id.obfuscated_res_0x7f091e31);
            this.d = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.d.setRectPaintColor(R.color.CAM_X0302);
            this.d.B(li.f(this.a.getContext(), R.dimen.tbds46), li.f(this.a.getContext(), R.dimen.tbds46), li.f(this.a.getContext(), R.dimen.tbds10), li.f(this.a.getContext(), R.dimen.tbds46), true);
            this.d.setmIndicatorWidth(li.f(this.mContext.getPageActivity(), R.dimen.tbds42));
            this.d.setIndicatorOvershot(li.f(this.mContext.getPageActivity(), R.dimen.tbds8));
            this.d.setIndicatorRadius(li.f(this.mContext.getPageActivity(), R.dimen.tbds8));
            this.d.setIndicatorMarginBottom(li.f(this.a.getContext(), R.dimen.tbds0));
            this.d.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.d.setTabPadding(li.f(this.a.getContext(), R.dimen.tbds36), 0, li.f(this.a.getContext(), R.dimen.tbds36), 0);
            this.d.setViewPager(this.e);
            this.d.setOnPageChangeListener(this.y);
            this.o = this.b.findViewById(R.id.obfuscated_res_0x7f0908c3);
            this.n = this.b.findViewById(R.id.obfuscated_res_0x7f0908c4);
        }
    }

    public void C(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, bundle) == null) || view2 == null) {
            return;
        }
        this.h = view2;
        D(bundle);
        B(bundle);
        A(bundle);
        NoNetworkView noNetworkView = (NoNetworkView) b45.e().d(1021, new d(this));
        this.r = noNetworkView;
        noNetworkView.setVisibility(8);
        ((RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0923a4)).addView(this.r);
        this.r.a(this);
    }

    public final void D(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.e = (PullLeftViewPager) this.h.findViewById(R.id.obfuscated_res_0x7f0908c7);
            EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
            aVar.a = new EnterForumFragment();
            aVar.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b3f);
            ((EnterForumFragment) aVar.a).N0(this);
            EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
            aVar2.a = new ForumSquareFragment();
            aVar2.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06b3);
            aVar2.d = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06b3);
            ArrayList arrayList = new ArrayList();
            this.g = arrayList;
            arrayList.add(aVar);
            this.g.add(aVar2);
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = new EnterForumTabPagerAdapter(this.a.getActivity().getSupportFragmentManager(), this.g);
            this.f = enterForumTabPagerAdapter;
            this.e.setAdapter(enterForumTabPagerAdapter);
            this.e.setOffscreenPageLimit(this.g.size());
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void H(int i, int i2, Intent intent) {
        List<EnterForumTabPagerAdapter.a> list;
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) || (list = this.g) == null || list.size() <= 0 || (pullLeftViewPager = this.e) == null) {
            return;
        }
        EnterForumTabPagerAdapter.a aVar = this.g.get(pullLeftViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.a) == null) {
            return;
        }
        fragment.onActivityResult(i, i2, intent);
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            EnterForumTabFragment enterForumTabFragment = this.a;
            if (enterForumTabFragment != null && this.g != null && this.e != null && this.f != null) {
                FragmentManager supportFragmentManager = enterForumTabFragment.getActivity().getSupportFragmentManager();
                if (supportFragmentManager.isDestroyed()) {
                    return;
                }
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.g.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(F(this.e.getId(), this.f.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            }
            NoNetworkView noNetworkView = this.r;
            if (noNetworkView != null) {
                noNetworkView.d(this);
            }
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
            } else if (ListUtils.getItem(this.g, i) == null || !(this.g.get(i).a instanceof EnterForumTabFeedFragment)) {
            } else {
                ((EnterForumTabFeedFragment) this.g.get(i).a).E0(true);
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            M(this.e.getCurrentItem());
        }
    }

    public final void M(int i) {
        b36 b36Var;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (this.m != null) {
                if (i == 0) {
                    b36 b36Var2 = this.k;
                    if (b36Var2 != null && b36Var2.a && b36Var2.b > 0) {
                        g56 g56Var = this.s;
                        if (g56Var != null && g56Var.T() != null && this.s.T().isViewAttached()) {
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        } else {
                            b36 b36Var3 = this.k;
                            int i4 = b36Var3.c;
                            if (i4 > 0 && b36Var3.b > i4 / 2) {
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                            } else {
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                            }
                        }
                    } else {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            NavigationBar navigationBar = this.p;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                if (i == 0) {
                    b36 b36Var4 = this.k;
                    if (b36Var4 != null && b36Var4.a && b36Var4.b > 0) {
                        g56 g56Var2 = this.s;
                        if (g56Var2 != null && g56Var2.T() != null && this.s.T().isViewAttached()) {
                            SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        } else {
                            b36 b36Var5 = this.k;
                            int i5 = b36Var5.c;
                            if (i5 > 0) {
                                int i6 = (b36Var5.b * 255) / i5;
                                if (i6 > 255) {
                                    i6 = 255;
                                }
                                i3 = 255 - i6;
                            } else {
                                i3 = 0;
                            }
                            this.p.setBackgroundColor(0);
                            SkinManager.setBackgroundColorWithAlpha(this.p.getBarBgView(), R.color.CAM_X0201, i3 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                        }
                    } else {
                        SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            }
            if (i == 0) {
                b36 b36Var6 = this.k;
                if (b36Var6 != null && b36Var6.a && (i2 = b36Var6.b) > 0) {
                    int i7 = b36Var6.c;
                    if (i7 > 0 && i2 > i7 / 2) {
                        g56 g56Var3 = this.s;
                        if (g56Var3 != null && g56Var3.T() != null && this.s.T().isViewAttached()) {
                            this.d.setWhiteStyle(false);
                        } else {
                            this.d.setWhiteStyle(true);
                        }
                    } else {
                        this.d.setWhiteStyle(false);
                    }
                } else {
                    this.d.setWhiteStyle(false);
                }
            } else {
                this.d.setWhiteStyle(false);
            }
            if (i == 0) {
                this.c.setAdState(this.k);
            } else {
                this.c.setAdState(null);
            }
            if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.a.isPrimary() && (b36Var = this.k) != null && b36Var.a && i == 0) {
                int i8 = b36Var.b;
                int i9 = b36Var.c;
                if (i8 > i9 / 2) {
                    b36 b36Var7 = this.l;
                    if (b36Var7 == null || b36Var7.b > i9 / 2) {
                        return;
                    }
                    StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                    return;
                }
                b36 b36Var8 = this.l;
                if (b36Var8 == null || b36Var8.b < i9 / 2) {
                    return;
                }
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public final void N(int i, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) || this.p == null) {
            return;
        }
        if (i == 0) {
            if (i2 == 0) {
                M(i);
                return;
            }
            b36 b36Var = this.k;
            if (b36Var == null || !b36Var.a || b36Var.b <= 0) {
                return;
            }
            g56 g56Var = this.s;
            if (g56Var != null && g56Var.T() != null && this.s.T().isViewAttached()) {
                SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.p.setBackgroundColor(0);
            SkinManager.setBackgroundColorWithAlpha(this.p.getBarBgView(), R.color.CAM_X0207, f2, TbadkCoreApplication.getInst().getSkinType());
        } else if (i2 == 0) {
            M(i);
        } else {
            b36 b36Var2 = this.k;
            if (b36Var2 == null || !b36Var2.a || b36Var2.b <= 0) {
                return;
            }
            g56 g56Var2 = this.s;
            if (g56Var2 != null && g56Var2.T() != null && this.s.T().isViewAttached()) {
                SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.p.setBackgroundColor(0);
            SkinManager.setBackgroundColorWithAlpha(this.p.getBarBgView(), R.color.CAM_X0201, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                if (this.e.getCurrentItem() == 0 && this.a.isPrimary()) {
                    g56 g56Var = this.s;
                    if (g56Var != null && g56Var.T() != null && this.s.T().isViewAttached()) {
                        StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                        return;
                    }
                    b36 b36Var = this.k;
                    if (b36Var != null && b36Var.a) {
                        int i = b36Var.b;
                        if (i <= b36Var.c / 2 && i != 0) {
                            StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                            return;
                        } else {
                            StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                            return;
                        }
                    }
                    StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                    return;
                }
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                return;
            }
            StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        }
    }

    public boolean P(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            if (i < 0 || i > this.g.size()) {
                return false;
            }
            this.e.setCurrentItem(i, true);
            return true;
        }
        return invokeI.booleanValue;
    }

    public void Q(b36 b36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, b36Var) == null) {
            this.l = this.k;
            this.k = b36Var;
            this.c.setAdState(b36Var);
            M(this.e.getCurrentItem());
        }
    }

    public void R(g56 g56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, g56Var) == null) {
            this.s = g56Var;
        }
    }

    public void T(boolean z) {
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.f;
            if (enterForumTabPagerAdapter != null) {
                enterForumTabPagerAdapter.c(z);
            }
            List<EnterForumTabPagerAdapter.a> list = this.g;
            if (list == null || list.size() <= 0 || (pullLeftViewPager = this.e) == null) {
                return;
            }
            EnterForumTabPagerAdapter.a aVar = this.g.get(pullLeftViewPager.getCurrentItem());
            if (aVar == null || (fragment = aVar.a) == null || !(fragment instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) fragment).setPrimary(z);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.c.setSearchHint(str);
        }
    }

    public void W(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048595, this, i, str) == null) || i < 0 || i > this.g.size()) {
            return;
        }
        this.e.setCurrentItem(i, true);
        if (this.g.get(i) == null || !(this.g.get(i).a instanceof ForumSquareFragment)) {
            return;
        }
        ((ForumSquareFragment) this.g.get(i).a).E0(str);
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LinearLayout linearLayout = this.b;
            if (linearLayout != null && linearLayout.getPaddingTop() < 0) {
                t();
                return;
            }
            View view2 = this.q;
            if (view2 == null) {
                return;
            }
            view2.clearAnimation();
            if (this.q.getVisibility() == 0) {
                return;
            }
            this.q.setVisibility(0);
            if (this.i == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.i = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.i.setDuration(300L);
            }
            this.q.startAnimation(this.i);
        }
    }

    public final void Y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams.topMargin = this.u + i;
            this.q.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void d(boolean z) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            List<EnterForumTabPagerAdapter.a> list = this.g;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.g.size(); i++) {
                    EnterForumTabPagerAdapter.a aVar = this.g.get(i);
                    if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof NoNetworkView.b)) {
                        ((NoNetworkView.b) fragment).d(z);
                    }
                }
            }
            M(this.e.getCurrentItem());
        }
    }

    public void onChangeSkinType(int i) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            M(this.e.getCurrentItem());
            NoNetworkView noNetworkView = this.r;
            if (noNetworkView != null) {
                noNetworkView.c(getPageContext(), i);
            }
            List<EnterForumTabPagerAdapter.a> list = this.g;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.g.size(); i2++) {
                    EnterForumTabPagerAdapter.a aVar = this.g.get(i2);
                    if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof BaseFragment)) {
                        ((BaseFragment) fragment).onChangeSkinType(i);
                    }
                }
            }
            SkinManager.setBackgroundResource(this.q, R.drawable.personalize_tab_shadow);
            this.d.G();
            this.c.b();
            SkinManager.setBackgroundColorToTransparent(this.o, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
            SkinManager.setBackgroundColorToTransparent(this.n, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
        }
    }

    public void r(NewPagerSlidingTabBaseStrip.c cVar) {
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) || (newPagerSlidingTabBaseStrip = this.d) == null || cVar == null) {
            return;
        }
        newPagerSlidingTabBaseStrip.setOnTabItemClickListener(cVar);
    }

    public void s() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (view2 = this.q) == null || view2.getVisibility() == 8) {
            return;
        }
        if (this.j == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.j = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.j.setDuration(300L);
            this.j.setAnimationListener(new h(this));
        }
        this.q.startAnimation(this.j);
    }

    public final void t() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (view2 = this.q) == null || view2.getVisibility() == 8) {
            return;
        }
        this.q.clearAnimation();
        this.q.setVisibility(8);
    }

    public int u(String str) {
        InterceptResult invokeL;
        List<EnterForumTabPagerAdapter.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (StringUtils.isNull(str) || (list = this.g) == null || list.size() <= 0) {
                return -1;
            }
            int i = -1;
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                if (str.equals(this.g.get(i2).d)) {
                    i = i2;
                }
            }
            if (i == -1 && this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b3f).equals(str)) {
                return 0;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.f;
            if (enterForumTabPagerAdapter != null) {
                return enterForumTabPagerAdapter.b();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.e.getCurrentItem() : invokeV.intValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? getPageContext().getPageActivity().getWindow().getDecorView() : (View) invokeV.objValue;
    }

    public String y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) ListUtils.getItem(this.g, i);
            if (aVar != null) {
                Fragment fragment = aVar.a;
                return fragment instanceof EnterForumTabFeedFragment ? ((EnterForumTabFeedFragment) fragment).G0() : "";
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.b : (View) invokeV.objValue;
    }
}

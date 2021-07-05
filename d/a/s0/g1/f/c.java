package d.a.s0.g1.f;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.DisableScrollLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.adapter.HotTopicThreadPagerAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicHeaderView;
import com.baidu.tieba.hottopic.view.HotTopicView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f59738a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f59739b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59740c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f59741d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f59742e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59743f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f59744g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.g1.f.e f59745h;

    /* renamed from: i  reason: collision with root package name */
    public HotTopicHeaderView f59746i;
    public CustomViewPager j;
    public HotTopicThreadPagerAdapter k;
    public DisableScrollLayout l;
    public int m;
    public int n;
    public int o;
    public TextView p;
    public ImageView q;
    public d.a.s0.g1.b.c r;
    public NoNetworkView.b s;
    public final d.a.r0.b1.j.e t;
    public final d.a.r0.b1.j.e u;
    public boolean v;
    public float w;
    public boolean x;
    public String y;
    public f z;

    /* loaded from: classes9.dex */
    public class a implements d.a.r0.b1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59747a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59747a = cVar;
        }

        @Override // d.a.r0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f59747a.o = i3;
                if (this.f59747a.f59746i != null) {
                    this.f59747a.f59746i.i(i3);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a.r0.b1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59748a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59748a = cVar;
        }

        @Override // d.a.r0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f59748a.n = i3;
                this.f59748a.k.i(i3);
                this.f59748a.l.setHeaderViewHeight(i3);
            }
        }
    }

    /* renamed from: d.a.s0.g1.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1432c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f59749e;

        public View$OnClickListenerC1432c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59749e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    ((HotTopicActivity) this.f59749e.f59738a.getOrignalPage()).showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f59749e.f59738a.getContext())) {
                    TiebaStatic.log(new StatisticItem("c10521").param("obj_id", ((HotTopicActivity) this.f59749e.f59738a.getOrignalPage()).getHotTopicId()).param("topic_id", ((HotTopicActivity) this.f59749e.f59738a.getOrignalPage()).getHotTopicId()));
                    ((HotTopicActivity) this.f59749e.f59738a.getOrignalPage()).shareTopic();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f59750e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59750e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    ((HotTopicActivity) this.f59750e.f59738a.getOrignalPage()).showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f59750e.f59738a.getContext())) {
                    TiebaStatic.log(new StatisticItem("c10521").param("obj_id", ((HotTopicActivity) this.f59750e.f59738a.getOrignalPage()).getHotTopicId()).param("topic_id", ((HotTopicActivity) this.f59750e.f59738a.getOrignalPage()).getHotTopicId()));
                    ((HotTopicActivity) this.f59750e.f59738a.getOrignalPage()).shareTopic();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f59751e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c cVar) {
            super(cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59751e = cVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            HotTopicView l;
            HotTopicActivity hotTopicActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || (l = this.f59751e.k.l()) == null) {
                return;
            }
            if (absListView == l.getListView()) {
                if (this.f59751e.f59745h != null) {
                    this.f59751e.f59745h.m(i2);
                }
                this.f59751e.G();
            }
            if (this.f59751e.k != null && this.f59751e.f59746i.getNavigationBarSwitchHeight() != this.f59751e.o) {
                if (this.f59751e.x) {
                    float navigationBarSwitchHeight = (-this.f59751e.f59746i.getY()) / (this.f59751e.f59746i.getNavigationBarSwitchHeight() - this.f59751e.o);
                    this.f59751e.f59740c.setAlpha(1.0f - navigationBarSwitchHeight);
                    this.f59751e.f59741d.setAlpha(navigationBarSwitchHeight);
                    if (this.f59751e.p != null) {
                        this.f59751e.p.setAlpha((-this.f59751e.f59746i.getY()) / (this.f59751e.f59746i.getNavigationBarSwitchHeight() - this.f59751e.o));
                    }
                } else {
                    if (this.f59751e.p != null) {
                        this.f59751e.p.setAlpha((-this.f59751e.f59746i.getY()) / (this.f59751e.f59746i.getNavigationBarSwitchHeight() - this.f59751e.o));
                    }
                    if (Math.abs(this.f59751e.w) == this.f59751e.v()) {
                        this.f59751e.f59741d.hideBottomLine();
                    } else {
                        this.f59751e.f59741d.showBottomLine();
                    }
                }
            }
            if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) this.f59751e.f59738a.getOrignalPage()) != null) {
                hotTopicActivity.onScrollToBottom();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            HotTopicView l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && (l = this.f59751e.k.l()) != null && absListView == l.getListView() && i2 == 0) {
                this.f59751e.v = true;
                float y = this.f59751e.f59746i.getY();
                if (this.f59751e.k != null) {
                    if (Math.abs(this.f59751e.w) != this.f59751e.v() || this.f59751e.w == y) {
                        this.f59751e.k.t((int) (this.f59751e.w - y));
                        return;
                    }
                    this.f59751e.k.u(y);
                    this.f59751e.f59740c.hideBottomLine();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public abstract class f implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = new a(this);
        this.u = new b(this);
        this.x = false;
        this.z = new e(this);
        this.f59738a = tbPageContext;
        this.y = str;
        z();
    }

    public void A(List<d.a.s0.g1.c.e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.k.z(list);
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            NavigationBar navigationBar = this.f59740c;
            if (navigationBar != null && this.x) {
                navigationBar.onChangeSkinType(this.f59738a, i2);
                this.f59740c.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
                SkinManager.setImageResource(this.f59740c.getBackImageView(), R.drawable.selector_topbar_return_white);
                this.f59740c.setAlpha((this.f59746i.getY() / (this.f59746i.getNavigationBarSwitchHeight() - this.o)) + 1.0f);
            }
            NavigationBar navigationBar2 = this.f59741d;
            if (navigationBar2 != null) {
                navigationBar2.onChangeSkinType(this.f59738a, i2);
                if (this.x) {
                    this.f59741d.setAlpha((-this.f59746i.getY()) / (this.f59746i.getNavigationBarSwitchHeight() - this.o));
                } else {
                    this.f59741d.setAlpha(1.0f);
                }
            }
            NoNetworkView noNetworkView = this.f59744g;
            if (noNetworkView != null) {
                noNetworkView.c(this.f59738a, i2);
            }
            if (this.f59743f != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59743f, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.f59742e != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59742e, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            HotTopicHeaderView hotTopicHeaderView = this.f59746i;
            if (hotTopicHeaderView != null) {
                hotTopicHeaderView.m();
            }
            HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
            if (hotTopicThreadPagerAdapter != null) {
                hotTopicThreadPagerAdapter.p(i2);
            }
            ImageView imageView = this.q;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, R.drawable.icon_tabbar_chaticon_n);
                SkinManager.setImageResource(this.q, R.drawable.icon_tabbar_add_n);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k.j(false);
        }
    }

    public void D() {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.q();
    }

    public void E(boolean z) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (noNetworkView = this.f59744g) == null) {
            return;
        }
        if (z) {
            noNetworkView.setVisibility(0);
        } else {
            noNetworkView.setVisibility(8);
        }
    }

    public void F() {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.s();
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.v) {
            this.w = this.f59746i.getY();
            this.v = false;
        }
    }

    public final void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            TextView textView = this.p;
            if (textView != null) {
                textView.setText(str);
                return;
            }
            NavigationBar navigationBar = this.f59741d;
            if (navigationBar != null) {
                this.p = navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f59746i.setVisibility(i2);
            this.j.setVisibility(i2);
        }
    }

    public void J(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.s = bVar;
            NoNetworkView noNetworkView = this.f59744g;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void K(View.OnTouchListener onTouchListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, onTouchListener) == null) || onTouchListener == null || (imageView = this.q) == null) {
            return;
        }
        imageView.setOnTouchListener(onTouchListener);
    }

    public void L(d.a.s0.g1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        if (!this.f59746i.l()) {
            this.f59746i.setData(eVar.h());
        }
        if (eVar.h() != null) {
            boolean z = !StringUtils.isNull(eVar.h().f59678i);
            this.x = z;
            this.f59740c.setVisibility(z ? 0 : 8);
            if (!this.x) {
                this.f59741d.setAlpha(1.0f);
                this.f59741d.showBottomLine();
            }
        }
        String str = eVar.h().f59675f;
        if (StringUtils.isNull(str)) {
            this.q.setVisibility(8);
            H("");
        } else {
            H(d.a.s0.g1.e.a.a(str, 10));
        }
        this.f59746i.setHeaderBottomLineShow(true);
    }

    public void M(int i2) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.w(i2);
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.k.x();
        }
    }

    public void O(int i2) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.y(i2);
    }

    public void P(AbsListView absListView, int i2) {
        HotTopicView l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, absListView, i2) == null) || this.f59746i == null || this.l == null || (l = this.k.l()) == null || l.getListView() == null || absListView != l.getListView()) {
            return;
        }
        this.l.setHeaderViewHeight(this.n - i2);
        this.f59746i.setY(-i2);
        if (i2 == 0) {
            this.l.a(false);
        } else {
            this.l.a(true);
        }
    }

    public void p() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
            if (hotTopicThreadPagerAdapter != null) {
                hotTopicThreadPagerAdapter.k();
            }
            d.a.s0.g1.f.e eVar = this.f59745h;
            if (eVar != null) {
                eVar.k();
            }
            NoNetworkView noNetworkView = this.f59744g;
            if (noNetworkView == null || (bVar = this.s) == null) {
                return;
            }
            noNetworkView.d(bVar);
        }
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.j.getCurrentItem() < 0) {
                return 0;
            }
            return this.j.getCurrentItem();
        }
        return invokeV.intValue;
    }

    public HotTopicView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k.l() : (HotTopicView) invokeV.objValue;
    }

    public HotTopicHeaderView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f59746i : (HotTopicHeaderView) invokeV.objValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.n : invokeV.intValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f59739b : (View) invokeV.objValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.n - this.m) - this.o : invokeV.intValue;
    }

    public void w(int i2) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.m(i2);
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.k.n();
        }
    }

    public void y(int i2, boolean z, long j, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i3)}) == null) {
            this.f59745h.l(i2, z, j, i3);
        }
    }

    public final void z() {
        TbPageContext<HotTopicActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (tbPageContext = this.f59738a) == null) {
            return;
        }
        tbPageContext.getOrignalPage().setContentView(R.layout.hot_topic_activity);
        this.m = l.g(this.f59738a.getPageActivity(), R.dimen.ds80);
        d.a.s0.g1.b.c cVar = new d.a.s0.g1.b.c((OvalActionButton) this.f59738a.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.f59738a);
        this.r = cVar;
        cVar.d(this.y);
        RelativeLayout relativeLayout = (RelativeLayout) this.f59738a.getOrignalPage().findViewById(R.id.hot_topic_root_view);
        this.f59739b = relativeLayout;
        this.l = (DisableScrollLayout) relativeLayout.findViewById(R.id.disable_scroll_layout);
        NavigationBar navigationBar = (NavigationBar) this.f59738a.getOrignalPage().findViewById(R.id.view_navigation_bar);
        this.f59740c = navigationBar;
        navigationBar.hideBottomLine();
        NavigationBar navigationBar2 = (NavigationBar) this.f59738a.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
        this.f59741d = navigationBar2;
        TextView centerTextTitle = navigationBar2.setCenterTextTitle("");
        this.p = centerTextTitle;
        centerTextTitle.setAlpha(0.0f);
        this.f59741d.hideBottomLine();
        this.f59740c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        SkinManager.setImageResource(this.f59740c.getBackImageView(), R.drawable.selector_topbar_return_white);
        this.f59741d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59742e = (ImageView) this.f59740c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View$OnClickListenerC1432c(this));
        this.f59743f = (ImageView) this.f59741d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d(this));
        this.f59744g = (NoNetworkView) this.f59739b.findViewById(R.id.view_no_network);
        ((ObservedChangeLinearLayout) this.f59739b.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.t);
        this.f59745h = new d.a.s0.g1.f.e(this.f59738a, this.f59739b);
        HotTopicHeaderView hotTopicHeaderView = (HotTopicHeaderView) this.f59739b.findViewById(R.id.hot_topic_header);
        this.f59746i = hotTopicHeaderView;
        hotTopicHeaderView.setOnSizeChangeListener(this.u);
        this.j = (CustomViewPager) this.f59739b.findViewById(R.id.hot_topic_view_pager);
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = new HotTopicThreadPagerAdapter(this.f59738a.getPageActivity(), this.z);
        this.k = hotTopicThreadPagerAdapter;
        hotTopicThreadPagerAdapter.v(this);
        this.j.setAdapter(this.k);
        this.f59746i.setViewPager(this.j);
        this.f59746i.setHeaderBottomLineShow(false);
        ImageView imageView = (ImageView) this.f59739b.findViewById(R.id.normal_write_icon);
        this.q = imageView;
        imageView.setVisibility(8);
    }
}

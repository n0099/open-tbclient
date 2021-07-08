package d.a.p0.g1.f;

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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f56480a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f56481b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56482c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56483d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f56484e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56485f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f56486g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.g1.f.e f56487h;

    /* renamed from: i  reason: collision with root package name */
    public HotTopicHeaderView f56488i;
    public CustomViewPager j;
    public HotTopicThreadPagerAdapter k;
    public DisableScrollLayout l;
    public int m;
    public int n;
    public int o;
    public TextView p;
    public ImageView q;
    public d.a.p0.g1.b.c r;
    public NoNetworkView.b s;
    public final d.a.o0.b1.j.e t;
    public final d.a.o0.b1.j.e u;
    public boolean v;
    public float w;
    public boolean x;
    public String y;
    public f z;

    /* loaded from: classes8.dex */
    public class a implements d.a.o0.b1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56489a;

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
            this.f56489a = cVar;
        }

        @Override // d.a.o0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f56489a.o = i3;
                if (this.f56489a.f56488i != null) {
                    this.f56489a.f56488i.i(i3);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.o0.b1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56490a;

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
            this.f56490a = cVar;
        }

        @Override // d.a.o0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f56490a.n = i3;
                this.f56490a.k.b(i3);
                this.f56490a.l.setHeaderViewHeight(i3);
            }
        }
    }

    /* renamed from: d.a.p0.g1.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1386c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f56491e;

        public View$OnClickListenerC1386c(c cVar) {
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
            this.f56491e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    ((HotTopicActivity) this.f56491e.f56480a.getOrignalPage()).showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f56491e.f56480a.getContext())) {
                    TiebaStatic.log(new StatisticItem("c10521").param("obj_id", ((HotTopicActivity) this.f56491e.f56480a.getOrignalPage()).getHotTopicId()).param("topic_id", ((HotTopicActivity) this.f56491e.f56480a.getOrignalPage()).getHotTopicId()));
                    ((HotTopicActivity) this.f56491e.f56480a.getOrignalPage()).shareTopic();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f56492e;

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
            this.f56492e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    ((HotTopicActivity) this.f56492e.f56480a.getOrignalPage()).showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f56492e.f56480a.getContext())) {
                    TiebaStatic.log(new StatisticItem("c10521").param("obj_id", ((HotTopicActivity) this.f56492e.f56480a.getOrignalPage()).getHotTopicId()).param("topic_id", ((HotTopicActivity) this.f56492e.f56480a.getOrignalPage()).getHotTopicId()));
                    ((HotTopicActivity) this.f56492e.f56480a.getOrignalPage()).shareTopic();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f56493e;

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
            this.f56493e = cVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            HotTopicView e2;
            HotTopicActivity hotTopicActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || (e2 = this.f56493e.k.e()) == null) {
                return;
            }
            if (absListView == e2.getListView()) {
                if (this.f56493e.f56487h != null) {
                    this.f56493e.f56487h.m(i2);
                }
                this.f56493e.G();
            }
            if (this.f56493e.k != null && this.f56493e.f56488i.getNavigationBarSwitchHeight() != this.f56493e.o) {
                if (this.f56493e.x) {
                    float navigationBarSwitchHeight = (-this.f56493e.f56488i.getY()) / (this.f56493e.f56488i.getNavigationBarSwitchHeight() - this.f56493e.o);
                    this.f56493e.f56482c.setAlpha(1.0f - navigationBarSwitchHeight);
                    this.f56493e.f56483d.setAlpha(navigationBarSwitchHeight);
                    if (this.f56493e.p != null) {
                        this.f56493e.p.setAlpha((-this.f56493e.f56488i.getY()) / (this.f56493e.f56488i.getNavigationBarSwitchHeight() - this.f56493e.o));
                    }
                } else {
                    if (this.f56493e.p != null) {
                        this.f56493e.p.setAlpha((-this.f56493e.f56488i.getY()) / (this.f56493e.f56488i.getNavigationBarSwitchHeight() - this.f56493e.o));
                    }
                    if (Math.abs(this.f56493e.w) == this.f56493e.v()) {
                        this.f56493e.f56483d.hideBottomLine();
                    } else {
                        this.f56493e.f56483d.showBottomLine();
                    }
                }
            }
            if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) this.f56493e.f56480a.getOrignalPage()) != null) {
                hotTopicActivity.onScrollToBottom();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            HotTopicView e2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && (e2 = this.f56493e.k.e()) != null && absListView == e2.getListView() && i2 == 0) {
                this.f56493e.v = true;
                float y = this.f56493e.f56488i.getY();
                if (this.f56493e.k != null) {
                    if (Math.abs(this.f56493e.w) != this.f56493e.v() || this.f56493e.w == y) {
                        this.f56493e.k.m((int) (this.f56493e.w - y));
                        return;
                    }
                    this.f56493e.k.n(y);
                    this.f56493e.f56482c.hideBottomLine();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
        this.f56480a = tbPageContext;
        this.y = str;
        z();
    }

    public void A(List<d.a.p0.g1.c.e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.k.s(list);
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            NavigationBar navigationBar = this.f56482c;
            if (navigationBar != null && this.x) {
                navigationBar.onChangeSkinType(this.f56480a, i2);
                this.f56482c.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
                SkinManager.setImageResource(this.f56482c.getBackImageView(), R.drawable.selector_topbar_return_white);
                this.f56482c.setAlpha((this.f56488i.getY() / (this.f56488i.getNavigationBarSwitchHeight() - this.o)) + 1.0f);
            }
            NavigationBar navigationBar2 = this.f56483d;
            if (navigationBar2 != null) {
                navigationBar2.onChangeSkinType(this.f56480a, i2);
                if (this.x) {
                    this.f56483d.setAlpha((-this.f56488i.getY()) / (this.f56488i.getNavigationBarSwitchHeight() - this.o));
                } else {
                    this.f56483d.setAlpha(1.0f);
                }
            }
            NoNetworkView noNetworkView = this.f56486g;
            if (noNetworkView != null) {
                noNetworkView.c(this.f56480a, i2);
            }
            if (this.f56485f != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56485f, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.f56484e != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56484e, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            HotTopicHeaderView hotTopicHeaderView = this.f56488i;
            if (hotTopicHeaderView != null) {
                hotTopicHeaderView.m();
            }
            HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
            if (hotTopicThreadPagerAdapter != null) {
                hotTopicThreadPagerAdapter.i(i2);
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
            this.k.c(false);
        }
    }

    public void D() {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.j();
    }

    public void E(boolean z) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (noNetworkView = this.f56486g) == null) {
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
        hotTopicThreadPagerAdapter.l();
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.v) {
            this.w = this.f56488i.getY();
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
            NavigationBar navigationBar = this.f56483d;
            if (navigationBar != null) {
                this.p = navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f56488i.setVisibility(i2);
            this.j.setVisibility(i2);
        }
    }

    public void J(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.s = bVar;
            NoNetworkView noNetworkView = this.f56486g;
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

    public void L(d.a.p0.g1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        if (!this.f56488i.l()) {
            this.f56488i.setData(eVar.h());
        }
        if (eVar.h() != null) {
            boolean z = !StringUtils.isNull(eVar.h().f56420i);
            this.x = z;
            this.f56482c.setVisibility(z ? 0 : 8);
            if (!this.x) {
                this.f56483d.setAlpha(1.0f);
                this.f56483d.showBottomLine();
            }
        }
        String str = eVar.h().f56417f;
        if (StringUtils.isNull(str)) {
            this.q.setVisibility(8);
            H("");
        } else {
            H(d.a.p0.g1.e.a.a(str, 10));
        }
        this.f56488i.setHeaderBottomLineShow(true);
    }

    public void M(int i2) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.p(i2);
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.k.q();
        }
    }

    public void O(int i2) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.r(i2);
    }

    public void P(AbsListView absListView, int i2) {
        HotTopicView e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, absListView, i2) == null) || this.f56488i == null || this.l == null || (e2 = this.k.e()) == null || e2.getListView() == null || absListView != e2.getListView()) {
            return;
        }
        this.l.setHeaderViewHeight(this.n - i2);
        this.f56488i.setY(-i2);
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
                hotTopicThreadPagerAdapter.d();
            }
            d.a.p0.g1.f.e eVar = this.f56487h;
            if (eVar != null) {
                eVar.k();
            }
            NoNetworkView noNetworkView = this.f56486g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k.e() : (HotTopicView) invokeV.objValue;
    }

    public HotTopicHeaderView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f56488i : (HotTopicHeaderView) invokeV.objValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.n : invokeV.intValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f56481b : (View) invokeV.objValue;
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
        hotTopicThreadPagerAdapter.f(i2);
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.k.g();
        }
    }

    public void y(int i2, boolean z, long j, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i3)}) == null) {
            this.f56487h.l(i2, z, j, i3);
        }
    }

    public final void z() {
        TbPageContext<HotTopicActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (tbPageContext = this.f56480a) == null) {
            return;
        }
        tbPageContext.getOrignalPage().setContentView(R.layout.hot_topic_activity);
        this.m = l.g(this.f56480a.getPageActivity(), R.dimen.ds80);
        d.a.p0.g1.b.c cVar = new d.a.p0.g1.b.c((OvalActionButton) this.f56480a.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.f56480a);
        this.r = cVar;
        cVar.d(this.y);
        RelativeLayout relativeLayout = (RelativeLayout) this.f56480a.getOrignalPage().findViewById(R.id.hot_topic_root_view);
        this.f56481b = relativeLayout;
        this.l = (DisableScrollLayout) relativeLayout.findViewById(R.id.disable_scroll_layout);
        NavigationBar navigationBar = (NavigationBar) this.f56480a.getOrignalPage().findViewById(R.id.view_navigation_bar);
        this.f56482c = navigationBar;
        navigationBar.hideBottomLine();
        NavigationBar navigationBar2 = (NavigationBar) this.f56480a.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
        this.f56483d = navigationBar2;
        TextView centerTextTitle = navigationBar2.setCenterTextTitle("");
        this.p = centerTextTitle;
        centerTextTitle.setAlpha(0.0f);
        this.f56483d.hideBottomLine();
        this.f56482c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        SkinManager.setImageResource(this.f56482c.getBackImageView(), R.drawable.selector_topbar_return_white);
        this.f56483d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56484e = (ImageView) this.f56482c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View$OnClickListenerC1386c(this));
        this.f56485f = (ImageView) this.f56483d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d(this));
        this.f56486g = (NoNetworkView) this.f56481b.findViewById(R.id.view_no_network);
        ((ObservedChangeLinearLayout) this.f56481b.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.t);
        this.f56487h = new d.a.p0.g1.f.e(this.f56480a, this.f56481b);
        HotTopicHeaderView hotTopicHeaderView = (HotTopicHeaderView) this.f56481b.findViewById(R.id.hot_topic_header);
        this.f56488i = hotTopicHeaderView;
        hotTopicHeaderView.setOnSizeChangeListener(this.u);
        this.j = (CustomViewPager) this.f56481b.findViewById(R.id.hot_topic_view_pager);
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = new HotTopicThreadPagerAdapter(this.f56480a.getPageActivity(), this.z);
        this.k = hotTopicThreadPagerAdapter;
        hotTopicThreadPagerAdapter.o(this);
        this.j.setAdapter(this.k);
        this.f56488i.setViewPager(this.j);
        this.f56488i.setHeaderBottomLineShow(false);
        ImageView imageView = (ImageView) this.f56481b.findViewById(R.id.normal_write_icon);
        this.q = imageView;
        imageView.setVisibility(8);
    }
}

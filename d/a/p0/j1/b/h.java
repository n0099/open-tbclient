package d.a.p0.j1.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.switchs.MessageChooseFriendSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class h extends d.a.c.a.d implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MessageCenterFragment f59000e;

    /* renamed from: f  reason: collision with root package name */
    public TbTabLayout f59001f;

    /* renamed from: g  reason: collision with root package name */
    public BdBaseViewPager f59002g;

    /* renamed from: h  reason: collision with root package name */
    public MessageFragmentPagerAdapter f59003h;

    /* renamed from: i  reason: collision with root package name */
    public List<MessageFragmentPagerAdapter.a> f59004i;
    public View j;
    public ChatAggregationFragment k;
    public ImageView l;
    public NavigationBar m;
    public NoNetworkView n;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f59005e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59005e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f59005e.f59000e == null) {
                return;
            }
            this.f59005e.f59000e.J0();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f59006e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59006e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f59006e.f59000e == null) {
                return;
            }
            this.f59006e.f59000e.K0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageCenterFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59000e = messageCenterFragment;
    }

    public static String m(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i2 + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void b(boolean z) {
        List<MessageFragmentPagerAdapter.a> list;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (list = this.f59004i) == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.f59004i.size(); i2++) {
            MessageFragmentPagerAdapter.a aVar = this.f59004i.get(i2);
            if (aVar != null && (fragment = aVar.f17898a) != null && (fragment instanceof NoNetworkView.b)) {
                ((NoNetworkView.b) fragment).b(z);
            }
        }
    }

    public void e(TbTabLayout.c cVar) {
        TbTabLayout tbTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (tbTabLayout = this.f59001f) == null || cVar == null) {
            return;
        }
        tbTabLayout.c(cVar);
    }

    public TbTabLayout.f f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbTabLayout tbTabLayout = this.f59001f;
            if (tbTabLayout == null || tbTabLayout.getTabCount() <= 0) {
                return null;
            }
            TbTabLayout tbTabLayout2 = this.f59001f;
            return tbTabLayout2.w(tbTabLayout2.getSelectedTabPosition());
        }
        return (TbTabLayout.f) invokeV.objValue;
    }

    public TbTabLayout.f g(int i2) {
        InterceptResult invokeI;
        int tabCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            TbTabLayout tbTabLayout = this.f59001f;
            if (tbTabLayout != null && (tabCount = tbTabLayout.getTabCount()) > 0) {
                for (int i3 = 0; i3 < tabCount; i3++) {
                    TbTabLayout.f w = this.f59001f.w(i3);
                    if (w != null && w.d() != -1 && w.d() == i2) {
                        return w;
                    }
                }
            }
            return null;
        }
        return (TbTabLayout.f) invokeI.objValue;
    }

    public final void h(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) this.j.findViewById(R.id.navigation_bar);
            this.m = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            if (addSystemImageButton != null) {
                if (this.f59000e.getActivity() instanceof MessageCenterActivity) {
                    addSystemImageButton.setVisibility(0);
                } else {
                    addSystemImageButton.setVisibility(4);
                }
            }
            this.l = new ImageView(this.f59000e.getContext());
            int g2 = d.a.c.e.p.l.g(this.f59000e.getContext(), R.dimen.ds88);
            this.l.setLayoutParams(new ViewGroup.LayoutParams(g2, g2));
            this.l.setScaleType(ImageView.ScaleType.CENTER);
            this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.l, new b(this));
            if (this.l.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, d.a.c.e.p.l.g(this.f59000e.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
                this.l.setLayoutParams(marginLayoutParams);
            }
            if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(4);
            }
            TbTabLayout tbTabLayout = this.f59001f;
            if (tbTabLayout != null) {
                this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, tbTabLayout, (View.OnClickListener) null);
                ViewGroup viewGroup = (ViewGroup) this.f59001f.getParent();
                if (viewGroup instanceof LinearLayout) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else if (viewGroup instanceof RelativeLayout) {
                    ((RelativeLayout) viewGroup).setGravity(17);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.gravity = 17;
                    viewGroup.setLayoutParams(layoutParams);
                }
                TbTabLayout tbTabLayout2 = this.f59001f;
                tbTabLayout2.setPadding(tbTabLayout2.getPaddingLeft(), this.f59001f.getPaddingTop(), this.f59001f.getPaddingRight(), this.f59001f.getPaddingBottom() + d.a.c.e.p.l.g(this.f59000e.getContext(), R.dimen.ds1));
            }
        }
    }

    public final void j(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            TbTabLayout tbTabLayout = (TbTabLayout) LayoutInflater.from(this.f59000e.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
            this.f59001f = tbTabLayout;
            tbTabLayout.setupWithViewPager(this.f59002g);
            int tabCount = this.f59001f.getTabCount();
            if (tabCount > 0) {
                for (int i2 = 0; i2 < tabCount; i2++) {
                    this.f59001f.w(i2).q(1);
                }
            }
        }
    }

    public void k(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view, bundle) == null) || view == null) {
            return;
        }
        this.j = view;
        l(bundle);
        j(bundle);
        h(bundle);
        NoNetworkView noNetworkView = (NoNetworkView) this.j.findViewById(R.id.view_no_network);
        this.n = noNetworkView;
        noNetworkView.a(this);
    }

    public final void l(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            this.f59002g = (BdBaseViewPager) this.j.findViewById(R.id.message_viewpager);
            MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
            ChatAggregationFragment chatAggregationFragment = new ChatAggregationFragment();
            this.k = chatAggregationFragment;
            aVar.f17898a = chatAggregationFragment;
            aVar.f17899b = this.f59000e.getResources().getString(R.string.message_center_message_tab);
            ArrayList arrayList = new ArrayList();
            this.f59004i = arrayList;
            arrayList.add(aVar);
            MessageFragmentPagerAdapter messageFragmentPagerAdapter = new MessageFragmentPagerAdapter(this.f59000e.getActivity().getSupportFragmentManager(), this.f59004i);
            this.f59003h = messageFragmentPagerAdapter;
            this.f59002g.setAdapter(messageFragmentPagerAdapter);
            this.f59002g.setOffscreenPageLimit(this.f59004i.size());
            this.f59003h.notifyDataSetChanged();
        }
    }

    public void n(int i2, int i3, Intent intent) {
        List<MessageFragmentPagerAdapter.a> list;
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent) == null) || (list = this.f59004i) == null || list.size() <= 0 || (bdBaseViewPager = this.f59002g) == null) {
            return;
        }
        MessageFragmentPagerAdapter.a aVar = this.f59004i.get(bdBaseViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.f17898a) == null) {
            return;
        }
        fragment.onActivityResult(i2, i3, intent);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageCenterFragment messageCenterFragment = this.f59000e;
            if (messageCenterFragment != null && this.f59004i != null && this.f59002g != null && this.f59003h != null) {
                FragmentManager supportFragmentManager = messageCenterFragment.getActivity().getSupportFragmentManager();
                if (supportFragmentManager.isDestroyed()) {
                    return;
                }
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i2 = 0; i2 < this.f59004i.size(); i2++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(m(this.f59002g.getId(), this.f59003h.getItemId(i2)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            }
            NoNetworkView noNetworkView = this.n;
            if (noNetworkView != null) {
                noNetworkView.d(this);
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            NavigationBar navigationBar = this.m;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i2);
                SkinManager.setBackgroundColor(this.m.getBarBgView(), R.color.CAM_X0207, i2);
            }
            NoNetworkView noNetworkView = this.n;
            if (noNetworkView != null) {
                noNetworkView.c(getPageContext(), i2);
            }
            List<MessageFragmentPagerAdapter.a> list = this.f59004i;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < this.f59004i.size(); i3++) {
                    MessageFragmentPagerAdapter.a aVar = this.f59004i.get(i3);
                    if (aVar != null && (fragment = aVar.f17898a) != null && (fragment instanceof BaseFragment)) {
                        ((BaseFragment) fragment).onChangeSkinType(i2);
                    }
                }
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_chat_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            TbTabLayout tbTabLayout = this.f59001f;
            if (tbTabLayout != null) {
                tbTabLayout.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
                this.f59001f.setSelectedTabIndicatorHeight(0);
                this.f59001f.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public void p() {
        ChatAggregationFragment chatAggregationFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (chatAggregationFragment = this.k) == null) {
            return;
        }
        chatAggregationFragment.o();
    }

    public void q(TbTabLayout.c cVar) {
        TbTabLayout tbTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) || (tbTabLayout = this.f59001f) == null || cVar == null) {
            return;
        }
        tbTabLayout.C(cVar);
    }

    public void r(int i2) {
        TbTabLayout.f g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (g2 = g(i2)) == null) {
            return;
        }
        g2.l();
    }

    public void s(boolean z) {
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            MessageFragmentPagerAdapter messageFragmentPagerAdapter = this.f59003h;
            if (messageFragmentPagerAdapter != null) {
                messageFragmentPagerAdapter.b(z);
            }
            List<MessageFragmentPagerAdapter.a> list = this.f59004i;
            if (list == null || list.size() <= 0 || (bdBaseViewPager = this.f59002g) == null) {
                return;
            }
            MessageFragmentPagerAdapter.a aVar = this.f59004i.get(bdBaseViewPager.getCurrentItem());
            if (aVar == null || (fragment = aVar.f17898a) == null || !(fragment instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) fragment).setPrimary(z);
        }
    }
}

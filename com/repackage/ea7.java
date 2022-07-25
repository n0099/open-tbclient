package com.repackage;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ea7 extends b9 implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageCenterFragment a;
    public TbTabLayout b;
    public BdBaseViewPager c;
    public MessageFragmentPagerAdapter d;
    public List<MessageFragmentPagerAdapter.a> e;
    public View f;
    public ChatAggregationFragment g;
    public TextView h;
    public NavigationBar i;
    public NoNetworkView j;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ea7 a;

        public a(ea7 ea7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ea7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            this.a.a.x1();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ea7 a;

        public b(ea7 ea7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ea7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            TiebaStatic.log("c14668");
            this.a.a.y1();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ea7(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageCenterFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = messageCenterFragment;
    }

    public static String o(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void g(boolean z) {
        List<MessageFragmentPagerAdapter.a> list;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (list = this.e) == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.e.size(); i++) {
            MessageFragmentPagerAdapter.a aVar = this.e.get(i);
            if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof NoNetworkView.b)) {
                ((NoNetworkView.b) fragment).g(z);
            }
        }
    }

    public TbTabLayout.f h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TbTabLayout tbTabLayout = this.b;
            if (tbTabLayout == null || tbTabLayout.getTabCount() <= 0) {
                return null;
            }
            TbTabLayout tbTabLayout2 = this.b;
            return tbTabLayout2.w(tbTabLayout2.getSelectedTabPosition());
        }
        return (TbTabLayout.f) invokeV.objValue;
    }

    public TbTabLayout.f j(int i) {
        InterceptResult invokeI;
        int tabCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            TbTabLayout tbTabLayout = this.b;
            if (tbTabLayout != null && (tabCount = tbTabLayout.getTabCount()) > 0) {
                for (int i2 = 0; i2 < tabCount; i2++) {
                    TbTabLayout.f w = this.b.w(i2);
                    if (w != null && w.d() != -1 && w.d() == i) {
                        return w;
                    }
                }
            }
            return null;
        }
        return (TbTabLayout.f) invokeI.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f.findViewById(R.id.obfuscated_res_0x7f091568);
            this.i = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            if (addSystemImageButton != null) {
                if (this.a.getActivity() instanceof MessageCenterActivity) {
                    addSystemImageButton.setVisibility(0);
                } else {
                    addSystemImageButton.setVisibility(4);
                }
            }
            TextView textView = new TextView(this.a.getContext());
            this.h = textView;
            textView.setText(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f08b0));
            this.h.setGravity(16);
            this.h.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
            this.h.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809da, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null, (Drawable) null);
            vr4 d = vr4.d(this.h);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            this.i.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.h, new b(this));
            if (this.h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, pi.f(this.a.getContext(), R.dimen.M_W_X007), 0);
                this.h.setLayoutParams(marginLayoutParams);
            }
            if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(4);
            }
            TbTabLayout tbTabLayout = this.b;
            if (tbTabLayout != null) {
                this.i.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, tbTabLayout, (View.OnClickListener) null);
                ViewGroup viewGroup = (ViewGroup) this.b.getParent();
                if (viewGroup instanceof LinearLayout) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else if (viewGroup instanceof RelativeLayout) {
                    ((RelativeLayout) viewGroup).setGravity(17);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.gravity = 17;
                    viewGroup.setLayoutParams(layoutParams);
                }
                TbTabLayout tbTabLayout2 = this.b;
                tbTabLayout2.setPadding(tbTabLayout2.getPaddingLeft(), this.b.getPaddingTop(), this.b.getPaddingRight(), this.b.getPaddingBottom() + pi.f(this.a.getContext(), R.dimen.obfuscated_res_0x7f070198));
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbTabLayout tbTabLayout = (TbTabLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d055c, (ViewGroup) null);
            this.b = tbTabLayout;
            tbTabLayout.setupWithViewPager(this.c);
            int tabCount = this.b.getTabCount();
            if (tabCount > 0) {
                for (int i = 0; i < tabCount; i++) {
                    this.b.w(i).q(1);
                }
            }
        }
    }

    public void m(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view2) == null) || view2 == null) {
            return;
        }
        this.f = view2;
        n();
        l();
        k();
        NoNetworkView noNetworkView = (NoNetworkView) this.f.findViewById(R.id.obfuscated_res_0x7f09243b);
        this.j = noNetworkView;
        noNetworkView.a(this);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c = (BdBaseViewPager) this.f.findViewById(R.id.obfuscated_res_0x7f09145e);
            MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
            ChatAggregationFragment chatAggregationFragment = new ChatAggregationFragment();
            this.g = chatAggregationFragment;
            aVar.a = chatAggregationFragment;
            aVar.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0aa5);
            ArrayList arrayList = new ArrayList();
            this.e = arrayList;
            arrayList.add(aVar);
            MessageFragmentPagerAdapter messageFragmentPagerAdapter = new MessageFragmentPagerAdapter(this.a.getActivity().getSupportFragmentManager(), this.e);
            this.d = messageFragmentPagerAdapter;
            this.c.setAdapter(messageFragmentPagerAdapter);
            this.c.setOffscreenPageLimit(this.e.size());
            this.d.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            NavigationBar navigationBar = this.i;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
                SkinManager.setBackgroundColor(this.i.getBarBgView(), R.color.CAM_X0207, i);
            }
            NoNetworkView noNetworkView = this.j;
            if (noNetworkView != null) {
                noNetworkView.d(getPageContext(), i);
            }
            List<MessageFragmentPagerAdapter.a> list = this.e;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.e.size(); i2++) {
                    MessageFragmentPagerAdapter.a aVar = this.e.get(i2);
                    if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof BaseFragment)) {
                        ((BaseFragment) fragment).onChangeSkinType(i);
                    }
                }
            }
            this.h.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809da, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null, (Drawable) null);
            vr4 d = vr4.d(this.h);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            TbTabLayout tbTabLayout = this.b;
            if (tbTabLayout != null) {
                tbTabLayout.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
                this.b.setSelectedTabIndicatorHeight(0);
                this.b.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public void p(int i, int i2, Intent intent) {
        List<MessageFragmentPagerAdapter.a> list;
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, intent) == null) || (list = this.e) == null || list.size() <= 0 || (bdBaseViewPager = this.c) == null) {
            return;
        }
        MessageFragmentPagerAdapter.a aVar = this.e.get(bdBaseViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.a) == null) {
            return;
        }
        fragment.onActivityResult(i, i2, intent);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageCenterFragment messageCenterFragment = this.a;
            if (messageCenterFragment != null && this.e != null && this.c != null && this.d != null) {
                FragmentManager supportFragmentManager = messageCenterFragment.getActivity().getSupportFragmentManager();
                if (supportFragmentManager.isDestroyed()) {
                    return;
                }
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.e.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(o(this.c.getId(), this.d.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            }
            NoNetworkView noNetworkView = this.j;
            if (noNetworkView != null) {
                noNetworkView.e(this);
            }
        }
    }

    public void r() {
        ChatAggregationFragment chatAggregationFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (chatAggregationFragment = this.g) == null) {
            return;
        }
        chatAggregationFragment.t();
    }

    public void s(int i) {
        TbTabLayout.f j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (j = j(i)) == null) {
            return;
        }
        j.l();
    }

    public void t(boolean z) {
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            MessageFragmentPagerAdapter messageFragmentPagerAdapter = this.d;
            if (messageFragmentPagerAdapter != null) {
                messageFragmentPagerAdapter.b(z);
            }
            List<MessageFragmentPagerAdapter.a> list = this.e;
            if (list == null || list.size() <= 0 || (bdBaseViewPager = this.c) == null) {
                return;
            }
            MessageFragmentPagerAdapter.a aVar = this.e.get(bdBaseViewPager.getCurrentItem());
            if (aVar == null || (fragment = aVar.a) == null || !(fragment instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) fragment).setPrimary(z);
        }
    }
}

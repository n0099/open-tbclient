package com.repackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.myCollection.CollectTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class lm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView a;
    public final FragmentTabHost b;
    public int c;
    public Fragment d;
    public final NavigationBar e;
    public final NoNetworkView f;
    public CollectTabActivity g;
    public boolean h;
    public List i;
    public ViewPager.OnPageChangeListener j;

    /* loaded from: classes6.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lm7 a;

        public a(lm7 lm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lm7Var;
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
                this.a.l(i);
                this.a.b(false);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public lm7(CollectTabActivity collectTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collectTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.h = false;
        this.j = new a(this);
        this.g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.obfuscated_res_0x7f091e30);
        this.b = fragmentTabHost;
        fragmentTabHost.setup(this.g.getSupportFragmentManager());
        this.b.setOnPageChangeListener(this.j);
        this.e = (NavigationBar) this.g.findViewById(R.id.obfuscated_res_0x7f091515);
        this.f = (NoNetworkView) this.g.findViewById(R.id.obfuscated_res_0x7f0923ae);
        this.e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.setCenterTextTitle(this.g.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b31));
        TextView textView = (TextView) this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05e6, this.g).findViewById(R.id.obfuscated_res_0x7f091aa9);
        this.a = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f0513);
        this.a.setOnClickListener(this.g);
        this.e.onChangeSkinType(this.g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Fragment fragment = this.d;
            if (fragment instanceof CollectFragment) {
                CollectFragment collectFragment = (CollectFragment) fragment;
                if (!collectFragment.C0()) {
                    z = false;
                }
                k(collectFragment.C0());
                i = collectFragment.getType();
            } else {
                i = -1;
            }
            this.h = z;
            this.a.setText(z ? R.string.obfuscated_res_0x7f0f04e7 : R.string.obfuscated_res_0x7f0f0513);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i2 = R.color.navi_op_text;
            if (skinType == 2) {
                SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.obfuscated_res_0x7f060870);
            } else {
                TextView textView = this.a;
                if (this.h) {
                    i2 = R.color.CAM_X0302;
                }
                SkinManager.setNavbarTitleColor(textView, i2, R.color.obfuscated_res_0x7f060870);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_edit_state", this.h);
            bundle.putInt("fragment_type", i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
        }
    }

    public final void c(m45 m45Var, FragmentTabIndicator fragmentTabIndicator) {
        n45 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m45Var, fragmentTabIndicator) == null) || (b = m45Var.b()) == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.c = b.a;
        bVar.a = b.e;
        fragmentTabIndicator.setText(b.b);
        fragmentTabIndicator.setTextSize(0, this.g.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar.b = fragmentTabIndicator;
        bVar.d = m45Var;
        this.b.c(bVar);
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (TextView) invokeV.objValue;
    }

    public Fragment e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (Fragment) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.i) : invokeV.intValue;
    }

    public void h(ArrayList<m45> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.i = arrayList;
        this.b.u();
        for (int i = 0; i < arrayList.size(); i++) {
            m45 m45Var = arrayList.get(i);
            if (m45Var != null && m45Var.d()) {
                c(m45Var, (FragmentTabIndicator) m45Var.c(this.g.getPageContext().getPageActivity()));
            }
        }
        this.b.n(0);
        this.b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b.s(i);
            if (this.b.getTabWrapper() != null) {
                if (g() <= 1) {
                    this.b.getTabWrapper().setVisibility(8);
                } else {
                    this.b.getTabWrapper().setVisibility(0);
                }
            }
            SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.obfuscated_res_0x7f060870);
            this.e.onChangeSkinType(this.g.getPageContext(), i);
            this.f.c(this.g.getPageContext(), i);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a.setEnabled(z);
            if (z) {
                return;
            }
            this.a.setText(R.string.obfuscated_res_0x7f0f0513);
            SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.obfuscated_res_0x7f060870);
        }
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            FragmentTabHost.b i2 = this.b.i(i);
            this.c = i2.a;
            this.d = i2.c;
        }
    }
}

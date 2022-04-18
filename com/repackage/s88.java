package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.tieba.postsearch.PostSearchListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class s88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PostSearchActivity a;
    public View b;
    public FragmentTabHost c;
    public ViewPager.OnPageChangeListener d;
    public PostSearchListFragment e;
    public PostSearchListFragment f;
    public PostSearchListFragment g;

    public s88(PostSearchActivity postSearchActivity, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postSearchActivity, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = postSearchActivity;
        this.b = view2;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.B0();
            this.f.B0();
            this.g.B0();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            PostSearchListFragment postSearchListFragment = new PostSearchListFragment(1);
            this.e = postSearchListFragment;
            bVar.c = postSearchListFragment;
            bVar.b = c(R.string.obfuscated_res_0x7f0f10aa);
            bVar.a = 1;
            this.c.c(bVar);
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            PostSearchListFragment postSearchListFragment2 = new PostSearchListFragment(2);
            this.f = postSearchListFragment2;
            bVar2.c = postSearchListFragment2;
            bVar2.b = c(R.string.obfuscated_res_0x7f0f10a9);
            bVar2.a = 2;
            this.c.c(bVar2);
            FragmentTabHost.b bVar3 = new FragmentTabHost.b();
            PostSearchListFragment postSearchListFragment3 = new PostSearchListFragment(3);
            this.g = postSearchListFragment3;
            bVar3.c = postSearchListFragment3;
            bVar3.b = c(R.string.obfuscated_res_0x7f0f10a8);
            bVar3.a = 3;
            this.c.c(bVar3);
        }
    }

    public final FragmentTabIndicator c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02f8, (ViewGroup) null);
            fragmentTabIndicator.setText(i);
            fragmentTabIndicator.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207));
            fragmentTabIndicator.h = R.color.s_actionbar_text_color;
            fragmentTabIndicator.setContentTvTopMargin(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
            fragmentTabIndicator.setWidth((oi.k(this.a.getPageContext().getContext()) - (this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f) * 2)) / 3);
            return fragmentTabIndicator;
        }
        return (FragmentTabIndicator) invokeI.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.getCurrentTabType() : invokeV.intValue;
    }

    public final PostSearchListFragment e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return this.g;
                }
                return this.f;
            }
            return this.e;
        }
        return (PostSearchListFragment) invokeI.objValue;
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            View inflate = ((ViewStub) this.b.findViewById(R.id.obfuscated_res_0x7f091c3a)).inflate();
            inflate.setVisibility(0);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) inflate.findViewById(R.id.obfuscated_res_0x7f0918b0);
            this.c = fragmentTabHost;
            fragmentTabHost.setup(this.a.getSupportFragmentManager());
            this.c.setTabWidgetViewHeight((int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275));
            this.c.setShouldDrawIndicatorLine(true);
            b();
            this.c.n(3);
            this.c.setCurrentTabByType(i);
            this.c.setNeedShowThemeStyle(false);
            this.c.getFragmentTabWidget().setBackGroundDrawableResId(0);
            this.c.s(TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.c.getFragmentTabWidget(), R.color.CAM_X0201);
            this.c.setOnPageChangeListener(this.d);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            FragmentTabHost fragmentTabHost = this.c;
            if (fragmentTabHost != null) {
                fragmentTabHost.s(i);
            }
            FragmentTabHost fragmentTabHost2 = this.c;
            if (fragmentTabHost2 == null || fragmentTabHost2.getFragmentTabWidget() == null) {
                return;
            }
            SkinManager.setBackgroundColor(this.c.getFragmentTabWidget(), R.color.CAM_X0201);
        }
    }

    public void h(int i, o88 o88Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), o88Var, Boolean.valueOf(z)}) == null) {
            j(true);
            PostSearchListFragment e = e(i);
            if (e != null) {
                e.F0(o88Var, z);
            }
        }
    }

    public void i(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onPageChangeListener) == null) {
            this.d = onPageChangeListener;
            FragmentTabHost fragmentTabHost = this.c;
            if (fragmentTabHost != null) {
                fragmentTabHost.setOnPageChangeListener(onPageChangeListener);
            }
        }
    }

    public void j(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (fragmentTabHost = this.c) == null) {
            return;
        }
        if (z) {
            fragmentTabHost.setVisibility(0);
        } else {
            fragmentTabHost.setVisibility(8);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (this.c == null) {
                f(1);
                return;
            }
            a();
            if (this.c.getCurrentTabType() == i) {
                PostSearchListFragment e = e(i);
                if (e != null) {
                    e.G0(true);
                    return;
                }
                return;
            }
            this.c.setCurrentTabByType(i);
        }
    }
}

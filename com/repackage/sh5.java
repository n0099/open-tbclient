package com.repackage;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.SelectForumActivity;
import com.baidu.tieba.SelectForumPagerAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sh5 implements jg5, View.OnClickListener, TbTabLayout.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<SelectForumActivity> a;
    public String b;
    public NavigationBar c;
    public ImageView d;
    public LinearLayout e;
    public TbTabLayout f;
    public BdBaseViewPager g;
    public SelectForumPagerAdapter h;
    public Intent i;
    public boolean j;

    /* loaded from: classes7.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sh5 a;

        public a(sh5 sh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sh5Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.j = i == 0;
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
            }
        }
    }

    public sh5(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.e = linearLayout;
        this.c = navigationBar;
        this.b = "key_select_forum_tab_index";
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.b += currentAccount;
        }
        f();
        d();
        g();
        h();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void a(TbTabLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void c(TbTabLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d004f, (ViewGroup) this.e, true);
            this.f = (TbTabLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090076);
            this.g = (BdBaseViewPager) this.e.findViewById(R.id.obfuscated_res_0x7f090077);
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void e(TbTabLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            TiebaStatic.log(new StatisticItem("c13994").param("obj_type", fVar.e() + 1));
            ys4.k().w(this.b, fVar.e());
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0093));
            ImageView imageView = (ImageView) this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d08b0, (View.OnClickListener) null);
            this.d = imageView;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(0, 0, li.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070234), 0);
            this.d.setLayoutParams(layoutParams);
            this.d.setOnClickListener(this);
            this.d.setVisibility(8);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f.setSelectedTabTextBlod(true);
            this.f.setSelectedTabIndicatorColor(0);
            TbTabLayout.f z = this.f.z();
            z.s(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0092));
            TbTabLayout.f z2 = this.f.z();
            z2.s(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0091));
            this.f.f(z, false);
            this.f.f(z2, false);
        }
    }

    @Override // com.repackage.s85
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (Intent) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SelectForumPagerAdapter selectForumPagerAdapter = new SelectForumPagerAdapter(this.a);
            this.h = selectForumPagerAdapter;
            this.g.setAdapter(selectForumPagerAdapter);
            this.f.setupWithViewPager(this.g);
            i(ys4.k().l(this.b, 0));
            this.f.setOnTabSelectedListener(this);
            this.g.addOnPageChangeListener(new a(this));
        }
    }

    public boolean i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (i < 0 || i > 1) {
                return false;
            }
            TbTabLayout.f w = this.f.w(i);
            if (w != null && !w.h()) {
                w.l();
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.repackage.s85
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.s85
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
        }
    }

    @Override // com.repackage.jg5
    public void onDestroy() {
        SelectForumPagerAdapter selectForumPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (selectForumPagerAdapter = this.h) == null) {
            return;
        }
        selectForumPagerAdapter.c();
    }

    @Override // com.repackage.jg5
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.repackage.s85
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
            this.h.d();
        }
    }
}

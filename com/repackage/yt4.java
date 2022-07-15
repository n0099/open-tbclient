package com.repackage;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public FragmentTabHost b;
    public final ig<ym> c;

    /* loaded from: classes7.dex */
    public class a extends ig<ym> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yt4 a;

        public a(yt4 yt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ig
        public void onLoaded(ym ymVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, ymVar, str, i) == null) {
                super.onLoaded((a) ymVar, str, i);
                if (this.a.b == null || ymVar == null || !ymVar.w()) {
                    this.a.f();
                    return;
                }
                FragmentTabWidget fragmentTabWidget = this.a.b.getFragmentTabWidget();
                CustomViewPager fragmentViewPager = this.a.b.getFragmentViewPager();
                ViewGroup tabWrapper = this.a.b.getTabWrapper();
                if (fragmentTabWidget == null || fragmentViewPager == null) {
                    return;
                }
                this.a.b.setNeedShowThemeStyle(false);
                fragmentTabWidget.setBackGroundDrawableResId(R.color.black_alpha0);
                SkinManager.setBackgroundColor(tabWrapper, R.color.black_alpha0);
                SkinManager.setBackgroundColor(fragmentTabWidget, R.color.black_alpha0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fragmentViewPager.getLayoutParams();
                layoutParams.bottomMargin = pi.f(this.a.b.getContext(), R.dimen.tbds100);
                fragmentViewPager.setLayoutParams(layoutParams);
                fragmentTabWidget.setBackgroundDrawable(new BitmapDrawable(ymVar.p()));
            }
        }
    }

    public yt4(FragmentTabHost fragmentTabHost, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentTabHost, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.c = new a(this);
        this.b = fragmentTabHost;
        this.a = i;
    }

    public final BdUniqueId c() {
        InterceptResult invokeV;
        d9<?> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FragmentTabHost fragmentTabHost = this.b;
            if (fragmentTabHost == null || fragmentTabHost.getContext() == null || (a2 = h9.a(this.b.getContext())) == null) {
                return null;
            }
            return a2.getUniqueId();
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            jg.h().m(str, 10, this.c, c());
        }
    }

    public void e(Pair<String, String> pair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pair) == null) || pair == null) {
            return;
        }
        String str = (String) pair.first;
        String str2 = (String) pair.second;
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(str2)) {
            d(str2);
        } else if (!TextUtils.isEmpty(str)) {
            d(str);
        } else {
            f();
        }
    }

    public final void f() {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fragmentTabHost = this.b) == null || fragmentTabHost.getFragmentTabWidget() == null) {
            return;
        }
        this.b.getFragmentTabWidget().setBackGroundDrawableResId(this.a);
        SkinManager.setBackgroundColor(this.b.getFragmentTabWidget(), this.a);
        SkinManager.setBackgroundColor(this.b.getTabWrapper(), this.a);
    }
}

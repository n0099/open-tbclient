package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.indicator.SlidingTabLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ee7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public View b;
    public TextView c;
    public SlidingTabLayout d;
    public Context e;
    public Animation f;
    public Animation g;
    public boolean h;
    public og i;

    /* loaded from: classes5.dex */
    public class a extends og {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee7 a;

        public a(ee7 ee7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee7Var;
        }

        @Override // com.repackage.og
        public void a(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.c == null) {
                return;
            }
            if (animation == this.a.f) {
                this.a.c.setVisibility(0);
                this.a.c.setClickable(true);
            } else if (animation == this.a.g) {
                this.a.c.setVisibility(8);
                this.a.c.setClickable(false);
            }
        }
    }

    public ee7(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = true;
        this.i = new a(this);
        this.b = view2;
        this.e = context;
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e42);
        this.a = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091e40);
        this.d = (SlidingTabLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e41);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h = true;
            TextView textView = this.c;
            if (textView != null) {
                textView.clearAnimation();
                this.c.startAnimation(f());
            }
            SkinManager.setImageResource(this.a, R.drawable.lego_icon_triangle_down_normal);
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.e, R.anim.obfuscated_res_0x7f010063);
                this.f = loadAnimation;
                loadAnimation.setAnimationListener(this.i);
            }
            return this.f;
        }
        return (Animation) invokeV.objValue;
    }

    public final Animation f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.g == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.e, R.anim.obfuscated_res_0x7f010064);
                this.g = loadAnimation;
                loadAnimation.setAnimationListener(this.i);
            }
            return this.g;
        }
        return (Animation) invokeV.objValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0106, 1);
            if (this.h) {
                SkinManager.setImageResource(this.a, R.drawable.lego_icon_triangle_down_normal);
            } else {
                SkinManager.setImageResource(this.a, R.drawable.lego_icon_triangle_up_normal);
            }
            SkinManager.setBackgroundResource(this.a, R.drawable.lego_btn_more_selector);
            SlidingTabLayout slidingTabLayout = this.d;
            if (slidingTabLayout != null) {
                slidingTabLayout.onChangeSkinType(i);
            }
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (imageView = this.a) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void i(ViewPager viewPager, int i) {
        SlidingTabLayout slidingTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewPager, i) == null) || (slidingTabLayout = this.d) == null) {
            return;
        }
        slidingTabLayout.setViewPager(viewPager, i);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h = false;
            TextView textView = this.c;
            if (textView != null) {
                textView.clearAnimation();
                this.c.setVisibility(0);
                this.c.startAnimation(e());
            }
            SkinManager.setImageResource(this.a, R.drawable.lego_icon_triangle_up_normal);
        }
    }
}

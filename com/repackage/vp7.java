package com.repackage;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes7.dex */
public class vp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public final Context e;
    public int f;
    public FrameLayout g;
    public TBLottieAnimationView h;
    public PopupWindow i;
    public Animator.AnimatorListener j;

    /* loaded from: classes7.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vp7 a;

        public a(vp7 vp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vp7Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.i.dismiss();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ vp7 d;

        public b(vp7 vp7Var, View view2, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vp7Var, view2, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vp7Var;
            this.a = view2;
            this.b = i;
            this.c = i2;
        }

        @Override // com.repackage.f05
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.d.h.setAnimation(i);
                if (!TextUtils.isEmpty(str)) {
                    this.d.h.setImageAssetsFolder(str);
                }
                this.d.g(this.a, this.b, this.c);
            }
        }

        @Override // com.repackage.f05
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.d.h.setAnimationDir(str);
                this.d.g(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ vp7 d;

        public c(vp7 vp7Var, View view2, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vp7Var, view2, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vp7Var;
            this.a = view2;
            this.b = i;
            this.c = i2;
        }

        @Override // com.repackage.f05
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.d.h.setAlpha(0.8f);
                } else {
                    this.d.h.setAlpha(1.0f);
                }
                this.d.h.setAnimation(i);
                this.d.h.setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.d.h.setImageAssetsFolder(str);
                this.d.g(this.a, this.b, this.c);
            }
        }

        @Override // com.repackage.f05
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.d.h.setAlpha(0.8f);
                } else {
                    this.d.h.setAlpha(1.0f);
                }
                this.d.h.setAnimationDir(str);
                this.d.h.setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
                this.d.g(this.a, this.b, this.c);
            }
        }
    }

    public vp7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
        this.b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds484);
        this.f = 0;
        this.e = context;
        e();
        d();
        f();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FrameLayout frameLayout = new FrameLayout(this.e);
            this.g = frameLayout;
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.h = new TBLottieAnimationView(this.e);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.b, this.a);
            this.h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.h.setLayoutParams(layoutParams);
            this.h.addAnimatorListener(this.j);
            this.g.addView(this.h);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j = new a(this);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PopupWindow popupWindow = new PopupWindow();
            this.i = popupWindow;
            popupWindow.setContentView(this.g);
            this.i.setHeight(-2);
            this.i.setWidth(-2);
        }
    }

    public final void g(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048579, this, view2, i, i2) == null) && sg.m(this.i, view2, this.f, i - this.c, i2 - this.d)) {
            this.h.playAnimation();
        }
    }

    public void h(boolean z) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (popupWindow = this.i) == null) {
            return;
        }
        popupWindow.setClippingEnabled(z);
    }

    public void i(ViewGroup.MarginLayoutParams marginLayoutParams) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, marginLayoutParams) == null) || (tBLottieAnimationView = this.h) == null) {
            return;
        }
        tBLottieAnimationView.setLayoutParams(marginLayoutParams);
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a = i;
        }
    }

    public void k(View view2, int i, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            this.c = this.b / 2;
            this.d = this.a / 2;
            g05.g().b(str, str2, new b(this, view2, i, i2));
        }
    }

    public void l(boolean z, View view2, int i, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), view2, Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            this.c = 0;
            this.d = this.a;
            g05.g().e(new Random().nextBoolean() ? "/duang1" : "/duang2", str, str2, z, new c(this, view2, i, i2));
        }
    }
}

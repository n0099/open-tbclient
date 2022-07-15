package com.repackage;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xp6 implements hx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public NoPressedRelativeLayout b;
    public FrsFragment c;
    public TextView d;
    public final Animation e;
    public final Animation f;
    public final Runnable g;
    public int h;
    public int i;
    public int j;

    /* loaded from: classes7.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp6 a;

        public a(xp6 xp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp6Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 111) {
                    this.a.j();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp6 a;

        public b(xp6 xp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp6Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.d.getParent() == null) {
                return;
            }
            ((ViewGroup) this.a.d.getParent()).removeView(this.a.d);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp6 a;

        public c(xp6 xp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp6 a;

        public d(xp6 xp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e();
                if (this.a.c == null || this.a.c.x3() || this.a.c.l1() == null) {
                    return;
                }
                this.a.c.l1().T1();
            }
        }
    }

    public xp6(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, noPressedRelativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.b = noPressedRelativeLayout;
        this.c = frsFragment;
        this.a = new Handler(new a(this));
        this.e = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.obfuscated_res_0x7f010063);
        Animation loadAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.obfuscated_res_0x7f010064);
        this.f = loadAnimation;
        loadAnimation.setAnimationListener(new b(this));
        this.g = new c(this);
        f();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.d.getParent() == null) {
            return;
        }
        this.h = -1;
        this.j = -1;
        this.a.removeCallbacks(this.g);
        this.d.clearAnimation();
        this.d.startAnimation(this.f);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TextView textView = new TextView(TbadkCoreApplication.getInst());
            this.d = textView;
            textView.setOnClickListener(new d(this));
            this.d.setGravity(17);
            this.d.setText(R.string.obfuscated_res_0x7f0f06ed);
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
            int dimensionPixelSize2 = this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070225);
            this.d.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            this.d.setTextSize(0, this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
            SkinManager.setBackgroundResource(this.d, R.drawable.bg_home_float);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0302);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.topMargin = this.c.N0().getBottom() + pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070304);
            this.d.setLayoutParams(layoutParams);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.removeCallbacksAndMessages(null);
        }
    }

    public void h(RecyclerView recyclerView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, recyclerView, i, i2) == null) {
            this.h = i;
            this.i = i2;
            if (this.j < 0) {
                this.j = i;
            }
        }
    }

    public void i(RecyclerView recyclerView, int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, recyclerView, i) == null) && i == 0) {
            int i4 = this.h;
            if (i4 > 0 && (i2 = this.i) > 0 && (i3 = this.j) >= 0 && i4 + i2 + 1 < i3) {
                this.a.sendEmptyMessage(111);
            }
            this.j = this.h;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.d.getParent() == null) {
            this.b.addView(this.d);
            this.d.clearAnimation();
            this.d.startAnimation(this.e);
            this.a.removeCallbacks(this.g);
            this.a.postDelayed(this.g, 4000L);
        }
    }

    @Override // com.repackage.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(this.d, R.drawable.bg_home_float);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0302);
        }
    }
}

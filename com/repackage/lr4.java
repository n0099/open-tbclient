package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nr4;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class lr4 extends Dialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static int j = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public d9 b;
    public View c;
    public LinearLayout d;
    public float e;
    public boolean f;
    public nr4 g;
    public boolean h;
    public CustomMessageListener i;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lr4 lr4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lr4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && this.a.g != null) {
                this.a.g.i();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr4 a;

        public b(lr4 lr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr4 a;

        public c(lr4 lr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lr4Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.setCancelable(true);
            }
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
                this.a.setCancelable(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr4 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.b == null || this.a.a.b.getPageActivity() == null) {
                    return;
                }
                Activity pageActivity = this.a.a.b.getPageActivity();
                if (pageActivity.isFinishing() || pageActivity.getWindow() == null) {
                    return;
                }
                lr4.super.dismiss();
            }
        }

        public d(lr4 lr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lr4Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.f = false;
                this.a.d.post(new a(this));
            }
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
                this.a.f = true;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755519485, "Lcom/repackage/lr4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755519485, "Lcom/repackage/lr4;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lr4(d9 d9Var, nr4 nr4Var) {
        super(d9Var.getPageActivity(), R.style.obfuscated_res_0x7f100106);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var, nr4Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = 0.33f;
        this.f = false;
        this.h = true;
        this.i = new a(this, 2001304);
        this.b = d9Var;
        this.a = d9Var.getPageActivity();
        this.g = nr4Var;
        this.c = nr4Var.c();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.d == null || this.f || !isShowing()) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f0100ee);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new d(this));
        this.d.startAnimation(loadAnimation);
        MessageManager.getInstance().unRegisterListener(this.i);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public nr4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (nr4) invokeV.objValue;
    }

    public LinearLayout h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (LinearLayout) invokeV.objValue;
    }

    public void i(nr4 nr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nr4Var) == null) {
            this.g = nr4Var;
            this.c = nr4Var.c();
        }
    }

    public void j(String str, String[] strArr, nr4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, strArr, eVar) == null) {
            this.g = new nr4(this.a);
            if (!StringUtils.isNull(str)) {
                this.g.q(str);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                arrayList.add(new jr4(i, strArr[i], this.g));
            }
            this.g.j(arrayList);
            this.g.n(eVar);
            setCanceledOnTouchOutside(true);
            this.c = this.g.c();
        }
    }

    public void k(SpannableStringBuilder spannableStringBuilder) {
        nr4 nr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, spannableStringBuilder) == null) || (nr4Var = this.g) == null) {
            return;
        }
        nr4Var.o(spannableStringBuilder);
        this.g.p();
    }

    public void l(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.e = f;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f = false;
            if (isShowing()) {
                super.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(sg.j(this, this.b))));
            if (this.d != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010040);
                loadAnimation.setFillAfter(true);
                loadAnimation.setAnimationListener(new c(this));
                this.d.startAnimation(loadAnimation);
            }
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (isShowing()) {
                cancel();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(R.layout.obfuscated_res_0x7f0d06f4);
            Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth();
            attributes.height = defaultDisplay.getHeight();
            if (this.h) {
                attributes.y = pi.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                getWindow().addFlags(512);
            }
            getWindow().setAttributes(attributes);
            getWindow().setBackgroundDrawableResource(R.color.transparent);
            getWindow().setDimAmount(this.e);
            getWindow().setGravity(80);
            getWindow().setWindowAnimations(0);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091b72);
            this.d = linearLayout;
            linearLayout.setOnClickListener(new b(this));
            View view2 = this.c;
            if (view2 == null) {
                return;
            }
            this.d.removeView(view2);
            if (this.h) {
                View view3 = this.c;
                if ((view3 instanceof ViewGroup) && ((ViewGroup) view3).getChildAt(((ViewGroup) view3).getChildCount() - 1).getId() != j) {
                    View view4 = new View(getContext());
                    view4.setId(j);
                    view4.setLayoutParams(new ViewGroup.LayoutParams(-1, pi.f(getContext(), R.dimen.bottom_enter_anim_place_holder_height)));
                    SkinManager.setBackgroundResource(view4, R.color.CAM_X0204);
                    ((ViewGroup) this.c).addView(view4);
                }
            }
            if (this.c.getParent() != null) {
                if (this.c.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.c.getParent()).removeView(this.c);
                    this.d.addView(this.c);
                    return;
                }
                return;
            }
            this.d.addView(this.c);
        }
    }

    @Override // android.app.Dialog
    public void setContentView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            this.c = view2;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.show();
            this.b.registerListener(this.i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lr4(d9 d9Var) {
        super(d9Var.getPageActivity(), R.style.obfuscated_res_0x7f100106);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = 0.33f;
        this.f = false;
        this.h = true;
        this.i = new a(this, 2001304);
        this.a = d9Var.getPageActivity();
        this.b = d9Var;
    }
}

package d.a.r0.r.s;

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
import d.a.r0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class j extends Dialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static int n = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f56191e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.a.f f56192f;

    /* renamed from: g  reason: collision with root package name */
    public View f56193g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f56194h;

    /* renamed from: i  reason: collision with root package name */
    public float f56195i;
    public boolean j;
    public l k;
    public boolean l;
    public CustomMessageListener m;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f56196a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56196a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && this.f56196a.k != null) {
                this.f56196a.k.j();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f56197e;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56197e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56197e.cancel();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f56198a;

        public c(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56198a = jVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f56198a.setCancelable(true);
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
                this.f56198a.setCancelable(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f56199a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f56200e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56200e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56200e.f56199a.f56192f == null || this.f56200e.f56199a.f56192f.getPageActivity() == null) {
                    return;
                }
                Activity pageActivity = this.f56200e.f56199a.f56192f.getPageActivity();
                if (pageActivity.isFinishing() || pageActivity.getWindow() == null) {
                    return;
                }
                j.super.dismiss();
            }
        }

        public d(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56199a = jVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f56199a.j = false;
                this.f56199a.f56194h.post(new a(this));
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
                this.f56199a.j = true;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-485374282, "Ld/a/r0/r/s/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-485374282, "Ld/a/r0/r/s/j;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d.a.c.a.f fVar, l lVar) {
        super(fVar.getPageActivity(), 16973835);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, lVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f56195i = 0.33f;
        this.j = false;
        this.l = true;
        this.m = new a(this, 2001304);
        this.f56192f = fVar;
        this.f56191e = fVar.getPageActivity();
        this.k = lVar;
        this.f56193g = lVar.c();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56194h == null || this.j || !isShowing()) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f56191e, R.anim.pop_exit_anim);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new d(this));
        this.f56194h.startAnimation(loadAnimation);
        MessageManager.getInstance().unRegisterListener(this.m);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56193g : (View) invokeV.objValue;
    }

    public LinearLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56194h : (LinearLayout) invokeV.objValue;
    }

    public void h(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lVar) == null) {
            this.k = lVar;
            this.f56193g = lVar.c();
        }
    }

    public void i(String str, String[] strArr, l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, strArr, eVar) == null) {
            this.k = new l(this.f56191e);
            if (!StringUtils.isNull(str)) {
                this.k.q(str);
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                arrayList.add(new h(i2, strArr[i2], this.k));
            }
            this.k.k(arrayList);
            this.k.n(eVar);
            setCanceledOnTouchOutside(true);
            this.f56193g = this.k.c();
        }
    }

    public void j(SpannableStringBuilder spannableStringBuilder) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, spannableStringBuilder) == null) || (lVar = this.k) == null) {
            return;
        }
        lVar.o(spannableStringBuilder);
        this.k.p();
    }

    public void k(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.f56195i = f2;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j = false;
            if (isShowing()) {
                super.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(d.a.c.e.m.g.j(this, this.f56192f))));
            if (this.f56194h != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f56191e, R.anim.bomb_pop_enter_anim);
                loadAnimation.setFillAfter(true);
                loadAnimation.setAnimationListener(new c(this));
                this.f56194h.startAnimation(loadAnimation);
            }
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(R.layout.popup_dialog);
            Display defaultDisplay = ((WindowManager) this.f56191e.getSystemService("window")).getDefaultDisplay();
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth();
            attributes.height = defaultDisplay.getHeight();
            if (this.l) {
                attributes.y = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                getWindow().addFlags(512);
            }
            getWindow().setAttributes(attributes);
            getWindow().setBackgroundDrawableResource(R.color.transparent);
            getWindow().setDimAmount(this.f56195i);
            getWindow().setGravity(80);
            getWindow().setWindowAnimations(0);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
            this.f56194h = linearLayout;
            linearLayout.setOnClickListener(new b(this));
            View view = this.f56193g;
            if (view == null) {
                return;
            }
            this.f56194h.removeView(view);
            if (this.l) {
                View view2 = this.f56193g;
                if ((view2 instanceof ViewGroup) && ((ViewGroup) view2).getChildAt(((ViewGroup) view2).getChildCount() - 1).getId() != n) {
                    View view3 = new View(getContext());
                    view3.setId(n);
                    view3.setLayoutParams(new ViewGroup.LayoutParams(-1, d.a.c.e.p.l.g(getContext(), R.dimen.bottom_enter_anim_place_holder_height)));
                    SkinManager.setBackgroundResource(view3, R.color.CAM_X0204);
                    ((ViewGroup) this.f56193g).addView(view3);
                }
            }
            if (this.f56193g.getParent() != null) {
                if (this.f56193g.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f56193g.getParent()).removeView(this.f56193g);
                    this.f56194h.addView(this.f56193g);
                    return;
                }
                return;
            }
            this.f56194h.addView(this.f56193g);
        }
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            this.f56193g = view;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.show();
            this.f56192f.registerListener(this.m);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d.a.c.a.f fVar) {
        super(fVar.getPageActivity(), 16973835);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f56195i = 0.33f;
        this.j = false;
        this.l = true;
        this.m = new a(this, 2001304);
        this.f56191e = fVar.getPageActivity();
        this.f56192f = fVar;
    }
}

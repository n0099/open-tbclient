package com.repackage;

import android.app.Activity;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.guide.Configuration;
import com.baidu.adp.lib.guide.MaskView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.df;
/* loaded from: classes5.dex */
public class cf implements View.OnKeyListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Configuration a;
    public MaskView b;
    public bf[] c;
    public boolean d;
    public boolean e;
    public df.a f;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf a;

        public a(cf cfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cfVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.f == null) {
                return;
            }
            this.a.f.onShown();
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

    /* loaded from: classes5.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ cf b;

        public b(cf cfVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cfVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cfVar;
            this.a = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.removeAllViews();
                if (this.b.f != null) {
                    this.b.f.onDismiss();
                }
                this.b.g();
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
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf a;

        public c(cf cfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cfVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.f == null) {
                return;
            }
            this.a.f.onShown();
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

    /* loaded from: classes5.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ cf b;

        public d(cf cfVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cfVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cfVar;
            this.a = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.removeView(this.b.b);
                if (this.b.f != null) {
                    this.b.f.onDismiss();
                }
                this.b.g();
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
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964043262, "Lcom/repackage/cf;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964043262, "Lcom/repackage/cf;");
            }
        }
    }

    public cf() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = true;
        this.e = false;
    }

    public void d() {
        MaskView maskView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (maskView = this.b) != null && (maskView.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.b.getParent();
            if (this.a.mExitAnimationId != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.b.getContext(), this.a.mExitAnimationId);
                loadAnimation.setAnimationListener(new d(this, viewGroup));
                this.b.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.b);
            df.a aVar = this.f;
            if (aVar != null) {
                aVar.onDismiss();
            }
            g();
        }
    }

    public void e(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        if (this.a.mExitAnimationId != -1) {
            Animation loadAnimation = AnimationUtils.loadAnimation(viewGroup.getContext(), this.a.mExitAnimationId);
            loadAnimation.setAnimationListener(new b(this, viewGroup));
            viewGroup.startAnimation(loadAnimation);
            return;
        }
        viewGroup.removeAllViews();
        df.a aVar = this.f;
        if (aVar != null) {
            aVar.onDismiss();
        }
        g();
    }

    public final MaskView f(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            MaskView maskView = new MaskView(activity);
            maskView.e(activity.getResources().getColor(this.a.mFullingColorId));
            maskView.d(this.a.mAlpha);
            maskView.g(this.a.mOverlayTarget);
            maskView.setOnKeyListener(this);
            int[] iArr = new int[2];
            ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
            int i = iArr[1];
            if (this.d && i == 0) {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    i = activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField(SapiSystemBarTintManager.SystemBarConfig.g).get(cls.newInstance()).toString()));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                } catch (InstantiationException e4) {
                    e4.printStackTrace();
                } catch (NoSuchFieldException e5) {
                    e5.printStackTrace();
                } catch (NumberFormatException e6) {
                    e6.printStackTrace();
                } catch (SecurityException e7) {
                    e7.printStackTrace();
                }
            }
            Configuration configuration = this.a;
            View view2 = configuration.mTargetView;
            if (view2 != null) {
                maskView.h(af.b(view2, 0, i));
            } else {
                View findViewById = activity.findViewById(configuration.mTargetViewId);
                if (findViewById != null) {
                    maskView.h(af.b(findViewById, 0, i));
                }
            }
            View findViewById2 = activity.findViewById(this.a.mFullingViewId);
            if (findViewById2 != null) {
                maskView.f(af.b(findViewById2, 0, i));
            }
            if (this.a.mOutsideTouchable) {
                maskView.setClickable(false);
            } else {
                maskView.setOnClickListener(this);
            }
            for (bf bfVar : this.c) {
                maskView.addView(af.a(activity.getLayoutInflater(), bfVar));
            }
            return maskView;
        }
        return (MaskView) invokeL.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a = null;
            this.c = null;
            this.f = null;
        }
    }

    public void i(df.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f = aVar;
        }
    }

    public void j(bf[] bfVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bfVarArr) == null) {
            this.c = bfVarArr;
        }
    }

    public void k(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            this.a = configuration;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.d = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.e = z;
        }
    }

    public void n(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, activity) == null) {
            o(activity, true);
        }
    }

    public void o(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, activity, z) == null) {
            q((ViewGroup) activity.findViewById(16908290), activity, z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Configuration configuration;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view2) == null) && (configuration = this.a) != null && configuration.mAutoDismiss) {
            d();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view2, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Configuration configuration;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048588, this, view2, i, keyEvent)) == null) {
            if (i == 4 && keyEvent.getAction() == 1 && (configuration = this.a) != null && configuration.mAutoDismiss) {
                d();
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public final void q(ViewGroup viewGroup, Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, viewGroup, activity, z) == null) {
            if (this.b == null) {
                MaskView f = f(activity);
                this.b = f;
                f.i(this.e);
                if (!z) {
                    this.b.setFocusable(false);
                    this.b.setFocusableInTouchMode(false);
                    this.b.clearFocus();
                }
            }
            if (this.b.getParent() == null) {
                viewGroup.addView(this.b);
                int i = this.a.mEnterAnimationId;
                if (i != -1) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(activity, i);
                    loadAnimation.setAnimationListener(new c(this));
                    this.b.startAnimation(loadAnimation);
                    return;
                }
                df.a aVar = this.f;
                if (aVar != null) {
                    aVar.onShown();
                }
            }
        }
    }

    public void r(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, activity) == null) {
            q((ViewGroup) activity.getWindow().getDecorView(), activity, true);
        }
    }

    public void s(Activity activity, ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048591, this, activity, viewGroup, z) == null) || viewGroup == null) {
            return;
        }
        if (!z) {
            viewGroup.setFocusable(false);
            viewGroup.setFocusableInTouchMode(false);
            viewGroup.clearFocus();
        }
        for (bf bfVar : this.c) {
            View c2 = bfVar.c(activity.getLayoutInflater());
            if (c2.getParent() == null) {
                viewGroup.addView(c2);
            }
        }
        int i = this.a.mEnterAnimationId;
        if (i == -1) {
            df.a aVar = this.f;
            if (aVar != null) {
                aVar.onShown();
                return;
            }
            return;
        }
        Animation animation = null;
        try {
            animation = AnimationUtils.loadAnimation(activity, i);
        } catch (Resources.NotFoundException unused) {
        }
        if (animation == null) {
            df.a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.onShown();
                return;
            }
            return;
        }
        animation.setAnimationListener(new a(this));
        viewGroup.startAnimation(animation);
    }
}

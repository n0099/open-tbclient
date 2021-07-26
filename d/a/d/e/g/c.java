package d.a.d.e.g;

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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.g.d;
/* loaded from: classes7.dex */
public class c implements View.OnKeyListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Configuration f41661e;

    /* renamed from: f  reason: collision with root package name */
    public MaskView f41662f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.d.e.g.b[] f41663g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41664h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f41665i;
    public d.a j;

    /* loaded from: classes7.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f41666a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41666a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f41666a.j == null) {
                return;
            }
            this.f41666a.j.onShown();
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
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f41667a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f41668b;

        public b(c cVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41668b = cVar;
            this.f41667a = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f41667a.removeAllViews();
                if (this.f41668b.j != null) {
                    this.f41668b.j.onDismiss();
                }
                this.f41668b.g();
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

    /* renamed from: d.a.d.e.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class animation.Animation$AnimationListenerC0557c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f41669a;

        public animation.Animation$AnimationListenerC0557c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41669a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f41669a.j == null) {
                return;
            }
            this.f41669a.j.onShown();
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
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f41670a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f41671b;

        public d(c cVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41671b = cVar;
            this.f41670a = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f41670a.removeView(this.f41671b.f41662f);
                if (this.f41671b.j != null) {
                    this.f41671b.j.onDismiss();
                }
                this.f41671b.g();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-402303718, "Ld/a/d/e/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-402303718, "Ld/a/d/e/g/c;");
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41664h = true;
        this.f41665i = false;
    }

    public void d() {
        MaskView maskView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (maskView = this.f41662f) != null && (maskView.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.f41662f.getParent();
            if (this.f41661e.mExitAnimationId != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f41662f.getContext(), this.f41661e.mExitAnimationId);
                loadAnimation.setAnimationListener(new d(this, viewGroup));
                this.f41662f.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.f41662f);
            d.a aVar = this.j;
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
        if (this.f41661e.mExitAnimationId != -1) {
            Animation loadAnimation = AnimationUtils.loadAnimation(viewGroup.getContext(), this.f41661e.mExitAnimationId);
            loadAnimation.setAnimationListener(new b(this, viewGroup));
            viewGroup.startAnimation(loadAnimation);
            return;
        }
        viewGroup.removeAllViews();
        d.a aVar = this.j;
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
            maskView.e(activity.getResources().getColor(this.f41661e.mFullingColorId));
            maskView.d(this.f41661e.mAlpha);
            maskView.g(this.f41661e.mOverlayTarget);
            maskView.setOnKeyListener(this);
            int[] iArr = new int[2];
            ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
            int i2 = iArr[1];
            if (this.f41664h && i2 == 0) {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    i2 = activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                } catch (InstantiationException e5) {
                    e5.printStackTrace();
                } catch (NoSuchFieldException e6) {
                    e6.printStackTrace();
                } catch (NumberFormatException e7) {
                    e7.printStackTrace();
                } catch (SecurityException e8) {
                    e8.printStackTrace();
                }
            }
            Configuration configuration = this.f41661e;
            View view = configuration.mTargetView;
            if (view != null) {
                maskView.h(d.a.d.e.g.a.b(view, 0, i2));
            } else {
                View findViewById = activity.findViewById(configuration.mTargetViewId);
                if (findViewById != null) {
                    maskView.h(d.a.d.e.g.a.b(findViewById, 0, i2));
                }
            }
            View findViewById2 = activity.findViewById(this.f41661e.mFullingViewId);
            if (findViewById2 != null) {
                maskView.f(d.a.d.e.g.a.b(findViewById2, 0, i2));
            }
            if (this.f41661e.mOutsideTouchable) {
                maskView.setClickable(false);
            } else {
                maskView.setOnClickListener(this);
            }
            for (d.a.d.e.g.b bVar : this.f41663g) {
                maskView.addView(d.a.d.e.g.a.a(activity.getLayoutInflater(), bVar));
            }
            return maskView;
        }
        return (MaskView) invokeL.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f41661e = null;
            this.f41663g = null;
            this.j = null;
        }
    }

    public void h(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.j = aVar;
        }
    }

    public void i(d.a.d.e.g.b[] bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVarArr) == null) {
            this.f41663g = bVarArr;
        }
    }

    public void j(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            this.f41661e = configuration;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f41664h = z;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f41665i = z;
        }
    }

    public void m(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, activity) == null) {
            n(activity, true);
        }
    }

    public void n(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, activity, z) == null) {
            o((ViewGroup) activity.findViewById(16908290), activity, z);
        }
    }

    public final void o(ViewGroup viewGroup, Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048587, this, viewGroup, activity, z) == null) {
            if (this.f41662f == null) {
                MaskView f2 = f(activity);
                this.f41662f = f2;
                f2.i(this.f41665i);
                if (!z) {
                    this.f41662f.setFocusable(false);
                    this.f41662f.setFocusableInTouchMode(false);
                    this.f41662f.clearFocus();
                }
            }
            if (this.f41662f.getParent() == null) {
                viewGroup.addView(this.f41662f);
                int i2 = this.f41661e.mEnterAnimationId;
                if (i2 != -1) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(activity, i2);
                    loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC0557c(this));
                    this.f41662f.startAnimation(loadAnimation);
                    return;
                }
                d.a aVar = this.j;
                if (aVar != null) {
                    aVar.onShown();
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Configuration configuration;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view) == null) && (configuration = this.f41661e) != null && configuration.mAutoDismiss) {
            d();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Configuration configuration;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048589, this, view, i2, keyEvent)) == null) {
            if (i2 == 4 && keyEvent.getAction() == 1 && (configuration = this.f41661e) != null && configuration.mAutoDismiss) {
                d();
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public void p(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, activity) == null) {
            o((ViewGroup) activity.getWindow().getDecorView(), activity, true);
        }
    }

    public void q(Activity activity, ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048591, this, activity, viewGroup, z) == null) || viewGroup == null) {
            return;
        }
        if (!z) {
            viewGroup.setFocusable(false);
            viewGroup.setFocusableInTouchMode(false);
            viewGroup.clearFocus();
        }
        for (d.a.d.e.g.b bVar : this.f41663g) {
            View c2 = bVar.c(activity.getLayoutInflater());
            if (c2.getParent() == null) {
                viewGroup.addView(c2);
            }
        }
        int i2 = this.f41661e.mEnterAnimationId;
        if (i2 == -1) {
            d.a aVar = this.j;
            if (aVar != null) {
                aVar.onShown();
                return;
            }
            return;
        }
        Animation animation = null;
        try {
            animation = AnimationUtils.loadAnimation(activity, i2);
        } catch (Resources.NotFoundException unused) {
        }
        if (animation == null) {
            d.a aVar2 = this.j;
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

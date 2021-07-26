package d.a.q0.h2.p;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f58478a;

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f58479b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58480c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f58481d;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f58482e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58482e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58482e.f58480c = true;
                int b2 = d.a.p0.t.g.f.b();
                if (b2 > 0) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f58482e.f58478a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    if (this.f58482e.f58479b != null) {
                        this.f58482e.f58479b.start();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Interpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (float) ((Math.sin((f2 * 18.84955592153876d) - 1.5707963267948966d) * 0.075d) + 1.075d) : invokeF.floatValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f58483e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58483e = hVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f58483e.f58478a == null) {
                return;
            }
            this.f58483e.f58478a.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f58483e.f58478a.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public h(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58480c = false;
        this.f58481d = new a(this);
        this.f58478a = imageView;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f58479b = valueAnimator;
        valueAnimator.setDuration(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        this.f58479b.setFloatValues(0.0f, 1.0f);
        this.f58479b.setInterpolator(new b(this));
        this.f58479b.addUpdateListener(new c(this));
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().c()) {
            d.a.d.e.m.e.a().removeCallbacks(this.f58481d);
            long a2 = TbSingleton.getInstance().getSharePanelConfData().a() * 1000;
            if (a2 <= 0) {
                a2 = 3000;
            }
            d.a.d.e.m.e.a().postDelayed(this.f58481d, a2);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58480c : invokeV.booleanValue;
    }

    public void f() {
        int b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f58480c && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().c() && (b2 = d.a.p0.t.g.f.b()) > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f58478a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.d.e.m.e.a().removeCallbacks(this.f58481d);
            ValueAnimator valueAnimator = this.f58479b;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.f58479b.removeAllUpdateListeners();
                this.f58479b.cancel();
            }
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f58480c = z;
        }
    }
}

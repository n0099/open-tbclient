package d.a.p0.x3.d;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f66264h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f66265i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final TBLottieAnimationView f66266e;

    /* renamed from: f  reason: collision with root package name */
    public final VerticalViewPager f66267f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66268g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-685378417, "Ld/a/p0/x3/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-685378417, "Ld/a/p0/x3/d/a;");
                return;
            }
        }
        f66264h = d.a.o0.r.d0.b.j().g("key_video_guide_up_slide_animated", false);
        f66265i = d.a.o0.r.d0.b.j().g("key_video_guide_left_slide_animated", false);
    }

    public a(TBLottieAnimationView tBLottieAnimationView, VerticalViewPager verticalViewPager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tBLottieAnimationView, verticalViewPager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66268g = false;
        this.f66266e = tBLottieAnimationView;
        this.f66267f = verticalViewPager;
        e();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f66265i = true;
        }
    }

    public void b() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tBLottieAnimationView = this.f66266e) == null || this.f66267f == null || this.f66268g || !f66264h || f66265i || tBLottieAnimationView.isAnimating()) {
            return;
        }
        this.f66266e.setImageAssetsFolder("lottie_video_guide_left");
        i(R.raw.lottie_video_guide_left);
        f66265i = true;
        this.f66268g = true;
        d.a.o0.r.d0.b.j().t("key_video_guide_left_slide_animated", true);
    }

    public void c() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tBLottieAnimationView = this.f66266e) == null || this.f66267f == null || this.f66268g || f66264h || tBLottieAnimationView.isAnimating()) {
            return;
        }
        this.f66266e.setImageAssetsFolder("lottie_video_guide_up");
        i(R.raw.lottie_video_guide_up);
        f66264h = true;
        this.f66268g = true;
        d.a.o0.r.d0.b.j().t("key_video_guide_up_slide_animated", true);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f66266e.isAnimating()) {
                this.f66266e.pauseAnimation();
            }
            this.f66266e.setVisibility(8);
        }
    }

    public final void e() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tBLottieAnimationView = this.f66266e) == null || this.f66267f == null) {
            return;
        }
        tBLottieAnimationView.setOnClickListener(this);
        this.f66266e.addAnimatorUpdateListener(this);
        this.f66266e.addAnimatorListener(this);
        this.f66266e.setRepeatCount(2);
        this.f66266e.setRepeatMode(1);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f66268g = false;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f66266e == null || this.f66267f == null) {
            return;
        }
        d();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f66266e.setVisibility(0);
            this.f66266e.playAnimation();
        }
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f66266e.setAnimation(i2);
            h();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, animator) == null) || this.f66266e == null || this.f66267f == null) {
            return;
        }
        d();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, animator) == null) {
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, valueAnimator) == null) || (tBLottieAnimationView = this.f66266e) == null || this.f66267f == null || !tBLottieAnimationView.isAnimating() || f66265i || !f66264h) {
            return;
        }
        valueAnimator.getAnimatedFraction();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            d();
        }
    }
}

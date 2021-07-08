package d.a.o0.d0;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class g extends d.a.o0.d0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ContinuousAnimationView f51900a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f51901b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f51902c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f51903d;

    /* renamed from: e  reason: collision with root package name */
    public int f51904e;

    /* renamed from: f  reason: collision with root package name */
    public final int f51905f;

    /* renamed from: g  reason: collision with root package name */
    public int f51906g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f51907h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f51908i;
    public ValueAnimator.AnimatorUpdateListener j;
    public final Animator.AnimatorListener k;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f51909e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51909e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f51909e.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(this.f51909e.f51907h);
                    return;
                }
                this.f51909e.f51902c.setText(this.f51909e.f51901b[this.f51909e.k()]);
                TbadkCoreApplication.getInst().handler.postDelayed(this.f51909e.f51907h, 200L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f51910e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51910e = gVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f51910e.f51908i) {
                return;
            }
            this.f51910e.f51900a.setAlpha(Math.min(1.0f, (valueAnimator.getAnimatedFraction() * 24.0f) / 6.0f));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f51911e;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51911e = gVar;
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
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                this.f51911e.f51908i = true;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f51911e.f51908i = false;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Context context) {
        this(context, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.d0.a
    public void dettachView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            ContinuousAnimationView continuousAnimationView = this.f51900a;
            if (continuousAnimationView != null) {
                continuousAnimationView.cancelAnimation();
            }
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.f51907h);
            super.dettachView(view);
        }
    }

    public void h() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (continuousAnimationView = this.f51900a) == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) continuousAnimationView.getLayoutParams()).addRule(15, 0);
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.attachedView : (View) invokeV.objValue;
    }

    public TextView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51903d : (TextView) invokeV.objValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f51904e + 1;
            this.f51904e = i2;
            if (i2 >= this.f51905f) {
                this.f51904e = 0;
            }
            return this.f51904e;
        }
        return invokeV.intValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setViewTextColor(this.f51902c, R.color.CAM_X0108, 1, i2);
            SkinManager.setViewTextColor(this.f51903d, R.color.CAM_X0108, 1, i2);
            SkinManager.setLottieAnimation(this.f51900a, R.raw.lottie_full_screen_refresh);
            if (isViewAttached()) {
                r();
            }
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.f51907h);
            TbadkCoreApplication.getInst().handler.postDelayed(this.f51907h, 200L);
            this.f51906g = i2;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            s();
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.f51907h);
        }
    }

    public void n(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (view = this.attachedView) == null) {
            return;
        }
        view.setBackgroundColor(i2);
    }

    public void o(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f51900a == null || (textView = this.f51903d) == null) {
            return;
        }
        if (textView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = this.f51900a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i2;
                this.f51900a.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.f51903d.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.bottomMargin = i2;
            this.f51903d.setLayoutParams(marginLayoutParams2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f51906g == -1) {
                this.f51906g = TbadkCoreApplication.getInst().getSkinType();
            }
            if (isViewAttached()) {
                SkinManager.setViewTextColor(this.f51902c, R.color.CAM_X0108, 1, this.f51906g);
                SkinManager.setViewTextColor(this.f51903d, R.color.CAM_X0108, 1, this.f51906g);
                r();
            }
        }
    }

    @Override // d.a.o0.d0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f51906g == -1) {
                this.f51906g = TbadkCoreApplication.getInst().getSkinType();
            }
            SkinManager.setLottieAnimation(this.f51900a, R.raw.lottie_full_screen_refresh);
            r();
            SkinManager.setViewTextColor(this.f51902c, R.color.CAM_X0108, 1, this.f51906g);
            SkinManager.setViewTextColor(this.f51903d, R.color.CAM_X0108, 1, this.f51906g);
            this.f51902c.setText(this.f51901b[0]);
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.f51907h);
            TbadkCoreApplication.getInst().handler.postDelayed(this.f51907h, 200L);
            this.attachedView.setClickable(true);
        }
    }

    @Override // d.a.o0.d0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            m();
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f51906g = i2;
        }
    }

    public void q(int i2) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (continuousAnimationView = this.f51900a) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2;
            this.f51900a.setLayoutParams(marginLayoutParams);
        }
    }

    public final void r() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (continuousAnimationView = this.f51900a) == null) {
            return;
        }
        continuousAnimationView.playAnimation();
    }

    public final void s() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (continuousAnimationView = this.f51900a) == null) {
            return;
        }
        continuousAnimationView.pauseAnimation();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, int i2) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51904e = 0;
        this.f51906g = -1;
        this.f51907h = new a(this);
        this.j = new b(this);
        this.k = new c(this);
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        this.f51900a = continuousAnimationView;
        if (i2 > 0) {
            ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i2;
                this.f51900a.setLayoutParams(marginLayoutParams);
            }
        }
        SkinManager.setLottieAnimation(this.f51900a, R.raw.lottie_full_screen_refresh);
        this.f51900a.setMinAndMaxProgress(0.0f, 1.0f);
        this.f51900a.setRepeatMode(1);
        this.f51900a.addAnimatorUpdateListener(this.j);
        this.f51900a.addAnimatorListener(this.k);
        this.f51900a.setSpeed(1.2f);
        this.f51902c = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.f51903d = (TextView) this.attachedView.findViewById(R.id.loading_text);
        String[] stringArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.f51901b = stringArray;
        this.f51905f = stringArray.length;
    }
}

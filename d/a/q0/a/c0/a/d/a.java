package d.a.q0.a.c0.a.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c0.a.d.b;
import d.a.q0.a.e0.d;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class a<V extends View, M extends b> extends d.a.q0.a.c0.b.a<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.c0.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0689a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppComponentContainerView f46763e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f46764f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f46765g;

        public C0689a(a aVar, SwanAppComponentContainerView swanAppComponentContainerView, boolean z, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppComponentContainerView, Boolean.valueOf(z), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46763e = swanAppComponentContainerView;
            this.f46764f = z;
            this.f46765g = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.f46763e.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (this.f46764f) {
                        marginLayoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    } else {
                        marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    }
                    this.f46765g.l.o(marginLayoutParams.leftMargin);
                    this.f46765g.l.p(marginLayoutParams.topMargin);
                    this.f46763e.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (d.a.q0.a.c0.b.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public final ValueAnimator H(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull b bVar, @NonNull b bVar2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppComponentContainerView, bVar, bVar2)) == null) {
            if (bVar2.n != null) {
                float b2 = w.b(bVar.n, "opacity", 1.0f);
                float b3 = w.b(bVar2.n, "opacity", b2);
                if (b2 != b3) {
                    return ObjectAnimator.ofFloat(swanAppComponentContainerView, "alpha", b2, b3);
                }
            }
            return null;
        }
        return (ValueAnimator) invokeLLL.objValue;
    }

    public final AnimatorSet I(long j, @NonNull Interpolator interpolator, List<Animator> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), interpolator, list})) == null) {
            if (j <= 0 || list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Animator animator : list) {
                if (animator != null) {
                    arrayList.add(animator);
                }
            }
            if (arrayList.size() == 0) {
                return null;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(interpolator);
            animatorSet.setDuration(j);
            animatorSet.playTogether(arrayList);
            return animatorSet;
        }
        return (AnimatorSet) invokeCommon.objValue;
    }

    @Nullable
    public final ValueAnimator J(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull b bVar, @NonNull b bVar2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{swanAppComponentContainerView, bVar, bVar2, Boolean.valueOf(z)})) == null) {
            d.a.q0.a.l1.e.a.a aVar = bVar.l;
            if (aVar == null || bVar2.l == null) {
                return null;
            }
            int g2 = z ? aVar.g() : aVar.h();
            d.a.q0.a.l1.e.a.a aVar2 = bVar2.l;
            int g3 = z ? aVar2.g() : aVar2.h();
            if (g2 != g3) {
                ValueAnimator ofInt = ValueAnimator.ofInt(g2, g3);
                ofInt.addUpdateListener(new C0689a(this, swanAppComponentContainerView, z, bVar2));
                return ofInt;
            }
            return null;
        }
        return (ValueAnimator) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.b.a
    @NonNull
    /* renamed from: K */
    public d.a.q0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, m, m2)) == null) {
            d.a.q0.a.c0.f.b k = super.k(m, m2);
            if (m2.n != null && ((jSONObject = m.n) == null || !TextUtils.equals(jSONObject.toString(), m2.n.toString()))) {
                k.b(4);
            }
            return k;
        }
        return (d.a.q0.a.c0.f.b) invokeLL.objValue;
    }

    public final boolean L() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? s(4) && t() && (jSONObject = ((b) n()).u) != null && !TextUtils.isEmpty(jSONObject.optString("duration")) : invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Interpolator M(@NonNull String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            switch (str.hashCode()) {
                case -1965120668:
                    if (str.equals("ease-in")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1102672091:
                    if (str.equals("linear")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -789192465:
                    if (str.equals("ease-out")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -361990811:
                    if (str.equals("ease-in-out")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3105774:
                    if (str.equals("ease")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
                        }
                        return PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
                    }
                    return PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
                }
                return PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            }
            return PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
        }
        return (Interpolator) invokeL.objValue;
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? P(false) : invokeV.booleanValue;
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? P(true) : invokeV.booleanValue;
    }

    public final boolean P(boolean z) {
        InterceptResult invokeZ;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            SwanAppComponentContainerView m = m();
            b bVar = (b) p();
            b bVar2 = (b) n();
            if (m == null || bVar == null || (jSONObject = bVar2.u) == null || TextUtils.isEmpty(jSONObject.optString("duration"))) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(J(m, bVar, bVar2, false));
                arrayList.add(J(m, bVar, bVar2, true));
            } else {
                arrayList.add(H(m, bVar, bVar2));
            }
            AnimatorSet I = I(bVar2.v, M(bVar2.w), arrayList);
            if (I != null) {
                I.start();
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.c0.b.a
    /* renamed from: Q */
    public void D(@NonNull V v, @NonNull M m, @NonNull d.a.q0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, v, m, bVar) == null) {
            super.D(v, m, bVar);
            if (bVar.a(4)) {
                T(v, m);
                S(v, m);
                R(v, m);
            }
        }
    }

    public void R(@NonNull View view, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, view, m) == null) || m.n == null) {
            return;
        }
        if (d.a.q0.a.c0.b.a.f46766h) {
            Log.d("Component-View", "renderAlpha");
        }
        if (L()) {
            if (d.a.q0.a.c0.b.a.f46766h) {
                Log.d("Component-View", "renderAlpha with animation");
            }
            if (N()) {
                return;
            }
            d.l("Component-View", "performAlphaUpdateAnimation fail");
            return;
        }
        float f2 = m.t;
        if (f2 >= 0.0f && f2 <= 1.0f) {
            view.setAlpha(f2);
            return;
        }
        d.l("Component-View", "alpha invalid: " + m.t);
    }

    public void S(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, v, m) == null) || m.n == null) {
            return;
        }
        if (d.a.q0.a.c0.b.a.f46766h) {
            Log.d("Component-View", "renderBackground");
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(m.o);
        gradientDrawable.setCornerRadius(m.r);
        gradientDrawable.setStroke(m.p, m.q);
        v.setBackground(gradientDrawable);
    }

    public void T(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, v, m) == null) || m.n == null) {
            return;
        }
        if (d.a.q0.a.c0.b.a.f46766h) {
            Log.d("Component-View", "renderPadding");
        }
        JSONArray jSONArray = m.s;
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.length() == 4) {
            v.setPadding(n0.g((float) jSONArray.optDouble(3, 0.0d)), n0.g((float) jSONArray.optDouble(0, 0.0d)), n0.g((float) jSONArray.optDouble(1, 0.0d)), n0.g((float) jSONArray.optDouble(2, 0.0d)));
            return;
        }
        d.b("Component-View", "invalid padding array length: " + jSONArray.length());
    }
}

package d.a.n0.a.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f48036e;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48036e = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f48036e.setTranslationX(0.0f);
            }
        }
    }

    public static void a(d.a.n0.a.h0.g.g gVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, gVar, context) == null) {
            b(gVar, context, 2);
        }
    }

    public static void b(d.a.n0.a.h0.g.g gVar, Context context, int i2) {
        View b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, gVar, context, i2) == null) || gVar == null || gVar.k() < i2) {
            return;
        }
        d.a.n0.a.h0.g.d j = gVar.j(gVar.k() - i2);
        float o = n0.o(context) >> 2;
        if (j == null || (b0 = j.b0()) == null) {
            return;
        }
        ObjectAnimator.ofFloat(b0, "translationX", -o, 0.0f).setDuration(300L).start();
    }

    public static void c(d.a.n0.a.h0.g.g gVar, Context context) {
        View b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, gVar, context) == null) || gVar == null || gVar.k() < 2) {
            return;
        }
        d.a.n0.a.h0.g.d j = gVar.j(gVar.k() - 2);
        float o = n0.o(context) >> 2;
        if (j == null || (b0 = j.b0()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b0, "translationX", 0.0f, -o);
        ofFloat.setDuration(300L).start();
        ofFloat.addListener(new a(b0));
    }
}

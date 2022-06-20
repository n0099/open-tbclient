package com.repackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes5.dex */
public class cc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.setTranslationX(0.0f);
            }
        }
    }

    public static void a(bz1 bz1Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bz1Var, context) == null) {
            b(bz1Var, context, 2);
        }
    }

    public static void b(bz1 bz1Var, Context context, int i) {
        View S;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, bz1Var, context, i) == null) || bz1Var == null || bz1Var.k() < i) {
            return;
        }
        yy1 j = bz1Var.j(bz1Var.k() - i);
        yy1 m = bz1Var.m();
        if (m == null || !m.D0) {
            float o = jd3.o(context) >> 2;
            if (j == null || (S = j.S()) == null) {
                return;
            }
            ObjectAnimator.ofFloat(S, AnimationProperty.TRANSLATE_X, -o, 0.0f).setDuration(300L).start();
        }
    }

    public static void c(bz1 bz1Var, Context context) {
        View S;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, bz1Var, context) == null) || bz1Var == null || bz1Var.k() < 2) {
            return;
        }
        yy1 j = bz1Var.j(bz1Var.k() - 2);
        float o = jd3.o(context) >> 2;
        if (j == null || (S = j.S()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(S, AnimationProperty.TRANSLATE_X, 0.0f, -o);
        ofFloat.setDuration(300L).start();
        ofFloat.addListener(new a(S));
    }

    public static void d(@NonNull od4 od4Var, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65539, null, od4Var, str, i, i2) == null) || od4Var == null) {
            return;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1876181062) {
            if (hashCode != -983638536) {
                if (hashCode == 1528366175 && str.equals("showModalPage")) {
                    c = 1;
                }
            } else if (str.equals("navigateBack")) {
                c = 0;
            }
        } else if (str.equals("hideModalPage")) {
            c = 2;
        }
        if (c != 0) {
            if (c == 1 || c == 2) {
                return;
            }
            od4Var.i(i, i2);
            return;
        }
        bz1 V = fl2.U().V();
        yy1 j = V.j(V.k() - 1);
        if (j == null || !j.D0) {
            od4Var.i(i, i2);
        }
    }
}

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
/* loaded from: classes7.dex */
public class sc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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

    public static void a(rz1 rz1Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, rz1Var, context) == null) {
            b(rz1Var, context, 2);
        }
    }

    public static void b(rz1 rz1Var, Context context, int i) {
        View U;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, rz1Var, context, i) == null) || rz1Var == null || rz1Var.k() < i) {
            return;
        }
        oz1 j = rz1Var.j(rz1Var.k() - i);
        oz1 m = rz1Var.m();
        if (m == null || !m.D0) {
            float o = zd3.o(context) >> 2;
            if (j == null || (U = j.U()) == null) {
                return;
            }
            ObjectAnimator.ofFloat(U, "translationX", -o, 0.0f).setDuration(300L).start();
        }
    }

    public static void c(rz1 rz1Var, Context context) {
        View U;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, rz1Var, context) == null) || rz1Var == null || rz1Var.k() < 2) {
            return;
        }
        oz1 j = rz1Var.j(rz1Var.k() - 2);
        float o = zd3.o(context) >> 2;
        if (j == null || (U = j.U()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(U, "translationX", 0.0f, -o);
        ofFloat.setDuration(300L).start();
        ofFloat.addListener(new a(U));
    }

    public static void d(@NonNull ee4 ee4Var, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65539, null, ee4Var, str, i, i2) == null) || ee4Var == null) {
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
            ee4Var.i(i, i2);
            return;
        }
        rz1 V = vl2.U().V();
        oz1 j = V.j(V.k() - 1);
        if (j == null || !j.D0) {
            ee4Var.i(i, i2);
        }
    }
}

package com.repackage;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class ov1 extends su1<TextView, pv1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppComponentContainerView i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ov1(@NonNull Context context, @NonNull pv1 pv1Var) {
        super(context, pv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, pv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (tu1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g(4);
        this.i = new SwanAppComponentContainerView(context);
        this.j = new TextView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.su1, com.repackage.uu1, com.repackage.wu1
    @NonNull
    /* renamed from: Z */
    public zv1 k(@NonNull pv1 pv1Var, @NonNull pv1 pv1Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, pv1Var, pv1Var2)) == null) {
            zv1 k = super.k(pv1Var, pv1Var2);
            if (!TextUtils.equals(pv1Var.E, pv1Var2.E) && (TextUtils.equals(pv1Var.E, "scroll") || TextUtils.equals(pv1Var2.E, "scroll"))) {
                k.b(7);
            }
            if (!TextUtils.equals(pv1Var.E, pv1Var2.E) || (TextUtils.equals(pv1Var2.E, "scroll") && pv1Var.D != pv1Var2.D)) {
                k.b(8);
            }
            return k;
        }
        return (zv1) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wu1
    @NonNull
    /* renamed from: a0 */
    public TextView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? this.j : (TextView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uu1
    /* renamed from: b0 */
    public void P(@NonNull View view2, @NonNull pv1 pv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, pv1Var) == null) {
            if (wu1.h) {
                Log.d("Component-CoverView", "renderAlpha");
            }
            if (pv1Var.j == null) {
                return;
            }
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                super.P((View) parent, pv1Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uu1
    /* renamed from: c0 */
    public void Q(@NonNull TextView textView, @NonNull pv1 pv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, textView, pv1Var) == null) {
            if (wu1.h) {
                Log.d("Component-CoverView", "renderBackground");
            }
            if (pv1Var.j == null) {
                return;
            }
            SwanAppComponentContainerView m = m();
            if (m != null) {
                m.setModel(pv1Var);
            }
            ViewParent parent = textView.getParent();
            if (parent instanceof View) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(pv1Var.k);
                gradientDrawable.setCornerRadius(pv1Var.n);
                gradientDrawable.setStroke(pv1Var.l, pv1Var.m);
                ((View) parent).setBackground(gradientDrawable);
            }
        }
    }

    @Override // com.repackage.wu1
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? this.i : (SwanAppComponentContainerView) invokeL.objValue;
    }
}

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
/* loaded from: classes7.dex */
public final class zv1 extends dv1<TextView, aw1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppComponentContainerView i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zv1(@NonNull Context context, @NonNull aw1 aw1Var) {
        super(context, aw1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aw1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ev1) objArr2[1]);
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
    @Override // com.repackage.dv1, com.repackage.fv1, com.repackage.hv1
    @NonNull
    /* renamed from: Z */
    public kw1 k(@NonNull aw1 aw1Var, @NonNull aw1 aw1Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, aw1Var, aw1Var2)) == null) {
            kw1 k = super.k(aw1Var, aw1Var2);
            if (!TextUtils.equals(aw1Var.E, aw1Var2.E) && (TextUtils.equals(aw1Var.E, "scroll") || TextUtils.equals(aw1Var2.E, "scroll"))) {
                k.b(7);
            }
            if (!TextUtils.equals(aw1Var.E, aw1Var2.E) || (TextUtils.equals(aw1Var2.E, "scroll") && aw1Var.D != aw1Var2.D)) {
                k.b(8);
            }
            return k;
        }
        return (kw1) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.hv1
    @NonNull
    /* renamed from: a0 */
    public TextView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? this.j : (TextView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fv1
    /* renamed from: b0 */
    public void P(@NonNull View view2, @NonNull aw1 aw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, aw1Var) == null) {
            if (hv1.h) {
                Log.d("Component-CoverView", "renderAlpha");
            }
            if (aw1Var.j == null) {
                return;
            }
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                super.P((View) parent, aw1Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fv1
    /* renamed from: c0 */
    public void Q(@NonNull TextView textView, @NonNull aw1 aw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, textView, aw1Var) == null) {
            if (hv1.h) {
                Log.d("Component-CoverView", "renderBackground");
            }
            if (aw1Var.j == null) {
                return;
            }
            SwanAppComponentContainerView m = m();
            if (m != null) {
                m.setModel(aw1Var);
            }
            ViewParent parent = textView.getParent();
            if (parent instanceof View) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(aw1Var.k);
                gradientDrawable.setCornerRadius(aw1Var.n);
                gradientDrawable.setStroke(aw1Var.l, aw1Var.m);
                ((View) parent).setBackground(gradientDrawable);
            }
        }
    }

    @Override // com.repackage.hv1
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? this.i : (SwanAppComponentContainerView) invokeL.objValue;
    }
}

package com.repackage;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d9 a;
    public final qn b;
    public Runnable c;
    public boolean d;

    public wy8(d9 d9Var, qn qnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var, qnVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d9Var;
        this.b = qnVar;
    }

    @NonNull
    public final Rect a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public final boolean b(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect)) == null) {
            float i = qi.i(TbadkCoreApplication.getInst());
            return rect.top >= ((int) (0.0f * i)) && rect.bottom <= ((int) (i * 0.66f));
        }
        return invokeL.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.c == null) {
            return;
        }
        rg.a().removeCallbacks(this.c);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.d) {
            return;
        }
        if (this.c == null) {
            this.c = new Runnable() { // from class: com.repackage.uy8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        wy8.this.g();
                    }
                }
            };
        }
        rg.a().postDelayed(this.c, 2000L);
    }

    public void e() {
        qn qnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == null || (qnVar = this.b) == null || qnVar.getListView().getChildCount() == 0 || this.b.getContentViewsCount() == 0) {
            return;
        }
        int childCount = this.b.getListView().getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getListView().getChildAt(i);
            if (childAt != null && (childAt.getTag(R.id.obfuscated_res_0x7f0925a1) instanceof vy8)) {
                ((vy8) childAt.getTag(R.id.obfuscated_res_0x7f0925a1)).b();
            }
        }
    }

    public void f(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && (view2.getTag(R.id.obfuscated_res_0x7f0925a1) instanceof vy8)) {
            ((vy8) view2.getTag(R.id.obfuscated_res_0x7f0925a1)).b();
            view2.setTag(R.id.obfuscated_res_0x7f0925a1, null);
        }
    }

    public final void g() {
        qn qnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a == null || (qnVar = this.b) == null || qnVar.getListView().getChildCount() == 0 || this.b.getContentViewsCount() == 0) {
            return;
        }
        int childCount = this.b.getListView().getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getListView().getChildAt(i);
            if (childAt != null && (childAt.getTag(R.id.obfuscated_res_0x7f0925a1) instanceof vy8)) {
                vy8 vy8Var = (vy8) childAt.getTag(R.id.obfuscated_res_0x7f0925a1);
                if (b(a(childAt))) {
                    vy8Var.play();
                }
            }
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.d = z;
        }
    }
}

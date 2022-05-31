package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.local.view.LocalInputContainer;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dg8;
import com.repackage.q15;
/* loaded from: classes7.dex */
public class y05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public Context b;
    public View c;
    public z05 d;
    public b15 e;

    public y05(Context context, View view2, z05 z05Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, z05Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (k(context, view2, z05Var)) {
            this.b = context;
            this.c = view2;
            this.d = z05Var;
            c();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.c instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.c).addView(this.a, layoutParams);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            this.a.o();
            if (this.c == null || this.a.getParent() == null) {
                return;
            }
            View view2 = this.c;
            if (view2 instanceof RelativeLayout) {
                ((RelativeLayout) view2).removeView(this.a);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            e();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            EditorTools a = ((g15) new h15(this.d).a(this.b)).a();
            this.a = a;
            a.setId(R.id.obfuscated_res_0x7f0912e9);
            this.a.setOnCancelClickListener(new View.OnClickListener() { // from class: com.repackage.v05
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        y05.this.f(view2);
                    }
                }
            });
            Context context = this.b;
            if (context instanceof Activity) {
                q15.b((Activity) context, this.a.b, new q15.b() { // from class: com.repackage.x05
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.repackage.q15.b
                    public final void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            y05.this.g(z);
                        }
                    }
                });
            }
            ((LocalInputContainer) this.a.n(36).m).setSendBtnClickListener(new LocalInputContainer.c() { // from class: com.repackage.u05
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.editortools.local.view.LocalInputContainer.c
                public final void a(z05 z05Var, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, z05Var, str) == null) {
                        y05.this.h(z05Var, str);
                    }
                }
            });
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e = new b15(this.d);
        }
    }

    public /* synthetic */ void f(View view2) {
        b();
    }

    public /* synthetic */ void g(boolean z) {
        if (z) {
            this.a.b.setVisibility(0);
            this.a.b.setBackgroundColorId(R.color.CAM_X0207);
            return;
        }
        this.a.b.o();
    }

    public /* synthetic */ void h(z05 z05Var, String str) {
        b15 b15Var = this.e;
        if (b15Var != null) {
            b15Var.f(z05Var, str);
            b();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SEND_BTN_CLICK);
            statisticItem.addParam("obj_id", z05Var.a().a);
            TiebaStatic.log(statisticItem);
        }
    }

    public /* synthetic */ void i(String str) {
        this.a.A(new sz4(6, 36, str));
    }

    public final void j() {
        b15 b15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (b15Var = this.e) == null) {
            return;
        }
        b15Var.d(new dg8.g() { // from class: com.repackage.w05
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.repackage.dg8.g
            public final void a(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    y05.this.i(str);
                }
            }
        });
    }

    public final boolean k(Context context, View view2, z05 z05Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, view2, z05Var)) == null) ? (!(context instanceof Activity) || view2 == null || z05Var == null) ? false : true : invokeLLL.booleanValue;
    }

    public final void l() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (editorTools = this.a) == null || editorTools.n(36) == null) {
            return;
        }
        f05 f05Var = this.a.n(36).m;
        if (f05Var instanceof LocalInputContainer) {
            String inputContentDraft = ((LocalInputContainer) f05Var).getInputContentDraft();
            b15 b15Var = this.e;
            if (b15Var != null) {
                b15Var.e(inputContentDraft);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.a == null) {
            return;
        }
        j();
        this.a.j();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SHOW);
        statisticItem.addParam("obj_id", this.d.a().a);
        TiebaStatic.log(statisticItem);
    }
}

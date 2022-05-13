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
import com.repackage.cj8;
import com.repackage.u25;
/* loaded from: classes5.dex */
public class c25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public Context b;
    public View c;
    public d25 d;
    public f25 e;

    public c25(Context context, View view2, d25 d25Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, d25Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (k(context, view2, d25Var)) {
            this.b = context;
            this.c = view2;
            this.d = d25Var;
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
            EditorTools a = ((k25) new l25(this.d).a(this.b)).a();
            this.a = a;
            a.setId(R.id.obfuscated_res_0x7f091327);
            this.a.setOnCancelClickListener(new View.OnClickListener() { // from class: com.repackage.z15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        c25.this.f(view2);
                    }
                }
            });
            Context context = this.b;
            if (context instanceof Activity) {
                u25.b((Activity) context, this.a.b, new u25.b() { // from class: com.repackage.b25
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.repackage.u25.b
                    public final void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            c25.this.g(z);
                        }
                    }
                });
            }
            ((LocalInputContainer) this.a.n(36).m).setSendBtnClickListener(new LocalInputContainer.c() { // from class: com.repackage.y15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.editortools.local.view.LocalInputContainer.c
                public final void a(d25 d25Var, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, d25Var, str) == null) {
                        c25.this.h(d25Var, str);
                    }
                }
            });
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e = new f25(this.d);
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

    public /* synthetic */ void h(d25 d25Var, String str) {
        f25 f25Var = this.e;
        if (f25Var != null) {
            f25Var.f(d25Var, str);
            b();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SEND_BTN_CLICK);
            statisticItem.addParam("obj_id", d25Var.a().a);
            TiebaStatic.log(statisticItem);
        }
    }

    public /* synthetic */ void i(String str) {
        this.a.A(new w05(6, 36, str));
    }

    public final void j() {
        f25 f25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (f25Var = this.e) == null) {
            return;
        }
        f25Var.d(new cj8.g() { // from class: com.repackage.a25
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.repackage.cj8.g
            public final void a(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    c25.this.i(str);
                }
            }
        });
    }

    public final boolean k(Context context, View view2, d25 d25Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, view2, d25Var)) == null) ? (!(context instanceof Activity) || view2 == null || d25Var == null) ? false : true : invokeLLL.booleanValue;
    }

    public final void l() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (editorTools = this.a) == null || editorTools.n(36) == null) {
            return;
        }
        j15 j15Var = this.a.n(36).m;
        if (j15Var instanceof LocalInputContainer) {
            String inputContentDraft = ((LocalInputContainer) j15Var).getInputContentDraft();
            f25 f25Var = this.e;
            if (f25Var != null) {
                f25Var.e(inputContentDraft);
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

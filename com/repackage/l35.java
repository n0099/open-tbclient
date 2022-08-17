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
import com.repackage.d45;
import com.repackage.ek8;
/* loaded from: classes6.dex */
public class l35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public Context b;
    public View c;
    public m35 d;
    public o35 e;

    public l35(Context context, View view2, m35 m35Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, m35Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (k(context, view2, m35Var)) {
            this.b = context;
            this.c = view2;
            this.d = m35Var;
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
            EditorTools a = ((t35) new u35(this.d).a(this.b)).a();
            this.a = a;
            a.setId(R.id.obfuscated_res_0x7f091406);
            this.a.setOnCancelClickListener(new View.OnClickListener() { // from class: com.repackage.j35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        l35.this.f(view2);
                    }
                }
            });
            Context context = this.b;
            if (context instanceof Activity) {
                d45.b((Activity) context, this.a.b, new d45.b() { // from class: com.repackage.i35
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.repackage.d45.b
                    public final void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            l35.this.g(z);
                        }
                    }
                });
            }
            ((LocalInputContainer) this.a.n(36).m).setSendBtnClickListener(new LocalInputContainer.c() { // from class: com.repackage.k35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.editortools.local.view.LocalInputContainer.c
                public final void a(m35 m35Var, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, m35Var, str) == null) {
                        l35.this.h(m35Var, str);
                    }
                }
            });
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e = new o35(this.d);
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

    public /* synthetic */ void h(m35 m35Var, String str) {
        o35 o35Var = this.e;
        if (o35Var != null) {
            o35Var.f(m35Var, str);
            b();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SEND_BTN_CLICK);
            statisticItem.addParam("obj_id", m35Var.a().a);
            TiebaStatic.log(statisticItem);
        }
    }

    public /* synthetic */ void i(String str) {
        this.a.A(new h25(6, 36, str));
    }

    public final void j() {
        o35 o35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (o35Var = this.e) == null) {
            return;
        }
        o35Var.d(new ek8.h() { // from class: com.repackage.h35
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.repackage.ek8.h
            public final void a(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    l35.this.i(str);
                }
            }
        });
    }

    public final boolean k(Context context, View view2, m35 m35Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, view2, m35Var)) == null) ? (!(context instanceof Activity) || view2 == null || m35Var == null) ? false : true : invokeLLL.booleanValue;
    }

    public final void l() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (editorTools = this.a) == null || editorTools.n(36) == null) {
            return;
        }
        t25 t25Var = this.a.n(36).m;
        if (t25Var instanceof LocalInputContainer) {
            String inputContentDraft = ((LocalInputContainer) t25Var).getInputContentDraft();
            o35 o35Var = this.e;
            if (o35Var != null) {
                o35Var.e(inputContentDraft);
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

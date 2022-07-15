package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NadExpressNaBaseView a;
    public final Context b;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-576115913, "Lcom/repackage/a51$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-576115913, "Lcom/repackage/a51$a;");
                    return;
                }
            }
            int[] iArr = new int[AdOperator.TYPE.values().length];
            a = iArr;
            try {
                iArr[AdOperator.TYPE.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdOperator.TYPE.CHECK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a51(NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nadExpressNaBaseView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nadExpressNaBaseView;
        this.b = nadExpressNaBaseView.getContext();
    }

    public final boolean a(AdBaseModel adBaseModel, int i) {
        InterceptResult invokeLI;
        AdOperator adOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, adBaseModel, i)) == null) {
            if (adBaseModel == null || (adOperator = adBaseModel.h) == null) {
                return false;
            }
            int i2 = a.a[adOperator.a.ordinal()];
            if (i2 != 1) {
                return i2 == 2 && i == 2;
            }
            qn0 qn0Var = adBaseModel.i;
            return (qn0Var == null || !qn0Var.k) ? i == 1 : i == 3;
        }
        return invokeLI.booleanValue;
    }

    public final void b(View view2, float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, f) == null) || view2 == null) {
            return;
        }
        g11.a(view2.getContext(), view2, f);
    }

    public z41 c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        AdOperator adOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel)) == null) {
            z41 operateBar = this.a.getOperateBar();
            if (z41.d(adBaseModel) && (adOperator = adBaseModel.h) != null) {
                if (operateBar == null || !a(adBaseModel, operateBar.a)) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09152e);
                    relativeLayout.removeAllViews();
                    AdOperator.TYPE type = adOperator.a;
                    AdOperator.TYPE type2 = AdOperator.TYPE.DOWNLOAD;
                    if (type == type2) {
                        xm0 xm0Var = adBaseModel.l;
                        if (xm0Var == null || !xm0Var.e) {
                            return null;
                        }
                        int i = R.layout.obfuscated_res_0x7f0d05c5;
                        pn0 pn0Var = adBaseModel.p;
                        if (pn0Var != null && pn0Var.b(type2) != 0) {
                            i = adBaseModel.p.b(AdOperator.TYPE.DOWNLOAD);
                        }
                        qn0 qn0Var = adBaseModel.i;
                        if (qn0Var != null && qn0Var.k) {
                            View inflate = LayoutInflater.from(this.b).inflate(i, (ViewGroup) relativeLayout, true);
                            b(inflate.findViewById(R.id.obfuscated_res_0x7f09152d), 6.0f);
                            return new b51(3, inflate);
                        }
                        View inflate2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d05c7, (ViewGroup) relativeLayout, true);
                        b(inflate2.findViewById(R.id.obfuscated_res_0x7f09152d), 6.0f);
                        return new d51(1, inflate2);
                    }
                    AdOperator.TYPE type3 = AdOperator.TYPE.CHECK;
                    if (type == type3) {
                        int i2 = R.layout.obfuscated_res_0x7f0d05c6;
                        pn0 pn0Var2 = adBaseModel.p;
                        if (pn0Var2 != null && pn0Var2.b(type3) != 0) {
                            i2 = adBaseModel.p.b(AdOperator.TYPE.CHECK);
                        }
                        View inflate3 = LayoutInflater.from(this.b).inflate(i2, (ViewGroup) relativeLayout, true);
                        b(inflate3.findViewById(R.id.obfuscated_res_0x7f09152c), 6.0f);
                        return new c51(2, inflate3);
                    }
                    return null;
                }
                return operateBar;
            }
            return null;
        }
        return (z41) invokeL.objValue;
    }
}

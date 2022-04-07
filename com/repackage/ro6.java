package com.repackage;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class ro6 implements qo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;
    public final Context b;
    @Nullable
    public Boolean c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-35707173, "Lcom/repackage/ro6$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-35707173, "Lcom/repackage/ro6$a;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.LIKE_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LogicField.SIGN_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TBSpecificationBtn b;
        public TBSpecificationBtn c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @NonNull
        public static b a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                b bVar = new b();
                bVar.a = view2;
                bVar.b = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f091241);
                bVar.c = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f091cea);
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    public ro6(@NonNull FrsFragment frsFragment, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = view2.getContext();
        b a2 = b.a(view2);
        this.a = a2;
        a2.b.setText(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f029c));
        this.a.b.setTextSize(R.dimen.T_X08);
        mu4 mu4Var = new mu4();
        mu4Var.p(R.color.CAM_X0901, R.color.CAM_X0105);
        this.a.b.setConfig(mu4Var);
        this.a.b.setTag(R.id.obfuscated_res_0x7f090663, LogicField.LIKE_BTN);
        this.a.c.setTextSize(R.dimen.T_X08);
        mu4 mu4Var2 = new mu4();
        mu4Var2.u(R.color.CAM_X0105);
        mu4Var2.g(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        mu4Var2.i(R.drawable.obfuscated_res_0x7f08090c, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.a.c.setConfig(mu4Var2);
        this.a.c.setText(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f1160));
        this.a.c.setTag(R.id.obfuscated_res_0x7f090663, LogicField.SIGN_BTN);
    }

    @Override // com.repackage.qo6
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            int i = a.a[logicField.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return (T) this.a.c;
            }
            return (T) this.a.b;
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a : (View) invokeV.objValue;
    }

    @Override // com.repackage.qo6
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.a.b.setVisibility(8);
                this.a.c.setVisibility(0);
                return;
            }
            this.a.b.setVisibility(0);
            this.a.c.setVisibility(8);
        }
    }

    @Override // com.repackage.qo6
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.a.b.setOnClickListener(onClickListener);
            this.a.c.setOnClickListener(onClickListener);
        }
    }

    public void e(boolean z, @NonNull ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, themeElement) == null) {
            Boolean bool = this.c;
            if (bool == null || bool.booleanValue() != z) {
                this.c = Boolean.valueOf(z);
                mu4 mu4Var = (mu4) this.a.b.getStyleConfig();
                if (z) {
                    mu4Var.p(R.color.CAM_X0901, R.color.CAM_X0105);
                } else if (UtilHelper.isNightOrDarkMode()) {
                    mu4Var.t(R.color.CAM_X0105);
                } else {
                    mu4Var.s(zi8.e(themeElement.common_color));
                }
                this.a.b.setConfig(mu4Var);
                this.a.b.setTag(R.id.obfuscated_res_0x7f090fa1, Boolean.valueOf(!z));
                mu4 mu4Var2 = (mu4) this.a.c.getStyleConfig();
                if (z) {
                    mu4Var2.u(R.color.CAM_X0105);
                } else {
                    Object tag = this.a.c.getTag(R.id.obfuscated_res_0x7f090fa1);
                    if (((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) || UtilHelper.isNightOrDarkMode()) {
                        mu4Var2.t(R.color.CAM_X0105);
                    } else {
                        mu4Var2.s(zi8.e(themeElement.common_color));
                    }
                }
                this.a.c.setConfig(mu4Var2);
            }
        }
    }
}

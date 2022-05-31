package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class tf0 extends o41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBaseModel a;
    public View b;
    public View.OnClickListener c;

    public tf0(AdBaseModel adBaseModel, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adBaseModel, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = adBaseModel;
        this.b = view2;
    }

    @Override // com.repackage.o41
    public void b(@NonNull um0 um0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, um0Var) == null) {
            Toast.makeText(xg0.b(), "on click : operator btn", 1).show();
            if (um0Var.c) {
                gg0.b(um0Var.a);
                g(ClogBuilder.LogType.CLICK, NativeConstants.ID_BUTTON, this.a);
            }
            View.OnClickListener onClickListener = this.c;
            if (onClickListener != null) {
                onClickListener.onClick(this.b);
            }
        }
    }

    public final void g(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        om0 om0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, logType, str, adBaseModel) == null) || adBaseModel == null || (om0Var = adBaseModel.f) == null || TextUtils.isEmpty(om0Var.d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(logType);
        clogBuilder.h(str);
        clogBuilder.n(adBaseModel.f.d);
        rx0.c(clogBuilder);
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }
}

package com.repackage;

import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes7.dex */
public class x0a implements j3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public n0a c;
    public AbsViewEventHandler d;

    public x0a(int i, int i2, n0a n0aVar, AbsViewEventHandler absViewEventHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), n0aVar, absViewEventHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("AmountDialogListener", "create AmountDialogListener appId:" + i + " userChannel:" + i2);
        this.a = i;
        this.b = i2;
        this.c = n0aVar;
        this.d = absViewEventHandler;
    }

    @Override // com.repackage.j3a
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("AmountDialogListener", "PayAmountDialog notifyCancelType clickArea:" + cancelType);
            this.c.c(cancelType, this.d);
            m1a.a(this.a, this.b, cancelType);
        }
    }

    @Override // com.repackage.j3a
    public boolean b(DialogInterface dialogInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}

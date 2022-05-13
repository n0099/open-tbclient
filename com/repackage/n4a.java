package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes6.dex */
public class n4a implements IYYPayResultView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public IYYPayResultView b;
    public AbsViewEventHandler c;
    public Dialog d;
    public s3a e;

    public n4a(Activity activity, IYYPayResultView iYYPayResultView, AbsViewEventHandler absViewEventHandler, Dialog dialog, s3a s3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, iYYPayResultView, absViewEventHandler, dialog, s3aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayResultViewCallback", "create PayResultViewCallback");
        this.a = activity;
        this.b = iYYPayResultView;
        this.c = absViewEventHandler;
        this.d = dialog;
        this.e = s3aVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RLog.info("PayResultViewCallback", "onBtnConfirm");
            i5a.b(this.d, PayDialogType.PAY_RESULT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e.k(this.a, this.b, this.c) : invokeV.booleanValue;
    }
}

package j.a.a.e.e.r;

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
/* loaded from: classes8.dex */
public class j implements IYYPayResultView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public IYYPayResultView f60888b;

    /* renamed from: c  reason: collision with root package name */
    public AbsViewEventHandler f60889c;

    /* renamed from: d  reason: collision with root package name */
    public Dialog f60890d;

    /* renamed from: e  reason: collision with root package name */
    public j.a.a.e.e.f f60891e;

    public j(Activity activity, IYYPayResultView iYYPayResultView, AbsViewEventHandler absViewEventHandler, Dialog dialog, j.a.a.e.e.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, iYYPayResultView, absViewEventHandler, dialog, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayResultViewCallback", "create PayResultViewCallback");
        this.a = activity;
        this.f60888b = iYYPayResultView;
        this.f60889c = absViewEventHandler;
        this.f60890d = dialog;
        this.f60891e = fVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RLog.info("PayResultViewCallback", "onBtnConfirm");
            j.a.a.e.h.h.b(this.f60890d, PayDialogType.PAY_RESULT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RLog.info("PayResultViewCallback", " onFinishPayFlow");
            j.a.a.e.h.h.b(this.f60890d, PayDialogType.PAY_RESULT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60891e.k(this.a, this.f60888b, this.f60889c) : invokeV.booleanValue;
    }
}

package j.a.a.e.m.r;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes4.dex */
public class i implements j.a.a.e.q.g.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AbsViewEventHandler a;

    /* renamed from: b  reason: collision with root package name */
    public j.a.a.e.m.f f64754b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f64755c;

    public i(AbsViewEventHandler absViewEventHandler, j.a.a.e.m.f fVar, Activity activity, IYYPayResultView iYYPayResultView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absViewEventHandler, fVar, activity, iYYPayResultView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayResultDialogListener", "create PayResultDialogListener");
        this.a = absViewEventHandler;
        this.f64754b = fVar;
        this.f64755c = activity;
    }

    @Override // j.a.a.e.q.g.c
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("PayResultDialogListener", "PayResultDialog notifyCancelType clickArea:" + cancelType);
            this.f64754b.c(cancelType, this.a);
        }
    }

    @Override // j.a.a.e.q.g.c
    public boolean b(DialogInterface dialogInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}

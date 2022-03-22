package h.a.a.e.e.r;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import h.a.a.e.e.n;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes7.dex */
public class k implements h.a.a.e.i.g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f45192b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f45193c;

    /* renamed from: d  reason: collision with root package name */
    public IYYPayWayView f45194d;

    /* renamed from: e  reason: collision with root package name */
    public AbsViewEventHandler f45195e;

    /* renamed from: f  reason: collision with root package name */
    public h.a.a.e.e.f f45196f;

    public k(int i, int i2, Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler, h.a.a.e.e.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), activity, iYYPayWayView, absViewEventHandler, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayWayDialogListener", "create PayWayDialogListener appId:" + i + " userChannel:" + i2);
        this.a = i;
        this.f45192b = i2;
        this.f45193c = activity;
        this.f45194d = iYYPayWayView;
        this.f45195e = absViewEventHandler;
        this.f45196f = fVar;
    }

    @Override // h.a.a.e.i.g.d
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("PayWayDialogListener", "PayWayDialog notifyCancelType clickArea:" + cancelType);
            this.f45196f.i();
            this.f45196f.c(cancelType, this.f45195e);
            n.b(this.a, this.f45192b, cancelType);
        }
    }

    @Override // h.a.a.e.i.g.d
    public boolean b(DialogInterface dialogInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface)) == null) ? this.f45196f.m(this.f45193c, this.f45194d, this.f45195e) : invokeL.booleanValue;
    }
}

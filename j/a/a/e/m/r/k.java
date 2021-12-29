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
import j.a.a.e.m.n;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes4.dex */
public class k implements j.a.a.e.q.g.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f64760b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f64761c;

    /* renamed from: d  reason: collision with root package name */
    public IYYPayWayView f64762d;

    /* renamed from: e  reason: collision with root package name */
    public AbsViewEventHandler f64763e;

    /* renamed from: f  reason: collision with root package name */
    public j.a.a.e.m.f f64764f;

    public k(int i2, int i3, Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler, j.a.a.e.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), activity, iYYPayWayView, absViewEventHandler, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayWayDialogListener", "create PayWayDialogListener appId:" + i2 + " userChannel:" + i3);
        this.a = i2;
        this.f64760b = i3;
        this.f64761c = activity;
        this.f64762d = iYYPayWayView;
        this.f64763e = absViewEventHandler;
        this.f64764f = fVar;
    }

    @Override // j.a.a.e.q.g.c
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("PayWayDialogListener", "PayWayDialog notifyCancelType clickArea:" + cancelType);
            this.f64764f.i();
            this.f64764f.c(cancelType, this.f64763e);
            n.b(this.a, this.f64760b, cancelType);
        }
    }

    @Override // j.a.a.e.q.g.c
    public boolean b(DialogInterface dialogInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface)) == null) ? this.f64764f.m(this.f64761c, this.f64762d, this.f64763e) : invokeL.booleanValue;
    }
}

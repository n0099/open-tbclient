package j.a.a.e.k.o;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import j.a.a.e.k.k;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes3.dex */
public class i implements j.a.a.e.o.g.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f64184b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f64185c;

    /* renamed from: d  reason: collision with root package name */
    public IYYPayWayView f64186d;

    /* renamed from: e  reason: collision with root package name */
    public AbsViewEventHandler f64187e;

    /* renamed from: f  reason: collision with root package name */
    public j.a.a.e.k.c f64188f;

    public i(int i2, int i3, Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler, j.a.a.e.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), activity, iYYPayWayView, absViewEventHandler, cVar};
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
        this.f64184b = i3;
        this.f64185c = activity;
        this.f64186d = iYYPayWayView;
        this.f64187e = absViewEventHandler;
        this.f64188f = cVar;
    }

    @Override // j.a.a.e.o.g.c
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("PayWayDialogListener", "PayWayDialog notifyCancelType clickArea:" + cancelType);
            this.f64188f.g();
            this.f64188f.b(cancelType, this.f64187e);
            k.b(this.a, this.f64184b, cancelType);
        }
    }

    @Override // j.a.a.e.o.g.c
    public boolean b(DialogInterface dialogInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface)) == null) ? this.f64188f.k(this.f64185c, this.f64186d, this.f64187e) : invokeL.booleanValue;
    }
}

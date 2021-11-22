package i.a.a.e.k.o;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import i.a.a.e.k.k;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes2.dex */
public class i implements i.a.a.e.o.g.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f73251a;

    /* renamed from: b  reason: collision with root package name */
    public int f73252b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f73253c;

    /* renamed from: d  reason: collision with root package name */
    public IYYPayWayView f73254d;

    /* renamed from: e  reason: collision with root package name */
    public AbsViewEventHandler f73255e;

    /* renamed from: f  reason: collision with root package name */
    public i.a.a.e.k.c f73256f;

    public i(int i2, int i3, Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler, i.a.a.e.k.c cVar) {
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
        this.f73251a = i2;
        this.f73252b = i3;
        this.f73253c = activity;
        this.f73254d = iYYPayWayView;
        this.f73255e = absViewEventHandler;
        this.f73256f = cVar;
    }

    @Override // i.a.a.e.o.g.c
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("PayWayDialogListener", "PayWayDialog notifyCancelType clickArea:" + cancelType);
            this.f73256f.g();
            this.f73256f.b(cancelType, this.f73255e);
            k.b(this.f73251a, this.f73252b, cancelType);
        }
    }

    @Override // i.a.a.e.o.g.c
    public boolean b(DialogInterface dialogInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface)) == null) ? this.f73256f.k(this.f73253c, this.f73254d, this.f73255e) : invokeL.booleanValue;
    }
}

package j.a.a.e.e.r;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import j.a.a.e.e.n;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes8.dex */
public class k implements j.a.a.e.i.g.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f60892b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f60893c;

    /* renamed from: d  reason: collision with root package name */
    public IYYPayWayView f60894d;

    /* renamed from: e  reason: collision with root package name */
    public AbsViewEventHandler f60895e;

    /* renamed from: f  reason: collision with root package name */
    public j.a.a.e.e.f f60896f;

    public k(int i2, int i3, Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler, j.a.a.e.e.f fVar) {
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
        this.f60892b = i3;
        this.f60893c = activity;
        this.f60894d = iYYPayWayView;
        this.f60895e = absViewEventHandler;
        this.f60896f = fVar;
    }

    @Override // j.a.a.e.i.g.c
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("PayWayDialogListener", "PayWayDialog notifyCancelType clickArea:" + cancelType);
            this.f60896f.i();
            this.f60896f.c(cancelType, this.f60895e);
            n.b(this.a, this.f60892b, cancelType);
        }
    }

    @Override // j.a.a.e.i.g.c
    public boolean b(DialogInterface dialogInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface)) == null) ? this.f60896f.m(this.f60893c, this.f60894d, this.f60895e) : invokeL.booleanValue;
    }
}

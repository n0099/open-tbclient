package i.a.a.e.k.o;

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
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes3.dex */
public class a implements i.a.a.e.o.g.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f72297a;

    /* renamed from: b  reason: collision with root package name */
    public int f72298b;

    /* renamed from: c  reason: collision with root package name */
    public i.a.a.e.k.c f72299c;

    /* renamed from: d  reason: collision with root package name */
    public AbsViewEventHandler f72300d;

    public a(int i2, int i3, i.a.a.e.k.c cVar, AbsViewEventHandler absViewEventHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), cVar, absViewEventHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("AmountDialogListener", "create AmountDialogListener appId:" + i2 + " userChannel:" + i3);
        this.f72297a = i2;
        this.f72298b = i3;
        this.f72299c = cVar;
        this.f72300d = absViewEventHandler;
    }

    @Override // i.a.a.e.o.g.c
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("AmountDialogListener", "PayAmountDialog notifyCancelType clickArea:" + cancelType);
            this.f72299c.b(cancelType, this.f72300d);
            k.a(this.f72297a, this.f72298b, cancelType);
        }
    }

    @Override // i.a.a.e.o.g.c
    public boolean b(DialogInterface dialogInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}

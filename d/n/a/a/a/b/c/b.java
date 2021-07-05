package d.n.a.a.a.b.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import com.yxcorp.kuaishou.addfp.a.b.b.d;
import com.yxcorp.kuaishou.addfp.a.b.b.e;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes10.dex */
public final class b implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f75064e;

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75064e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d eVar;
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            try {
                a aVar = this.f75064e;
                if (iBinder == null) {
                    eVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                    if (queryLocalInterface != null && (queryLocalInterface instanceof com.yxcorp.kuaishou.addfp.a.b.a.b)) {
                        eVar = (d) queryLocalInterface;
                    }
                    eVar = new e(iBinder);
                }
                aVar.f75060c = eVar;
                countDownLatch = this.f75064e.f75061d;
                if (countDownLatch != null) {
                    countDownLatch2 = this.f75064e.f75061d;
                    countDownLatch2.countDown();
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            this.f75064e.f75060c = null;
        }
    }
}

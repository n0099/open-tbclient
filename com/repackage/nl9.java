package com.repackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class nl9 implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public boolean b;
    public final BlockingQueue c;

    public nl9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = new LinkedBlockingQueue();
        this.a = context;
    }

    public IBinder a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.b) {
                throw new IllegalStateException("Binder already consumed");
            }
            IBinder iBinder = (IBinder) this.c.take();
            if (iBinder != null) {
                this.b = true;
            }
            return iBinder;
        }
        return (IBinder) invokeV.objValue;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName, iBinder) == null) {
            try {
                this.c.put(iBinder);
                String a = ((com.win.opensdk.a) com.win.opensdk.b.a(iBinder)).a();
                if (TextUtils.isEmpty(a)) {
                    return;
                }
                bn9.x(this.a, a);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName) == null) {
        }
    }
}

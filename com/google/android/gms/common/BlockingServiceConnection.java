package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@KeepForSdk
/* loaded from: classes7.dex */
public class BlockingServiceConnection implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean zza;
    public final BlockingQueue<IBinder> zzb;

    public BlockingServiceConnection() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zza = false;
        this.zzb = new LinkedBlockingQueue();
    }

    @NonNull
    @KeepForSdk
    public IBinder getService() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
            if (!this.zza) {
                this.zza = true;
                return this.zzb.take();
            }
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        return (IBinder) invokeV.objValue;
    }

    @NonNull
    @KeepForSdk
    public IBinder getServiceWithTimeout(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit)) == null) {
            Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
            if (!this.zza) {
                this.zza = true;
                IBinder poll = this.zzb.poll(j, timeUnit);
                if (poll != null) {
                    return poll;
                }
                throw new TimeoutException("Timed out waiting for the service connection");
            }
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        return (IBinder) invokeJL.objValue;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, componentName, iBinder) == null) {
            this.zzb.add(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, componentName) == null) {
        }
    }
}

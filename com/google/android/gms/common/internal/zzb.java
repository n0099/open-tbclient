package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
/* loaded from: classes7.dex */
public final class zzb extends com.google.android.gms.internal.common.zzi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ BaseGmsClient zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseGmsClient, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zza = baseGmsClient;
    }

    public static final void zza(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, message) == null) {
            zzc zzcVar = (zzc) message.obj;
            zzcVar.zzc();
            zzcVar.zzg();
        }
    }

    public static final boolean zzb(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, message)) == null) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }
        return invokeL.booleanValue;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks;
        BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks2;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            if (this.zza.zzd.get() != message.arg1) {
                if (zzb(message)) {
                    zza(message);
                    return;
                }
                return;
            }
            int i = message.what;
            if ((i != 1 && i != 7 && ((i != 4 || this.zza.enableLocalFallback()) && message.what != 5)) || this.zza.isConnecting()) {
                int i2 = message.what;
                if (i2 == 4) {
                    this.zza.zzB = new ConnectionResult(message.arg2);
                    if (BaseGmsClient.zzo(this.zza)) {
                        BaseGmsClient baseGmsClient = this.zza;
                        z = baseGmsClient.zzC;
                        if (!z) {
                            baseGmsClient.zzp(3, null);
                            return;
                        }
                    }
                    BaseGmsClient baseGmsClient2 = this.zza;
                    connectionResult2 = baseGmsClient2.zzB;
                    ConnectionResult connectionResult3 = connectionResult2 != null ? baseGmsClient2.zzB : new ConnectionResult(8);
                    this.zza.zzc.onReportServiceBinding(connectionResult3);
                    this.zza.onConnectionFailed(connectionResult3);
                    return;
                } else if (i2 == 5) {
                    BaseGmsClient baseGmsClient3 = this.zza;
                    connectionResult = baseGmsClient3.zzB;
                    ConnectionResult connectionResult4 = connectionResult != null ? baseGmsClient3.zzB : new ConnectionResult(8);
                    this.zza.zzc.onReportServiceBinding(connectionResult4);
                    this.zza.onConnectionFailed(connectionResult4);
                    return;
                } else if (i2 == 3) {
                    Object obj = message.obj;
                    ConnectionResult connectionResult5 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
                    this.zza.zzc.onReportServiceBinding(connectionResult5);
                    this.zza.onConnectionFailed(connectionResult5);
                    return;
                } else if (i2 == 6) {
                    this.zza.zzp(5, null);
                    BaseGmsClient baseGmsClient4 = this.zza;
                    baseConnectionCallbacks = baseGmsClient4.zzw;
                    if (baseConnectionCallbacks != null) {
                        baseConnectionCallbacks2 = baseGmsClient4.zzw;
                        baseConnectionCallbacks2.onConnectionSuspended(message.arg2);
                    }
                    this.zza.onConnectionSuspended(message.arg2);
                    BaseGmsClient.zzn(this.zza, 5, 1, null);
                    return;
                } else if (i2 == 2 && !this.zza.isConnected()) {
                    zza(message);
                    return;
                } else if (zzb(message)) {
                    ((zzc) message.obj).zze();
                    return;
                } else {
                    int i3 = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i3);
                    Log.wtf("GmsClient", sb.toString(), new Exception());
                    return;
                }
            }
            zza(message);
        }
    }
}

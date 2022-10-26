package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
/* loaded from: classes7.dex */
public final class zzf extends zza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IBinder zze;
    public final /* synthetic */ BaseGmsClient zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(BaseGmsClient baseGmsClient, int i, IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, i, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseGmsClient, Integer.valueOf(i), iBinder, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseGmsClient) objArr2[0], ((Integer) objArr2[1]).intValue(), (Bundle) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zzf = baseGmsClient;
        this.zze = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, connectionResult) == null) {
            if (this.zzf.zzx != null) {
                this.zzf.zzx.onConnectionFailed(connectionResult);
            }
            this.zzf.onConnectionFailed(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.internal.zza
    public final boolean zzd() {
        InterceptResult invokeV;
        BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks;
        BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                IBinder iBinder = this.zze;
                Preconditions.checkNotNull(iBinder);
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if (!this.zzf.getServiceDescriptor().equals(interfaceDescriptor)) {
                    String serviceDescriptor = this.zzf.getServiceDescriptor();
                    StringBuilder sb = new StringBuilder(String.valueOf(serviceDescriptor).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(serviceDescriptor);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.w("GmsClient", sb.toString());
                    return false;
                }
                IInterface createServiceInterface = this.zzf.createServiceInterface(this.zze);
                if (createServiceInterface == null || (!BaseGmsClient.zzn(this.zzf, 2, 4, createServiceInterface) && !BaseGmsClient.zzn(this.zzf, 3, 4, createServiceInterface))) {
                    return false;
                }
                this.zzf.zzB = null;
                Bundle connectionHint = this.zzf.getConnectionHint();
                BaseGmsClient baseGmsClient = this.zzf;
                baseConnectionCallbacks = baseGmsClient.zzw;
                if (baseConnectionCallbacks != null) {
                    baseConnectionCallbacks2 = baseGmsClient.zzw;
                    baseConnectionCallbacks2.onConnected(connectionHint);
                    return true;
                }
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}

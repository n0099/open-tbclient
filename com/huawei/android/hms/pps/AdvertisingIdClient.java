package com.huawei.android.hms.pps;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.android.hms.pps.a.a;
import com.huawei.android.hms.pps.a.b;
import java.io.IOException;
@Keep
/* loaded from: classes6.dex */
public class AdvertisingIdClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes6.dex */
    public static final class Info {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String advertisingId;
        public final boolean limitAdTrackingEnabled;

        public Info(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        @Keep
        public final String getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.advertisingId : (String) invokeV.objValue;
        }

        @Keep
        public final boolean isLimitAdTrackingEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.limitAdTrackingEnabled : invokeV.booleanValue;
        }
    }

    public AdvertisingIdClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Keep
    public static Info getAdvertisingIdInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String tag = getTag();
            Log.i(tag, "getAdvertisingIdInfo " + System.currentTimeMillis());
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Log.w(getTag(), "Cannot be called from the main thread");
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            try {
                context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
                a aVar = new a();
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage("com.huawei.hwid");
                if (!context.bindService(intent, aVar, 1)) {
                    Log.w(getTag(), "bind failed");
                    throw new IOException("bind failed");
                }
                Log.i(getTag(), "bind ok");
                try {
                    try {
                        if (aVar.f33776a) {
                            throw new IllegalStateException();
                        }
                        aVar.f33776a = true;
                        b.a.C0398a c0398a = new b.a.C0398a(aVar.f33777b.take());
                        return new Info(c0398a.a(), c0398a.b());
                    } finally {
                        context.unbindService(aVar);
                    }
                } catch (RemoteException unused) {
                    Log.e(getTag(), "bind hms service RemoteException");
                    throw new IOException("bind hms service RemoteException");
                } catch (InterruptedException unused2) {
                    Log.e(getTag(), "bind hms service InterruptedException");
                    throw new IOException("bind hms service InterruptedException");
                }
            } catch (PackageManager.NameNotFoundException unused3) {
                Log.w(getTag(), "HMS not found");
                throw new IOException("Service not found");
            }
        }
        return (Info) invokeL.objValue;
    }

    public static String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "AdId" : (String) invokeV.objValue;
    }
}

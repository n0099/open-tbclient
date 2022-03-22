package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.ads.identifier.aidl.OpenDeviceIdentifierService;
import java.io.IOException;
@Keep
/* loaded from: classes7.dex */
public class AdvertisingIdClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SETTINGS_AD_ID = "pps_oaid";
    public static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes7.dex */
    public static final class Info {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String advertisingId;
        public final boolean limitAdTrackingEnabled;

        @Keep
        public Info(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        @Keep
        public String getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.advertisingId : (String) invokeV.objValue;
        }

        @Keep
        public boolean isLimitAdTrackingEnabled() {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Keep
    public static Info getAdvertisingIdInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    String string = Settings.Global.getString(context.getContentResolver(), SETTINGS_AD_ID);
                    String string2 = Settings.Global.getString(context.getContentResolver(), SETTINGS_TRACK_LIMIT);
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        updateAdvertisingIdInfo(context);
                        return new Info(string, Boolean.valueOf(string2).booleanValue());
                    }
                } catch (Throwable unused) {
                }
            }
            return requestAdvertisingIdInfo(context);
        }
        return (Info) invokeL.objValue;
    }

    @Keep
    public static boolean isAdvertisingIdAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                packageManager.getPackageInfo(b.a(context), 128);
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage(b.a(context));
                return !packageManager.queryIntentServices(intent, 0).isEmpty();
            } catch (PackageManager.NameNotFoundException | Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static Info requestAdvertisingIdInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                context.getPackageManager().getPackageInfo(b.a(context), 128);
                a aVar = new a();
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage(b.a(context));
                try {
                    if (context.bindService(intent, aVar, 1)) {
                        try {
                            try {
                                OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(aVar.a());
                                Info info = new Info(asInterface.getOaid(), asInterface.isOaidTrackLimited());
                                try {
                                    context.unbindService(aVar);
                                } catch (Throwable th) {
                                    Log.w("AdIdClient", "unbind " + th.getClass().getSimpleName());
                                }
                                return info;
                            } catch (InterruptedException unused) {
                                throw new IOException("bind hms service InterruptedException");
                            }
                        } catch (RemoteException unused2) {
                            throw new IOException("bind hms service RemoteException");
                        }
                    }
                    throw new IOException("bind failed");
                } catch (Throwable th2) {
                    try {
                        context.unbindService(aVar);
                    } catch (Throwable th3) {
                        Log.w("AdIdClient", "unbind " + th3.getClass().getSimpleName());
                    }
                    throw th2;
                }
            } catch (PackageManager.NameNotFoundException unused3) {
                throw new IOException("Service not found");
            }
        }
        return (Info) invokeL.objValue;
    }

    public static void updateAdvertisingIdInfo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            c.a.execute(new Runnable(context) { // from class: com.huawei.hms.ads.identifier.AdvertisingIdClient.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            AdvertisingIdClient.requestAdvertisingIdInfo(this.a);
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        }
    }

    @Keep
    public static boolean verifyAdId(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, context, str, z)) == null) {
            Info requestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
            if (requestAdvertisingIdInfo != null) {
                return TextUtils.equals(str, requestAdvertisingIdInfo.getId()) && z == requestAdvertisingIdInfo.isLimitAdTrackingEnabled();
            }
            Log.w("AdIdClient", "info is null");
            return false;
        }
        return invokeLLZ.booleanValue;
    }
}

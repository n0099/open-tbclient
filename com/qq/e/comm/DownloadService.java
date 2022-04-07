package com.qq.e.comm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes5.dex */
public class DownloadService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SVSD a;

    public DownloadService() {
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

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.a == null) {
                try {
                    if (GDTADManager.getInstance().isInitialized()) {
                        SVSD aPKDownloadServiceDelegate = GDTADManager.getInstance().getPM().getPOFactory().getAPKDownloadServiceDelegate(this);
                        this.a = aPKDownloadServiceDelegate;
                        aPKDownloadServiceDelegate.onCreate();
                    }
                } catch (Throwable th) {
                    GDTLogger.e("初始化Service发生异常", th);
                }
            }
            return this.a != null;
        }
        return invokeV.booleanValue;
    }

    public static void enterAPPDownloadListPage(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (context == null) {
                GDTLogger.e("enterAPPDownloadListPage 调用异常，context为空");
                return;
            }
            Intent intent = new Intent(context, DownloadService.class);
            intent.putExtra("GDT_APPID", GDTADManager.getInstance().getAppStatus().getAPPID());
            intent.setAction("com.qq.e.comm.ACTION_DOWNLOAD_LIST");
            context.startService(intent);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            GDTLogger.d("DownloadService.onBind");
            SVSD svsd = this.a;
            if (svsd != null) {
                return svsd.onBind(intent);
            }
            String stringExtra = intent.getStringExtra("GDT_APPID");
            GDTLogger.d("DownloadService.onBind,appID=" + stringExtra);
            if (TextUtils.isEmpty(stringExtra) || !a()) {
                return null;
            }
            return this.a.onBind(intent);
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configuration) == null) || (svsd = this.a) == null) {
            return;
        }
        svsd.onConfigurationChanged(configuration);
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        SVSD svsd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (svsd = this.a) == null) {
            return;
        }
        svsd.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (svsd = this.a) == null) {
            return;
        }
        svsd.onLowMemory();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, intent) == null) || (svsd = this.a) == null) {
            return;
        }
        svsd.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, intent, i, i2)) == null) {
            if (intent == null) {
                stopSelf(i2);
                return 2;
            } else if (TextUtils.isEmpty(intent.getStringExtra("GDT_APPID")) || !a()) {
                GDTLogger.w("Service onStartCommand 出现异常");
                return 2;
            } else {
                return this.a.onStartCommand(intent, i, i2);
            }
        }
        return invokeLII.intValue;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, intent) == null) || (svsd = this.a) == null) {
            return;
        }
        svsd.onTaskRemoved(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        SVSD svsd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (svsd = this.a) == null) {
            return;
        }
        svsd.onTrimMemory(i);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, intent)) == null) {
            SVSD svsd = this.a;
            return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
        }
        return invokeL.booleanValue;
    }
}

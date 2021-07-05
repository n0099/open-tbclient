package com.qq.e.comm;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
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
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes7.dex */
public class DownloadService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SVSD f40913a;

    public DownloadService() {
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

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (this.f40913a == null) {
                try {
                    if (GDTADManager.getInstance().initWith(getApplicationContext(), str)) {
                        SVSD aPKDownloadServiceDelegate = GDTADManager.getInstance().getPM().getPOFactory().getAPKDownloadServiceDelegate(this);
                        this.f40913a = aPKDownloadServiceDelegate;
                        aPKDownloadServiceDelegate.onCreate();
                    } else {
                        GDTLogger.report("Init GDTADManager fail in DownloadService.oncreate");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return this.f40913a != null;
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            GDTLogger.d("DownloadService.onBind");
            SVSD svsd = this.f40913a;
            if (svsd != null) {
                return svsd.onBind(intent);
            }
            String stringExtra = intent.getStringExtra("GDT_APPID");
            GDTLogger.d("DownloadService.onBind,appID=" + stringExtra);
            if (StringUtil.isEmpty(stringExtra) || !a(stringExtra)) {
                return null;
            }
            return this.f40913a.onBind(intent);
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configuration) == null) || (svsd = this.f40913a) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (svsd = this.f40913a) == null) {
            return;
        }
        svsd.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (svsd = this.f40913a) == null) {
            return;
        }
        svsd.onLowMemory();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, intent) == null) || (svsd = this.f40913a) == null) {
            return;
        }
        svsd.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, intent, i2, i3)) == null) {
            if (intent == null) {
                stopSelf(i3);
                return 2;
            }
            String stringExtra = intent.getStringExtra("GDT_APPID");
            if (StringUtil.isEmpty(stringExtra) || !a(stringExtra)) {
                GDTLogger.w("Failto Start new download Service");
                return 2;
            }
            return this.f40913a.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, intent) == null) || (svsd = this.f40913a) == null) {
            return;
        }
        svsd.onTaskRemoved(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        SVSD svsd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (svsd = this.f40913a) == null) {
            return;
        }
        svsd.onTrimMemory(i2);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, intent)) == null) {
            SVSD svsd = this.f40913a;
            return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
        }
        return invokeL.booleanValue;
    }
}

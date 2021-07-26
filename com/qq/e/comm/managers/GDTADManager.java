package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GDTADManager {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService INIT_EXECUTOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile Boolean f38148a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f38149b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SM f38150c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PM f38151d;

    /* renamed from: e  reason: collision with root package name */
    public volatile DevTools f38152e;

    /* renamed from: f  reason: collision with root package name */
    public volatile APPStatus f38153f;

    /* renamed from: g  reason: collision with root package name */
    public volatile DeviceStatus f38154g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f38155h;

    /* renamed from: i  reason: collision with root package name */
    public PM.a.InterfaceC0480a f38156i;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static GDTADManager f38159a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(876102630, "Lcom/qq/e/comm/managers/GDTADManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(876102630, "Lcom/qq/e/comm/managers/GDTADManager$a;");
                    return;
                }
            }
            f38159a = new GDTADManager((byte) 0);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-562216189, "Lcom/qq/e/comm/managers/GDTADManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-562216189, "Lcom/qq/e/comm/managers/GDTADManager;");
                return;
            }
        }
        INIT_EXECUTOR = Executors.newSingleThreadExecutor();
    }

    public GDTADManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38148a = Boolean.FALSE;
    }

    public /* synthetic */ GDTADManager(byte b2) {
        this();
    }

    public static /* synthetic */ void a(GDTADManager gDTADManager, long j) {
        com.qq.e.comm.a.a.a().a(gDTADManager.f38149b, gDTADManager.f38150c, gDTADManager.f38151d, gDTADManager.f38154g, gDTADManager.f38153f, j);
    }

    public static GDTADManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.f38159a : (GDTADManager) invokeV.objValue;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (isInitialized()) {
                JSONObject a2 = com.qq.e.comm.net.a.a(this.f38150c);
                a2.put("app", com.qq.e.comm.net.a.a(this.f38153f));
                a2.put("c", com.qq.e.comm.net.a.a(this.f38154g));
                a2.put("sdk", com.qq.e.comm.net.a.a(this.f38151d));
                return a2;
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String getADActivityClazz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? CustomPkgConstants.getADActivityName() : (String) invokeV.objValue;
    }

    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38149b : (Context) invokeV.objValue;
    }

    public APPStatus getAppStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38153f : (APPStatus) invokeV.objValue;
    }

    public DevTools getDevTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f38152e == null) {
                this.f38152e = new DevTools();
            }
            return this.f38152e;
        }
        return (DevTools) invokeV.objValue;
    }

    public DeviceStatus getDeviceStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38154g : (DeviceStatus) invokeV.objValue;
    }

    public String getDownLoadClazz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? CustomPkgConstants.getDownLoadServiceName() : (String) invokeV.objValue;
    }

    public String getLandscapeADActivityClazz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? CustomPkgConstants.getLandscapeADActivityName() : (String) invokeV.objValue;
    }

    public PM getPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f38151d : (PM) invokeV.objValue;
    }

    public String getPortraitADActivityClazz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? CustomPkgConstants.getPortraitADActivityName() : (String) invokeV.objValue;
    }

    public String getProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f38155h : (String) invokeV.objValue;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? CustomPkgConstants.getRewardvideoLandscapeADActivityName() : (String) invokeV.objValue;
    }

    public String getRewardvideoPortraitADActivityClazz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? CustomPkgConstants.getRewardvideoPortraitADActivityName() : (String) invokeV.objValue;
    }

    public SM getSM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f38150c : (SM) invokeV.objValue;
    }

    public synchronized boolean initWith(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, context, str)) == null) {
            synchronized (this) {
                if (Build.VERSION.SDK_INT < 14) {
                    GDTLogger.e("system version not support !");
                    return false;
                } else if (this.f38148a.booleanValue()) {
                    return true;
                } else {
                    if (context == null || StringUtil.isEmpty(str)) {
                        GDTLogger.e("Context And APPID should Never Be NULL while init GDTADManager");
                        return false;
                    }
                    long nanoTime = System.nanoTime();
                    this.f38155h = SystemUtil.getProcessName(context);
                    this.f38149b = context.getApplicationContext();
                    this.f38150c = new SM(this.f38149b);
                    this.f38151d = new PM(this.f38149b, this.f38156i);
                    this.f38153f = new APPStatus(str, this.f38149b);
                    this.f38154g = new DeviceStatus(this.f38149b);
                    if (Build.VERSION.SDK_INT > 7) {
                        new Thread(this, "GDT_ACTIVATE_LAUNCH", nanoTime) { // from class: com.qq.e.comm.managers.GDTADManager.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public /* synthetic */ long f38157a;

                            /* renamed from: b  reason: collision with root package name */
                            public /* synthetic */ GDTADManager f38158b;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r8);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r8, Long.valueOf(nanoTime)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        super((String) newInitContext.callArgs[0]);
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f38158b = this;
                                this.f38157a = nanoTime;
                            }

                            @Override // java.lang.Thread, java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    super.run();
                                    GDTADManager.a(this.f38158b, this.f38157a);
                                }
                            }
                        }.start();
                    }
                    this.f38148a = Boolean.TRUE;
                    return true;
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f38148a == null) {
                return false;
            }
            return this.f38148a.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public void setPluginLoadListener(PM.a.InterfaceC0480a interfaceC0480a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, interfaceC0480a) == null) {
            this.f38156i = interfaceC0480a;
        }
    }
}

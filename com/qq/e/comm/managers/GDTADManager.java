package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SystemUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes10.dex */
public class GDTADManager implements IGDTAdManager {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService INIT_EXECUTOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile Boolean f75308a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f75309b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SM f75310c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PM f75311d;

    /* renamed from: e  reason: collision with root package name */
    public volatile DevTools f75312e;

    /* renamed from: f  reason: collision with root package name */
    public volatile APPStatus f75313f;

    /* renamed from: g  reason: collision with root package name */
    public volatile DeviceStatus f75314g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f75315h;

    /* renamed from: i  reason: collision with root package name */
    public PM.a.InterfaceC2043a f75316i;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static GDTADManager f75319a;
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
            f75319a = new GDTADManager((byte) 0);
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
        this.f75308a = Boolean.FALSE;
    }

    public /* synthetic */ GDTADManager(byte b2) {
        this();
    }

    public static /* synthetic */ void a(GDTADManager gDTADManager, long j2) {
        com.qq.e.comm.a.a.a().a(gDTADManager.f75309b, gDTADManager.f75310c, gDTADManager.f75311d, gDTADManager.f75314g, gDTADManager.f75313f, j2);
    }

    public static GDTADManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.f75319a : (GDTADManager) invokeV.objValue;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (isInitialized()) {
                JSONObject a2 = com.qq.e.comm.net.a.a(this.f75310c);
                a2.put("app", com.qq.e.comm.net.a.a(this.f75313f));
                a2.put("c", com.qq.e.comm.net.a.a(this.f75314g));
                a2.put("sdk", com.qq.e.comm.net.a.a(this.f75311d));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f75309b : (Context) invokeV.objValue;
    }

    public APPStatus getAppStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f75313f : (APPStatus) invokeV.objValue;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (isInitialized()) {
                try {
                    return this.f75311d.getPOFactory().getBuyerId();
                } catch (Exception e2) {
                    GDTLogger.e("SDK 初始化异常", e2);
                    return "";
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f75312e == null) {
                this.f75312e = new DevTools();
            }
            return this.f75312e;
        }
        return (DevTools) invokeV.objValue;
    }

    public DeviceStatus getDeviceStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f75314g : (DeviceStatus) invokeV.objValue;
    }

    public String getDownLoadClazz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? CustomPkgConstants.getDownLoadServiceName() : (String) invokeV.objValue;
    }

    public String getLandscapeADActivityClazz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? CustomPkgConstants.getLandscapeADActivityName() : (String) invokeV.objValue;
    }

    public PM getPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f75311d : (PM) invokeV.objValue;
    }

    public String getPortraitADActivityClazz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? CustomPkgConstants.getPortraitADActivityName() : (String) invokeV.objValue;
    }

    public String getProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f75315h : (String) invokeV.objValue;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? CustomPkgConstants.getRewardvideoLandscapeADActivityName() : (String) invokeV.objValue;
    }

    public String getRewardvideoPortraitADActivityClazz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? CustomPkgConstants.getRewardvideoPortraitADActivityName() : (String) invokeV.objValue;
    }

    public SM getSM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f75310c : (SM) invokeV.objValue;
    }

    public synchronized boolean initWith(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, context, str)) == null) {
            synchronized (this) {
                if (Build.VERSION.SDK_INT < 14) {
                    GDTLogger.e("GDTADManager初始化错误，SDK不支持Android 4.0以下版本");
                    return false;
                } else if (this.f75308a.booleanValue()) {
                    return true;
                } else {
                    if (context == null || TextUtils.isEmpty(str)) {
                        GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
                        return false;
                    }
                    long nanoTime = System.nanoTime();
                    this.f75315h = SystemUtil.getProcessName(context);
                    this.f75309b = context.getApplicationContext();
                    this.f75310c = new SM(this.f75309b);
                    this.f75311d = new PM(this.f75309b, this.f75316i);
                    this.f75313f = new APPStatus(str, this.f75309b);
                    this.f75314g = new DeviceStatus(this.f75309b);
                    if (Build.VERSION.SDK_INT > 7) {
                        new Thread(this, "GDT_ACTIVATE_LAUNCH", nanoTime) { // from class: com.qq.e.comm.managers.GDTADManager.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public /* synthetic */ long f75317a;

                            /* renamed from: b  reason: collision with root package name */
                            public /* synthetic */ GDTADManager f75318b;

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
                                this.f75318b = this;
                                this.f75317a = nanoTime;
                            }

                            @Override // java.lang.Thread, java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    super.run();
                                    GDTADManager.a(this.f75318b, this.f75317a);
                                }
                            }
                        }.start();
                    }
                    this.f75308a = Boolean.TRUE;
                    return true;
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.f75308a == null || !this.f75308a.booleanValue()) {
                GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.init() 初始化");
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setPluginLoadListener(PM.a.InterfaceC2043a interfaceC2043a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, interfaceC2043a) == null) {
            this.f75316i = interfaceC2043a;
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, gDTAppDialogClickListener)) == null) {
            if (isInitialized()) {
                try {
                    return this.f75311d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
                } catch (Exception e2) {
                    GDTLogger.e("SDK 初始化异常", e2);
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }
}

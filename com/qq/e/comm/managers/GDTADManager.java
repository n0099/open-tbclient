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
import com.qq.e.comm.managers.plugin.e;
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
/* loaded from: classes3.dex */
public class GDTADManager implements IGDTAdManager {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService INIT_EXECUTOR;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Boolean a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f59060b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SM f59061c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PM f59062d;

    /* renamed from: e  reason: collision with root package name */
    public volatile DevTools f59063e;

    /* renamed from: f  reason: collision with root package name */
    public volatile APPStatus f59064f;

    /* renamed from: g  reason: collision with root package name */
    public volatile DeviceStatus f59065g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f59066h;

    /* renamed from: i  reason: collision with root package name */
    public e f59067i;

    /* loaded from: classes3.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GDTADManager f59068b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GDTADManager gDTADManager, String str, long j2) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gDTADManager, str, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59068b = gDTADManager;
            this.a = j2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.run();
                GDTADManager.a(this.f59068b, this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static GDTADManager a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(876102661, "Lcom/qq/e/comm/managers/GDTADManager$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(876102661, "Lcom/qq/e/comm/managers/GDTADManager$b;");
                    return;
                }
            }
            a = new GDTADManager(null);
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
        this.a = Boolean.FALSE;
    }

    public /* synthetic */ GDTADManager(a aVar) {
        this();
    }

    private void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, str) == null) {
            long nanoTime = System.nanoTime();
            this.f59066h = SystemUtil.getProcessName(context);
            this.f59060b = context.getApplicationContext();
            this.f59061c = new SM(this.f59060b);
            this.f59062d = new PM(this.f59060b, this.f59067i);
            this.f59064f = new APPStatus(str, this.f59060b);
            this.f59065g = new DeviceStatus(this.f59060b);
            if (Build.VERSION.SDK_INT > 7) {
                new a(this, "GDT_ACTIVATE_LAUNCH", nanoTime).start();
            }
        }
    }

    public static void a(GDTADManager gDTADManager, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, gDTADManager, j2) == null) {
            if (gDTADManager == null) {
                throw null;
            }
            com.qq.e.comm.b.a.a().a(gDTADManager.f59060b, gDTADManager.f59061c, gDTADManager.f59062d, gDTADManager.f59065g, gDTADManager.f59064f, j2);
        }
    }

    public static GDTADManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? b.a : (GDTADManager) invokeV.objValue;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (isInitialized()) {
                SM sm = this.f59061c;
                JSONObject jSONObject = new JSONObject();
                if (sm != null) {
                    jSONObject.putOpt("suid", sm.getSuid());
                    jSONObject.putOpt("sid", sm.getSid());
                }
                jSONObject.put("app", com.qq.e.comm.net.a.a(this.f59064f));
                jSONObject.put("c", com.qq.e.comm.net.a.a(this.f59065g));
                jSONObject.put("sdk", com.qq.e.comm.net.a.a(this.f59062d));
                return jSONObject;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59060b : (Context) invokeV.objValue;
    }

    public APPStatus getAppStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59064f : (APPStatus) invokeV.objValue;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (isInitialized()) {
                try {
                    return this.f59062d.getPOFactory().getBuyerId();
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
            if (this.f59063e == null) {
                this.f59063e = new DevTools();
            }
            return this.f59063e;
        }
        return (DevTools) invokeV.objValue;
    }

    public DeviceStatus getDeviceStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59065g : (DeviceStatus) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f59062d : (PM) invokeV.objValue;
    }

    public String getPortraitADActivityClazz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? CustomPkgConstants.getPortraitADActivityName() : (String) invokeV.objValue;
    }

    public String getProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f59066h : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f59061c : (SM) invokeV.objValue;
    }

    public synchronized boolean initWith(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, context, str)) == null) {
            synchronized (this) {
                if (Build.VERSION.SDK_INT < 14) {
                    GDTLogger.e("GDTADManager初始化错误，SDK不支持Android 4.0以下版本");
                    return false;
                } else if (this.a.booleanValue()) {
                    return true;
                } else {
                    if (context == null || TextUtils.isEmpty(str)) {
                        GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
                        return false;
                    }
                    a(context, str);
                    this.a = Boolean.TRUE;
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
            if (this.a == null || !this.a.booleanValue()) {
                GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.init() 初始化");
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setPluginLoadListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.f59067i = eVar;
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, gDTAppDialogClickListener)) == null) {
            if (isInitialized()) {
                try {
                    return this.f59062d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
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

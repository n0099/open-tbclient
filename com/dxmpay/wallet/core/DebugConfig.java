package com.dxmpay.wallet.core;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.f.b.b.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.RestDebugConfig;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes3.dex */
public final class DebugConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONFIG_FILE = "dxm_wallet_config.properties";
    public static String DEFAULT_ENVIRONMENT = "ONLINE";
    public static final String ENVIRONMENT_ONLINE = "ONLINE";
    public static final String ENVIRONMENT_PRELINE = "PRELINE";
    public static final String ENVIRONMENT_QA = "QA";
    public static final String ENVIRONMENT_RD = "RD";
    public static final String PASS_COMPLETE_VERIFY = "pass_complete_verify";
    public static final String SERVER_COMPLETE_VERIFY = "http://wappass.baidu.com/v2/?bindingret";
    public static final String SERVICE = "service";
    public static final String VOICE_API_HOST_DFT = "https://wallet.baidu.com";
    public static final String VOICE_SERVICE_URL_DFT = "https://wallet.baidu.com";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f53977c = false;

    /* renamed from: d  reason: collision with root package name */
    public static String f53978d = "https://www.baifubao.com";

    /* renamed from: e  reason: collision with root package name */
    public static String f53979e = "http://wappass.baidu.com/passport";

    /* renamed from: f  reason: collision with root package name */
    public static String f53980f = "https://chong.baidu.com";

    /* renamed from: g  reason: collision with root package name */
    public static String f53981g = "https://wallet.baidu.com";

    /* renamed from: h  reason: collision with root package name */
    public static String f53982h = "https://wallet.baidu.com";

    /* renamed from: i  reason: collision with root package name */
    public static String f53983i = "https://wallet.baidu.com";

    /* renamed from: j  reason: collision with root package name */
    public static String f53984j = "https://www.baifubao.com";
    public static String k = "https://www.baifubao.com";
    public static String l = "https://www.baifubao.com";
    public static String m = "https://datasink.dxmpay.com";
    public static String n = "https://www.baifubao.com/wireless/0/config?cate[plugin]&_app=wallet";
    public static DebugConfig o;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;

    /* renamed from: b  reason: collision with root package name */
    public Properties f53985b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(160037222, "Lcom/dxmpay/wallet/core/DebugConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(160037222, "Lcom/dxmpay/wallet/core/DebugConfig;");
        }
    }

    public DebugConfig(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        if (context != null && context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
            File externalFilesDir = context.getExternalFilesDir("");
            if (externalFilesDir != null && !externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            this.a = new File(externalFilesDir, CONFIG_FILE);
        } else {
            this.a = new File(String.valueOf(Environment.getExternalStorageDirectory()), CONFIG_FILE);
        }
        this.f53985b = c();
    }

    public static synchronized DebugConfig getInstance(Context context) {
        InterceptResult invokeL;
        DebugConfig debugConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (DebugConfig.class) {
                if (o == null) {
                    o = new DebugConfig(context);
                }
                debugConfig = o;
            }
            return debugConfig;
        }
        return (DebugConfig) invokeL.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Properties c2 = c();
            this.f53985b = c2;
            return c2.getProperty(str);
        }
        return (String) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a().b(a("app_host"));
            c.a().c(a(com.baidu.wallet.core.domain.c.r));
            c.a().f(a("app_spare_pay_host"));
            c.a().d(a(com.baidu.wallet.core.domain.c.v));
            c.a().e(a("rtc_host"));
            DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA);
            String a = a(com.baidu.wallet.core.DebugConfig.k);
            f53984j = a;
            if (TextUtils.isEmpty(a)) {
                f53984j = "https://www.baifubao.com";
            }
            String a2 = a(com.baidu.wallet.core.DebugConfig.l);
            k = a2;
            if (TextUtils.isEmpty(a2)) {
                k = "https://www.baifubao.com";
            }
            String a3 = a(com.baidu.wallet.core.DebugConfig.m);
            m = a3;
            if (TextUtils.isEmpty(a3)) {
                m = "https://datasink.dxmpay.com";
            }
        }
    }

    public final Properties c() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Properties properties = new Properties();
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(this.a);
                } catch (IOException unused) {
                }
                try {
                    properties.load(fileInputStream);
                    fileInputStream.close();
                } catch (Exception unused2) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return properties;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
            return properties;
        }
        return (Properties) invokeV.objValue;
    }

    public void changeOnline() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f53977c = false;
            f53978d = "https://www.baifubao.com";
            f53979e = "https://wappass.baidu.com/passport/";
            f53980f = "https://chong.baidu.com";
            f53981g = "https://wallet.baidu.com";
            DEFAULT_ENVIRONMENT = "ONLINE";
            f53982h = "https://wallet.baidu.com";
            f53983i = "https://wallet.baidu.com";
            f53984j = "https://www.baifubao.com";
            k = "https://www.baifubao.com";
            l = "https://www.baifubao.com";
        }
    }

    public void changeQA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f53977c = true;
            DEFAULT_ENVIRONMENT = "QA";
            readConfigHost(true);
        }
    }

    public String getCouponHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? f53981g : (String) invokeV.objValue;
    }

    public String getEnvironment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (f53977c) {
                return a(com.baidu.wallet.core.DebugConfig.f50955e);
            }
            return DEFAULT_ENVIRONMENT;
        }
        return (String) invokeV.objValue;
    }

    public String getFixedWalletHttpsHostForH5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "https://www.baifubao.com" : (String) invokeV.objValue;
    }

    public String getProperty(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            if (!f53977c) {
                String str3 = "没有打开DEBUG开关 返回默认值=" + str2;
                return str2;
            }
            String a = a(str);
            if (TextUtils.isEmpty(a)) {
                String str4 = "配置文件没有配置 返回默认值=" + str2;
                return str2;
            }
            String str5 = "返回配置文件的值 value=" + a;
            return a;
        }
        return (String) invokeLL.objValue;
    }

    public String getSenorStatisticsHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? m : (String) invokeV.objValue;
    }

    public String getStatisticsHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (isOnline()) {
                return DomainConfig.getInstance().getAppHost();
            }
            return f53984j;
        }
        return (String) invokeV.objValue;
    }

    public String getVoiceprintHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? f53983i : (String) invokeV.objValue;
    }

    public String getVoiceprintServiceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? f53982h : (String) invokeV.objValue;
    }

    public String getWalletHttpsHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? f53978d : (String) invokeV.objValue;
    }

    public String getWalletNfcHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? f53980f : (String) invokeV.objValue;
    }

    public String getWalletPassportHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? f53979e : (String) invokeV.objValue;
    }

    public String getWalletPluginHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? n : (String) invokeV.objValue;
    }

    public String getWebCacheHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? l : (String) invokeV.objValue;
    }

    public boolean isOnline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? "ONLINE".equals(getEnvironment()) : invokeV.booleanValue;
    }

    public void readConfigHost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            f53977c = z;
            if (z) {
                b();
            } else {
                f53978d = "https://www.baifubao.com";
                f53979e = "https://wappass.baidu.com/passport/";
                n = "https://www.baifubao.com/wireless/0/config?cate[plugin]&_app=wallet";
                f53980f = "https://chong.baidu.com";
                f53981g = "https://wallet.baidu.com";
                f53982h = "https://wallet.baidu.com";
                f53983i = "https://wallet.baidu.com";
                f53984j = "https://www.baifubao.com";
                k = "https://www.baifubao.com";
                l = "https://www.baifubao.com";
                m = "https://datasink.dxmpay.com";
            }
            RestDebugConfig.getInstance().setQAEnv(z);
        }
    }

    public void setWalletHttpsHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            f53978d = str;
        }
    }

    public static synchronized DebugConfig getInstance() {
        InterceptResult invokeV;
        DebugConfig debugConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (DebugConfig.class) {
                if (o == null) {
                    o = new DebugConfig(null);
                }
                debugConfig = o;
            }
            return debugConfig;
        }
        return (DebugConfig) invokeV.objValue;
    }
}

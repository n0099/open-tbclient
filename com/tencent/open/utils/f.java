package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, f> f39007a;

    /* renamed from: b  reason: collision with root package name */
    public static String f39008b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f39009c;

    /* renamed from: d  reason: collision with root package name */
    public String f39010d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f39011e;

    /* renamed from: f  reason: collision with root package name */
    public long f39012f;

    /* renamed from: g  reason: collision with root package name */
    public int f39013g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39014h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2036590924, "Lcom/tencent/open/utils/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2036590924, "Lcom/tencent/open/utils/f;");
                return;
            }
        }
        f39007a = Collections.synchronizedMap(new HashMap());
        f39008b = null;
    }

    public f(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39009c = null;
        this.f39010d = null;
        this.f39011e = null;
        this.f39012f = 0L;
        this.f39013g = 0;
        this.f39014h = true;
        this.f39009c = context.getApplicationContext();
        this.f39010d = str;
        a();
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (this.f39013g != 0) {
                d("update thread is running, return");
                return;
            }
            this.f39013g = 1;
            Bundle bundle = new Bundle();
            bundle.putString("appid", this.f39010d);
            bundle.putString("appid_for_getting_config", this.f39010d);
            bundle.putString("status_os", Build.VERSION.RELEASE);
            bundle.putString("status_machine", Build.MODEL);
            bundle.putString("status_version", Build.VERSION.SDK);
            bundle.putString("sdkv", Constants.SDK_VERSION);
            bundle.putString("sdkp", "a");
            new Thread(this, bundle) { // from class: com.tencent.open.utils.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Bundle f39015a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f39016b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bundle};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39016b = this;
                    this.f39015a = bundle;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f39016b.a(j.d(HttpUtils.openUrl2(this.f39016b.f39009c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", this.f39015a).f39034a));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        this.f39016b.f39013g = 0;
                    }
                }
            }.start();
        }
    }

    private String c(String str) {
        InterceptResult invokeL;
        InputStream open;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            String str3 = "";
            try {
                try {
                    if (this.f39010d != null) {
                        str2 = str + "." + this.f39010d;
                    } else {
                        str2 = str;
                    }
                    open = this.f39009c.openFileInput(str2);
                } catch (FileNotFoundException unused) {
                    open = this.f39009c.getAssets().open(str);
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charset.forName("UTF-8")));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    try {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            } catch (Throwable th) {
                                try {
                                    open.close();
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                throw th;
                            }
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            open.close();
                            bufferedReader.close();
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                str3 = stringBuffer.toString();
                open.close();
                bufferedReader.close();
                return str3;
            } catch (IOException e5) {
                e5.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, this, str) == null) && this.f39014h) {
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", str + "; appid: " + this.f39010d);
        }
    }

    public static f a(Context context, String str) {
        InterceptResult invokeLL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            synchronized (f39007a) {
                com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", "getInstance begin");
                if (str != null) {
                    f39008b = str;
                }
                if (str == null) {
                    str = f39008b != null ? f39008b : "0";
                }
                fVar = f39007a.get(str);
                if (fVar == null) {
                    fVar = new f(context, str);
                    f39007a.put(str, fVar);
                }
                com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", "getInstance end");
            }
            return fVar;
        }
        return (f) invokeLL.objValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            d("get " + str);
            c();
            Object opt = this.f39011e.opt(str);
            if (opt == null) {
                return false;
            }
            if (opt instanceof Integer) {
                return !opt.equals(0);
            }
            if (opt instanceof Boolean) {
                return ((Boolean) opt).booleanValue();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            try {
                this.f39011e = new JSONObject(c("com.tencent.open.config.json"));
            } catch (JSONException unused) {
                this.f39011e = new JSONObject();
            }
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, str2) == null) {
            try {
                if (this.f39010d != null) {
                    str = str + "." + this.f39010d;
                }
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f39009c.openFileOutput(str, 0), Charset.forName("UTF-8"));
                outputStreamWriter.write(str2);
                outputStreamWriter.flush();
                outputStreamWriter.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            int optInt = this.f39011e.optInt("Common_frequency");
            if (optInt == 0) {
                optInt = 1;
            }
            if (SystemClock.elapsedRealtime() - this.f39012f >= optInt * 3600000) {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, jSONObject) == null) {
            d("cgi back, do update");
            this.f39011e = jSONObject;
            a("com.tencent.open.config.json", jSONObject.toString());
            this.f39012f = SystemClock.elapsedRealtime();
        }
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            d("get " + str);
            c();
            return this.f39011e.optInt(str);
        }
        return invokeL.intValue;
    }
}

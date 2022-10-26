package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
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
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static Map a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;
    public String d;
    public JSONObject e;
    public long f;
    public int g;
    public boolean h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2036590893, "Lcom/tencent/open/utils/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2036590893, "Lcom/tencent/open/utils/g;");
                return;
            }
        }
        a = Collections.synchronizedMap(new HashMap());
        b = null;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            try {
                this.e = new JSONObject(c("com.tencent.open.config.json"));
            } catch (JSONException unused) {
                this.e = new JSONObject();
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            int optInt = this.e.optInt("Common_frequency");
            if (optInt == 0) {
                optInt = 1;
            }
            if (SystemClock.elapsedRealtime() - this.f >= optInt * 3600000) {
                b();
            }
        }
    }

    public g(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0L;
        this.g = 0;
        this.h = true;
        this.c = context.getApplicationContext();
        this.d = str;
        a();
        b();
    }

    public static g a(Context context, String str) {
        InterceptResult invokeLL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            synchronized (a) {
                SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
                if (str != null) {
                    b = str;
                }
                if (str == null) {
                    if (b != null) {
                        str = b;
                    } else {
                        str = "0";
                    }
                }
                gVar = (g) a.get(str);
                if (gVar == null) {
                    gVar = new g(context, str);
                    a.put(str, gVar);
                }
                SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
            }
            return gVar;
        }
        return (g) invokeLL.objValue;
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, this, str) == null) && this.h) {
            SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.d);
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, str2) == null) {
            try {
                if (this.d != null) {
                    str = str + "." + this.d;
                }
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.c.openFileOutput(str, 0), Charset.forName("UTF-8"));
                outputStreamWriter.write(str2);
                outputStreamWriter.flush();
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, jSONObject) == null) {
            d("cgi back, do update");
            this.e = jSONObject;
            a("com.tencent.open.config.json", jSONObject.toString());
            this.f = SystemClock.elapsedRealtime();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (this.g != 0) {
                d("update thread is running, return");
                return;
            }
            this.g = 1;
            Bundle bundle = new Bundle();
            bundle.putString("appid", this.d);
            bundle.putString("appid_for_getting_config", this.d);
            bundle.putString("status_os", Build.VERSION.RELEASE);
            bundle.putString("status_machine", Build.MODEL);
            bundle.putString("status_version", Build.VERSION.SDK);
            bundle.putString("sdkv", Constants.SDK_VERSION);
            bundle.putString("sdkp", "a");
            new Thread(this, bundle) { // from class: com.tencent.open.utils.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bundle a;
                public final /* synthetic */ g b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bundle};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = bundle;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.b.a(l.d(HttpUtils.openUrl2(this.b.c, "https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", this.a).a));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.b.g = 0;
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
                    if (this.d != null) {
                        str2 = str + "." + this.d;
                    } else {
                        str2 = str;
                    }
                    open = this.c.openFileInput(str2);
                } catch (FileNotFoundException unused) {
                    open = this.c.getAssets().open(str);
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
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                throw th;
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            open.close();
                            bufferedReader.close();
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                str3 = stringBuffer.toString();
                open.close();
                bufferedReader.close();
                return str3;
            } catch (IOException e4) {
                e4.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            d("get " + str);
            c();
            return this.e.optInt(str);
        }
        return invokeL.intValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            d("get " + str);
            c();
            Object opt = this.e.opt(str);
            if (opt == null) {
                return false;
            }
            if (opt instanceof Integer) {
                return !opt.equals(0);
            }
            if (!(opt instanceof Boolean)) {
                return false;
            }
            return ((Boolean) opt).booleanValue();
        }
        return invokeL.booleanValue;
    }
}

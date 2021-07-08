package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes6.dex */
public class BindTestPhoneController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BindTestPhoneController() {
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

    public static void bind(String str, Context context) {
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, str, context) == null) || (indexOf = str.indexOf(":")) < 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(indexOf + 3);
        if (!substring.toLowerCase().startsWith("https://")) {
            sb.append("https://");
        }
        sb.append(substring);
        if (str.indexOf("?") > 0) {
            sb.append("&hdid=");
            sb.append(DeviceProxy.getHdid(context));
        } else {
            sb.append("?hdid=");
            sb.append(DeviceProxy.getHdid(context));
        }
        try {
            sb.append("&sjp=");
            sb.append(URLEncoder.encode(ArdUtil.getSjp(context), "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        try {
            sb.append("&sjm=");
            sb.append(URLEncoder.encode(ArdUtil.getSjm(context), "UTF-8"));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        sb.append("&sys=");
        sb.append(2);
        try {
            sb.append("&mbos=");
            sb.append(URLEncoder.encode(ArdUtil.getOS(), "UTF-8"));
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
        }
        try {
            sb.append("&name=");
            sb.append(URLEncoder.encode(ArdUtil.getDeviceName(context), "UTF-8"));
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
        }
        ThreadPool.getPool().execute(new Runnable(sb.toString()) { // from class: com.yy.hiidostatis.defs.controller.BindTestPhoneController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$nurl;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r6};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$nurl = r6;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BindTestPhoneController.get(this.val$nurl);
                }
            }
        });
    }

    public static void get(String str) {
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65538, null, str) != null) {
            return;
        }
        HttpsURLConnection httpsURLConnection = null;
        InputStream inputStream2 = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
            try {
                httpsURLConnection2.setConnectTimeout(30000);
                httpsURLConnection2.setReadTimeout(60000);
                httpsURLConnection2.setUseCaches(false);
                httpsURLConnection2.setRequestMethod("GET");
                httpsURLConnection2.setInstanceFollowRedirects(true);
                httpsURLConnection2.setRequestProperty("User-Agent", "Hiido");
                httpsURLConnection2.connect();
                if (httpsURLConnection2.getResponseCode() == 200) {
                    L.verbose("HttpUtil", "get url=[%s] is ok", str);
                    inputStream2 = httpsURLConnection2.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    L.verbose("HttpUtil", "the result is %s", new String(byteArrayOutputStream.toByteArray(), "UTF-8"));
                    byteArrayOutputStream.close();
                } else {
                    L.warn("HttpUtil", "http get [%s] error! status:%d", str, Integer.valueOf(httpsURLConnection2.getResponseCode()));
                }
                if (httpsURLConnection2 != null) {
                    try {
                        httpsURLConnection2.disconnect();
                    } catch (Throwable th) {
                        L.debug("BindTestPhoneController", th.getMessage(), new Object[0]);
                        return;
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                httpsURLConnection = httpsURLConnection2;
                try {
                    L.error("BindTestPhoneController", th.getMessage(), new Object[0]);
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Throwable th3) {
                            L.debug("BindTestPhoneController", th3.getMessage(), new Object[0]);
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th4) {
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Throwable th5) {
                            L.debug("BindTestPhoneController", th5.getMessage(), new Object[0]);
                            throw th4;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
        }
    }
}

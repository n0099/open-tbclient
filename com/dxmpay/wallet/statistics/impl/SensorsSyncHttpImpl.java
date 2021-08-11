package com.dxmpay.wallet.statistics.impl;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.dxmpay.statistics.internal.ISyncHttpImpl;
import com.qq.e.comm.constants.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SensorsSyncHttpImpl implements ISyncHttpImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SensorsSyncHttpImpl() {
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

    public static InputStream a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, httpURLConnection)) == null) {
            try {
                return httpURLConnection.getInputStream();
            } catch (IOException unused) {
                return httpURLConnection.getErrorStream();
            }
        }
        return (InputStream) invokeL.objValue;
    }

    public static String b(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, inputStream)) != null) {
            return (String) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toString();
            }
        }
    }

    public final String c(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            StringBuilder sb = new StringBuilder();
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String encode = URLEncoder.encode(entry.getKey());
                    String encode2 = URLEncoder.encode(entry.getValue());
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                    sb.append("&");
                }
            }
            return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.ISyncHttpImpl
    public boolean send(Context context, int i2, String str, Map<String, String> map) {
        InterceptResult invokeLILL;
        OutputStream outputStream;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, str, map)) == null) {
            HttpURLConnection httpURLConnection2 = null;
            OutputStream outputStream3 = null;
            HttpURLConnection httpURLConnection3 = null;
            boolean z = false;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setDoOutput(1 == i2);
                    if (1 == i2) {
                        httpURLConnection.setRequestMethod("POST");
                    } else if (i2 == 0) {
                        httpURLConnection.setRequestMethod("GET");
                    } else {
                        throw new Exception("not support http method:" + i2);
                    }
                    httpURLConnection.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    String c2 = c(map);
                    httpURLConnection.setFixedLengthStreamingMode(c2.length());
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.connect();
                    if (c2.length() > 0) {
                        outputStream3 = httpURLConnection.getOutputStream();
                        outputStream3.write(c2.getBytes());
                        outputStream3.flush();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    if (200 <= responseCode && 300 > responseCode) {
                        JSONObject jSONObject = new JSONObject(b(httpURLConnection.getInputStream()));
                        if (jSONObject.has(Constants.KEYS.RET) && jSONObject.optInt(Constants.KEYS.RET) == 1) {
                            z = true;
                        }
                    }
                    if (httpURLConnection != null) {
                        InputStream a2 = a(httpURLConnection);
                        if (a2 != null) {
                            try {
                                a2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        httpURLConnection.disconnect();
                    }
                } catch (Exception unused) {
                    outputStream2 = null;
                    httpURLConnection3 = httpURLConnection;
                    if (httpURLConnection3 != null) {
                        InputStream a3 = a(httpURLConnection3);
                        if (a3 != null) {
                            try {
                                a3.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        httpURLConnection3.disconnect();
                    }
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                    outputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        InputStream a4 = a(httpURLConnection2);
                        if (a4 != null) {
                            try {
                                a4.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        httpURLConnection2.disconnect();
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                outputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
            }
            if (outputStream3 != null) {
                outputStream3.close();
            }
            return z;
        }
        return invokeLILL.booleanValue;
    }
}

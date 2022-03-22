package com.yy.mobile.framework.revenuesdk.baseapi.log;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class HttpLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HttpLoader() {
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

    public static String postJson(String str, String str2) {
        InterceptResult invokeLL;
        GZIPInputStream gZIPInputStream;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            String str3 = "";
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty(Config.LAUNCH_REFERER, "https://www.yy.com/index.html");
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "application/json");
                    if (str2 != null && !TextUtils.isEmpty(str2)) {
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str2.getBytes().length));
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(str2.getBytes());
                        outputStream.flush();
                        outputStream.close();
                    }
                    if (httpURLConnection.getResponseCode() == 200) {
                        gZIPInputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                        try {
                            try {
                                bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, "UTF-8"));
                            } catch (Exception e2) {
                                e = e2;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            str3 = bufferedReader.readLine();
                            bufferedReader2 = bufferedReader;
                        } catch (Exception e3) {
                            bufferedReader2 = bufferedReader;
                            e = e3;
                            e.printStackTrace();
                            Log.e("yyrevenue", "xxxxx > " + e.toString());
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            return str3;
                        } catch (Throwable th2) {
                            bufferedReader2 = bufferedReader;
                            th = th2;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        gZIPInputStream = null;
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
            } catch (Exception e9) {
                e = e9;
                gZIPInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                gZIPInputStream = null;
            }
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }
}

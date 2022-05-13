package com.repackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class pn {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static abstract class a implements b<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.pn.b
        /* renamed from: c */
        public JSONObject a(int i, String str, InputStream inputStream) throws IOException {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, inputStream)) == null) {
                if (i != 200) {
                    throw new IOException("parse response error: statuscode is " + i);
                } else if (inputStream != null) {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString("UTF-8"));
                        if (pn.a) {
                            Log.d(TitanDownloadService.TAG, jSONObject.toString());
                        }
                        return jSONObject;
                    } catch (Exception e) {
                        throw new IOException(e);
                    }
                } else {
                    throw new IOException("parse response error: input stream is null");
                }
            }
            return (JSONObject) invokeILL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface b<T> {
        T a(int i, String str, InputStream inputStream) throws IOException;

        void b(int i, String str, T t);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964030521, "Lcom/repackage/pn;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964030521, "Lcom/repackage/pn;");
                return;
            }
        }
        a = mn.a;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "0.8";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                sb = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                int length = property.length();
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if (charAt <= 31 || charAt >= 127) {
                        sb2.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                    } else {
                        sb2.append(charAt);
                    }
                }
                sb = sb2.toString();
            }
            String str = Build.VERSION.RELEASE;
            String replace = TextUtils.isEmpty(str) ? "0.0" : str.replace("_", "-");
            return sb + " baiduboxapp/" + b(context) + " (Baidu; P1 " + replace + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0112 A[Catch: all -> 0x0125, TRY_LEAVE, TryCatch #3 {all -> 0x0125, blocks: (B:67:0x010d, B:69:0x0112), top: B:83:0x010d }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void d(Context context, String str, String str2, byte[] bArr, Map<String, String> map, b<T> bVar) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection3;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, bArr, map, bVar}) != null) {
            return;
        }
        OutputStream outputStream3 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setRequestProperty("User-Agent", c(context));
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestMethod(str2);
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (!TextUtils.equals(str2, "POST")) {
                    outputStream2 = null;
                } else if (bArr == null) {
                    if (a) {
                        Log.d(TitanDownloadService.TAG, "post requestSync body is null");
                    }
                    if (bVar != null) {
                        bVar.b(-1, "post requestSync body is null", null);
                    }
                    Closeables.closeSafely((Closeable) null);
                    Closeables.closeSafely((Closeable) null);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } else {
                    httpURLConnection.setDoOutput(true);
                    if (map == null || !map.containsKey("Content-Type")) {
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    }
                    outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(bArr);
                    } catch (Exception e) {
                        inputStream2 = null;
                        httpURLConnection3 = httpURLConnection;
                        outputStream = outputStream2;
                        e = e;
                        httpURLConnection2 = httpURLConnection3;
                        try {
                            e.printStackTrace();
                            if (bVar != null) {
                                bVar.b(-1, e.getMessage(), null);
                            }
                            Closeables.closeSafely(outputStream);
                            Closeables.closeSafely(inputStream2);
                            if (httpURLConnection2 == null) {
                                httpURLConnection2.disconnect();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            outputStream3 = outputStream;
                            httpURLConnection = httpURLConnection2;
                            inputStream = inputStream2;
                            Closeables.closeSafely(outputStream3);
                            Closeables.closeSafely(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        outputStream3 = outputStream2;
                        th = th2;
                        inputStream = null;
                        Closeables.closeSafely(outputStream3);
                        Closeables.closeSafely(inputStream);
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                Log.d(TitanDownloadService.TAG, "request code = " + responseCode + " msg = " + httpURLConnection.getResponseMessage());
                if (responseCode == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    if (bVar != null) {
                        try {
                            t = bVar.a(responseCode, httpURLConnection.getResponseMessage(), inputStream);
                        } catch (Exception e2) {
                            httpURLConnection3 = httpURLConnection;
                            outputStream = outputStream2;
                            e = e2;
                            inputStream2 = inputStream;
                            httpURLConnection2 = httpURLConnection3;
                            e.printStackTrace();
                            if (bVar != null) {
                            }
                            Closeables.closeSafely(outputStream);
                            Closeables.closeSafely(inputStream2);
                            if (httpURLConnection2 == null) {
                            }
                        } catch (Throwable th3) {
                            outputStream3 = outputStream2;
                            th = th3;
                            Closeables.closeSafely(outputStream3);
                            Closeables.closeSafely(inputStream);
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    } else {
                        t = null;
                    }
                } else {
                    inputStream = null;
                    t = null;
                }
                if (bVar != null) {
                    bVar.b(responseCode, httpURLConnection.getResponseMessage(), t);
                }
                Closeables.closeSafely(outputStream2);
                Closeables.closeSafely(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Exception e3) {
                e = e3;
                httpURLConnection2 = httpURLConnection;
                outputStream = null;
                inputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            outputStream = null;
            httpURLConnection2 = null;
            inputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            inputStream = null;
        }
    }
}

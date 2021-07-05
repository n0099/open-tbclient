package d.a.n.a.b;

import com.baidu.crabsdk.lite.a.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f46212e;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46212e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpURLConnection httpURLConnection;
        String f2;
        URLConnection openConnection;
        DataOutputStream dataOutputStream;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        try {
            String str2 = this.f46212e;
            DataOutputStream dataOutputStream2 = null;
            try {
                try {
                    f2 = com.baidu.crabsdk.lite.sender.b.f(str2);
                    com.baidu.crabsdk.lite.b.a.c(str2, "sync json is " + f2);
                    URL url = new URL(com.baidu.crabsdk.lite.a.c(str2));
                    if (com.baidu.crabsdk.lite.a.l != null) {
                        HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4688a.get(str2);
                        if (hashMap != null) {
                            Object obj = hashMap.get("domain_proxy");
                            openConnection = obj != null ? url.openConnection((Proxy) obj) : url.openConnection();
                        } else {
                            openConnection = url.openConnection();
                        }
                    } else {
                        openConnection = url.openConnection();
                    }
                    httpURLConnection = (HttpURLConnection) openConnection;
                    try {
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        httpURLConnection.setRequestProperty("User-Agent", com.baidu.crabsdk.lite.sender.b.a(str2, "sync", null));
                        httpURLConnection.setConnectTimeout(3000);
                        httpURLConnection.setReadTimeout(3000);
                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    } catch (Exception unused) {
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    dataOutputStream.writeBytes(f2);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (httpURLConnection.getResponseCode() == 200) {
                        l.b(str2);
                        str = "#### ^@^ sync ok!";
                    } else {
                        str = "#### T^T sync failed!";
                    }
                    com.baidu.crabsdk.lite.b.a.f(str2, str);
                    httpURLConnection.disconnect();
                    try {
                        dataOutputStream.close();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception unused2) {
                    dataOutputStream2 = dataOutputStream;
                    com.baidu.crabsdk.lite.b.a.f(str2, "sync connect to server error!");
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream2 = dataOutputStream;
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                httpURLConnection = null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}

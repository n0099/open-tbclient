package d.a.m.c.b;

import com.baidu.crabsdk.lite.a.l;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f63857e;

    public b(String str) {
        this.f63857e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpURLConnection httpURLConnection;
        URLConnection openConnection;
        DataOutputStream dataOutputStream;
        String str;
        try {
            String str2 = this.f63857e;
            DataOutputStream dataOutputStream2 = null;
            try {
                String f2 = com.baidu.crabsdk.lite.sender.b.f(str2);
                com.baidu.crabsdk.lite.b.a.c(str2, "sync json is " + f2);
                URL url = new URL(com.baidu.crabsdk.lite.a.c(str2));
                if (com.baidu.crabsdk.lite.a.l != null) {
                    HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4716a.get(str2);
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

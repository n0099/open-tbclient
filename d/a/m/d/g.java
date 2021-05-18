package d.a.m.d;

import android.content.Context;
import com.baidu.crabsdk.b.n;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f63870e;

    public g(Context context) {
        this.f63870e = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2 A[Catch: Exception -> 0x009e, TRY_LEAVE, TryCatch #1 {Exception -> 0x009e, blocks: (B:32:0x009a, B:36:0x00a2), top: B:53:0x009a, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        Exception e2;
        String a2;
        String str;
        try {
            try {
                try {
                    a2 = com.baidu.crabsdk.sender.g.a();
                    com.baidu.crabsdk.c.a.c("sync json is " + a2);
                    httpURLConnection = (HttpURLConnection) new URL(com.baidu.crabsdk.a.c()).openConnection();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            } catch (Exception e4) {
                e = e4;
                httpURLConnection = null;
                dataOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
                dataOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("User-Agent", com.baidu.crabsdk.sender.g.b("sync", null));
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(8000);
            dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream2.writeBytes(a2);
                dataOutputStream2.flush();
                dataOutputStream2.close();
                if (httpURLConnection.getResponseCode() == 200) {
                    n.c();
                    str = "#### ^@^ sync ok!";
                } else {
                    str = "#### T^T sync failed!";
                }
                com.baidu.crabsdk.c.a.b(str);
                httpURLConnection.disconnect();
                try {
                    dataOutputStream2.close();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } catch (Exception e6) {
                e2 = e6;
                com.baidu.crabsdk.c.a.a("sync connect to server error!", e2);
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                        return;
                    }
                }
                if (httpURLConnection == null) {
                    httpURLConnection.disconnect();
                }
            }
        } catch (Exception e8) {
            e = e8;
            dataOutputStream2 = null;
            e2 = e;
            com.baidu.crabsdk.c.a.a("sync connect to server error!", e2);
            if (dataOutputStream2 != null) {
            }
            if (httpURLConnection == null) {
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            th = th;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (Exception e9) {
                    e9.printStackTrace();
                    throw th;
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}

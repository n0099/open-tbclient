package d.b.n.d;

import android.content.Context;
import com.baidu.crabsdk.b.n;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes2.dex */
public final class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f64151e;

    public g(Context context) {
        this.f64151e = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a5 A[Catch: Exception -> 0x00a1, TRY_LEAVE, TryCatch #8 {Exception -> 0x00a1, blocks: (B:32:0x009d, B:36:0x00a5), top: B:61:0x009d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b8 A[Catch: Exception -> 0x00b4, TRY_LEAVE, TryCatch #4 {Exception -> 0x00b4, blocks: (B:42:0x00b0, B:46:0x00b8), top: B:56:0x00b0, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        Throwable th;
        Exception e2;
        String str;
        try {
            try {
                String a2 = com.baidu.crabsdk.sender.g.a();
                com.baidu.crabsdk.c.a.c("sync json is " + a2);
                httpURLConnection = (HttpURLConnection) new URL(com.baidu.crabsdk.a.c()).openConnection();
                try {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestProperty("User-Agent", com.baidu.crabsdk.sender.g.b("sync", null));
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(8000);
                    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    try {
                        try {
                            dataOutputStream.writeBytes(a2);
                            dataOutputStream.flush();
                            dataOutputStream.close();
                            if (httpURLConnection.getResponseCode() == 200) {
                                n.c();
                                str = "#### ^@^ sync ok!";
                            } else {
                                str = "#### T^T sync failed!";
                            }
                            com.baidu.crabsdk.c.a.b(str);
                            httpURLConnection.disconnect();
                            try {
                                dataOutputStream.close();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            com.baidu.crabsdk.c.a.a("sync connect to server error!", e2);
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                    return;
                                }
                            }
                            if (httpURLConnection == null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    e = e7;
                    dataOutputStream = null;
                    e2 = e;
                    com.baidu.crabsdk.c.a.a("sync connect to server error!", e2);
                    if (dataOutputStream != null) {
                    }
                    if (httpURLConnection == null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = null;
                    th = th;
                    if (dataOutputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        } catch (Exception e9) {
            e = e9;
            httpURLConnection = null;
            dataOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            dataOutputStream = null;
        }
    }
}

package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidubce.http.Headers;
import com.tencent.turingfd.sdk.ams.au.ad;
import com.tencent.turingfd.sdk.ams.au.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class bd implements ad {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f13807a;

    public bd(String str) {
        this.f13807a = str;
    }

    public ad.a a(int i, byte[] bArr, int i2, int i3) {
        v.a aVar;
        int i4;
        String str;
        boolean z = true;
        int i5 = -4000;
        v vVar = new v();
        String str2 = this.f13807a;
        Context a2 = aj.a();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) a2.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !(activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) {
                aVar = v.a.d;
            } else if (activeNetworkInfo.getType() == 1) {
                aVar = v.a.f13851a;
            } else if (activeNetworkInfo.getType() == 0) {
                String a3 = v.a(a2);
                aVar = (a3 == null || a3.length() <= 0 || v.b(a2) <= 0) ? v.a.c : v.a.f13852b;
            } else {
                aVar = v.a.c;
            }
        } catch (Throwable th) {
            String message = th.getMessage();
            aVar = message != null && message.contains("ACCESS_NETWORK_STATE") ? v.a.f13851a : v.a.d;
        }
        if (aVar == v.a.d) {
            i4 = -1052;
        } else {
            try {
                URL url = new URL(str2);
                if (aVar == v.a.f13852b) {
                    vVar.f13849a = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(v.a(aj.a()), v.b(aj.a()))));
                } else {
                    vVar.f13849a = (HttpURLConnection) url.openConnection();
                }
                vVar.f13849a.setReadTimeout(BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
                vVar.f13849a.setConnectTimeout(BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
                i4 = 0;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                i4 = -1057;
            } catch (SecurityException e2) {
                e2.printStackTrace();
                i4 = -1058;
            } catch (UnsupportedOperationException e3) {
                e3.printStackTrace();
                i4 = -1059;
            } catch (MalformedURLException e4) {
                e4.printStackTrace();
                i4 = -1053;
            } catch (IOException e5) {
                g.a().a(e5);
                e5.printStackTrace();
                i4 = -1056;
            } catch (Throwable th2) {
                th2.printStackTrace();
                i4 = -1000;
            }
        }
        if (i4 == 0) {
            vVar.f13850b = false;
            try {
                try {
                    int length = bArr.length;
                    vVar.f13849a.setDoOutput(true);
                    vVar.f13849a.setDoInput(true);
                    vVar.f13849a.setUseCaches(false);
                    vVar.f13849a.setRequestMethod("POST");
                    vVar.f13849a.setRequestProperty("Pragma", "no-cache");
                    vVar.f13849a.setRequestProperty(Headers.CACHE_CONTROL, "no-cache");
                    vVar.f13849a.setInstanceFollowRedirects(false);
                    vVar.f13849a.setRequestProperty("User-Agent", "QQPimSecure");
                    vVar.f13849a.setRequestProperty("Accept", "*/*");
                    vVar.f13849a.setRequestProperty("Accept-Charset", "utf-8");
                    vVar.f13849a.setRequestProperty("Content-Type", "application/octet-stream");
                    vVar.f13849a.setRequestProperty("Content-length", "" + length);
                    try {
                        if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
                            vVar.f13849a.setRequestProperty(HTTP.CONN_DIRECTIVE, "close");
                        }
                    } catch (Exception e6) {
                    }
                    OutputStream outputStream = vVar.f13849a.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    outputStream.close();
                    int responseCode = vVar.f13849a.getResponseCode();
                    if (responseCode == 200) {
                        vVar.f13850b = true;
                        i4 = 0;
                    } else {
                        i4 = responseCode == -1 ? -2000 : (-2000) - responseCode;
                    }
                    if (responseCode < 301 || responseCode > 305) {
                        z = false;
                    }
                    if (z) {
                        g a4 = g.a();
                        try {
                            str = vVar.f13849a.getHeaderField(Headers.LOCATION);
                        } catch (Exception e7) {
                            str = "";
                        }
                        a4.a("3", str);
                    }
                } catch (IllegalAccessError e8) {
                    i4 = -2060;
                    e8.printStackTrace();
                }
            } catch (IllegalStateException e9) {
                e9.printStackTrace();
                i4 = -2061;
            } catch (ProtocolException e10) {
                e10.printStackTrace();
                i4 = -2051;
            } catch (IOException e11) {
                e11.printStackTrace();
                i4 = -2056;
            } catch (Exception e12) {
                e12.printStackTrace();
                i4 = -2000;
            }
        }
        if (i4 != 0) {
            return ad.a.a(i4, new byte[0]);
        }
        AtomicReference atomicReference = new AtomicReference();
        HttpURLConnection httpURLConnection = vVar.f13849a;
        if (httpURLConnection != null && vVar.f13850b) {
            byte[] bArr2 = null;
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = inputStream.read();
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(read);
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                i5 = 0;
            } catch (IOException e13) {
                i5 = -4056;
                e13.printStackTrace();
            } catch (Exception e14) {
                e14.printStackTrace();
            }
            atomicReference.set(bArr2);
            HttpURLConnection httpURLConnection2 = vVar.f13849a;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
                vVar.f13849a = null;
            }
        }
        return i5 != 0 ? ad.a.a(i5, new byte[0]) : ad.a.a(i5, (byte[]) atomicReference.get());
    }
}

package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.live.interfaces.DI;
import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.loader.a;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f32168a;

    /* renamed from: b  reason: collision with root package name */
    public String f32169b;

    /* renamed from: c  reason: collision with root package name */
    public int f32170c;

    /* loaded from: classes6.dex */
    public interface a {
        void a(a.b bVar);

        void a(Exception exc);
    }

    public e(String str) {
        this.f32169b = str;
        this.f32168a = str;
    }

    private String a() {
        int i;
        Context context = Loader.get().getContext();
        int i2 = com.kwad.sdk.api.a.f32130a;
        String valueOf = String.valueOf(Loader.get().a(context));
        IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
        if (ksAdSDKImpl != null) {
            if (TextUtils.isEmpty(valueOf)) {
                valueOf = ksAdSDKImpl.getSDKVersion();
            }
            i = ksAdSDKImpl.getSDKVersionCode();
        } else {
            i = -1;
        }
        JSONObject appInfo = Loader.get().getKsAdSDKImpl().getAppInfo();
        JSONObject deviceInfo = Loader.get().getKsAdSDKImpl().getDeviceInfo();
        JSONObject networkInfo = Loader.get().getKsAdSDKImpl().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdkApiVersion", "3.3.9");
            jSONObject.put("sdkApiVersionCode", 3030900);
            jSONObject.put(CommandMessage.SDK_VERSION, valueOf);
            jSONObject.put("SDKVersionCode", i);
            jSONObject.put("sdkType", i2);
            jSONObject.put(DI.APP_INFO_NAME, appInfo);
            jSONObject.put("deviceInfo", deviceInfo);
            jSONObject.put("networkInfo", networkInfo);
            jSONObject.put("sdkAbi", s.b());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (IOException e6) {
                    e6.printStackTrace();
                    return null;
                }
            }
        }
        String str = new String(byteArrayOutputStream.toByteArray());
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e8) {
            e8.printStackTrace();
        }
        return str;
    }

    private URLConnection a(String str, int i, int i2, boolean z) {
        URLConnection openConnection = new URL(str).openConnection();
        openConnection.setRequestProperty("Accept-Language", "zh-CN");
        if (i > 0) {
            openConnection.setConnectTimeout(i);
        }
        if (i2 > 0) {
            openConnection.setReadTimeout(i2);
        }
        openConnection.setUseCaches(z);
        openConnection.setDoInput(true);
        openConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
        openConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
        return openConnection;
    }

    @Nullable
    private HttpURLConnection b() {
        if (TextUtils.isEmpty(this.f32168a)) {
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) a(this.f32168a, 10000, 30000, false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("User-Agent", RequestParamsUtils.getUserAgent());
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = b();
                if (httpURLConnection != null) {
                    httpURLConnection.connect();
                    new DataOutputStream(httpURLConnection.getOutputStream()).write(a().getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        String a2 = a(httpURLConnection.getInputStream());
                        a.b bVar = new a.b();
                        bVar.a(new JSONObject(a2));
                        aVar.a(bVar);
                    } else if (responseCode / 100 != 3) {
                        throw new RuntimeException("response code = " + responseCode);
                    } else if (this.f32170c < 21) {
                        this.f32168a = httpURLConnection.getHeaderField("Location");
                        this.f32170c++;
                        b(aVar);
                    }
                }
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e2) {
                aVar.a(e2);
                if (0 == 0) {
                    return;
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public void a(final a aVar) {
        i.a(new Runnable() { // from class: com.kwad.sdk.api.loader.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.b(aVar);
            }
        });
    }
}

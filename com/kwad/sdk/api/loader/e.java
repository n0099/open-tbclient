package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidubce.http.Headers;
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
/* loaded from: classes3.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private String f8197a;

    /* renamed from: b  reason: collision with root package name */
    private String f8198b;
    private int c;

    /* loaded from: classes3.dex */
    public interface a {
        void a(a.b bVar);

        void a(Exception exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str) {
        this.f8198b = str;
        this.f8197a = str;
    }

    private String a() {
        Context context = Loader.get().getContext();
        int i = com.kwad.sdk.api.a.f8176a;
        int i2 = -1;
        String valueOf = String.valueOf(Loader.get().a(context));
        IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
        if (ksAdSDKImpl != null) {
            if (TextUtils.isEmpty(valueOf)) {
                valueOf = ksAdSDKImpl.getSDKVersion();
            }
            i2 = ksAdSDKImpl.getSDKVersionCode();
        }
        JSONObject appInfo = Loader.get().getKsAdSDKImpl().getAppInfo();
        JSONObject deviceInfo = Loader.get().getKsAdSDKImpl().getDeviceInfo();
        JSONObject networkInfo = Loader.get().getKsAdSDKImpl().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdkApiVersion", "3.3.9");
            jSONObject.put("sdkApiVersionCode", 3030900);
            jSONObject.put(CommandMessage.SDK_VERSION, valueOf);
            jSONObject.put("SDKVersionCode", i2);
            jSONObject.put("sdkType", i);
            jSONObject.put("appInfo", appInfo);
            jSONObject.put("deviceInfo", deviceInfo);
            jSONObject.put("networkInfo", networkInfo);
            jSONObject.put("sdkAbi", s.b());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, IF, INVOKE, MOVE_EXCEPTION] complete} */
    private static String a(InputStream inputStream) {
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
                } catch (IOException e) {
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
        String str = new String(byteArrayOutputStream.toByteArray());
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
                return str;
            } catch (IOException e7) {
                e7.printStackTrace();
                return str;
            }
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
        openConnection.setRequestProperty("Charset", "UTF-8");
        return openConnection;
    }

    @Nullable
    private HttpURLConnection b() {
        if (TextUtils.isEmpty(this.f8197a)) {
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) a(this.f8197a, 10000, 30000, false);
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
                HttpURLConnection b2 = b();
                if (b2 != null) {
                    b2.connect();
                    new DataOutputStream(b2.getOutputStream()).write(a().getBytes());
                    int responseCode = b2.getResponseCode();
                    if (responseCode == 200) {
                        String a2 = a(b2.getInputStream());
                        a.b bVar = new a.b();
                        bVar.a(new JSONObject(a2));
                        aVar.a(bVar);
                    } else if (responseCode / 100 != 3) {
                        throw new RuntimeException("response code = " + responseCode);
                    } else {
                        if (this.c < 21) {
                            this.f8197a = b2.getHeaderField(Headers.LOCATION);
                            this.c++;
                            b(aVar);
                        }
                    }
                }
                if (b2 != null) {
                    try {
                        b2.disconnect();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                aVar.a(e2);
                if (0 != 0) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e3) {
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final a aVar) {
        i.a(new Runnable() { // from class: com.kwad.sdk.api.loader.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.b(aVar);
            }
        });
    }
}

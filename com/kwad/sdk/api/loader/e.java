package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.api.loader.a;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f53953b;

    /* renamed from: c  reason: collision with root package name */
    public int f53954c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f53955d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public IKsAdSDK f53956e;

    /* loaded from: classes7.dex */
    public interface a {
        void a(a.b bVar);

        void a(Exception exc);
    }

    public e(String str, IKsAdSDK iKsAdSDK) {
        this.f53953b = str;
        this.a = str;
        this.f53956e = iKsAdSDK;
    }

    private String a() {
        int i2;
        String valueOf = String.valueOf(Loader.get().a(Loader.get().getContext()));
        IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
        if (ksAdSDKImpl != null) {
            if (TextUtils.isEmpty(valueOf)) {
                valueOf = ksAdSDKImpl.getSDKVersion();
            }
            i2 = ksAdSDKImpl.getSDKVersionCode();
        } else {
            i2 = -1;
        }
        JSONObject appInfo = Loader.get().getKsAdSDKImpl().getAppInfo();
        JSONObject deviceInfo = Loader.get().getKsAdSDKImpl().getDeviceInfo();
        JSONObject networkInfo = Loader.get().getKsAdSDKImpl().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdkApiVersion", "3.3.17.4");
            jSONObject.put("sdkApiVersionCode", 3031704);
            jSONObject.put(CommandMessage.SDK_VERSION, valueOf);
            jSONObject.put("SDKVersionCode", i2);
            jSONObject.put("sdkType", 1);
            jSONObject.put(DI.APP_INFO_NAME, appInfo);
            jSONObject.put(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, deviceInfo);
            jSONObject.put("networkInfo", networkInfo);
            jSONObject.put("sdkAbi", s.b());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.f53956e != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("version", "3.3.17.4");
                jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, appInfo.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                jSONObject2.put("message", this.f53956e.getRM(jSONObject.toString()));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            this.f53956e.sR(this.f53953b.replace("https://open.e.kuaishou.com", ""), this.f53955d, jSONObject2.toString());
            return jSONObject2.toString();
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

    private URLConnection a(String str, int i2, int i3, boolean z) {
        URLConnection openConnection = new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(openConnection);
        a("Accept-Language", "zh-CN");
        if (i2 > 0) {
            openConnection.setConnectTimeout(i2);
        }
        if (i3 > 0) {
            openConnection.setReadTimeout(i3);
        }
        openConnection.setUseCaches(z);
        openConnection.setDoInput(true);
        a(HTTP.CONN_DIRECTIVE, "keep-alive");
        a(BOSTokenRequest.CHARSET, "UTF-8");
        return openConnection;
    }

    private void a(String str, String str2) {
        this.f53955d.put(str, str2);
    }

    @Nullable
    private HttpURLConnection b() {
        if (TextUtils.isEmpty(this.a)) {
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) a(this.a, 10000, 30000, false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        a("Content-Type", "application/json; charset=UTF-8");
        a("User-Agent", RequestParamsUtils.getUserAgent());
        IKsAdSDK iKsAdSDK = this.f53956e;
        if (iKsAdSDK != null) {
            iKsAdSDK.addHp(this.f53955d);
        }
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = b();
                if (httpURLConnection != null) {
                    String a2 = a();
                    if (this.f53955d != null) {
                        for (Map.Entry<String, String> entry : this.f53955d.entrySet()) {
                            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    httpURLConnection.connect();
                    new DataOutputStream(httpURLConnection.getOutputStream()).write(a2.getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        String a3 = a(httpURLConnection.getInputStream());
                        a.b bVar = new a.b();
                        JSONObject jSONObject = new JSONObject(a3);
                        if (this.f53956e != null) {
                            jSONObject.put("data", new JSONObject(this.f53956e.getRD(jSONObject.optString("data"))));
                        }
                        bVar.a(jSONObject);
                        aVar.a(bVar);
                    } else if (responseCode / 100 != 3) {
                        throw new RuntimeException("response code = " + responseCode);
                    } else if (this.f53954c < 21) {
                        this.a = httpURLConnection.getHeaderField("Location");
                        this.f53954c++;
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

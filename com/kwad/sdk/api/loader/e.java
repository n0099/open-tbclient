package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidubce.http.Headers;
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
/* loaded from: classes5.dex */
public class e {
    public String a;
    public String b;
    public int c;
    public Map<String, String> d = new HashMap();
    public IKsAdSDK e;

    /* loaded from: classes5.dex */
    public interface a {
        void a(a.b bVar);

        void a(Exception exc);
    }

    public e(String str, IKsAdSDK iKsAdSDK) {
        this.b = str;
        this.a = str;
        this.e = iKsAdSDK;
    }

    private String a() {
        int i;
        String valueOf = String.valueOf(Loader.get().a(Loader.get().getContext()));
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
            jSONObject.put("sdkApiVersion", "3.3.17.4");
            jSONObject.put("sdkApiVersionCode", 3031704);
            jSONObject.put(CommandMessage.SDK_VERSION, valueOf);
            jSONObject.put("SDKVersionCode", i);
            jSONObject.put("sdkType", 1);
            jSONObject.put(DI.APP_INFO_NAME, appInfo);
            jSONObject.put(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, deviceInfo);
            jSONObject.put("networkInfo", networkInfo);
            jSONObject.put("sdkAbi", s.b());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.e != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("version", "3.3.17.4");
                jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, appInfo.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                jSONObject2.put("message", this.e.getRM(jSONObject.toString()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.e.sR(this.b.replace("https://open.e.kuaishou.com", ""), this.d, jSONObject2.toString());
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
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (IOException e5) {
                    e5.printStackTrace();
                    return null;
                }
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
        try {
            byteArrayOutputStream.close();
        } catch (IOException e7) {
            e7.printStackTrace();
        }
        return str;
    }

    private URLConnection a(String str, int i, int i2, boolean z) {
        URLConnection openConnection = new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(openConnection);
        a("Accept-Language", "zh-CN");
        if (i > 0) {
            openConnection.setConnectTimeout(i);
        }
        if (i2 > 0) {
            openConnection.setReadTimeout(i2);
        }
        openConnection.setUseCaches(z);
        openConnection.setDoInput(true);
        a(HTTP.CONN_DIRECTIVE, "keep-alive");
        a(BOSTokenRequest.CHARSET, "UTF-8");
        return openConnection;
    }

    private void a(String str, String str2) {
        this.d.put(str, str2);
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
        IKsAdSDK iKsAdSDK = this.e;
        if (iKsAdSDK != null) {
            iKsAdSDK.addHp(this.d);
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
                    if (this.d != null) {
                        for (Map.Entry<String, String> entry : this.d.entrySet()) {
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
                        if (this.e != null) {
                            jSONObject.put("data", new JSONObject(this.e.getRD(jSONObject.optString("data"))));
                        }
                        bVar.a(jSONObject);
                        aVar.a(bVar);
                    } else if (responseCode / 100 != 3) {
                        throw new RuntimeException("response code = " + responseCode);
                    } else if (this.c < 21) {
                        this.a = httpURLConnection.getHeaderField(Headers.LOCATION);
                        this.c++;
                        b(aVar);
                    }
                }
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e) {
                aVar.a(e);
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

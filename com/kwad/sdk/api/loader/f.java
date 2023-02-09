package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.components.offline.api.BuildConfig;
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
import okhttp3.internal.http2.Http2Codec;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class f {
    public Map<String, String> Sm = new HashMap();
    public IKsAdSDK Sn;
    public String a;
    public String b;
    public int c;

    /* loaded from: classes8.dex */
    public interface a {
        void a(a.b bVar);

        void a(Exception exc);
    }

    public f(String str, IKsAdSDK iKsAdSDK) {
        this.b = str;
        this.a = str;
        this.Sn = iKsAdSDK;
    }

    private String a() {
        int i;
        String a2 = g.a(Loader.get().getContext());
        IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
        if (ksAdSDKImpl != null) {
            if (TextUtils.isEmpty(a2)) {
                a2 = ksAdSDKImpl.getSDKVersion();
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
            jSONObject.put("sdkApiVersion", BuildConfig.VERSION_NAME);
            jSONObject.put("sdkApiVersionCode", BuildConfig.VERSION_CODE);
            jSONObject.put(CommandMessage.SDK_VERSION, a2);
            jSONObject.put("SDKVersionCode", i);
            jSONObject.put("sdkType", 1);
            jSONObject.put(DI.APP_INFO_NAME, appInfo);
            jSONObject.put(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, deviceInfo);
            jSONObject.put("networkInfo", networkInfo);
            jSONObject.put("sdkAbi", v.a() ? "arm64-v8a" : PassBiometricUtil.CPU_TYPE_ARMEABI_V7A);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.Sn != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("version", BuildConfig.VERSION_NAME);
                jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, appInfo.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                jSONObject2.put("message", this.Sn.getRM(jSONObject.toString()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.Sn.sR(this.b, this.Sm, jSONObject2.toString());
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

    private void a(String str, String str2) {
        this.Sm.put(str, str2);
    }

    public final void a(a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                if (!TextUtils.isEmpty(this.a)) {
                    URLConnection openConnection = new URL(this.a).openConnection();
                    TLSConnectionUtils.wrapHttpURLConnection(openConnection);
                    a("Accept-Language", "zh-CN");
                    openConnection.setConnectTimeout(10000);
                    openConnection.setReadTimeout(30000);
                    openConnection.setUseCaches(false);
                    openConnection.setDoInput(true);
                    a(HTTP.CONN_DIRECTIVE, Http2Codec.KEEP_ALIVE);
                    a(BOSTokenRequest.CHARSET, "UTF-8");
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    a("Content-Type", "application/json; charset=UTF-8");
                    a("User-Agent", RequestParamsUtils.getUserAgent());
                    if (this.Sn != null) {
                        this.Sn.addHp(this.Sm);
                    }
                    httpURLConnection = httpURLConnection2;
                }
                if (httpURLConnection != null) {
                    String a2 = a();
                    if (this.Sm != null) {
                        for (Map.Entry<String, String> entry : this.Sm.entrySet()) {
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
                        if (this.Sn != null) {
                            String optString = jSONObject.optString("data");
                            if (!TextUtils.isEmpty(optString)) {
                                jSONObject.put("data", new JSONObject(this.Sn.getRD(optString)));
                            }
                        }
                        bVar.a = jSONObject.optLong("result");
                        bVar.b = jSONObject.optString("errorMsg");
                        a.C0625a c0625a = new a.C0625a();
                        bVar.Sg = c0625a;
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            c0625a.a = optJSONObject.optInt("dynamicType");
                            c0625a.b = optJSONObject.optString("dynamicUrl");
                            c0625a.c = optJSONObject.optString(PackageTable.MD5);
                            c0625a.Se = optJSONObject.optLong("interval");
                            c0625a.e = optJSONObject.optString(CommandMessage.SDK_VERSION);
                        }
                        aVar.a(bVar);
                    } else if (responseCode / 100 != 3) {
                        throw new RuntimeException("response code = ".concat(String.valueOf(responseCode)));
                    } else {
                        if (this.c < 21) {
                            this.a = httpURLConnection.getHeaderField("Location");
                            this.c++;
                            a(aVar);
                        }
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                aVar.a(e);
                if (0 != 0) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }
}

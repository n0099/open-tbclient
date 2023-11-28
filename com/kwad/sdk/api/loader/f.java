package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.api.loader.a;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Http2Codec;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final v alH;
    public int alI;
    public String alJ;
    public final String mUrl;

    /* loaded from: classes10.dex */
    public interface a {
        void a(a.b bVar);
    }

    public f(v vVar) {
        this.alH = vVar;
        String zr = vVar.zr();
        this.mUrl = zr;
        this.alJ = zr;
    }

    public static HttpURLConnection bT(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004c: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:37:0x004c */
    /* JADX WARN: Removed duplicated region for block: B:53:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (IOException e) {
                        e = e;
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
                }
                String byteArrayOutputStream4 = byteArrayOutputStream.toString();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return byteArrayOutputStream4;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream3 = byteArrayOutputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
            }
            if (byteArrayOutputStream3 != null) {
            }
            throw th;
        }
    }

    public static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map != null && httpURLConnection != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private String d(Map<String, String> map) {
        String ay = g.ay(this.alH.getContext());
        if (TextUtils.isEmpty(ay)) {
            ay = this.alH.zs().getSDKVersion();
        }
        int sDKVersionCode = this.alH.zs().getSDKVersionCode();
        JSONObject appInfo = this.alH.zs().getAppInfo();
        JSONObject deviceInfo = this.alH.zs().getDeviceInfo();
        JSONObject networkInfo = this.alH.zs().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        l.putValue(jSONObject, "sdkApiVersion", BuildConfig.VERSION_NAME);
        l.putValue(jSONObject, "sdkApiVersionCode", (int) BuildConfig.VERSION_CODE);
        l.putValue(jSONObject, com.heytap.mcssdk.constant.b.C, ay);
        l.putValue(jSONObject, "SDKVersionCode", sDKVersionCode);
        l.putValue(jSONObject, "sdkType", 1);
        l.putValue(jSONObject, DI.APP_INFO_NAME, appInfo);
        l.putValue(jSONObject, GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, deviceInfo);
        l.putValue(jSONObject, "networkInfo", networkInfo);
        l.putValue(jSONObject, "sdkAbi", w.xz());
        String jSONObject2 = jSONObject.toString();
        this.alH.zs().addHp(map);
        JSONObject jSONObject3 = new JSONObject();
        l.putValue(jSONObject3, "version", BuildConfig.VERSION_NAME);
        l.putValue(jSONObject3, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, appInfo.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
        l.putValue(jSONObject3, "message", this.alH.zs().getRM(jSONObject2));
        this.alH.zs().sR(this.mUrl, map, jSONObject3.toString());
        return jSONObject3.toString();
    }

    public final void a(a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            Map<String, String> zi = zi();
            String d = d(zi);
            HttpURLConnection bT = bT(this.alJ);
            a(bT, zi);
            bT.connect();
            new DataOutputStream(bT.getOutputStream()).write(d.getBytes());
            int responseCode = bT.getResponseCode();
            if (responseCode == 200) {
                String a2 = a(bT.getInputStream());
                a.b bVar = new a.b();
                JSONObject jSONObject = new JSONObject(a2);
                String optString = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString) && !StringUtil.NULL_STRING.equals(optString)) {
                    jSONObject.put("data", new JSONObject(this.alH.zs().getRD(optString)));
                }
                bVar.parseJson(jSONObject);
                aVar.a(bVar);
            } else if (responseCode / 100 == 3) {
                if (this.alI < 21) {
                    this.alJ = bT.getHeaderField("Location");
                    this.alI++;
                    a(aVar);
                }
            } else {
                throw new RuntimeException("response code = " + responseCode);
            }
            if (bT != null) {
                try {
                    bT.disconnect();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    public static Map<String, String> zi() {
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", "zh-CN");
        hashMap.put(HTTP.CONN_DIRECTIVE, Http2Codec.KEEP_ALIVE);
        hashMap.put(BOSTokenRequest.CHARSET, "UTF-8");
        hashMap.put("Content-Type", "application/json; charset=UTF-8");
        hashMap.put("User-Agent", RequestParamsUtils.getUserAgent());
        return hashMap;
    }
}

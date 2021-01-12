package com.fun.ad;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.fun.ad.sdk.FunAdSdk;
import com.qq.e.comm.constants.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class bc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f7762a;

    /* renamed from: b  reason: collision with root package name */
    public String f7763b;

    public bc(Context context, String str) {
        this.f7762a = context.getApplicationContext();
        this.f7763b = str;
    }

    public static void a(Context context, String str) {
        context.getSharedPreferences("fun_ad_sdk", 0).edit().putString("key_ad_online_config", str).apply();
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject optJSONObject;
        try {
            Uri.Builder buildUpon = Uri.parse("https://cd.xdplt.com/v1/z").buildUpon();
            buildUpon.appendQueryParameter("lic", this.f7763b);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(bn.a(this.f7762a, buildUpon)).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", HttpHelper.CONTENT_JSON);
            m.a("Download online ad config response code: " + httpURLConnection.getResponseCode());
            if (httpURLConnection.getResponseCode() == 200) {
                String a2 = m.a(httpURLConnection.getInputStream());
                m.a("Download online ad config response: " + a2);
                JSONObject jSONObject = new JSONObject(a2);
                int optInt = jSONObject.optInt(Constants.KEYS.RET);
                m.a("Download online ad config response ret: " + optInt);
                if (optInt != 200 || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                    return;
                }
                String optString = optJSONObject.optString("content");
                m.a("Download online ad config decrypt key: " + this.f7763b);
                String a3 = m.a(optString, this.f7763b);
                m.a("Download online ad config response adConfigJson: " + a3);
                if (TextUtils.equals(optString, this.f7762a.getSharedPreferences("fun_ad_sdk", 0).getString("key_ad_online_config", null))) {
                    return;
                }
                a(this.f7762a, optString);
                ((FunAdSdk.a) bq.pFN).a(a3);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}

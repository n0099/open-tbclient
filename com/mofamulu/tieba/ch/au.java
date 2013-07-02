package com.mofamulu.tieba.ch;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.R;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    public static int a;
    private static af b = null;

    public static void a(Context context, String str) {
        com.baidu.tieba.util.aa.c(context, str);
    }

    public static int b(Context context, String str) {
        try {
            if (b == null) {
                b = af.a();
            }
        } catch (Exception e) {
        }
        if (b.c()) {
            String a2 = b.a("http://msg.baidu.com/msg/home/data/unreadnum?qing_request_source=&b" + System.currentTimeMillis() + "=1", (Map) null, "http://msg.baidu.com/", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.5 Safari/537.22", "GBK");
            if (bf.b(a2)) {
                JSONObject jSONObject = new JSONObject(a2);
                if ("0".equals(jSONObject.optString("errorNo"))) {
                    int i = jSONObject.getJSONArray("data").getJSONObject(0).getInt("unreadNum");
                    a(context, i, str);
                    return i;
                }
                Log.e("tbhp_net", "error:" + jSONObject.optString("errorMsg"));
            }
            return 0;
        }
        return 0;
    }

    public static void a(Context context, int i, String str) {
        if (a != i) {
            a = i;
            Intent intent = new Intent("com.baidu.tieba.broadcast.sms");
            intent.putExtra("sms", i);
            context.sendBroadcast(intent);
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if ("0".equals(jSONObject.optString("error_code"))) {
                        JSONObject optJSONObject = jSONObject.optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE);
                        Intent intent2 = new Intent(com.baidu.tieba.data.g.k);
                        intent2.getLongExtra("relay", Long.parseLong(optJSONObject.getString("replyme")));
                        intent2.getLongExtra("at_me", Long.parseLong(optJSONObject.getString("atme")));
                        intent2.getLongExtra("fans", Long.parseLong(optJSONObject.getString("fans")));
                        context.sendBroadcast(intent2);
                    }
                } catch (Exception e) {
                    Log.e("tbhp_net", "failed to parse orginal notify message.", e);
                }
            }
        }
    }

    public static String c(Context context, String str) {
        af a2 = af.a();
        HttpGet httpGet = new HttpGet(str);
        httpGet.setHeader("tbhp_x_from", "android");
        String a3 = bg.a();
        httpGet.setHeader("x_un", a3 == null ? "" : URLEncoder.encode(a3, "UTF-8"));
        httpGet.setHeader("tbhp_x_v", bg.c().e(false) ? "1" : "0");
        if (context != null) {
            try {
                httpGet.setHeader("tbhp_x_vn", context.getString(R.string.tbhp_version_num));
                httpGet.setHeader("tbhp_x_vd", URLEncoder.encode(context.getString(R.string.tbhp_version), "UTF-8"));
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                httpGet.setHeader("tbhp_x_imei", telephonyManager.getDeviceId());
                httpGet.setHeader("tbhp_x_sim", telephonyManager.getSimSerialNumber());
                httpGet.setHeader("tbhp_x_imsi", telephonyManager.getSubscriberId());
            } catch (Throwable th) {
            }
        }
        HttpResponse execute = a2.d().execute(httpGet);
        HttpEntity entity = execute.getEntity();
        if (execute.getStatusLine().getStatusCode() == 200) {
            String entityUtils = EntityUtils.toString(entity);
            entity.consumeContent();
            return entityUtils;
        }
        if (entity != null) {
            entity.consumeContent();
        }
        throw new IOException("云端暂不可用，请稍候再试。");
    }
}

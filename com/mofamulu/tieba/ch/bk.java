package com.mofamulu.tieba.ch;

import android.telephony.TelephonyManager;
import com.baidu.tieba.TiebaApplication;
import com.mofamulu.tieba.sign.SignService;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements Runnable {
    final /* synthetic */ bj a;
    private final String b;
    private final bl c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar, String str) {
        this.a = bjVar;
        this.b = str;
        this.c = null;
        if (str == null) {
            bjVar.c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar, bl blVar) {
        this.a = bjVar;
        this.b = null;
        this.c = blVar;
        bjVar.c = true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONSTRUCTOR]}, finally: {[IGET, IGET, INVOKE, IPUT, IF] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IPUT, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [329=4, 331=4] */
    @Override // java.lang.Runnable
    public void run() {
        String str;
        try {
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 15000);
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
            HttpPost httpPost = new HttpPost("http://book.mofamulu.com/api/vs.do");
            httpPost.setHeader("x_from", "android");
            boolean e = bg.c().e(false);
            if (e) {
                String a = bg.a();
                httpPost.setHeader("x_un", a == null ? "" : URLEncoder.encode(a, "UTF-8"));
                httpPost.setHeader("x_v", e ? "1" : "0");
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) TiebaApplication.f().getSystemService("phone");
                    httpPost.setHeader("x_imei", telephonyManager.getDeviceId());
                    httpPost.setHeader("x_sim", telephonyManager.getSimSerialNumber());
                    httpPost.setHeader("x_imsi", telephonyManager.getSubscriberId());
                } catch (Throwable th) {
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.b != null) {
                arrayList.add(new BasicNameValuePair("ns[]", this.b));
            } else {
                Iterator<String> keys = this.a.a.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next instanceof String) {
                        arrayList.add(new BasicNameValuePair("ns[]", next));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                a(null);
                if (str == null) {
                    return;
                }
                return;
            }
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                JSONObject jSONObject = (JSONObject) new JSONTokener(EntityUtils.toString(execute.getEntity()).trim()).nextValue();
                Iterator<String> keys2 = jSONObject.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (next2 instanceof String) {
                        this.a.a.put(next2, jSONObject.optInt(next2, 0));
                    }
                }
                this.a.b = System.currentTimeMillis();
                this.a.e();
                SignService.a();
            } else if (this.b == null) {
                this.a.b += 600000;
            }
            if (this.b == null) {
                this.a.c = false;
            }
            a(null);
        } catch (Throwable th2) {
            try {
                if (this.b == null) {
                    this.a.b += 600000;
                }
                a(th2 instanceof IOException ? "网络错误，请稍候再试。" : th2.getMessage());
                if (this.b == null) {
                    this.a.c = false;
                }
            } finally {
                if (this.b == null) {
                    this.a.c = false;
                }
            }
        }
    }

    protected void a(String str) {
        if (this.c != null) {
            this.c.a(str);
        }
    }
}

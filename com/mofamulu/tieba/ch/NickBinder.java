package com.mofamulu.tieba.ch;

import android.graphics.Color;
import android.os.Binder;
import android.telephony.TelephonyManager;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes.dex */
public class NickBinder extends Binder {
    public static ag b = new ag(1048576);
    protected bg a;
    private az d;
    private final NickService e;
    private Map g = new ConcurrentHashMap();
    private Map h = new ConcurrentHashMap();
    private List i = new LinkedList();
    private Object j = new Object();
    private List k = new LinkedList();
    protected volatile boolean c = false;
    private com.mofamulu.tieba.sign.ab f = new aw(this, "check_nick_with_cloud", 2);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        return this.a.q() > 0 && !am.a();
    }

    public void b() {
        this.e.stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NickBinder(NickService nickService) {
        this.e = nickService;
        this.a = new bg(nickService);
        this.d = new az(nickService);
        this.f.start();
    }

    public void c() {
        this.f.c();
        this.f = null;
        synchronized (this.j) {
            this.g.clear();
            this.h.clear();
            this.i.clear();
            this.k.clear();
        }
        this.d.b();
    }

    public av a(String str) {
        av avVar;
        if (str == null) {
            return null;
        }
        try {
            avVar = (av) b.a(str);
        } catch (Throwable th) {
        }
        if (avVar != null) {
            if (a(avVar)) {
                b(str);
                return avVar;
            }
            return avVar;
        }
        if (((LinkedList) this.g.get(str)) == null) {
            this.g.put(str, new LinkedList());
        }
        if (!this.c) {
            this.c = true;
            new ay(this).execute(str);
        }
        return null;
    }

    public boolean a(String str, ba baVar) {
        av avVar;
        try {
            avVar = (av) b.a(str);
        } catch (Throwable th) {
        }
        if (avVar != null) {
            baVar.a(avVar);
            if (a(avVar)) {
                b(str);
            }
            return false;
        }
        LinkedList linkedList = (LinkedList) this.g.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList();
            this.g.put(str, linkedList);
        }
        synchronized (this.j) {
            linkedList.add(baVar);
        }
        if (!this.c) {
            this.c = true;
            new ay(this).execute(str);
        }
        return true;
    }

    public boolean d() {
        try {
            this.d.a();
            b.a();
            a(bg.a());
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(av avVar) {
        if (avVar == null) {
            return true;
        }
        long h = this.a.h();
        if (avVar.b != null && avVar.b.equalsIgnoreCase(bg.a())) {
            h = Math.min(h, 3600000L);
        }
        return System.currentTimeMillis() - avVar.f() > h;
    }

    public void b(String str) {
        if (!this.k.contains(str) && !this.i.contains(str)) {
            synchronized (this.j) {
                this.i.add(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        if ((!a() || !z || this.g.size() >= 100) && this.g.isEmpty() && !this.i.isEmpty()) {
            synchronized (this.j) {
                this.k = this.i;
                this.i = new LinkedList();
            }
            try {
                if (a.b()) {
                    new ax(this, this.k).execute(0);
                } else {
                    a(this.k);
                }
            } catch (Throwable th) {
            }
        }
    }

    public LinkedList a(List list) {
        LinkedList linkedList = new LinkedList();
        try {
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 15000);
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
            HttpPost httpPost = new HttpPost("http://n.guzzservices.com/api/ns.do");
            httpPost.setHeader("x_from", "android");
            boolean e = bg.c().e(false);
            if (e) {
                String a = bg.a();
                httpPost.setHeader("x_un", a == null ? "" : URLEncoder.encode(a, "UTF-8"));
                httpPost.setHeader("x_v", e ? "1" : "0");
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) this.e.getSystemService("phone");
                    httpPost.setHeader("x_imei", telephonyManager.getDeviceId());
                    httpPost.setHeader("x_sim", telephonyManager.getSimSerialNumber());
                    httpPost.setHeader("x_imsi", telephonyManager.getSubscriberId());
                } catch (Throwable th) {
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new BasicNameValuePair("ns[]", (String) it.next()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                JSONObject jSONObject = (JSONObject) new JSONTokener(EntityUtils.toString(execute.getEntity())).nextValue();
                long currentTimeMillis = System.currentTimeMillis();
                long j = (currentTimeMillis - (currentTimeMillis % 1800000)) + 1800000;
                for (int i = 0; i < list.size(); i++) {
                    String str = (String) list.get(i);
                    JSONArray optJSONArray = jSONObject.optJSONArray(str);
                    av avVar = new av();
                    avVar.b = str;
                    avVar.h = j;
                    if (optJSONArray == null) {
                        avVar.g = 2;
                    } else if (optJSONArray.length() == 0) {
                        avVar.g = 1;
                    } else {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                        avVar.g = 0;
                        avVar.c = jSONObject2.optString("text");
                        avVar.e = jSONObject2.optString("w");
                        avVar.f = jSONObject2.optString("s");
                        avVar.i = jSONObject2.optString("b");
                        String optString = jSONObject2.optString("y");
                        if (bf.b(optString)) {
                            try {
                                avVar.d = Color.parseColor(optString);
                            } catch (Throwable th2) {
                            }
                        }
                    }
                    b.a(avVar.b, avVar);
                    linkedList.add(avVar);
                }
            }
        } catch (Throwable th3) {
        }
        if (!linkedList.isEmpty()) {
            this.d.a(linkedList);
        }
        return linkedList;
    }
}

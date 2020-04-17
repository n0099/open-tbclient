package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class cj implements co {
    private static cj a;

    /* renamed from: a  reason: collision with other field name */
    private int f185a;

    /* renamed from: a  reason: collision with other field name */
    private Context f186a;

    /* renamed from: a  reason: collision with other field name */
    private ci f187a;

    /* renamed from: a  reason: collision with other field name */
    private String f188a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, ch> f189a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private String f190b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private String f191c;
    private int d;

    public static synchronized cj a() {
        cj cjVar;
        synchronized (cj.class) {
            cjVar = a;
        }
        return cjVar;
    }

    private String a(ArrayList<cg> arrayList, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(this.f188a)) {
            jSONObject2.put("imei", cm.a(this.f188a));
        }
        jSONObject2.put("actionType", str);
        jSONObject2.put("actionTime", System.currentTimeMillis());
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                jSONObject2.put("adList", new JSONArray((Collection) arrayList2));
                return Base64.encodeToString(jSONObject2.toString().getBytes(), 2);
            }
            if (TextUtils.isEmpty(arrayList.get(i2).f182a)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(arrayList.get(i2).f182a);
                } catch (Exception e) {
                    Log.e("com.xiaomi.miui.ads.pushsdk", "content 不是json串");
                    jSONObject = null;
                }
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject3 = jSONObject;
            jSONObject3.put("adId", arrayList.get(i2).f181a);
            arrayList2.add(jSONObject3);
            i = i2 + 1;
        }
    }

    private void a(ch chVar) {
        if (this.f189a.containsKey(chVar.b)) {
            return;
        }
        this.b++;
        cm.m197a("send: " + this.b);
        ck ckVar = new ck(this, this.f190b, this.f191c, chVar);
        this.f189a.put(chVar.b, chVar);
        ckVar.execute(new String[0]);
    }

    private void a(ArrayList<cg> arrayList, String str, int i) {
        try {
            String a2 = a(arrayList, str);
            String a3 = cm.a(a2);
            if (m196a(new ch(i, a2, a3))) {
                a(new ch(i, a2, a3));
            }
        } catch (JSONException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m196a(ch chVar) {
        if (cl.a(this.f186a)) {
            return true;
        }
        b(chVar);
        return false;
    }

    private void b(ch chVar) {
        this.d++;
        cm.m197a("cacheCount: " + this.d);
        this.f187a.a(chVar);
        this.f187a.a();
    }

    public void a(cg cgVar) {
        if (cgVar.f181a <= 0) {
            return;
        }
        ArrayList<cg> arrayList = new ArrayList<>();
        arrayList.add(cgVar);
        a(arrayList, "click", cgVar.a);
    }

    @Override // com.xiaomi.push.co
    public void a(Integer num, ch chVar) {
        if (this.f189a.containsKey(chVar.b)) {
            if (num.intValue() != 0) {
                this.c++;
                cm.m197a("faild: " + this.c + " " + chVar.b + "  " + this.f189a.size());
                b(chVar);
            } else {
                this.f185a++;
                cm.m197a("success: " + this.f185a);
            }
            this.f189a.remove(chVar.b);
        }
    }

    public void b(cg cgVar) {
        if (cgVar.f181a <= 0) {
            return;
        }
        ArrayList<cg> arrayList = new ArrayList<>();
        arrayList.add(cgVar);
        a(arrayList, "remove", cgVar.a);
    }

    public void c(cg cgVar) {
        if (cgVar.f181a <= 0) {
            return;
        }
        ArrayList<cg> arrayList = new ArrayList<>();
        arrayList.add(cgVar);
        a(arrayList, "received", cgVar.a);
    }
}

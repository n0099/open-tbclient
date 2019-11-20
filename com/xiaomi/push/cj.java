package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cj implements co {
    private static cj a;

    /* renamed from: a  reason: collision with other field name */
    private int f184a;

    /* renamed from: a  reason: collision with other field name */
    private Context f185a;

    /* renamed from: a  reason: collision with other field name */
    private ci f186a;

    /* renamed from: a  reason: collision with other field name */
    private String f187a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, ch> f188a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private String f189b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private String f190c;
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
        if (!TextUtils.isEmpty(this.f187a)) {
            jSONObject2.put("imei", cm.a(this.f187a));
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
            if (TextUtils.isEmpty(arrayList.get(i2).f181a)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(arrayList.get(i2).f181a);
                } catch (Exception e) {
                    Log.e("com.xiaomi.miui.ads.pushsdk", "content 不是json串");
                    jSONObject = null;
                }
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject3 = jSONObject;
            jSONObject3.put("adId", arrayList.get(i2).f180a);
            arrayList2.add(jSONObject3);
            i = i2 + 1;
        }
    }

    private void a(ch chVar) {
        if (this.f188a.containsKey(chVar.b)) {
            return;
        }
        this.b++;
        cm.m177a("send: " + this.b);
        ck ckVar = new ck(this, this.f189b, this.f190c, chVar);
        this.f188a.put(chVar.b, chVar);
        ckVar.execute(new String[0]);
    }

    private void a(ArrayList<cg> arrayList, String str, int i) {
        try {
            String a2 = a(arrayList, str);
            String a3 = cm.a(a2);
            if (m176a(new ch(i, a2, a3))) {
                a(new ch(i, a2, a3));
            }
        } catch (JSONException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m176a(ch chVar) {
        if (cl.a(this.f185a)) {
            return true;
        }
        b(chVar);
        return false;
    }

    private void b(ch chVar) {
        this.d++;
        cm.m177a("cacheCount: " + this.d);
        this.f186a.a(chVar);
        this.f186a.a();
    }

    public void a(cg cgVar) {
        if (cgVar.f180a <= 0) {
            return;
        }
        ArrayList<cg> arrayList = new ArrayList<>();
        arrayList.add(cgVar);
        a(arrayList, "click", cgVar.a);
    }

    @Override // com.xiaomi.push.co
    public void a(Integer num, ch chVar) {
        if (this.f188a.containsKey(chVar.b)) {
            if (num.intValue() != 0) {
                this.c++;
                cm.m177a("faild: " + this.c + HanziToPinyin.Token.SEPARATOR + chVar.b + "  " + this.f188a.size());
                b(chVar);
            } else {
                this.f184a++;
                cm.m177a("success: " + this.f184a);
            }
            this.f188a.remove(chVar.b);
        }
    }

    public void b(cg cgVar) {
        if (cgVar.f180a <= 0) {
            return;
        }
        ArrayList<cg> arrayList = new ArrayList<>();
        arrayList.add(cgVar);
        a(arrayList, "remove", cgVar.a);
    }

    public void c(cg cgVar) {
        if (cgVar.f180a <= 0) {
            return;
        }
        ArrayList<cg> arrayList = new ArrayList<>();
        arrayList.add(cgVar);
        a(arrayList, "received", cgVar.a);
    }
}

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
public class co implements ct {
    private static co a;

    /* renamed from: a  reason: collision with other field name */
    private int f175a;

    /* renamed from: a  reason: collision with other field name */
    private Context f176a;

    /* renamed from: a  reason: collision with other field name */
    private cn f177a;

    /* renamed from: a  reason: collision with other field name */
    private String f178a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, cm> f179a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private String f180b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private String f181c;
    private int d;

    public static synchronized co a() {
        co coVar;
        synchronized (co.class) {
            coVar = a;
        }
        return coVar;
    }

    private String a(ArrayList<cl> arrayList, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(this.f178a)) {
            jSONObject2.put("imei", cr.a(this.f178a));
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
            if (TextUtils.isEmpty(arrayList.get(i2).f172a)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(arrayList.get(i2).f172a);
                } catch (Exception e) {
                    Log.e("com.xiaomi.miui.ads.pushsdk", "content 不是json串");
                    jSONObject = null;
                }
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject3 = jSONObject;
            jSONObject3.put("adId", arrayList.get(i2).f171a);
            arrayList2.add(jSONObject3);
            i = i2 + 1;
        }
    }

    private void a(cm cmVar) {
        if (this.f179a.containsKey(cmVar.b)) {
            return;
        }
        this.b++;
        cr.m197a("send: " + this.b);
        cp cpVar = new cp(this, this.f180b, this.f181c, cmVar);
        this.f179a.put(cmVar.b, cmVar);
        cpVar.execute(new String[0]);
    }

    private void a(ArrayList<cl> arrayList, String str, int i) {
        try {
            String a2 = a(arrayList, str);
            String a3 = cr.a(a2);
            if (m196a(new cm(i, a2, a3))) {
                a(new cm(i, a2, a3));
            }
        } catch (JSONException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m196a(cm cmVar) {
        if (cq.a(this.f176a)) {
            return true;
        }
        b(cmVar);
        return false;
    }

    private void b(cm cmVar) {
        this.d++;
        cr.m197a("cacheCount: " + this.d);
        this.f177a.a(cmVar);
        this.f177a.a();
    }

    public void a(cl clVar) {
        if (clVar.f171a <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<>();
        arrayList.add(clVar);
        a(arrayList, "click", clVar.a);
    }

    @Override // com.xiaomi.push.ct
    public void a(Integer num, cm cmVar) {
        if (this.f179a.containsKey(cmVar.b)) {
            if (num.intValue() != 0) {
                this.c++;
                cr.m197a("faild: " + this.c + " " + cmVar.b + "  " + this.f179a.size());
                b(cmVar);
            } else {
                this.f175a++;
                cr.m197a("success: " + this.f175a);
            }
            this.f179a.remove(cmVar.b);
        }
    }

    public void b(cl clVar) {
        if (clVar.f171a <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<>();
        arrayList.add(clVar);
        a(arrayList, "remove", clVar.a);
    }

    public void c(cl clVar) {
        if (clVar.f171a <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<>();
        arrayList.add(clVar);
        a(arrayList, "received", clVar.a);
    }
}

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
/* loaded from: classes6.dex */
public class co implements ct {

    /* renamed from: a  reason: collision with root package name */
    private static co f13917a;

    /* renamed from: a  reason: collision with other field name */
    private int f249a;

    /* renamed from: a  reason: collision with other field name */
    private Context f250a;

    /* renamed from: a  reason: collision with other field name */
    private cn f251a;

    /* renamed from: a  reason: collision with other field name */
    private String f252a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, cm> f253a;

    /* renamed from: b  reason: collision with root package name */
    private int f13918b;

    /* renamed from: b  reason: collision with other field name */
    private String f254b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private String f255c;
    private int d;

    public static synchronized co a() {
        co coVar;
        synchronized (co.class) {
            coVar = f13917a;
        }
        return coVar;
    }

    private String a(ArrayList<cl> arrayList, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(this.f252a)) {
            jSONObject2.put("imei", cr.a(this.f252a));
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
            if (TextUtils.isEmpty(arrayList.get(i2).f246a)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(arrayList.get(i2).f246a);
                } catch (Exception e) {
                    Log.e("com.xiaomi.miui.ads.pushsdk", "content 不是json串");
                    jSONObject = null;
                }
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject3 = jSONObject;
            jSONObject3.put("adId", arrayList.get(i2).f245a);
            arrayList2.add(jSONObject3);
            i = i2 + 1;
        }
    }

    private void a(cm cmVar) {
        if (this.f253a.containsKey(cmVar.f13915b)) {
            return;
        }
        this.f13918b++;
        cr.m229a("send: " + this.f13918b);
        cp cpVar = new cp(this, this.f254b, this.f255c, cmVar);
        this.f253a.put(cmVar.f13915b, cmVar);
        cpVar.execute(new String[0]);
    }

    private void a(ArrayList<cl> arrayList, String str, int i) {
        try {
            String a2 = a(arrayList, str);
            String a3 = cr.a(a2);
            if (m228a(new cm(i, a2, a3))) {
                a(new cm(i, a2, a3));
            }
        } catch (JSONException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m228a(cm cmVar) {
        if (cq.a(this.f250a)) {
            return true;
        }
        b(cmVar);
        return false;
    }

    private void b(cm cmVar) {
        this.d++;
        cr.m229a("cacheCount: " + this.d);
        this.f251a.a(cmVar);
        this.f251a.a();
    }

    public void a(cl clVar) {
        if (clVar.f245a <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<>();
        arrayList.add(clVar);
        a(arrayList, "click", clVar.f13913a);
    }

    @Override // com.xiaomi.push.ct
    public void a(Integer num, cm cmVar) {
        if (this.f253a.containsKey(cmVar.f13915b)) {
            if (num.intValue() != 0) {
                this.c++;
                cr.m229a("faild: " + this.c + " " + cmVar.f13915b + "  " + this.f253a.size());
                b(cmVar);
            } else {
                this.f249a++;
                cr.m229a("success: " + this.f249a);
            }
            this.f253a.remove(cmVar.f13915b);
        }
    }

    public void b(cl clVar) {
        if (clVar.f245a <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<>();
        arrayList.add(clVar);
        a(arrayList, "remove", clVar.f13913a);
    }

    public void c(cl clVar) {
        if (clVar.f245a <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<>();
        arrayList.add(clVar);
        a(arrayList, "received", clVar.f13913a);
    }
}

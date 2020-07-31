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
/* loaded from: classes9.dex */
public class co implements ct {
    private static co a;

    /* renamed from: a  reason: collision with other field name */
    private int f172a;

    /* renamed from: a  reason: collision with other field name */
    private Context f173a;

    /* renamed from: a  reason: collision with other field name */
    private cn f174a;

    /* renamed from: a  reason: collision with other field name */
    private String f175a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, cm> f176a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private String f177b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private String f178c;
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
        if (!TextUtils.isEmpty(this.f175a)) {
            jSONObject2.put("imei", cr.a(this.f175a));
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
            if (TextUtils.isEmpty(arrayList.get(i2).f169a)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(arrayList.get(i2).f169a);
                } catch (Exception e) {
                    Log.e("com.xiaomi.miui.ads.pushsdk", "content 不是json串");
                    jSONObject = null;
                }
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject3 = jSONObject;
            jSONObject3.put("adId", arrayList.get(i2).f168a);
            arrayList2.add(jSONObject3);
            i = i2 + 1;
        }
    }

    private void a(cm cmVar) {
        if (this.f176a.containsKey(cmVar.b)) {
            return;
        }
        this.b++;
        cr.m198a("send: " + this.b);
        cp cpVar = new cp(this, this.f177b, this.f178c, cmVar);
        this.f176a.put(cmVar.b, cmVar);
        cpVar.execute(new String[0]);
    }

    private void a(ArrayList<cl> arrayList, String str, int i) {
        try {
            String a2 = a(arrayList, str);
            String a3 = cr.a(a2);
            if (m197a(new cm(i, a2, a3))) {
                a(new cm(i, a2, a3));
            }
        } catch (JSONException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m197a(cm cmVar) {
        if (cq.a(this.f173a)) {
            return true;
        }
        b(cmVar);
        return false;
    }

    private void b(cm cmVar) {
        this.d++;
        cr.m198a("cacheCount: " + this.d);
        this.f174a.a(cmVar);
        this.f174a.a();
    }

    public void a(cl clVar) {
        if (clVar.f168a <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<>();
        arrayList.add(clVar);
        a(arrayList, "click", clVar.a);
    }

    @Override // com.xiaomi.push.ct
    public void a(Integer num, cm cmVar) {
        if (this.f176a.containsKey(cmVar.b)) {
            if (num.intValue() != 0) {
                this.c++;
                cr.m198a("faild: " + this.c + " " + cmVar.b + "  " + this.f176a.size());
                b(cmVar);
            } else {
                this.f172a++;
                cr.m198a("success: " + this.f172a);
            }
            this.f176a.remove(cmVar.b);
        }
    }

    public void b(cl clVar) {
        if (clVar.f168a <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<>();
        arrayList.add(clVar);
        a(arrayList, "remove", clVar.a);
    }

    public void c(cl clVar) {
        if (clVar.f168a <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<>();
        arrayList.add(clVar);
        a(arrayList, "received", clVar.a);
    }
}

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
/* loaded from: classes18.dex */
public class co implements ct {

    /* renamed from: a  reason: collision with root package name */
    private static co f4842a;

    /* renamed from: a  reason: collision with other field name */
    private int f173a;

    /* renamed from: a  reason: collision with other field name */
    private Context f174a;

    /* renamed from: a  reason: collision with other field name */
    private cn f175a;

    /* renamed from: a  reason: collision with other field name */
    private String f176a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, cm> f177a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private String f178b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private String f179c;
    private int d;

    public static synchronized co a() {
        co coVar;
        synchronized (co.class) {
            coVar = f4842a;
        }
        return coVar;
    }

    private String a(ArrayList<cl> arrayList, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(this.f176a)) {
            jSONObject2.put("imei", cr.a(this.f176a));
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
            if (TextUtils.isEmpty(arrayList.get(i2).f170a)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(arrayList.get(i2).f170a);
                } catch (Exception e) {
                    Log.e("com.xiaomi.miui.ads.pushsdk", "content 不是json串");
                    jSONObject = null;
                }
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject3 = jSONObject;
            jSONObject3.put("adId", arrayList.get(i2).f169a);
            arrayList2.add(jSONObject3);
            i = i2 + 1;
        }
    }

    private void a(cm cmVar) {
        if (this.f177a.containsKey(cmVar.b)) {
            return;
        }
        this.b++;
        cr.m206a("send: " + this.b);
        cp cpVar = new cp(this, this.f178b, this.f179c, cmVar);
        this.f177a.put(cmVar.b, cmVar);
        cpVar.execute(new String[0]);
    }

    private void a(ArrayList<cl> arrayList, String str, int i) {
        try {
            String a2 = a(arrayList, str);
            String a3 = cr.a(a2);
            if (m205a(new cm(i, a2, a3))) {
                a(new cm(i, a2, a3));
            }
        } catch (JSONException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m205a(cm cmVar) {
        if (cq.a(this.f174a)) {
            return true;
        }
        b(cmVar);
        return false;
    }

    private void b(cm cmVar) {
        this.d++;
        cr.m206a("cacheCount: " + this.d);
        this.f175a.a(cmVar);
        this.f175a.a();
    }

    public void a(cl clVar) {
        if (clVar.f169a <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<>();
        arrayList.add(clVar);
        a(arrayList, "click", clVar.f4839a);
    }

    @Override // com.xiaomi.push.ct
    public void a(Integer num, cm cmVar) {
        if (this.f177a.containsKey(cmVar.b)) {
            if (num.intValue() != 0) {
                this.c++;
                cr.m206a("faild: " + this.c + " " + cmVar.b + "  " + this.f177a.size());
                b(cmVar);
            } else {
                this.f173a++;
                cr.m206a("success: " + this.f173a);
            }
            this.f177a.remove(cmVar.b);
        }
    }

    public void b(cl clVar) {
        if (clVar.f169a <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<>();
        arrayList.add(clVar);
        a(arrayList, "remove", clVar.f4839a);
    }

    public void c(cl clVar) {
        if (clVar.f169a <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<>();
        arrayList.add(clVar);
        a(arrayList, "received", clVar.f4839a);
    }
}

package com.qq.e.comm.plugin.n;

import android.view.View;
import com.qq.e.comm.plugin.n.f;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.util.bd;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class e extends com.qq.e.comm.plugin.ab.f.a.c {

    /* renamed from: a  reason: collision with root package name */
    private com.qq.e.comm.plugin.s.e f12244a;

    /* renamed from: b  reason: collision with root package name */
    private f.a f12245b;

    public e(com.qq.e.comm.plugin.s.e eVar, f.a aVar) {
        this.f12244a = eVar;
        this.f12245b = aVar;
    }

    @Override // com.qq.e.comm.plugin.ab.f.a.c
    public com.qq.e.comm.plugin.ab.c.f<String> a(com.qq.e.comm.plugin.ab.f.e eVar, View view, String str, String str2, String str3, String str4) {
        String str5;
        GDTLogger.d("EndCardView JS action : " + str2);
        com.qq.e.comm.plugin.s.a c = this.f12245b.c();
        if ("getVideoAdInfo".equals(str2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject a2 = n.a(view.getContext(), c);
                jSONObject.put("code", 0);
                JSONObject jSONObject2 = new JSONObject();
                JSONObject a3 = this.f12244a.a();
                jSONObject2.put("adInfo", a2);
                jSONObject2.put("cfg", a3);
                jSONObject.put("data", jSONObject2);
                return new com.qq.e.comm.plugin.ab.c.f<>(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
                GDTLogger.d("EndCardView getVideoAdInfo JSONException : " + e.getMessage());
                return new com.qq.e.comm.plugin.ab.c.f<>(null);
            }
        } else if ("onClick".equals(str2)) {
            try {
                str5 = new JSONObject(str3).optString("antiSpam");
            } catch (JSONException e2) {
                e2.printStackTrace();
                str5 = null;
            }
            if (this.f12245b != null) {
                this.f12245b.a(str5, false);
            }
            return new com.qq.e.comm.plugin.ab.c.f<>(null);
        } else if ("isViewable".equals(str2)) {
            if (view == null) {
                return new com.qq.e.comm.plugin.ab.c.f<>(null);
            }
            boolean a4 = bd.a(view.getContext(), view, 100);
            GDTLogger.d("isViewable : " + a4);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("viewable", a4);
                return new com.qq.e.comm.plugin.ab.c.f<>(jSONObject3.toString());
            } catch (Exception e3) {
                e3.printStackTrace();
                GDTLogger.d("EndCardView isViewable JSONException : " + e3.getMessage());
                return new com.qq.e.comm.plugin.ab.c.f<>(null);
            }
        } else {
            return new com.qq.e.comm.plugin.ab.c.f<>(1000, "Unsupported action");
        }
    }
}

package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.UIMsg;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.a.i;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private b f12516a;

    /* renamed from: b  reason: collision with root package name */
    private c f12517b;
    private Context c;
    private com.qq.e.comm.plugin.c.a.a d;
    private String e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum a {
        NOT_DEEP_LINK,
        FAILED,
        SUCCESS
    }

    public g(Context context, b bVar, c cVar) {
        this.c = context;
        this.f12516a = bVar;
        this.f12517b = cVar;
        this.d = new com.qq.e.comm.plugin.c.a.c(this.c) { // from class: com.qq.e.comm.plugin.m.g.1
            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void a(com.qq.e.comm.plugin.s.a aVar) {
                super.a(aVar);
                g.this.a(null, false, g.this.e);
            }

            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void b(com.qq.e.comm.plugin.s.a aVar) {
                super.b(aVar);
                g.this.a(null, false, g.this.e);
            }

            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void c(String str) {
                super.c(str);
                g.this.a(str, false, g.this.e);
            }
        };
    }

    private a a() {
        if (this.f12517b.a_() == 12 || this.f12517b.a_() == 1000 || this.f12517b.a_() == 38 || this.f12517b.a_() == 25) {
            String e = this.f12517b.e();
            if (az.b(e)) {
                return com.qq.e.comm.plugin.w.a.c.a(this.c, com.qq.e.comm.plugin.util.d.d(this.f12517b.E()).d(), e, this.f12517b.m(), null) ? a.SUCCESS : a.FAILED;
            }
        }
        return a.NOT_DEEP_LINK;
    }

    private void a(String str, final a aVar) {
        d.a a2 = com.qq.e.comm.plugin.w.i.a(this.f12517b);
        d.e eVar = new d.e(this.f12516a.f12485b, com.qq.e.comm.plugin.ad.e.EXPRESS2, this.f12516a.f12484a);
        d.b a3 = d.a(0, -1, this.f12517b, this.f12516a.f.q(), str, this.f12516a.c);
        a3.i = com.qq.e.comm.plugin.ad.a.a().b(this.f12516a.f.q());
        if (((Boolean) com.qq.e.comm.plugin.w.a.i.a(this.f12516a.f.q(), a2, a3, eVar, new i.a() { // from class: com.qq.e.comm.plugin.m.g.2
            @Override // com.qq.e.comm.plugin.w.a.i.a
            public void a(String str2, boolean z) {
                if (aVar == a.FAILED && z) {
                    com.qq.e.comm.plugin.w.a.a(str2);
                }
            }
        }).second).booleanValue() || !this.f12517b.ah()) {
            return;
        }
        a(false, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        if (com.qq.e.comm.plugin.nativeadunified.c.a() != null) {
            GDTLogger.e("广告点击太快");
            return;
        }
        com.qq.e.comm.plugin.nativeadunified.c.a(this.f12516a);
        com.qq.e.comm.plugin.nativeadunified.c.a(z);
        this.f12516a.f.u();
        com.qq.e.comm.plugin.nativeadunified.c.a(d.a(0, -1, this.f12517b, this.f12516a.f.q(), str2, this.f12516a.c));
        com.qq.e.comm.plugin.nativeadunified.c.a(new d.e(this.f12516a.f12485b, com.qq.e.comm.plugin.ad.e.EXPRESS2, this.f12516a.f12484a));
        Intent intent = new Intent();
        Context applicationContext = this.c.getApplicationContext();
        intent.setClassName(applicationContext.getApplicationContext(), ar.b());
        intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, "detailPage");
        intent.putExtra("antiSpam", str2);
        intent.putExtra("url", str);
        if (this.f12516a.d != null) {
            intent.putExtra("detailPageMuted", this.f12516a.d.isDetailPageMuted());
        }
        intent.addFlags(268435456);
        applicationContext.startActivity(intent);
    }

    private void a(boolean z, String str) {
        a(null, z, str);
    }

    private boolean a(String str, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("componentInfo");
        if (optJSONObject == null) {
            return false;
        }
        switch (optJSONObject.optInt("type", -1)) {
            case 1:
                this.f12516a.a(str, 0, UIMsg.m_AppUI.MSG_CLICK_ITEM);
                return true;
            case 2:
                d.a(this.c, this.f12517b);
                this.f12516a.a(str, 0, com.baidu.pass.ecommerce.d.b.p);
                return true;
            case 3:
                this.f12516a.a(str, 0, 9002);
                return true;
            default:
                return false;
        }
    }

    private boolean a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("componentInfo");
        if (optJSONObject != null) {
            int optInt = optJSONObject.optInt("type", -1);
            return optInt == 1 || optInt == 2 || optInt == 3;
        }
        return false;
    }

    private void b(String str) {
        JSONObject jSONObject;
        this.f12516a.c(200);
        if (TextUtils.isEmpty(str) || this.f12516a.f == null) {
            GDTLogger.e("ExpressAdDataController click error params: " + str + "  mAdViewController: " + this.f12516a.f);
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            GDTLogger.e("ExpressAdDataController click error json parse error");
            return;
        }
        this.f12516a.a((View) null);
        this.e = d.a(jSONObject.optString("clickInfo"));
        com.qq.e.comm.plugin.c.f a2 = new f.a(this.f12517b, this.f12516a.f.q()).a(this.e).a();
        if (a(jSONObject)) {
            com.qq.e.comm.plugin.c.e.c(a2, this.d);
        } else {
            com.qq.e.comm.plugin.c.e.a(a2, this.d);
        }
        this.f12516a.a(101, new Object[0]);
    }

    private int c(String str) {
        JSONObject jSONObject;
        this.f12516a.c(200);
        if (TextUtils.isEmpty(str) || this.f12516a.f == null) {
            GDTLogger.e("ExpressAdDataController click error params: " + str + "  mAdViewController: " + this.f12516a.f);
            return 201;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            GDTLogger.e("ExpressAdDataController click error json parse error");
            return 201;
        }
        this.f12516a.a((View) null);
        this.e = d.a(jSONObject.optString("clickInfo"));
        if (a(this.e, jSONObject)) {
            return 202;
        }
        if (!this.f12517b.ah()) {
            this.f12516a.a(this.e, 0);
            return 206;
        } else if (com.qq.e.comm.plugin.util.b.b(this.f12517b)) {
            a(this.e, (a) null);
            return 203;
        } else {
            a a2 = a();
            if (a.SUCCESS == a2) {
                this.f12516a.a(this.e, 4);
                return 204;
            } else if (com.qq.e.comm.plugin.util.b.f(this.f12517b.E())) {
                a(this.e, a2);
                return 205;
            } else {
                if (!this.f12517b.v() || (this.f12517b.w() && !this.f12517b.aa())) {
                    a(a2 == a.FAILED, this.e);
                } else {
                    this.f12516a.a(this.e, a2 == a.FAILED ? 3 : 1);
                    a(false, this.e);
                }
                return 206;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, String str) {
        com.qq.e.comm.plugin.c.e.b(new f.a(this.f12517b, view).a(str).a(), this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        if (com.qq.e.comm.plugin.c.e.a(this.f12517b)) {
            b(str);
            return;
        }
        int c = c(str);
        if (c != 201) {
            this.f12516a.a(101, new Object[0]);
            this.f12516a.c(c);
        }
    }
}

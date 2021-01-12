package com.qq.e.comm.plugin.gdtnativead;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.UIMsg;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.a.i;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private h f12071a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.c.a.a f12072b;

    public i(h hVar, com.qq.e.comm.plugin.c.a.a aVar) {
        this.f12071a = hVar;
        this.f12072b = aVar;
    }

    private d.b a(int i, int i2) {
        int a2 = b.a(this.f12071a.b());
        com.qq.e.comm.plugin.ad.f c = c();
        boolean a3 = com.qq.e.comm.plugin.util.d.a(this.f12071a.c);
        String o = this.f12071a.o();
        if (i2 == -1) {
            i2 = (!a3 || com.qq.e.comm.plugin.util.b.g(this.f12071a.c)) ? 0 : 1;
        }
        if (this.f12071a.d.a_() == 48) {
            i2 = 48;
        }
        return new d.b(i2, this.f12071a.o == 2 ? d.c.SysBrowser : d.c.InnerBrowser).a(i).a(o).b(a2).a(c);
    }

    private void a() {
        com.qq.e.comm.plugin.s.c l = this.f12071a.d.l();
        if (l == null) {
            return;
        }
        String c = l.c();
        if (TextUtils.isEmpty(c)) {
            return;
        }
        new com.qq.e.comm.plugin.ac.e(this.f12071a.m).a(c);
    }

    private void a(final int i) {
        b(0);
        if (!this.f12071a.f) {
            this.f12071a.k();
        }
        d.a a2 = com.qq.e.comm.plugin.w.i.a(this.f12071a.d);
        d.e eVar = new d.e(this.f12071a.a(), com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD, this.f12071a.b());
        d.b a3 = a(0, -1);
        a3.i = com.qq.e.comm.plugin.ad.a.a().b(this.f12071a.l);
        if (((Boolean) com.qq.e.comm.plugin.w.a.i.a(this.f12071a.f12027a, a2, a3, eVar, new i.a() { // from class: com.qq.e.comm.plugin.gdtnativead.i.1
            @Override // com.qq.e.comm.plugin.w.a.i.a
            public void a(String str, boolean z) {
                if (i == 1 && z) {
                    com.qq.e.comm.plugin.w.a.a(str);
                }
            }
        }).second).booleanValue()) {
            return;
        }
        this.f12071a.a(false);
    }

    private void a(int i, boolean z) {
        if (i == 4) {
            com.qq.e.comm.plugin.a.c d = this.f12071a.d(this.f12071a.g.d());
            if (d != null) {
                l.a().a(d.m(), 1);
            }
        } else if (i != 32) {
            a(null, 2, -1, z);
        } else {
            com.qq.e.comm.plugin.a.c d2 = this.f12071a.d(this.f12071a.g.d());
            if (d2 != null) {
                l.a().a(d2.m());
            }
        }
    }

    private void a(String str, JSONObject jSONObject) {
        if (str.equals(String.valueOf(1))) {
            a(jSONObject, 0, UIMsg.m_AppUI.MSG_CLICK_ITEM);
        } else if (str.equals(String.valueOf(2))) {
            a();
            a(jSONObject, 0, com.baidu.pass.ecommerce.d.b.p);
        } else if (str.equals(String.valueOf(3))) {
            a(jSONObject, 0, 9002);
        }
    }

    private void a(JSONObject jSONObject, int i) {
        a(jSONObject, i, -1, false);
    }

    private void a(JSONObject jSONObject, int i, int i2) {
        a(jSONObject, i, i2, false);
    }

    private void a(JSONObject jSONObject, int i, int i2, boolean z) {
        GDTLogger.d("sendClickRequest:" + jSONObject + ", action:" + i);
        if (!z) {
            b(i);
        }
        d.a a2 = com.qq.e.comm.plugin.w.i.a(this.f12071a.d);
        d.e eVar = new d.e(this.f12071a.a(), com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD, this.f12071a.b());
        d.b a3 = a(i, i2);
        a3.i = com.qq.e.comm.plugin.ad.a.a().b(this.f12071a.l);
        com.qq.e.comm.plugin.w.a.d.a(this.f12071a.f12027a, a2, eVar, a3);
    }

    private int b() {
        int optInt;
        if (this.f12071a.k == 1 && ((optInt = this.f12071a.c.optInt("producttype")) == 12 || optInt == 1000 || optInt == 38 || optInt == 25)) {
            String optString = this.f12071a.c.optString("customized_invoke_url");
            if (az.b(optString)) {
                if (com.qq.e.comm.plugin.w.a.c.a(this.f12071a.h, com.qq.e.comm.plugin.util.d.e(this.f12071a.c), optString, com.qq.e.comm.plugin.util.b.d(this.f12071a.c), null)) {
                    if (!this.f12071a.f) {
                        this.f12071a.k();
                    }
                    return 2;
                }
                return 1;
            }
        }
        return 0;
    }

    private void b(int i) {
        if (SDKStatus.getSDKVersionCode() >= 10) {
            this.f12071a.a(6, new Object[]{this.f12071a.f12028b, ""});
        } else {
            this.f12071a.a(6, new Object[]{this.f12071a.f12028b});
        }
    }

    private void b(JSONObject jSONObject) {
        if (!this.f12071a.m()) {
            if (this.f12071a.c == null || !this.f12071a.e) {
                return;
            }
            a(jSONObject, 0);
            return;
        }
        if (this.f12071a.i != null && this.f12071a.j != null && this.f12071a.j.getVisibility() != 0) {
            this.f12071a.j.setVisibility(0);
            com.qq.e.comm.plugin.aa.b.a.a(this.f12071a.i);
        }
        if (com.qq.e.comm.plugin.util.b.c(this.f12071a.c) && this.f12071a.k == 1) {
            a(-1);
            return;
        }
        int b2 = b();
        if (b2 == 2) {
            a(jSONObject, 4);
        } else if (com.qq.e.comm.plugin.util.b.f(this.f12071a.c) && this.f12071a.k == 1) {
            a(b2);
            return;
        } else if (this.f12071a.k == 1 && com.qq.e.comm.plugin.util.d.a(this.f12071a.c) && !com.qq.e.comm.plugin.util.d.b(this.f12071a.c)) {
            if (b2 == 1) {
                a(jSONObject, 3);
            } else {
                a(jSONObject, 1);
            }
            this.f12071a.a(false);
        } else if (b2 == 1) {
            b(0);
            this.f12071a.a(true);
        } else {
            b(0);
            this.f12071a.a(false);
        }
        this.f12071a.f = false;
    }

    private boolean b(String str) {
        return str.equals(String.valueOf(1)) || str.equals(String.valueOf(2)) || str.equals(String.valueOf(3));
    }

    private com.qq.e.comm.plugin.ad.f c() {
        if (this.f12071a.f12027a == null) {
            GDTLogger.e("Native Express AD view is null");
            u.a(100332, 0, this.f12071a.n);
            return null;
        }
        View a2 = this.f12071a.f12027a.a();
        if (a2 != null) {
            Rect rect = new Rect();
            if (a2.getGlobalVisibleRect(rect)) {
                return new com.qq.e.comm.plugin.ad.f(true, a2.getWidth(), a2.getHeight(), rect.width(), rect.height(), a2.toString());
            }
            GDTLogger.d("Ad is not visible.");
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", "InnerBrowser");
        com.qq.e.comm.plugin.w.a.d.a(str, this.f12071a.d.E(), new d.e(this.f12071a.a(), com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD, this.f12071a.b()), a(0, -1), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        com.qq.e.comm.plugin.ad.f c = c();
        String optString = jSONObject.optString("action");
        com.qq.e.comm.plugin.s.a aVar = this.f12071a.d;
        if (b(optString)) {
            if (!com.qq.e.comm.plugin.c.e.a(aVar)) {
                a(optString, jSONObject);
                return;
            }
            com.qq.e.comm.plugin.c.e.c(new f.a(aVar, this.f12071a.l).a(c).a(this.f12071a.o()).a(), this.f12072b);
            b(0);
        } else if (!com.qq.e.comm.plugin.c.e.a(aVar)) {
            b(jSONObject);
        } else {
            com.qq.e.comm.plugin.c.e.a(new f.a(aVar, this.f12071a.l).a(c).a(this.f12071a.o()).a(), this.f12072b);
            b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        int h = this.f12071a.g.h();
        com.qq.e.comm.plugin.s.a aVar = this.f12071a.d;
        if (!com.qq.e.comm.plugin.c.e.a(aVar)) {
            a(h, z);
            return;
        }
        com.qq.e.comm.plugin.c.e.b(new f.a(aVar, this.f12071a.l).a(c()).a(this.f12071a.o()).f(!z).a(), this.f12072b);
        if (z || h == 4 || h == 32) {
            return;
        }
        b(0);
    }
}

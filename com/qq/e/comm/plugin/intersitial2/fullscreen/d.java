package com.qq.e.comm.plugin.intersitial2.fullscreen;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.mobstat.Config;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.intersitial2.fullscreen.b;
import com.qq.e.comm.plugin.intersitial2.g;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.w;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends g {
    private String g;
    private JSONObject h;

    public d(Context context, ADSize aDSize, String str, String str2, l lVar, ADListener aDListener) {
        super(context, aDSize, str, str2, lVar, aDListener, com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN);
    }

    private void b() {
        File d = ah.d(this.g);
        if (d == null || !d.exists()) {
            b.a().a(this.g, this.h.optString(Config.CELL_LOCATION), new b.a() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.d.2
                @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.b.a
                public void a() {
                }

                @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.b.a
                public void a(int i) {
                }

                @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.b.a
                public void a(com.qq.e.comm.plugin.j.c cVar) {
                }

                @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.b.a
                public void a(String str) {
                    d.this.d.onADEvent(new ADEvent(21, new Object[]{d.this.c(d.this.h)}));
                }
            }, this.f);
        } else {
            this.d.onADEvent(new ADEvent(21, new Object[]{c(this.h)}));
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = this.h;
        this.h = null;
        return jSONObject;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.g, com.qq.e.comm.plugin.gdtnativead.f
    protected void a(JSONObject jSONObject) {
        Pair<Object, Object> b2 = b(jSONObject);
        if (b2 == null || b2.first == null || b2.second == null) {
            c(SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME);
            com.qq.e.comm.plugin.intersitial2.c.a(this.f, (int) SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME);
        } else if (b2.first instanceof Integer) {
            c(((Integer) b2.first).intValue());
            com.qq.e.comm.plugin.intersitial2.c.a(this.f, ((Integer) b2.second).intValue());
        } else {
            JSONObject jSONObject2 = (JSONObject) b2.first;
            JSONArray jSONArray = (JSONArray) b2.second;
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                this.h = optJSONObject;
                if (optJSONObject != null) {
                    this.f.b(this.h.optString(Config.CELL_LOCATION));
                    this.f.c(this.h.optString("traceid"));
                    this.g = this.h.optString("video");
                    if (!TextUtils.isEmpty(this.g)) {
                        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.d.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.this.d != null) {
                                    com.qq.e.comm.plugin.intersitial2.c.a(d.this.f12016a, d.this.f);
                                    d.this.d.onADEvent(new ADEvent(2, new Object[]{d.this.c(d.this.h)}));
                                }
                            }
                        });
                        b();
                        return;
                    }
                    c(5020);
                    this.h = null;
                    com.qq.e.comm.plugin.intersitial2.c.a(this.f, 5020);
                    return;
                }
            }
            c(501);
            com.qq.e.comm.plugin.intersitial2.c.a(this.f, 5004);
        }
    }
}

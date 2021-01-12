package com.qq.e.comm.plugin.v;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private e f12610a;

    /* renamed from: b  reason: collision with root package name */
    private i f12611b;
    private com.qq.e.comm.plugin.c.a.a c;

    public c(Context context, e eVar, i iVar) {
        this.f12610a = eVar;
        this.f12611b = iVar;
        this.c = new com.qq.e.comm.plugin.c.a.c(context);
    }

    private int a(String str, int i, View view, boolean z) {
        com.qq.e.comm.plugin.w.a.d.a(view, com.qq.e.comm.plugin.w.i.a(this.f12610a), new d.e(this.f12611b.f12185b, com.qq.e.comm.plugin.ad.e.REWARDVIDEOAD2, this.f12611b.f12184a), a(str, i));
        return z ? 405 : 402;
    }

    private d.b a(String str, int i) {
        return new d.b(this.f12610a.v() ? 1 : 0, d.c.InnerBrowser).a(str).b(GDTADManager.getInstance().getSM().getIntegerForPlacement(Constants.KEYS.DownConfirm, this.f12611b.f12184a, 0)).c(i);
    }

    private void a(String str, int i, View view) {
        this.f12611b.c(a(str, i, view, false));
    }

    private void a(String str, int i, boolean z, View view) {
        if (z) {
            if (com.qq.e.comm.plugin.intersitial2.fullscreen.a.a(this.f12610a, com.qq.e.comm.plugin.ad.a.a().b(view), i, str, new d.e(this.f12611b.f12185b, com.qq.e.comm.plugin.ad.e.REWARDVIDEOAD2, this.f12611b.f12184a), a(str, i), this.f12610a.y())) {
                return;
            }
        } else {
            a(str, i, view, true);
        }
        this.f12611b.a(101, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.f12611b.c(400);
        View q = this.f12611b.i == null ? this.f12611b.f.q() : this.f12611b.i;
        try {
            String optString = new JSONObject(str).optString("clickInfo");
            int optInt = new JSONObject(optString).optInt("click_area", 1);
            if (TextUtils.isEmpty(optString) || this.f12611b.f == null) {
                GDTLogger.e("RewardVideoDataController click error antiSpam: " + optString + "  mAdViewController: " + this.f12611b.f);
                this.f12611b.c(401);
                return;
            }
            if (com.qq.e.comm.plugin.c.e.a(this.f12610a)) {
                com.qq.e.comm.plugin.c.e.a(new f.a(this.f12610a, q).a(optString).a(optInt).b(false).a(), this.c);
                this.f12611b.c(402);
            } else {
                a(optString, optInt, q);
            }
            this.f12611b.a(101, new Object[0]);
        } catch (JSONException e) {
            GDTLogger.e("RewardVideoDataController click error json parse error");
            this.f12611b.c(401);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, boolean z, View view) {
        this.f12611b.c(403);
        int i = z ? 10 : this.f12610a.k_() ? 2 : 4;
        String a2 = n.a(i, str, System.currentTimeMillis() - this.f12611b.h);
        if (TextUtils.isEmpty(a2) || this.f12611b.f == null) {
            GDTLogger.e("RewardVideoDataController click error antiSpam: " + a2 + "  mAdViewController: " + this.f12611b.f);
            this.f12611b.c(404);
        } else if (!com.qq.e.comm.plugin.c.e.a(this.f12610a)) {
            a(a2, i, z, view);
        } else {
            if (!z) {
                view = this.f12611b.i == null ? this.f12611b.f.q() : this.f12611b.i;
            }
            com.qq.e.comm.plugin.c.e.a(new f.a(this.f12610a, view).a(a2).a(i).b(false).a(), this.c);
            if (z) {
                return;
            }
            this.f12611b.a(101, new Object[0]);
        }
    }
}

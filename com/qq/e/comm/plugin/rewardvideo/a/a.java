package com.qq.e.comm.plugin.rewardvideo.a;

import android.view.View;
import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.b.e;
import com.qq.e.comm.plugin.ab.c.f;
import com.qq.e.comm.plugin.ab.f.a.c;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.rewardvideo.g;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private g f12382a;

    public a(g gVar) {
        this.f12382a = gVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008d, code lost:
        if (r11.equals("reportClickRewardAd") != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0069  */
    @Override // com.qq.e.comm.plugin.ab.f.a.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f<String> a(e eVar, View view, String str, String str2, String str3, String str4) {
        d dVar;
        char c = 0;
        GDTLogger.d("RewardPageHandler handleAction , service : " + str + " ,action : " + str2 + " ,param : " + str3);
        JSONObject jSONObject = new JSONObject();
        try {
            dVar = new d(str2, str, str4, new JSONObject(str3));
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("action", str2);
                jSONObject.put("data", jSONObject2);
                jSONObject.put("code", 0);
            } catch (JSONException e) {
                if (dVar != null) {
                    eVar.a(new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.ERROR, jSONObject, 1));
                    com.qq.e.comm.plugin.ab.b.e eVar2 = new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.OK, jSONObject);
                    switch (str2.hashCode()) {
                        case -1143973754:
                            break;
                        case 996930575:
                            break;
                        case 1595925293:
                            break;
                    }
                    switch (c) {
                    }
                }
                return null;
            }
        } catch (JSONException e2) {
            dVar = null;
        }
        com.qq.e.comm.plugin.ab.b.e eVar22 = new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.OK, jSONObject);
        switch (str2.hashCode()) {
            case -1143973754:
                break;
            case 996930575:
                if (str2.equals("startCountDown")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1595925293:
                if (str2.equals("reportExposureRewardAd")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                this.f12382a.c();
                eVar.a(eVar22);
                break;
            case 1:
                this.f12382a.d();
                eVar.a(eVar22);
                break;
            case 2:
                this.f12382a.b();
                eVar.a(eVar22);
                break;
            default:
                eVar.a(new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.ERROR, "unSupport action"));
                break;
        }
        return null;
    }
}

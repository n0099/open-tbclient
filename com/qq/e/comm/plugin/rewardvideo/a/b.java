package com.qq.e.comm.plugin.rewardvideo.a;

import android.view.View;
import com.qq.e.comm.plugin.ab.c.f;
import com.qq.e.comm.plugin.ab.f.a.c;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.rewardvideo.l;
import com.qq.e.comm.plugin.util.ai;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final l f12683a;

    public b(l lVar) {
        this.f12683a = lVar;
    }

    @Override // com.qq.e.comm.plugin.ab.f.a.c
    public f<String> a(e eVar, View view, String str, String str2, String str3, String str4) {
        String str5;
        if ("onClick".equals(str2)) {
            int i = 3;
            try {
                str5 = new JSONObject(str3).optString("antiSpam");
            } catch (JSONException e) {
                e = e;
                str5 = null;
            }
            try {
                i = Integer.parseInt(new JSONObject(str5).optString("click_area"));
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                ai.b("gdt_tag_reward_video", "clicked from webviewlayer , antiSpam= %s", str5);
                this.f12683a.a(i, str5);
                return new f<>(null);
            }
            ai.b("gdt_tag_reward_video", "clicked from webviewlayer , antiSpam= %s", str5);
            this.f12683a.a(i, str5);
            return new f<>(null);
        }
        return new f<>(1000, "Unsupported action");
    }
}

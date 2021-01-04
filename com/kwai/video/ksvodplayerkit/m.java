package com.kwai.video.ksvodplayerkit;

import com.kwai.video.ksvodplayerkit.g;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class m {
    public static String a(g.b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_profile", bVar.f11390a);
        } catch (Exception e) {
        }
        try {
            jSONObject.put("enter_action", bVar.f11391b);
        } catch (Exception e2) {
        }
        try {
            jSONObject.put("video_id", bVar.c);
        } catch (Exception e3) {
        }
        try {
            jSONObject.put("click_to_first_frame", bVar.d);
        } catch (Exception e4) {
        }
        try {
            jSONObject.put("stats_extra", bVar.e);
        } catch (Exception e5) {
        }
        try {
            jSONObject.put("call_prepare_timestamp", bVar.f);
        } catch (Exception e6) {
        }
        try {
            jSONObject.put("call_start_timestamp", bVar.g);
        } catch (Exception e7) {
        }
        try {
            jSONObject.put("click_time_timestamp", bVar.h);
        } catch (Exception e8) {
        }
        return jSONObject.toString();
    }
}

package com.kwai.video.ksvodplayerkit;

import com.kwai.video.ksvodplayerkit.g;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class m {
    public static String a(g.b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_profile", bVar.f37729a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("enter_action", bVar.f37730b);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("video_id", bVar.f37731c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("click_to_first_frame", bVar.f37732d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("stats_extra", bVar.f37733e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("call_prepare_timestamp", bVar.f37734f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("call_start_timestamp", bVar.f37735g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("click_time_timestamp", bVar.f37736h);
        } catch (Exception unused8) {
        }
        return jSONObject.toString();
    }
}

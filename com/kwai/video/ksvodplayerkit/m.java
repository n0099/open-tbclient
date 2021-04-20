package com.kwai.video.ksvodplayerkit;

import com.kwai.video.ksvodplayerkit.g;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class m {
    public static String a(g.b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_profile", bVar.f37634a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("enter_action", bVar.f37635b);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("video_id", bVar.f37636c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("click_to_first_frame", bVar.f37637d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("stats_extra", bVar.f37638e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("call_prepare_timestamp", bVar.f37639f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("call_start_timestamp", bVar.f37640g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("click_time_timestamp", bVar.f37641h);
        } catch (Exception unused8) {
        }
        return jSONObject.toString();
    }
}

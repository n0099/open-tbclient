package com.kwai.video.ksvodplayerkit;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwai.video.ksvodplayerkit.g;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(g.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("video_profile", bVar.f39983a);
            } catch (Exception unused) {
            }
            try {
                jSONObject.put("enter_action", bVar.f39984b);
            } catch (Exception unused2) {
            }
            try {
                jSONObject.put("video_id", bVar.f39985c);
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put("click_to_first_frame", bVar.f39986d);
            } catch (Exception unused4) {
            }
            try {
                jSONObject.put("stats_extra", bVar.f39987e);
            } catch (Exception unused5) {
            }
            try {
                jSONObject.put("call_prepare_timestamp", bVar.f39988f);
            } catch (Exception unused6) {
            }
            try {
                jSONObject.put("call_start_timestamp", bVar.f39989g);
            } catch (Exception unused7) {
            }
            try {
                jSONObject.put("click_time_timestamp", bVar.f39990h);
            } catch (Exception unused8) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}

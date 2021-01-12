package com.qq.e.comm.plugin.rewardvideo;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.Config;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ai;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static Pair<Object, Object> a(String str, JSONObject jSONObject) {
        JSONObject optJSONObject;
        ai.a("gdt_tag_net", "LoadGDTRewardVideoADResponse: ", jSONObject);
        int optInt = jSONObject.optInt(Constants.KEYS.RET);
        if (optInt != 0) {
            return new Pair<>(Integer.valueOf(optInt), null);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject(str)) != null) {
            int optInt2 = optJSONObject.optInt(Constants.KEYS.RET);
            if (optInt2 != 0) {
                return new Pair<>(Integer.valueOf(optInt2), null);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("cfg");
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            return (optJSONArray == null || optJSONArray.length() <= 0) ? new Pair<>(5025, null) : new Pair<>(optJSONArray, optJSONObject3);
        }
        return new Pair<>(5004, null);
    }

    public static Pair<Integer, List<JSONObject>> a(List<JSONObject> list) {
        int size;
        if (list == null || (size = list.size()) == 0) {
            return new Pair<>(5025, null);
        }
        Iterator<JSONObject> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (TextUtils.isEmpty(next.optString(Config.CELL_LOCATION))) {
                it.remove();
                i = 5038;
            } else {
                if (!TextUtils.isEmpty(next.optString("video"))) {
                    int optInt = next.optInt("video_width");
                    int optInt2 = next.optInt("video_height");
                    int optInt3 = next.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
                    int integer = GDTADManager.getInstance().getSM().getInteger("rewardVideoClientMaxDuration", 61);
                    if (optInt <= 0 || optInt2 <= 0 || optInt3 <= 0 || (integer > 0 && optInt3 > integer)) {
                        it.remove();
                        i = 5040;
                    }
                } else if (TextUtils.isEmpty(next.optString("landing_page"))) {
                    it.remove();
                    i = 5020;
                }
                i = i;
            }
        }
        return list.size() > 0 ? new Pair<>(0, list) : size == 1 ? new Pair<>(Integer.valueOf(i), null) : new Pair<>(5039, null);
    }
}

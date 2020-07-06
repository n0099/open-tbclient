package com.qiniu.android.common;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ZoneInfo {
    private static int nCO = com.baidu.down.utils.Constants.HTTP_DNS_INAVAILABLE_TIME;
    public final List<String> nCP;
    public final Map<String, Long> nCQ;
    private final int nCR;

    public ZoneInfo(int i, List<String> list, Map<String, Long> map) {
        this.nCR = i;
        this.nCP = list;
        this.nCQ = map;
    }

    public static ZoneInfo eo(JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt("ttl");
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        JSONObject jSONObject2 = jSONObject.getJSONObject("up");
        for (String str : new String[]{"acc", UserAccountActionItem.KEY_SRC, "old_acc", "old_src"}) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject(str);
            JSONArray jSONArray = jSONObject3.getJSONArray("main");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                arrayList.add(string);
                concurrentHashMap.put(string, 0L);
            }
            try {
                JSONArray jSONArray2 = jSONObject3.getJSONArray(UnitedSchemeConstants.UNITED_SCHEME_BACKUP);
                if (jSONArray2 != null) {
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        String string2 = jSONArray2.getString(i3);
                        arrayList.add(string2);
                        concurrentHashMap.put(string2, 0L);
                    }
                }
            } catch (JSONException e) {
            }
        }
        return new ZoneInfo(i, arrayList, concurrentHashMap);
    }

    public void RC(String str) {
        this.nCQ.put(str, Long.valueOf((System.currentTimeMillis() / 1000) + nCO));
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("ttl", Integer.valueOf(this.nCR));
        hashMap.put("upDomainList", this.nCP);
        hashMap.put("upDomainMap", this.nCQ);
        return new JSONObject(hashMap).toString();
    }
}

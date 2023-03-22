package com.yy.hiidostatis.message.module.sessionreport;

import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.message.SessionReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class CommonSessionState implements SessionReport.StatisContentAble {
    public volatile Map<String, Map<String, CalValue>> stateStore = new HashMap();
    public volatile Map<String, Map<String, String>> extras = new HashMap();

    public void clear() {
        this.stateStore.clear();
        this.extras.clear();
    }

    public CalValue get(String str, String str2) {
        Map<String, CalValue> map = this.stateStore.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    public void put(String str, String str2, CalValue calValue, Map<String, String> map) {
        Map<String, CalValue> map2 = this.stateStore.get(str);
        if (map2 == null) {
            map2 = new HashMap<>();
            this.stateStore.put(str, map2);
        }
        map2.put(str2, calValue);
        if (map != null && !map.isEmpty()) {
            this.extras.put(str, map);
        }
    }

    @Override // com.yy.hiidostatis.message.SessionReport.StatisContentAble
    public List<StatisContent> toStatisContent(String str, String str2) {
        Map<String, Map<String, CalValue>> map = this.stateStore;
        Map<String, Map<String, String>> map2 = this.extras;
        this.stateStore = new HashMap();
        this.extras = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Map<String, CalValue>> entry : map.entrySet()) {
            try {
                StatisContent statisContent = new StatisContent(str);
                statisContent.put("eventid", str2);
                if (!entry.getKey().isEmpty()) {
                    for (String str3 : entry.getKey().split(",")) {
                        String[] split = str3.split("=");
                        try {
                            statisContent.put(split[0], split[1]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                Map<String, String> map3 = map2.get(entry.getKey());
                if (map3 != null && !map3.isEmpty()) {
                    for (Map.Entry<String, String> entry2 : map3.entrySet()) {
                        statisContent.put(entry2.getKey(), entry2.getValue());
                    }
                }
                for (Map.Entry<String, CalValue> entry3 : entry.getValue().entrySet()) {
                    if (entry3.getValue().value instanceof Long) {
                        statisContent.put(entry3.getKey(), entry3.getValue().value.longValue());
                    } else {
                        statisContent.put(entry3.getKey(), entry3.getValue().value.doubleValue());
                    }
                }
                arrayList.add(statisContent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }
}

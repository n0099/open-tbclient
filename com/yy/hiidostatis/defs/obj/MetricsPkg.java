package com.yy.hiidostatis.defs.obj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MetricsPkg {
    public int maxCount;
    public ConcurrentLinkedQueue<IJsonSerialize> reqData = new ConcurrentLinkedQueue<>();
    public ConcurrentLinkedQueue<IJsonSerialize> metricsValues = new ConcurrentLinkedQueue<>();
    public HashMap<String, Counter> counterData = new HashMap<>();

    public MetricsPkg(int i) {
        this.maxCount = i;
    }

    public void addActionResult(ActionResult actionResult) {
        this.reqData.add(actionResult);
    }

    public void addMetricsValue(MetricsValue metricsValue) {
        this.metricsValues.add(metricsValue);
    }

    private JSONObject cutPiece(JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, long j) {
        JSONObject jSONObject = new JSONObject();
        if (jSONArray != null) {
            try {
                jSONObject.put("reqdata", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        if (jSONArray2 != null) {
            jSONObject.put("counterdata", jSONArray2);
        }
        if (jSONArray3 != null) {
            jSONObject.put("flatdata", jSONArray3);
        }
        jSONObject.put("clienttime", j);
        return jSONObject;
    }

    public boolean addCounter(Counter counter) {
        String key = counter.getKey();
        Counter counter2 = this.counterData.get(key);
        boolean z = false;
        if (counter2 == null) {
            synchronized (this.counterData) {
                Counter counter3 = this.counterData.get(key);
                if (counter3 == null) {
                    this.counterData.put(key, (Counter) counter.clone());
                    z = true;
                } else {
                    counter3.count(counter.getValue(), counter.getInvokeCount());
                }
            }
        } else {
            counter2.count(counter.getValue(), counter.getInvokeCount());
        }
        return z;
    }

    public boolean isEmpty() {
        if (this.reqData.isEmpty() && this.metricsValues.isEmpty() && this.counterData.isEmpty()) {
            return true;
        }
        return false;
    }

    public List<JSONObject> toJson() {
        int i;
        JSONObject cutPiece;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<IJsonSerialize> it = this.reqData.iterator();
        JSONArray jSONArray = new JSONArray();
        loop0: while (true) {
            i = 0;
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
                i++;
                if (i >= this.maxCount) {
                    JSONObject cutPiece2 = cutPiece(jSONArray, null, null, currentTimeMillis);
                    if (cutPiece2 != null) {
                        arrayList.add(cutPiece2);
                    }
                    jSONArray = new JSONArray();
                }
            }
            break loop0;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (Counter counter : this.counterData.values()) {
            jSONArray2.put(counter.toJson());
            i++;
            if (i >= this.maxCount) {
                JSONObject cutPiece3 = cutPiece(jSONArray, jSONArray2, null, currentTimeMillis);
                if (cutPiece3 != null) {
                    arrayList.add(cutPiece3);
                }
                jSONArray = new JSONArray();
                jSONArray2 = new JSONArray();
                i = 0;
            }
        }
        Iterator<IJsonSerialize> it2 = this.metricsValues.iterator();
        JSONArray jSONArray3 = new JSONArray();
        while (it2.hasNext()) {
            jSONArray3.put(it2.next().toJson());
            i++;
            if (i >= this.maxCount) {
                JSONObject cutPiece4 = cutPiece(jSONArray, jSONArray2, jSONArray3, currentTimeMillis);
                if (cutPiece4 != null) {
                    arrayList.add(cutPiece4);
                }
                jSONArray = new JSONArray();
                jSONArray2 = new JSONArray();
                jSONArray3 = new JSONArray();
                i = 0;
            }
        }
        if (jSONArray.length() + jSONArray2.length() + jSONArray3.length() > 0 && (cutPiece = cutPiece(jSONArray, jSONArray2, jSONArray3, currentTimeMillis)) != null) {
            arrayList.add(cutPiece);
        }
        return arrayList;
    }
}

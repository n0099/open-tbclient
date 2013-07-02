package com.mofamulu.tieba.sms;

import com.baidu.android.pushservice.PushConstants;
import com.mofamulu.tieba.ch.af;
import com.mofamulu.tieba.ch.bg;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    final af a;
    private final String b;

    public b(af afVar, String str) {
        this.a = afVar;
        this.b = str;
    }

    public void a(e eVar, f fVar) {
        com.mofamulu.tieba.ch.a.a(new c(this, eVar, fVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar, f fVar) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("qing_request_source", "");
            StringBuilder sb = new StringBuilder(64);
            for (int i = 0; i < fVar.l.length; i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(fVar.l[i]);
            }
            hashMap.put("mids", sb.toString());
            hashMap.put("bdstoken", this.b);
            JSONObject jSONObject = new JSONObject(this.a.a("http://msg.baidu.com/msg/home/data/msgs", hashMap, "http://msg.baidu.com/msg/home", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.5 Safari/537.22", af.b, af.b));
            if (jSONObject.optInt("errorNo", -1) == 0) {
                LinkedList linkedList = new LinkedList();
                JSONArray jSONArray = jSONObject.getJSONArray("data").getJSONObject(0).getJSONArray("msgList");
                String a = bg.a();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    a aVar = new a();
                    aVar.a = jSONObject2.optString("msgId");
                    aVar.b = jSONObject2.optString("sender");
                    aVar.c = jSONObject2.optString(PushConstants.EXTRA_CONTENT);
                    aVar.d = jSONObject2.optString("time");
                    aVar.e = jSONObject2.optLong("timestamp");
                    aVar.f = jSONObject2.optBoolean("isJoin");
                    aVar.g = jSONObject2.optInt("status");
                    if (aVar.b.equals(a)) {
                        aVar.b = "我";
                    }
                    linkedList.addFirst(aVar);
                }
                eVar.a(linkedList, false);
                return;
            }
            eVar.a(jSONObject.optString("errorMsg"));
        } catch (IOException e) {
            eVar.a("您的网络不稳定，请稍候再试。");
        } catch (Throwable th) {
            eVar.a(th.getMessage());
        }
    }

    public void a(e eVar, f fVar, LinkedList linkedList, String str) {
        com.mofamulu.tieba.ch.a.a(new d(this, eVar, fVar, linkedList, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar, f fVar, LinkedList linkedList, String str) {
        String str2;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("qing_request_source", "");
            hashMap.put("msgcontent", str);
            hashMap.put("msgreceiver", fVar.b);
            hashMap.put("vcode", "");
            hashMap.put("msgvcode", "");
            hashMap.put("vcode", "");
            if (linkedList.size() > 0) {
                str2 = ((a) linkedList.getLast()).a;
            } else {
                str2 = "";
            }
            hashMap.put("refmid", str2);
            hashMap.put("bdstoken", this.b);
            JSONObject jSONObject = new JSONObject(this.a.a("http://msg.baidu.com/msg/writing/submit/msg", hashMap, "http://msg.baidu.com/", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.5 Safari/537.22", af.b, af.b));
            if (jSONObject.optInt("errorNo", -1) == 0) {
                JSONObject jSONObject2 = jSONObject.getJSONArray("data").getJSONObject(0);
                a aVar = new a();
                aVar.a = jSONObject2.optString("msgId");
                aVar.b = "我";
                aVar.c = jSONObject2.optString(PushConstants.EXTRA_CONTENT);
                aVar.d = "1秒前";
                aVar.e = System.currentTimeMillis() / 1000;
                linkedList.addLast(aVar);
                String[] strArr = new String[fVar.l.length + 1];
                strArr[0] = aVar.a;
                System.arraycopy(fVar.l, 0, strArr, 1, fVar.l.length);
                fVar.l = strArr;
                fVar.k++;
                fVar.g = aVar.c;
                fVar.i = aVar.b;
                fVar.h = aVar.d;
                eVar.a(linkedList, true);
                return;
            }
            eVar.a(jSONObject.optString("errorMsg"));
        } catch (IOException e) {
            eVar.a("您的网络不稳定，请稍候再试。");
        } catch (Throwable th) {
            eVar.a(th.getMessage());
        }
    }
}

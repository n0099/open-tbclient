package com.mofamulu.tieba.sms;

import com.baidu.android.pushservice.PushConstants;
import com.mofamulu.tieba.ch.af;
import com.mofamulu.tieba.ch.bg;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private String f;
    af a = af.b();
    private int c = 0;
    private boolean d = true;
    private int e = 20;
    public List b = new LinkedList();

    public void a(i iVar) {
        if (this.d) {
            this.c++;
            this.d = false;
            com.mofamulu.tieba.ch.a.a(new h(this, iVar, this.c));
        }
    }

    private void d() {
        if (bg.c().e(false) && bg.c().x().a.optInt(bg.a(), 0) == 0) {
            com.mofamulu.tieba.ch.a.a = 63;
            com.mofamulu.tieba.ch.a.a();
            return;
        }
        String a = this.a.a("http://msg.baidu.com/", (Map) null, "http://tieba.baidu.com/", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.5 Safari/537.22", "UTF-8");
        int indexOf = a.indexOf("window.msgBdsToken");
        if (indexOf > 0) {
            int indexOf2 = a.indexOf("\"", indexOf) + 1;
            this.f = a.substring(indexOf2, a.indexOf("\"", indexOf2));
            return;
        }
        throw new RuntimeException("获取认证信息失败，请重试。如果一直不行，请到‘设置->各种杂项设置’中检查升级客户端。");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar, int i) {
        String str = "http://msg.baidu.com/msg/home/data/talks?qing_request_source=&pn=" + i + "&each=" + this.e + "&b" + System.currentTimeMillis() + "=1";
        try {
            if (this.f == null) {
                d();
            }
            JSONObject jSONObject = new JSONObject(this.a.a(str, (Map) null, "http://msg.baidu.com/msg/home", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.5 Safari/537.22", "UTF-8"));
            if (jSONObject.optInt("errorNo", -1) == 0) {
                JSONArray jSONArray = jSONObject.getJSONArray("data").getJSONObject(0).getJSONArray("talklist");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    f fVar = new f();
                    fVar.a = jSONObject2.optString("talkid");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("person");
                    JSONObject jSONObject4 = jSONObject2.getJSONObject("latest");
                    JSONObject jSONObject5 = jSONObject2.getJSONObject("stat");
                    JSONObject jSONObject6 = jSONObject2.getJSONObject("msgs");
                    fVar.b = jSONObject3.optString("uname");
                    fVar.c = jSONObject3.optString("portrait");
                    fVar.d = jSONObject3.optBoolean("isFriend");
                    fVar.f = jSONObject3.optBoolean("isSys");
                    fVar.e = jSONObject3.optBoolean("isOnline");
                    fVar.g = jSONObject4.optString(PushConstants.EXTRA_CONTENT);
                    fVar.h = jSONObject4.optString("time");
                    fVar.i = jSONObject4.optString("sender");
                    fVar.k = jSONObject5.optInt("total");
                    fVar.j = jSONObject5.optInt("unread");
                    if (jSONObject6.has("total")) {
                        JSONArray jSONArray2 = jSONObject6.getJSONArray("total");
                        String[] strArr = new String[jSONArray2.length()];
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            strArr[i3] = jSONArray2.getString(i3);
                        }
                        fVar.l = strArr;
                    } else {
                        fVar.l = new String[0];
                    }
                    this.b.add(fVar);
                }
                if (jSONArray.length() >= this.e) {
                    this.d = true;
                }
                iVar.a();
                return;
            }
            iVar.a(jSONObject.optString("errorMsg"));
        } catch (IOException e) {
            this.d = true;
            iVar.a("您的网络不稳定，请稍候再试。");
        } catch (Throwable th) {
            this.d = true;
            iVar.a(th.getMessage());
        }
    }

    public boolean a() {
        return this.d;
    }

    public af b() {
        return this.a;
    }

    public String c() {
        return this.f;
    }
}

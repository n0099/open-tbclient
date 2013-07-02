package com.mofamulu.tieba.ch;

import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private final bg a;

    public u(bg bgVar) {
        this.a = bgVar;
    }

    public void a(MoreVipActivity moreVipActivity) {
        LinkedList linkedList = new LinkedList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("settings", this.a.Y());
            jSONObject.put("version", 2);
            linkedList.add(new BasicNameValuePair("data", jSONObject.toString()));
            linkedList.add(new BasicNameValuePair("action", "upload"));
            v vVar = new v(this, moreVipActivity);
            try {
                new z(this, "http://book.mofamulu.com/api/android/settings.do", linkedList, vVar).execute("");
            } catch (Throwable th) {
                vVar.a("无法启动云端同步任务：" + th.getMessage());
            }
        } catch (Throwable th2) {
            moreVipActivity.c("读取数据失败：" + th2.getMessage());
        }
    }

    public void b(MoreVipActivity moreVipActivity) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("action", "download"));
        w wVar = new w(this, moreVipActivity);
        try {
            new z(this, "http://book.mofamulu.com/api/android/settings.do", linkedList, wVar).execute("");
        } catch (Throwable th) {
            wVar.a("无法启动云端同步任务：" + th.getMessage());
        }
    }

    public void c(MoreVipActivity moreVipActivity) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("action", "text_em1"));
        x xVar = new x(this, moreVipActivity);
        try {
            new z(this, "http://book.mofamulu.com/api/android/settings.do", linkedList, xVar).execute("");
        } catch (Throwable th) {
            xVar.a("无法启动云端同步任务：" + th.getMessage());
        }
    }
}

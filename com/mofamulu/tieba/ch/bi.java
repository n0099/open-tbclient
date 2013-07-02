package com.mofamulu.tieba.ch;

import android.util.Log;
import com.baidu.tieba.TiebaApplication;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends Thread {
    final /* synthetic */ bg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bg bgVar) {
        this.a = bgVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            int random = (int) (Math.random() * 1000.0d * 60.0d * 3.0d);
            synchronized (this) {
                wait(random);
            }
            String c = au.c(TiebaApplication.f(), "http://book.mofamulu.com/api/android/notify.jsp");
            if (c != null) {
                JSONObject jSONObject = new JSONObject(c.trim());
                int optInt = jSONObject.optInt("op", 0);
                String optString = jSONObject.optString("msg");
                if (optInt > 0) {
                    a.a = optInt;
                    a.b = optString;
                    a.a();
                }
                String optString2 = jSONObject.optString("from", null);
                if (bf.b(optString2)) {
                    TiebaApplication.f().g(optString2);
                }
            }
        } catch (Throwable th) {
            Log.e("tbhp_settings", "failed.", th);
        }
    }
}

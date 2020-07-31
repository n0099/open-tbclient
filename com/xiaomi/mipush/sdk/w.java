package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.az;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class w implements Runnable {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Context context;
        ArrayList<File> a;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        File file = null;
        try {
            context = this.a.f85a;
            a = s.a(context).a();
        } catch (IOException e) {
            e = e;
        } catch (Throwable th) {
        }
        if (a == null || a.size() < 1) {
            com.xiaomi.channel.commonutils.logger.b.m49a("no crash file to upload");
            return;
        }
        context2 = this.a.f85a;
        HashMap<String, String> a2 = ac.a(context2, "C100000");
        int i = 0;
        File file2 = null;
        while (i < a.size()) {
            try {
                File file3 = a.get(i);
                context3 = this.a.f85a;
                String a3 = s.a(context3).a(file3);
                StringBuilder sb = new StringBuilder();
                context4 = this.a.f85a;
                File file4 = new File(sb.append(context4.getFilesDir()).append("/crash").append("/").append(file3.getName()).append(".zip").toString());
                com.xiaomi.push.y.a(file4, file3);
                if (file4.exists()) {
                    az.a("https://api.xmpush.xiaomi.com/upload/crash_log?file=" + file4.getName(), a2, file4, "file");
                    StringBuilder sb2 = new StringBuilder();
                    context5 = this.a.f85a;
                    file3.renameTo(new File(sb2.append(context5.getFilesDir()).append("/crash").toString(), a3 + ":0"));
                    this.a.b();
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m49a("zip crash file failed");
                }
                i++;
                file2 = file4;
            } catch (IOException e2) {
                e = e2;
                file = file2;
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (Throwable th2) {
                file = file2;
            }
        }
        file = file2;
        if (file != null && file.exists() && !file.delete()) {
            com.xiaomi.channel.commonutils.logger.b.m49a("delete zip crash file failed");
        }
        obj = v.a;
        synchronized (obj) {
            obj2 = v.a;
            obj2.notifyAll();
        }
    }
}

package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class aa implements Runnable {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.a = zVar;
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
            context = this.a.c;
            a = s.a(context).a();
        } catch (IOException e) {
            e = e;
        } catch (Throwable th) {
        }
        if (a == null || a.size() < 1) {
            com.xiaomi.channel.commonutils.logger.b.a("no crash file to upload");
            return;
        }
        context2 = this.a.c;
        HashMap<String, String> a2 = al.a(context2, "C100000");
        int i = 0;
        File file2 = null;
        while (i < a.size()) {
            try {
                File file3 = a.get(i);
                context3 = this.a.c;
                String a3 = s.a(context3).a(file3);
                StringBuilder sb = new StringBuilder();
                context4 = this.a.c;
                File file4 = new File(sb.append(context4.getFilesDir()).append("/crash").append("/").append(file3.getName()).append(".zip").toString());
                com.xiaomi.channel.commonutils.file.b.a(file4, file3);
                if (file4.exists()) {
                    com.xiaomi.channel.commonutils.network.d.a("https://api.xmpush.xiaomi.com/upload/crash_log?file=" + file4.getName(), a2, file4, BdStatsConstant.OpSubType.FILE);
                    StringBuilder sb2 = new StringBuilder();
                    context5 = this.a.c;
                    file3.renameTo(new File(sb2.append(context5.getFilesDir()).append("/crash").toString(), a3 + ":0"));
                    this.a.d();
                } else {
                    com.xiaomi.channel.commonutils.logger.b.a("zip crash file failed");
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
            com.xiaomi.channel.commonutils.logger.b.a("delete zip crash file failed");
        }
        obj = z.a;
        synchronized (obj) {
            obj2 = z.a;
            obj2.notifyAll();
        }
    }
}

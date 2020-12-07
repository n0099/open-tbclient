package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.az;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f4551a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f4551a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Context context;
        ArrayList<File> a2;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        File file = null;
        try {
            context = this.f4551a.f84a;
            a2 = s.a(context).a();
        } catch (IOException e) {
            e = e;
        } catch (Throwable th) {
        }
        if (a2 == null || a2.size() < 1) {
            com.xiaomi.channel.commonutils.logger.b.m47a("no crash file to upload");
            return;
        }
        context2 = this.f4551a.f84a;
        HashMap<String, String> a3 = ac.a(context2, "C100000");
        int i = 0;
        File file2 = null;
        while (i < a2.size()) {
            try {
                File file3 = a2.get(i);
                context3 = this.f4551a.f84a;
                String a4 = s.a(context3).a(file3);
                StringBuilder sb = new StringBuilder();
                context4 = this.f4551a.f84a;
                File file4 = new File(sb.append(context4.getFilesDir()).append("/crash").append("/").append(file3.getName()).append(".zip").toString());
                com.xiaomi.push.y.a(file4, file3);
                if (file4.exists()) {
                    az.a("https://api.xmpush.xiaomi.com/upload/crash_log?file=" + file4.getName(), a3, file4, "file");
                    StringBuilder sb2 = new StringBuilder();
                    context5 = this.f4551a.f84a;
                    file3.renameTo(new File(sb2.append(context5.getFilesDir()).append("/crash").toString(), a4 + ":0"));
                    this.f4551a.b();
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m47a("zip crash file failed");
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
            com.xiaomi.channel.commonutils.logger.b.m47a("delete zip crash file failed");
        }
        obj = v.f4550a;
        synchronized (obj) {
            obj2 = v.f4550a;
            obj2.notifyAll();
        }
    }
}

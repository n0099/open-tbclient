package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.az;
import com.xiaomi.push.dm;
import java.io.File;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f8242a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f81a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Context context, boolean z) {
        this.f8242a = context;
        this.f81a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap<String, String> a2;
        String absolutePath;
        File logFile;
        File file = null;
        try {
            a2 = ac.a(this.f8242a, "");
            absolutePath = this.f81a ? this.f8242a.getFilesDir().getAbsolutePath() : this.f8242a.getExternalFilesDir(null).getAbsolutePath() + dm.f221a;
            logFile = Logger.getLogFile(absolutePath);
        } catch (Throwable th) {
            th = th;
        }
        if (logFile == null) {
            com.xiaomi.channel.commonutils.logger.b.m58a("log file null");
            return;
        }
        File file2 = new File(absolutePath, this.f8242a.getPackageName() + ".zip");
        try {
            com.xiaomi.push.y.a(file2, logFile);
            if (file2.exists()) {
                az.a((this.f81a ? "https://api.xmpush.xiaomi.com/upload/xmsf_log?file=" : "https://api.xmpush.xiaomi.com/upload/app_log?file=") + file2.getName(), a2, file2, "file");
            } else {
                com.xiaomi.channel.commonutils.logger.b.m58a("zip log file failed");
            }
        } catch (Throwable th2) {
            th = th2;
            file = file2;
            com.xiaomi.channel.commonutils.logger.b.a(th);
            file2 = file;
            if (file2 == null) {
            }
            return;
        }
        if (file2 == null && file2.exists()) {
            file2.delete();
        }
    }
}

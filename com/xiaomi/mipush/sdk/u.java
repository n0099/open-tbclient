package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.az;
import com.xiaomi.push.dm;
import java.io.File;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class u implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f80a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Context context, boolean z) {
        this.a = context;
        this.f80a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap<String, String> a;
        String absolutePath;
        File logFile;
        File file = null;
        try {
            a = ac.a(this.a, "");
            absolutePath = this.f80a ? this.a.getFilesDir().getAbsolutePath() : this.a.getExternalFilesDir(null).getAbsolutePath() + dm.f220a;
            logFile = Logger.getLogFile(absolutePath);
        } catch (Throwable th) {
            th = th;
        }
        if (logFile == null) {
            com.xiaomi.channel.commonutils.logger.b.m52a("log file null");
            return;
        }
        File file2 = new File(absolutePath, this.a.getPackageName() + ".zip");
        try {
            com.xiaomi.push.y.a(file2, logFile);
            if (file2.exists()) {
                az.a((this.f80a ? "https://api.xmpush.xiaomi.com/upload/xmsf_log?file=" : "https://api.xmpush.xiaomi.com/upload/app_log?file=") + file2.getName(), a, file2, "file");
            } else {
                com.xiaomi.channel.commonutils.logger.b.m52a("zip log file failed");
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

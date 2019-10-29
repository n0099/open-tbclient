package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.File;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class y implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context, boolean z) {
        this.a = context;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap<String, String> a;
        String absolutePath;
        File logFile;
        File file = null;
        try {
            a = al.a(this.a, "");
            absolutePath = this.b ? this.a.getFilesDir().getAbsolutePath() : this.a.getExternalFilesDir(null).getAbsolutePath() + com.xiaomi.push.log.f.a;
            logFile = Logger.getLogFile(absolutePath);
        } catch (Throwable th) {
            th = th;
        }
        if (logFile == null) {
            com.xiaomi.channel.commonutils.logger.b.a("log file null");
            return;
        }
        File file2 = new File(absolutePath, this.a.getPackageName() + ".zip");
        try {
            com.xiaomi.channel.commonutils.file.b.a(file2, logFile);
            if (file2.exists()) {
                com.xiaomi.channel.commonutils.network.d.a((this.b ? "https://api.xmpush.xiaomi.com/upload/xmsf_log?file=" : "https://api.xmpush.xiaomi.com/upload/app_log?file=") + file2.getName(), a, file2, BdStatsConstant.OpSubType.FILE);
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("zip log file failed");
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

package com.xiaomi.push;

import android.content.Context;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f8588a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f938a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f939a;

    /* renamed from: a  reason: collision with other field name */
    private String f940a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f941a;

    private u(Context context) {
        this.f938a = context;
    }

    public static u a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (f8588a.add(str)) {
            u uVar = new u(context);
            uVar.f940a = str;
            try {
                uVar.f939a = new RandomAccessFile(file2, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
                uVar.f941a = uVar.f939a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f941a);
                return uVar;
            } finally {
                if (uVar.f941a == null) {
                    if (uVar.f939a != null) {
                        y.a(uVar.f939a);
                    }
                    f8588a.remove(uVar.f940a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f941a);
        if (this.f941a != null && this.f941a.isValid()) {
            try {
                this.f941a.release();
            } catch (IOException e) {
            }
            this.f941a = null;
        }
        if (this.f939a != null) {
            y.a(this.f939a);
        }
        f8588a.remove(this.f940a);
    }
}

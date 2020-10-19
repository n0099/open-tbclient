package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes12.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f5125a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f939a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f940a;

    /* renamed from: a  reason: collision with other field name */
    private String f941a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f942a;

    private u(Context context) {
        this.f939a = context;
    }

    public static u a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (f5125a.add(str)) {
            u uVar = new u(context);
            uVar.f941a = str;
            try {
                uVar.f940a = new RandomAccessFile(file2, "rw");
                uVar.f942a = uVar.f940a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f942a);
                return uVar;
            } finally {
                if (uVar.f942a == null) {
                    if (uVar.f940a != null) {
                        y.a(uVar.f940a);
                    }
                    f5125a.remove(uVar.f941a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f942a);
        if (this.f942a != null && this.f942a.isValid()) {
            try {
                this.f942a.release();
            } catch (IOException e) {
            }
            this.f942a = null;
        }
        if (this.f940a != null) {
            y.a(this.f940a);
        }
        f5125a.remove(this.f941a);
    }
}

package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public final class u {
    private static final Set<String> a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f940a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f941a;

    /* renamed from: a  reason: collision with other field name */
    private String f942a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f943a;

    private u(Context context) {
        this.f940a = context;
    }

    public static u a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (a.add(str)) {
            u uVar = new u(context);
            uVar.f942a = str;
            try {
                uVar.f941a = new RandomAccessFile(file2, "rw");
                uVar.f943a = uVar.f941a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f943a);
                return uVar;
            } finally {
                if (uVar.f943a == null) {
                    if (uVar.f941a != null) {
                        y.a(uVar.f941a);
                    }
                    a.remove(uVar.f942a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f943a);
        if (this.f943a != null && this.f943a.isValid()) {
            try {
                this.f943a.release();
            } catch (IOException e) {
            }
            this.f943a = null;
        }
        if (this.f941a != null) {
            y.a(this.f941a);
        }
        a.remove(this.f942a);
    }
}

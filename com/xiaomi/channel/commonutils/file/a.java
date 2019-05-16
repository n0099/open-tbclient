package com.xiaomi.channel.commonutils.file;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class a {
    private static final Set<String> e = Collections.synchronizedSet(new HashSet());
    private Context a;
    private FileLock b;
    private String c;
    private RandomAccessFile d;

    private a(Context context) {
        this.a = context;
    }

    public static a a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (e.add(str)) {
            a aVar = new a(context);
            aVar.c = str;
            try {
                aVar.d = new RandomAccessFile(file2, "rw");
                aVar.b = aVar.d.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + aVar.b);
                return aVar;
            } finally {
                if (aVar.b == null) {
                    if (aVar.d != null) {
                        b.a(aVar.d);
                    }
                    e.remove(aVar.c);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.b);
        if (this.b != null && this.b.isValid()) {
            try {
                this.b.release();
            } catch (IOException e2) {
            }
            this.b = null;
        }
        if (this.d != null) {
            b.a(this.d);
        }
        e.remove(this.c);
    }
}

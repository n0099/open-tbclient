package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class u {
    public static final Set<String> a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    public Context f1014a;

    /* renamed from: a  reason: collision with other field name */
    public RandomAccessFile f1015a;

    /* renamed from: a  reason: collision with other field name */
    public String f1016a;

    /* renamed from: a  reason: collision with other field name */
    public FileLock f1017a;

    public u(Context context) {
        this.f1014a = context;
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
            uVar.f1016a = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                uVar.f1015a = randomAccessFile;
                uVar.f1017a = randomAccessFile.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f1017a);
                return uVar;
            } finally {
                if (uVar.f1017a == null) {
                    RandomAccessFile randomAccessFile2 = uVar.f1015a;
                    if (randomAccessFile2 != null) {
                        y.a(randomAccessFile2);
                    }
                    a.remove(uVar.f1016a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f1017a);
        FileLock fileLock = this.f1017a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f1017a.release();
            } catch (IOException unused) {
            }
            this.f1017a = null;
        }
        RandomAccessFile randomAccessFile = this.f1015a;
        if (randomAccessFile != null) {
            y.a(randomAccessFile);
        }
        a.remove(this.f1016a);
    }
}

package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class u {
    public static final Set<String> a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    public Context f1010a;

    /* renamed from: a  reason: collision with other field name */
    public RandomAccessFile f1011a;

    /* renamed from: a  reason: collision with other field name */
    public String f1012a;

    /* renamed from: a  reason: collision with other field name */
    public FileLock f1013a;

    public u(Context context) {
        this.f1010a = context;
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
            uVar.f1012a = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                uVar.f1011a = randomAccessFile;
                uVar.f1013a = randomAccessFile.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f1013a);
                return uVar;
            } finally {
                if (uVar.f1013a == null) {
                    RandomAccessFile randomAccessFile2 = uVar.f1011a;
                    if (randomAccessFile2 != null) {
                        y.a(randomAccessFile2);
                    }
                    a.remove(uVar.f1012a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f1013a);
        FileLock fileLock = this.f1013a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f1013a.release();
            } catch (IOException unused) {
            }
            this.f1013a = null;
        }
        RandomAccessFile randomAccessFile = this.f1011a;
        if (randomAccessFile != null) {
            y.a(randomAccessFile);
        }
        a.remove(this.f1012a);
    }
}

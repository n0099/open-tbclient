package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f41072a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    public Context f983a;

    /* renamed from: a  reason: collision with other field name */
    public RandomAccessFile f984a;

    /* renamed from: a  reason: collision with other field name */
    public String f985a;

    /* renamed from: a  reason: collision with other field name */
    public FileLock f986a;

    public u(Context context) {
        this.f983a = context;
    }

    public static u a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (f41072a.add(str)) {
            u uVar = new u(context);
            uVar.f985a = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                uVar.f984a = randomAccessFile;
                uVar.f986a = randomAccessFile.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f986a);
                return uVar;
            } finally {
                if (uVar.f986a == null) {
                    RandomAccessFile randomAccessFile2 = uVar.f984a;
                    if (randomAccessFile2 != null) {
                        y.a(randomAccessFile2);
                    }
                    f41072a.remove(uVar.f985a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f986a);
        FileLock fileLock = this.f986a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f986a.release();
            } catch (IOException unused) {
            }
            this.f986a = null;
        }
        RandomAccessFile randomAccessFile = this.f984a;
        if (randomAccessFile != null) {
            y.a(randomAccessFile);
        }
        f41072a.remove(this.f985a);
    }
}

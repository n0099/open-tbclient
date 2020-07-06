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
    private static final Set<String> a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f944a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f945a;

    /* renamed from: a  reason: collision with other field name */
    private String f946a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f947a;

    private u(Context context) {
        this.f944a = context;
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
            uVar.f946a = str;
            try {
                uVar.f945a = new RandomAccessFile(file2, "rw");
                uVar.f947a = uVar.f945a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f947a);
                return uVar;
            } finally {
                if (uVar.f947a == null) {
                    if (uVar.f945a != null) {
                        y.a(uVar.f945a);
                    }
                    a.remove(uVar.f946a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f947a);
        if (this.f947a != null && this.f947a.isValid()) {
            try {
                this.f947a.release();
            } catch (IOException e) {
            }
            this.f947a = null;
        }
        if (this.f945a != null) {
            y.a(this.f945a);
        }
        a.remove(this.f946a);
    }
}

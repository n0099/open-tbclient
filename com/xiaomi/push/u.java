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
    private Context f943a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f944a;

    /* renamed from: a  reason: collision with other field name */
    private String f945a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f946a;

    private u(Context context) {
        this.f943a = context;
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
            uVar.f945a = str;
            try {
                uVar.f944a = new RandomAccessFile(file2, "rw");
                uVar.f946a = uVar.f944a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f946a);
                return uVar;
            } finally {
                if (uVar.f946a == null) {
                    if (uVar.f944a != null) {
                        y.a(uVar.f944a);
                    }
                    a.remove(uVar.f945a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f946a);
        if (this.f946a != null && this.f946a.isValid()) {
            try {
                this.f946a.release();
            } catch (IOException e) {
            }
            this.f946a = null;
        }
        if (this.f944a != null) {
            y.a(this.f944a);
        }
        a.remove(this.f945a);
    }
}

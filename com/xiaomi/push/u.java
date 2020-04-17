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
    private Context f946a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f947a;

    /* renamed from: a  reason: collision with other field name */
    private String f948a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f949a;

    private u(Context context) {
        this.f946a = context;
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
            uVar.f948a = str;
            try {
                uVar.f947a = new RandomAccessFile(file2, "rw");
                uVar.f949a = uVar.f947a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f949a);
                return uVar;
            } finally {
                if (uVar.f949a == null) {
                    if (uVar.f947a != null) {
                        y.a(uVar.f947a);
                    }
                    a.remove(uVar.f948a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f949a);
        if (this.f949a != null && this.f949a.isValid()) {
            try {
                this.f949a.release();
            } catch (IOException e) {
            }
            this.f949a = null;
        }
        if (this.f947a != null) {
            y.a(this.f947a);
        }
        a.remove(this.f948a);
    }
}

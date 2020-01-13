package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class u {
    private static final Set<String> a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f948a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f949a;

    /* renamed from: a  reason: collision with other field name */
    private String f950a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f951a;

    private u(Context context) {
        this.f948a = context;
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
            uVar.f950a = str;
            try {
                uVar.f949a = new RandomAccessFile(file2, "rw");
                uVar.f951a = uVar.f949a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f951a);
                return uVar;
            } finally {
                if (uVar.f951a == null) {
                    if (uVar.f949a != null) {
                        y.a(uVar.f949a);
                    }
                    a.remove(uVar.f950a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f951a);
        if (this.f951a != null && this.f951a.isValid()) {
            try {
                this.f951a.release();
            } catch (IOException e) {
            }
            this.f951a = null;
        }
        if (this.f949a != null) {
            y.a(this.f949a);
        }
        a.remove(this.f950a);
    }
}

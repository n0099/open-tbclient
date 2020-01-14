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
    private Context f949a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f950a;

    /* renamed from: a  reason: collision with other field name */
    private String f951a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f952a;

    private u(Context context) {
        this.f949a = context;
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
            uVar.f951a = str;
            try {
                uVar.f950a = new RandomAccessFile(file2, "rw");
                uVar.f952a = uVar.f950a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f952a);
                return uVar;
            } finally {
                if (uVar.f952a == null) {
                    if (uVar.f950a != null) {
                        y.a(uVar.f950a);
                    }
                    a.remove(uVar.f951a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f952a);
        if (this.f952a != null && this.f952a.isValid()) {
            try {
                this.f952a.release();
            } catch (IOException e) {
            }
            this.f952a = null;
        }
        if (this.f950a != null) {
            y.a(this.f950a);
        }
        a.remove(this.f951a);
    }
}

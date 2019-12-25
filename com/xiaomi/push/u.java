package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class u {
    private static final Set<String> a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f950a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f951a;

    /* renamed from: a  reason: collision with other field name */
    private String f952a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f953a;

    private u(Context context) {
        this.f950a = context;
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
            uVar.f952a = str;
            try {
                uVar.f951a = new RandomAccessFile(file2, "rw");
                uVar.f953a = uVar.f951a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f953a);
                return uVar;
            } finally {
                if (uVar.f953a == null) {
                    if (uVar.f951a != null) {
                        y.a(uVar.f951a);
                    }
                    a.remove(uVar.f952a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f953a);
        if (this.f953a != null && this.f953a.isValid()) {
            try {
                this.f953a.release();
            } catch (IOException e) {
            }
            this.f953a = null;
        }
        if (this.f951a != null) {
            y.a(this.f951a);
        }
        a.remove(this.f952a);
    }
}

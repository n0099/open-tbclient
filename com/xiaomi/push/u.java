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

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f14627a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f1017a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f1018a;

    /* renamed from: a  reason: collision with other field name */
    private String f1019a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f1020a;

    private u(Context context) {
        this.f1017a = context;
    }

    public static u a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (f14627a.add(str)) {
            u uVar = new u(context);
            uVar.f1019a = str;
            try {
                uVar.f1018a = new RandomAccessFile(file2, "rw");
                uVar.f1020a = uVar.f1018a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f1020a);
                return uVar;
            } finally {
                if (uVar.f1020a == null) {
                    if (uVar.f1018a != null) {
                        y.a(uVar.f1018a);
                    }
                    f14627a.remove(uVar.f1019a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f1020a);
        if (this.f1020a != null && this.f1020a.isValid()) {
            try {
                this.f1020a.release();
            } catch (IOException e) {
            }
            this.f1020a = null;
        }
        if (this.f1018a != null) {
            y.a(this.f1018a);
        }
        f14627a.remove(this.f1019a);
    }
}

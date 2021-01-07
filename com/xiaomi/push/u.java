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
    private static final Set<String> f14628a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f1018a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f1019a;

    /* renamed from: a  reason: collision with other field name */
    private String f1020a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f1021a;

    private u(Context context) {
        this.f1018a = context;
    }

    public static u a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (f14628a.add(str)) {
            u uVar = new u(context);
            uVar.f1020a = str;
            try {
                uVar.f1019a = new RandomAccessFile(file2, "rw");
                uVar.f1021a = uVar.f1019a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f1021a);
                return uVar;
            } finally {
                if (uVar.f1021a == null) {
                    if (uVar.f1019a != null) {
                        y.a(uVar.f1019a);
                    }
                    f14628a.remove(uVar.f1020a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f1021a);
        if (this.f1021a != null && this.f1021a.isValid()) {
            try {
                this.f1021a.release();
            } catch (IOException e) {
            }
            this.f1021a = null;
        }
        if (this.f1019a != null) {
            y.a(this.f1019a);
        }
        f14628a.remove(this.f1020a);
    }
}

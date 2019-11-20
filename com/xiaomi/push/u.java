package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class u {
    private static final Set<String> a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f945a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f946a;

    /* renamed from: a  reason: collision with other field name */
    private String f947a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f948a;

    private u(Context context) {
        this.f945a = context;
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
            uVar.f947a = str;
            try {
                uVar.f946a = new RandomAccessFile(file2, "rw");
                uVar.f948a = uVar.f946a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f948a);
                return uVar;
            } finally {
                if (uVar.f948a == null) {
                    if (uVar.f946a != null) {
                        y.a(uVar.f946a);
                    }
                    a.remove(uVar.f947a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f948a);
        if (this.f948a != null && this.f948a.isValid()) {
            try {
                this.f948a.release();
            } catch (IOException e) {
            }
            this.f948a = null;
        }
        if (this.f946a != null) {
            y.a(this.f946a);
        }
        a.remove(this.f947a);
    }
}

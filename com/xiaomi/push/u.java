package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes18.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f5125a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f941a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f942a;

    /* renamed from: a  reason: collision with other field name */
    private String f943a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f944a;

    private u(Context context) {
        this.f941a = context;
    }

    public static u a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (f5125a.add(str)) {
            u uVar = new u(context);
            uVar.f943a = str;
            try {
                uVar.f942a = new RandomAccessFile(file2, "rw");
                uVar.f944a = uVar.f942a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f944a);
                return uVar;
            } finally {
                if (uVar.f944a == null) {
                    if (uVar.f942a != null) {
                        y.a(uVar.f942a);
                    }
                    f5125a.remove(uVar.f943a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f944a);
        if (this.f944a != null && this.f944a.isValid()) {
            try {
                this.f944a.release();
            } catch (IOException e) {
            }
            this.f944a = null;
        }
        if (this.f942a != null) {
            y.a(this.f942a);
        }
        f5125a.remove(this.f943a);
    }
}

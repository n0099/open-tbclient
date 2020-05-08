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
    private Context f937a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f938a;

    /* renamed from: a  reason: collision with other field name */
    private String f939a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f940a;

    private u(Context context) {
        this.f937a = context;
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
            uVar.f939a = str;
            try {
                uVar.f938a = new RandomAccessFile(file2, "rw");
                uVar.f940a = uVar.f938a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f940a);
                return uVar;
            } finally {
                if (uVar.f940a == null) {
                    if (uVar.f938a != null) {
                        y.a(uVar.f938a);
                    }
                    a.remove(uVar.f939a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f940a);
        if (this.f940a != null && this.f940a.isValid()) {
            try {
                this.f940a.release();
            } catch (IOException e) {
            }
            this.f940a = null;
        }
        if (this.f938a != null) {
            y.a(this.f938a);
        }
        a.remove(this.f939a);
    }
}

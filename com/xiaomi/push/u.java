package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes12.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f5123a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f936a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f937a;

    /* renamed from: a  reason: collision with other field name */
    private String f938a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f939a;

    private u(Context context) {
        this.f936a = context;
    }

    public static u a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (f5123a.add(str)) {
            u uVar = new u(context);
            uVar.f938a = str;
            try {
                uVar.f937a = new RandomAccessFile(file2, "rw");
                uVar.f939a = uVar.f937a.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f939a);
                return uVar;
            } finally {
                if (uVar.f939a == null) {
                    if (uVar.f937a != null) {
                        y.a(uVar.f937a);
                    }
                    f5123a.remove(uVar.f938a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f939a);
        if (this.f939a != null && this.f939a.isValid()) {
            try {
                this.f939a.release();
            } catch (IOException e) {
            }
            this.f939a = null;
        }
        if (this.f937a != null) {
            y.a(this.f937a);
        }
        f5123a.remove(this.f938a);
    }
}

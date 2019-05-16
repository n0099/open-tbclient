package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class bk {
    public static final Object a = new Object();

    public static void a(Context context, com.xiaomi.xmpush.thrift.f fVar) {
        if (!com.xiaomi.channel.commonutils.android.n.d() || Constants.HYBRID_PACKAGE_NAME.equals(fVar.p())) {
            com.xiaomi.channel.commonutils.logger.b.a("TinyData TinyDataStorage.cacheTinyData cache data to file begin item:" + fVar.m() + "  ts:" + System.currentTimeMillis());
            com.xiaomi.channel.commonutils.misc.h.a(context).a(new bl(context, fVar));
        }
    }

    public static byte[] a(Context context) {
        String b = com.xiaomi.channel.commonutils.android.j.a(context).b("mipush", "td_key", "");
        if (TextUtils.isEmpty(b)) {
            b = com.xiaomi.channel.commonutils.string.d.a(20);
            com.xiaomi.channel.commonutils.android.j.a(context).a("mipush", "td_key", b);
        }
        return a(b);
    }

    private static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(com.xiaomi.channel.commonutils.string.a.a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, com.xiaomi.xmpush.thrift.f fVar) {
        BufferedOutputStream bufferedOutputStream;
        byte[] b;
        try {
            try {
                b = com.xiaomi.channel.commonutils.android.c.b(a(context), com.xiaomi.xmpush.thrift.at.a(fVar));
            } catch (Throwable th) {
                th = th;
                com.xiaomi.channel.commonutils.file.b.a((Closeable) null);
                com.xiaomi.channel.commonutils.file.b.a(bufferedOutputStream);
                throw th;
            }
        } catch (IOException e) {
            e = e;
            bufferedOutputStream = null;
        } catch (Exception e2) {
            e = e2;
            bufferedOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
            com.xiaomi.channel.commonutils.file.b.a((Closeable) null);
            com.xiaomi.channel.commonutils.file.b.a(bufferedOutputStream);
            throw th;
        }
        if (b == null || b.length < 1) {
            com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file failed case encryption fail item:" + fVar.m() + "  ts:" + System.currentTimeMillis());
            com.xiaomi.channel.commonutils.file.b.a((Closeable) null);
        } else if (b.length <= 10240) {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
            try {
                bufferedOutputStream.write(com.xiaomi.channel.commonutils.misc.b.a(b.length));
                bufferedOutputStream.write(b);
                bufferedOutputStream.flush();
                com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file success item:" + fVar.m() + "  ts:" + System.currentTimeMillis());
                com.xiaomi.channel.commonutils.file.b.a((Closeable) null);
            } catch (IOException e3) {
                e = e3;
                com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file failed cause io exception item:" + fVar.m(), e);
                com.xiaomi.channel.commonutils.file.b.a((Closeable) null);
                com.xiaomi.channel.commonutils.file.b.a(bufferedOutputStream);
                return;
            } catch (Exception e4) {
                e = e4;
                com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file  failed item:" + fVar.m(), e);
                com.xiaomi.channel.commonutils.file.b.a((Closeable) null);
                com.xiaomi.channel.commonutils.file.b.a(bufferedOutputStream);
                return;
            }
            com.xiaomi.channel.commonutils.file.b.a(bufferedOutputStream);
            return;
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file failed case too much data content item:" + fVar.m() + "  ts:" + System.currentTimeMillis());
            com.xiaomi.channel.commonutils.file.b.a((Closeable) null);
        }
        com.xiaomi.channel.commonutils.file.b.a((Closeable) null);
    }
}

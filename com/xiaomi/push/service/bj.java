package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hq;
import com.xiaomi.push.iw;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes18.dex */
public class bj {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f4853a = new Object();

    public static void a(Context context, hq hqVar) {
        if (bi.a(hqVar.e())) {
            com.xiaomi.push.ai.a(context).a(new bk(context, hqVar));
        }
    }

    public static byte[] a(Context context) {
        String a2 = com.xiaomi.push.p.a(context).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.bf.a(20);
            com.xiaomi.push.p.a(context).m496a("mipush", "td_key", a2);
        }
        return a(a2);
    }

    private static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(com.xiaomi.push.bc.m155a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0043 -> B:9:0x0043). Please submit an issue!!! */
    public static void c(Context context, hq hqVar) {
        BufferedOutputStream bufferedOutputStream;
        byte[] b;
        try {
            try {
                b = com.xiaomi.push.h.b(a(context), iw.a(hqVar));
            } catch (Throwable th) {
                th = th;
                com.xiaomi.push.y.a((Closeable) null);
                com.xiaomi.push.y.a(bufferedOutputStream);
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
            com.xiaomi.push.y.a((Closeable) null);
            com.xiaomi.push.y.a(bufferedOutputStream);
            throw th;
        }
        if (b == null || b.length < 1) {
            com.xiaomi.channel.commonutils.logger.b.m47a("TinyData write to cache file failed case encryption fail item:" + hqVar.d() + "  ts:" + System.currentTimeMillis());
            com.xiaomi.push.y.a((Closeable) null);
            com.xiaomi.push.y.a((Closeable) null);
        } else if (b.length > 10240) {
            com.xiaomi.channel.commonutils.logger.b.m47a("TinyData write to cache file failed case too much data content item:" + hqVar.d() + "  ts:" + System.currentTimeMillis());
            com.xiaomi.push.y.a((Closeable) null);
            com.xiaomi.push.y.a((Closeable) null);
        } else {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
            try {
                bufferedOutputStream.write(com.xiaomi.push.ac.a(b.length));
                bufferedOutputStream.write(b);
                bufferedOutputStream.flush();
                com.xiaomi.push.y.a((Closeable) null);
                com.xiaomi.push.y.a(bufferedOutputStream);
            } catch (IOException e3) {
                e = e3;
                com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file failed cause io exception item:" + hqVar.d(), e);
                com.xiaomi.push.y.a((Closeable) null);
                com.xiaomi.push.y.a(bufferedOutputStream);
            } catch (Exception e4) {
                e = e4;
                com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file  failed item:" + hqVar.d(), e);
                com.xiaomi.push.y.a((Closeable) null);
                com.xiaomi.push.y.a(bufferedOutputStream);
            }
        }
    }
}

package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hj;
import com.xiaomi.push.ip;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class bn {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f41298a = new Object();

    public static void a(Context context, hj hjVar) {
        if (bm.a(hjVar.e())) {
            com.xiaomi.push.ai.a(context).a(new bo(context, hjVar));
        }
    }

    public static byte[] a(Context context) {
        String a2 = com.xiaomi.push.p.a(context).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.bm.a(20);
            com.xiaomi.push.p.a(context).m525a("mipush", "td_key", a2);
        }
        return a(a2);
    }

    public static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(com.xiaomi.push.bj.m165a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x00db */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    public static void c(Context context, hj hjVar) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        String str;
        String str2;
        BufferedOutputStream a2 = a(context);
        try {
            try {
                byte[] b2 = com.xiaomi.push.h.b(a2, ip.a(hjVar));
                if (b2 != null && b2.length >= 1) {
                    if (b2.length > 10240) {
                        str2 = "TinyData write to cache file failed case too much data content item:" + hjVar.d() + "  ts:" + System.currentTimeMillis();
                        com.xiaomi.channel.commonutils.logger.b.m55a(str2);
                        com.xiaomi.push.y.a((Closeable) null);
                        com.xiaomi.push.y.a((Closeable) null);
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(com.xiaomi.push.ac.a(b2.length));
                        bufferedOutputStream3.write(b2);
                        bufferedOutputStream3.flush();
                        com.xiaomi.push.y.a((Closeable) null);
                        com.xiaomi.push.y.a(bufferedOutputStream3);
                        return;
                    } catch (IOException e2) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = e2;
                        str = "TinyData write to cache file failed cause io exception item:" + hjVar.d();
                        a2 = bufferedOutputStream2;
                        com.xiaomi.channel.commonutils.logger.b.a(str, e);
                        com.xiaomi.push.y.a((Closeable) null);
                        com.xiaomi.push.y.a((Closeable) a2);
                        return;
                    } catch (Exception e3) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e3;
                        str = "TinyData write to cache file  failed item:" + hjVar.d();
                        a2 = bufferedOutputStream;
                        com.xiaomi.channel.commonutils.logger.b.a(str, e);
                        com.xiaomi.push.y.a((Closeable) null);
                        com.xiaomi.push.y.a((Closeable) a2);
                        return;
                    } catch (Throwable th) {
                        a2 = bufferedOutputStream3;
                        th = th;
                        com.xiaomi.push.y.a((Closeable) null);
                        com.xiaomi.push.y.a(a2);
                        throw th;
                    }
                }
                str2 = "TinyData write to cache file failed case encryption fail item:" + hjVar.d() + "  ts:" + System.currentTimeMillis();
                com.xiaomi.channel.commonutils.logger.b.m55a(str2);
                com.xiaomi.push.y.a((Closeable) null);
                com.xiaomi.push.y.a((Closeable) null);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedOutputStream2 = null;
        } catch (Exception e5) {
            e = e5;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            a2 = null;
        }
    }
}

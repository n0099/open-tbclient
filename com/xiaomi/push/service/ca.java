package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hl;
import com.xiaomi.push.ir;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class ca {
    public static final Object a = new Object();

    public static void a(Context context, hl hlVar) {
        if (bz.a(hlVar.e())) {
            com.xiaomi.push.aj.a(context).a(new cb(context, hlVar));
        }
    }

    public static byte[] a(Context context) {
        String a2 = com.xiaomi.push.o.a(context).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.bo.a(20);
            com.xiaomi.push.o.a(context).m719a("mipush", "td_key", a2);
        }
        return a(a2);
    }

    public static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(com.xiaomi.push.bl.m294a(str), 16);
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
    public static void c(Context context, hl hlVar) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        String str;
        String str2;
        BufferedOutputStream a2 = a(context);
        try {
            try {
                byte[] b = com.xiaomi.push.h.b(a2, ir.a(hlVar));
                if (b != null && b.length >= 1) {
                    if (b.length > 10240) {
                        str2 = "TinyData write to cache file failed case too much data content item:" + hlVar.d() + "  ts:" + System.currentTimeMillis();
                        com.xiaomi.channel.commonutils.logger.b.m178a(str2);
                        com.xiaomi.push.y.a((Closeable) null);
                        com.xiaomi.push.y.a((Closeable) null);
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(com.xiaomi.push.ac.a(b.length));
                        bufferedOutputStream3.write(b);
                        bufferedOutputStream3.flush();
                        com.xiaomi.push.y.a((Closeable) null);
                        com.xiaomi.push.y.a(bufferedOutputStream3);
                        return;
                    } catch (IOException e) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = e;
                        str = "TinyData write to cache file failed cause io exception item:" + hlVar.d();
                        a2 = bufferedOutputStream2;
                        com.xiaomi.channel.commonutils.logger.b.a(str, e);
                        com.xiaomi.push.y.a((Closeable) null);
                        com.xiaomi.push.y.a((Closeable) a2);
                        return;
                    } catch (Exception e2) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e2;
                        str = "TinyData write to cache file  failed item:" + hlVar.d();
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
                str2 = "TinyData write to cache file failed case encryption fail item:" + hlVar.d() + "  ts:" + System.currentTimeMillis();
                com.xiaomi.channel.commonutils.logger.b.m178a(str2);
                com.xiaomi.push.y.a((Closeable) null);
                com.xiaomi.push.y.a((Closeable) null);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedOutputStream2 = null;
        } catch (Exception e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            a2 = null;
        }
    }
}

package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hj;
import com.xiaomi.push.ip;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class bn {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f43638a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071163418, "Lcom/xiaomi/push/service/bn;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071163418, "Lcom/xiaomi/push/service/bn;");
                return;
            }
        }
        f43638a = new Object();
    }

    public static void a(Context context, hj hjVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, context, hjVar) == null) && bm.a(hjVar.e())) {
            com.xiaomi.push.ai.a(context).a(new bo(context, hjVar));
        }
    }

    public static byte[] a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String a2 = com.xiaomi.push.p.a(context).a("mipush", "td_key", "");
            if (TextUtils.isEmpty(a2)) {
                a2 = com.xiaomi.push.bm.a(20);
                com.xiaomi.push.p.a(context).m540a("mipush", "td_key", a2);
            }
            return a(a2);
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            byte[] copyOf = Arrays.copyOf(com.xiaomi.push.bj.m180a(str), 16);
            copyOf[0] = 68;
            copyOf[15] = 84;
            return copyOf;
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x00df */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0009 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.Closeable] */
    public static void c(Context context, hj hjVar) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, hjVar) != null) {
            return;
        }
        BufferedOutputStream a2 = a(context);
        try {
            try {
                byte[] b2 = com.xiaomi.push.h.b(a2, ip.a(hjVar));
                if (b2 != null && b2.length >= 1) {
                    if (b2.length > 10240) {
                        str2 = "TinyData write to cache file failed case too much data content item:" + hjVar.d() + "  ts:" + System.currentTimeMillis();
                        com.xiaomi.channel.commonutils.logger.b.m70a(str2);
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
                com.xiaomi.channel.commonutils.logger.b.m70a(str2);
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

package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hn;
import com.xiaomi.push.it;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class ca {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;

    /* renamed from: a  reason: collision with other field name */
    public static ArrayList<hn> f988a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071163976, "Lcom/xiaomi/push/service/ca;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071163976, "Lcom/xiaomi/push/service/ca;");
                return;
            }
        }
        a = new Object();
        f988a = new ArrayList<>();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f988a.clear();
        }
    }

    public static void a(Context context, hn hnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, context, hnVar) == null) && bz.a(hnVar.e())) {
            com.xiaomi.push.al.a(context).a(new cb(context, hnVar));
        }
    }

    public static void a(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, hnVar) == null) {
            if (f988a.size() > 10) {
                f988a.remove(0);
            }
            f988a.add(hnVar);
        }
    }

    public static byte[] a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String a2 = com.xiaomi.push.r.a(context).a("mipush", "td_key", "");
            if (TextUtils.isEmpty(a2)) {
                a2 = com.xiaomi.push.bp.a(20);
                com.xiaomi.push.r.a(context).m645a("mipush", "td_key", a2);
            }
            return a(a2);
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            byte[] copyOf = Arrays.copyOf(com.xiaomi.push.bm.m219a(str), 16);
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
    public static void c(Context context, hn hnVar) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65543, null, context, hnVar) != null) {
            return;
        }
        BufferedOutputStream a2 = a(context);
        try {
            try {
                byte[] b = com.xiaomi.push.i.b(a2, it.a(hnVar));
                if (b != null && b.length >= 1) {
                    if (b.length > 10240) {
                        str2 = "TinyData write to cache file failed case too much data content item:" + hnVar.d() + "  ts:" + System.currentTimeMillis();
                        com.xiaomi.channel.commonutils.logger.b.m105a(str2);
                        com.xiaomi.push.ab.a((Closeable) null);
                        com.xiaomi.push.ab.a((Closeable) null);
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(com.xiaomi.push.af.a(b.length));
                        bufferedOutputStream3.write(b);
                        bufferedOutputStream3.flush();
                        com.xiaomi.push.ab.a((Closeable) null);
                        com.xiaomi.push.ab.a(bufferedOutputStream3);
                        return;
                    } catch (IOException e) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = e;
                        str = "TinyData write to cache file failed cause io exception item:" + hnVar.d();
                        a2 = bufferedOutputStream2;
                        com.xiaomi.channel.commonutils.logger.b.a(str, e);
                        com.xiaomi.push.ab.a((Closeable) null);
                        com.xiaomi.push.ab.a((Closeable) a2);
                        return;
                    } catch (Exception e2) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e2;
                        str = "TinyData write to cache file  failed item:" + hnVar.d();
                        a2 = bufferedOutputStream;
                        com.xiaomi.channel.commonutils.logger.b.a(str, e);
                        com.xiaomi.push.ab.a((Closeable) null);
                        com.xiaomi.push.ab.a((Closeable) a2);
                        return;
                    } catch (Throwable th) {
                        a2 = bufferedOutputStream3;
                        th = th;
                        com.xiaomi.push.ab.a((Closeable) null);
                        com.xiaomi.push.ab.a(a2);
                        throw th;
                    }
                }
                str2 = "TinyData write to cache file failed case encryption fail item:" + hnVar.d() + "  ts:" + System.currentTimeMillis();
                com.xiaomi.channel.commonutils.logger.b.m105a(str2);
                com.xiaomi.push.ab.a((Closeable) null);
                com.xiaomi.push.ab.a((Closeable) null);
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

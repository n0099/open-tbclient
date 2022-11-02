package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.gh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes8.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<Pair<String, byte[]>> a;

    /* renamed from: a  reason: collision with other field name */
    public static final Map<String, byte[]> f1011a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(311648952, "Lcom/xiaomi/push/service/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(311648952, "Lcom/xiaomi/push/service/x;");
                return;
            }
        }
        f1011a = new HashMap();
        a = new ArrayList<>();
    }

    public static void a(Context context, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, context, i, str) == null) {
            synchronized (f1011a) {
                for (String str2 : f1011a.keySet()) {
                    com.xiaomi.channel.commonutils.logger.b.m89a("notify registration error. " + str2);
                    a(context, str2, f1011a.get(str2), i, str);
                }
                f1011a.clear();
            }
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, bArr, Integer.valueOf(i), str2}) == null) {
            Intent intent = new Intent("com.xiaomi.mipush.ERROR");
            intent.setPackage(str);
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_error_code", i);
            intent.putExtra("mipush_error_msg", str2);
            context.sendBroadcast(intent, ah.a(str));
        }
    }

    public static void a(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, xMPushService) == null) {
            try {
                synchronized (a) {
                    arrayList = a;
                    a = new ArrayList<>();
                }
                boolean a2 = com.xiaomi.push.w.a();
                Iterator<Pair<String, byte[]>> it = arrayList.iterator();
                while (it.hasNext()) {
                    Pair<String, byte[]> next = it.next();
                    ah.a(xMPushService, (String) next.first, (byte[]) next.second);
                    if (!a2) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            } catch (gh e) {
                com.xiaomi.channel.commonutils.logger.b.d("meet error when process pending message. " + e);
                xMPushService.a(10, e);
            }
        }
    }

    public static void a(XMPushService xMPushService, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, xMPushService, z) == null) {
            try {
                synchronized (f1011a) {
                    for (String str : f1011a.keySet()) {
                        com.xiaomi.channel.commonutils.logger.b.m89a("processing pending registration request. " + str);
                        ah.a(xMPushService, str, f1011a.get(str));
                        if (z && !com.xiaomi.push.w.a()) {
                            try {
                                Thread.sleep(200L);
                            } catch (Exception unused) {
                            }
                        }
                    }
                    f1011a.clear();
                }
            } catch (gh e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to deal with pending register request. " + e);
                xMPushService.a(10, e);
            }
        }
    }

    public static void a(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, bArr) == null) {
            synchronized (f1011a) {
                com.xiaomi.channel.commonutils.logger.b.m89a("pending registration request. " + str);
                f1011a.put(str, bArr);
            }
        }
    }

    public static void b(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, bArr) == null) {
            synchronized (a) {
                a.add(new Pair<>(str, bArr));
                if (a.size() > 50) {
                    a.remove(0);
                }
            }
        }
    }
}

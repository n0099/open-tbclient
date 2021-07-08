package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.fw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Pair<String, byte[]>> f40700a;

    /* renamed from: a  reason: collision with other field name */
    public static final Map<String, byte[]> f968a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(311648704, "Lcom/xiaomi/push/service/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(311648704, "Lcom/xiaomi/push/service/p;");
                return;
            }
        }
        f968a = new HashMap();
        f40700a = new ArrayList<>();
    }

    public static void a(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, context, i2, str) == null) {
            synchronized (f968a) {
                for (String str2 : f968a.keySet()) {
                    a(context, str2, f968a.get(str2), i2, str);
                }
                f968a.clear();
            }
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, bArr, Integer.valueOf(i2), str2}) == null) {
            Intent intent = new Intent("com.xiaomi.mipush.ERROR");
            intent.setPackage(str);
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_error_code", i2);
            intent.putExtra("mipush_error_msg", str2);
            context.sendBroadcast(intent, y.a(str));
        }
    }

    public static void a(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, xMPushService) == null) {
            try {
                synchronized (f968a) {
                    for (String str : f968a.keySet()) {
                        y.a(xMPushService, str, f968a.get(str));
                    }
                    f968a.clear();
                }
            } catch (fw e2) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to deal with pending register request. " + e2);
                xMPushService.a(10, e2);
            }
        }
    }

    public static void a(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bArr) == null) {
            synchronized (f968a) {
                f968a.put(str, bArr);
            }
        }
    }

    public static void b(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, xMPushService) == null) {
            try {
                synchronized (f40700a) {
                    arrayList = f40700a;
                    f40700a = new ArrayList<>();
                }
                boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
                Iterator<Pair<String, byte[]>> it = arrayList.iterator();
                while (it.hasNext()) {
                    Pair<String, byte[]> next = it.next();
                    y.a(xMPushService, (String) next.first, (byte[]) next.second);
                    if (!z) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            } catch (fw e2) {
                com.xiaomi.channel.commonutils.logger.b.d("meet error when process pending message. " + e2);
                xMPushService.a(10, e2);
            }
        }
    }

    public static void b(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, bArr) == null) {
            synchronized (f40700a) {
                f40700a.add(new Pair<>(str, bArr));
                if (f40700a.size() > 50) {
                    f40700a.remove(0);
                }
            }
        }
    }
}

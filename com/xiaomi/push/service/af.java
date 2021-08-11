package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/* loaded from: classes10.dex */
public class af {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f77729a;

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, Queue<String>> f888a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162209, "Lcom/xiaomi/push/service/af;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162209, "Lcom/xiaomi/push/service/af;");
                return;
            }
        }
        f77729a = new Object();
        f888a = new HashMap();
    }

    public static boolean a(XMPushService xMPushService, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, xMPushService, str, str2)) == null) {
            synchronized (f77729a) {
                SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
                Queue<String> queue = f888a.get(str);
                if (queue == null) {
                    String[] split = sharedPreferences.getString(str, "").split(",");
                    LinkedList linkedList = new LinkedList();
                    for (String str3 : split) {
                        linkedList.add(str3);
                    }
                    f888a.put(str, linkedList);
                    queue = linkedList;
                }
                if (queue.contains(str2)) {
                    return true;
                }
                queue.add(str2);
                if (queue.size() > 25) {
                    queue.poll();
                }
                String a2 = com.xiaomi.push.bm.a(queue, ",");
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str, a2);
                edit.commit();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}

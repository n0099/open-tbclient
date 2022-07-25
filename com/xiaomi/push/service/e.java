package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.ay;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final SparseArray<ay.a<String, String, String>> a;

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f979a;
    public static final SparseArray<Integer> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(311648363, "Lcom/xiaomi/push/service/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(311648363, "Lcom/xiaomi/push/service/e;");
                return;
            }
        }
        f979a = new int[]{1, 2, 4, 8, 16};
        a = new f(5);
        b = new g(5);
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            int i = a(str, str2, 8) ? 8 : 0;
            if (a(str, str2, 16)) {
                i |= 16;
            }
            if (a(str, str2, 1)) {
                i |= 1;
            }
            if (a(str, str2, 2)) {
                i |= 2;
            }
            return a(str, str2, 4) ? i | 4 : i;
        }
        return invokeLL.intValue;
    }

    public static SharedPreferences a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getSharedPreferences("ch_permission_cache_file", 0) : (SharedPreferences) invokeL.objValue;
    }

    public static void a(Context context, String str) {
        List<NotificationChannel> m629a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) || !com.xiaomi.push.m.m561a(context) || TextUtils.isEmpty(str) || (m629a = ax.a(context, str).m629a()) == null) {
            return;
        }
        synchronized (e.class) {
            SharedPreferences a2 = a(context);
            ArrayList arrayList = new ArrayList();
            for (NotificationChannel notificationChannel : m629a) {
                String str2 = (String) com.xiaomi.push.bk.a(notificationChannel, "mId");
                if (!TextUtils.isEmpty(str2) && a2.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() > 0) {
                a(a2, arrayList);
            }
        }
    }

    public static void a(Context context, String str, String str2, int i, String str3, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, str, str2, Integer.valueOf(i), str3, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (!com.xiaomi.push.m.m561a(context) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                if (com.xiaomi.push.m.m561a(context)) {
                    com.xiaomi.channel.commonutils.logger.b.m89a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
                    return;
                }
                return;
            }
            int a2 = com.xiaomi.push.w.a(str3, 0);
            boolean a3 = a(i, a2);
            if (z) {
                a(str, str2, a2, i2);
                if (a3) {
                    synchronized (e.class) {
                        a(a(context), a2, str2);
                    }
                    return;
                }
                return;
            }
            synchronized (e.class) {
                SharedPreferences a4 = a(context);
                if (a3 || a4.contains(str2)) {
                    a(a4, a2, str, str2, i2);
                    if (a3) {
                        a(a4, a2, str2);
                    } else {
                        a(a4, str2);
                    }
                }
            }
        }
    }

    public static void a(SharedPreferences sharedPreferences, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65542, null, sharedPreferences, i, str) == null) {
            sharedPreferences.edit().putInt(str, i).commit();
        }
    }

    public static void a(SharedPreferences sharedPreferences, int i, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{sharedPreferences, Integer.valueOf(i), str, str2, Integer.valueOf(i2)}) == null) || sharedPreferences.getInt(str2, 0) == i) {
            return;
        }
        a(str, str2, i, i2);
    }

    public static void a(SharedPreferences sharedPreferences, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, sharedPreferences, str) == null) {
            a(sharedPreferences, new h(str));
        }
    }

    public static void a(SharedPreferences sharedPreferences, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, sharedPreferences, list) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (String str : list) {
                edit.remove(str);
            }
            edit.commit();
        }
    }

    public static void a(String str, String str2, int i, int i2) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65546, null, str, str2, i, i2) == null) {
            for (int i3 : f979a) {
                if ((b.get(i3).intValue() & i2) == 0) {
                    a(str, str2, i3, (i & i3) > 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m89a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i3 + "> :stoped by userLock");
                }
            }
        }
    }

    public static void a(String str, String str2, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            boolean a2 = ay.a(com.xiaomi.push.v.m687a(), str, str2, a.get(i), z);
            com.xiaomi.channel.commonutils.logger.b.m89a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i + "=" + z + "> :" + a2);
        }
    }

    public static boolean a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65548, null, i, i2)) == null) ? i >= 4 || (i2 & 2) > 0 || (i2 & 1) > 0 || (i2 & 8) > 0 || (i2 & 16) > 0 : invokeII.booleanValue;
    }

    public static boolean a(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65549, null, str, str2, i)) == null) {
            boolean z = ay.a(com.xiaomi.push.v.m687a(), str, str2, a.get(i)) == 1;
            com.xiaomi.channel.commonutils.logger.b.m89a("ChannelPermissions.checkPermission:" + str + ":" + str2 + ": <" + i + "=" + z + ">");
            return z;
        }
        return invokeLLI.booleanValue;
    }
}

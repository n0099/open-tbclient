package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class cg implements XMPushService.n {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;

    /* renamed from: a  reason: collision with other field name */
    public static final Map<Integer, Map<String, List<String>>> f962a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f963a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071164162, "Lcom/xiaomi/push/service/cg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071164162, "Lcom/xiaomi/push/service/cg;");
                return;
            }
        }
        f963a = Log.isLoggable("UNDatas", 3);
        f962a = new HashMap();
    }

    public cg(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a = context;
    }

    public static ii a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, str2, str3, str4)) == null) {
            ii iiVar = new ii();
            if (str3 != null) {
                iiVar.c(str3);
            }
            if (str != null) {
                iiVar.b(str);
            }
            if (str2 != null) {
                iiVar.a(str2);
            }
            if (str4 != null) {
                iiVar.d(str4);
            }
            iiVar.a(false);
            return iiVar;
        }
        return (ii) invokeLLLL.objValue;
    }

    public static void a(Context context, ii iiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, iiVar) == null) {
            if (f963a) {
                com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload message notification:" + iiVar);
            }
            com.xiaomi.push.al.a(context).a(new ch(iiVar));
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(f962a);
            if (hashMap.size() > 0) {
                for (Integer num : hashMap.keySet()) {
                    Map map = (Map) hashMap.get(num);
                    if (map != null && map.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (String str : map.keySet()) {
                            sb.append(str);
                            sb.append(":");
                            List list = (List) map.get(str);
                            if (!com.xiaomi.push.w.a(list)) {
                                for (int i = 0; i < list.size(); i++) {
                                    if (i != 0) {
                                        sb.append(",");
                                    }
                                    sb.append((String) list.get(i));
                                }
                            }
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        ii a2 = a(null, bd.a(), ht.Y.f498a, null);
                        a2.a("removed_reason", String.valueOf(num));
                        a2.a("all_delete_msgId_appId", sb.toString());
                        com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                        a(a, a2);
                    }
                    f962a.remove(num);
                }
            }
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a */
    public void mo389a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || f962a.size() <= 0) {
            return;
        }
        synchronized (f962a) {
            b();
        }
    }
}

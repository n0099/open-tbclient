package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.hm;
import com.xiaomi.push.hn;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public class bz {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: a  reason: collision with other field name */
    public static SimpleDateFormat f962a;

    /* renamed from: a  reason: collision with other field name */
    public static AtomicLong f963a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071163790, "Lcom/xiaomi/push/service/bz;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071163790, "Lcom/xiaomi/push/service/bz;");
                return;
            }
        }
        f963a = new AtomicLong(0L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f962a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static ii a(String str, String str2, hm hmVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, hmVar)) == null) ? new ii("-1", false).d(str).b(str2).a(com.xiaomi.push.ab.a(it.a(hmVar))).c(ht.B.f506a) : (ii) invokeLLL.objValue;
    }

    public static synchronized String a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (bz.class) {
                String format = f962a.format(Long.valueOf(System.currentTimeMillis()));
                if (!TextUtils.equals(a, format)) {
                    f963a.set(0L);
                    a = format;
                }
                str = format + "-" + f963a.incrementAndGet();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<ii> a(List<hn> list, String str, String str2, int i) {
        InterceptResult invokeLLLI;
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65539, null, list, str, str2, i)) == null) {
            if (list == null) {
                str3 = "requests can not be null in TinyDataHelper.transToThriftObj().";
            } else if (list.size() != 0) {
                ArrayList<ii> arrayList = new ArrayList<>();
                hm hmVar = new hm();
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    hn hnVar = list.get(i4);
                    if (hnVar != null) {
                        if (hnVar.m400a() == null || !hnVar.m400a().containsKey("item_size")) {
                            i2 = 0;
                        } else {
                            String str4 = hnVar.m400a().get("item_size");
                            if (!TextUtils.isEmpty(str4)) {
                                try {
                                    i2 = Integer.parseInt(str4);
                                } catch (Exception unused) {
                                }
                                if (hnVar.m400a().size() != 1) {
                                    hnVar.a((Map<String, String>) null);
                                } else {
                                    hnVar.m400a().remove("item_size");
                                }
                            }
                            i2 = 0;
                            if (hnVar.m400a().size() != 1) {
                            }
                        }
                        if (i2 <= 0) {
                            i2 = it.a(hnVar).length;
                        }
                        if (i2 > i) {
                            com.xiaomi.channel.commonutils.logger.b.d("TinyData is too big, ignore upload request item:" + hnVar.d());
                        } else {
                            if (i3 + i2 > i) {
                                arrayList.add(a(str, str2, hmVar));
                                hmVar = new hm();
                                i3 = 0;
                            }
                            hmVar.a(hnVar);
                            i3 += i2;
                        }
                    }
                }
                if (hmVar.a() != 0) {
                    arrayList.add(a(str, str2, hmVar));
                }
                return arrayList;
            } else {
                str3 = "requests.length is 0 in TinyDataHelper.transToThriftObj().";
            }
            com.xiaomi.channel.commonutils.logger.b.d(str3);
            return null;
        }
        return (ArrayList) invokeLLLI.objValue;
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, Long.valueOf(j), str3}) == null) {
            hn hnVar = new hn();
            hnVar.d(str);
            hnVar.c(str2);
            hnVar.a(j);
            hnVar.b(str3);
            hnVar.a("push_sdk_channel");
            hnVar.g(context.getPackageName());
            hnVar.e(context.getPackageName());
            hnVar.a(true);
            hnVar.b(System.currentTimeMillis());
            hnVar.f(a());
            ca.a(context, hnVar);
        }
    }

    public static void a(String str, String str2, String str3, ao aoVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65541, null, str, str2, str3, aoVar) == null) || aoVar == null) {
            return;
        }
        hn hnVar = new hn();
        hnVar.d(str);
        hnVar.c(str2);
        hnVar.g(str3);
        hnVar.e(str3);
        HashMap hashMap = new HashMap();
        hashMap.put("chid", String.valueOf(aoVar.a));
        hashMap.put("screen_on", String.valueOf(aoVar.f902a));
        hashMap.put("wifi", String.valueOf(aoVar.f904b));
        hashMap.put("rx_msg", String.valueOf(aoVar.f901a));
        hashMap.put("enqueue", String.valueOf(aoVar.f903b));
        hashMap.put("num", String.valueOf(aoVar.b));
        hashMap.put("run", String.valueOf(aoVar.c));
        hashMap.put("send", String.valueOf(System.currentTimeMillis()));
        hnVar.a(hashMap);
        ca.a(hnVar);
    }

    public static boolean a(hn hnVar, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, hnVar, z)) == null) {
            if (hnVar == null) {
                str = "item is null, verfiy ClientUploadDataItem failed.";
            } else if (!z && TextUtils.isEmpty(hnVar.f478a)) {
                str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
            } else if (TextUtils.isEmpty(hnVar.f485d)) {
                str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
            } else if (TextUtils.isEmpty(hnVar.f484c)) {
                str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
            } else if (!com.xiaomi.push.bp.m204a(hnVar.f485d)) {
                str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
            } else if (com.xiaomi.push.bp.m204a(hnVar.f484c)) {
                String str2 = hnVar.f483b;
                if (str2 == null || str2.length() <= 10240) {
                    return false;
                }
                str = "item.data is too large(" + hnVar.f483b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.";
            } else {
                str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
            }
            com.xiaomi.channel.commonutils.logger.b.m89a(str);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? !com.xiaomi.push.v.m691b() || Constants.HYBRID_PACKAGE_NAME.equals(str) : invokeL.booleanValue;
    }
}

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
import com.xiaomi.push.hi;
import com.xiaomi.push.hj;
import com.xiaomi.push.hp;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public class bm {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: a  reason: collision with other field name */
    public static SimpleDateFormat f945a;

    /* renamed from: a  reason: collision with other field name */
    public static AtomicLong f946a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071163387, "Lcom/xiaomi/push/service/bm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071163387, "Lcom/xiaomi/push/service/bm;");
                return;
            }
        }
        f946a = new AtomicLong(0L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f945a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static ie a(String str, String str2, hi hiVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, hiVar)) == null) ? new ie("-1", false).d(str).b(str2).a(com.xiaomi.push.y.a(ip.a(hiVar))).c(hp.B.f514a) : (ie) invokeLLL.objValue;
    }

    public static synchronized String a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (bm.class) {
                String format = f945a.format(Long.valueOf(System.currentTimeMillis()));
                if (!TextUtils.equals(a, format)) {
                    f946a.set(0L);
                    a = format;
                }
                str = format + "-" + f946a.incrementAndGet();
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
    public static ArrayList<ie> a(List<hj> list, String str, String str2, int i2) {
        InterceptResult invokeLLLI;
        int i3;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65539, null, list, str, str2, i2)) == null) {
            if (list == null) {
                str3 = "requests can not be null in TinyDataHelper.transToThriftObj().";
            } else if (list.size() != 0) {
                ArrayList<ie> arrayList = new ArrayList<>();
                hi hiVar = new hi();
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    hj hjVar = list.get(i5);
                    if (hjVar != null) {
                        if (hjVar.m439a() == null || !hjVar.m439a().containsKey("item_size")) {
                            i3 = 0;
                        } else {
                            String str4 = hjVar.m439a().get("item_size");
                            if (!TextUtils.isEmpty(str4)) {
                                try {
                                    i3 = Integer.parseInt(str4);
                                } catch (Exception unused) {
                                }
                                if (hjVar.m439a().size() != 1) {
                                    hjVar.a((Map<String, String>) null);
                                } else {
                                    hjVar.m439a().remove("item_size");
                                }
                            }
                            i3 = 0;
                            if (hjVar.m439a().size() != 1) {
                            }
                        }
                        if (i3 <= 0) {
                            i3 = ip.a(hjVar).length;
                        }
                        if (i3 > i2) {
                            com.xiaomi.channel.commonutils.logger.b.d("TinyData is too big, ignore upload request item:" + hjVar.d());
                        } else {
                            if (i4 + i3 > i2) {
                                arrayList.add(a(str, str2, hiVar));
                                hiVar = new hi();
                                i4 = 0;
                            }
                            hiVar.a(hjVar);
                            i4 += i3;
                        }
                    }
                }
                if (hiVar.a() != 0) {
                    arrayList.add(a(str, str2, hiVar));
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

    public static void a(Context context, String str, String str2, long j2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, Long.valueOf(j2), str3}) == null) {
            hj hjVar = new hj();
            hjVar.d(str);
            hjVar.c(str2);
            hjVar.a(j2);
            hjVar.b(str3);
            hjVar.a("push_sdk_channel");
            hjVar.g(context.getPackageName());
            hjVar.e(context.getPackageName());
            hjVar.a(true);
            hjVar.b(System.currentTimeMillis());
            hjVar.f(a());
            bn.a(context, hjVar);
        }
    }

    public static boolean a(hj hjVar, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, hjVar, z)) == null) {
            if (hjVar == null) {
                str = "item is null, verfiy ClientUploadDataItem failed.";
            } else if (!z && TextUtils.isEmpty(hjVar.f486a)) {
                str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
            } else if (TextUtils.isEmpty(hjVar.f493d)) {
                str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
            } else if (TextUtils.isEmpty(hjVar.f492c)) {
                str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
            } else if (!com.xiaomi.push.bm.m244a(hjVar.f493d)) {
                str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
            } else if (com.xiaomi.push.bm.m244a(hjVar.f492c)) {
                String str2 = hjVar.f491b;
                if (str2 == null || str2.length() <= 10240) {
                    return false;
                }
                str = "item.data is too large(" + hjVar.f491b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.";
            } else {
                str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
            }
            com.xiaomi.channel.commonutils.logger.b.m133a(str);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? !com.xiaomi.push.t.m704b() || Constants.HYBRID_PACKAGE_NAME.equals(str) : invokeL.booleanValue;
    }
}

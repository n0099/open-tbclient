package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class hc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static HashMap<String, ArrayList<hj>> a(Context context, List<hj> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, list)) == null) {
            if (list == null || list.size() == 0) {
                return null;
            }
            HashMap<String, ArrayList<hj>> hashMap = new HashMap<>();
            for (hj hjVar : list) {
                a(context, hjVar);
                ArrayList<hj> arrayList = hashMap.get(hjVar.c());
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    hashMap.put(hjVar.c(), arrayList);
                }
                arrayList.add(hjVar);
            }
            return hashMap;
        }
        return (HashMap) invokeLL.objValue;
    }

    public static void a(Context context, he heVar, HashMap<String, ArrayList<hj>> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, heVar, hashMap) == null) {
            for (Map.Entry<String, ArrayList<hj>> entry : hashMap.entrySet()) {
                try {
                    ArrayList<hj> value = entry.getValue();
                    if (value != null && value.size() != 0) {
                        heVar.a(value, value.get(0).e(), entry.getKey());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void a(Context context, he heVar, List<hj> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, heVar, list) == null) {
            HashMap<String, ArrayList<hj>> a = a(context, list);
            if (a != null && a.size() != 0) {
                a(context, heVar, a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m109a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
        }
    }

    public static void a(Context context, hj hjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, hjVar) == null) {
            if (hjVar.f465a) {
                hjVar.a("push_sdk_channel");
            }
            if (TextUtils.isEmpty(hjVar.d())) {
                hjVar.f(com.xiaomi.push.service.bm.a());
            }
            hjVar.b(System.currentTimeMillis());
            if (TextUtils.isEmpty(hjVar.e())) {
                hjVar.e(context.getPackageName());
            }
            if (TextUtils.isEmpty(hjVar.c())) {
                hjVar.e(hjVar.e());
            }
        }
    }
}

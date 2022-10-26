package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class hf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static HashMap a(Context context, List list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, list)) == null) {
            if (list == null || list.size() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                hn hnVar = (hn) it.next();
                a(context, hnVar);
                ArrayList arrayList = (ArrayList) hashMap.get(hnVar.c());
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashMap.put(hnVar.c(), arrayList);
                }
                arrayList.add(hnVar);
            }
            return hashMap;
        }
        return (HashMap) invokeLL.objValue;
    }

    public static void a(Context context, hh hhVar, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, hhVar, hashMap) == null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                try {
                    ArrayList arrayList = (ArrayList) entry.getValue();
                    if (arrayList != null && arrayList.size() != 0) {
                        hhVar.a(arrayList, ((hn) arrayList.get(0)).e(), (String) entry.getKey());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void a(Context context, hh hhVar, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, hhVar, list) == null) {
            HashMap a = a(context, list);
            if (a != null && a.size() != 0) {
                a(context, hhVar, a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m89a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
        }
    }

    public static void a(Context context, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, hnVar) == null) {
            if (hnVar.f481a) {
                hnVar.a("push_sdk_channel");
            }
            if (TextUtils.isEmpty(hnVar.d())) {
                hnVar.f(com.xiaomi.push.service.bz.a());
            }
            hnVar.b(System.currentTimeMillis());
            if (TextUtils.isEmpty(hnVar.e())) {
                hnVar.e(context.getPackageName());
            }
            if (TextUtils.isEmpty(hnVar.c())) {
                hnVar.e(hnVar.e());
            }
        }
    }
}

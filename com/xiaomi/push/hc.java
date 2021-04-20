package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class hc {
    public static HashMap<String, ArrayList<hj>> a(Context context, List<hj> list) {
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

    public static void a(Context context, he heVar, HashMap<String, ArrayList<hj>> hashMap) {
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

    public static void a(Context context, he heVar, List<hj> list) {
        HashMap<String, ArrayList<hj>> a2 = a(context, list);
        if (a2 != null && a2.size() != 0) {
            a(context, heVar, a2);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m55a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
    }

    public static void a(Context context, hj hjVar) {
        if (hjVar.f481a) {
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

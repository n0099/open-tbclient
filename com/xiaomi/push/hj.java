package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes18.dex */
public class hj {
    private static HashMap<String, ArrayList<hq>> a(Context context, List<hq> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<hq>> hashMap = new HashMap<>();
        for (hq hqVar : list) {
            a(context, hqVar);
            ArrayList<hq> arrayList = hashMap.get(hqVar.c());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                hashMap.put(hqVar.c(), arrayList);
            }
            arrayList.add(hqVar);
        }
        return hashMap;
    }

    private static void a(Context context, hl hlVar, HashMap<String, ArrayList<hq>> hashMap) {
        for (Map.Entry<String, ArrayList<hq>> entry : hashMap.entrySet()) {
            try {
                ArrayList<hq> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    hlVar.a(value, value.get(0).e(), entry.getKey());
                }
            } catch (Exception e) {
            }
        }
    }

    public static void a(Context context, hl hlVar, List<hq> list) {
        HashMap<String, ArrayList<hq>> a2 = a(context, list);
        if (a2 == null || a2.size() == 0) {
            com.xiaomi.channel.commonutils.logger.b.m57a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
        } else {
            a(context, hlVar, a2);
        }
    }

    private static void a(Context context, hq hqVar) {
        if (hqVar.f454a) {
            hqVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(hqVar.d())) {
            hqVar.f(com.xiaomi.push.service.bi.a());
        }
        hqVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(hqVar.e())) {
            hqVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(hqVar.c())) {
            hqVar.e(hqVar.e());
        }
    }
}

package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class hd {
    private static HashMap<String, ArrayList<hk>> a(Context context, List<hk> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<hk>> hashMap = new HashMap<>();
        for (hk hkVar : list) {
            a(context, hkVar);
            ArrayList<hk> arrayList = hashMap.get(hkVar.c());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                hashMap.put(hkVar.c(), arrayList);
            }
            arrayList.add(hkVar);
        }
        return hashMap;
    }

    private static void a(Context context, hf hfVar, HashMap<String, ArrayList<hk>> hashMap) {
        for (Map.Entry<String, ArrayList<hk>> entry : hashMap.entrySet()) {
            try {
                ArrayList<hk> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    com.xiaomi.channel.commonutils.logger.b.m33a("TinyData is uploaded immediately item size:" + value.size());
                    hfVar.a(value, value.get(0).e(), entry.getKey());
                }
            } catch (Exception e) {
            }
        }
    }

    public static void a(Context context, hf hfVar, List<hk> list) {
        HashMap<String, ArrayList<hk>> a = a(context, list);
        if (a == null || a.size() == 0) {
            com.xiaomi.channel.commonutils.logger.b.m33a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
        } else {
            a(context, hfVar, a);
        }
    }

    private static void a(Context context, hk hkVar) {
        if (hkVar.f469a) {
            hkVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(hkVar.d())) {
            hkVar.f(com.xiaomi.push.service.be.a());
        }
        hkVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(hkVar.e())) {
            hkVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(hkVar.c())) {
            hkVar.e(hkVar.e());
        }
    }
}

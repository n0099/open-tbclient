package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class he {
    public static HashMap<String, ArrayList<hl>> a(Context context, List<hl> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<hl>> hashMap = new HashMap<>();
        for (hl hlVar : list) {
            a(context, hlVar);
            ArrayList<hl> arrayList = hashMap.get(hlVar.c());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                hashMap.put(hlVar.c(), arrayList);
            }
            arrayList.add(hlVar);
        }
        return hashMap;
    }

    public static void a(Context context, hg hgVar, HashMap<String, ArrayList<hl>> hashMap) {
        for (Map.Entry<String, ArrayList<hl>> entry : hashMap.entrySet()) {
            try {
                ArrayList<hl> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    hgVar.a(value, value.get(0).e(), entry.getKey());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, hg hgVar, List<hl> list) {
        HashMap<String, ArrayList<hl>> a = a(context, list);
        if (a != null && a.size() != 0) {
            a(context, hgVar, a);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m101a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
    }

    public static void a(Context context, hl hlVar) {
        if (hlVar.f483a) {
            hlVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(hlVar.d())) {
            hlVar.f(com.xiaomi.push.service.bz.a());
        }
        hlVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(hlVar.e())) {
            hlVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(hlVar.c())) {
            hlVar.e(hlVar.e());
        }
    }
}

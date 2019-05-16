package com.xiaomi.tinyData;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.bj;
import com.xiaomi.xmpush.thrift.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class c {
    private static HashMap<String, ArrayList<f>> a(Context context, List<f> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<f>> hashMap = new HashMap<>();
        for (f fVar : list) {
            a(context, fVar);
            ArrayList<f> arrayList = hashMap.get(fVar.k());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                hashMap.put(fVar.k(), arrayList);
            }
            arrayList.add(fVar);
        }
        return hashMap;
    }

    private static void a(Context context, e eVar, HashMap<String, ArrayList<f>> hashMap) {
        for (Map.Entry<String, ArrayList<f>> entry : hashMap.entrySet()) {
            try {
                ArrayList<f> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    com.xiaomi.channel.commonutils.logger.b.a("TinyData is uploaded immediately item size:" + value.size());
                    eVar.a(value, value.get(0).p(), entry.getKey());
                }
            } catch (Exception e) {
            }
        }
    }

    public static void a(Context context, e eVar, List<f> list) {
        HashMap<String, ArrayList<f>> a = a(context, list);
        if (a == null || a.size() == 0) {
            com.xiaomi.channel.commonutils.logger.b.a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
        } else {
            a(context, eVar, a);
        }
    }

    private static void a(Context context, f fVar) {
        if (fVar.f) {
            fVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(fVar.m())) {
            fVar.f(bj.a());
        }
        fVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(fVar.p())) {
            fVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(fVar.k())) {
            fVar.e(fVar.p());
        }
    }
}

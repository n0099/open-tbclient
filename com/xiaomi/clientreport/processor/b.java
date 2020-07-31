package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.bj;
import java.io.File;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class b implements IPerfProcessor {
    protected Context a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f25a;

    public b(Context context) {
        this.a = context;
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production) + "#" + aVar.clientInterfaceId;
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        String str = "";
        int i = aVar.production;
        String str2 = aVar.clientInterfaceId;
        if (i > 0 && !TextUtils.isEmpty(str2)) {
            str = String.valueOf(i) + "#" + str2;
        }
        File externalFilesDir = this.a.getExternalFilesDir("perf");
        if (externalFilesDir == null) {
            com.xiaomi.channel.commonutils.logger.b.d("cannot get folder when to write perf");
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return new File(externalFilesDir, str).getAbsolutePath();
    }

    private String c(com.xiaomi.clientreport.data.a aVar) {
        String str;
        String b = b(aVar);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 20) {
                str = null;
                break;
            }
            str = b + i2;
            if (bj.m163a(this.a, str)) {
                break;
            }
            i = i2 + 1;
        }
        return str;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        bj.a(this.a, "perf", "perfUploading");
        File[] m164a = bj.m164a(this.a, "perfUploading");
        if (m164a == null || m164a.length <= 0) {
            return;
        }
        for (File file : m164a) {
            if (file != null) {
                List<String> a = e.a(this.a, file.getAbsolutePath());
                file.delete();
                a(a);
            }
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a */
    public void mo56a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof PerfClientReport) && this.f25a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) aVar;
            String a = a((com.xiaomi.clientreport.data.a) perfClientReport);
            String a2 = e.a(perfClientReport);
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f25a.get(a);
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = hashMap == null ? new HashMap<>() : hashMap;
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap2.get(a2);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap2.put(a2, perfClientReport);
            this.f25a.put(a, hashMap2);
        }
    }

    public void a(List<String> list) {
        bj.a(this.a, list);
    }

    public void a(com.xiaomi.clientreport.data.a[] aVarArr) {
        String c = c(aVarArr[0]);
        if (TextUtils.isEmpty(c)) {
            return;
        }
        e.a(c, aVarArr);
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        if (this.f25a == null) {
            return;
        }
        if (this.f25a.size() > 0) {
            for (String str : this.f25a.keySet()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f25a.get(str);
                if (hashMap != null && hashMap.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[hashMap.size()];
                    hashMap.values().toArray(aVarArr);
                    a(aVarArr);
                }
            }
        }
        this.f25a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap) {
        this.f25a = hashMap;
    }
}

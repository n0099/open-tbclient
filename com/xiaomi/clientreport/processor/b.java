package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.bj;
import java.io.File;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements IPerfProcessor {

    /* renamed from: a  reason: collision with root package name */
    protected Context f13783a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f102a;

    public b(Context context) {
        this.f13783a = context;
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
        File externalFilesDir = this.f13783a.getExternalFilesDir("perf");
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
        String b2 = b(aVar);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 20) {
                str = null;
                break;
            }
            str = b2 + i2;
            if (bj.m194a(this.f13783a, str)) {
                break;
            }
            i = i2 + 1;
        }
        return str;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        bj.a(this.f13783a, "perf", "perfUploading");
        File[] m195a = bj.m195a(this.f13783a, "perfUploading");
        if (m195a == null || m195a.length <= 0) {
            return;
        }
        for (File file : m195a) {
            if (file != null) {
                List<String> a2 = e.a(this.f13783a, file.getAbsolutePath());
                file.delete();
                a(a2);
            }
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a */
    public void mo87a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof PerfClientReport) && this.f102a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) aVar;
            String a2 = a((com.xiaomi.clientreport.data.a) perfClientReport);
            String a3 = e.a(perfClientReport);
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f102a.get(a2);
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = hashMap == null ? new HashMap<>() : hashMap;
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap2.get(a3);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap2.put(a3, perfClientReport);
            this.f102a.put(a2, hashMap2);
        }
    }

    public void a(List<String> list) {
        bj.a(this.f13783a, list);
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
        if (this.f102a == null) {
            return;
        }
        if (this.f102a.size() > 0) {
            for (String str : this.f102a.keySet()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f102a.get(str);
                if (hashMap != null && hashMap.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[hashMap.size()];
                    hashMap.values().toArray(aVarArr);
                    a(aVarArr);
                }
            }
        }
        this.f102a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap) {
        this.f102a = hashMap;
    }
}

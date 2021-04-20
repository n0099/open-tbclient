package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.coremedia.iso.boxes.PerformerBox;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.bq;
import java.io.File;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements IPerfProcessor {

    /* renamed from: a  reason: collision with root package name */
    public Context f40424a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f40a;

    public b(Context context) {
        this.f40424a = context;
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production) + "#" + aVar.clientInterfaceId;
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        String str;
        int i = aVar.production;
        String str2 = aVar.clientInterfaceId;
        if (i <= 0 || TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = String.valueOf(i) + "#" + str2;
        }
        File externalFilesDir = this.f40424a.getExternalFilesDir(PerformerBox.TYPE);
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
        String b2 = b(aVar);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        for (int i = 0; i < 20; i++) {
            String str = b2 + i;
            if (bq.m171a(this.f40424a, str)) {
                return str;
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        bq.a(this.f40424a, PerformerBox.TYPE, "perfUploading");
        File[] m172a = bq.m172a(this.f40424a, "perfUploading");
        if (m172a == null || m172a.length <= 0) {
            return;
        }
        for (File file : m172a) {
            if (file != null) {
                List<String> a2 = e.a(this.f40424a, file.getAbsolutePath());
                file.delete();
                a(a2);
            }
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a */
    public void mo63a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof PerfClientReport) && this.f40a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) aVar;
            String a2 = a((com.xiaomi.clientreport.data.a) perfClientReport);
            String a3 = e.a(perfClientReport);
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f40a.get(a2);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap.get(a3);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap.put(a3, perfClientReport);
            this.f40a.put(a2, hashMap);
        }
    }

    public void a(List<String> list) {
        bq.a(this.f40424a, list);
    }

    public void a(com.xiaomi.clientreport.data.a[] aVarArr) {
        String c2 = c(aVarArr[0]);
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        e.a(c2, aVarArr);
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f40a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            for (String str : this.f40a.keySet()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f40a.get(str);
                if (hashMap2 != null && hashMap2.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[hashMap2.size()];
                    hashMap2.values().toArray(aVarArr);
                    a(aVarArr);
                }
            }
        }
        this.f40a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap) {
        this.f40a = hashMap;
    }
}

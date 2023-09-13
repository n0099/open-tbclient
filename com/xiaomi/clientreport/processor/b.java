package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.coremedia.iso.boxes.PerformerBox;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.bs;
import java.io.File;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements IPerfProcessor {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f32a;

    public b(Context context) {
        this.a = context;
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
        File externalFilesDir = this.a.getExternalFilesDir(PerformerBox.TYPE);
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
        String b = b(aVar);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        for (int i = 0; i < 20; i++) {
            String str = b + i;
            if (bs.m303a(this.a, str)) {
                return str;
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        bs.a(this.a, PerformerBox.TYPE, "perfUploading");
        File[] m304a = bs.m304a(this.a, "perfUploading");
        if (m304a == null || m304a.length <= 0) {
            return;
        }
        for (File file : m304a) {
            if (file != null) {
                List<String> a = e.a(this.a, file.getAbsolutePath());
                file.delete();
                a(a);
            }
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a */
    public void mo189a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof PerfClientReport) && this.f32a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) aVar;
            String a = a((com.xiaomi.clientreport.data.a) perfClientReport);
            String a2 = e.a(perfClientReport);
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f32a.get(a);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap.get(a2);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap.put(a2, perfClientReport);
            this.f32a.put(a, hashMap);
        }
    }

    public void a(List<String> list) {
        bs.a(this.a, list);
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
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f32a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            for (String str : this.f32a.keySet()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f32a.get(str);
                if (hashMap2 != null && hashMap2.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[hashMap2.size()];
                    hashMap2.values().toArray(aVarArr);
                    a(aVarArr);
                }
            }
        }
        this.f32a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap) {
        this.f32a = hashMap;
    }
}

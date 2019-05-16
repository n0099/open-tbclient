package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.coremedia.iso.boxes.PerformerBox;
import com.xiaomi.clientreport.data.PerfClientReport;
import java.io.File;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements IPerfProcessor {
    protected Context a;
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> b;

    public b(Context context) {
        this.a = context;
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production) + "#" + aVar.clientInterfaceId;
    }

    private String c(com.xiaomi.clientreport.data.a aVar) {
        String str = "";
        int i = aVar.production;
        String str2 = aVar.clientInterfaceId;
        if (i > 0 && !TextUtils.isEmpty(str2)) {
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

    private String d(com.xiaomi.clientreport.data.a aVar) {
        String str;
        String c = c(aVar);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 20) {
                str = null;
                break;
            }
            str = c + i2;
            if (com.xiaomi.clientreport.util.a.b(this.a, str)) {
                break;
            }
            i = i2 + 1;
        }
        return str;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        com.xiaomi.clientreport.util.a.a(this.a, PerformerBox.TYPE, "perfUploading");
        File[] c = com.xiaomi.clientreport.util.a.c(this.a, "perfUploading");
        if (c == null || c.length <= 0) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + "  perfread  paths " + c.length);
        for (File file : c) {
            if (file != null) {
                List<String> a = e.a(this.a, file.getAbsolutePath());
                file.delete();
                a(a);
            }
        }
    }

    public void a(List<String> list) {
        com.xiaomi.clientreport.util.a.a(this.a, list);
    }

    public void a(com.xiaomi.clientreport.data.a[] aVarArr) {
        String d = d(aVarArr[0]);
        if (TextUtils.isEmpty(d)) {
            return;
        }
        e.a(d, aVarArr);
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        if (this.b == null) {
            return;
        }
        if (this.b.size() > 0) {
            for (String str : this.b.keySet()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.b.get(str);
                if (hashMap != null && hashMap.size() > 0) {
                    com.xiaomi.channel.commonutils.logger.b.c("begin write perfJob " + hashMap.size());
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[hashMap.size()];
                    hashMap.values().toArray(aVarArr);
                    a(aVarArr);
                }
            }
        }
        this.b.clear();
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof PerfClientReport) && this.b != null) {
            PerfClientReport perfClientReport = (PerfClientReport) aVar;
            String a = a(perfClientReport);
            String a2 = e.a(perfClientReport);
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.b.get(a);
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = hashMap == null ? new HashMap<>() : hashMap;
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap2.get(a2);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap2.put(a2, perfClientReport);
            this.b.put(a, hashMap2);
            com.xiaomi.channel.commonutils.logger.b.c("pre perf inner " + hashMap2.size() + " outer " + this.b.size());
        }
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap) {
        this.b = hashMap;
    }
}

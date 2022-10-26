package com.kwad.sdk.core.report;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class l implements j {
    public final Map aaf = new LinkedHashMap();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.j
    /* renamed from: b */
    public synchronized void d(c cVar) {
        this.aaf.put(cVar.ZR, cVar);
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized void q(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.aaf.remove(((c) it.next()).ZR);
        }
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized long size() {
        int size;
        size = this.aaf.size();
        com.kwad.sdk.core.e.b.d("MemReportCache", "size() = " + size);
        return size;
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized List uy() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.aaf.size());
        for (Map.Entry entry : this.aaf.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }
}

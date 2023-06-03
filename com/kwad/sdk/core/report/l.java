package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public final class l<T extends c> implements j<T> {
    public final Map<String, T> aaf = new LinkedHashMap();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.j
    /* renamed from: b */
    public synchronized void d(@NonNull T t) {
        this.aaf.put(t.ZR, t);
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized void q(List<T> list) {
        for (T t : list) {
            this.aaf.remove(t.ZR);
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
    public final synchronized List<T> uy() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.aaf.size());
        for (Map.Entry<String, T> entry : this.aaf.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }
}

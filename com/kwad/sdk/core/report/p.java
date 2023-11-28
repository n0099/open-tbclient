package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.g;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public final class p<T extends g> implements o<T> {
    public final Map<String, T> avF = new LinkedHashMap();

    @Override // com.kwad.sdk.core.report.o
    public final synchronized List<T> Dw() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.avF.size());
        for (Map.Entry<String, T> entry : this.avF.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.core.report.o
    public final synchronized long size() {
        int size;
        size = this.avF.size();
        com.kwad.sdk.core.e.c.d("MemReportCache", "size() = " + size);
        return size;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.o
    /* renamed from: b */
    public synchronized void j(@NonNull T t) {
        this.avF.put(t.actionId, t);
    }

    @Override // com.kwad.sdk.core.report.o
    public final synchronized void v(List<T> list) {
        for (T t : list) {
            if (t != null) {
                this.avF.remove(t.actionId);
            }
        }
    }
}

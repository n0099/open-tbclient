package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class j<T extends c> implements h<T> {
    public Map<String, T> a = new LinkedHashMap();

    @Override // com.kwad.sdk.core.report.h
    public synchronized long a() {
        int size;
        size = this.a.size();
        com.kwad.sdk.core.d.a.a("MemReportCache", "size() = " + size);
        return size;
    }

    public synchronized void a(@NonNull T t) {
        this.a.put(t.a, t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.core.report.j<T extends com.kwad.sdk.core.report.c> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.report.h
    public /* bridge */ /* synthetic */ void a(@NonNull Object obj) {
        a((j<T>) ((c) obj));
    }

    @Override // com.kwad.sdk.core.report.h
    public synchronized void a(List<T> list) {
        for (T t : list) {
            this.a.remove(t.a);
        }
    }

    @Override // com.kwad.sdk.core.report.h
    public synchronized List<T> b() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.a.size());
        for (Map.Entry<String, T> entry : this.a.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }
}

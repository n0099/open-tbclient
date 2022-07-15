package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class l<T extends c> implements j<T> {
    public final Map<String, T> a = new LinkedHashMap();

    private synchronized void a(@NonNull T t) {
        this.a.put(t.a, t);
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized long a() {
        int size;
        size = this.a.size();
        com.kwad.sdk.core.d.b.a("MemReportCache", "size() = " + size);
        return size;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.core.report.l<T extends com.kwad.sdk.core.report.c> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.report.j
    public final /* bridge */ /* synthetic */ void a(@NonNull Object obj) {
        a((l<T>) ((c) obj));
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized void a(List<T> list) {
        for (T t : list) {
            this.a.remove(t.a);
        }
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized List<T> b() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.a.size());
        for (Map.Entry<String, T> entry : this.a.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }
}

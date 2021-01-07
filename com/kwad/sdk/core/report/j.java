package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.d;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class j<T extends d> implements i<T> {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, T> f9720a = new LinkedHashMap();

    @Override // com.kwad.sdk.core.report.i
    public synchronized long a() {
        int size;
        size = this.f9720a.size();
        com.kwad.sdk.core.d.a.a("MemReportCache", "size() = " + size);
        return size;
    }

    public synchronized void a(@NonNull T t) {
        this.f9720a.put(t.f9714a, t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.core.report.j<T extends com.kwad.sdk.core.report.d> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.report.i
    public /* bridge */ /* synthetic */ void a(@NonNull Object obj) {
        a((j<T>) ((d) obj));
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized void a(List<T> list) {
        for (T t : list) {
            this.f9720a.remove(t.f9714a);
        }
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized List<T> b() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f9720a.size());
        for (Map.Entry<String, T> entry : this.f9720a.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }
}

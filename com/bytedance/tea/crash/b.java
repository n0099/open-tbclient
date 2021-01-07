package com.bytedance.tea.crash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Map<c, List<a>> f7918a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f7919b = new HashMap();
    private final List<e> c = new CopyOnWriteArrayList();
    private final List<e> d = new CopyOnWriteArrayList();
    private final List<e> e = new CopyOnWriteArrayList();
    private final List<e> f = new CopyOnWriteArrayList();
    private f ppU = null;

    @Nullable
    public List<a> b(c cVar) {
        return this.f7918a.get(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Map<? extends String, ? extends String> map) {
        this.f7919b.putAll(map);
    }

    public Map<String, String> a() {
        return this.f7919b;
    }

    @NonNull
    public List<e> b() {
        return this.d;
    }

    @NonNull
    public List<e> c() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar) {
        this.ppU = fVar;
    }

    @Nullable
    public f esw() {
        return this.ppU;
    }
}

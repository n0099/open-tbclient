package com.meizu.cloud.pushsdk.c.d;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private int f11286a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicLong f11287b = new AtomicLong(0);
    private Map<Long, byte[]> c = new ConcurrentHashMap();
    private List<Long> d = new CopyOnWriteArrayList();

    public c(int i) {
        this.f11286a = i;
    }

    @Override // com.meizu.cloud.pushsdk.c.d.d
    public void a(com.meizu.cloud.pushsdk.c.a.a aVar) {
        b(aVar);
    }

    @Override // com.meizu.cloud.pushsdk.c.d.d
    public boolean a() {
        return true;
    }

    @Override // com.meizu.cloud.pushsdk.c.d.d
    public boolean a(long j) {
        return this.d.remove(Long.valueOf(j)) && this.c.remove(Long.valueOf(j)) != null;
    }

    public long b(com.meizu.cloud.pushsdk.c.a.a aVar) {
        byte[] a2 = a.a(aVar.a());
        long andIncrement = this.f11287b.getAndIncrement();
        this.d.add(Long.valueOf(andIncrement));
        this.c.put(Long.valueOf(andIncrement), a2);
        return andIncrement;
    }

    @Override // com.meizu.cloud.pushsdk.c.d.d
    public long c() {
        return this.d.size();
    }

    @Override // com.meizu.cloud.pushsdk.c.d.d
    public com.meizu.cloud.pushsdk.c.b.b d() {
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        int c = (int) c();
        int i = c > this.f11286a ? this.f11286a : c;
        for (int i2 = 0; i2 < i; i2++) {
            Long l = this.d.get(i2);
            if (l != null) {
                com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
                cVar.a(a.a(this.c.get(l)));
                com.meizu.cloud.pushsdk.c.f.c.c("MemoryStore", " current key " + l + " payload " + cVar, new Object[0]);
                linkedList.add(l);
                arrayList.add(cVar);
            }
        }
        return new com.meizu.cloud.pushsdk.c.b.b(arrayList, linkedList);
    }
}

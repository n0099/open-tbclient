package com.meizu.cloud.pushsdk.c.d;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    public int f75185a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicLong f75186b = new AtomicLong(0);

    /* renamed from: c  reason: collision with root package name */
    public Map<Long, byte[]> f75187c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public List<Long> f75188d = new CopyOnWriteArrayList();

    public c(int i2) {
        this.f75185a = i2;
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
    public boolean a(long j2) {
        return this.f75188d.remove(Long.valueOf(j2)) && this.f75187c.remove(Long.valueOf(j2)) != null;
    }

    public long b(com.meizu.cloud.pushsdk.c.a.a aVar) {
        byte[] a2 = a.a(aVar.a());
        long andIncrement = this.f75186b.getAndIncrement();
        this.f75188d.add(Long.valueOf(andIncrement));
        this.f75187c.put(Long.valueOf(andIncrement), a2);
        return andIncrement;
    }

    @Override // com.meizu.cloud.pushsdk.c.d.d
    public long c() {
        return this.f75188d.size();
    }

    @Override // com.meizu.cloud.pushsdk.c.d.d
    public com.meizu.cloud.pushsdk.c.b.b d() {
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        int c2 = (int) c();
        int i2 = this.f75185a;
        if (c2 > i2) {
            c2 = i2;
        }
        for (int i3 = 0; i3 < c2; i3++) {
            Long l = this.f75188d.get(i3);
            if (l != null) {
                com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
                cVar.a(a.a(this.f75187c.get(l)));
                com.meizu.cloud.pushsdk.c.f.c.c("MemoryStore", " current key " + l + " payload " + cVar, new Object[0]);
                linkedList.add(l);
                arrayList.add(cVar);
            }
        }
        return new com.meizu.cloud.pushsdk.c.b.b(arrayList, linkedList);
    }
}

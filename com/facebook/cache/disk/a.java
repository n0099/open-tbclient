package com.facebook.cache.disk;

import com.facebook.cache.disk.c;
/* loaded from: classes2.dex */
public class a implements g {
    @Override // com.facebook.cache.disk.g
    public f cCi() {
        return new f() { // from class: com.facebook.cache.disk.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(c.a aVar, c.a aVar2) {
                long timestamp = aVar.getTimestamp();
                long timestamp2 = aVar2.getTimestamp();
                if (timestamp < timestamp2) {
                    return -1;
                }
                return timestamp2 == timestamp ? 0 : 1;
            }
        };
    }
}

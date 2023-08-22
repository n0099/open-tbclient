package com.xiaomi.push;

import com.xiaomi.push.aj;
import java.util.Map;
/* loaded from: classes10.dex */
public class al extends aj.b {
    public final /* synthetic */ aj a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(aj ajVar, aj.a aVar) {
        super(aVar);
        this.a = ajVar;
    }

    @Override // com.xiaomi.push.aj.b
    public void b() {
        Object obj;
        Map map;
        obj = this.a.f99a;
        synchronized (obj) {
            map = this.a.f100a;
            map.remove(super.a.mo300a());
        }
    }
}

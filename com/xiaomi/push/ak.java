package com.xiaomi.push;

import com.xiaomi.push.ai;
import java.util.Map;
/* loaded from: classes7.dex */
public class ak extends ai.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ai f41082a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(ai aiVar, ai.a aVar) {
        super(aVar);
        this.f41082a = aiVar;
    }

    @Override // com.xiaomi.push.ai.b
    public void b() {
        Object obj;
        Map map;
        obj = this.f41082a.f104a;
        synchronized (obj) {
            map = this.f41082a.f105a;
            map.remove(super.f41080a.mo170a());
        }
    }
}

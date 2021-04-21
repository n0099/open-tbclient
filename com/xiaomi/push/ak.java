package com.xiaomi.push;

import com.xiaomi.push.ai;
import java.util.Map;
/* loaded from: classes7.dex */
public class ak extends ai.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ai f40611a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(ai aiVar, ai.a aVar) {
        super(aVar);
        this.f40611a = aiVar;
    }

    @Override // com.xiaomi.push.ai.b
    public void b() {
        Object obj;
        Map map;
        obj = this.f40611a.f104a;
        synchronized (obj) {
            map = this.f40611a.f105a;
            map.remove(super.f40609a.mo169a());
        }
    }
}

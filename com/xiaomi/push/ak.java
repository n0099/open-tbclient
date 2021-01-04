package com.xiaomi.push;

import android.util.SparseArray;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ak extends ai.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ai f14153a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(ai aiVar, ai.a aVar) {
        super(aVar);
        this.f14153a = aiVar;
    }

    @Override // com.xiaomi.push.ai.b
    void b() {
        Object obj;
        SparseArray sparseArray;
        obj = this.f14153a.f175a;
        synchronized (obj) {
            sparseArray = this.f14153a.f174a;
            sparseArray.remove(this.f14151a.mo185a());
        }
    }
}

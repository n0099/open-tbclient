package com.xiaomi.push;

import android.util.SparseArray;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ak extends ai.b {
    final /* synthetic */ ai a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(ai aiVar, ai.a aVar) {
        super(aVar);
        this.a = aiVar;
    }

    @Override // com.xiaomi.push.ai.b
    void b() {
        Object obj;
        SparseArray sparseArray;
        obj = this.a.f95a;
        synchronized (obj) {
            sparseArray = this.a.f94a;
            sparseArray.remove(this.a.mo163a());
        }
    }
}

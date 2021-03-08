package com.xiaomi.push;

import android.util.SparseArray;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class ak extends ai.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ai f8255a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(ai aiVar, ai.a aVar) {
        super(aVar);
        this.f8255a = aiVar;
    }

    @Override // com.xiaomi.push.ai.b
    void b() {
        Object obj;
        SparseArray sparseArray;
        obj = this.f8255a.f96a;
        synchronized (obj) {
            sparseArray = this.f8255a.f95a;
            sparseArray.remove(this.f8253a.mo170a());
        }
    }
}

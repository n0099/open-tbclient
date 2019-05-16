package com.xiaomi.channel.commonutils.misc;

import android.util.SparseArray;
import com.xiaomi.channel.commonutils.misc.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class j extends h.b {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, h.a aVar) {
        super(aVar);
        this.a = hVar;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.b
    void b() {
        Object obj;
        SparseArray sparseArray;
        obj = this.a.d;
        synchronized (obj) {
            sparseArray = this.a.c;
            sparseArray.remove(this.c.a());
        }
    }
}

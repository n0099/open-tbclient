package com.google.android.gms.appstate;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.c;
import com.google.android.gms.internal.k;
/* loaded from: classes.dex */
public final class AppStateBuffer extends DataBuffer {
    public AppStateBuffer(k kVar) {
        super(kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: a */
    public AppState b(int i) {
        return new c(this.a, i);
    }
}

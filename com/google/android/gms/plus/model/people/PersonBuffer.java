package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.es;
import com.google.android.gms.internal.k;
/* loaded from: classes.dex */
public final class PersonBuffer extends DataBuffer {
    public PersonBuffer(k kVar) {
        super(kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: a */
    public Person b(int i) {
        return new es(this.a, i);
    }
}

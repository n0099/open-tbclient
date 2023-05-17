package com.google.android.gms.internal.common;

import java.util.Iterator;
/* loaded from: classes9.dex */
public final class zzad<E> extends zzaa<E> {
    public zzad() {
        super(4);
    }

    public zzad(int i) {
        super(4);
    }

    public final zzad<E> zzb(E e) {
        super.zza(e);
        return this;
    }

    public final zzad<E> zzc(Iterator<? extends E> it) {
        while (it.hasNext()) {
            super.zza(it.next());
        }
        return this;
    }
}

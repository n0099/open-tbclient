package com.google.android.gms.internal.common;
/* loaded from: classes8.dex */
public final class zzai<E> extends zzag<E> {
    public static final zzag<Object> zza = new zzai(new Object[0], 0);
    public final transient Object[] zzb;
    public final transient int zzc;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final Object[] zzg() {
        return this.zzb;
    }

    public zzai(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.common.zzag, com.google.android.gms.internal.common.zzac
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzs.zza(i, this.zzc, "index");
        E e = (E) this.zzb[i];
        e.getClass();
        return e;
    }
}

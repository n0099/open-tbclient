package com.google.android.gms.common;

import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public abstract class zzk extends zzi {
    public static final WeakReference<byte[]> zza = new WeakReference<>(null);
    public WeakReference<byte[]> zzb;

    public abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzi
    public final byte[] zzf() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.zzb.get();
            if (bArr == null) {
                bArr = zzb();
                this.zzb = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    public zzk(byte[] bArr) {
        super(bArr);
        this.zzb = zza;
    }
}

package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public final class zzx {
    public final zzo zza;
    public final boolean zzb;
    public final zzu zzc;

    public zzx(zzu zzuVar, boolean z, zzo zzoVar, int i, byte[] bArr) {
        this.zzc = zzuVar;
        this.zzb = z;
        this.zza = zzoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator<String> zzh(CharSequence charSequence) {
        return new zzt(this.zzc, this, charSequence);
    }

    public final zzx zzb() {
        return new zzx(this.zzc, true, this.zza, Integer.MAX_VALUE, null);
    }

    public final Iterable<String> zzd(CharSequence charSequence) {
        return new zzv(this, charSequence);
    }

    public static zzx zzc(zzo zzoVar) {
        return new zzx(new zzu(zzoVar), false, zzn.zza, Integer.MAX_VALUE, null);
    }

    public final List<String> zzf(CharSequence charSequence) {
        if (charSequence != null) {
            Iterator<String> zzh = zzh(charSequence);
            ArrayList arrayList = new ArrayList();
            while (zzh.hasNext()) {
                arrayList.add(zzh.next());
            }
            return Collections.unmodifiableList(arrayList);
        }
        throw null;
    }
}

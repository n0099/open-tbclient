package com.google.android.gms.internal.common;

import com.baidu.android.common.others.lang.StringUtil;
import java.io.IOException;
import java.util.Iterator;
/* loaded from: classes8.dex */
public final class zzv implements Iterable<String> {
    public final /* synthetic */ CharSequence zza;
    public final /* synthetic */ zzx zzb;

    public zzv(zzx zzxVar, CharSequence charSequence) {
        this.zzb = zzxVar;
        this.zza = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        Iterator<String> zzh;
        zzh = this.zzb.zzh(this.zza);
        return zzh;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<String> it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(zzq.zza(it.next(), StringUtil.ARRAY_ELEMENT_SEPARATOR));
                while (it.hasNext()) {
                    sb.append((CharSequence) StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(zzq.zza(it.next(), StringUtil.ARRAY_ELEMENT_SEPARATOR));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}

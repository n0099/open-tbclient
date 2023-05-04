package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;
/* loaded from: classes8.dex */
public final class zzc {
    public static final ClassLoader zza = zzc.class.getClassLoader();

    public static void zza(Parcel parcel, boolean z) {
        parcel.writeInt(1);
    }

    public static boolean zzb(Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }
}

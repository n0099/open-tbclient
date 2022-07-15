package com.repackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.zzs;
/* loaded from: classes6.dex */
public final class hl9 implements Parcelable.Creator<zzs> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hl9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzs createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        boolean z = false;
        String str = null;
        IBinder iBinder = null;
        boolean z2 = false;
        while (parcel.dataPosition() < q) {
            int k = SafeParcelReader.k(parcel);
            int h = SafeParcelReader.h(k);
            if (h == 1) {
                str = SafeParcelReader.d(parcel, k);
            } else if (h == 2) {
                iBinder = SafeParcelReader.l(parcel, k);
            } else if (h == 3) {
                z = SafeParcelReader.i(parcel, k);
            } else if (h != 4) {
                SafeParcelReader.p(parcel, k);
            } else {
                z2 = SafeParcelReader.i(parcel, k);
            }
        }
        SafeParcelReader.g(parcel, q);
        return new zzs(str, iBinder, z, z2);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzs[] newArray(int i) {
        return new zzs[i];
    }
}

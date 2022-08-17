package com.repackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes7.dex */
public final class yn9 implements Parcelable.Creator<Feature> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yn9() {
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
    public final /* bridge */ /* synthetic */ Feature createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < q) {
            int k = SafeParcelReader.k(parcel);
            int h = SafeParcelReader.h(k);
            if (h == 1) {
                str = SafeParcelReader.d(parcel, k);
            } else if (h == 2) {
                i = SafeParcelReader.m(parcel, k);
            } else if (h != 3) {
                SafeParcelReader.p(parcel, k);
            } else {
                j = SafeParcelReader.n(parcel, k);
            }
        }
        SafeParcelReader.g(parcel, q);
        return new Feature(str, i, j);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature[] newArray(int i) {
        return new Feature[i];
    }
}

package com.repackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes5.dex */
public final class ak9 implements Parcelable.Creator<Status> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ak9() {
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
    public final /* bridge */ /* synthetic */ Status createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        ConnectionResult connectionResult = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < q) {
            int k = SafeParcelReader.k(parcel);
            int h = SafeParcelReader.h(k);
            if (h == 1) {
                i2 = SafeParcelReader.m(parcel, k);
            } else if (h == 2) {
                str = SafeParcelReader.d(parcel, k);
            } else if (h == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.c(parcel, k, PendingIntent.CREATOR);
            } else if (h == 4) {
                connectionResult = (ConnectionResult) SafeParcelReader.c(parcel, k, ConnectionResult.CREATOR);
            } else if (h != 1000) {
                SafeParcelReader.p(parcel, k);
            } else {
                i = SafeParcelReader.m(parcel, k);
            }
        }
        SafeParcelReader.g(parcel, q);
        return new Status(i, i2, str, pendingIntent, connectionResult);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i) {
        return new Status[i];
    }
}

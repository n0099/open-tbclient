package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes7.dex */
public final class zzl implements Parcelable.Creator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zzl() {
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

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArr = null;
        int[] iArr2 = null;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) SafeParcelReader.createParcelable(parcel, readHeader, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 5:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    iArr2 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z, z2, iArr, i, iArr2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ConnectionTelemetryConfiguration[i];
    }
}

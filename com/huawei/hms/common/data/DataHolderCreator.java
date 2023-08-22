package com.huawei.hms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes10.dex */
public final class DataHolderCreator implements Parcelable.Creator<DataHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DataHolderCreator() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final DataHolder createFromParcel(Parcel parcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
            int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
            int i = 0;
            String[] strArr = null;
            CursorWindow[] cursorWindowArr = null;
            Bundle bundle = null;
            int i2 = 0;
            int i3 = 0;
            while (i <= validateObjectHeader && parcel.dataPosition() < validateObjectHeader) {
                i++;
                int readHeader = SafeParcelReader.readHeader(parcel);
                int fieldId = SafeParcelReader.getFieldId(readHeader);
                if (fieldId != 1000) {
                    if (fieldId != 1) {
                        if (fieldId != 2) {
                            if (fieldId != 3) {
                                if (fieldId != 4) {
                                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                                } else {
                                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                                }
                            } else {
                                i3 = SafeParcelReader.readInt(parcel, readHeader);
                            }
                        } else {
                            cursorWindowArr = (CursorWindow[]) SafeParcelReader.createTypedArray(parcel, readHeader, CursorWindow.CREATOR);
                        }
                    } else {
                        strArr = SafeParcelReader.createStringArray(parcel, readHeader);
                    }
                } else {
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                }
            }
            SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
            return new DataHolder(i2, strArr, cursorWindowArr, i3, bundle);
        }
        return (DataHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final DataHolder[] newArray(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return new DataHolder[i];
        }
        return (DataHolder[]) invokeI.objValue;
    }
}

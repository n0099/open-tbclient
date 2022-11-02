package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class ApicFrame extends Id3Frame {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<ApicFrame> CREATOR;
    public static final String ID = "APIC";
    public transient /* synthetic */ FieldHolder $fh;
    public final String description;
    public final String mimeType;
    public final byte[] pictureData;
    public final int pictureType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1995092624, "Lcom/google/android/exoplayer2/metadata/id3/ApicFrame;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1995092624, "Lcom/google/android/exoplayer2/metadata/id3/ApicFrame;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<ApicFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.ApicFrame.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ApicFrame createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new ApicFrame(parcel);
                }
                return (ApicFrame) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ApicFrame[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new ApicFrame[i];
                }
                return (ApicFrame[]) invokeI.objValue;
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApicFrame(Parcel parcel) {
        super(ID);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.pictureType = parcel.readInt();
        this.pictureData = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ApicFrame.class != obj.getClass()) {
                return false;
            }
            ApicFrame apicFrame = (ApicFrame) obj;
            if (this.pictureType == apicFrame.pictureType && Util.areEqual(this.mimeType, apicFrame.mimeType) && Util.areEqual(this.description, apicFrame.description) && Arrays.equals(this.pictureData, apicFrame.pictureData)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApicFrame(String str, String str2, int i, byte[] bArr) {
        super(ID);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i), bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mimeType = str;
        this.description = str2;
        this.pictureType = i;
        this.pictureData = bArr;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = (527 + this.pictureType) * 31;
            String str = this.mimeType;
            int i3 = 0;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            int i4 = (i2 + i) * 31;
            String str2 = this.description;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return ((i4 + i3) * 31) + Arrays.hashCode(this.pictureData);
        }
        return invokeV.intValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            parcel.writeString(this.mimeType);
            parcel.writeString(this.description);
            parcel.writeInt(this.pictureType);
            parcel.writeByteArray(this.pictureData);
        }
    }
}

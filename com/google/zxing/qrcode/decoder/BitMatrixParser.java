package com.google.zxing.qrcode.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes3.dex */
public final class BitMatrixParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitMatrix bitMatrix;
    public boolean mirror;
    public FormatInformation parsedFormatInfo;
    public Version parsedVersion;

    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int height = bitMatrix.getHeight();
        if (height >= 21 && (height & 3) == 1) {
            this.bitMatrix = bitMatrix;
            return;
        }
        throw FormatException.getFormatInstance();
    }

    private int copyBit(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65537, this, i2, i3, i4)) == null) {
            return this.mirror ? this.bitMatrix.get(i3, i2) : this.bitMatrix.get(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
        }
        return invokeIII.intValue;
    }

    public void mirror() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = 0;
            while (i2 < this.bitMatrix.getWidth()) {
                int i3 = i2 + 1;
                for (int i4 = i3; i4 < this.bitMatrix.getHeight(); i4++) {
                    if (this.bitMatrix.get(i2, i4) != this.bitMatrix.get(i4, i2)) {
                        this.bitMatrix.flip(i4, i2);
                        this.bitMatrix.flip(i2, i4);
                    }
                }
                i2 = i3;
            }
        }
    }

    public byte[] readCodewords() throws FormatException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FormatInformation readFormatInformation = readFormatInformation();
            Version readVersion = readVersion();
            DataMask dataMask = DataMask.values()[readFormatInformation.getDataMask()];
            int height = this.bitMatrix.getHeight();
            dataMask.unmaskBitMatrix(this.bitMatrix, height);
            BitMatrix buildFunctionPattern = readVersion.buildFunctionPattern();
            byte[] bArr = new byte[readVersion.getTotalCodewords()];
            int i2 = height - 1;
            boolean z = true;
            int i3 = i2;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i3 > 0) {
                if (i3 == 6) {
                    i3--;
                }
                for (int i7 = 0; i7 < height; i7++) {
                    int i8 = z ? i2 - i7 : i7;
                    for (int i9 = 0; i9 < 2; i9++) {
                        int i10 = i3 - i9;
                        if (!buildFunctionPattern.get(i10, i8)) {
                            i5++;
                            i6 <<= 1;
                            if (this.bitMatrix.get(i10, i8)) {
                                i6 |= 1;
                            }
                            if (i5 == 8) {
                                bArr[i4] = (byte) i6;
                                i4++;
                                i5 = 0;
                                i6 = 0;
                            }
                        }
                    }
                }
                z = !z;
                i3 -= 2;
            }
            if (i4 == readVersion.getTotalCodewords()) {
                return bArr;
            }
            throw FormatException.getFormatInstance();
        }
        return (byte[]) invokeV.objValue;
    }

    public FormatInformation readFormatInformation() throws FormatException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FormatInformation formatInformation = this.parsedFormatInfo;
            if (formatInformation != null) {
                return formatInformation;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 6; i4++) {
                i3 = copyBit(i4, 8, i3);
            }
            int copyBit = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, i3)));
            for (int i5 = 5; i5 >= 0; i5--) {
                copyBit = copyBit(8, i5, copyBit);
            }
            int height = this.bitMatrix.getHeight();
            int i6 = height - 7;
            for (int i7 = height - 1; i7 >= i6; i7--) {
                i2 = copyBit(8, i7, i2);
            }
            for (int i8 = height - 8; i8 < height; i8++) {
                i2 = copyBit(i8, 8, i2);
            }
            FormatInformation decodeFormatInformation = FormatInformation.decodeFormatInformation(copyBit, i2);
            this.parsedFormatInfo = decodeFormatInformation;
            if (decodeFormatInformation != null) {
                return decodeFormatInformation;
            }
            throw FormatException.getFormatInstance();
        }
        return (FormatInformation) invokeV.objValue;
    }

    public Version readVersion() throws FormatException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Version version = this.parsedVersion;
            if (version != null) {
                return version;
            }
            int height = this.bitMatrix.getHeight();
            int i2 = (height - 17) / 4;
            if (i2 <= 6) {
                return Version.getVersionForNumber(i2);
            }
            int i3 = height - 11;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 5; i6 >= 0; i6--) {
                for (int i7 = height - 9; i7 >= i3; i7--) {
                    i5 = copyBit(i7, i6, i5);
                }
            }
            Version decodeVersionInformation = Version.decodeVersionInformation(i5);
            if (decodeVersionInformation != null && decodeVersionInformation.getDimensionForVersion() == height) {
                this.parsedVersion = decodeVersionInformation;
                return decodeVersionInformation;
            }
            for (int i8 = 5; i8 >= 0; i8--) {
                for (int i9 = height - 9; i9 >= i3; i9--) {
                    i4 = copyBit(i8, i9, i4);
                }
            }
            Version decodeVersionInformation2 = Version.decodeVersionInformation(i4);
            if (decodeVersionInformation2 != null && decodeVersionInformation2.getDimensionForVersion() == height) {
                this.parsedVersion = decodeVersionInformation2;
                return decodeVersionInformation2;
            }
            throw FormatException.getFormatInstance();
        }
        return (Version) invokeV.objValue;
    }

    public void remask() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.parsedFormatInfo == null) {
            return;
        }
        DataMask.values()[this.parsedFormatInfo.getDataMask()].unmaskBitMatrix(this.bitMatrix, this.bitMatrix.getHeight());
    }

    public void setMirror(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.parsedVersion = null;
            this.parsedFormatInfo = null;
            this.mirror = z;
        }
    }
}

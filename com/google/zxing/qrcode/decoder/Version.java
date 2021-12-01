package com.google.zxing.qrcode.decoder;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes2.dex */
public final class Version {
    public static /* synthetic */ Interceptable $ic;
    public static final Version[] VERSIONS;
    public static final int[] VERSION_DECODE_INFO;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] alignmentPatternCenters;
    public final ECBlocks[] ecBlocks;
    public final int totalCodewords;
    public final int versionNumber;

    /* loaded from: classes2.dex */
    public static final class ECB {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int count;
        public final int dataCodewords;

        public ECB(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.count = i2;
            this.dataCodewords = i3;
        }

        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.count : invokeV.intValue;
        }

        public int getDataCodewords() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dataCodewords : invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ECBlocks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ECB[] ecBlocks;
        public final int ecCodewordsPerBlock;

        public ECBlocks(int i2, ECB... ecbArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), ecbArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.ecCodewordsPerBlock = i2;
            this.ecBlocks = ecbArr;
        }

        public ECB[] getECBlocks() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.ecBlocks : (ECB[]) invokeV.objValue;
        }

        public int getECCodewordsPerBlock() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.ecCodewordsPerBlock : invokeV.intValue;
        }

        public int getNumBlocks() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = 0;
                for (ECB ecb : this.ecBlocks) {
                    i2 += ecb.getCount();
                }
                return i2;
            }
            return invokeV.intValue;
        }

        public int getTotalECCodewords() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.ecCodewordsPerBlock * getNumBlocks() : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1770933784, "Lcom/google/zxing/qrcode/decoder/Version;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1770933784, "Lcom/google/zxing/qrcode/decoder/Version;");
                return;
            }
        }
        VERSION_DECODE_INFO = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
        VERSIONS = buildVersions();
    }

    public Version(int i2, int[] iArr, ECBlocks... eCBlocksArr) {
        ECB[] eCBlocks;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), iArr, eCBlocksArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.versionNumber = i2;
        this.alignmentPatternCenters = iArr;
        this.ecBlocks = eCBlocksArr;
        int eCCodewordsPerBlock = eCBlocksArr[0].getECCodewordsPerBlock();
        int i5 = 0;
        for (ECB ecb : eCBlocksArr[0].getECBlocks()) {
            i5 += ecb.getCount() * (ecb.getDataCodewords() + eCCodewordsPerBlock);
        }
        this.totalCodewords = i5;
    }

    public static Version[] buildVersions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Version[]{new Version(1, new int[0], new ECBlocks(7, new ECB(1, 19)), new ECBlocks(10, new ECB(1, 16)), new ECBlocks(13, new ECB(1, 13)), new ECBlocks(17, new ECB(1, 9))), new Version(2, new int[]{6, 18}, new ECBlocks(10, new ECB(1, 34)), new ECBlocks(16, new ECB(1, 28)), new ECBlocks(22, new ECB(1, 22)), new ECBlocks(28, new ECB(1, 16))), new Version(3, new int[]{6, 22}, new ECBlocks(15, new ECB(1, 55)), new ECBlocks(26, new ECB(1, 44)), new ECBlocks(18, new ECB(2, 17)), new ECBlocks(22, new ECB(2, 13))), new Version(4, new int[]{6, 26}, new ECBlocks(20, new ECB(1, 80)), new ECBlocks(18, new ECB(2, 32)), new ECBlocks(26, new ECB(2, 24)), new ECBlocks(16, new ECB(4, 9))), new Version(5, new int[]{6, 30}, new ECBlocks(26, new ECB(1, 108)), new ECBlocks(24, new ECB(2, 43)), new ECBlocks(18, new ECB(2, 15), new ECB(2, 16)), new ECBlocks(22, new ECB(2, 11), new ECB(2, 12))), new Version(6, new int[]{6, 34}, new ECBlocks(18, new ECB(2, 68)), new ECBlocks(16, new ECB(4, 27)), new ECBlocks(24, new ECB(4, 19)), new ECBlocks(28, new ECB(4, 15))), new Version(7, new int[]{6, 22, 38}, new ECBlocks(20, new ECB(2, 78)), new ECBlocks(18, new ECB(4, 31)), new ECBlocks(18, new ECB(2, 14), new ECB(4, 15)), new ECBlocks(26, new ECB(4, 13), new ECB(1, 14))), new Version(8, new int[]{6, 24, 42}, new ECBlocks(24, new ECB(2, 97)), new ECBlocks(22, new ECB(2, 38), new ECB(2, 39)), new ECBlocks(22, new ECB(4, 18), new ECB(2, 19)), new ECBlocks(26, new ECB(4, 14), new ECB(2, 15))), new Version(9, new int[]{6, 26, 46}, new ECBlocks(30, new ECB(2, 116)), new ECBlocks(22, new ECB(3, 36), new ECB(2, 37)), new ECBlocks(20, new ECB(4, 16), new ECB(4, 17)), new ECBlocks(24, new ECB(4, 12), new ECB(4, 13))), new Version(10, new int[]{6, 28, 50}, new ECBlocks(18, new ECB(2, 68), new ECB(2, 69)), new ECBlocks(26, new ECB(4, 43), new ECB(1, 44)), new ECBlocks(24, new ECB(6, 19), new ECB(2, 20)), new ECBlocks(28, new ECB(6, 15), new ECB(2, 16))), new Version(11, new int[]{6, 30, 54}, new ECBlocks(20, new ECB(4, 81)), new ECBlocks(30, new ECB(1, 50), new ECB(4, 51)), new ECBlocks(28, new ECB(4, 22), new ECB(4, 23)), new ECBlocks(24, new ECB(3, 12), new ECB(8, 13))), new Version(12, new int[]{6, 32, 58}, new ECBlocks(24, new ECB(2, 92), new ECB(2, 93)), new ECBlocks(22, new ECB(6, 36), new ECB(2, 37)), new ECBlocks(26, new ECB(4, 20), new ECB(6, 21)), new ECBlocks(28, new ECB(7, 14), new ECB(4, 15))), new Version(13, new int[]{6, 34, 62}, new ECBlocks(26, new ECB(4, 107)), new ECBlocks(22, new ECB(8, 37), new ECB(1, 38)), new ECBlocks(24, new ECB(8, 20), new ECB(4, 21)), new ECBlocks(22, new ECB(12, 11), new ECB(4, 12))), new Version(14, new int[]{6, 26, 46, 66}, new ECBlocks(30, new ECB(3, 115), new ECB(1, 116)), new ECBlocks(24, new ECB(4, 40), new ECB(5, 41)), new ECBlocks(20, new ECB(11, 16), new ECB(5, 17)), new ECBlocks(24, new ECB(11, 12), new ECB(5, 13))), new Version(15, new int[]{6, 26, 48, 70}, new ECBlocks(22, new ECB(5, 87), new ECB(1, 88)), new ECBlocks(24, new ECB(5, 41), new ECB(5, 42)), new ECBlocks(30, new ECB(5, 24), new ECB(7, 25)), new ECBlocks(24, new ECB(11, 12), new ECB(7, 13))), new Version(16, new int[]{6, 26, 50, 74}, new ECBlocks(24, new ECB(5, 98), new ECB(1, 99)), new ECBlocks(28, new ECB(7, 45), new ECB(3, 46)), new ECBlocks(24, new ECB(15, 19), new ECB(2, 20)), new ECBlocks(30, new ECB(3, 15), new ECB(13, 16))), new Version(17, new int[]{6, 30, 54, 78}, new ECBlocks(28, new ECB(1, 107), new ECB(5, 108)), new ECBlocks(28, new ECB(10, 46), new ECB(1, 47)), new ECBlocks(28, new ECB(1, 22), new ECB(15, 23)), new ECBlocks(28, new ECB(2, 14), new ECB(17, 15))), new Version(18, new int[]{6, 30, 56, 82}, new ECBlocks(30, new ECB(5, 120), new ECB(1, 121)), new ECBlocks(26, new ECB(9, 43), new ECB(4, 44)), new ECBlocks(28, new ECB(17, 22), new ECB(1, 23)), new ECBlocks(28, new ECB(2, 14), new ECB(19, 15))), new Version(19, new int[]{6, 30, 58, 86}, new ECBlocks(28, new ECB(3, 113), new ECB(4, 114)), new ECBlocks(26, new ECB(3, 44), new ECB(11, 45)), new ECBlocks(26, new ECB(17, 21), new ECB(4, 22)), new ECBlocks(26, new ECB(9, 13), new ECB(16, 14))), new Version(20, new int[]{6, 34, 62, 90}, new ECBlocks(28, new ECB(3, 107), new ECB(5, 108)), new ECBlocks(26, new ECB(3, 41), new ECB(13, 42)), new ECBlocks(30, new ECB(15, 24), new ECB(5, 25)), new ECBlocks(28, new ECB(15, 15), new ECB(10, 16))), new Version(21, new int[]{6, 28, 50, 72, 94}, new ECBlocks(28, new ECB(4, 116), new ECB(4, 117)), new ECBlocks(26, new ECB(17, 42)), new ECBlocks(28, new ECB(17, 22), new ECB(6, 23)), new ECBlocks(30, new ECB(19, 16), new ECB(6, 17))), new Version(22, new int[]{6, 26, 50, 74, 98}, new ECBlocks(28, new ECB(2, 111), new ECB(7, 112)), new ECBlocks(28, new ECB(17, 46)), new ECBlocks(30, new ECB(7, 24), new ECB(16, 25)), new ECBlocks(24, new ECB(34, 13))), new Version(23, new int[]{6, 30, 54, 78, 102}, new ECBlocks(30, new ECB(4, 121), new ECB(5, 122)), new ECBlocks(28, new ECB(4, 47), new ECB(14, 48)), new ECBlocks(30, new ECB(11, 24), new ECB(14, 25)), new ECBlocks(30, new ECB(16, 15), new ECB(14, 16))), new Version(24, new int[]{6, 28, 54, 80, 106}, new ECBlocks(30, new ECB(6, 117), new ECB(4, 118)), new ECBlocks(28, new ECB(6, 45), new ECB(14, 46)), new ECBlocks(30, new ECB(11, 24), new ECB(16, 25)), new ECBlocks(30, new ECB(30, 16), new ECB(2, 17))), new Version(25, new int[]{6, 32, 58, 84, 110}, new ECBlocks(26, new ECB(8, 106), new ECB(4, 107)), new ECBlocks(28, new ECB(8, 47), new ECB(13, 48)), new ECBlocks(30, new ECB(7, 24), new ECB(22, 25)), new ECBlocks(30, new ECB(22, 15), new ECB(13, 16))), new Version(26, new int[]{6, 30, 58, 86, 114}, new ECBlocks(28, new ECB(10, 114), new ECB(2, 115)), new ECBlocks(28, new ECB(19, 46), new ECB(4, 47)), new ECBlocks(28, new ECB(28, 22), new ECB(6, 23)), new ECBlocks(30, new ECB(33, 16), new ECB(4, 17))), new Version(27, new int[]{6, 34, 62, 90, 118}, new ECBlocks(30, new ECB(8, 122), new ECB(4, 123)), new ECBlocks(28, new ECB(22, 45), new ECB(3, 46)), new ECBlocks(30, new ECB(8, 23), new ECB(26, 24)), new ECBlocks(30, new ECB(12, 15), new ECB(28, 16))), new Version(28, new int[]{6, 26, 50, 74, 98, 122}, new ECBlocks(30, new ECB(3, 117), new ECB(10, 118)), new ECBlocks(28, new ECB(3, 45), new ECB(23, 46)), new ECBlocks(30, new ECB(4, 24), new ECB(31, 25)), new ECBlocks(30, new ECB(11, 15), new ECB(31, 16))), new Version(29, new int[]{6, 30, 54, 78, 102, 126}, new ECBlocks(30, new ECB(7, 116), new ECB(7, 117)), new ECBlocks(28, new ECB(21, 45), new ECB(7, 46)), new ECBlocks(30, new ECB(1, 23), new ECB(37, 24)), new ECBlocks(30, new ECB(19, 15), new ECB(26, 16))), new Version(30, new int[]{6, 26, 52, 78, 104, 130}, new ECBlocks(30, new ECB(5, 115), new ECB(10, 116)), new ECBlocks(28, new ECB(19, 47), new ECB(10, 48)), new ECBlocks(30, new ECB(15, 24), new ECB(25, 25)), new ECBlocks(30, new ECB(23, 15), new ECB(25, 16))), new Version(31, new int[]{6, 30, 56, 82, 108, 134}, new ECBlocks(30, new ECB(13, 115), new ECB(3, 116)), new ECBlocks(28, new ECB(2, 46), new ECB(29, 47)), new ECBlocks(30, new ECB(42, 24), new ECB(1, 25)), new ECBlocks(30, new ECB(23, 15), new ECB(28, 16))), new Version(32, new int[]{6, 34, 60, 86, 112, 138}, new ECBlocks(30, new ECB(17, 115)), new ECBlocks(28, new ECB(10, 46), new ECB(23, 47)), new ECBlocks(30, new ECB(10, 24), new ECB(35, 25)), new ECBlocks(30, new ECB(19, 15), new ECB(35, 16))), new Version(33, new int[]{6, 30, 58, 86, 114, 142}, new ECBlocks(30, new ECB(17, 115), new ECB(1, 116)), new ECBlocks(28, new ECB(14, 46), new ECB(21, 47)), new ECBlocks(30, new ECB(29, 24), new ECB(19, 25)), new ECBlocks(30, new ECB(11, 15), new ECB(46, 16))), new Version(34, new int[]{6, 34, 62, 90, 118, 146}, new ECBlocks(30, new ECB(13, 115), new ECB(6, 116)), new ECBlocks(28, new ECB(14, 46), new ECB(23, 47)), new ECBlocks(30, new ECB(44, 24), new ECB(7, 25)), new ECBlocks(30, new ECB(59, 16), new ECB(1, 17))), new Version(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new ECBlocks(30, new ECB(12, 121), new ECB(7, 122)), new ECBlocks(28, new ECB(12, 47), new ECB(26, 48)), new ECBlocks(30, new ECB(39, 24), new ECB(14, 25)), new ECBlocks(30, new ECB(22, 15), new ECB(41, 16))), new Version(36, new int[]{6, 24, 50, 76, 102, 128, Opcodes.IFNE}, new ECBlocks(30, new ECB(6, 121), new ECB(14, 122)), new ECBlocks(28, new ECB(6, 47), new ECB(34, 48)), new ECBlocks(30, new ECB(46, 24), new ECB(10, 25)), new ECBlocks(30, new ECB(2, 15), new ECB(64, 16))), new Version(37, new int[]{6, 28, 54, 80, 106, 132, 158}, new ECBlocks(30, new ECB(17, 122), new ECB(4, 123)), new ECBlocks(28, new ECB(29, 46), new ECB(14, 47)), new ECBlocks(30, new ECB(49, 24), new ECB(10, 25)), new ECBlocks(30, new ECB(24, 15), new ECB(46, 16))), new Version(38, new int[]{6, 32, 58, 84, 110, 136, 162}, new ECBlocks(30, new ECB(4, 122), new ECB(18, 123)), new ECBlocks(28, new ECB(13, 46), new ECB(32, 47)), new ECBlocks(30, new ECB(48, 24), new ECB(14, 25)), new ECBlocks(30, new ECB(42, 15), new ECB(32, 16))), new Version(39, new int[]{6, 26, 54, 82, 110, 138, 166}, new ECBlocks(30, new ECB(20, 117), new ECB(4, 118)), new ECBlocks(28, new ECB(40, 47), new ECB(7, 48)), new ECBlocks(30, new ECB(43, 24), new ECB(22, 25)), new ECBlocks(30, new ECB(10, 15), new ECB(67, 16))), new Version(40, new int[]{6, 30, 58, 86, 114, 142, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID}, new ECBlocks(30, new ECB(19, 118), new ECB(6, 119)), new ECBlocks(28, new ECB(18, 47), new ECB(31, 48)), new ECBlocks(30, new ECB(34, 24), new ECB(34, 25)), new ECBlocks(30, new ECB(20, 15), new ECB(61, 16)))} : (Version[]) invokeV.objValue;
    }

    public static Version decodeVersionInformation(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65539, null, i2)) != null) {
            return (Version) invokeI.objValue;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        while (true) {
            int[] iArr = VERSION_DECODE_INFO;
            if (i3 >= iArr.length) {
                if (i5 <= 3) {
                    return getVersionForNumber(i4);
                }
                return null;
            }
            int i6 = iArr[i3];
            if (i6 == i2) {
                return getVersionForNumber(i3 + 7);
            }
            int numBitsDiffering = FormatInformation.numBitsDiffering(i2, i6);
            if (numBitsDiffering < i5) {
                i4 = i3 + 7;
                i5 = numBitsDiffering;
            }
            i3++;
        }
    }

    public static Version getProvisionalVersionForDimension(int i2) throws FormatException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (i2 % 4 == 1) {
                try {
                    return getVersionForNumber((i2 - 17) / 4);
                } catch (IllegalArgumentException unused) {
                    throw FormatException.getFormatInstance();
                }
            }
            throw FormatException.getFormatInstance();
        }
        return (Version) invokeI.objValue;
    }

    public static Version getVersionForNumber(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) {
            if (i2 > 0 && i2 <= 40) {
                return VERSIONS[i2 - 1];
            }
            throw new IllegalArgumentException();
        }
        return (Version) invokeI.objValue;
    }

    public BitMatrix buildFunctionPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int dimensionForVersion = getDimensionForVersion();
            BitMatrix bitMatrix = new BitMatrix(dimensionForVersion);
            bitMatrix.setRegion(0, 0, 9, 9);
            int i2 = dimensionForVersion - 8;
            bitMatrix.setRegion(i2, 0, 8, 9);
            bitMatrix.setRegion(0, i2, 9, 8);
            int length = this.alignmentPatternCenters.length;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = this.alignmentPatternCenters[i3] - 2;
                for (int i5 = 0; i5 < length; i5++) {
                    if ((i3 != 0 || (i5 != 0 && i5 != length - 1)) && (i3 != length - 1 || i5 != 0)) {
                        bitMatrix.setRegion(this.alignmentPatternCenters[i5] - 2, i4, 5, 5);
                    }
                }
            }
            int i6 = dimensionForVersion - 17;
            bitMatrix.setRegion(6, 9, 1, i6);
            bitMatrix.setRegion(9, 6, i6, 1);
            if (this.versionNumber > 6) {
                int i7 = dimensionForVersion - 11;
                bitMatrix.setRegion(i7, 0, 3, 6);
                bitMatrix.setRegion(0, i7, 6, 3);
            }
            return bitMatrix;
        }
        return (BitMatrix) invokeV.objValue;
    }

    public int[] getAlignmentPatternCenters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.alignmentPatternCenters : (int[]) invokeV.objValue;
    }

    public int getDimensionForVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.versionNumber * 4) + 17 : invokeV.intValue;
    }

    public ECBlocks getECBlocksForLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, errorCorrectionLevel)) == null) ? this.ecBlocks[errorCorrectionLevel.ordinal()] : (ECBlocks) invokeL.objValue;
    }

    public int getTotalCodewords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.totalCodewords : invokeV.intValue;
    }

    public int getVersionNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.versionNumber : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? String.valueOf(this.versionNumber) : (String) invokeV.objValue;
    }
}

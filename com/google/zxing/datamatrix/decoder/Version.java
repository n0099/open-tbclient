package com.google.zxing.datamatrix.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.zxing.FormatException;
/* loaded from: classes5.dex */
public final class Version {
    public static /* synthetic */ Interceptable $ic;
    public static final Version[] VERSIONS;
    public transient /* synthetic */ FieldHolder $fh;
    public final int dataRegionSizeColumns;
    public final int dataRegionSizeRows;
    public final ECBlocks ecBlocks;
    public final int symbolSizeColumns;
    public final int symbolSizeRows;
    public final int totalCodewords;
    public final int versionNumber;

    /* renamed from: com.google.zxing.datamatrix.decoder.Version$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class ECB {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int count;
        public final int dataCodewords;

        public /* synthetic */ ECB(int i, int i2, AnonymousClass1 anonymousClass1) {
            this(i, i2);
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

        public ECB(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.count = i;
            this.dataCodewords = i2;
        }
    }

    /* loaded from: classes5.dex */
    public static final class ECBlocks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ECB[] ecBlocks;
        public final int ecCodewords;

        public /* synthetic */ ECBlocks(int i, ECB ecb, AnonymousClass1 anonymousClass1) {
            this(i, ecb);
        }

        public ECB[] getECBlocks() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.ecBlocks : (ECB[]) invokeV.objValue;
        }

        public int getECCodewords() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.ecCodewords : invokeV.intValue;
        }

        public /* synthetic */ ECBlocks(int i, ECB ecb, ECB ecb2, AnonymousClass1 anonymousClass1) {
            this(i, ecb, ecb2);
        }

        public ECBlocks(int i, ECB ecb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), ecb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.ecCodewords = i;
            this.ecBlocks = new ECB[]{ecb};
        }

        public ECBlocks(int i, ECB ecb, ECB ecb2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), ecb, ecb2};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.ecCodewords = i;
            this.ecBlocks = new ECB[]{ecb, ecb2};
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(656410283, "Lcom/google/zxing/datamatrix/decoder/Version;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(656410283, "Lcom/google/zxing/datamatrix/decoder/Version;");
                return;
            }
        }
        VERSIONS = buildVersions();
    }

    public Version(int i, int i2, int i3, int i4, int i5, ECBlocks eCBlocks) {
        ECB[] eCBlocks2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), eCBlocks};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.versionNumber = i;
        this.symbolSizeRows = i2;
        this.symbolSizeColumns = i3;
        this.dataRegionSizeRows = i4;
        this.dataRegionSizeColumns = i5;
        this.ecBlocks = eCBlocks;
        int eCCodewords = eCBlocks.getECCodewords();
        int i8 = 0;
        for (ECB ecb : eCBlocks.getECBlocks()) {
            i8 += ecb.getCount() * (ecb.getDataCodewords() + eCCodewords);
        }
        this.totalCodewords = i8;
    }

    public static Version[] buildVersions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Version[]{new Version(1, 10, 10, 8, 8, new ECBlocks(5, new ECB(1, 3, null), (AnonymousClass1) null)), new Version(2, 12, 12, 10, 10, new ECBlocks(7, new ECB(1, 5, null), (AnonymousClass1) null)), new Version(3, 14, 14, 12, 12, new ECBlocks(10, new ECB(1, 8, null), (AnonymousClass1) null)), new Version(4, 16, 16, 14, 14, new ECBlocks(12, new ECB(1, 12, null), (AnonymousClass1) null)), new Version(5, 18, 18, 16, 16, new ECBlocks(14, new ECB(1, 18, null), (AnonymousClass1) null)), new Version(6, 20, 20, 18, 18, new ECBlocks(18, new ECB(1, 22, null), (AnonymousClass1) null)), new Version(7, 22, 22, 20, 20, new ECBlocks(20, new ECB(1, 30, null), (AnonymousClass1) null)), new Version(8, 24, 24, 22, 22, new ECBlocks(24, new ECB(1, 36, null), (AnonymousClass1) null)), new Version(9, 26, 26, 24, 24, new ECBlocks(28, new ECB(1, 44, null), (AnonymousClass1) null)), new Version(10, 32, 32, 14, 14, new ECBlocks(36, new ECB(1, 62, null), (AnonymousClass1) null)), new Version(11, 36, 36, 16, 16, new ECBlocks(42, new ECB(1, 86, null), (AnonymousClass1) null)), new Version(12, 40, 40, 18, 18, new ECBlocks(48, new ECB(1, 114, null), (AnonymousClass1) null)), new Version(13, 44, 44, 20, 20, new ECBlocks(56, new ECB(1, Cea708Decoder.COMMAND_SPA, null), (AnonymousClass1) null)), new Version(14, 48, 48, 22, 22, new ECBlocks(68, new ECB(1, MatroskaExtractor.ID_TRACK_ENTRY, null), (AnonymousClass1) null)), new Version(15, 52, 52, 24, 24, new ECBlocks(42, new ECB(2, 102, null), (AnonymousClass1) null)), new Version(16, 64, 64, 14, 14, new ECBlocks(56, new ECB(2, Cea708Decoder.COMMAND_DLW, null), (AnonymousClass1) null)), new Version(17, 72, 72, 16, 16, new ECBlocks(36, new ECB(4, 92, null), (AnonymousClass1) null)), new Version(18, 80, 80, 18, 18, new ECBlocks(48, new ECB(4, 114, null), (AnonymousClass1) null)), new Version(19, 88, 88, 20, 20, new ECBlocks(56, new ECB(4, Cea708Decoder.COMMAND_SPA, null), (AnonymousClass1) null)), new Version(20, 96, 96, 22, 22, new ECBlocks(68, new ECB(4, MatroskaExtractor.ID_TRACK_ENTRY, null), (AnonymousClass1) null)), new Version(21, 104, 104, 24, 24, new ECBlocks(56, new ECB(6, 136, null), (AnonymousClass1) null)), new Version(22, 120, 120, 18, 18, new ECBlocks(68, new ECB(6, 175, null), (AnonymousClass1) null)), new Version(23, 132, 132, 20, 20, new ECBlocks(62, new ECB(8, MatroskaExtractor.ID_SIMPLE_BLOCK, null), (AnonymousClass1) null)), new Version(24, Cea708Decoder.COMMAND_SPA, Cea708Decoder.COMMAND_SPA, 22, 22, new ECBlocks(62, new ECB(8, Cea708Decoder.COMMAND_DS4, null), new ECB(2, 155, null), null)), new Version(25, 8, 18, 6, 16, new ECBlocks(7, new ECB(1, 5, null), (AnonymousClass1) null)), new Version(26, 8, 32, 6, 14, new ECBlocks(11, new ECB(1, 10, null), (AnonymousClass1) null)), new Version(27, 12, 26, 10, 24, new ECBlocks(14, new ECB(1, 16, null), (AnonymousClass1) null)), new Version(28, 12, 36, 10, 16, new ECBlocks(18, new ECB(1, 22, null), (AnonymousClass1) null)), new Version(29, 16, 36, 14, 16, new ECBlocks(24, new ECB(1, 32, null), (AnonymousClass1) null)), new Version(30, 16, 48, 14, 22, new ECBlocks(28, new ECB(1, 49, null), (AnonymousClass1) null))} : (Version[]) invokeV.objValue;
    }

    public static Version getVersionForDimensions(int i, int i2) throws FormatException {
        InterceptResult invokeII;
        Version[] versionArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
            if ((i & 1) == 0 && (i2 & 1) == 0) {
                for (Version version : VERSIONS) {
                    if (version.symbolSizeRows == i && version.symbolSizeColumns == i2) {
                        return version;
                    }
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        }
        return (Version) invokeII.objValue;
    }

    public int getDataRegionSizeColumns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.dataRegionSizeColumns : invokeV.intValue;
    }

    public int getDataRegionSizeRows() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dataRegionSizeRows : invokeV.intValue;
    }

    public ECBlocks getECBlocks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ecBlocks : (ECBlocks) invokeV.objValue;
    }

    public int getSymbolSizeColumns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.symbolSizeColumns : invokeV.intValue;
    }

    public int getSymbolSizeRows() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.symbolSizeRows : invokeV.intValue;
    }

    public int getTotalCodewords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.totalCodewords : invokeV.intValue;
    }

    public int getVersionNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.versionNumber : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? String.valueOf(this.versionNumber) : (String) invokeV.objValue;
    }
}

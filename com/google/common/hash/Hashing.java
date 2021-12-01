package com.google.common.hash;

import androidx.core.view.InputDeviceCompat;
import c.i.d.d.e;
import c.i.d.d.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
/* loaded from: classes2.dex */
public final class Hashing {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static abstract class ChecksumType implements g<Checksum> {
        public static final /* synthetic */ ChecksumType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ChecksumType ADLER_32;
        public static final ChecksumType CRC_32;
        public transient /* synthetic */ FieldHolder $fh;
        public final e hashFunction;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1326073365, "Lcom/google/common/hash/Hashing$ChecksumType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1326073365, "Lcom/google/common/hash/Hashing$ChecksumType;");
                    return;
                }
            }
            CRC_32 = new ChecksumType("CRC_32", 0, "Hashing.crc32()") { // from class: com.google.common.hash.Hashing.ChecksumType.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r10, r11, r12, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r10, Integer.valueOf(r11), r12};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (a) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.hash.Hashing.ChecksumType, c.i.d.a.r
                public Checksum get() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new CRC32() : (Checksum) invokeV.objValue;
                }
            };
            ChecksumType checksumType = new ChecksumType("ADLER_32", 1, "Hashing.adler32()") { // from class: com.google.common.hash.Hashing.ChecksumType.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r10, r11, r12, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r10, Integer.valueOf(r11), r12};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (a) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.hash.Hashing.ChecksumType, c.i.d.a.r
                public Checksum get() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new Adler32() : (Checksum) invokeV.objValue;
                }
            };
            ADLER_32 = checksumType;
            $VALUES = new ChecksumType[]{CRC_32, checksumType};
        }

        public /* synthetic */ ChecksumType(String str, int i2, String str2, a aVar) {
            this(str, i2, str2);
        }

        public static ChecksumType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ChecksumType) Enum.valueOf(ChecksumType.class, str) : (ChecksumType) invokeL.objValue;
        }

        public static ChecksumType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ChecksumType[]) $VALUES.clone() : (ChecksumType[]) invokeV.objValue;
        }

        @Override // c.i.d.a.r
        public abstract /* synthetic */ T get();

        public ChecksumType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.hashFunction = new ChecksumHashFunction(this, 32, str2);
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1051282880, "Lcom/google/common/hash/Hashing;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1051282880, "Lcom/google/common/hash/Hashing;");
                return;
            }
        }
        a = (int) System.currentTimeMillis();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Murmur3_128HashFunction.MURMUR3_128 : (e) invokeV.objValue;
    }
}

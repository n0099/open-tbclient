package com.ta.utdid2.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.ta.utdid2.a.a.f$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] d;
        public int x;
        public int y;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = new int[256];
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str == null) {
                return null;
            }
            a aVar = new a(null);
            for (int i = 0; i < 256; i++) {
                aVar.d[i] = i;
            }
            aVar.x = 0;
            aVar.y = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                try {
                    i3 = ((str.charAt(i2) + aVar.d[i4]) + i3) % 256;
                    int i5 = aVar.d[i4];
                    aVar.d[i4] = aVar.d[i3];
                    aVar.d[i3] = i5;
                    i2 = (i2 + 1) % str.length();
                } catch (Exception unused) {
                    return null;
                }
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr != null && (a2 = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) != null) {
                return a(bArr, a2);
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, aVar)) == null) {
            if (bArr != null && aVar != null) {
                int i = aVar.x;
                int i2 = aVar.y;
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    i = (i + 1) % 256;
                    int[] iArr = aVar.d;
                    i2 = (iArr[i] + i2) % 256;
                    int i4 = iArr[i];
                    iArr[i] = iArr[i2];
                    iArr[i2] = i4;
                    bArr[i3] = (byte) (iArr[(iArr[i] + iArr[i2]) % 256] ^ bArr[i3]);
                }
                aVar.x = i;
                aVar.y = i2;
                return bArr;
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }
}

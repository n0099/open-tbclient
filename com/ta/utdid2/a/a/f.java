package com.ta.utdid2.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.ta.utdid2.a.a.f$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null || (a2 = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
                return null;
            }
            return a(bArr, a2);
        }
        return (byte[]) invokeL.objValue;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public int[] f76363d;
        public int x;
        public int y;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76363d = new int[256];
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str != null) {
                a aVar = new a(null);
                for (int i2 = 0; i2 < 256; i2++) {
                    aVar.f76363d[i2] = i2;
                }
                aVar.x = 0;
                aVar.y = 0;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < 256; i5++) {
                    try {
                        i4 = ((str.charAt(i3) + aVar.f76363d[i5]) + i4) % 256;
                        int i6 = aVar.f76363d[i5];
                        aVar.f76363d[i5] = aVar.f76363d[i4];
                        aVar.f76363d[i4] = i6;
                        i3 = (i3 + 1) % str.length();
                    } catch (Exception unused) {
                        return null;
                    }
                }
                return aVar;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, aVar)) == null) {
            if (bArr == null || aVar == null) {
                return null;
            }
            int i2 = aVar.x;
            int i3 = aVar.y;
            for (int i4 = 0; i4 < bArr.length; i4++) {
                i2 = (i2 + 1) % 256;
                int[] iArr = aVar.f76363d;
                i3 = (iArr[i2] + i3) % 256;
                int i5 = iArr[i2];
                iArr[i2] = iArr[i3];
                iArr[i3] = i5;
                bArr[i4] = (byte) (iArr[(iArr[i2] + iArr[i3]) % 256] ^ bArr[i4]);
            }
            aVar.x = i2;
            aVar.y = i3;
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }
}

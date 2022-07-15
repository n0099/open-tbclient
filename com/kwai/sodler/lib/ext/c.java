package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public String l;
    public byte[] m;
    public boolean n;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public boolean i;
        public boolean j;
        public String k;
        public byte[] l;
        public boolean m;
        public boolean n;

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
            this.a = 3;
            this.c = "sodler";
            this.d = "code-cache";
            this.e = "lib";
            this.f = SevenZipUtils.FILE_NAME_TEMP;
            this.g = "base-1.apk";
            this.h = ".tmp";
            this.i = false;
            this.j = false;
        }

        public final a a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (i > 0) {
                    this.a = i;
                }
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.m = false;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new c(this.j, this.i, this.b, this.c, this.d, this.e, this.f, this.h, this.g, this.a, this.k, this.l, this.m, this.n, (byte) 0) : (c) invokeV.objValue;
        }

        public final a b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.n = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i), str8, bArr, Boolean.valueOf(z3), Boolean.valueOf(z4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str;
        this.i = z;
        this.j = z2;
        this.l = str8;
        this.m = bArr;
        this.n = z3;
        this.k = z4;
    }

    public /* synthetic */ c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, byte b) {
        this(z, z2, str, str2, str3, str4, str5, str6, str7, i, str8, bArr, z3, z4);
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.booleanValue;
    }
}

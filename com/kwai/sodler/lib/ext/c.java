package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes10.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f74216a;

    /* renamed from: b  reason: collision with root package name */
    public final String f74217b;

    /* renamed from: c  reason: collision with root package name */
    public final String f74218c;

    /* renamed from: d  reason: collision with root package name */
    public final String f74219d;

    /* renamed from: e  reason: collision with root package name */
    public final String f74220e;

    /* renamed from: f  reason: collision with root package name */
    public final String f74221f;

    /* renamed from: g  reason: collision with root package name */
    public final String f74222g;

    /* renamed from: h  reason: collision with root package name */
    public final String f74223h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f74224i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f74225j;
    public String k;
    public byte[] l;
    public boolean m;

    /* renamed from: com.kwai.sodler.lib.ext.c$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f74226a;

        /* renamed from: b  reason: collision with root package name */
        public String f74227b;

        /* renamed from: c  reason: collision with root package name */
        public String f74228c;

        /* renamed from: d  reason: collision with root package name */
        public String f74229d;

        /* renamed from: e  reason: collision with root package name */
        public String f74230e;

        /* renamed from: f  reason: collision with root package name */
        public String f74231f;

        /* renamed from: g  reason: collision with root package name */
        public String f74232g;

        /* renamed from: h  reason: collision with root package name */
        public String f74233h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f74234i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f74235j;
        public String k;
        public byte[] l;
        public boolean m;

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
            this.f74226a = 3;
            this.f74228c = "sodler";
            this.f74229d = "code-cache";
            this.f74230e = "lib";
            this.f74231f = SevenZipUtils.FILE_NAME_TEMP;
            this.f74232g = "base-1.apk";
            this.f74233h = ".tmp";
            this.f74234i = false;
            this.f74235j = false;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 > 0) {
                    this.f74226a = i2;
                }
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f74228c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.m = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new c(this.f74235j, this.f74234i, this.f74227b, this.f74228c, this.f74229d, this.f74230e, this.f74231f, this.f74233h, this.f74232g, this.f74226a, this.k, this.l, this.m, null) : (c) invokeV.objValue;
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, byte[] bArr, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i2), str8, bArr, Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74216a = i2;
        this.f74217b = str2;
        this.f74218c = str3;
        this.f74219d = str4;
        this.f74220e = str5;
        this.f74221f = str6;
        this.f74222g = str7;
        this.f74223h = str;
        this.f74224i = z;
        this.f74225j = z2;
        this.k = str8;
        this.l = bArr;
        this.m = z3;
    }

    public /* synthetic */ c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, byte[] bArr, boolean z3, AnonymousClass1 anonymousClass1) {
        this(z, z2, str, str2, str3, str4, str5, str6, str7, i2, str8, bArr, z3);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f74216a : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f74217b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f74219d : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f74220e : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f74221f : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f74222g : (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f74225j : invokeV.booleanValue;
    }
}

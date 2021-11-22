package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes2.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f68037a;

    /* renamed from: b  reason: collision with root package name */
    public final String f68038b;

    /* renamed from: c  reason: collision with root package name */
    public final String f68039c;

    /* renamed from: d  reason: collision with root package name */
    public final String f68040d;

    /* renamed from: e  reason: collision with root package name */
    public final String f68041e;

    /* renamed from: f  reason: collision with root package name */
    public final String f68042f;

    /* renamed from: g  reason: collision with root package name */
    public final String f68043g;

    /* renamed from: h  reason: collision with root package name */
    public final String f68044h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f68045i;
    public final boolean j;
    public String k;
    public byte[] l;
    public boolean m;

    /* renamed from: com.kwai.sodler.lib.ext.c$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f68046a;

        /* renamed from: b  reason: collision with root package name */
        public String f68047b;

        /* renamed from: c  reason: collision with root package name */
        public String f68048c;

        /* renamed from: d  reason: collision with root package name */
        public String f68049d;

        /* renamed from: e  reason: collision with root package name */
        public String f68050e;

        /* renamed from: f  reason: collision with root package name */
        public String f68051f;

        /* renamed from: g  reason: collision with root package name */
        public String f68052g;

        /* renamed from: h  reason: collision with root package name */
        public String f68053h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f68054i;
        public boolean j;
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
            this.f68046a = 3;
            this.f68048c = "sodler";
            this.f68049d = "code-cache";
            this.f68050e = "lib";
            this.f68051f = SevenZipUtils.FILE_NAME_TEMP;
            this.f68052g = "base-1.apk";
            this.f68053h = ".tmp";
            this.f68054i = false;
            this.j = false;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 > 0) {
                    this.f68046a = i2;
                }
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f68048c = str;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new c(this.j, this.f68054i, this.f68047b, this.f68048c, this.f68049d, this.f68050e, this.f68051f, this.f68053h, this.f68052g, this.f68046a, this.k, this.l, this.m, null) : (c) invokeV.objValue;
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
        this.f68037a = i2;
        this.f68038b = str2;
        this.f68039c = str3;
        this.f68040d = str4;
        this.f68041e = str5;
        this.f68042f = str6;
        this.f68043g = str7;
        this.f68044h = str;
        this.f68045i = z;
        this.j = z2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68037a : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68038b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68040d : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68041e : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68042f : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f68043g : (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.booleanValue;
    }
}

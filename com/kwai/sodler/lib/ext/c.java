package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f36996a;

    /* renamed from: b  reason: collision with root package name */
    public final String f36997b;

    /* renamed from: c  reason: collision with root package name */
    public final String f36998c;

    /* renamed from: d  reason: collision with root package name */
    public final String f36999d;

    /* renamed from: e  reason: collision with root package name */
    public final String f37000e;

    /* renamed from: f  reason: collision with root package name */
    public final String f37001f;

    /* renamed from: g  reason: collision with root package name */
    public final String f37002g;

    /* renamed from: h  reason: collision with root package name */
    public final String f37003h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f37004i;
    public final boolean j;
    public String k;
    public byte[] l;
    public boolean m;

    /* renamed from: com.kwai.sodler.lib.ext.c$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f37005a;

        /* renamed from: b  reason: collision with root package name */
        public String f37006b;

        /* renamed from: c  reason: collision with root package name */
        public String f37007c;

        /* renamed from: d  reason: collision with root package name */
        public String f37008d;

        /* renamed from: e  reason: collision with root package name */
        public String f37009e;

        /* renamed from: f  reason: collision with root package name */
        public String f37010f;

        /* renamed from: g  reason: collision with root package name */
        public String f37011g;

        /* renamed from: h  reason: collision with root package name */
        public String f37012h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f37013i;
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
            this.f37005a = 3;
            this.f37007c = "sodler";
            this.f37008d = "code-cache";
            this.f37009e = "lib";
            this.f37010f = SevenZipUtils.FILE_NAME_TEMP;
            this.f37011g = "base-1.apk";
            this.f37012h = ".tmp";
            this.f37013i = false;
            this.j = false;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 > 0) {
                    this.f37005a = i2;
                }
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f37007c = str;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new c(this.j, this.f37013i, this.f37006b, this.f37007c, this.f37008d, this.f37009e, this.f37010f, this.f37012h, this.f37011g, this.f37005a, this.k, this.l, this.m, null) : (c) invokeV.objValue;
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
        this.f36996a = i2;
        this.f36997b = str2;
        this.f36998c = str3;
        this.f36999d = str4;
        this.f37000e = str5;
        this.f37001f = str6;
        this.f37002g = str7;
        this.f37003h = str;
        this.f37004i = z;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36996a : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f36997b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36999d : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37000e : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37001f : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f37002g : (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.booleanValue;
    }
}

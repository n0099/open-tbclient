package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final k f66000a;

    /* renamed from: b  reason: collision with root package name */
    public final e f66001b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f66002c;

    /* renamed from: d  reason: collision with root package name */
    public int f66003d;

    /* renamed from: e  reason: collision with root package name */
    public int f66004e;

    /* renamed from: f  reason: collision with root package name */
    public int f66005f;

    /* renamed from: g  reason: collision with root package name */
    public int f66006g;

    /* renamed from: h  reason: collision with root package name */
    public int f66007h;

    /* renamed from: i  reason: collision with root package name */
    public int f66008i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66000a = kVar;
        this.f66001b = eVar;
        this.f66002c = eVar != null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f66007h = i2;
            if (!this.f66002c) {
                this.n = 1;
                this.f66003d = 1;
                this.f66004e = 1;
                this.f66005f = 0;
                this.f66006g = 0;
                this.j = i2;
                this.f66008i = i2;
                k kVar = this.f66000a;
                this.k = kVar.f65978b;
                this.l = kVar.f65977a;
                this.m = kVar.k;
                return;
            }
            this.n = this.f66001b.d();
            e eVar = this.f66001b;
            this.f66004e = eVar.f65966c;
            this.f66003d = eVar.f65965b;
            this.f66006g = eVar.f65968e;
            this.f66005f = eVar.f65967d;
            this.f66008i = eVar.c();
            this.j = this.f66001b.b();
            this.k = this.f66001b.e();
            int f2 = this.f66001b.f();
            this.l = f2;
            this.m = ((this.f66000a.f65985i * f2) + 7) / 8;
        }
    }

    public void a(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2) == null) {
            this.o = bArr;
            this.p = i2;
        }
    }
}

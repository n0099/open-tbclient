package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final k f35872a;

    /* renamed from: b  reason: collision with root package name */
    public final e f35873b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f35874c;

    /* renamed from: d  reason: collision with root package name */
    public int f35875d;

    /* renamed from: e  reason: collision with root package name */
    public int f35876e;

    /* renamed from: f  reason: collision with root package name */
    public int f35877f;

    /* renamed from: g  reason: collision with root package name */
    public int f35878g;

    /* renamed from: h  reason: collision with root package name */
    public int f35879h;

    /* renamed from: i  reason: collision with root package name */
    public int f35880i;
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
        this.f35872a = kVar;
        this.f35873b = eVar;
        this.f35874c = eVar != null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f35879h = i2;
            if (!this.f35874c) {
                this.n = 1;
                this.f35875d = 1;
                this.f35876e = 1;
                this.f35877f = 0;
                this.f35878g = 0;
                this.j = i2;
                this.f35880i = i2;
                k kVar = this.f35872a;
                this.k = kVar.f35850b;
                this.l = kVar.f35849a;
                this.m = kVar.k;
                return;
            }
            this.n = this.f35873b.d();
            e eVar = this.f35873b;
            this.f35876e = eVar.f35838c;
            this.f35875d = eVar.f35837b;
            this.f35878g = eVar.f35840e;
            this.f35877f = eVar.f35839d;
            this.f35880i = eVar.c();
            this.j = this.f35873b.b();
            this.k = this.f35873b.e();
            int f2 = this.f35873b.f();
            this.l = f2;
            this.m = ((this.f35872a.f35857i * f2) + 7) / 8;
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

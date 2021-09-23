package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final k f73555a;

    /* renamed from: b  reason: collision with root package name */
    public final e f73556b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f73557c;

    /* renamed from: d  reason: collision with root package name */
    public int f73558d;

    /* renamed from: e  reason: collision with root package name */
    public int f73559e;

    /* renamed from: f  reason: collision with root package name */
    public int f73560f;

    /* renamed from: g  reason: collision with root package name */
    public int f73561g;

    /* renamed from: h  reason: collision with root package name */
    public int f73562h;

    /* renamed from: i  reason: collision with root package name */
    public int f73563i;

    /* renamed from: j  reason: collision with root package name */
    public int f73564j;
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
        this.f73555a = kVar;
        this.f73556b = eVar;
        this.f73557c = eVar != null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f73562h = i2;
            if (!this.f73557c) {
                this.n = 1;
                this.f73558d = 1;
                this.f73559e = 1;
                this.f73560f = 0;
                this.f73561g = 0;
                this.f73564j = i2;
                this.f73563i = i2;
                k kVar = this.f73555a;
                this.k = kVar.f73532b;
                this.l = kVar.f73531a;
                this.m = kVar.k;
                return;
            }
            this.n = this.f73556b.d();
            e eVar = this.f73556b;
            this.f73559e = eVar.f73518c;
            this.f73558d = eVar.f73517b;
            this.f73561g = eVar.f73520e;
            this.f73560f = eVar.f73519d;
            this.f73563i = eVar.c();
            this.f73564j = this.f73556b.b();
            this.k = this.f73556b.e();
            int f2 = this.f73556b.f();
            this.l = f2;
            this.m = ((this.f73555a.f73539i * f2) + 7) / 8;
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

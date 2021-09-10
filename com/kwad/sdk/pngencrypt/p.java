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
    public final k f73236a;

    /* renamed from: b  reason: collision with root package name */
    public final e f73237b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f73238c;

    /* renamed from: d  reason: collision with root package name */
    public int f73239d;

    /* renamed from: e  reason: collision with root package name */
    public int f73240e;

    /* renamed from: f  reason: collision with root package name */
    public int f73241f;

    /* renamed from: g  reason: collision with root package name */
    public int f73242g;

    /* renamed from: h  reason: collision with root package name */
    public int f73243h;

    /* renamed from: i  reason: collision with root package name */
    public int f73244i;

    /* renamed from: j  reason: collision with root package name */
    public int f73245j;
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
        this.f73236a = kVar;
        this.f73237b = eVar;
        this.f73238c = eVar != null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f73243h = i2;
            if (!this.f73238c) {
                this.n = 1;
                this.f73239d = 1;
                this.f73240e = 1;
                this.f73241f = 0;
                this.f73242g = 0;
                this.f73245j = i2;
                this.f73244i = i2;
                k kVar = this.f73236a;
                this.k = kVar.f73213b;
                this.l = kVar.f73212a;
                this.m = kVar.k;
                return;
            }
            this.n = this.f73237b.d();
            e eVar = this.f73237b;
            this.f73240e = eVar.f73199c;
            this.f73239d = eVar.f73198b;
            this.f73242g = eVar.f73201e;
            this.f73241f = eVar.f73200d;
            this.f73244i = eVar.c();
            this.f73245j = this.f73237b.b();
            this.k = this.f73237b.e();
            int f2 = this.f73237b.f();
            this.l = f2;
            this.m = ((this.f73236a.f73220i * f2) + 7) / 8;
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

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
    public final k f72856a;

    /* renamed from: b  reason: collision with root package name */
    public final e f72857b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f72858c;

    /* renamed from: d  reason: collision with root package name */
    public int f72859d;

    /* renamed from: e  reason: collision with root package name */
    public int f72860e;

    /* renamed from: f  reason: collision with root package name */
    public int f72861f;

    /* renamed from: g  reason: collision with root package name */
    public int f72862g;

    /* renamed from: h  reason: collision with root package name */
    public int f72863h;

    /* renamed from: i  reason: collision with root package name */
    public int f72864i;

    /* renamed from: j  reason: collision with root package name */
    public int f72865j;
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
        this.f72856a = kVar;
        this.f72857b = eVar;
        this.f72858c = eVar != null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f72863h = i2;
            if (!this.f72858c) {
                this.n = 1;
                this.f72859d = 1;
                this.f72860e = 1;
                this.f72861f = 0;
                this.f72862g = 0;
                this.f72865j = i2;
                this.f72864i = i2;
                k kVar = this.f72856a;
                this.k = kVar.f72833b;
                this.l = kVar.f72832a;
                this.m = kVar.k;
                return;
            }
            this.n = this.f72857b.d();
            e eVar = this.f72857b;
            this.f72860e = eVar.f72819c;
            this.f72859d = eVar.f72818b;
            this.f72862g = eVar.f72821e;
            this.f72861f = eVar.f72820d;
            this.f72864i = eVar.c();
            this.f72865j = this.f72857b.b();
            this.k = this.f72857b.e();
            int f2 = this.f72857b.f();
            this.l = f2;
            this.m = ((this.f72856a.f72840i * f2) + 7) / 8;
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

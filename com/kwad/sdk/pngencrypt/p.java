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
    public final k f36061a;

    /* renamed from: b  reason: collision with root package name */
    public final e f36062b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36063c;

    /* renamed from: d  reason: collision with root package name */
    public int f36064d;

    /* renamed from: e  reason: collision with root package name */
    public int f36065e;

    /* renamed from: f  reason: collision with root package name */
    public int f36066f;

    /* renamed from: g  reason: collision with root package name */
    public int f36067g;

    /* renamed from: h  reason: collision with root package name */
    public int f36068h;

    /* renamed from: i  reason: collision with root package name */
    public int f36069i;
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
        this.f36061a = kVar;
        this.f36062b = eVar;
        this.f36063c = eVar != null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f36068h = i2;
            if (!this.f36063c) {
                this.n = 1;
                this.f36064d = 1;
                this.f36065e = 1;
                this.f36066f = 0;
                this.f36067g = 0;
                this.j = i2;
                this.f36069i = i2;
                k kVar = this.f36061a;
                this.k = kVar.f36039b;
                this.l = kVar.f36038a;
                this.m = kVar.k;
                return;
            }
            this.n = this.f36062b.d();
            e eVar = this.f36062b;
            this.f36065e = eVar.f36027c;
            this.f36064d = eVar.f36026b;
            this.f36067g = eVar.f36029e;
            this.f36066f = eVar.f36028d;
            this.f36069i = eVar.c();
            this.j = this.f36062b.b();
            this.k = this.f36062b.e();
            int f2 = this.f36062b.f();
            this.l = f2;
            this.m = ((this.f36061a.f36046i * f2) + 7) / 8;
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

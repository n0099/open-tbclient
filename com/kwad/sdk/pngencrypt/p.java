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
    public final k f65999a;

    /* renamed from: b  reason: collision with root package name */
    public final e f66000b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f66001c;

    /* renamed from: d  reason: collision with root package name */
    public int f66002d;

    /* renamed from: e  reason: collision with root package name */
    public int f66003e;

    /* renamed from: f  reason: collision with root package name */
    public int f66004f;

    /* renamed from: g  reason: collision with root package name */
    public int f66005g;

    /* renamed from: h  reason: collision with root package name */
    public int f66006h;

    /* renamed from: i  reason: collision with root package name */
    public int f66007i;
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
        this.f65999a = kVar;
        this.f66000b = eVar;
        this.f66001c = eVar != null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f66006h = i2;
            if (!this.f66001c) {
                this.n = 1;
                this.f66002d = 1;
                this.f66003e = 1;
                this.f66004f = 0;
                this.f66005g = 0;
                this.j = i2;
                this.f66007i = i2;
                k kVar = this.f65999a;
                this.k = kVar.f65977b;
                this.l = kVar.f65976a;
                this.m = kVar.k;
                return;
            }
            this.n = this.f66000b.d();
            e eVar = this.f66000b;
            this.f66003e = eVar.f65965c;
            this.f66002d = eVar.f65964b;
            this.f66005g = eVar.f65967e;
            this.f66004f = eVar.f65966d;
            this.f66007i = eVar.c();
            this.j = this.f66000b.b();
            this.k = this.f66000b.e();
            int f2 = this.f66000b.f();
            this.l = f2;
            this.m = ((this.f65999a.f65984i * f2) + 7) / 8;
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

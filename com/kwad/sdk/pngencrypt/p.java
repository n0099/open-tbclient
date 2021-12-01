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
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final e f58814b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f58815c;

    /* renamed from: d  reason: collision with root package name */
    public int f58816d;

    /* renamed from: e  reason: collision with root package name */
    public int f58817e;

    /* renamed from: f  reason: collision with root package name */
    public int f58818f;

    /* renamed from: g  reason: collision with root package name */
    public int f58819g;

    /* renamed from: h  reason: collision with root package name */
    public int f58820h;

    /* renamed from: i  reason: collision with root package name */
    public int f58821i;

    /* renamed from: j  reason: collision with root package name */
    public int f58822j;

    /* renamed from: k  reason: collision with root package name */
    public int f58823k;
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
        this.a = kVar;
        this.f58814b = eVar;
        this.f58815c = eVar != null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f58820h = i2;
            if (!this.f58815c) {
                this.n = 1;
                this.f58816d = 1;
                this.f58817e = 1;
                this.f58818f = 0;
                this.f58819g = 0;
                this.f58822j = i2;
                this.f58821i = i2;
                k kVar = this.a;
                this.f58823k = kVar.f58794b;
                this.l = kVar.a;
                this.m = kVar.f58803k;
                return;
            }
            this.n = this.f58814b.d();
            e eVar = this.f58814b;
            this.f58817e = eVar.f58780c;
            this.f58816d = eVar.f58779b;
            this.f58819g = eVar.f58782e;
            this.f58818f = eVar.f58781d;
            this.f58821i = eVar.c();
            this.f58822j = this.f58814b.b();
            this.f58823k = this.f58814b.e();
            int f2 = this.f58814b.f();
            this.l = f2;
            this.m = ((this.a.f58801i * f2) + 7) / 8;
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

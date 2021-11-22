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
    public final k f66912a;

    /* renamed from: b  reason: collision with root package name */
    public final e f66913b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f66914c;

    /* renamed from: d  reason: collision with root package name */
    public int f66915d;

    /* renamed from: e  reason: collision with root package name */
    public int f66916e;

    /* renamed from: f  reason: collision with root package name */
    public int f66917f;

    /* renamed from: g  reason: collision with root package name */
    public int f66918g;

    /* renamed from: h  reason: collision with root package name */
    public int f66919h;

    /* renamed from: i  reason: collision with root package name */
    public int f66920i;
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
        this.f66912a = kVar;
        this.f66913b = eVar;
        this.f66914c = eVar != null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f66919h = i2;
            if (!this.f66914c) {
                this.n = 1;
                this.f66915d = 1;
                this.f66916e = 1;
                this.f66917f = 0;
                this.f66918g = 0;
                this.j = i2;
                this.f66920i = i2;
                k kVar = this.f66912a;
                this.k = kVar.f66890b;
                this.l = kVar.f66889a;
                this.m = kVar.k;
                return;
            }
            this.n = this.f66913b.d();
            e eVar = this.f66913b;
            this.f66916e = eVar.f66878c;
            this.f66915d = eVar.f66877b;
            this.f66918g = eVar.f66880e;
            this.f66917f = eVar.f66879d;
            this.f66920i = eVar.c();
            this.j = this.f66913b.b();
            this.k = this.f66913b.e();
            int f2 = this.f66913b.f();
            this.l = f2;
            this.m = ((this.f66912a.f66897i * f2) + 7) / 8;
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

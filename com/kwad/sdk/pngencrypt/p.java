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
    public final k f73056a;

    /* renamed from: b  reason: collision with root package name */
    public final e f73057b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f73058c;

    /* renamed from: d  reason: collision with root package name */
    public int f73059d;

    /* renamed from: e  reason: collision with root package name */
    public int f73060e;

    /* renamed from: f  reason: collision with root package name */
    public int f73061f;

    /* renamed from: g  reason: collision with root package name */
    public int f73062g;

    /* renamed from: h  reason: collision with root package name */
    public int f73063h;

    /* renamed from: i  reason: collision with root package name */
    public int f73064i;

    /* renamed from: j  reason: collision with root package name */
    public int f73065j;
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
        this.f73056a = kVar;
        this.f73057b = eVar;
        this.f73058c = eVar != null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f73063h = i2;
            if (!this.f73058c) {
                this.n = 1;
                this.f73059d = 1;
                this.f73060e = 1;
                this.f73061f = 0;
                this.f73062g = 0;
                this.f73065j = i2;
                this.f73064i = i2;
                k kVar = this.f73056a;
                this.k = kVar.f73033b;
                this.l = kVar.f73032a;
                this.m = kVar.k;
                return;
            }
            this.n = this.f73057b.d();
            e eVar = this.f73057b;
            this.f73060e = eVar.f73019c;
            this.f73059d = eVar.f73018b;
            this.f73062g = eVar.f73021e;
            this.f73061f = eVar.f73020d;
            this.f73064i = eVar.c();
            this.f73065j = this.f73057b.b();
            this.k = this.f73057b.e();
            int f2 = this.f73057b.f();
            this.l = f2;
            this.m = ((this.f73056a.f73040i * f2) + 7) / 8;
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

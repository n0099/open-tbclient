package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final k f38800a;

    /* renamed from: b  reason: collision with root package name */
    public final e f38801b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f38802c;

    /* renamed from: d  reason: collision with root package name */
    public int f38803d;

    /* renamed from: e  reason: collision with root package name */
    public int f38804e;

    /* renamed from: f  reason: collision with root package name */
    public int f38805f;

    /* renamed from: g  reason: collision with root package name */
    public int f38806g;

    /* renamed from: h  reason: collision with root package name */
    public int f38807h;

    /* renamed from: i  reason: collision with root package name */
    public int f38808i;
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
        this.f38800a = kVar;
        this.f38801b = eVar;
        this.f38802c = eVar != null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f38807h = i2;
            if (!this.f38802c) {
                this.n = 1;
                this.f38803d = 1;
                this.f38804e = 1;
                this.f38805f = 0;
                this.f38806g = 0;
                this.j = i2;
                this.f38808i = i2;
                k kVar = this.f38800a;
                this.k = kVar.f38778b;
                this.l = kVar.f38777a;
                this.m = kVar.k;
                return;
            }
            this.n = this.f38801b.d();
            e eVar = this.f38801b;
            this.f38804e = eVar.f38766c;
            this.f38803d = eVar.f38765b;
            this.f38806g = eVar.f38768e;
            this.f38805f = eVar.f38767d;
            this.f38808i = eVar.c();
            this.j = this.f38801b.b();
            this.k = this.f38801b.e();
            int f2 = this.f38801b.f();
            this.l = f2;
            this.m = ((this.f38800a.f38785i * f2) + 7) / 8;
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
